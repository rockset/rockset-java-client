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

// Source Details about the data source for the given collection. Only one of the following fields are allowed to be defined. Only collections can act as data sources for views. 
type Source struct {
	AzureBlobStorage *SourceAzureBlobStorage `json:"azure_blob_storage,omitempty"`
	AzureEventHubs *SourceAzureEventHubs `json:"azure_event_hubs,omitempty"`
	AzureServiceBus *SourceAzureServiceBus `json:"azure_service_bus,omitempty"`
	Dynamodb *SourceDynamoDb `json:"dynamodb,omitempty"`
	FileUpload *SourceFileUpload `json:"file_upload,omitempty"`
	FormatParams *FormatParams `json:"format_params,omitempty"`
	Gcs *SourceGcs `json:"gcs,omitempty"`
	// Unique source identifier.
	Id *string `json:"id,omitempty"`
	IngestTransformation *FieldMappingQuery `json:"ingest_transformation,omitempty"`
	// Name of integration to use.
	IntegrationName *string `json:"integration_name,omitempty"`
	Kafka *SourceKafka `json:"kafka,omitempty"`
	Kinesis *SourceKinesis `json:"kinesis,omitempty"`
	Mongodb *SourceMongoDb `json:"mongodb,omitempty"`
	S3 *SourceS3 `json:"s3,omitempty"`
	Snowflake *SourceSnowflake `json:"snowflake,omitempty"`
	Status *Status `json:"status,omitempty"`
	// ISO-8601 date when source was suspended, if suspended
	SuspendedAt *string `json:"suspended_at,omitempty"`
	System *SourceSystem `json:"system,omitempty"`
}

// NewSource instantiates a new Source object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewSource() *Source {
	this := Source{}
	return &this
}

// NewSourceWithDefaults instantiates a new Source object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewSourceWithDefaults() *Source {
	this := Source{}
	return &this
}

// GetAzureBlobStorage returns the AzureBlobStorage field value if set, zero value otherwise.
func (o *Source) GetAzureBlobStorage() SourceAzureBlobStorage {
	if o == nil || o.AzureBlobStorage == nil {
		var ret SourceAzureBlobStorage
		return ret
	}
	return *o.AzureBlobStorage
}

// GetAzureBlobStorageOk returns a tuple with the AzureBlobStorage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetAzureBlobStorageOk() (*SourceAzureBlobStorage, bool) {
	if o == nil || o.AzureBlobStorage == nil {
		return nil, false
	}
	return o.AzureBlobStorage, true
}

// HasAzureBlobStorage returns a boolean if a field has been set.
func (o *Source) HasAzureBlobStorage() bool {
	if o != nil && o.AzureBlobStorage != nil {
		return true
	}

	return false
}

// SetAzureBlobStorage gets a reference to the given SourceAzureBlobStorage and assigns it to the AzureBlobStorage field.
func (o *Source) SetAzureBlobStorage(v SourceAzureBlobStorage) {
	o.AzureBlobStorage = &v
}

// GetAzureEventHubs returns the AzureEventHubs field value if set, zero value otherwise.
func (o *Source) GetAzureEventHubs() SourceAzureEventHubs {
	if o == nil || o.AzureEventHubs == nil {
		var ret SourceAzureEventHubs
		return ret
	}
	return *o.AzureEventHubs
}

// GetAzureEventHubsOk returns a tuple with the AzureEventHubs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetAzureEventHubsOk() (*SourceAzureEventHubs, bool) {
	if o == nil || o.AzureEventHubs == nil {
		return nil, false
	}
	return o.AzureEventHubs, true
}

// HasAzureEventHubs returns a boolean if a field has been set.
func (o *Source) HasAzureEventHubs() bool {
	if o != nil && o.AzureEventHubs != nil {
		return true
	}

	return false
}

// SetAzureEventHubs gets a reference to the given SourceAzureEventHubs and assigns it to the AzureEventHubs field.
func (o *Source) SetAzureEventHubs(v SourceAzureEventHubs) {
	o.AzureEventHubs = &v
}

