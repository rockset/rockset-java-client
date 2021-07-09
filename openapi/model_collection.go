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

// Collection struct for Collection
type Collection struct {
	// ISO-8601 date
	CreatedAt *string `json:"created_at,omitempty"`
	// email of user who created the collection
	CreatedBy *string `json:"created_by,omitempty"`
	// unique identifer for collection, can contain alphanumeric or dash characters
	Name *string `json:"name,omitempty"`
	// text describing the collection
	Description *string `json:"description,omitempty"`
	// name of the workspace that the collection is in
	Workspace *string `json:"workspace,omitempty"`
	// current status of collection, one of: CREATED, READY, DELETED
	Status *string `json:"status,omitempty"`
	// list of sources from which collection ingests
	Sources *[]Source `json:"sources,omitempty"`
	Stats *CollectionStats `json:"stats,omitempty"`
	// number of seconds after which data is purged based on event time
	RetentionSecs *int64 `json:"retention_secs,omitempty"`
	// list of mappings applied on all documents in a collection
	FieldMappings *[]FieldMappingV2 `json:"field_mappings,omitempty"`
	// list of clustering fields for a collection
	ClusteringKey *[]FieldPartition `json:"clustering_key,omitempty"`
	// list of aliases for a collection
	Aliases *[]Alias `json:"aliases,omitempty"`
	// list of field schemas 
	FieldSchemas *[]FieldSchema `json:"field_schemas,omitempty"`
	InvertedIndexGroupEncodingOptions *InvertedIndexGroupEncodingOptions `json:"inverted_index_group_encoding_options,omitempty"`
	FieldPartitions *[]FieldPartition `json:"fieldPartitions,omitempty"`
}

// NewCollection instantiates a new Collection object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewCollection() *Collection {
	this := Collection{}
	return &this
}

// NewCollectionWithDefaults instantiates a new Collection object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewCollectionWithDefaults() *Collection {
	this := Collection{}
	return &this
}

// GetCreatedAt returns the CreatedAt field value if set, zero value otherwise.
func (o *Collection) GetCreatedAt() string {
	if o == nil || o.CreatedAt == nil {
		var ret string
		return ret
	}
	return *o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetCreatedAtOk() (*string, bool) {
	if o == nil || o.CreatedAt == nil {
		return nil, false
	}
	return o.CreatedAt, true
}

// HasCreatedAt returns a boolean if a field has been set.
func (o *Collection) HasCreatedAt() bool {
	if o != nil && o.CreatedAt != nil {
		return true
	}

	return false
}

// SetCreatedAt gets a reference to the given string and assigns it to the CreatedAt field.
func (o *Collection) SetCreatedAt(v string) {
	o.CreatedAt = &v
}

// GetCreatedBy returns the CreatedBy field value if set, zero value otherwise.
func (o *Collection) GetCreatedBy() string {
	if o == nil || o.CreatedBy == nil {
		var ret string
		return ret
	}
	return *o.CreatedBy
}

// GetCreatedByOk returns a tuple with the CreatedBy field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetCreatedByOk() (*string, bool) {
	if o == nil || o.CreatedBy == nil {
		return nil, false
	}
	return o.CreatedBy, true
}

// HasCreatedBy returns a boolean if a field has been set.
func (o *Collection) HasCreatedBy() bool {
	if o != nil && o.CreatedBy != nil {
		return true
	}

	return false
}

// SetCreatedBy gets a reference to the given string and assigns it to the CreatedBy field.
func (o *Collection) SetCreatedBy(v string) {
	o.CreatedBy = &v
}

// GetName returns the Name field value if set, zero value otherwise.
func (o *Collection) GetName() string {
	if o == nil || o.Name == nil {
		var ret string
		return ret
	}
	return *o.Name
}

// GetNameOk returns a tuple with the Name field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetNameOk() (*string, bool) {
	if o == nil || o.Name == nil {
		return nil, false
	}
	return o.Name, true
}

// HasName returns a boolean if a field has been set.
func (o *Collection) HasName() bool {
	if o != nil && o.Name != nil {
		return true
	}

	return false
}

