package rockset_test

import (
	"context"
	"fmt"
	"github.com/rockset/rockset-go-client/internal/test"
	"math/rand"
	"os"
	"strings"
	"testing"
	"time"

	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
	"github.com/rs/zerolog"
	"github.com/seborama/govcr/v14"
	"github.com/seborama/govcr/v14/cassette/track"
	"github.com/seborama/govcr/v14/fileio"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/rockset/rockset-go-client"
)

// testRetrier is used with VCR to retry as fast as possible, as the responses are recorded
type testRetrier struct{}

func (t testRetrier) Retry(ctx context.Context, retryFn rockset.RetryFunc) error {
	for {
		err := retryFn()
		if err == nil {
			return nil
		}
		if !rockset.DefaultRetryableErrorCheck(err) {
			return err
		}
	}
}

func (t testRetrier) RetryWithCheck(ctx context.Context, checkFunc rockset.RetryCheck) error {
	for {
		retry, err := checkFunc()
		if err == nil {
			return nil
		}
		if !retry {
			return nil
		}
		if !rockset.DefaultRetryableErrorCheck(err) {
			return err
		}
	}
}

func vcrTestClient(t *testing.T, name string) (*rockset.RockClient, func(string) string) {
	rc, fn, err := vcrClient(name)
	if err != nil {
		require.NoError(t, err)
	}

	return rc, fn
}

const vcrBucket = "rockset-go-tests"

func vcrBucketPath(name string) string {
	return fmt.Sprintf("/%s/vcr/%s/%s.cassette.gz", vcrBucket, rockset.Version, name)
}

func vcrClient(name string) (*rockset.RockClient, func(string) string, error) {
	return vcrClientWrapper(strings.ToLower(os.Getenv("VCR_MODE")), name)
}

func vcrClientWrapper(mode, name string) (*rockset.RockClient, func(string) string, error) {
	randFn := randomName
	options := []rockset.RockOption{
		rockset.WithUserAgent("rockset-go-integration-tests"),
		rockset.WithCustomHeader("x-rockset-test", "go-client"),
	}
	var settings []govcr.Setting
	path := vcrBucketPath(name)

	// VCR cassettes are in S3 bucket rockset-go-tests (in us-west-2)
	cfg, err := config.LoadDefaultConfig(context.Background(), config.WithRegion("us-west-2"))
	if err != nil {
		return nil, nil, err
	}
	s3Client := s3.NewFromConfig(cfg, func(o *s3.Options) { o.UsePathStyle = true })

	switch mode {
	case "record":
		// remove cassette to force a new one to be created
		//res, err := s3Client.DeleteObject(context.Background(), &s3.DeleteObjectInput{
		//	Bucket: aws.String(""),
		//	Key:    "",
		//})
		randFn = func(pfx string) string {
			return fmt.Sprintf("go_%s", pfx)
		}
		settings = vcrSettings(false)
	case "offline", "": // quick run using a recorded response
		randFn = func(pfx string) string {
			return fmt.Sprintf("go_%s", pfx)
		}
		settings = vcrSettings(true)
		options = append(options, rockset.WithAPIKey("fake"),
			rockset.WithAPIServer("fake"), rockset.WithRetry(&testRetrier{}))
	case "online": // for running everything live
		settings = append(vcrSettings(false), govcr.WithLiveOnlyMode(), govcr.WithReadOnlyMode())
	case "disabled":
		rc, err := rockset.NewClient(options...)
		return rc, randFn, err
	default:
		return nil, nil, fmt.Errorf("unknown VCR_MODE: %s", mode)
	}

	vcr := govcr.NewVCR(govcr.NewCassetteLoader(path).WithStore(fileio.NewAWS(s3Client)), settings...)
	options = append(options, rockset.WithHTTPClient(vcr.HTTPClient()),
		rockset.WithCustomHeader("x-rockset-test", "go-client"))

	rc, err := rockset.NewClient(options...)
	return rc, randFn, err
}

