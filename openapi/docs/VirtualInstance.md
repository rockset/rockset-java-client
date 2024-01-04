# VirtualInstance

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AutoScalingPolicy** | Pointer to [**AutoScalingPolicy**](AutoScalingPolicy.md) |  | [optional] 
**AutoSuspendSeconds** | Pointer to **int32** | Number of seconds without queries after which the VI is suspended | [optional] 
**CreatedAt** | Pointer to **string** | ISO-8601 date of when virtual instance was created. | [optional] 
**CreatedBy** | Pointer to **string** | Creator of requested virtual instance. | [optional] 
**CurrentSize** | Pointer to **string** | Virtual instance current size. | [optional] [readonly] 
**DefaultPodCount** | Pointer to **int32** |  | [optional] 
**DefaultVi** | Pointer to **bool** |  | [optional] 
**Description** | Pointer to **string** | Virtual instance description. | [optional] 
**DesiredSize** | Pointer to **string** | Virtual instance desired size. | [optional] [readonly] 
**EnableRemountOnResume** | Pointer to **bool** | When a Virtual Instance is resumed, it will remount all collections that were mounted when the Virtual Instance was suspended. | [optional] 
**Id** | Pointer to **string** | Unique identifier for virtual instance. | [optional] 
**MonitoringEnabled** | Pointer to **bool** |  | [optional] 
**MountRefreshIntervalSeconds** | Pointer to **int32** | DEPRECATED. Number of seconds between data refreshes for mounts on this Virtual Instance | [optional] 
**MountType** | Pointer to **string** | The mount type of collections that this Virtual Instance will query. Live mounted collections stay up-to-date with the underlying collection in real-time. Static mounted collections do not stay up-to-date. See https://docs.rockset.com/documentation/docs/virtual-instances#virtual-instance-configuration | [optional] 
**Name** | **string** | Virtual instance name. | 
**ResumedAt** | Pointer to **string** | ISO-8601 date of when virtual instance was created. | [optional] 
**Rrn** | Pointer to **string** | Virtual Instance RRN. | [optional] 
**ScaledPodCount** | Pointer to **int32** |  | [optional] 
**State** | Pointer to **string** | Virtual instance state. | [optional] 
**Stats** | Pointer to [**VirtualInstanceStats**](VirtualInstanceStats.md) |  | [optional] 

## Methods

### NewVirtualInstance

`func NewVirtualInstance(name string, ) *VirtualInstance`

NewVirtualInstance instantiates a new VirtualInstance object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewVirtualInstanceWithDefaults

`func NewVirtualInstanceWithDefaults() *VirtualInstance`

NewVirtualInstanceWithDefaults instantiates a new VirtualInstance object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAutoScalingPolicy

`func (o *VirtualInstance) GetAutoScalingPolicy() AutoScalingPolicy`

GetAutoScalingPolicy returns the AutoScalingPolicy field if non-nil, zero value otherwise.

### GetAutoScalingPolicyOk

`func (o *VirtualInstance) GetAutoScalingPolicyOk() (*AutoScalingPolicy, bool)`

GetAutoScalingPolicyOk returns a tuple with the AutoScalingPolicy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAutoScalingPolicy

`func (o *VirtualInstance) SetAutoScalingPolicy(v AutoScalingPolicy)`

SetAutoScalingPolicy sets AutoScalingPolicy field to given value.

### HasAutoScalingPolicy

`func (o *VirtualInstance) HasAutoScalingPolicy() bool`

HasAutoScalingPolicy returns a boolean if a field has been set.

### GetAutoSuspendSeconds

`func (o *VirtualInstance) GetAutoSuspendSeconds() int32`

GetAutoSuspendSeconds returns the AutoSuspendSeconds field if non-nil, zero value otherwise.

### GetAutoSuspendSecondsOk

`func (o *VirtualInstance) GetAutoSuspendSecondsOk() (*int32, bool)`

GetAutoSuspendSecondsOk returns a tuple with the AutoSuspendSeconds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAutoSuspendSeconds

`func (o *VirtualInstance) SetAutoSuspendSeconds(v int32)`

SetAutoSuspendSeconds sets AutoSuspendSeconds field to given value.

### HasAutoSuspendSeconds

`func (o *VirtualInstance) HasAutoSuspendSeconds() bool`

HasAutoSuspendSeconds returns a boolean if a field has been set.

### GetCreatedAt

`func (o *VirtualInstance) GetCreatedAt() string`

GetCreatedAt returns the CreatedAt field if non-nil, zero value otherwise.

### GetCreatedAtOk

`func (o *VirtualInstance) GetCreatedAtOk() (*string, bool)`

GetCreatedAtOk returns a tuple with the CreatedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreatedAt

`func (o *VirtualInstance) SetCreatedAt(v string)`

