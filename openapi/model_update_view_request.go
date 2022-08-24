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

// UpdateViewRequest struct for UpdateViewRequest
type UpdateViewRequest struct {
	// Optional description.
	Description *string `json:"description,omitempty"`
	// SQL for this view.
	Query string `json:"query"`
}

// NewUpdateViewRequest instantiates a new UpdateViewRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUpdateViewRequest(query string) *UpdateViewRequest {
	this := UpdateViewRequest{}
	this.Query = query
	return &this
}

// NewUpdateViewRequestWithDefaults instantiates a new UpdateViewRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUpdateViewRequestWithDefaults() *UpdateViewRequest {
	this := UpdateViewRequest{}
	return &this
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *UpdateViewRequest) GetDescription() string {
	if o == nil || o.Description == nil {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *UpdateViewRequest) GetDescriptionOk() (*string, bool) {
	if o == nil || o.Description == nil {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *UpdateViewRequest) HasDescription() bool {
	if o != nil && o.Description != nil {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *UpdateViewRequest) SetDescription(v string) {
	o.Description = &v
}

// GetQuery returns the Query field value
func (o *UpdateViewRequest) GetQuery() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Query
}

// GetQueryOk returns a tuple with the Query field value
// and a boolean to check if the value has been set.
func (o *UpdateViewRequest) GetQueryOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Query, true
}

// SetQuery sets field value
func (o *UpdateViewRequest) SetQuery(v string) {
	o.Query = v
}

func (o UpdateViewRequest) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.Description != nil {
		toSerialize["description"] = o.Description
	}
	if true {
		toSerialize["query"] = o.Query
	}
	return json.Marshal(toSerialize)
}

type NullableUpdateViewRequest struct {
	value *UpdateViewRequest
	isSet bool
}

func (v NullableUpdateViewRequest) Get() *UpdateViewRequest {
	return v.value
}

func (v *NullableUpdateViewRequest) Set(val *UpdateViewRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableUpdateViewRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableUpdateViewRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUpdateViewRequest(val *UpdateViewRequest) *NullableUpdateViewRequest {
	return &NullableUpdateViewRequest{value: val, isSet: true}
}

func (v NullableUpdateViewRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUpdateViewRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


