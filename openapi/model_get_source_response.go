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

// checks if the GetSourceResponse type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &GetSourceResponse{}

// GetSourceResponse struct for GetSourceResponse
type GetSourceResponse struct {
	Data *Source `json:"data,omitempty"`
}

// NewGetSourceResponse instantiates a new GetSourceResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewGetSourceResponse() *GetSourceResponse {
	this := GetSourceResponse{}
	return &this
}

// NewGetSourceResponseWithDefaults instantiates a new GetSourceResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewGetSourceResponseWithDefaults() *GetSourceResponse {
	this := GetSourceResponse{}
	return &this
}

// GetData returns the Data field value if set, zero value otherwise.
func (o *GetSourceResponse) GetData() Source {
	if o == nil || IsNil(o.Data) {
		var ret Source
		return ret
	}
	return *o.Data
}

// GetDataOk returns a tuple with the Data field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetSourceResponse) GetDataOk() (*Source, bool) {
	if o == nil || IsNil(o.Data) {
		return nil, false
	}
	return o.Data, true
}

// HasData returns a boolean if a field has been set.
func (o *GetSourceResponse) HasData() bool {
	if o != nil && !IsNil(o.Data) {
		return true
	}

	return false
}

// SetData gets a reference to the given Source and assigns it to the Data field.
func (o *GetSourceResponse) SetData(v Source) {
	o.Data = &v
}

func (o GetSourceResponse) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o GetSourceResponse) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Data) {
		toSerialize["data"] = o.Data
	}
	return toSerialize, nil
}

type NullableGetSourceResponse struct {
	value *GetSourceResponse
	isSet bool
}

func (v NullableGetSourceResponse) Get() *GetSourceResponse {
	return v.value
}

func (v *NullableGetSourceResponse) Set(val *GetSourceResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetSourceResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetSourceResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetSourceResponse(val *GetSourceResponse) *NullableGetSourceResponse {
	return &NullableGetSourceResponse{value: val, isSet: true}
}

func (v NullableGetSourceResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGetSourceResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


