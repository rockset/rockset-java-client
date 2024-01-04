# SourceKafka

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ClientId** | Pointer to **string** | The kafka client id being used. | [optional] 
**ConsumerGroupId** | Pointer to **string** | The Kafka consumer group Id being used. | [optional] 
**KafkaTopicName** | Pointer to **string** | The Kafka topic to be tailed. | [optional] 
**OffsetResetPolicy** | Pointer to **string** | The offset reset policy. | [optional] 
**Status** | Pointer to [**StatusKafka**](StatusKafka.md) |  | [optional] 
**UseV3** | Pointer to **bool** | Whether to use v3 integration. | [optional] 

## Methods

### NewSourceKafka

`func NewSourceKafka() *SourceKafka`

NewSourceKafka instantiates a new SourceKafka object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceKafkaWithDefaults

`func NewSourceKafkaWithDefaults() *SourceKafka`

NewSourceKafkaWithDefaults instantiates a new SourceKafka object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetClientId

`func (o *SourceKafka) GetClientId() string`

GetClientId returns the ClientId field if non-nil, zero value otherwise.

### GetClientIdOk

`func (o *SourceKafka) GetClientIdOk() (*string, bool)`

GetClientIdOk returns a tuple with the ClientId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetClientId

`func (o *SourceKafka) SetClientId(v string)`

SetClientId sets ClientId field to given value.

### HasClientId

`func (o *SourceKafka) HasClientId() bool`

HasClientId returns a boolean if a field has been set.

### GetConsumerGroupId

`func (o *SourceKafka) GetConsumerGroupId() string`

GetConsumerGroupId returns the ConsumerGroupId field if non-nil, zero value otherwise.

### GetConsumerGroupIdOk

`func (o *SourceKafka) GetConsumerGroupIdOk() (*string, bool)`

GetConsumerGroupIdOk returns a tuple with the ConsumerGroupId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConsumerGroupId

`func (o *SourceKafka) SetConsumerGroupId(v string)`

SetConsumerGroupId sets ConsumerGroupId field to given value.

### HasConsumerGroupId

`func (o *SourceKafka) HasConsumerGroupId() bool`

HasConsumerGroupId returns a boolean if a field has been set.

### GetKafkaTopicName

`func (o *SourceKafka) GetKafkaTopicName() string`

GetKafkaTopicName returns the KafkaTopicName field if non-nil, zero value otherwise.

### GetKafkaTopicNameOk

`func (o *SourceKafka) GetKafkaTopicNameOk() (*string, bool)`

GetKafkaTopicNameOk returns a tuple with the KafkaTopicName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKafkaTopicName

`func (o *SourceKafka) SetKafkaTopicName(v string)`

SetKafkaTopicName sets KafkaTopicName field to given value.

### HasKafkaTopicName

`func (o *SourceKafka) HasKafkaTopicName() bool`

HasKafkaTopicName returns a boolean if a field has been set.

### GetOffsetResetPolicy

`func (o *SourceKafka) GetOffsetResetPolicy() string`

GetOffsetResetPolicy returns the OffsetResetPolicy field if non-nil, zero value otherwise.

### GetOffsetResetPolicyOk

`func (o *SourceKafka) GetOffsetResetPolicyOk() (*string, bool)`

GetOffsetResetPolicyOk returns a tuple with the OffsetResetPolicy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOffsetResetPolicy

`func (o *SourceKafka) SetOffsetResetPolicy(v string)`

SetOffsetResetPolicy sets OffsetResetPolicy field to given value.

### HasOffsetResetPolicy

`func (o *SourceKafka) HasOffsetResetPolicy() bool`

HasOffsetResetPolicy returns a boolean if a field has been set.

### GetStatus

`func (o *SourceKafka) GetStatus() StatusKafka`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *SourceKafka) GetStatusOk() (*StatusKafka, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *SourceKafka) SetStatus(v StatusKafka)`

SetStatus sets Status field to given value.

### HasStatus

`func (o *SourceKafka) HasStatus() bool`

HasStatus returns a boolean if a field has been set.

### GetUseV3

`func (o *SourceKafka) GetUseV3() bool`

GetUseV3 returns the UseV3 field if non-nil, zero value otherwise.

### GetUseV3Ok

`func (o *SourceKafka) GetUseV3Ok() (*bool, bool)`

GetUseV3Ok returns a tuple with the UseV3 field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUseV3

`func (o *SourceKafka) SetUseV3(v bool)`

SetUseV3 sets UseV3 field to given value.

### HasUseV3

`func (o *SourceKafka) HasUseV3() bool`

HasUseV3 returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


