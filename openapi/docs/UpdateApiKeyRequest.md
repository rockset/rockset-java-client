# UpdateApiKeyRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ClearExpiryTime** | Pointer to **bool** | If set to true, the expiration time for this key will be cleared. | [optional] 
**ExpiryTime** | Pointer to **string** | If provided, the API key will automatically expire at this time (ISO-8601 format). Requires premium. | [optional] 
**State** | Pointer to **string** | State that the api key should be set to. | [optional] 

## Methods

### NewUpdateApiKeyRequest

`func NewUpdateApiKeyRequest() *UpdateApiKeyRequest`

NewUpdateApiKeyRequest instantiates a new UpdateApiKeyRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUpdateApiKeyRequestWithDefaults

`func NewUpdateApiKeyRequestWithDefaults() *UpdateApiKeyRequest`

NewUpdateApiKeyRequestWithDefaults instantiates a new UpdateApiKeyRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetClearExpiryTime

`func (o *UpdateApiKeyRequest) GetClearExpiryTime() bool`

GetClearExpiryTime returns the ClearExpiryTime field if non-nil, zero value otherwise.

### GetClearExpiryTimeOk

`func (o *UpdateApiKeyRequest) GetClearExpiryTimeOk() (*bool, bool)`

GetClearExpiryTimeOk returns a tuple with the ClearExpiryTime field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetClearExpiryTime

`func (o *UpdateApiKeyRequest) SetClearExpiryTime(v bool)`

SetClearExpiryTime sets ClearExpiryTime field to given value.

### HasClearExpiryTime

`func (o *UpdateApiKeyRequest) HasClearExpiryTime() bool`

HasClearExpiryTime returns a boolean if a field has been set.

### GetExpiryTime

`func (o *UpdateApiKeyRequest) GetExpiryTime() string`

GetExpiryTime returns the ExpiryTime field if non-nil, zero value otherwise.

### GetExpiryTimeOk

`func (o *UpdateApiKeyRequest) GetExpiryTimeOk() (*string, bool)`

GetExpiryTimeOk returns a tuple with the ExpiryTime field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpiryTime

`func (o *UpdateApiKeyRequest) SetExpiryTime(v string)`

SetExpiryTime sets ExpiryTime field to given value.

### HasExpiryTime

`func (o *UpdateApiKeyRequest) HasExpiryTime() bool`

HasExpiryTime returns a boolean if a field has been set.

### GetState

`func (o *UpdateApiKeyRequest) GetState() string`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *UpdateApiKeyRequest) GetStateOk() (*string, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *UpdateApiKeyRequest) SetState(v string)`

SetState sets State field to given value.

### HasState

`func (o *UpdateApiKeyRequest) HasState() bool`

HasState returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


