# SourceGcsSettings

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**GcsScanFrequency** | Pointer to **string** | Rockset scans a GCS bucket based on a defined time interval. The scan frequency determines the length of time between a new scan and the previous scan. If the previous scan finds new objects or updates to existing objects, Rockset immediately scans the bucket again after processing changes from the previous scan. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn&#39;t account for DST, leap seconds and leap years. Minimum value: PT1S. Maximum value: PT1H. | [optional] 

## Methods

### NewSourceGcsSettings

`func NewSourceGcsSettings() *SourceGcsSettings`

NewSourceGcsSettings instantiates a new SourceGcsSettings object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceGcsSettingsWithDefaults

`func NewSourceGcsSettingsWithDefaults() *SourceGcsSettings`

NewSourceGcsSettingsWithDefaults instantiates a new SourceGcsSettings object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetGcsScanFrequency

`func (o *SourceGcsSettings) GetGcsScanFrequency() string`

GetGcsScanFrequency returns the GcsScanFrequency field if non-nil, zero value otherwise.

### GetGcsScanFrequencyOk

`func (o *SourceGcsSettings) GetGcsScanFrequencyOk() (*string, bool)`

GetGcsScanFrequencyOk returns a tuple with the GcsScanFrequency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGcsScanFrequency

`func (o *SourceGcsSettings) SetGcsScanFrequency(v string)`

SetGcsScanFrequency sets GcsScanFrequency field to given value.

### HasGcsScanFrequency

`func (o *SourceGcsSettings) HasGcsScanFrequency() bool`

HasGcsScanFrequency returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