// GetAzureServiceBus returns the AzureServiceBus field value if set, zero value otherwise.
func (o *Source) GetAzureServiceBus() SourceAzureServiceBus {
	if o == nil || o.AzureServiceBus == nil {
		var ret SourceAzureServiceBus
		return ret
	}
	return *o.AzureServiceBus
}

// GetAzureServiceBusOk returns a tuple with the AzureServiceBus field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetAzureServiceBusOk() (*SourceAzureServiceBus, bool) {
	if o == nil || o.AzureServiceBus == nil {
		return nil, false
	}
	return o.AzureServiceBus, true
}

// HasAzureServiceBus returns a boolean if a field has been set.
func (o *Source) HasAzureServiceBus() bool {
	if o != nil && o.AzureServiceBus != nil {
		return true
	}

	return false
}

// SetAzureServiceBus gets a reference to the given SourceAzureServiceBus and assigns it to the AzureServiceBus field.
func (o *Source) SetAzureServiceBus(v SourceAzureServiceBus) {
	o.AzureServiceBus = &v
}

// GetDynamodb returns the Dynamodb field value if set, zero value otherwise.
func (o *Source) GetDynamodb() SourceDynamoDb {
	if o == nil || o.Dynamodb == nil {
		var ret SourceDynamoDb
		return ret
	}
	return *o.Dynamodb
}

// GetDynamodbOk returns a tuple with the Dynamodb field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetDynamodbOk() (*SourceDynamoDb, bool) {
	if o == nil || o.Dynamodb == nil {
		return nil, false
	}
	return o.Dynamodb, true
}

// HasDynamodb returns a boolean if a field has been set.
func (o *Source) HasDynamodb() bool {
	if o != nil && o.Dynamodb != nil {
		return true
	}

	return false
}

// SetDynamodb gets a reference to the given SourceDynamoDb and assigns it to the Dynamodb field.
func (o *Source) SetDynamodb(v SourceDynamoDb) {
	o.Dynamodb = &v
}

// GetFileUpload returns the FileUpload field value if set, zero value otherwise.
func (o *Source) GetFileUpload() SourceFileUpload {
	if o == nil || o.FileUpload == nil {
		var ret SourceFileUpload
		return ret
	}
	return *o.FileUpload
}

// GetFileUploadOk returns a tuple with the FileUpload field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetFileUploadOk() (*SourceFileUpload, bool) {
	if o == nil || o.FileUpload == nil {
		return nil, false
	}
	return o.FileUpload, true
}

// HasFileUpload returns a boolean if a field has been set.
func (o *Source) HasFileUpload() bool {
	if o != nil && o.FileUpload != nil {
		return true
	}

	return false
}

// SetFileUpload gets a reference to the given SourceFileUpload and assigns it to the FileUpload field.
func (o *Source) SetFileUpload(v SourceFileUpload) {
	o.FileUpload = &v
}

// GetFormatParams returns the FormatParams field value if set, zero value otherwise.
func (o *Source) GetFormatParams() FormatParams {
	if o == nil || o.FormatParams == nil {
		var ret FormatParams
		return ret
	}
	return *o.FormatParams
}

// GetFormatParamsOk returns a tuple with the FormatParams field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetFormatParamsOk() (*FormatParams, bool) {
	if o == nil || o.FormatParams == nil {
		return nil, false
	}
	return o.FormatParams, true
}

// HasFormatParams returns a boolean if a field has been set.
func (o *Source) HasFormatParams() bool {
	if o != nil && o.FormatParams != nil {
		return true
	}

	return false
}

// SetFormatParams gets a reference to the given FormatParams and assigns it to the FormatParams field.
func (o *Source) SetFormatParams(v FormatParams) {
	o.FormatParams = &v
}

