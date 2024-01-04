# SourceDynamoDbSettings

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**DynamodbStreamPollFrequency** | Pointer to **string** | Each DynamoDB stream can have one to many shards, and Rockset polls each DynamoDB shard at a fixed rate. Decreasing the duration between polls helps reduce ingest latency, while increasing the duration can prevent  Rockset from keeping up with the updates. If the latency exceeds 24 hours (DynamoDB stream retention duration), Rockset will not be able to process all of the streaming updates. Each request also has a fixed price associated with it. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn&#39;t account for DST, leap seconds and leap years. Minimum value: PT0.25S. Maximum value: PT5M. | [optional] 

## Methods

### NewSourceDynamoDbSettings

`func NewSourceDynamoDbSettings() *SourceDynamoDbSettings`

NewSourceDynamoDbSettings instantiates a new SourceDynamoDbSettings object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceDynamoDbSettingsWithDefaults

`func NewSourceDynamoDbSettingsWithDefaults() *SourceDynamoDbSettings`

NewSourceDynamoDbSettingsWithDefaults instantiates a new SourceDynamoDbSettings object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDynamodbStreamPollFrequency

`func (o *SourceDynamoDbSettings) GetDynamodbStreamPollFrequency() string`

GetDynamodbStreamPollFrequency returns the DynamodbStreamPollFrequency field if non-nil, zero value otherwise.

### GetDynamodbStreamPollFrequencyOk

`func (o *SourceDynamoDbSettings) GetDynamodbStreamPollFrequencyOk() (*string, bool)`

GetDynamodbStreamPollFrequencyOk returns a tuple with the DynamodbStreamPollFrequency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDynamodbStreamPollFrequency

`func (o *SourceDynamoDbSettings) SetDynamodbStreamPollFrequency(v string)`

SetDynamodbStreamPollFrequency sets DynamodbStreamPollFrequency field to given value.

### HasDynamodbStreamPollFrequency

`func (o *SourceDynamoDbSettings) HasDynamodbStreamPollFrequency() bool`

HasDynamodbStreamPollFrequency returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


