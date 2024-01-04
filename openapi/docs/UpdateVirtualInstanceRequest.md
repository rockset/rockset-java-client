# UpdateVirtualInstanceRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AutoScalingPolicy** | Pointer to [**AutoScalingPolicy**](AutoScalingPolicy.md) |  | [optional] 
**AutoSuspendEnabled** | Pointer to **bool** | Whether Query VI auto-suspend should be enabled for this Virtual Instance. | [optional] 
**AutoSuspendSeconds** | Pointer to **int32** | Number of seconds without queries after which the Query VI is suspended | [optional] 
**Description** | Pointer to **string** | New virtual instance description. | [optional] 
**EnableRemountOnResume** | Pointer to **bool** | When a Virtual Instance is resumed, it will remount all collections that were mounted when the Virtual Instance was suspended. | [optional] 
**MountRefreshIntervalSeconds** | Pointer to **int32** | DEPRECATED. Use &#x60;mount_type&#x60; instead. Number of seconds between data refreshes for mounts on this Virtual Instance. The only valid values are 0 and null. 0 means the data will be refreshed continuously and null means the data will never refresh. | [optional] 
**MountType** | Pointer to **string** | The mount type of collections that this Virtual Instance will query. Live mounted collections stay up-to-date with the underlying collection in real-time. Static mounted collections do not stay up-to-date. See https://docs.rockset.com/documentation/docs/virtual-instances#virtual-instance-configuration | [optional] 
**Name** | Pointer to **string** | New virtual instance name. | [optional] 
**NewSize** | Pointer to **string** | Requested virtual instance size. | [optional] 

## Methods

### NewUpdateVirtualInstanceRequest

`func NewUpdateVirtualInstanceRequest() *UpdateVirtualInstanceRequest`

NewUpdateVirtualInstanceRequest instantiates a new UpdateVirtualInstanceRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUpdateVirtualInstanceRequestWithDefaults

`func NewUpdateVirtualInstanceRequestWithDefaults() *UpdateVirtualInstanceRequest`

NewUpdateVirtualInstanceRequestWithDefaults instantiates a new UpdateVirtualInstanceRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAutoScalingPolicy

`func (o *UpdateVirtualInstanceRequest) GetAutoScalingPolicy() AutoScalingPolicy`

GetAutoScalingPolicy returns the AutoScalingPolicy field if non-nil, zero value otherwise.

### GetAutoScalingPolicyOk

`func (o *UpdateVirtualInstanceRequest) GetAutoScalingPolicyOk() (*AutoScalingPolicy, bool)`

GetAutoScalingPolicyOk returns a tuple with the AutoScalingPolicy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAutoScalingPolicy

`func (o *UpdateVirtualInstanceRequest) SetAutoScalingPolicy(v AutoScalingPolicy)`

SetAutoScalingPolicy sets AutoScalingPolicy field to given value.

### HasAutoScalingPolicy

`func (o *UpdateVirtualInstanceRequest) HasAutoScalingPolicy() bool`

HasAutoScalingPolicy returns a boolean if a field has been set.

### GetAutoSuspendEnabled

`func (o *UpdateVirtualInstanceRequest) GetAutoSuspendEnabled() bool`

GetAutoSuspendEnabled returns the AutoSuspendEnabled field if non-nil, zero value otherwise.

### GetAutoSuspendEnabledOk

`func (o *UpdateVirtualInstanceRequest) GetAutoSuspendEnabledOk() (*bool, bool)`

GetAutoSuspendEnabledOk returns a tuple with the AutoSuspendEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAutoSuspendEnabled

`func (o *UpdateVirtualInstanceRequest) SetAutoSuspendEnabled(v bool)`

SetAutoSuspendEnabled sets AutoSuspendEnabled field to given value.

### HasAutoSuspendEnabled

`func (o *UpdateVirtualInstanceRequest) HasAutoSuspendEnabled() bool`

HasAutoSuspendEnabled returns a boolean if a field has been set.

### GetAutoSuspendSeconds

`func (o *UpdateVirtualInstanceRequest) GetAutoSuspendSeconds() int32`

GetAutoSuspendSeconds returns the AutoSuspendSeconds field if non-nil, zero value otherwise.