// stripPatchVersion removes the patch version from a SemVer string
func stripPatchVersion(v string) string {
	fields := strings.Split(v, ".")
	if len(fields) != 3 {
		panic("malformed version string: " + v)
	}

	return strings.Join(fields[:2], ".")
}

// VCR settings that exclude the HTTP header Authorization and ignores the patch version
func vcrSettings(offline bool) []govcr.Setting {
	const authHeader = "Authorization"
	settings := []govcr.Setting{
		govcr.WithRequestMatchers(
			func(httpRequest, trackRequest *track.Request) bool {
				httpRequest.Header.Del(authHeader)
				trackRequest.Header.Del(authHeader)

				v := httpRequest.Header.Get(rockset.HeaderVersionName)
				v = stripPatchVersion(v)
				httpRequest.Header.Set(rockset.HeaderVersionName, v)

				v = trackRequest.Header.Get(rockset.HeaderVersionName)
				v = stripPatchVersion(v)
				trackRequest.Header.Set(rockset.HeaderVersionName, v)

				return govcr.DefaultHeaderMatcher(httpRequest, trackRequest)
			},
		),
		govcr.WithTrackRecordingMutators(track.TrackRequestDeleteHeaderKeys(authHeader)),
		govcr.WithTrackRecordingMutators(track.ResponseDeleteTLS()),
		govcr.WithTrackReplayingMutators(track.TrackRequestDeleteHeaderKeys(authHeader)),
		govcr.WithTrackReplayingMutators(track.ResponseDeleteTLS()),
	}
	if offline {
		settings = append(settings, govcr.WithOfflineMode())
	}

	return settings
}

func debugClient(t *testing.T) *rockset.RockClient {
	rc, err := rockset.NewClient(rockset.WithUserAgent("rockset-go-integration-tests"), rockset.WithHTTPDebug())
	require.NoError(t, err)
	return rc
}

// these are used for testing when a persistent value is needed
const buildNum = "CIRCLE_BUILD_NUM"
const persistentWorkspace = "persistent"
const persistentCollection = "snp"
const persistentAlias = "getalias"

func description() string {
	num, found := os.LookupEnv(buildNum)
	if !found {
		num = "dev"
	}
	return fmt.Sprintf("created by terraform integration test run %s", num)
}

const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

var seededRand = rand.New(rand.NewSource(time.Now().UnixNano()))

// StringWithCharset creates a random string with length and charset
func stringWithCharset(length int, charset string) string {
	b := make([]byte, length)
	for i := range b {
		b[i] = charset[seededRand.Intn(len(charset))]
	}
	return string(b)
}

// String creates a random string with length
func randomString(length int) string {
	return stringWithCharset(length, charset)
}

func randomName(prefix string) string {
	num, found := os.LookupEnv(buildNum)
	if !found {
		if user, found := os.LookupEnv("USER"); found {
			num = strings.ToLower(user)
		} else {
			num = "dev"
		}
	}

	return fmt.Sprintf("go_%s_%s_%s", num, prefix, randomString(6))
}

// TestTemplate is used as a copypasta for new tests
func TestTemplate(t *testing.T) {
	rc, _ := vcrTestClient(t, t.Name())
	ctx := test.Context()
	log := zerolog.Ctx(ctx)

	org, err := rc.GetOrganization(ctx)
	require.NoError(t, err)

	log.Debug().Str("org", org.GetDisplayName())
}

