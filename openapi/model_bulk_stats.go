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

// checks if the BulkStats type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &BulkStats{}

// BulkStats struct for BulkStats
type BulkStats struct {
	// Size in bytes of documents downloaded from source during an ongoing or completed bulk ingest. This includes documents that are dropped and reingested.
	DataDownloadedBytes *int64 `json:"data_downloaded_bytes,omitempty"`
	// Size in bytes of documents indexed. This is the total size of documents after transformations and dropping before indexes are built.
	DataIndexedBytes *int64 `json:"data_indexed_bytes,omitempty"`
	// Throughput of documents indexed in the last minute measured in bytes/s. This is based off the data_indexed_bytes size. Throughput during the download stage is shown on a per-source granularity in the sources field of the Collection response.
	DataIndexedThroughputBytes *float64 `json:"data_indexed_throughput_bytes,omitempty"`
	// Number of documents downloaded from source during an ongoing or completed bulk ingest. This includes documents that are dropped and reingested.
	DocumentsDownloaded *int64 `json:"documents_downloaded,omitempty"`
	// Bulk ingest compute units in milliseconds used for downloading documents.
	DownloadComputeMs *int64 `json:"download_compute_ms,omitempty"`
	// ISO-8601 date of when the downloading stage was completed.
	DownloadingStageDoneAt *string `json:"downloading_stage_done_at,omitempty"`
	// ISO-8601 date of when the finalizing stage was completed.
	FinalizingStageDoneAt *string `json:"finalizing_stage_done_at,omitempty"`
	// Bulk ingest compute units in milliseconds used for indexing documents.
	IndexComputeMs *int64 `json:"index_compute_ms,omitempty"`
	// ISO-8601 date of when the indexing stage was completed.
	IndexingStageDoneAt *string `json:"indexing_stage_done_at,omitempty"`
	// ISO-8601 date of when the initializing stage was completed.
	InitializingStageDoneAt *string `json:"initializing_stage_done_at,omitempty"`
	// Size in bytes of documents before being indexed. This is the total size of documents after decompression, transformations, and dropping. This is equal to data_indexed_bytes after the indexing stage is done unless there are retries during indexing the data.
	PreIndexSizeBytes *int64 `json:"pre_index_size_bytes,omitempty"`
	// ISO-8601 date of when the provisioning stage was completed.
	ProvisioningStageDoneAt *string `json:"provisioning_stage_done_at,omitempty"`
	// ISO-8601 date of when the bulk ingest was started.
	StartedAt *string `json:"started_at,omitempty"`
	// Total size of indexes after the completed bulk ingest. This is the same as collection size.
	TotalIndexSizeBytes *int64 `json:"total_index_size_bytes,omitempty"`
	// Bulk ingest compute units in milliseconds used for ingest transformation.
	TransformationComputeMs *int64 `json:"transformation_compute_ms,omitempty"`
}

// NewBulkStats instantiates a new BulkStats object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBulkStats() *BulkStats {
	this := BulkStats{}
	return &this
}

// NewBulkStatsWithDefaults instantiates a new BulkStats object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBulkStatsWithDefaults() *BulkStats {
	this := BulkStats{}
	return &this
}

// GetDataDownloadedBytes returns the DataDownloadedBytes field value if set, zero value otherwise.
func (o *BulkStats) GetDataDownloadedBytes() int64 {
	if o == nil || IsNil(o.DataDownloadedBytes) {
		var ret int64
		return ret
	}
	return *o.DataDownloadedBytes
}

// GetDataDownloadedBytesOk returns a tuple with the DataDownloadedBytes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetDataDownloadedBytesOk() (*int64, bool) {
	if o == nil || IsNil(o.DataDownloadedBytes) {
		return nil, false
	}
	return o.DataDownloadedBytes, true
}

// HasDataDownloadedBytes returns a boolean if a field has been set.
func (o *BulkStats) HasDataDownloadedBytes() bool {
	if o != nil && !IsNil(o.DataDownloadedBytes) {
		return true
	}

	return false
}

// SetDataDownloadedBytes gets a reference to the given int64 and assigns it to the DataDownloadedBytes field.
func (o *BulkStats) SetDataDownloadedBytes(v int64) {
	o.DataDownloadedBytes = &v
}

// GetDataIndexedBytes returns the DataIndexedBytes field value if set, zero value otherwise.
func (o *BulkStats) GetDataIndexedBytes() int64 {
	if o == nil || IsNil(o.DataIndexedBytes) {
		var ret int64
		return ret
	}
	return *o.DataIndexedBytes
}