// GetGcs returns the Gcs field value if set, zero value otherwise.
func (o *Source) GetGcs() SourceGcs {
	if o == nil || o.Gcs == nil {
		var ret SourceGcs
		return ret
	}
	return *o.Gcs
}

// GetGcsOk returns a tuple with the Gcs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetGcsOk() (*SourceGcs, bool) {
	if o == nil || o.Gcs == nil {
		return nil, false
	}
	return o.Gcs, true
}

// HasGcs returns a boolean if a field has been set.
func (o *Source) HasGcs() bool {
	if o != nil && o.Gcs != nil {
		return true
	}

	return false
}

// SetGcs gets a reference to the given SourceGcs and assigns it to the Gcs field.
func (o *Source) SetGcs(v SourceGcs) {
	o.Gcs = &v
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *Source) GetId() string {
	if o == nil || o.Id == nil {
		var ret string
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetIdOk() (*string, bool) {
	if o == nil || o.Id == nil {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *Source) HasId() bool {
	if o != nil && o.Id != nil {
		return true
	}

	return false
}

// SetId gets a reference to the given string and assigns it to the Id field.
func (o *Source) SetId(v string) {
	o.Id = &v
}

// GetIngestTransformation returns the IngestTransformation field value if set, zero value otherwise.
func (o *Source) GetIngestTransformation() FieldMappingQuery {
	if o == nil || o.IngestTransformation == nil {
		var ret FieldMappingQuery
		return ret
	}
	return *o.IngestTransformation
}

// GetIngestTransformationOk returns a tuple with the IngestTransformation field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetIngestTransformationOk() (*FieldMappingQuery, bool) {
	if o == nil || o.IngestTransformation == nil {
		return nil, false
	}
	return o.IngestTransformation, true
}

// HasIngestTransformation returns a boolean if a field has been set.
func (o *Source) HasIngestTransformation() bool {
	if o != nil && o.IngestTransformation != nil {
		return true
	}

	return false
}

// SetIngestTransformation gets a reference to the given FieldMappingQuery and assigns it to the IngestTransformation field.
func (o *Source) SetIngestTransformation(v FieldMappingQuery) {
	o.IngestTransformation = &v
}

// GetIntegrationName returns the IntegrationName field value if set, zero value otherwise.
func (o *Source) GetIntegrationName() string {
	if o == nil || o.IntegrationName == nil {
		var ret string
		return ret
	}
	return *o.IntegrationName
}

// GetIntegrationNameOk returns a tuple with the IntegrationName field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetIntegrationNameOk() (*string, bool) {
	if o == nil || o.IntegrationName == nil {
		return nil, false
	}
	return o.IntegrationName, true
}

// HasIntegrationName returns a boolean if a field has been set.
func (o *Source) HasIntegrationName() bool {
	if o != nil && o.IntegrationName != nil {
		return true
	}

	return false
}

// SetIntegrationName gets a reference to the given string and assigns it to the IntegrationName field.
func (o *Source) SetIntegrationName(v string) {
	o.IntegrationName = &v
}

// GetKafka returns the Kafka field value if set, zero value otherwise.
func (o *Source) GetKafka() SourceKafka {
	if o == nil || o.Kafka == nil {
		var ret SourceKafka
		return ret
	}
	return *o.Kafka
}

// GetKafkaOk returns a tuple with the Kafka field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetKafkaOk() (*SourceKafka, bool) {
	if o == nil || o.Kafka == nil {
		return nil, false
	}
	return o.Kafka, true
}

// HasKafka returns a boolean if a field has been set.
func (o *Source) HasKafka() bool {
	if o != nil && o.Kafka != nil {
		return true
	}

	return false
}

// SetKafka gets a reference to the given SourceKafka and assigns it to the Kafka field.
func (o *Source) SetKafka(v SourceKafka) {
	o.Kafka = &v
}

// GetKinesis returns the Kinesis field value if set, zero value otherwise.
func (o *Source) GetKinesis() SourceKinesis {
	if o == nil || o.Kinesis == nil {
		var ret SourceKinesis
		return ret
	}
	return *o.Kinesis
}

