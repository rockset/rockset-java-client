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

// DeleteDocumentsRequest struct for DeleteDocumentsRequest
type DeleteDocumentsRequest struct {
	// array of document IDs
	Data []DeleteDocumentsRequestData `json:"data"`
}

// NewDeleteDocumentsRequest instantiates a new DeleteDocumentsRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewDeleteDocumentsRequest(data []DeleteDocumentsRequestData) *DeleteDocumentsRequest {
	this := DeleteDocumentsRequest{}
	this.Data = data
	return &this
}

// NewDeleteDocumentsRequestWithDefaults instantiates a new DeleteDocumentsRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewDeleteDocumentsRequestWithDefaults() *DeleteDocumentsRequest {
	this := DeleteDocumentsRequest{}
	return &this
}

// GetData returns the Data field value
func (o *DeleteDocumentsRequest) GetData() []DeleteDocumentsRequestData {
	if o == nil {
		var ret []DeleteDocumentsRequestData
		return ret
	}

	return o.Data
}

// GetDataOk returns a tuple with the Data field value
// and a boolean to check if the value has been set.
func (o *DeleteDocumentsRequest) GetDataOk() (*[]DeleteDocumentsRequestData, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Data, true
}

// SetData sets field value
func (o *DeleteDocumentsRequest) SetData(v []DeleteDocumentsRequestData) {
	o.Data = v
}

func (o DeleteDocumentsRequest) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["data"] = o.Data
	}
	return json.Marshal(toSerialize)
}

type NullableDeleteDocumentsRequest struct {
	value *DeleteDocumentsRequest
	isSet bool
}

func (v NullableDeleteDocumentsRequest) Get() *DeleteDocumentsRequest {
	return v.value
}

func (v *NullableDeleteDocumentsRequest) Set(val *DeleteDocumentsRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableDeleteDocumentsRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableDeleteDocumentsRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDeleteDocumentsRequest(val *DeleteDocumentsRequest) *NullableDeleteDocumentsRequest {
	return &NullableDeleteDocumentsRequest{value: val, isSet: true}
}

func (v NullableDeleteDocumentsRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableDeleteDocumentsRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


