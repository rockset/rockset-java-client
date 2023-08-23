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

// checks if the DeleteDocumentsRequestData type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &DeleteDocumentsRequestData{}

// DeleteDocumentsRequestData struct for DeleteDocumentsRequestData
type DeleteDocumentsRequestData struct {
	// Unique document ID.
	Id string `json:"_id"`
}

// NewDeleteDocumentsRequestData instantiates a new DeleteDocumentsRequestData object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewDeleteDocumentsRequestData(id string) *DeleteDocumentsRequestData {
	this := DeleteDocumentsRequestData{}
	this.Id = id
	return &this
}

// NewDeleteDocumentsRequestDataWithDefaults instantiates a new DeleteDocumentsRequestData object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewDeleteDocumentsRequestDataWithDefaults() *DeleteDocumentsRequestData {
	this := DeleteDocumentsRequestData{}
	return &this
}

// GetId returns the Id field value
func (o *DeleteDocumentsRequestData) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *DeleteDocumentsRequestData) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value
func (o *DeleteDocumentsRequestData) SetId(v string) {
	o.Id = v
}

func (o DeleteDocumentsRequestData) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o DeleteDocumentsRequestData) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["_id"] = o.Id
	return toSerialize, nil
}

type NullableDeleteDocumentsRequestData struct {
	value *DeleteDocumentsRequestData
	isSet bool
}

func (v NullableDeleteDocumentsRequestData) Get() *DeleteDocumentsRequestData {
	return v.value
}

func (v *NullableDeleteDocumentsRequestData) Set(val *DeleteDocumentsRequestData) {
	v.value = val
	v.isSet = true
}

func (v NullableDeleteDocumentsRequestData) IsSet() bool {
	return v.isSet
}

func (v *NullableDeleteDocumentsRequestData) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDeleteDocumentsRequestData(val *DeleteDocumentsRequestData) *NullableDeleteDocumentsRequestData {
	return &NullableDeleteDocumentsRequestData{value: val, isSet: true}
}

func (v NullableDeleteDocumentsRequestData) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableDeleteDocumentsRequestData) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


