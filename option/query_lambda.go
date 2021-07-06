package option

import "github.com/rockset/rockset-go-client/openapi"

type ExecuteQueryLambdaRequest struct {
	openapi.ExecuteQueryLambdaRequest
	Tag     string
	Version string
}

type QueryLambdaOption func(request *ExecuteQueryLambdaRequest)

func WithTag(tag string) QueryLambdaOption {
	return func(o *ExecuteQueryLambdaRequest) {
		o.Tag = tag
	}
}

func WithVersion(version string) QueryLambdaOption {
	return func(o *ExecuteQueryLambdaRequest) {
		o.Version = version
	}
}

func WithRowLimit2(limit int32) QueryLambdaOption {
	return func(o *ExecuteQueryLambdaRequest) {
		o.DefaultRowLimit = &limit
	}
}

func WithWarnings2() QueryLambdaOption {
	return func(o *ExecuteQueryLambdaRequest) {
		o.GenerateWarnings = openapi.PtrBool(true)
	}
}

func WithParameter2(name, valueType, value string) QueryLambdaOption {
	return func(o *ExecuteQueryLambdaRequest) {
		*o.Parameters = append(*o.Parameters, openapi.QueryParameter{
			Name:  name,
			Type:  valueType,
			Value: value,
		})
	}
}

type ListQueryLambdaOptions struct {
	Workspace *string
}

type ListQueryLambdaOption func(request *ListQueryLambdaOptions)

func WithQueryLambdaWorkspace(name string) ListQueryLambdaOption {
	return func(o *ListQueryLambdaOptions) {

	}
}

type ListQueryLambdaTagsOptions struct {
	Workspace   *string
	QueryLambda *string
}

type ListQueryLambdaTagsOption func(request *ListQueryLambdaTagsOptions)

func WithQueryLambda(workspace, name string) ListQueryLambdaTagsOption {
	return func(o *ListQueryLambdaTagsOptions) {
		o.Workspace = &workspace
		o.QueryLambda = &name
	}
}