// GetKinesisOk returns a tuple with the Kinesis field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetKinesisOk() (*SourceKinesis, bool) {
	if o == nil || o.Kinesis == nil {
		return nil, false
	}
	return o.Kinesis, true
}

// HasKinesis returns a boolean if a field has been set.
func (o *Source) HasKinesis() bool {
	if o != nil && o.Kinesis != nil {
		return true
	}

	return false
}

// SetKinesis gets a reference to the given SourceKinesis and assigns it to the Kinesis field.
func (o *Source) SetKinesis(v SourceKinesis) {
	o.Kinesis = &v
}

// GetMongodb returns the Mongodb field value if set, zero value otherwise.
func (o *Source) GetMongodb() SourceMongoDb {
	if o == nil || o.Mongodb == nil {
		var ret SourceMongoDb
		return ret
	}
	return *o.Mongodb
}

// GetMongodbOk returns a tuple with the Mongodb field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetMongodbOk() (*SourceMongoDb, bool) {
	if o == nil || o.Mongodb == nil {
		return nil, false
	}
	return o.Mongodb, true
}

// HasMongodb returns a boolean if a field has been set.
func (o *Source) HasMongodb() bool {
	if o != nil && o.Mongodb != nil {
		return true
	}

	return false
}

// SetMongodb gets a reference to the given SourceMongoDb and assigns it to the Mongodb field.
func (o *Source) SetMongodb(v SourceMongoDb) {
	o.Mongodb = &v
}

// GetS3 returns the S3 field value if set, zero value otherwise.
func (o *Source) GetS3() SourceS3 {
	if o == nil || o.S3 == nil {
		var ret SourceS3
		return ret
	}
	return *o.S3
}

// GetS3Ok returns a tuple with the S3 field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetS3Ok() (*SourceS3, bool) {
	if o == nil || o.S3 == nil {
		return nil, false
	}
	return o.S3, true
}

// HasS3 returns a boolean if a field has been set.
func (o *Source) HasS3() bool {
	if o != nil && o.S3 != nil {
		return true
	}

	return false
}

// SetS3 gets a reference to the given SourceS3 and assigns it to the S3 field.
func (o *Source) SetS3(v SourceS3) {
	o.S3 = &v
}

// GetSnowflake returns the Snowflake field value if set, zero value otherwise.
func (o *Source) GetSnowflake() SourceSnowflake {
	if o == nil || o.Snowflake == nil {
		var ret SourceSnowflake
		return ret
	}
	return *o.Snowflake
}

// GetSnowflakeOk returns a tuple with the Snowflake field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetSnowflakeOk() (*SourceSnowflake, bool) {
	if o == nil || o.Snowflake == nil {
		return nil, false
	}
	return o.Snowflake, true
}

// HasSnowflake returns a boolean if a field has been set.
func (o *Source) HasSnowflake() bool {
	if o != nil && o.Snowflake != nil {
		return true
	}

	return false
}

// SetSnowflake gets a reference to the given SourceSnowflake and assigns it to the Snowflake field.
func (o *Source) SetSnowflake(v SourceSnowflake) {
	o.Snowflake = &v
}

// GetStatus returns the Status field value if set, zero value otherwise.
func (o *Source) GetStatus() Status {
	if o == nil || o.Status == nil {
		var ret Status
		return ret
	}
	return *o.Status
}

// GetStatusOk returns a tuple with the Status field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetStatusOk() (*Status, bool) {
	if o == nil || o.Status == nil {
		return nil, false
	}
	return o.Status, true
}

// HasStatus returns a boolean if a field has been set.
func (o *Source) HasStatus() bool {
	if o != nil && o.Status != nil {
		return true
	}

	return false
}

// SetStatus gets a reference to the given Status and assigns it to the Status field.
func (o *Source) SetStatus(v Status) {
	o.Status = &v
}

