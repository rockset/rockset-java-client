# Source

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AzureBlobStorage** | Pointer to [**SourceAzureBlobStorage**](SourceAzureBlobStorage.md) |  | [optional] 
**AzureEventHubs** | Pointer to [**SourceAzureEventHubs**](SourceAzureEventHubs.md) |  | [optional] 
**AzureServiceBus** | Pointer to [**SourceAzureServiceBus**](SourceAzureServiceBus.md) |  | [optional] 
**Dynamodb** | Pointer to [**SourceDynamoDb**](SourceDynamoDb.md) |  | [optional] 
**FileUpload** | Pointer to [**SourceFileUpload**](SourceFileUpload.md) |  | [optional] 
**FormatParams** | Pointer to [**FormatParams**](FormatParams.md) |  | [optional] 
**Gcs** | Pointer to [**SourceGcs**](SourceGcs.md) |  | [optional] 
**Id** | Pointer to **string** | Unique source identifier. | [optional] [readonly] 
**IngestTransformation** | Pointer to [**FieldMappingQuery**](FieldMappingQuery.md) |  | [optional] 
**IntegrationName** | Pointer to **string** | Name of integration to use. | [optional] 
**Kafka** | Pointer to [**SourceKafka**](SourceKafka.md) |  | [optional] 
**Kinesis** | Pointer to [**SourceKinesis**](SourceKinesis.md) |  | [optional] 
**Mongodb** | Pointer to [**SourceMongoDb**](SourceMongoDb.md) |  | [optional] 
**ResumeAt** | Pointer to **string** | ISO-8601 date when source would be auto resumed, if suspended | [optional] [readonly] 
**S3** | Pointer to [**SourceS3**](SourceS3.md) |  | [optional] 
**Snapshot** | Pointer to [**SourceSnapshot**](SourceSnapshot.md) |  | [optional] 
**Snowflake** | Pointer to [**SourceSnowflake**](SourceSnowflake.md) |  | [optional] 
**Status** | Pointer to [**Status**](Status.md) |  | [optional] 
**SuspendedAt** | Pointer to **string** | ISO-8601 date when source was suspended, if suspended | [optional] [readonly] 
**System** | Pointer to [**SourceSystem**](SourceSystem.md) |  | [optional] 

## Methods

### NewSource

`func NewSource() *Source`

NewSource instantiates a new Source object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceWithDefaults

`func NewSourceWithDefaults() *Source`

NewSourceWithDefaults instantiates a new Source object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAzureBlobStorage

`func (o *Source) GetAzureBlobStorage() SourceAzureBlobStorage`

GetAzureBlobStorage returns the AzureBlobStorage field if non-nil, zero value otherwise.

### GetAzureBlobStorageOk

`func (o *Source) GetAzureBlobStorageOk() (*SourceAzureBlobStorage, bool)`

GetAzureBlobStorageOk returns a tuple with the AzureBlobStorage field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAzureBlobStorage

`func (o *Source) SetAzureBlobStorage(v SourceAzureBlobStorage)`

SetAzureBlobStorage sets AzureBlobStorage field to given value.

### HasAzureBlobStorage

`func (o *Source) HasAzureBlobStorage() bool`

HasAzureBlobStorage returns a boolean if a field has been set.

### GetAzureEventHubs

`func (o *Source) GetAzureEventHubs() SourceAzureEventHubs`

GetAzureEventHubs returns the AzureEventHubs field if non-nil, zero value otherwise.

### GetAzureEventHubsOk

`func (o *Source) GetAzureEventHubsOk() (*SourceAzureEventHubs, bool)`

GetAzureEventHubsOk returns a tuple with the AzureEventHubs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAzureEventHubs

`func (o *Source) SetAzureEventHubs(v SourceAzureEventHubs)`

SetAzureEventHubs sets AzureEventHubs field to given value.

### HasAzureEventHubs

`func (o *Source) HasAzureEventHubs() bool`

HasAzureEventHubs returns a boolean if a field has been set.

### GetAzureServiceBus

`func (o *Source) GetAzureServiceBus() SourceAzureServiceBus`

GetAzureServiceBus returns the AzureServiceBus field if non-nil, zero value otherwise.

### GetAzureServiceBusOk

`func (o *Source) GetAzureServiceBusOk() (*SourceAzureServiceBus, bool)`

GetAzureServiceBusOk returns a tuple with the AzureServiceBus field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAzureServiceBus

`func (o *Source) SetAzureServiceBus(v SourceAzureServiceBus)`

SetAzureServiceBus sets AzureServiceBus field to given value.