SetCreatedAt sets CreatedAt field to given value.

### HasCreatedAt

`func (o *VirtualInstance) HasCreatedAt() bool`

HasCreatedAt returns a boolean if a field has been set.

### GetCreatedBy

`func (o *VirtualInstance) GetCreatedBy() string`

GetCreatedBy returns the CreatedBy field if non-nil, zero value otherwise.

### GetCreatedByOk

`func (o *VirtualInstance) GetCreatedByOk() (*string, bool)`

GetCreatedByOk returns a tuple with the CreatedBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreatedBy

`func (o *VirtualInstance) SetCreatedBy(v string)`

SetCreatedBy sets CreatedBy field to given value.

### HasCreatedBy

`func (o *VirtualInstance) HasCreatedBy() bool`

HasCreatedBy returns a boolean if a field has been set.

### GetCurrentSize

`func (o *VirtualInstance) GetCurrentSize() string`

GetCurrentSize returns the CurrentSize field if non-nil, zero value otherwise.

### GetCurrentSizeOk

`func (o *VirtualInstance) GetCurrentSizeOk() (*string, bool)`

GetCurrentSizeOk returns a tuple with the CurrentSize field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCurrentSize

`func (o *VirtualInstance) SetCurrentSize(v string)`

SetCurrentSize sets CurrentSize field to given value.

### HasCurrentSize

`func (o *VirtualInstance) HasCurrentSize() bool`

HasCurrentSize returns a boolean if a field has been set.

### GetDefaultPodCount

`func (o *VirtualInstance) GetDefaultPodCount() int32`

GetDefaultPodCount returns the DefaultPodCount field if non-nil, zero value otherwise.

### GetDefaultPodCountOk

`func (o *VirtualInstance) GetDefaultPodCountOk() (*int32, bool)`

GetDefaultPodCountOk returns a tuple with the DefaultPodCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDefaultPodCount

`func (o *VirtualInstance) SetDefaultPodCount(v int32)`

SetDefaultPodCount sets DefaultPodCount field to given value.

### HasDefaultPodCount

`func (o *VirtualInstance) HasDefaultPodCount() bool`

HasDefaultPodCount returns a boolean if a field has been set.

### GetDefaultVi

`func (o *VirtualInstance) GetDefaultVi() bool`

GetDefaultVi returns the DefaultVi field if non-nil, zero value otherwise.

### GetDefaultViOk

`func (o *VirtualInstance) GetDefaultViOk() (*bool, bool)`

GetDefaultViOk returns a tuple with the DefaultVi field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDefaultVi

`func (o *VirtualInstance) SetDefaultVi(v bool)`

SetDefaultVi sets DefaultVi field to given value.

### HasDefaultVi

`func (o *VirtualInstance) HasDefaultVi() bool`

HasDefaultVi returns a boolean if a field has been set.

### GetDescription

