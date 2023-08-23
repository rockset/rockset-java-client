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

// checks if the CreateRoleRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &CreateRoleRequest{}

// CreateRoleRequest struct for CreateRoleRequest
type CreateRoleRequest struct {
	// Description for the role.
	Description *string `json:"description,omitempty"`
	// List of privileges that will be associated with the role.
	Privileges []Privilege `json:"privileges,omitempty"`
	// Unique identifier for the role.
	RoleName *string `json:"role_name,omitempty"`
}

// NewCreateRoleRequest instantiates a new CreateRoleRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewCreateRoleRequest() *CreateRoleRequest {
	this := CreateRoleRequest{}
	return &this
}

// NewCreateRoleRequestWithDefaults instantiates a new CreateRoleRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewCreateRoleRequestWithDefaults() *CreateRoleRequest {
	this := CreateRoleRequest{}
	return &this
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *CreateRoleRequest) GetDescription() string {
	if o == nil || IsNil(o.Description) {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *CreateRoleRequest) GetDescriptionOk() (*string, bool) {
	if o == nil || IsNil(o.Description) {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *CreateRoleRequest) HasDescription() bool {
	if o != nil && !IsNil(o.Description) {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *CreateRoleRequest) SetDescription(v string) {
	o.Description = &v
}

// GetPrivileges returns the Privileges field value if set, zero value otherwise.
func (o *CreateRoleRequest) GetPrivileges() []Privilege {
	if o == nil || IsNil(o.Privileges) {
		var ret []Privilege
		return ret
	}
	return o.Privileges
}

// GetPrivilegesOk returns a tuple with the Privileges field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *CreateRoleRequest) GetPrivilegesOk() ([]Privilege, bool) {
	if o == nil || IsNil(o.Privileges) {
		return nil, false
	}
	return o.Privileges, true
}

// HasPrivileges returns a boolean if a field has been set.
func (o *CreateRoleRequest) HasPrivileges() bool {
	if o != nil && !IsNil(o.Privileges) {
		return true
	}

	return false
}

// SetPrivileges gets a reference to the given []Privilege and assigns it to the Privileges field.
func (o *CreateRoleRequest) SetPrivileges(v []Privilege) {
	o.Privileges = v
}

// GetRoleName returns the RoleName field value if set, zero value otherwise.
func (o *CreateRoleRequest) GetRoleName() string {
	if o == nil || IsNil(o.RoleName) {
		var ret string
		return ret
	}
	return *o.RoleName
}

// GetRoleNameOk returns a tuple with the RoleName field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *CreateRoleRequest) GetRoleNameOk() (*string, bool) {
	if o == nil || IsNil(o.RoleName) {
		return nil, false
	}
	return o.RoleName, true
}

// HasRoleName returns a boolean if a field has been set.
func (o *CreateRoleRequest) HasRoleName() bool {
	if o != nil && !IsNil(o.RoleName) {
		return true
	}

	return false
}

// SetRoleName gets a reference to the given string and assigns it to the RoleName field.
func (o *CreateRoleRequest) SetRoleName(v string) {
	o.RoleName = &v
}

func (o CreateRoleRequest) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o CreateRoleRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Description) {
		toSerialize["description"] = o.Description
	}
	if !IsNil(o.Privileges) {
		toSerialize["privileges"] = o.Privileges
	}
	if !IsNil(o.RoleName) {
		toSerialize["role_name"] = o.RoleName
	}
	return toSerialize, nil
}

type NullableCreateRoleRequest struct {
	value *CreateRoleRequest
	isSet bool
}

func (v NullableCreateRoleRequest) Get() *CreateRoleRequest {
	return v.value
}

func (v *NullableCreateRoleRequest) Set(val *CreateRoleRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableCreateRoleRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableCreateRoleRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableCreateRoleRequest(val *CreateRoleRequest) *NullableCreateRoleRequest {
	return &NullableCreateRoleRequest{value: val, isSet: true}
}

func (v NullableCreateRoleRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableCreateRoleRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