### HasAzureServiceBus

`func (o *Source) HasAzureServiceBus() bool`

HasAzureServiceBus returns a boolean if a field has been set.

### GetDynamodb

`func (o *Source) GetDynamodb() SourceDynamoDb`

GetDynamodb returns the Dynamodb field if non-nil, zero value otherwise.

### GetDynamodbOk

`func (o *Source) GetDynamodbOk() (*SourceDynamoDb, bool)`

GetDynamodbOk returns a tuple with the Dynamodb field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDynamodb

`func (o *Source) SetDynamodb(v SourceDynamoDb)`

SetDynamodb sets Dynamodb field to given value.

### HasDynamodb

`func (o *Source) HasDynamodb() bool`

HasDynamodb returns a boolean if a field has been set.

### GetFileUpload

`func (o *Source) GetFileUpload() SourceFileUpload`

GetFileUpload returns the FileUpload field if non-nil, zero value otherwise.

### GetFileUploadOk

`func (o *Source) GetFileUploadOk() (*SourceFileUpload, bool)`

GetFileUploadOk returns a tuple with the FileUpload field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFileUpload

`func (o *Source) SetFileUpload(v SourceFileUpload)`

SetFileUpload sets FileUpload field to given value.

### HasFileUpload

`func (o *Source) HasFileUpload() bool`

HasFileUpload returns a boolean if a field has been set.

### GetFormatParams

`func (o *Source) GetFormatParams() FormatParams`

GetFormatParams returns the FormatParams field if non-nil, zero value otherwise.

### GetFormatParamsOk

`func (o *Source) GetFormatParamsOk() (*FormatParams, bool)`

GetFormatParamsOk returns a tuple with the FormatParams field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFormatParams

`func (o *Source) SetFormatParams(v FormatParams)`

SetFormatParams sets FormatParams field to given value.

### HasFormatParams

`func (o *Source) HasFormatParams() bool`

HasFormatParams returns a boolean if a field has been set.

### GetGcs

`func (o *Source) GetGcs() SourceGcs`

GetGcs returns the Gcs field if non-nil, zero value otherwise.

### GetGcsOk

`func (o *Source) GetGcsOk() (*SourceGcs, bool)`

GetGcsOk returns a tuple with the Gcs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGcs

`func (o *Source) SetGcs(v SourceGcs)`

SetGcs sets Gcs field to given value.

### HasGcs

`func (o *Source) HasGcs() bool`

HasGcs returns a boolean if a field has been set.

### GetId

`func (o *Source) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Source) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Source) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *Source) HasId() bool`

HasId returns a boolean if a field has been set.

### GetIngestTransformation

`func (o *Source) GetIngestTransformation() FieldMappingQuery`

GetIngestTransformation returns the IngestTransformation field if non-nil, zero value otherwise.

### GetIngestTransformationOk

`func (o *Source) GetIngestTransformationOk() (*FieldMappingQuery, bool)`

GetIngestTransformationOk returns a tuple with the IngestTransformation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIngestTransformation

`func (o *Source) SetIngestTransformation(v FieldMappingQuery)`

SetIngestTransformation sets IngestTransformation field to given value.

### HasIngestTransformation

`func (o *Source) HasIngestTransformation() bool`

HasIngestTransformation returns a boolean if a field has been set.

### GetIntegrationName

`func (o *Source) GetIntegrationName() string`

GetIntegrationName returns the IntegrationName field if non-nil, zero value otherwise.

### GetIntegrationNameOk

`func (o *Source) GetIntegrationNameOk() (*string, bool)`

GetIntegrationNameOk returns a tuple with the IntegrationName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIntegrationName

`func (o *Source) SetIntegrationName(v string)`

SetIntegrationName sets IntegrationName field to given value.

### HasIntegrationName

`func (o *Source) HasIntegrationName() bool`

HasIntegrationName returns a boolean if a field has been set.

### GetKafka

`func (o *Source) GetKafka() SourceKafka`

GetKafka returns the Kafka field if non-nil, zero value otherwise.

### GetKafkaOk

`func (o *Source) GetKafkaOk() (*SourceKafka, bool)`

GetKafkaOk returns a tuple with the Kafka field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKafka

`func (o *Source) SetKafka(v SourceKafka)`

SetKafka sets Kafka field to given value.

### HasKafka

`func (o *Source) HasKafka() bool`

HasKafka returns a boolean if a field has been set.

### GetKinesis

`func (o *Source) GetKinesis() SourceKinesis`

GetKinesis returns the Kinesis field if non-nil, zero value otherwise.

### GetKinesisOk

