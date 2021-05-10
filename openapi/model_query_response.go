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

// QueryResponse struct for QueryResponse
type QueryResponse struct {
	// unique id for this query
	QueryId *string `json:"query_id,omitempty"`
	// list of collections queried by the query
	Collections *[]string `json:"collections,omitempty"`
	// list of objects returned by the query
	Results *[]map[string]interface{} `json:"results,omitempty"`
	Stats *QueryResponseStats `json:"stats,omitempty"`
	// warnings received from the query
	Warnings *[]string `json:"warnings,omitempty"`
	// errors encountered while streaming the query
	QueryErrors *[]QueryError `json:"query_errors,omitempty"`
	// meta information about each column in the result set
	ColumnFields *[]QueryFieldType `json:"column_fields,omitempty"`
}

// NewQueryResponse instantiates a new QueryResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewQueryResponse() *QueryResponse {
	this := QueryResponse{}
	return &this
}

// NewQueryResponseWithDefaults instantiates a new QueryResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewQueryResponseWithDefaults() *QueryResponse {
	this := QueryResponse{}
	return &this
}

// GetQueryId returns the QueryId field value if set, zero value otherwise.
func (o *QueryResponse) GetQueryId() string {
	if o == nil || o.QueryId == nil {
		var ret string
		return ret
	}
	return *o.QueryId
}

// GetQueryIdOk returns a tuple with the QueryId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetQueryIdOk() (*string, bool) {
	if o == nil || o.QueryId == nil {
		return nil, false
	}
	return o.QueryId, true
}

// HasQueryId returns a boolean if a field has been set.
func (o *QueryResponse) HasQueryId() bool {
	if o != nil && o.QueryId != nil {
		return true
	}

	return false
}

// SetQueryId gets a reference to the given string and assigns it to the QueryId field.
func (o *QueryResponse) SetQueryId(v string) {
	o.QueryId = &v
}

// GetCollections returns the Collections field value if set, zero value otherwise.
func (o *QueryResponse) GetCollections() []string {
	if o == nil || o.Collections == nil {
		var ret []string
		return ret
	}
	return *o.Collections
}

// GetCollectionsOk returns a tuple with the Collections field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetCollectionsOk() (*[]string, bool) {
	if o == nil || o.Collections == nil {
		return nil, false
	}
	return o.Collections, true
}

// HasCollections returns a boolean if a field has been set.
func (o *QueryResponse) HasCollections() bool {
	if o != nil && o.Collections != nil {
		return true
	}

	return false
}

// SetCollections gets a reference to the given []string and assigns it to the Collections field.
func (o *QueryResponse) SetCollections(v []string) {
	o.Collections = &v
}

// GetResults returns the Results field value if set, zero value otherwise.
func (o *QueryResponse) GetResults() []map[string]interface{} {
	if o == nil || o.Results == nil {
		var ret []map[string]interface{}
		return ret
	}
	return *o.Results
}

// GetResultsOk returns a tuple with the Results field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetResultsOk() (*[]map[string]interface{}, bool) {
	if o == nil || o.Results == nil {
		return nil, false
	}
	return o.Results, true
}

// HasResults returns a boolean if a field has been set.
func (o *QueryResponse) HasResults() bool {
	if o != nil && o.Results != nil {
		return true
	}

	return false
}

// SetResults gets a reference to the given []map[string]interface{} and assigns it to the Results field.
func (o *QueryResponse) SetResults(v []map[string]interface{}) {
	o.Results = &v
}

// GetStats returns the Stats field value if set, zero value otherwise.
func (o *QueryResponse) GetStats() QueryResponseStats {
	if o == nil || o.Stats == nil {
		var ret QueryResponseStats
		return ret
	}
	return *o.Stats
}

// GetStatsOk returns a tuple with the Stats field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetStatsOk() (*QueryResponseStats, bool) {
	if o == nil || o.Stats == nil {
		return nil, false
	}
	return o.Stats, true
}

// HasStats returns a boolean if a field has been set.
func (o *QueryResponse) HasStats() bool {
	if o != nil && o.Stats != nil {
		return true
	}

	return false
}