func TestRockClient_withAPIKey(t *testing.T) {
	test.SkipUnlessIntegrationTest(t)

	ctx := test.Context()
	log := zerolog.Ctx(ctx)

	key := os.Getenv(rockset.APIKeyEnvironmentVariableName)
	err := os.Unsetenv(rockset.APIKeyEnvironmentVariableName)
	require.NoError(t, err)

	defer func() {
		if err = os.Setenv(rockset.APIKeyEnvironmentVariableName, key); err != nil {
			panic("failed to reset environment")
		}
	}()

	rc, err := rockset.NewClient(rockset.WithAPIKey(key))
	require.NoError(t, err)

	org, err := rc.GetOrganization(ctx)
	require.NoError(t, err)

	log.Debug().Str("org", org.GetDisplayName())
}

func TestRockClient_withoutAPIServer(t *testing.T) {
	// this is messing with the environment
	oldEnv, set := os.LookupEnv(rockset.APIServerEnvironmentVariableName)
	if set {
		defer func() {
			if err := os.Setenv(rockset.APIServerEnvironmentVariableName, oldEnv); err != nil {
				t.Errorf("failed to reset environment variable %s: %v", rockset.APIServerEnvironmentVariableName, err)
			}
		}()
		err := os.Unsetenv(rockset.APIServerEnvironmentVariableName)
		require.NoError(t, err)
	}

	_, err := rockset.NewClient()
	if assert.Error(t, err) {
		assert.Equal(t, "you must specify an API server", err.Error())
	}
}

const USW2A1 = "api.usw2a1.rockset.com"

func TestRockClient_withAPIServer(t *testing.T) {
	test.SkipUnlessIntegrationTest(t)
	// TODO this should use VCR too

	ctx := test.Context()
	log := zerolog.Ctx(ctx)

	// this is messing with the environment
	oldEnv := os.Getenv(rockset.APIServerEnvironmentVariableName)
	defer func() {
		if err := os.Setenv(rockset.APIServerEnvironmentVariableName, oldEnv); err != nil {
			t.Errorf("failed to reset environment variable %s: %v", rockset.APIServerEnvironmentVariableName, err)
		}
	}()
	err := os.Unsetenv(rockset.APIServerEnvironmentVariableName)
	require.NoError(t, err)

	rc, err := rockset.NewClient(rockset.WithAPIServer(fmt.Sprintf("https://%s/", USW2A1)))
	require.NoError(t, err)

	org, err := rc.GetOrganization(ctx)
	require.NoError(t, err)

	log.Debug().Str("org", org.GetDisplayName())
}

func TestRockClient_withAPIServerEnv(t *testing.T) {
	rc, _ := vcrTestClient(t, t.Name())

	ctx := test.Context()
	log := zerolog.Ctx(ctx)

	// this is messing with the environment
	oldEnv := os.Getenv(rockset.APIServerEnvironmentVariableName)
	defer func() {
		if err := os.Setenv(rockset.APIServerEnvironmentVariableName, oldEnv); err != nil {
			t.Logf("failed to reset environment variable %s: %v", rockset.APIServerEnvironmentVariableName, err)
		}
	}()
	err := os.Setenv(rockset.APIServerEnvironmentVariableName, USW2A1)
	require.NoError(t, err)

	org, err := rc.GetOrganization(ctx)
	require.NoError(t, err)

	log.Debug().Str("org", org.GetDisplayName())
}

func TestRockClient_Ping(t *testing.T) {
	rc, _ := vcrTestClient(t, t.Name())
	ctx := test.Context()

	err := rc.Ping(ctx)
	require.NoError(t, err)
}

func TestValidCollectionName(t *testing.T) {
	tests := []struct {
		name   string
		errStr string
	}{
		{"_123", "invalid name, must match `^[[:alnum:]][[:alnum:]-_]*$`"},
		{"abc", ""},
		{
			"a1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
			"name must be less than 100 characters",
		},
	}

	for _, tst := range tests {
		t.Run(tst.name, func(t *testing.T) {
			err := rockset.ValidEntityName(tst.name)
			if tst.errStr == "" {
				assert.NoError(t, err)
			} else {
				assert.Error(t, err)
				assert.Equal(t, tst.errStr, err.Error())
			}
		})
	}
}