// SetName gets a reference to the given string and assigns it to the Name field.
func (o *Collection) SetName(v string) {
	o.Name = &v
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *Collection) GetDescription() string {
	if o == nil || o.Description == nil {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetDescriptionOk() (*string, bool) {
	if o == nil || o.Description == nil {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *Collection) HasDescription() bool {
	if o != nil && o.Description != nil {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *Collection) SetDescription(v string) {
	o.Description = &v
}

// GetWorkspace returns the Workspace field value if set, zero value otherwise.
func (o *Collection) GetWorkspace() string {
	if o == nil || o.Workspace == nil {
		var ret string
		return ret
	}
	return *o.Workspace
}

// GetWorkspaceOk returns a tuple with the Workspace field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetWorkspaceOk() (*string, bool) {
	if o == nil || o.Workspace == nil {
		return nil, false
	}
	return o.Workspace, true
}

// HasWorkspace returns a boolean if a field has been set.
func (o *Collection) HasWorkspace() bool {
	if o != nil && o.Workspace != nil {
		return true
	}

	return false
}

// SetWorkspace gets a reference to the given string and assigns it to the Workspace field.
func (o *Collection) SetWorkspace(v string) {
	o.Workspace = &v
}

// GetStatus returns the Status field value if set, zero value otherwise.
func (o *Collection) GetStatus() string {
	if o == nil || o.Status == nil {
		var ret string
		return ret
	}
	return *o.Status
}

// GetStatusOk returns a tuple with the Status field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetStatusOk() (*string, bool) {
	if o == nil || o.Status == nil {
		return nil, false
	}
	return o.Status, true
}

// HasStatus returns a boolean if a field has been set.
func (o *Collection) HasStatus() bool {
	if o != nil && o.Status != nil {
		return true
	}

	return false
}

// SetStatus gets a reference to the given string and assigns it to the Status field.
func (o *Collection) SetStatus(v string) {
	o.Status = &v
}

// GetSources returns the Sources field value if set, zero value otherwise.
func (o *Collection) GetSources() []Source {
	if o == nil || o.Sources == nil {
		var ret []Source
		return ret
	}
	return *o.Sources
}

// GetSourcesOk returns a tuple with the Sources field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetSourcesOk() (*[]Source, bool) {
	if o == nil || o.Sources == nil {
		return nil, false
	}
	return o.Sources, true
}

// HasSources returns a boolean if a field has been set.
func (o *Collection) HasSources() bool {
	if o != nil && o.Sources != nil {
		return true
	}

	return false
}

// SetSources gets a reference to the given []Source and assigns it to the Sources field.
func (o *Collection) SetSources(v []Source) {
	o.Sources = &v
}

// GetStats returns the Stats field value if set, zero value otherwise.
func (o *Collection) GetStats() CollectionStats {
	if o == nil || o.Stats == nil {
		var ret CollectionStats
		return ret
	}
	return *o.Stats
}

// GetStatsOk returns a tuple with the Stats field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetStatsOk() (*CollectionStats, bool) {
	if o == nil || o.Stats == nil {
		return nil, false
	}
	return o.Stats, true
}

// HasStats returns a boolean if a field has been set.
func (o *Collection) HasStats() bool {
	if o != nil && o.Stats != nil {
		return true
	}

	return false
}

// SetStats gets a reference to the given CollectionStats and assigns it to the Stats field.
func (o *Collection) SetStats(v CollectionStats) {
	o.Stats = &v
}

// GetRetentionSecs returns the RetentionSecs field value if set, zero value otherwise.
func (o *Collection) GetRetentionSecs() int64 {
	if o == nil || o.RetentionSecs == nil {
		var ret int64
		return ret
	}
	return *o.RetentionSecs
}

// GetRetentionSecsOk returns a tuple with the RetentionSecs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetRetentionSecsOk() (*int64, bool) {
	if o == nil || o.RetentionSecs == nil {
		return nil, false
	}
	return o.RetentionSecs, true
}

// HasRetentionSecs returns a boolean if a field has been set.
func (o *Collection) HasRetentionSecs() bool {
	if o != nil && o.RetentionSecs != nil {
		return true
	}

	return false
}

// SetRetentionSecs gets a reference to the given int64 and assigns it to the RetentionSecs field.
func (o *Collection) SetRetentionSecs(v int64) {
	o.RetentionSecs = &v
}