// GetDataIndexedBytesOk returns a tuple with the DataIndexedBytes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetDataIndexedBytesOk() (*int64, bool) {
	if o == nil || IsNil(o.DataIndexedBytes) {
		return nil, false
	}
	return o.DataIndexedBytes, true
}

// HasDataIndexedBytes returns a boolean if a field has been set.
func (o *BulkStats) HasDataIndexedBytes() bool {
	if o != nil && !IsNil(o.DataIndexedBytes) {
		return true
	}

	return false
}

// SetDataIndexedBytes gets a reference to the given int64 and assigns it to the DataIndexedBytes field.
func (o *BulkStats) SetDataIndexedBytes(v int64) {
	o.DataIndexedBytes = &v
}

// GetDataIndexedThroughputBytes returns the DataIndexedThroughputBytes field value if set, zero value otherwise.
func (o *BulkStats) GetDataIndexedThroughputBytes() float64 {
	if o == nil || IsNil(o.DataIndexedThroughputBytes) {
		var ret float64
		return ret
	}
	return *o.DataIndexedThroughputBytes
}

// GetDataIndexedThroughputBytesOk returns a tuple with the DataIndexedThroughputBytes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetDataIndexedThroughputBytesOk() (*float64, bool) {
	if o == nil || IsNil(o.DataIndexedThroughputBytes) {
		return nil, false
	}
	return o.DataIndexedThroughputBytes, true
}

// HasDataIndexedThroughputBytes returns a boolean if a field has been set.
func (o *BulkStats) HasDataIndexedThroughputBytes() bool {
	if o != nil && !IsNil(o.DataIndexedThroughputBytes) {
		return true
	}

	return false
}

// SetDataIndexedThroughputBytes gets a reference to the given float64 and assigns it to the DataIndexedThroughputBytes field.
func (o *BulkStats) SetDataIndexedThroughputBytes(v float64) {
	o.DataIndexedThroughputBytes = &v
}

// GetDocumentsDownloaded returns the DocumentsDownloaded field value if set, zero value otherwise.
func (o *BulkStats) GetDocumentsDownloaded() int64 {
	if o == nil || IsNil(o.DocumentsDownloaded) {
		var ret int64
		return ret
	}
	return *o.DocumentsDownloaded
}

// GetDocumentsDownloadedOk returns a tuple with the DocumentsDownloaded field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetDocumentsDownloadedOk() (*int64, bool) {
	if o == nil || IsNil(o.DocumentsDownloaded) {
		return nil, false
	}
	return o.DocumentsDownloaded, true
}

// HasDocumentsDownloaded returns a boolean if a field has been set.
func (o *BulkStats) HasDocumentsDownloaded() bool {
	if o != nil && !IsNil(o.DocumentsDownloaded) {
		return true
	}

	return false
}

// SetDocumentsDownloaded gets a reference to the given int64 and assigns it to the DocumentsDownloaded field.
func (o *BulkStats) SetDocumentsDownloaded(v int64) {
	o.DocumentsDownloaded = &v
}

// GetDownloadComputeMs returns the DownloadComputeMs field value if set, zero value otherwise.
func (o *BulkStats) GetDownloadComputeMs() int64 {
	if o == nil || IsNil(o.DownloadComputeMs) {
		var ret int64
		return ret
	}
	return *o.DownloadComputeMs
}

// GetDownloadComputeMsOk returns a tuple with the DownloadComputeMs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetDownloadComputeMsOk() (*int64, bool) {
	if o == nil || IsNil(o.DownloadComputeMs) {
		return nil, false
	}
	return o.DownloadComputeMs, true
}

// HasDownloadComputeMs returns a boolean if a field has been set.
func (o *BulkStats) HasDownloadComputeMs() bool {
	if o != nil && !IsNil(o.DownloadComputeMs) {
		return true
	}

	return false
}

// SetDownloadComputeMs gets a reference to the given int64 and assigns it to the DownloadComputeMs field.
func (o *BulkStats) SetDownloadComputeMs(v int64) {
	o.DownloadComputeMs = &v
}

// GetDownloadingStageDoneAt returns the DownloadingStageDoneAt field value if set, zero value otherwise.
func (o *BulkStats) GetDownloadingStageDoneAt() string {
	if o == nil || IsNil(o.DownloadingStageDoneAt) {
		var ret string
		return ret
	}
	return *o.DownloadingStageDoneAt
}

