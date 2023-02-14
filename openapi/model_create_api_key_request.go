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

// CreateApiKeyRequest struct for CreateApiKeyRequest
type CreateApiKeyRequest struct {
	// Name for this API key.
	Name string `json:"name"`
	Role *string `json:"role,omitempty"`
	CreatedBy *string `json:"created_by,omitempty"`
}

// NewCreateApiKeyRequest instantiates a new CreateApiKeyRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewCreateApiKeyRequest(name string) *CreateApiKeyRequest {
	this := CreateApiKeyRequest{}
	this.Name = name
	return &this
}

// NewCreateApiKeyRequestWithDefaults instantiates a new CreateApiKeyRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewCreateApiKeyRequestWithDefaults() *CreateApiKeyRequest {
	this := CreateApiKeyRequest{}
	return &this
}

// GetName returns the Name field value
func (o *CreateApiKeyRequest) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *CreateApiKeyRequest) GetNameOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *CreateApiKeyRequest) SetName(v string) {
	o.Name = v
}

// GetRole returns the Role field value if set, zero value otherwise.
func (o *CreateApiKeyRequest) GetRole() string {
	if o == nil || o.Role == nil {
		var ret string
		return ret
	}
	return *o.Role
}

// GetRoleOk returns a tuple with the Role field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *CreateApiKeyRequest) GetRoleOk() (*string, bool) {
	if o == nil || o.Role == nil {
		return nil, false
	}
	return o.Role, true
}

// HasRole returns a boolean if a field has been set.
func (o *CreateApiKeyRequest) HasRole() bool {
	if o != nil && o.Role != nil {
		return true
	}

	return false
}

// SetRole gets a reference to the given string and assigns it to the Role field.
func (o *CreateApiKeyRequest) SetRole(v string) {
	o.Role = &v
}

// GetCreatedBy returns the CreatedBy field value if set, zero value otherwise.
func (o *CreateApiKeyRequest) GetCreatedBy() string {
	if o == nil || o.CreatedBy == nil {
		var ret string
		return ret
	}
	return *o.CreatedBy
}

// GetCreatedByOk returns a tuple with the CreatedBy field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *CreateApiKeyRequest) GetCreatedByOk() (*string, bool) {
	if o == nil || o.CreatedBy == nil {
		return nil, false
	}
	return o.CreatedBy, true
}

// HasCreatedBy returns a boolean if a field has been set.
func (o *CreateApiKeyRequest) HasCreatedBy() bool {
	if o != nil && o.CreatedBy != nil {
		return true
	}

	return false
}

// SetCreatedBy gets a reference to the given string and assigns it to the CreatedBy field.
func (o *CreateApiKeyRequest) SetCreatedBy(v string) {
	o.CreatedBy = &v
}

func (o CreateApiKeyRequest) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["name"] = o.Name
	}
	if o.Role != nil {
		toSerialize["role"] = o.Role
	}
	if o.CreatedBy != nil {
		toSerialize["created_by"] = o.CreatedBy
	}
	return json.Marshal(toSerialize)
}

type NullableCreateApiKeyRequest struct {
	value *CreateApiKeyRequest
	isSet bool
}

func (v NullableCreateApiKeyRequest) Get() *CreateApiKeyRequest {
	return v.value
}

func (v *NullableCreateApiKeyRequest) Set(val *CreateApiKeyRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableCreateApiKeyRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableCreateApiKeyRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableCreateApiKeyRequest(val *CreateApiKeyRequest) *NullableCreateApiKeyRequest {
	return &NullableCreateApiKeyRequest{value: val, isSet: true}
}

func (v NullableCreateApiKeyRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableCreateApiKeyRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