// GetFieldMappings returns the FieldMappings field value if set, zero value otherwise.
func (o *Collection) GetFieldMappings() []FieldMappingV2 {
	if o == nil || o.FieldMappings == nil {
		var ret []FieldMappingV2
		return ret
	}
	return *o.FieldMappings
}

// GetFieldMappingsOk returns a tuple with the FieldMappings field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetFieldMappingsOk() (*[]FieldMappingV2, bool) {
	if o == nil || o.FieldMappings == nil {
		return nil, false
	}
	return o.FieldMappings, true
}

// HasFieldMappings returns a boolean if a field has been set.
func (o *Collection) HasFieldMappings() bool {
	if o != nil && o.FieldMappings != nil {
		return true
	}

	return false
}

// SetFieldMappings gets a reference to the given []FieldMappingV2 and assigns it to the FieldMappings field.
func (o *Collection) SetFieldMappings(v []FieldMappingV2) {
	o.FieldMappings = &v
}

// GetClusteringKey returns the ClusteringKey field value if set, zero value otherwise.
func (o *Collection) GetClusteringKey() []FieldPartition {
	if o == nil || o.ClusteringKey == nil {
		var ret []FieldPartition
		return ret
	}
	return *o.ClusteringKey
}

// GetClusteringKeyOk returns a tuple with the ClusteringKey field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetClusteringKeyOk() (*[]FieldPartition, bool) {
	if o == nil || o.ClusteringKey == nil {
		return nil, false
	}
	return o.ClusteringKey, true
}

// HasClusteringKey returns a boolean if a field has been set.
func (o *Collection) HasClusteringKey() bool {
	if o != nil && o.ClusteringKey != nil {
		return true
	}

	return false
}

// SetClusteringKey gets a reference to the given []FieldPartition and assigns it to the ClusteringKey field.
func (o *Collection) SetClusteringKey(v []FieldPartition) {
	o.ClusteringKey = &v
}

// GetAliases returns the Aliases field value if set, zero value otherwise.
func (o *Collection) GetAliases() []Alias {
	if o == nil || o.Aliases == nil {
		var ret []Alias
		return ret
	}
	return *o.Aliases
}

// GetAliasesOk returns a tuple with the Aliases field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetAliasesOk() (*[]Alias, bool) {
	if o == nil || o.Aliases == nil {
		return nil, false
	}
	return o.Aliases, true
}

// HasAliases returns a boolean if a field has been set.
func (o *Collection) HasAliases() bool {
	if o != nil && o.Aliases != nil {
		return true
	}

	return false
}

// SetAliases gets a reference to the given []Alias and assigns it to the Aliases field.
func (o *Collection) SetAliases(v []Alias) {
	o.Aliases = &v
}

// GetFieldSchemas returns the FieldSchemas field value if set, zero value otherwise.
func (o *Collection) GetFieldSchemas() []FieldSchema {
	if o == nil || o.FieldSchemas == nil {
		var ret []FieldSchema
		return ret
	}
	return *o.FieldSchemas
}

// GetFieldSchemasOk returns a tuple with the FieldSchemas field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetFieldSchemasOk() (*[]FieldSchema, bool) {
	if o == nil || o.FieldSchemas == nil {
		return nil, false
	}
	return o.FieldSchemas, true
}

// HasFieldSchemas returns a boolean if a field has been set.
func (o *Collection) HasFieldSchemas() bool {
	if o != nil && o.FieldSchemas != nil {
		return true
	}

	return false
}

// SetFieldSchemas gets a reference to the given []FieldSchema and assigns it to the FieldSchemas field.
func (o *Collection) SetFieldSchemas(v []FieldSchema) {
	o.FieldSchemas = &v
}

// GetInvertedIndexGroupEncodingOptions returns the InvertedIndexGroupEncodingOptions field value if set, zero value otherwise.
func (o *Collection) GetInvertedIndexGroupEncodingOptions() InvertedIndexGroupEncodingOptions {
	if o == nil || o.InvertedIndexGroupEncodingOptions == nil {
		var ret InvertedIndexGroupEncodingOptions
		return ret
	}
	return *o.InvertedIndexGroupEncodingOptions
}

