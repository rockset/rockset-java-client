# SourceS3

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Bucket** | **string** | Address of S3 bucket containing data. | 
**ObjectBytesDownloaded** | Pointer to **int64** |  | [optional] [readonly] 
**ObjectBytesTotal** | Pointer to **int64** |  | [optional] [readonly] 
**ObjectCountDownloaded** | Pointer to **int64** |  | [optional] [readonly] 
**ObjectCountTotal** | Pointer to **int64** |  | [optional] [readonly] 
**Pattern** | Pointer to **string** | Glob-style pattern that selects keys to ingest. Only either prefix or pattern can be specified. | [optional] 
**Prefix** | Pointer to **string** | Prefix that selects keys to ingest. | [optional] 
**Prefixes** | Pointer to **[]string** | Deprecated in favor of &#x60;prefix&#x60;. List of prefixes to paths from which data should be ingested. | [optional] [readonly] 
**Region** | Pointer to **string** | AWS region containing source bucket. | [optional] 
**Settings** | Pointer to [**SourceS3Settings**](SourceS3Settings.md) |  | [optional] 

## Methods

### NewSourceS3

`func NewSourceS3(bucket string, ) *SourceS3`

NewSourceS3 instantiates a new SourceS3 object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceS3WithDefaults

`func NewSourceS3WithDefaults() *SourceS3`

NewSourceS3WithDefaults instantiates a new SourceS3 object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetBucket

`func (o *SourceS3) GetBucket() string`

GetBucket returns the Bucket field if non-nil, zero value otherwise.

### GetBucketOk

`func (o *SourceS3) GetBucketOk() (*string, bool)`

GetBucketOk returns a tuple with the Bucket field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBucket

`func (o *SourceS3) SetBucket(v string)`

SetBucket sets Bucket field to given value.


### GetObjectBytesDownloaded

`func (o *SourceS3) GetObjectBytesDownloaded() int64`

GetObjectBytesDownloaded returns the ObjectBytesDownloaded field if non-nil, zero value otherwise.

### GetObjectBytesDownloadedOk

`func (o *SourceS3) GetObjectBytesDownloadedOk() (*int64, bool)`

GetObjectBytesDownloadedOk returns a tuple with the ObjectBytesDownloaded field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetObjectBytesDownloaded

`func (o *SourceS3) SetObjectBytesDownloaded(v int64)`

SetObjectBytesDownloaded sets ObjectBytesDownloaded field to given value.

### HasObjectBytesDownloaded

`func (o *SourceS3) HasObjectBytesDownloaded() bool`

HasObjectBytesDownloaded returns a boolean if a field has been set.

### GetObjectBytesTotal

`func (o *SourceS3) GetObjectBytesTotal() int64`

GetObjectBytesTotal returns the ObjectBytesTotal field if non-nil, zero value otherwise.

### GetObjectBytesTotalOk

`func (o *SourceS3) GetObjectBytesTotalOk() (*int64, bool)`

GetObjectBytesTotalOk returns a tuple with the ObjectBytesTotal field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetObjectBytesTotal

`func (o *SourceS3) SetObjectBytesTotal(v int64)`

SetObjectBytesTotal sets ObjectBytesTotal field to given value.

### HasObjectBytesTotal

`func (o *SourceS3) HasObjectBytesTotal() bool`

HasObjectBytesTotal returns a boolean if a field has been set.

### GetObjectCountDownloaded

`func (o *SourceS3) GetObjectCountDownloaded() int64`

GetObjectCountDownloaded returns the ObjectCountDownloaded field if non-nil, zero value otherwise.

### GetObjectCountDownloadedOk

`func (o *SourceS3) GetObjectCountDownloadedOk() (*int64, bool)`

GetObjectCountDownloadedOk returns a tuple with the ObjectCountDownloaded field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetObjectCountDownloaded

`func (o *SourceS3) SetObjectCountDownloaded(v int64)`

SetObjectCountDownloaded sets ObjectCountDownloaded field to given value.

### HasObjectCountDownloaded

`func (o *SourceS3) HasObjectCountDownloaded() bool`

HasObjectCountDownloaded returns a boolean if a field has been set.

### GetObjectCountTotal

`func (o *SourceS3) GetObjectCountTotal() int64`

GetObjectCountTotal returns the ObjectCountTotal field if non-nil, zero value otherwise.

### GetObjectCountTotalOk

`func (o *SourceS3) GetObjectCountTotalOk() (*int64, bool)`

GetObjectCountTotalOk returns a tuple with the ObjectCountTotal field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetObjectCountTotal

`func (o *SourceS3) SetObjectCountTotal(v int64)`

SetObjectCountTotal sets ObjectCountTotal field to given value.

### HasObjectCountTotal

`func (o *SourceS3) HasObjectCountTotal() bool`

HasObjectCountTotal returns a boolean if a field has been set.

### GetPattern

`func (o *SourceS3) GetPattern() string`

GetPattern returns the Pattern field if non-nil, zero value otherwise.

### GetPatternOk

`func (o *SourceS3) GetPatternOk() (*string, bool)`

GetPatternOk returns a tuple with the Pattern field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPattern

`func (o *SourceS3) SetPattern(v string)`

SetPattern sets Pattern field to given value.

### HasPattern

`func (o *SourceS3) HasPattern() bool`

HasPattern returns a boolean if a field has been set.

### GetPrefix

`func (o *SourceS3) GetPrefix() string`

GetPrefix returns the Prefix field if non-nil, zero value otherwise.

### GetPrefixOk

`func (o *SourceS3) GetPrefixOk() (*string, bool)`

GetPrefixOk returns a tuple with the Prefix field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPrefix

`func (o *SourceS3) SetPrefix(v string)`

SetPrefix sets Prefix field to given value.

### HasPrefix

`func (o *SourceS3) HasPrefix() bool`

HasPrefix returns a boolean if a field has been set.

### GetPrefixes

`func (o *SourceS3) GetPrefixes() []string`

GetPrefixes returns the Prefixes field if non-nil, zero value otherwise.

### GetPrefixesOk

`func (o *SourceS3) GetPrefixesOk() (*[]string, bool)`

GetPrefixesOk returns a tuple with the Prefixes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPrefixes

`func (o *SourceS3) SetPrefixes(v []string)`

SetPrefixes sets Prefixes field to given value.

### HasPrefixes

`func (o *SourceS3) HasPrefixes() bool`

HasPrefixes returns a boolean if a field has been set.

### GetRegion

`func (o *SourceS3) GetRegion() string`

GetRegion returns the Region field if non-nil, zero value otherwise.

### GetRegionOk

`func (o *SourceS3) GetRegionOk() (*string, bool)`

GetRegionOk returns a tuple with the Region field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRegion

`func (o *SourceS3) SetRegion(v string)`

SetRegion sets Region field to given value.

### HasRegion

`func (o *SourceS3) HasRegion() bool`

HasRegion returns a boolean if a field has been set.

### GetSettings

`func (o *SourceS3) GetSettings() SourceS3Settings`

GetSettings returns the Settings field if non-nil, zero value otherwise.

### GetSettingsOk

`func (o *SourceS3) GetSettingsOk() (*SourceS3Settings, bool)`

GetSettingsOk returns a tuple with the Settings field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSettings

`func (o *SourceS3) SetSettings(v SourceS3Settings)`

SetSettings sets Settings field to given value.

### HasSettings

`func (o *SourceS3) HasSettings() bool`

HasSettings returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


