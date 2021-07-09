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

// AwsRole struct for AwsRole
type AwsRole struct {
	// ARN of rockset-role created in your account
	AwsRoleArn string `json:"aws_role_arn"`
}

// NewAwsRole instantiates a new AwsRole object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAwsRole(awsRoleArn string) *AwsRole {
	this := AwsRole{}
	this.AwsRoleArn = awsRoleArn
	return &this
}

// NewAwsRoleWithDefaults instantiates a new AwsRole object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAwsRoleWithDefaults() *AwsRole {
	this := AwsRole{}
	return &this
}

// GetAwsRoleArn returns the AwsRoleArn field value
func (o *AwsRole) GetAwsRoleArn() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.AwsRoleArn
}

// GetAwsRoleArnOk returns a tuple with the AwsRoleArn field value
// and a boolean to check if the value has been set.
func (o *AwsRole) GetAwsRoleArnOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.AwsRoleArn, true
}

// SetAwsRoleArn sets field value
func (o *AwsRole) SetAwsRoleArn(v string) {
	o.AwsRoleArn = v
}

func (o AwsRole) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["aws_role_arn"] = o.AwsRoleArn
	}
	return json.Marshal(toSerialize)
}

type NullableAwsRole struct {
	value *AwsRole
	isSet bool
}

func (v NullableAwsRole) Get() *AwsRole {
	return v.value
}

func (v *NullableAwsRole) Set(val *AwsRole) {
	v.value = val
	v.isSet = true
}

func (v NullableAwsRole) IsSet() bool {
	return v.isSet
}

func (v *NullableAwsRole) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAwsRole(val *AwsRole) *NullableAwsRole {
	return &NullableAwsRole{value: val, isSet: true}
}

func (v NullableAwsRole) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAwsRole) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