// SetStats gets a reference to the given QueryResponseStats and assigns it to the Stats field.
func (o *QueryResponse) SetStats(v QueryResponseStats) {
	o.Stats = &v
}

// GetWarnings returns the Warnings field value if set, zero value otherwise.
func (o *QueryResponse) GetWarnings() []string {
	if o == nil || o.Warnings == nil {
		var ret []string
		return ret
	}
	return *o.Warnings
}

// GetWarningsOk returns a tuple with the Warnings field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetWarningsOk() (*[]string, bool) {
	if o == nil || o.Warnings == nil {
		return nil, false
	}
	return o.Warnings, true
}

// HasWarnings returns a boolean if a field has been set.
func (o *QueryResponse) HasWarnings() bool {
	if o != nil && o.Warnings != nil {
		return true
	}

	return false
}

// SetWarnings gets a reference to the given []string and assigns it to the Warnings field.
func (o *QueryResponse) SetWarnings(v []string) {
	o.Warnings = &v
}

// GetQueryErrors returns the QueryErrors field value if set, zero value otherwise.
func (o *QueryResponse) GetQueryErrors() []QueryError {
	if o == nil || o.QueryErrors == nil {
		var ret []QueryError
		return ret
	}
	return *o.QueryErrors
}

// GetQueryErrorsOk returns a tuple with the QueryErrors field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetQueryErrorsOk() (*[]QueryError, bool) {
	if o == nil || o.QueryErrors == nil {
		return nil, false
	}
	return o.QueryErrors, true
}

// HasQueryErrors returns a boolean if a field has been set.
func (o *QueryResponse) HasQueryErrors() bool {
	if o != nil && o.QueryErrors != nil {
		return true
	}

	return false
}

// SetQueryErrors gets a reference to the given []QueryError and assigns it to the QueryErrors field.
func (o *QueryResponse) SetQueryErrors(v []QueryError) {
	o.QueryErrors = &v
}

// GetColumnFields returns the ColumnFields field value if set, zero value otherwise.
func (o *QueryResponse) GetColumnFields() []QueryFieldType {
	if o == nil || o.ColumnFields == nil {
		var ret []QueryFieldType
		return ret
	}
	return *o.ColumnFields
}

// GetColumnFieldsOk returns a tuple with the ColumnFields field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *QueryResponse) GetColumnFieldsOk() (*[]QueryFieldType, bool) {
	if o == nil || o.ColumnFields == nil {
		return nil, false
	}
	return o.ColumnFields, true
}

// HasColumnFields returns a boolean if a field has been set.
func (o *QueryResponse) HasColumnFields() bool {
	if o != nil && o.ColumnFields != nil {
		return true
	}

	return false
}

// SetColumnFields gets a reference to the given []QueryFieldType and assigns it to the ColumnFields field.
func (o *QueryResponse) SetColumnFields(v []QueryFieldType) {
	o.ColumnFields = &v
}

func (o QueryResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.QueryId != nil {
		toSerialize["query_id"] = o.QueryId
	}
	if o.Collections != nil {
		toSerialize["collections"] = o.Collections
	}
	if o.Results != nil {
		toSerialize["results"] = o.Results
	}
	if o.Stats != nil {
		toSerialize["stats"] = o.Stats
	}
	if o.Warnings != nil {
		toSerialize["warnings"] = o.Warnings
	}
	if o.QueryErrors != nil {
		toSerialize["query_errors"] = o.QueryErrors
	}
	if o.ColumnFields != nil {
		toSerialize["column_fields"] = o.ColumnFields
	}
	return json.Marshal(toSerialize)
}

type NullableQueryResponse struct {
	value *QueryResponse
	isSet bool
}

func (v NullableQueryResponse) Get() *QueryResponse {
	return v.value
}

func (v *NullableQueryResponse) Set(val *QueryResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableQueryResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableQueryResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableQueryResponse(val *QueryResponse) *NullableQueryResponse {
	return &NullableQueryResponse{value: val, isSet: true}
}

func (v NullableQueryResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableQueryResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