// GetDownloadingStageDoneAtOk returns a tuple with the DownloadingStageDoneAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetDownloadingStageDoneAtOk() (*string, bool) {
	if o == nil || IsNil(o.DownloadingStageDoneAt) {
		return nil, false
	}
	return o.DownloadingStageDoneAt, true
}

// HasDownloadingStageDoneAt returns a boolean if a field has been set.
func (o *BulkStats) HasDownloadingStageDoneAt() bool {
	if o != nil && !IsNil(o.DownloadingStageDoneAt) {
		return true
	}

	return false
}

// SetDownloadingStageDoneAt gets a reference to the given string and assigns it to the DownloadingStageDoneAt field.
func (o *BulkStats) SetDownloadingStageDoneAt(v string) {
	o.DownloadingStageDoneAt = &v
}

// GetFinalizingStageDoneAt returns the FinalizingStageDoneAt field value if set, zero value otherwise.
func (o *BulkStats) GetFinalizingStageDoneAt() string {
	if o == nil || IsNil(o.FinalizingStageDoneAt) {
		var ret string
		return ret
	}
	return *o.FinalizingStageDoneAt
}

// GetFinalizingStageDoneAtOk returns a tuple with the FinalizingStageDoneAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetFinalizingStageDoneAtOk() (*string, bool) {
	if o == nil || IsNil(o.FinalizingStageDoneAt) {
		return nil, false
	}
	return o.FinalizingStageDoneAt, true
}

// HasFinalizingStageDoneAt returns a boolean if a field has been set.
func (o *BulkStats) HasFinalizingStageDoneAt() bool {
	if o != nil && !IsNil(o.FinalizingStageDoneAt) {
		return true
	}

	return false
}

// SetFinalizingStageDoneAt gets a reference to the given string and assigns it to the FinalizingStageDoneAt field.
func (o *BulkStats) SetFinalizingStageDoneAt(v string) {
	o.FinalizingStageDoneAt = &v
}

// GetIndexComputeMs returns the IndexComputeMs field value if set, zero value otherwise.
func (o *BulkStats) GetIndexComputeMs() int64 {
	if o == nil || IsNil(o.IndexComputeMs) {
		var ret int64
		return ret
	}
	return *o.IndexComputeMs
}

// GetIndexComputeMsOk returns a tuple with the IndexComputeMs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetIndexComputeMsOk() (*int64, bool) {
	if o == nil || IsNil(o.IndexComputeMs) {
		return nil, false
	}
	return o.IndexComputeMs, true
}

// HasIndexComputeMs returns a boolean if a field has been set.
func (o *BulkStats) HasIndexComputeMs() bool {
	if o != nil && !IsNil(o.IndexComputeMs) {
		return true
	}

	return false
}

// SetIndexComputeMs gets a reference to the given int64 and assigns it to the IndexComputeMs field.
func (o *BulkStats) SetIndexComputeMs(v int64) {
	o.IndexComputeMs = &v
}

// GetIndexingStageDoneAt returns the IndexingStageDoneAt field value if set, zero value otherwise.
func (o *BulkStats) GetIndexingStageDoneAt() string {
	if o == nil || IsNil(o.IndexingStageDoneAt) {
		var ret string
		return ret
	}
	return *o.IndexingStageDoneAt
}

// GetIndexingStageDoneAtOk returns a tuple with the IndexingStageDoneAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetIndexingStageDoneAtOk() (*string, bool) {
	if o == nil || IsNil(o.IndexingStageDoneAt) {
		return nil, false
	}
	return o.IndexingStageDoneAt, true
}

// HasIndexingStageDoneAt returns a boolean if a field has been set.
func (o *BulkStats) HasIndexingStageDoneAt() bool {
	if o != nil && !IsNil(o.IndexingStageDoneAt) {
		return true
	}

	return false
}

// SetIndexingStageDoneAt gets a reference to the given string and assigns it to the IndexingStageDoneAt field.
func (o *BulkStats) SetIndexingStageDoneAt(v string) {
	o.IndexingStageDoneAt = &v
}

// GetInitializingStageDoneAt returns the InitializingStageDoneAt field value if set, zero value otherwise.
func (o *BulkStats) GetInitializingStageDoneAt() string {
	if o == nil || IsNil(o.InitializingStageDoneAt) {
		var ret string
		return ret
	}
	return *o.InitializingStageDoneAt
}