`func (o *Source) GetKinesisOk() (*SourceKinesis, bool)`

GetKinesisOk returns a tuple with the Kinesis field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKinesis

`func (o *Source) SetKinesis(v SourceKinesis)`

SetKinesis sets Kinesis field to given value.

### HasKinesis

`func (o *Source) HasKinesis() bool`

HasKinesis returns a boolean if a field has been set.

### GetMongodb

`func (o *Source) GetMongodb() SourceMongoDb`

GetMongodb returns the Mongodb field if non-nil, zero value otherwise.

### GetMongodbOk

`func (o *Source) GetMongodbOk() (*SourceMongoDb, bool)`

GetMongodbOk returns a tuple with the Mongodb field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMongodb

`func (o *Source) SetMongodb(v SourceMongoDb)`

SetMongodb sets Mongodb field to given value.

### HasMongodb

`func (o *Source) HasMongodb() bool`

HasMongodb returns a boolean if a field has been set.

### GetResumeAt

`func (o *Source) GetResumeAt() string`

GetResumeAt returns the ResumeAt field if non-nil, zero value otherwise.

### GetResumeAtOk

`func (o *Source) GetResumeAtOk() (*string, bool)`

GetResumeAtOk returns a tuple with the ResumeAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResumeAt

`func (o *Source) SetResumeAt(v string)`

SetResumeAt sets ResumeAt field to given value.

### HasResumeAt

`func (o *Source) HasResumeAt() bool`

HasResumeAt returns a boolean if a field has been set.

### GetS3

`func (o *Source) GetS3() SourceS3`

GetS3 returns the S3 field if non-nil, zero value otherwise.

### GetS3Ok

`func (o *Source) GetS3Ok() (*SourceS3, bool)`

GetS3Ok returns a tuple with the S3 field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetS3

`func (o *Source) SetS3(v SourceS3)`

SetS3 sets S3 field to given value.

### HasS3

`func (o *Source) HasS3() bool`

HasS3 returns a boolean if a field has been set.

### GetSnapshot

`func (o *Source) GetSnapshot() SourceSnapshot`

GetSnapshot returns the Snapshot field if non-nil, zero value otherwise.

### GetSnapshotOk

`func (o *Source) GetSnapshotOk() (*SourceSnapshot, bool)`

GetSnapshotOk returns a tuple with the Snapshot field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSnapshot

`func (o *Source) SetSnapshot(v SourceSnapshot)`

SetSnapshot sets Snapshot field to given value.

### HasSnapshot

`func (o *Source) HasSnapshot() bool`

HasSnapshot returns a boolean if a field has been set.

### GetSnowflake

`func (o *Source) GetSnowflake() SourceSnowflake`

GetSnowflake returns the Snowflake field if non-nil, zero value otherwise.

### GetSnowflakeOk

`func (o *Source) GetSnowflakeOk() (*SourceSnowflake, bool)`

GetSnowflakeOk returns a tuple with the Snowflake field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSnowflake

`func (o *Source) SetSnowflake(v SourceSnowflake)`

SetSnowflake sets Snowflake field to given value.

### HasSnowflake

`func (o *Source) HasSnowflake() bool`

HasSnowflake returns a boolean if a field has been set.

### GetStatus

`func (o *Source) GetStatus() Status`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *Source) GetStatusOk() (*Status, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *Source) SetStatus(v Status)`

SetStatus sets Status field to given value.

### HasStatus

`func (o *Source) HasStatus() bool`

HasStatus returns a boolean if a field has been set.

### GetSuspendedAt

`func (o *Source) GetSuspendedAt() string`

GetSuspendedAt returns the SuspendedAt field if non-nil, zero value otherwise.

### GetSuspendedAtOk

`func (o *Source) GetSuspendedAtOk() (*string, bool)`

GetSuspendedAtOk returns a tuple with the SuspendedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuspendedAt

`func (o *Source) SetSuspendedAt(v string)`

SetSuspendedAt sets SuspendedAt field to given value.

### HasSuspendedAt

`func (o *Source) HasSuspendedAt() bool`

HasSuspendedAt returns a boolean if a field has been set.

### GetSystem

`func (o *Source) GetSystem() SourceSystem`

GetSystem returns the System field if non-nil, zero value otherwise.

### GetSystemOk

`func (o *Source) GetSystemOk() (*SourceSystem, bool)`

GetSystemOk returns a tuple with the System field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSystem

`func (o *Source) SetSystem(v SourceSystem)`

SetSystem sets System field to given value.

### HasSystem

`func (o *Source) HasSystem() bool`

HasSystem returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


