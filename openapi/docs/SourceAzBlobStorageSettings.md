# SourceAzBlobStorageSettings

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AzblobScanFrequency** | Pointer to **string** | Rockset scans an Azure blob Storage container based on a defined time interval. The scan frequency determines the length of time between a new scan and the previous scan. If the previous scan finds new objects or updates to existing objects, Rockset immediately scans the bucket again after processing changes from the previous scan. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn&#39;t account for DST, leap seconds and leap years. Minimum value: PT1S. Maximum value: PT1H. | [optional] 

## Methods

### NewSourceAzBlobStorageSettings

`func NewSourceAzBlobStorageSettings() *SourceAzBlobStorageSettings`

NewSourceAzBlobStorageSettings instantiates a new SourceAzBlobStorageSettings object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceAzBlobStorageSettingsWithDefaults

`func NewSourceAzBlobStorageSettingsWithDefaults() *SourceAzBlobStorageSettings`

NewSourceAzBlobStorageSettingsWithDefaults instantiates a new SourceAzBlobStorageSettings object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAzblobScanFrequency

`func (o *SourceAzBlobStorageSettings) GetAzblobScanFrequency() string`

GetAzblobScanFrequency returns the AzblobScanFrequency field if non-nil, zero value otherwise.

### GetAzblobScanFrequencyOk

`func (o *SourceAzBlobStorageSettings) GetAzblobScanFrequencyOk() (*string, bool)`

GetAzblobScanFrequencyOk returns a tuple with the AzblobScanFrequency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAzblobScanFrequency

`func (o *SourceAzBlobStorageSettings) SetAzblobScanFrequency(v string)`

SetAzblobScanFrequency sets AzblobScanFrequency field to given value.

### HasAzblobScanFrequency

`func (o *SourceAzBlobStorageSettings) HasAzblobScanFrequency() bool`

HasAzblobScanFrequency returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