`func (o *VirtualInstance) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *VirtualInstance) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *VirtualInstance) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *VirtualInstance) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetDesiredSize

`func (o *VirtualInstance) GetDesiredSize() string`

GetDesiredSize returns the DesiredSize field if non-nil, zero value otherwise.

### GetDesiredSizeOk

`func (o *VirtualInstance) GetDesiredSizeOk() (*string, bool)`

GetDesiredSizeOk returns a tuple with the DesiredSize field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDesiredSize

`func (o *VirtualInstance) SetDesiredSize(v string)`

SetDesiredSize sets DesiredSize field to given value.

### HasDesiredSize

`func (o *VirtualInstance) HasDesiredSize() bool`

HasDesiredSize returns a boolean if a field has been set.

### GetEnableRemountOnResume

`func (o *VirtualInstance) GetEnableRemountOnResume() bool`

GetEnableRemountOnResume returns the EnableRemountOnResume field if non-nil, zero value otherwise.

### GetEnableRemountOnResumeOk

`func (o *VirtualInstance) GetEnableRemountOnResumeOk() (*bool, bool)`

GetEnableRemountOnResumeOk returns a tuple with the EnableRemountOnResume field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnableRemountOnResume

`func (o *VirtualInstance) SetEnableRemountOnResume(v bool)`

SetEnableRemountOnResume sets EnableRemountOnResume field to given value.

### HasEnableRemountOnResume

`func (o *VirtualInstance) HasEnableRemountOnResume() bool`

HasEnableRemountOnResume returns a boolean if a field has been set.

### GetId

`func (o *VirtualInstance) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *VirtualInstance) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *VirtualInstance) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *VirtualInstance) HasId() bool`

HasId returns a boolean if a field has been set.

### GetMonitoringEnabled

`func (o *VirtualInstance) GetMonitoringEnabled() bool`

GetMonitoringEnabled returns the MonitoringEnabled field if non-nil, zero value otherwise.

### GetMonitoringEnabledOk

`func (o *VirtualInstance) GetMonitoringEnabledOk() (*bool, bool)`

GetMonitoringEnabledOk returns a tuple with the MonitoringEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMonitoringEnabled

`func (o *VirtualInstance) SetMonitoringEnabled(v bool)`

SetMonitoringEnabled sets MonitoringEnabled field to given value.

### HasMonitoringEnabled

`func (o *VirtualInstance) HasMonitoringEnabled() bool`

HasMonitoringEnabled returns a boolean if a field has been set.

### GetMountRefreshIntervalSeconds

`func (o *VirtualInstance) GetMountRefreshIntervalSeconds() int32`

GetMountRefreshIntervalSeconds returns the MountRefreshIntervalSeconds field if non-nil, zero value otherwise.

### GetMountRefreshIntervalSecondsOk

`func (o *VirtualInstance) GetMountRefreshIntervalSecondsOk() (*int32, bool)`

GetMountRefreshIntervalSecondsOk returns a tuple with the MountRefreshIntervalSeconds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMountRefreshIntervalSeconds

`func (o *VirtualInstance) SetMountRefreshIntervalSeconds(v int32)`

SetMountRefreshIntervalSeconds sets MountRefreshIntervalSeconds field to given value.

### HasMountRefreshIntervalSeconds

`func (o *VirtualInstance) HasMountRefreshIntervalSeconds() bool`

HasMountRefreshIntervalSeconds returns a boolean if a field has been set.

### GetMountType

`func (o *VirtualInstance) GetMountType() string`

GetMountType returns the MountType field if non-nil, zero value otherwise.

### GetMountTypeOk

`func (o *VirtualInstance) GetMountTypeOk() (*string, bool)`

GetMountTypeOk returns a tuple with the MountType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMountType

`func (o *VirtualInstance) SetMountType(v string)`

SetMountType sets MountType field to given value.

### HasMountType

`func (o *VirtualInstance) HasMountType() bool`

HasMountType returns a boolean if a field has been set.

### GetName

`func (o *VirtualInstance) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *VirtualInstance) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *VirtualInstance) SetName(v string)`

SetName sets Name field to given value.


### GetResumedAt

`func (o *VirtualInstance) GetResumedAt() string`

GetResumedAt returns the ResumedAt field if non-nil, zero value otherwise.

### GetResumedAtOk

`func (o *VirtualInstance) GetResumedAtOk() (*string, bool)`

GetResumedAtOk returns a tuple with the ResumedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResumedAt

`func (o *VirtualInstance) SetResumedAt(v string)`

SetResumedAt sets ResumedAt field to given value.

### HasResumedAt

`func (o *VirtualInstance) HasResumedAt() bool`

HasResumedAt returns a boolean if a field has been set.

### GetRrn

`func (o *VirtualInstance) GetRrn() string`

GetRrn returns the Rrn field if non-nil, zero value otherwise.

### GetRrnOk

`func (o *VirtualInstance) GetRrnOk() (*string, bool)`

GetRrnOk returns a tuple with the Rrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRrn

`func (o *VirtualInstance) SetRrn(v string)`

SetRrn sets Rrn field to given value.

### HasRrn

`func (o *VirtualInstance) HasRrn() bool`

HasRrn returns a boolean if a field has been set.

### GetScaledPodCount

`func (o *VirtualInstance) GetScaledPodCount() int32`

GetScaledPodCount returns the ScaledPodCount field if non-nil, zero value otherwise.

### GetScaledPodCountOk

`func (o *VirtualInstance) GetScaledPodCountOk() (*int32, bool)`

GetScaledPodCountOk returns a tuple with the ScaledPodCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetScaledPodCount

`func (o *VirtualInstance) SetScaledPodCount(v int32)`

SetScaledPodCount sets ScaledPodCount field to given value.

### HasScaledPodCount

`func (o *VirtualInstance) HasScaledPodCount() bool`

HasScaledPodCount returns a boolean if a field has been set.

### GetState

`func (o *VirtualInstance) GetState() string`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *VirtualInstance) GetStateOk() (*string, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *VirtualInstance) SetState(v string)`

SetState sets State field to given value.

### HasState

`func (o *VirtualInstance) HasState() bool`

HasState returns a boolean if a field has been set.

### GetStats

`func (o *VirtualInstance) GetStats() VirtualInstanceStats`

GetStats returns the Stats field if non-nil, zero value otherwise.

### GetStatsOk

`func (o *VirtualInstance) GetStatsOk() (*VirtualInstanceStats, bool)`

GetStatsOk returns a tuple with the Stats field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStats

`func (o *VirtualInstance) SetStats(v VirtualInstanceStats)`

SetStats sets Stats field to given value.

### HasStats

`func (o *VirtualInstance) HasStats() bool`

HasStats returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