// GetInvertedIndexGroupEncodingOptionsOk returns a tuple with the InvertedIndexGroupEncodingOptions field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetInvertedIndexGroupEncodingOptionsOk() (*InvertedIndexGroupEncodingOptions, bool) {
	if o == nil || o.InvertedIndexGroupEncodingOptions == nil {
		return nil, false
	}
	return o.InvertedIndexGroupEncodingOptions, true
}

// HasInvertedIndexGroupEncodingOptions returns a boolean if a field has been set.
func (o *Collection) HasInvertedIndexGroupEncodingOptions() bool {
	if o != nil && o.InvertedIndexGroupEncodingOptions != nil {
		return true
	}

	return false
}

// SetInvertedIndexGroupEncodingOptions gets a reference to the given InvertedIndexGroupEncodingOptions and assigns it to the InvertedIndexGroupEncodingOptions field.
func (o *Collection) SetInvertedIndexGroupEncodingOptions(v InvertedIndexGroupEncodingOptions) {
	o.InvertedIndexGroupEncodingOptions = &v
}

// GetFieldPartitions returns the FieldPartitions field value if set, zero value otherwise.
func (o *Collection) GetFieldPartitions() []FieldPartition {
	if o == nil || o.FieldPartitions == nil {
		var ret []FieldPartition
		return ret
	}
	return *o.FieldPartitions
}

// GetFieldPartitionsOk returns a tuple with the FieldPartitions field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Collection) GetFieldPartitionsOk() (*[]FieldPartition, bool) {
	if o == nil || o.FieldPartitions == nil {
		return nil, false
	}
	return o.FieldPartitions, true
}

// HasFieldPartitions returns a boolean if a field has been set.
func (o *Collection) HasFieldPartitions() bool {
	if o != nil && o.FieldPartitions != nil {
		return true
	}

	return false
}

// SetFieldPartitions gets a reference to the given []FieldPartition and assigns it to the FieldPartitions field.
func (o *Collection) SetFieldPartitions(v []FieldPartition) {
	o.FieldPartitions = &v
}

func (o Collection) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.CreatedAt != nil {
		toSerialize["created_at"] = o.CreatedAt
	}
	if o.CreatedBy != nil {
		toSerialize["created_by"] = o.CreatedBy
	}
	if o.Name != nil {
		toSerialize["name"] = o.Name
	}
	if o.Description != nil {
		toSerialize["description"] = o.Description
	}
	if o.Workspace != nil {
		toSerialize["workspace"] = o.Workspace
	}
	if o.Status != nil {
		toSerialize["status"] = o.Status
	}
	if o.Sources != nil {
		toSerialize["sources"] = o.Sources
	}
	if o.Stats != nil {
		toSerialize["stats"] = o.Stats
	}
	if o.RetentionSecs != nil {
		toSerialize["retention_secs"] = o.RetentionSecs
	}
	if o.FieldMappings != nil {
		toSerialize["field_mappings"] = o.FieldMappings
	}
	if o.ClusteringKey != nil {
		toSerialize["clustering_key"] = o.ClusteringKey
	}
	if o.Aliases != nil {
		toSerialize["aliases"] = o.Aliases
	}
	if o.FieldSchemas != nil {
		toSerialize["field_schemas"] = o.FieldSchemas
	}
	if o.InvertedIndexGroupEncodingOptions != nil {
		toSerialize["inverted_index_group_encoding_options"] = o.InvertedIndexGroupEncodingOptions
	}
	if o.FieldPartitions != nil {
		toSerialize["fieldPartitions"] = o.FieldPartitions
	}
	return json.Marshal(toSerialize)
}

type NullableCollection struct {
	value *Collection
	isSet bool
}

func (v NullableCollection) Get() *Collection {
	return v.value
}

func (v *NullableCollection) Set(val *Collection) {
	v.value = val
	v.isSet = true
}

func (v NullableCollection) IsSet() bool {
	return v.isSet
}

func (v *NullableCollection) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableCollection(val *Collection) *NullableCollection {
	return &NullableCollection{value: val, isSet: true}
}

func (v NullableCollection) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableCollection) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

