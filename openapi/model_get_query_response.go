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

// checks if the GetQueryResponse type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &GetQueryResponse{}

// GetQueryResponse struct for GetQueryResponse
type GetQueryResponse struct {
	Data *QueryInfo `json:"data,omitempty"`
}

// NewGetQueryResponse instantiates a new GetQueryResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewGetQueryResponse() *GetQueryResponse {
	this := GetQueryResponse{}
	return &this
}

// NewGetQueryResponseWithDefaults instantiates a new GetQueryResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewGetQueryResponseWithDefaults() *GetQueryResponse {
	this := GetQueryResponse{}
	return &this
}

// GetData returns the Data field value if set, zero value otherwise.
func (o *GetQueryResponse) GetData() QueryInfo {
	if o == nil || IsNil(o.Data) {
		var ret QueryInfo
		return ret
	}
	return *o.Data
}

// GetDataOk returns a tuple with the Data field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetQueryResponse) GetDataOk() (*QueryInfo, bool) {
	if o == nil || IsNil(o.Data) {
		return nil, false
	}
	return o.Data, true
}

// HasData returns a boolean if a field has been set.
func (o *GetQueryResponse) HasData() bool {
	if o != nil && !IsNil(o.Data) {
		return true
	}

	return false
}

// SetData gets a reference to the given QueryInfo and assigns it to the Data field.
func (o *GetQueryResponse) SetData(v QueryInfo) {
	o.Data = &v
}

func (o GetQueryResponse) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o GetQueryResponse) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Data) {
		toSerialize["data"] = o.Data
	}
	return toSerialize, nil
}

type NullableGetQueryResponse struct {
	value *GetQueryResponse
	isSet bool
}

func (v NullableGetQueryResponse) Get() *GetQueryResponse {
	return v.value
}

func (v *NullableGetQueryResponse) Set(val *GetQueryResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetQueryResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetQueryResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetQueryResponse(val *GetQueryResponse) *NullableGetQueryResponse {
	return &NullableGetQueryResponse{value: val, isSet: true}
}

func (v NullableGetQueryResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGetQueryResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


