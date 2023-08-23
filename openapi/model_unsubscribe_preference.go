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

// checks if the UnsubscribePreference type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &UnsubscribePreference{}

// UnsubscribePreference Notification preferences for the user.
type UnsubscribePreference struct {
	// The type of notification to be unsubscribed from.
	NotificationType string `json:"notificationType"`
}

// NewUnsubscribePreference instantiates a new UnsubscribePreference object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUnsubscribePreference(notificationType string) *UnsubscribePreference {
	this := UnsubscribePreference{}
	this.NotificationType = notificationType
	return &this
}

// NewUnsubscribePreferenceWithDefaults instantiates a new UnsubscribePreference object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUnsubscribePreferenceWithDefaults() *UnsubscribePreference {
	this := UnsubscribePreference{}
	return &this
}

// GetNotificationType returns the NotificationType field value
func (o *UnsubscribePreference) GetNotificationType() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.NotificationType
}

// GetNotificationTypeOk returns a tuple with the NotificationType field value
// and a boolean to check if the value has been set.
func (o *UnsubscribePreference) GetNotificationTypeOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NotificationType, true
}

// SetNotificationType sets field value
func (o *UnsubscribePreference) SetNotificationType(v string) {
	o.NotificationType = v
}

func (o UnsubscribePreference) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o UnsubscribePreference) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["notificationType"] = o.NotificationType
	return toSerialize, nil
}

type NullableUnsubscribePreference struct {
	value *UnsubscribePreference
	isSet bool
}

func (v NullableUnsubscribePreference) Get() *UnsubscribePreference {
	return v.value
}

func (v *NullableUnsubscribePreference) Set(val *UnsubscribePreference) {
	v.value = val
	v.isSet = true
}

func (v NullableUnsubscribePreference) IsSet() bool {
	return v.isSet
}

func (v *NullableUnsubscribePreference) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUnsubscribePreference(val *UnsubscribePreference) *NullableUnsubscribePreference {
	return &NullableUnsubscribePreference{value: val, isSet: true}
}

func (v NullableUnsubscribePreference) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUnsubscribePreference) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


