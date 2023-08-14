/*
REST API

Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
)

// SourceS3 struct for SourceS3
type SourceS3 struct {
	// Address of S3 bucket containing data.
	Bucket string `json:"bucket"`
	ObjectBytesDownloaded *int64 `json:"object_bytes_downloaded,omitempty"`
	ObjectBytesTotal *int64 `json:"object_bytes_total,omitempty"`
	ObjectCountDownloaded *int64 `json:"object_count_downloaded,omitempty"`
	ObjectCountTotal *int64 `json:"object_count_total,omitempty"`
	// Glob-style pattern that selects keys to ingest. Only either prefix or pattern can be specified.
	Pattern *string `json:"pattern,omitempty"`
	// Prefix that selects keys to ingest.
	Prefix *string `json:"prefix,omitempty"`
	// List of prefixes to paths from which data should be ingested.
	Prefixes []string `json:"prefixes,omitempty"`
	// AWS region containing source bucket.
	Region *string `json:"region,omitempty"`
}

// NewSourceS3 instantiates a new SourceS3 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewSourceS3(bucket string) *SourceS3 {
	this := SourceS3{}
	this.Bucket = bucket
	return &this
}

// NewSourceS3WithDefaults instantiates a new SourceS3 object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewSourceS3WithDefaults() *SourceS3 {
	this := SourceS3{}
	return &this
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

// GetObjectBytesDownloaded returns the ObjectBytesDownloaded field value if set, zero value otherwise.
func (o *SourceS3) GetObjectBytesDownloaded() int64 {
	if o == nil || o.ObjectBytesDownloaded == nil {
		var ret int64
		return ret
	}
	return *o.ObjectBytesDownloaded
}

// GetObjectBytesDownloadedOk returns a tuple with the ObjectBytesDownloaded field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetObjectBytesDownloadedOk() (*int64, bool) {
	if o == nil || o.ObjectBytesDownloaded == nil {
		return nil, false
	}
	return o.ObjectBytesDownloaded, true
}

// HasObjectBytesDownloaded returns a boolean if a field has been set.
func (o *SourceS3) HasObjectBytesDownloaded() bool {
	if o != nil && o.ObjectBytesDownloaded != nil {
		return true
	}

	return false
}

// SetObjectBytesDownloaded gets a reference to the given int64 and assigns it to the ObjectBytesDownloaded field.
func (o *SourceS3) SetObjectBytesDownloaded(v int64) {
	o.ObjectBytesDownloaded = &v
}

// GetObjectBytesTotal returns the ObjectBytesTotal field value if set, zero value otherwise.
func (o *SourceS3) GetObjectBytesTotal() int64 {
	if o == nil || o.ObjectBytesTotal == nil {
		var ret int64
		return ret
	}
	return *o.ObjectBytesTotal
}

// GetObjectBytesTotalOk returns a tuple with the ObjectBytesTotal field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetObjectBytesTotalOk() (*int64, bool) {
	if o == nil || o.ObjectBytesTotal == nil {
		return nil, false
	}
	return o.ObjectBytesTotal, true
}

// HasObjectBytesTotal returns a boolean if a field has been set.
func (o *SourceS3) HasObjectBytesTotal() bool {
	if o != nil && o.ObjectBytesTotal != nil {
		return true
	}

	return false
}

// SetObjectBytesTotal gets a reference to the given int64 and assigns it to the ObjectBytesTotal field.
func (o *SourceS3) SetObjectBytesTotal(v int64) {
	o.ObjectBytesTotal = &v
}

// GetObjectCountDownloaded returns the ObjectCountDownloaded field value if set, zero value otherwise.
func (o *SourceS3) GetObjectCountDownloaded() int64 {
	if o == nil || o.ObjectCountDownloaded == nil {
		var ret int64
		return ret
	}
	return *o.ObjectCountDownloaded
}

// GetObjectCountDownloadedOk returns a tuple with the ObjectCountDownloaded field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetObjectCountDownloadedOk() (*int64, bool) {
	if o == nil || o.ObjectCountDownloaded == nil {
		return nil, false
	}
	return o.ObjectCountDownloaded, true
}

// HasObjectCountDownloaded returns a boolean if a field has been set.
func (o *SourceS3) HasObjectCountDownloaded() bool {
	if o != nil && o.ObjectCountDownloaded != nil {
		return true
	}

	return false
}

// SetObjectCountDownloaded gets a reference to the given int64 and assigns it to the ObjectCountDownloaded field.
func (o *SourceS3) SetObjectCountDownloaded(v int64) {
	o.ObjectCountDownloaded = &v
}

// GetObjectCountTotal returns the ObjectCountTotal field value if set, zero value otherwise.
func (o *SourceS3) GetObjectCountTotal() int64 {
	if o == nil || o.ObjectCountTotal == nil {
		var ret int64
		return ret
	}
	return *o.ObjectCountTotal
}

// GetObjectCountTotalOk returns a tuple with the ObjectCountTotal field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetObjectCountTotalOk() (*int64, bool) {
	if o == nil || o.ObjectCountTotal == nil {
		return nil, false
	}
	return o.ObjectCountTotal, true
}

// HasObjectCountTotal returns a boolean if a field has been set.
func (o *SourceS3) HasObjectCountTotal() bool {
	if o != nil && o.ObjectCountTotal != nil {
		return true
	}

	return false
}

// SetObjectCountTotal gets a reference to the given int64 and assigns it to the ObjectCountTotal field.
func (o *SourceS3) SetObjectCountTotal(v int64) {
	o.ObjectCountTotal = &v
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

// GetPrefixes returns the Prefixes field value if set, zero value otherwise.
func (o *SourceS3) GetPrefixes() []string {
	if o == nil || o.Prefixes == nil {
		var ret []string
		return ret
	}
	return o.Prefixes
}

// GetPrefixesOk returns a tuple with the Prefixes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceS3) GetPrefixesOk() ([]string, bool) {
	if o == nil || o.Prefixes == nil {
		return nil, false
	}
	return o.Prefixes, true
}

// HasPrefixes returns a boolean if a field has been set.
func (o *SourceS3) HasPrefixes() bool {
	if o != nil && o.Prefixes != nil {
		return true
	}

	return false
}

// SetPrefixes gets a reference to the given []string and assigns it to the Prefixes field.
func (o *SourceS3) SetPrefixes(v []string) {
	o.Prefixes = v
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

func (o SourceS3) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["bucket"] = o.Bucket
	}
	if o.ObjectBytesDownloaded != nil {
		toSerialize["object_bytes_downloaded"] = o.ObjectBytesDownloaded
	}
	if o.ObjectBytesTotal != nil {
		toSerialize["object_bytes_total"] = o.ObjectBytesTotal
	}
	if o.ObjectCountDownloaded != nil {
		toSerialize["object_count_downloaded"] = o.ObjectCountDownloaded
	}
	if o.ObjectCountTotal != nil {
		toSerialize["object_count_total"] = o.ObjectCountTotal
	}
	if o.Pattern != nil {
		toSerialize["pattern"] = o.Pattern
	}
	if o.Prefix != nil {
		toSerialize["prefix"] = o.Prefix
	}
	if o.Prefixes != nil {
		toSerialize["prefixes"] = o.Prefixes
	}
	if o.Region != nil {
		toSerialize["region"] = o.Region
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


