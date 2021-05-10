/*
 * REST API
 *
 * Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!
 *
 * API version: v1
 */

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
)

// SourceS3 struct for SourceS3
type SourceS3 struct {
	// AWS credential with ListObjects and GetObject access
	AccessKey *string `json:"access_key,omitempty"`
	// AWS credential with ListObjects and GetObject access
	SecretAccess *string `json:"secret_access,omitempty"`
	// Prefix that selects keys to ingest.
	Prefix *string `json:"prefix,omitempty"`
	// Pattern that selects keys to ingest.
	Pattern *string `json:"pattern,omitempty"`
	// AWS region containing source bucket
	Region *string `json:"region,omitempty"`
	// address of S3 bucket containing data
	Bucket string `json:"bucket"`
	// list of prefixes to paths from which data should be ingested
	Prefixes []string `json:"prefixes"`
	// do not use
	Format *string `json:"format,omitempty"`
	// custom transformation on data field
	Mappings *[]FieldMask `json:"mappings,omitempty"`
}

// NewSourceS3 instantiates a new SourceS3 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewSourceS3(bucket string, prefixes []string) *SourceS3 {
	this := SourceS3{}
	this.Bucket = bucket
	this.Prefixes = prefixes
	return &this
}

// NewSourceS3WithDefaults instantiates a new SourceS3 object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewSourceS3WithDefaults() *SourceS3 {
	this := SourceS3{}
	return &this
}

// GetAccessKey returns the AccessKey field value if set, zero value otherwise.
func (o *SourceS3) GetAccessKey() string {
	if o == nil || o.AccessKey == nil {
		var ret string
		return ret
	}
	return *o.AccessKey
}

// GetAccessKeyOk returns a tuple with the AccessKey field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetAccessKeyOk() (*string, bool) {
	if o == nil || o.AccessKey == nil {
		return nil, false
	}
	return o.AccessKey, true
}

// HasAccessKey returns a boolean if a field has been set.
func (o *SourceS3) HasAccessKey() bool {
	if o != nil && o.AccessKey != nil {
		return true
	}

	return false
}

// SetAccessKey gets a reference to the given string and assigns it to the AccessKey field.
func (o *SourceS3) SetAccessKey(v string) {
	o.AccessKey = &v
}

// GetSecretAccess returns the SecretAccess field value if set, zero value otherwise.
func (o *SourceS3) GetSecretAccess() string {
	if o == nil || o.SecretAccess == nil {
		var ret string
		return ret
	}
	return *o.SecretAccess
}

// GetSecretAccessOk returns a tuple with the SecretAccess field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetSecretAccessOk() (*string, bool) {
	if o == nil || o.SecretAccess == nil {
		return nil, false
	}
	return o.SecretAccess, true
}

// HasSecretAccess returns a boolean if a field has been set.
func (o *SourceS3) HasSecretAccess() bool {
	if o != nil && o.SecretAccess != nil {
		return true
	}

	return false
}

// SetSecretAccess gets a reference to the given string and assigns it to the SecretAccess field.
func (o *SourceS3) SetSecretAccess(v string) {
	o.SecretAccess = &v
}

// GetPrefix returns the Prefix field value if set, zero value otherwise.
func (o *SourceS3) GetPrefix() string {
	if o == nil || o.Prefix == nil {
		var ret string
		return ret
	}
	return *o.Prefix
}

// GetPrefixOk returns a tuple with the Prefix field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetPrefixOk() (*string, bool) {
	if o == nil || o.Prefix == nil {
		return nil, false
	}
	return o.Prefix, true
}

// HasPrefix returns a boolean if a field has been set.
func (o *SourceS3) HasPrefix() bool {
	if o != nil && o.Prefix != nil {
		return true
	}

	return false
}

// SetPrefix gets a reference to the given string and assigns it to the Prefix field.
func (o *SourceS3) SetPrefix(v string) {
	o.Prefix = &v
}

// GetPattern returns the Pattern field value if set, zero value otherwise.
func (o *SourceS3) GetPattern() string {
	if o == nil || o.Pattern == nil {
		var ret string
		return ret
	}
	return *o.Pattern
}

// GetPatternOk returns a tuple with the Pattern field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetPatternOk() (*string, bool) {
	if o == nil || o.Pattern == nil {
		return nil, false
	}
	return o.Pattern, true
}

// HasPattern returns a boolean if a field has been set.
func (o *SourceS3) HasPattern() bool {
	if o != nil && o.Pattern != nil {
		return true
	}

	return false
}

