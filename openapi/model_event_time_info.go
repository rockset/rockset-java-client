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

// EventTimeInfo struct for EventTimeInfo
type EventTimeInfo struct {
	// Name of the field containing event time.
	Field string `json:"field"`
	// Format of time field, can be one of: milliseconds_since_epoch, seconds_since_epoch.
	Format *string `json:"format,omitempty"`
	// Default time zone, in standard IANA format.
	TimeZone *string `json:"time_zone,omitempty"`
}

// NewEventTimeInfo instantiates a new EventTimeInfo object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewEventTimeInfo(field string) *EventTimeInfo {
	this := EventTimeInfo{}
	this.Field = field
	return &this
}

// NewEventTimeInfoWithDefaults instantiates a new EventTimeInfo object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewEventTimeInfoWithDefaults() *EventTimeInfo {
	this := EventTimeInfo{}
	return &this
}

// GetField returns the Field field value
func (o *EventTimeInfo) GetField() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Field
}

// GetFieldOk returns a tuple with the Field field value
// and a boolean to check if the value has been set.
func (o *EventTimeInfo) GetFieldOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Field, true
}

// SetField sets field value
func (o *EventTimeInfo) SetField(v string) {
	o.Field = v
}

// GetFormat returns the Format field value if set, zero value otherwise.
func (o *EventTimeInfo) GetFormat() string {
	if o == nil || o.Format == nil {
		var ret string
		return ret
	}
	return *o.Format
}

// GetFormatOk returns a tuple with the Format field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventTimeInfo) GetFormatOk() (*string, bool) {
	if o == nil || o.Format == nil {
		return nil, false
	}
	return o.Format, true
}

// HasFormat returns a boolean if a field has been set.
func (o *EventTimeInfo) HasFormat() bool {
	if o != nil && o.Format != nil {
		return true
	}

	return false
}

// SetFormat gets a reference to the given string and assigns it to the Format field.
func (o *EventTimeInfo) SetFormat(v string) {
	o.Format = &v
}

// GetTimeZone returns the TimeZone field value if set, zero value otherwise.
func (o *EventTimeInfo) GetTimeZone() string {
	if o == nil || o.TimeZone == nil {
		var ret string
		return ret
	}
	return *o.TimeZone
}

// GetTimeZoneOk returns a tuple with the TimeZone field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventTimeInfo) GetTimeZoneOk() (*string, bool) {
	if o == nil || o.TimeZone == nil {
		return nil, false
	}
	return o.TimeZone, true
}

// HasTimeZone returns a boolean if a field has been set.
func (o *EventTimeInfo) HasTimeZone() bool {
	if o != nil && o.TimeZone != nil {
		return true
	}

	return false
}

// SetTimeZone gets a reference to the given string and assigns it to the TimeZone field.
func (o *EventTimeInfo) SetTimeZone(v string) {
	o.TimeZone = &v
}

func (o EventTimeInfo) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["field"] = o.Field
	}
	if o.Format != nil {
		toSerialize["format"] = o.Format
	}
	if o.TimeZone != nil {
		toSerialize["time_zone"] = o.TimeZone
	}
	return json.Marshal(toSerialize)
}

type NullableEventTimeInfo struct {
	value *EventTimeInfo
	isSet bool
}

func (v NullableEventTimeInfo) Get() *EventTimeInfo {
	return v.value
}

func (v *NullableEventTimeInfo) Set(val *EventTimeInfo) {
	v.value = val
	v.isSet = true
}

func (v NullableEventTimeInfo) IsSet() bool {
	return v.isSet
}

func (v *NullableEventTimeInfo) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEventTimeInfo(val *EventTimeInfo) *NullableEventTimeInfo {
	return &NullableEventTimeInfo{value: val, isSet: true}
}

func (v NullableEventTimeInfo) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEventTimeInfo) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

