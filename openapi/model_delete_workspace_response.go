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

// DeleteWorkspaceResponse struct for DeleteWorkspaceResponse
type DeleteWorkspaceResponse struct {
	Data *Workspace `json:"data,omitempty"`
}

// NewDeleteWorkspaceResponse instantiates a new DeleteWorkspaceResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewDeleteWorkspaceResponse() *DeleteWorkspaceResponse {
	this := DeleteWorkspaceResponse{}
	return &this
}

// NewDeleteWorkspaceResponseWithDefaults instantiates a new DeleteWorkspaceResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewDeleteWorkspaceResponseWithDefaults() *DeleteWorkspaceResponse {
	this := DeleteWorkspaceResponse{}
	return &this
}

// GetData returns the Data field value if set, zero value otherwise.
func (o *DeleteWorkspaceResponse) GetData() Workspace {
	if o == nil || o.Data == nil {
		var ret Workspace
		return ret
	}
	return *o.Data
}

// GetDataOk returns a tuple with the Data field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DeleteWorkspaceResponse) GetDataOk() (*Workspace, bool) {
	if o == nil || o.Data == nil {
		return nil, false
	}
	return o.Data, true
}

// HasData returns a boolean if a field has been set.
func (o *DeleteWorkspaceResponse) HasData() bool {
	if o != nil && o.Data != nil {
		return true
	}

	return false
}

// SetData gets a reference to the given Workspace and assigns it to the Data field.
func (o *DeleteWorkspaceResponse) SetData(v Workspace) {
	o.Data = &v
}

func (o DeleteWorkspaceResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.Data != nil {
		toSerialize["data"] = o.Data
	}
	return json.Marshal(toSerialize)
}

type NullableDeleteWorkspaceResponse struct {
	value *DeleteWorkspaceResponse
	isSet bool
}

func (v NullableDeleteWorkspaceResponse) Get() *DeleteWorkspaceResponse {
	return v.value
}

func (v *NullableDeleteWorkspaceResponse) Set(val *DeleteWorkspaceResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableDeleteWorkspaceResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableDeleteWorkspaceResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDeleteWorkspaceResponse(val *DeleteWorkspaceResponse) *NullableDeleteWorkspaceResponse {
	return &NullableDeleteWorkspaceResponse{value: val, isSet: true}
}

func (v NullableDeleteWorkspaceResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableDeleteWorkspaceResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

