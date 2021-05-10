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

// ListApiKeysResponse struct for ListApiKeysResponse
type ListApiKeysResponse struct {
	// list of API key objects
	Data *[]ApiKey `json:"data,omitempty"`
}

// NewListApiKeysResponse instantiates a new ListApiKeysResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewListApiKeysResponse() *ListApiKeysResponse {
	this := ListApiKeysResponse{}
	return &this
}

// NewListApiKeysResponseWithDefaults instantiates a new ListApiKeysResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewListApiKeysResponseWithDefaults() *ListApiKeysResponse {
	this := ListApiKeysResponse{}
	return &this
}

// GetData returns the Data field value if set, zero value otherwise.
func (o *ListApiKeysResponse) GetData() []ApiKey {
	if o == nil || o.Data == nil {
		var ret []ApiKey
		return ret
	}
	return *o.Data
}

// GetDataOk returns a tuple with the Data field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ListApiKeysResponse) GetDataOk() (*[]ApiKey, bool) {
	if o == nil || o.Data == nil {
		return nil, false
	}
	return o.Data, true
}

// HasData returns a boolean if a field has been set.
func (o *ListApiKeysResponse) HasData() bool {
	if o != nil && o.Data != nil {
		return true
	}

	return false
}

// SetData gets a reference to the given []ApiKey and assigns it to the Data field.
func (o *ListApiKeysResponse) SetData(v []ApiKey) {
	o.Data = &v
}

func (o ListApiKeysResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.Data != nil {
		toSerialize["data"] = o.Data
	}
	return json.Marshal(toSerialize)
}

type NullableListApiKeysResponse struct {
	value *ListApiKeysResponse
	isSet bool
}

func (v NullableListApiKeysResponse) Get() *ListApiKeysResponse {
	return v.value
}

func (v *NullableListApiKeysResponse) Set(val *ListApiKeysResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableListApiKeysResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableListApiKeysResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableListApiKeysResponse(val *ListApiKeysResponse) *NullableListApiKeysResponse {
	return &NullableListApiKeysResponse{value: val, isSet: true}
}

func (v NullableListApiKeysResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableListApiKeysResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


