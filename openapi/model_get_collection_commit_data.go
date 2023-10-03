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

// checks if the GetCollectionCommitData type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &GetCollectionCommitData{}

// GetCollectionCommitData struct for GetCollectionCommitData
type GetCollectionCommitData struct {
	// The max offset passed in the request which is the latest offset that was compared to the commit.
	Fence *string `json:"fence,omitempty"`
	// True if all the data in the offsets are available to be queried. False if one or more of the offsets is still behind the request offsets.
	Passed *bool `json:"passed,omitempty"`
}

// NewGetCollectionCommitData instantiates a new GetCollectionCommitData object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewGetCollectionCommitData() *GetCollectionCommitData {
	this := GetCollectionCommitData{}
	return &this
}

// NewGetCollectionCommitDataWithDefaults instantiates a new GetCollectionCommitData object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewGetCollectionCommitDataWithDefaults() *GetCollectionCommitData {
	this := GetCollectionCommitData{}
	return &this
}

// GetFence returns the Fence field value if set, zero value otherwise.
func (o *GetCollectionCommitData) GetFence() string {
	if o == nil || IsNil(o.Fence) {
		var ret string
		return ret
	}
	return *o.Fence
}

// GetFenceOk returns a tuple with the Fence field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetCollectionCommitData) GetFenceOk() (*string, bool) {
	if o == nil || IsNil(o.Fence) {
		return nil, false
	}
	return o.Fence, true
}

// HasFence returns a boolean if a field has been set.
func (o *GetCollectionCommitData) HasFence() bool {
	if o != nil && !IsNil(o.Fence) {
		return true
	}

	return false
}

// SetFence gets a reference to the given string and assigns it to the Fence field.
func (o *GetCollectionCommitData) SetFence(v string) {
	o.Fence = &v
}

// GetPassed returns the Passed field value if set, zero value otherwise.
func (o *GetCollectionCommitData) GetPassed() bool {
	if o == nil || IsNil(o.Passed) {
		var ret bool
		return ret
	}
	return *o.Passed
}

// GetPassedOk returns a tuple with the Passed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetCollectionCommitData) GetPassedOk() (*bool, bool) {
	if o == nil || IsNil(o.Passed) {
		return nil, false
	}
	return o.Passed, true
}

// HasPassed returns a boolean if a field has been set.
func (o *GetCollectionCommitData) HasPassed() bool {
	if o != nil && !IsNil(o.Passed) {
		return true
	}

	return false
}

// SetPassed gets a reference to the given bool and assigns it to the Passed field.
func (o *GetCollectionCommitData) SetPassed(v bool) {
	o.Passed = &v
}

func (o GetCollectionCommitData) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o GetCollectionCommitData) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Fence) {
		toSerialize["fence"] = o.Fence
	}
	if !IsNil(o.Passed) {
		toSerialize["passed"] = o.Passed
	}
	return toSerialize, nil
}

type NullableGetCollectionCommitData struct {
	value *GetCollectionCommitData
	isSet bool
}

func (v NullableGetCollectionCommitData) Get() *GetCollectionCommitData {
	return v.value
}

func (v *NullableGetCollectionCommitData) Set(val *GetCollectionCommitData) {
	v.value = val
	v.isSet = true
}

func (v NullableGetCollectionCommitData) IsSet() bool {
	return v.isSet
}

func (v *NullableGetCollectionCommitData) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetCollectionCommitData(val *GetCollectionCommitData) *NullableGetCollectionCommitData {
	return &NullableGetCollectionCommitData{value: val, isSet: true}
}

func (v NullableGetCollectionCommitData) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGetCollectionCommitData) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

