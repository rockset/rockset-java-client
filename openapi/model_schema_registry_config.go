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

// SchemaRegistryConfig struct for SchemaRegistryConfig
type SchemaRegistryConfig struct {
	// Schema registry URL.
	Url *string `json:"url,omitempty"`
	// The secure API key for schema registry.
	Key *string `json:"key,omitempty"`
	// The secure API password registry.
	Secret *string `json:"secret,omitempty"`
}

// NewSchemaRegistryConfig instantiates a new SchemaRegistryConfig object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewSchemaRegistryConfig() *SchemaRegistryConfig {
	this := SchemaRegistryConfig{}
	return &this
}

// NewSchemaRegistryConfigWithDefaults instantiates a new SchemaRegistryConfig object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewSchemaRegistryConfigWithDefaults() *SchemaRegistryConfig {
	this := SchemaRegistryConfig{}
	return &this
}

// GetUrl returns the Url field value if set, zero value otherwise.
func (o *SchemaRegistryConfig) GetUrl() string {
	if o == nil || o.Url == nil {
		var ret string
		return ret
	}
	return *o.Url
}

// GetUrlOk returns a tuple with the Url field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SchemaRegistryConfig) GetUrlOk() (*string, bool) {
	if o == nil || o.Url == nil {
		return nil, false
	}
	return o.Url, true
}

// HasUrl returns a boolean if a field has been set.
func (o *SchemaRegistryConfig) HasUrl() bool {
	if o != nil && o.Url != nil {
		return true
	}

	return false
}

// SetUrl gets a reference to the given string and assigns it to the Url field.
func (o *SchemaRegistryConfig) SetUrl(v string) {
	o.Url = &v
}

// GetKey returns the Key field value if set, zero value otherwise.
func (o *SchemaRegistryConfig) GetKey() string {
	if o == nil || o.Key == nil {
		var ret string
		return ret
	}
	return *o.Key
}

// GetKeyOk returns a tuple with the Key field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SchemaRegistryConfig) GetKeyOk() (*string, bool) {
	if o == nil || o.Key == nil {
		return nil, false
	}
	return o.Key, true
}

// HasKey returns a boolean if a field has been set.
func (o *SchemaRegistryConfig) HasKey() bool {
	if o != nil && o.Key != nil {
		return true
	}

	return false
}

// SetKey gets a reference to the given string and assigns it to the Key field.
func (o *SchemaRegistryConfig) SetKey(v string) {
	o.Key = &v
}

// GetSecret returns the Secret field value if set, zero value otherwise.
func (o *SchemaRegistryConfig) GetSecret() string {
	if o == nil || o.Secret == nil {
		var ret string
		return ret
	}
	return *o.Secret
}

// GetSecretOk returns a tuple with the Secret field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SchemaRegistryConfig) GetSecretOk() (*string, bool) {
	if o == nil || o.Secret == nil {
		return nil, false
	}
	return o.Secret, true
}

// HasSecret returns a boolean if a field has been set.
func (o *SchemaRegistryConfig) HasSecret() bool {
	if o != nil && o.Secret != nil {
		return true
	}

	return false
}

// SetSecret gets a reference to the given string and assigns it to the Secret field.
func (o *SchemaRegistryConfig) SetSecret(v string) {
	o.Secret = &v
}

func (o SchemaRegistryConfig) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.Url != nil {
		toSerialize["url"] = o.Url
	}
	if o.Key != nil {
		toSerialize["key"] = o.Key
	}
	if o.Secret != nil {
		toSerialize["secret"] = o.Secret
	}
	return json.Marshal(toSerialize)
}

type NullableSchemaRegistryConfig struct {
	value *SchemaRegistryConfig
	isSet bool
}

func (v NullableSchemaRegistryConfig) Get() *SchemaRegistryConfig {
	return v.value
}

func (v *NullableSchemaRegistryConfig) Set(val *SchemaRegistryConfig) {
	v.value = val
	v.isSet = true
}

func (v NullableSchemaRegistryConfig) IsSet() bool {
	return v.isSet
}

func (v *NullableSchemaRegistryConfig) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSchemaRegistryConfig(val *SchemaRegistryConfig) *NullableSchemaRegistryConfig {
	return &NullableSchemaRegistryConfig{value: val, isSet: true}
}

func (v NullableSchemaRegistryConfig) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSchemaRegistryConfig) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