// GetInitializingStageDoneAtOk returns a tuple with the InitializingStageDoneAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetInitializingStageDoneAtOk() (*string, bool) {
	if o == nil || IsNil(o.InitializingStageDoneAt) {
		return nil, false
	}
	return o.InitializingStageDoneAt, true
}

// HasInitializingStageDoneAt returns a boolean if a field has been set.
func (o *BulkStats) HasInitializingStageDoneAt() bool {
	if o != nil && !IsNil(o.InitializingStageDoneAt) {
		return true
	}

	return false
}

// SetInitializingStageDoneAt gets a reference to the given string and assigns it to the InitializingStageDoneAt field.
func (o *BulkStats) SetInitializingStageDoneAt(v string) {
	o.InitializingStageDoneAt = &v
}

// GetPreIndexSizeBytes returns the PreIndexSizeBytes field value if set, zero value otherwise.
func (o *BulkStats) GetPreIndexSizeBytes() int64 {
	if o == nil || IsNil(o.PreIndexSizeBytes) {
		var ret int64
		return ret
	}
	return *o.PreIndexSizeBytes
}

// GetPreIndexSizeBytesOk returns a tuple with the PreIndexSizeBytes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetPreIndexSizeBytesOk() (*int64, bool) {
	if o == nil || IsNil(o.PreIndexSizeBytes) {
		return nil, false
	}
	return o.PreIndexSizeBytes, true
}

// HasPreIndexSizeBytes returns a boolean if a field has been set.
func (o *BulkStats) HasPreIndexSizeBytes() bool {
	if o != nil && !IsNil(o.PreIndexSizeBytes) {
		return true
	}

	return false
}

// SetPreIndexSizeBytes gets a reference to the given int64 and assigns it to the PreIndexSizeBytes field.
func (o *BulkStats) SetPreIndexSizeBytes(v int64) {
	o.PreIndexSizeBytes = &v
}

// GetProvisioningStageDoneAt returns the ProvisioningStageDoneAt field value if set, zero value otherwise.
func (o *BulkStats) GetProvisioningStageDoneAt() string {
	if o == nil || IsNil(o.ProvisioningStageDoneAt) {
		var ret string
		return ret
	}
	return *o.ProvisioningStageDoneAt
}

// GetProvisioningStageDoneAtOk returns a tuple with the ProvisioningStageDoneAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetProvisioningStageDoneAtOk() (*string, bool) {
	if o == nil || IsNil(o.ProvisioningStageDoneAt) {
		return nil, false
	}
	return o.ProvisioningStageDoneAt, true
}

// HasProvisioningStageDoneAt returns a boolean if a field has been set.
func (o *BulkStats) HasProvisioningStageDoneAt() bool {
	if o != nil && !IsNil(o.ProvisioningStageDoneAt) {
		return true
	}

	return false
}

// SetProvisioningStageDoneAt gets a reference to the given string and assigns it to the ProvisioningStageDoneAt field.
func (o *BulkStats) SetProvisioningStageDoneAt(v string) {
	o.ProvisioningStageDoneAt = &v
}

// GetStartedAt returns the StartedAt field value if set, zero value otherwise.
func (o *BulkStats) GetStartedAt() string {
	if o == nil || IsNil(o.StartedAt) {
		var ret string
		return ret
	}
	return *o.StartedAt
}

// GetStartedAtOk returns a tuple with the StartedAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetStartedAtOk() (*string, bool) {
	if o == nil || IsNil(o.StartedAt) {
		return nil, false
	}
	return o.StartedAt, true
}

// HasStartedAt returns a boolean if a field has been set.
func (o *BulkStats) HasStartedAt() bool {
	if o != nil && !IsNil(o.StartedAt) {
		return true
	}

	return false
}

// SetStartedAt gets a reference to the given string and assigns it to the StartedAt field.
func (o *BulkStats) SetStartedAt(v string) {
	o.StartedAt = &v
}

// GetTotalIndexSizeBytes returns the TotalIndexSizeBytes field value if set, zero value otherwise.
func (o *BulkStats) GetTotalIndexSizeBytes() int64 {
	if o == nil || IsNil(o.TotalIndexSizeBytes) {
		var ret int64
		return ret
	}
	return *o.TotalIndexSizeBytes
}

// GetTotalIndexSizeBytesOk returns a tuple with the TotalIndexSizeBytes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetTotalIndexSizeBytesOk() (*int64, bool) {
	if o == nil || IsNil(o.TotalIndexSizeBytes) {
		return nil, false
	}
	return o.TotalIndexSizeBytes, true
}

