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

// ListIpAllowlistsResponse struct for ListIpAllowlistsResponse
type ListIpAllowlistsResponse struct {
	// list of all IP Allowlist network policies
	Data *[]IpAllowlist `json:"data,omitempty"`
}

// NewListIpAllowlistsResponse instantiates a new ListIpAllowlistsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewListIpAllowlistsResponse() *ListIpAllowlistsResponse {
	this := ListIpAllowlistsResponse{}
	return &this
}

// NewListIpAllowlistsResponseWithDefaults instantiates a new ListIpAllowlistsResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewListIpAllowlistsResponseWithDefaults() *ListIpAllowlistsResponse {
	this := ListIpAllowlistsResponse{}
	return &this
}

// GetData returns the Data field value if set, zero value otherwise.
func (o *ListIpAllowlistsResponse) GetData() []IpAllowlist {
	if o == nil || o.Data == nil {
		var ret []IpAllowlist
		return ret
	}
	return *o.Data
}

// GetDataOk returns a tuple with the Data field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ListIpAllowlistsResponse) GetDataOk() (*[]IpAllowlist, bool) {
	if o == nil || o.Data == nil {
		return nil, false
	}
	return o.Data, true
}

// HasData returns a boolean if a field has been set.
func (o *ListIpAllowlistsResponse) HasData() bool {
	if o != nil && o.Data != nil {
		return true
	}

	return false
}

// SetData gets a reference to the given []IpAllowlist and assigns it to the Data field.
func (o *ListIpAllowlistsResponse) SetData(v []IpAllowlist) {
	o.Data = &v
}

func (o ListIpAllowlistsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.Data != nil {
		toSerialize["data"] = o.Data
	}
	return json.Marshal(toSerialize)
}

type NullableListIpAllowlistsResponse struct {
	value *ListIpAllowlistsResponse
	isSet bool
}

func (v NullableListIpAllowlistsResponse) Get() *ListIpAllowlistsResponse {
	return v.value
}

func (v *NullableListIpAllowlistsResponse) Set(val *ListIpAllowlistsResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableListIpAllowlistsResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableListIpAllowlistsResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableListIpAllowlistsResponse(val *ListIpAllowlistsResponse) *NullableListIpAllowlistsResponse {
	return &NullableListIpAllowlistsResponse{value: val, isSet: true}
}

func (v NullableListIpAllowlistsResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableListIpAllowlistsResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