### GetAutoSuspendSecondsOk

`func (o *UpdateVirtualInstanceRequest) GetAutoSuspendSecondsOk() (*int32, bool)`

GetAutoSuspendSecondsOk returns a tuple with the AutoSuspendSeconds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAutoSuspendSeconds

`func (o *UpdateVirtualInstanceRequest) SetAutoSuspendSeconds(v int32)`

SetAutoSuspendSeconds sets AutoSuspendSeconds field to given value.

### HasAutoSuspendSeconds

`func (o *UpdateVirtualInstanceRequest) HasAutoSuspendSeconds() bool`

HasAutoSuspendSeconds returns a boolean if a field has been set.

### GetDescription

`func (o *UpdateVirtualInstanceRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *UpdateVirtualInstanceRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *UpdateVirtualInstanceRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *UpdateVirtualInstanceRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetEnableRemountOnResume

`func (o *UpdateVirtualInstanceRequest) GetEnableRemountOnResume() bool`

GetEnableRemountOnResume returns the EnableRemountOnResume field if non-nil, zero value otherwise.

### GetEnableRemountOnResumeOk

`func (o *UpdateVirtualInstanceRequest) GetEnableRemountOnResumeOk() (*bool, bool)`

GetEnableRemountOnResumeOk returns a tuple with the EnableRemountOnResume field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnableRemountOnResume

`func (o *UpdateVirtualInstanceRequest) SetEnableRemountOnResume(v bool)`

SetEnableRemountOnResume sets EnableRemountOnResume field to given value.

### HasEnableRemountOnResume

`func (o *UpdateVirtualInstanceRequest) HasEnableRemountOnResume() bool`

HasEnableRemountOnResume returns a boolean if a field has been set.

### GetMountRefreshIntervalSeconds

`func (o *UpdateVirtualInstanceRequest) GetMountRefreshIntervalSeconds() int32`

GetMountRefreshIntervalSeconds returns the MountRefreshIntervalSeconds field if non-nil, zero value otherwise.

### GetMountRefreshIntervalSecondsOk

`func (o *UpdateVirtualInstanceRequest) GetMountRefreshIntervalSecondsOk() (*int32, bool)`

GetMountRefreshIntervalSecondsOk returns a tuple with the MountRefreshIntervalSeconds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMountRefreshIntervalSeconds

`func (o *UpdateVirtualInstanceRequest) SetMountRefreshIntervalSeconds(v int32)`

SetMountRefreshIntervalSeconds sets MountRefreshIntervalSeconds field to given value.

### HasMountRefreshIntervalSeconds

`func (o *UpdateVirtualInstanceRequest) HasMountRefreshIntervalSeconds() bool`

HasMountRefreshIntervalSeconds returns a boolean if a field has been set.

### GetMountType

`func (o *UpdateVirtualInstanceRequest) GetMountType() string`

GetMountType returns the MountType field if non-nil, zero value otherwise.

### GetMountTypeOk

`func (o *UpdateVirtualInstanceRequest) GetMountTypeOk() (*string, bool)`

GetMountTypeOk returns a tuple with the MountType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMountType

`func (o *UpdateVirtualInstanceRequest) SetMountType(v string)`

SetMountType sets MountType field to given value.

### HasMountType

`func (o *UpdateVirtualInstanceRequest) HasMountType() bool`

HasMountType returns a boolean if a field has been set.

### GetName

`func (o *UpdateVirtualInstanceRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *UpdateVirtualInstanceRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *UpdateVirtualInstanceRequest) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *UpdateVirtualInstanceRequest) HasName() bool`

HasName returns a boolean if a field has been set.

### GetNewSize

`func (o *UpdateVirtualInstanceRequest) GetNewSize() string`

GetNewSize returns the NewSize field if non-nil, zero value otherwise.

### GetNewSizeOk

`func (o *UpdateVirtualInstanceRequest) GetNewSizeOk() (*string, bool)`

GetNewSizeOk returns a tuple with the NewSize field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNewSize

`func (o *UpdateVirtualInstanceRequest) SetNewSize(v string)`

SetNewSize sets NewSize field to given value.

### HasNewSize

`func (o *UpdateVirtualInstanceRequest) HasNewSize() bool`

HasNewSize returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