// SetPattern gets a reference to the given string and assigns it to the Pattern field.
func (o *SourceS3) SetPattern(v string) {
	o.Pattern = &v
}

// GetRegion returns the Region field value if set, zero value otherwise.
func (o *SourceS3) GetRegion() string {
	if o == nil || o.Region == nil {
		var ret string
		return ret
	}
	return *o.Region
}

// GetRegionOk returns a tuple with the Region field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetRegionOk() (*string, bool) {
	if o == nil || o.Region == nil {
		return nil, false
	}
	return o.Region, true
}

// HasRegion returns a boolean if a field has been set.
func (o *SourceS3) HasRegion() bool {
	if o != nil && o.Region != nil {
		return true
	}

	return false
}

// SetRegion gets a reference to the given string and assigns it to the Region field.
func (o *SourceS3) SetRegion(v string) {
	o.Region = &v
}

// GetBucket returns the Bucket field value
func (o *SourceS3) GetBucket() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Bucket
}

// GetBucketOk returns a tuple with the Bucket field value
// and a boolean to check if the value has been set.
func (o *SourceS3) GetBucketOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Bucket, true
}

// SetBucket sets field value
func (o *SourceS3) SetBucket(v string) {
	o.Bucket = v
}

// GetPrefixes returns the Prefixes field value
func (o *SourceS3) GetPrefixes() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.Prefixes
}

// GetPrefixesOk returns a tuple with the Prefixes field value
// and a boolean to check if the value has been set.
func (o *SourceS3) GetPrefixesOk() (*[]string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Prefixes, true
}

// SetPrefixes sets field value
func (o *SourceS3) SetPrefixes(v []string) {
	o.Prefixes = v
}

// GetFormat returns the Format field value if set, zero value otherwise.
func (o *SourceS3) GetFormat() string {
	if o == nil || o.Format == nil {
		var ret string
		return ret
	}
	return *o.Format
}

// GetFormatOk returns a tuple with the Format field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetFormatOk() (*string, bool) {
	if o == nil || o.Format == nil {
		return nil, false
	}
	return o.Format, true
}

// HasFormat returns a boolean if a field has been set.
func (o *SourceS3) HasFormat() bool {
	if o != nil && o.Format != nil {
		return true
	}

	return false
}

// SetFormat gets a reference to the given string and assigns it to the Format field.
func (o *SourceS3) SetFormat(v string) {
	o.Format = &v
}

// GetMappings returns the Mappings field value if set, zero value otherwise.
func (o *SourceS3) GetMappings() []FieldMask {
	if o == nil || o.Mappings == nil {
		var ret []FieldMask
		return ret
	}
	return *o.Mappings
}

// GetMappingsOk returns a tuple with the Mappings field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetMappingsOk() (*[]FieldMask, bool) {
	if o == nil || o.Mappings == nil {
		return nil, false
	}
	return o.Mappings, true
}

// HasMappings returns a boolean if a field has been set.
func (o *SourceS3) HasMappings() bool {
	if o != nil && o.Mappings != nil {
		return true
	}

	return false
}

// SetMappings gets a reference to the given []FieldMask and assigns it to the Mappings field.
func (o *SourceS3) SetMappings(v []FieldMask) {
	o.Mappings = &v
}

func (o SourceS3) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.AccessKey != nil {
		toSerialize["access_key"] = o.AccessKey
	}
	if o.SecretAccess != nil {
		toSerialize["secret_access"] = o.SecretAccess
	}
	if o.Prefix != nil {
		toSerialize["prefix"] = o.Prefix
	}
	if o.Pattern != nil {
		toSerialize["pattern"] = o.Pattern
	}
	if o.Region != nil {
		toSerialize["region"] = o.Region
	}
	if true {
		toSerialize["bucket"] = o.Bucket
	}
	if true {
		toSerialize["prefixes"] = o.Prefixes
	}
	if o.Format != nil {
		toSerialize["format"] = o.Format
	}
	if o.Mappings != nil {
		toSerialize["mappings"] = o.Mappings
	}
	return json.Marshal(toSerialize)
}

type NullableSourceS3 struct {
	value *SourceS3
	isSet bool
}

func (v NullableSourceS3) Get() *SourceS3 {
	return v.value
}

func (v *NullableSourceS3) Set(val *SourceS3) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceS3) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceS3) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceS3(val *SourceS3) *NullableSourceS3 {
	return &NullableSourceS3{value: val, isSet: true}
}

func (v NullableSourceS3) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSourceS3) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


