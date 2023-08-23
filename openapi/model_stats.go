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

// checks if the Stats type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &Stats{}

// Stats struct for Stats
type Stats struct {
	// Total execution time (including time queued) of the query, in milliseconds.
	ElapsedTimeMs *int64 `json:"elapsed_time_ms,omitempty"`
	// Number of bytes in the query result set. Only populated if `status` is `COMPLETE`. Not populated for INSERT INTO queries.
	ResultSetBytesSize *int64 `json:"result_set_bytes_size,omitempty"`
	// Number of documents returned by the query. Only populated if `status` is `COMPLETE`.
	ResultSetDocumentCount *int64 `json:"result_set_document_count,omitempty"`
	// Time query spent queued, in milliseconds.
	ThrottledTimeMs *int64 `json:"throttled_time_ms,omitempty"`
}

// NewStats instantiates a new Stats object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewStats() *Stats {
	this := Stats{}
	return &this
}

// NewStatsWithDefaults instantiates a new Stats object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewStatsWithDefaults() *Stats {
	this := Stats{}
	return &this
}

// GetElapsedTimeMs returns the ElapsedTimeMs field value if set, zero value otherwise.
func (o *Stats) GetElapsedTimeMs() int64 {
	if o == nil || IsNil(o.ElapsedTimeMs) {
		var ret int64
		return ret
	}
	return *o.ElapsedTimeMs
}

// GetElapsedTimeMsOk returns a tuple with the ElapsedTimeMs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Stats) GetElapsedTimeMsOk() (*int64, bool) {
	if o == nil || IsNil(o.ElapsedTimeMs) {
		return nil, false
	}
	return o.ElapsedTimeMs, true
}

// HasElapsedTimeMs returns a boolean if a field has been set.
func (o *Stats) HasElapsedTimeMs() bool {
	if o != nil && !IsNil(o.ElapsedTimeMs) {
		return true
	}

	return false
}

// SetElapsedTimeMs gets a reference to the given int64 and assigns it to the ElapsedTimeMs field.
func (o *Stats) SetElapsedTimeMs(v int64) {
	o.ElapsedTimeMs = &v
}

// GetResultSetBytesSize returns the ResultSetBytesSize field value if set, zero value otherwise.
func (o *Stats) GetResultSetBytesSize() int64 {
	if o == nil || IsNil(o.ResultSetBytesSize) {
		var ret int64
		return ret
	}
	return *o.ResultSetBytesSize
}

// GetResultSetBytesSizeOk returns a tuple with the ResultSetBytesSize field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Stats) GetResultSetBytesSizeOk() (*int64, bool) {
	if o == nil || IsNil(o.ResultSetBytesSize) {
		return nil, false
	}
	return o.ResultSetBytesSize, true
}

// HasResultSetBytesSize returns a boolean if a field has been set.
func (o *Stats) HasResultSetBytesSize() bool {
	if o != nil && !IsNil(o.ResultSetBytesSize) {
		return true
	}

	return false
}

// SetResultSetBytesSize gets a reference to the given int64 and assigns it to the ResultSetBytesSize field.
func (o *Stats) SetResultSetBytesSize(v int64) {
	o.ResultSetBytesSize = &v
}

// GetResultSetDocumentCount returns the ResultSetDocumentCount field value if set, zero value otherwise.
func (o *Stats) GetResultSetDocumentCount() int64 {
	if o == nil || IsNil(o.ResultSetDocumentCount) {
		var ret int64
		return ret
	}
	return *o.ResultSetDocumentCount
}

// GetResultSetDocumentCountOk returns a tuple with the ResultSetDocumentCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Stats) GetResultSetDocumentCountOk() (*int64, bool) {
	if o == nil || IsNil(o.ResultSetDocumentCount) {
		return nil, false
	}
	return o.ResultSetDocumentCount, true
}

// HasResultSetDocumentCount returns a boolean if a field has been set.
func (o *Stats) HasResultSetDocumentCount() bool {
	if o != nil && !IsNil(o.ResultSetDocumentCount) {
		return true
	}

	return false
}

// SetResultSetDocumentCount gets a reference to the given int64 and assigns it to the ResultSetDocumentCount field.
func (o *Stats) SetResultSetDocumentCount(v int64) {
	o.ResultSetDocumentCount = &v
}

// GetThrottledTimeMs returns the ThrottledTimeMs field value if set, zero value otherwise.
func (o *Stats) GetThrottledTimeMs() int64 {
	if o == nil || IsNil(o.ThrottledTimeMs) {
		var ret int64
		return ret
	}
	return *o.ThrottledTimeMs
}

// GetThrottledTimeMsOk returns a tuple with the ThrottledTimeMs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Stats) GetThrottledTimeMsOk() (*int64, bool) {
	if o == nil || IsNil(o.ThrottledTimeMs) {
		return nil, false
	}
	return o.ThrottledTimeMs, true
}

// HasThrottledTimeMs returns a boolean if a field has been set.
func (o *Stats) HasThrottledTimeMs() bool {
	if o != nil && !IsNil(o.ThrottledTimeMs) {
		return true
	}

	return false
}

// SetThrottledTimeMs gets a reference to the given int64 and assigns it to the ThrottledTimeMs field.
func (o *Stats) SetThrottledTimeMs(v int64) {
	o.ThrottledTimeMs = &v
}

func (o Stats) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o Stats) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.ElapsedTimeMs) {
		toSerialize["elapsed_time_ms"] = o.ElapsedTimeMs
	}
	if !IsNil(o.ResultSetBytesSize) {
		toSerialize["result_set_bytes_size"] = o.ResultSetBytesSize
	}
	if !IsNil(o.ResultSetDocumentCount) {
		toSerialize["result_set_document_count"] = o.ResultSetDocumentCount
	}
	if !IsNil(o.ThrottledTimeMs) {
		toSerialize["throttled_time_ms"] = o.ThrottledTimeMs
	}
	return toSerialize, nil
}

type NullableStats struct {
	value *Stats
	isSet bool
}

func (v NullableStats) Get() *Stats {
	return v.value
}

func (v *NullableStats) Set(val *Stats) {
	v.value = val
	v.isSet = true
}

func (v NullableStats) IsSet() bool {
	return v.isSet
}

func (v *NullableStats) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableStats(val *Stats) *NullableStats {
	return &NullableStats{value: val, isSet: true}
}

func (v NullableStats) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableStats) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