// HasTotalIndexSizeBytes returns a boolean if a field has been set.
func (o *BulkStats) HasTotalIndexSizeBytes() bool {
	if o != nil && !IsNil(o.TotalIndexSizeBytes) {
		return true
	}

	return false
}

// SetTotalIndexSizeBytes gets a reference to the given int64 and assigns it to the TotalIndexSizeBytes field.
func (o *BulkStats) SetTotalIndexSizeBytes(v int64) {
	o.TotalIndexSizeBytes = &v
}

// GetTransformationComputeMs returns the TransformationComputeMs field value if set, zero value otherwise.
func (o *BulkStats) GetTransformationComputeMs() int64 {
	if o == nil || IsNil(o.TransformationComputeMs) {
		var ret int64
		return ret
	}
	return *o.TransformationComputeMs
}

// GetTransformationComputeMsOk returns a tuple with the TransformationComputeMs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkStats) GetTransformationComputeMsOk() (*int64, bool) {
	if o == nil || IsNil(o.TransformationComputeMs) {
		return nil, false
	}
	return o.TransformationComputeMs, true
}

// HasTransformationComputeMs returns a boolean if a field has been set.
func (o *BulkStats) HasTransformationComputeMs() bool {
	if o != nil && !IsNil(o.TransformationComputeMs) {
		return true
	}

	return false
}

// SetTransformationComputeMs gets a reference to the given int64 and assigns it to the TransformationComputeMs field.
func (o *BulkStats) SetTransformationComputeMs(v int64) {
	o.TransformationComputeMs = &v
}

func (o BulkStats) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o BulkStats) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.DataDownloadedBytes) {
		toSerialize["data_downloaded_bytes"] = o.DataDownloadedBytes
	}
	if !IsNil(o.DataIndexedBytes) {
		toSerialize["data_indexed_bytes"] = o.DataIndexedBytes
	}
	if !IsNil(o.DataIndexedThroughputBytes) {
		toSerialize["data_indexed_throughput_bytes"] = o.DataIndexedThroughputBytes
	}
	if !IsNil(o.DocumentsDownloaded) {
		toSerialize["documents_downloaded"] = o.DocumentsDownloaded
	}
	if !IsNil(o.DownloadComputeMs) {
		toSerialize["download_compute_ms"] = o.DownloadComputeMs
	}
	if !IsNil(o.DownloadingStageDoneAt) {
		toSerialize["downloading_stage_done_at"] = o.DownloadingStageDoneAt
	}
	if !IsNil(o.FinalizingStageDoneAt) {
		toSerialize["finalizing_stage_done_at"] = o.FinalizingStageDoneAt
	}
	if !IsNil(o.IndexComputeMs) {
		toSerialize["index_compute_ms"] = o.IndexComputeMs
	}
	if !IsNil(o.IndexingStageDoneAt) {
		toSerialize["indexing_stage_done_at"] = o.IndexingStageDoneAt
	}
	if !IsNil(o.InitializingStageDoneAt) {
		toSerialize["initializing_stage_done_at"] = o.InitializingStageDoneAt
	}
	if !IsNil(o.PreIndexSizeBytes) {
		toSerialize["pre_index_size_bytes"] = o.PreIndexSizeBytes
	}
	if !IsNil(o.ProvisioningStageDoneAt) {
		toSerialize["provisioning_stage_done_at"] = o.ProvisioningStageDoneAt
	}
	if !IsNil(o.StartedAt) {
		toSerialize["started_at"] = o.StartedAt
	}
	if !IsNil(o.TotalIndexSizeBytes) {
		toSerialize["total_index_size_bytes"] = o.TotalIndexSizeBytes
	}
	if !IsNil(o.TransformationComputeMs) {
		toSerialize["transformation_compute_ms"] = o.TransformationComputeMs
	}
	return toSerialize, nil
}

type NullableBulkStats struct {
	value *BulkStats
	isSet bool
}

func (v NullableBulkStats) Get() *BulkStats {
	return v.value
}

func (v *NullableBulkStats) Set(val *BulkStats) {
	v.value = val
	v.isSet = true
}

func (v NullableBulkStats) IsSet() bool {
	return v.isSet
}

func (v *NullableBulkStats) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBulkStats(val *BulkStats) *NullableBulkStats {
	return &NullableBulkStats{value: val, isSet: true}
}

func (v NullableBulkStats) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBulkStats) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

