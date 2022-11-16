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

// SourceSnowflake struct for SourceSnowflake
type SourceSnowflake struct {
	// Name of the snowflake database.
	Database string `json:"database"`
	// Name of the snowflake database schema.
	Schema string `json:"schema"`
	// Name of the snowflake table.
	TableName string `json:"table_name"`
	// Name of the data warehouse to be used.
	Warehouse *string `json:"warehouse,omitempty"`
	Status *StatusSnowflake `json:"status,omitempty"`
}

// NewSourceSnowflake instantiates a new SourceSnowflake object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewSourceSnowflake(database string, schema string, tableName string) *SourceSnowflake {
	this := SourceSnowflake{}
	this.Database = database
	this.Schema = schema
	this.TableName = tableName
	return &this
}

// NewSourceSnowflakeWithDefaults instantiates a new SourceSnowflake object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewSourceSnowflakeWithDefaults() *SourceSnowflake {
	this := SourceSnowflake{}
	return &this
}

// GetDatabase returns the Database field value
func (o *SourceSnowflake) GetDatabase() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Database
}

// GetDatabaseOk returns a tuple with the Database field value
// and a boolean to check if the value has been set.
func (o *SourceSnowflake) GetDatabaseOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Database, true
}

// SetDatabase sets field value
func (o *SourceSnowflake) SetDatabase(v string) {
	o.Database = v
}

// GetSchema returns the Schema field value
func (o *SourceSnowflake) GetSchema() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Schema
}

// GetSchemaOk returns a tuple with the Schema field value
// and a boolean to check if the value has been set.
func (o *SourceSnowflake) GetSchemaOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Schema, true
}

// SetSchema sets field value
func (o *SourceSnowflake) SetSchema(v string) {
	o.Schema = v
}

// GetTableName returns the TableName field value
func (o *SourceSnowflake) GetTableName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.TableName
}

// GetTableNameOk returns a tuple with the TableName field value
// and a boolean to check if the value has been set.
func (o *SourceSnowflake) GetTableNameOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.TableName, true
}

// SetTableName sets field value
func (o *SourceSnowflake) SetTableName(v string) {
	o.TableName = v
}

// GetWarehouse returns the Warehouse field value if set, zero value otherwise.
func (o *SourceSnowflake) GetWarehouse() string {
	if o == nil || o.Warehouse == nil {
		var ret string
		return ret
	}
	return *o.Warehouse
}

// GetWarehouseOk returns a tuple with the Warehouse field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceSnowflake) GetWarehouseOk() (*string, bool) {
	if o == nil || o.Warehouse == nil {
		return nil, false
	}
	return o.Warehouse, true
}

// HasWarehouse returns a boolean if a field has been set.
func (o *SourceSnowflake) HasWarehouse() bool {
	if o != nil && o.Warehouse != nil {
		return true
	}

	return false
}

// SetWarehouse gets a reference to the given string and assigns it to the Warehouse field.
func (o *SourceSnowflake) SetWarehouse(v string) {
	o.Warehouse = &v
}

// GetStatus returns the Status field value if set, zero value otherwise.
func (o *SourceSnowflake) GetStatus() StatusSnowflake {
	if o == nil || o.Status == nil {
		var ret StatusSnowflake
		return ret
	}
	return *o.Status
}

// GetStatusOk returns a tuple with the Status field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceSnowflake) GetStatusOk() (*StatusSnowflake, bool) {
	if o == nil || o.Status == nil {
		return nil, false
	}
	return o.Status, true
}

// HasStatus returns a boolean if a field has been set.
func (o *SourceSnowflake) HasStatus() bool {
	if o != nil && o.Status != nil {
		return true
	}

	return false
}

// SetStatus gets a reference to the given StatusSnowflake and assigns it to the Status field.
func (o *SourceSnowflake) SetStatus(v StatusSnowflake) {
	o.Status = &v
}

func (o SourceSnowflake) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["database"] = o.Database
	}
	if true {
		toSerialize["schema"] = o.Schema
	}
	if true {
		toSerialize["table_name"] = o.TableName
	}
	if o.Warehouse != nil {
		toSerialize["warehouse"] = o.Warehouse
	}
	if o.Status != nil {
		toSerialize["status"] = o.Status
	}
	return json.Marshal(toSerialize)
}

type NullableSourceSnowflake struct {
	value *SourceSnowflake
	isSet bool
}

func (v NullableSourceSnowflake) Get() *SourceSnowflake {
	return v.value
}

func (v *NullableSourceSnowflake) Set(val *SourceSnowflake) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceSnowflake) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceSnowflake) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceSnowflake(val *SourceSnowflake) *NullableSourceSnowflake {
	return &NullableSourceSnowflake{value: val, isSet: true}
}

func (v NullableSourceSnowflake) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSourceSnowflake) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