// GetSuspendedAt returns the SuspendedAt field value if set, zero value otherwise.
func (o *Source) GetSuspendedAt() string {
	if o == nil || o.SuspendedAt == nil {
		var ret string
		return ret
	}
	return *o.SuspendedAt
}

// GetSuspendedAtOk returns a tuple with the SuspendedAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetSuspendedAtOk() (*string, bool) {
	if o == nil || o.SuspendedAt == nil {
		return nil, false
	}
	return o.SuspendedAt, true
}

// HasSuspendedAt returns a boolean if a field has been set.
func (o *Source) HasSuspendedAt() bool {
	if o != nil && o.SuspendedAt != nil {
		return true
	}

	return false
}

// SetSuspendedAt gets a reference to the given string and assigns it to the SuspendedAt field.
func (o *Source) SetSuspendedAt(v string) {
	o.SuspendedAt = &v
}

// GetSystem returns the System field value if set, zero value otherwise.
func (o *Source) GetSystem() SourceSystem {
	if o == nil || o.System == nil {
		var ret SourceSystem
		return ret
	}
	return *o.System
}

// GetSystemOk returns a tuple with the System field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Source) GetSystemOk() (*SourceSystem, bool) {
	if o == nil || o.System == nil {
		return nil, false
	}
	return o.System, true
}

// HasSystem returns a boolean if a field has been set.
func (o *Source) HasSystem() bool {
	if o != nil && o.System != nil {
		return true
	}

	return false
}

// SetSystem gets a reference to the given SourceSystem and assigns it to the System field.
func (o *Source) SetSystem(v SourceSystem) {
	o.System = &v
}

func (o Source) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.AzureBlobStorage != nil {
		toSerialize["azure_blob_storage"] = o.AzureBlobStorage
	}
	if o.AzureEventHubs != nil {
		toSerialize["azure_event_hubs"] = o.AzureEventHubs
	}
	if o.AzureServiceBus != nil {
		toSerialize["azure_service_bus"] = o.AzureServiceBus
	}
	if o.Dynamodb != nil {
		toSerialize["dynamodb"] = o.Dynamodb
	}
	if o.FileUpload != nil {
		toSerialize["file_upload"] = o.FileUpload
	}
	if o.FormatParams != nil {
		toSerialize["format_params"] = o.FormatParams
	}
	if o.Gcs != nil {
		toSerialize["gcs"] = o.Gcs
	}
	if o.Id != nil {
		toSerialize["id"] = o.Id
	}
	if o.IngestTransformation != nil {
		toSerialize["ingest_transformation"] = o.IngestTransformation
	}
	if o.IntegrationName != nil {
		toSerialize["integration_name"] = o.IntegrationName
	}
	if o.Kafka != nil {
		toSerialize["kafka"] = o.Kafka
	}
	if o.Kinesis != nil {
		toSerialize["kinesis"] = o.Kinesis
	}
	if o.Mongodb != nil {
		toSerialize["mongodb"] = o.Mongodb
	}
	if o.S3 != nil {
		toSerialize["s3"] = o.S3
	}
	if o.Snowflake != nil {
		toSerialize["snowflake"] = o.Snowflake
	}
	if o.Status != nil {
		toSerialize["status"] = o.Status
	}
	if o.SuspendedAt != nil {
		toSerialize["suspended_at"] = o.SuspendedAt
	}
	if o.System != nil {
		toSerialize["system"] = o.System
	}
	return json.Marshal(toSerialize)
}

type NullableSource struct {
	value *Source
	isSet bool
}

func (v NullableSource) Get() *Source {
	return v.value
}

func (v *NullableSource) Set(val *Source) {
	v.value = val
	v.isSet = true
}

func (v NullableSource) IsSet() bool {
	return v.isSet
}

func (v *NullableSource) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSource(val *Source) *NullableSource {
	return &NullableSource{value: val, isSet: true}
}

func (v NullableSource) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSource) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


