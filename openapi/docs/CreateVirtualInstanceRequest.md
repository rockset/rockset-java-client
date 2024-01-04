# CreateVirtualInstanceRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AutoSuspendSeconds** | Pointer to **int32** | Number of seconds without queries after which the VI is suspended | [optional] 
**Description** | Pointer to **string** | Description of requested virtual instance. | [optional] 
**EnableRemountOnResume** | Pointer to **bool** | When a Virtual Instance is resumed, it will remount all collections that were mounted when the Virtual Instance was suspended. | [optional] 
**MountRefreshIntervalSeconds** | Pointer to **int32** | DEPRECATED. Use &#x60;mount_type&#x60; instead. Number of seconds between data refreshes for mounts on this Virtual Instance. The only valid values are 0 and null. 0 means the data will be refreshed continuously and null means the data will never refresh. | [optional] 
**MountType** | Pointer to **string** | The mount type of collections that this Virtual Instance will query. Live mounted collections stay up-to-date with the underlying collection in real-time. Static mounted collections do not stay up-to-date. See https://docs.rockset.com/documentation/docs/virtual-instances#virtual-instance-configuration | [optional] 
**Name** | **string** | Unique identifier for virtual instance, can contain alphanumeric or dash characters. | 
**Type** | Pointer to **string** | Requested virtual instance type. | [optional] 

## Methods

### NewCreateVirtualInstanceRequest

`func NewCreateVirtualInstanceRequest(name string, ) *CreateVirtualInstanceRequest`

NewCreateVirtualInstanceRequest instantiates a new CreateVirtualInstanceRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewCreateVirtualInstanceRequestWithDefaults

`func NewCreateVirtualInstanceRequestWithDefaults() *CreateVirtualInstanceRequest`

NewCreateVirtualInstanceRequestWithDefaults instantiates a new CreateVirtualInstanceRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAutoSuspendSeconds

`func (o *CreateVirtualInstanceRequest) GetAutoSuspendSeconds() int32`

GetAutoSuspendSeconds returns the AutoSuspendSeconds field if non-nil, zero value otherwise.

### GetAutoSuspendSecondsOk

`func (o *CreateVirtualInstanceRequest) GetAutoSuspendSecondsOk() (*int32, bool)`

GetAutoSuspendSecondsOk returns a tuple with the AutoSuspendSeconds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAutoSuspendSeconds

`func (o *CreateVirtualInstanceRequest) SetAutoSuspendSeconds(v int32)`

SetAutoSuspendSeconds sets AutoSuspendSeconds field to given value.

### HasAutoSuspendSeconds

`func (o *CreateVirtualInstanceRequest) HasAutoSuspendSeconds() bool`

HasAutoSuspendSeconds returns a boolean if a field has been set.

### GetDescription

`func (o *CreateVirtualInstanceRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *CreateVirtualInstanceRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *CreateVirtualInstanceRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *CreateVirtualInstanceRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetEnableRemountOnResume

`func (o *CreateVirtualInstanceRequest) GetEnableRemountOnResume() bool`

GetEnableRemountOnResume returns the EnableRemountOnResume field if non-nil, zero value otherwise.

### GetEnableRemountOnResumeOk

`func (o *CreateVirtualInstanceRequest) GetEnableRemountOnResumeOk() (*bool, bool)`

GetEnableRemountOnResumeOk returns a tuple with the EnableRemountOnResume field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnableRemountOnResume

`func (o *CreateVirtualInstanceRequest) SetEnableRemountOnResume(v bool)`

SetEnableRemountOnResume sets EnableRemountOnResume field to given value.

### HasEnableRemountOnResume

`func (o *CreateVirtualInstanceRequest) HasEnableRemountOnResume() bool`

HasEnableRemountOnResume returns a boolean if a field has been set.

### GetMountRefreshIntervalSeconds

`func (o *CreateVirtualInstanceRequest) GetMountRefreshIntervalSeconds() int32`

GetMountRefreshIntervalSeconds returns the MountRefreshIntervalSeconds field if non-nil, zero value otherwise.

### GetMountRefreshIntervalSecondsOk

`func (o *CreateVirtualInstanceRequest) GetMountRefreshIntervalSecondsOk() (*int32, bool)`

GetMountRefreshIntervalSecondsOk returns a tuple with the MountRefreshIntervalSeconds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMountRefreshIntervalSeconds

`func (o *CreateVirtualInstanceRequest) SetMountRefreshIntervalSeconds(v int32)`

SetMountRefreshIntervalSeconds sets MountRefreshIntervalSeconds field to given value.

### HasMountRefreshIntervalSeconds

`func (o *CreateVirtualInstanceRequest) HasMountRefreshIntervalSeconds() bool`

HasMountRefreshIntervalSeconds returns a boolean if a field has been set.

### GetMountType

`func (o *CreateVirtualInstanceRequest) GetMountType() string`

GetMountType returns the MountType field if non-nil, zero value otherwise.

### GetMountTypeOk

`func (o *CreateVirtualInstanceRequest) GetMountTypeOk() (*string, bool)`

GetMountTypeOk returns a tuple with the MountType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMountType

`func (o *CreateVirtualInstanceRequest) SetMountType(v string)`

SetMountType sets MountType field to given value.

### HasMountType

`func (o *CreateVirtualInstanceRequest) HasMountType() bool`

HasMountType returns a boolean if a field has been set.

### GetName

`func (o *CreateVirtualInstanceRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *CreateVirtualInstanceRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *CreateVirtualInstanceRequest) SetName(v string)`

SetName sets Name field to given value.


### GetType

`func (o *CreateVirtualInstanceRequest) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *CreateVirtualInstanceRequest) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *CreateVirtualInstanceRequest) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *CreateVirtualInstanceRequest) HasType() bool`

HasType returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


