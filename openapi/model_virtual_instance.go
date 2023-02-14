/*
REST API

Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
)

// VirtualInstance struct for VirtualInstance
type VirtualInstance struct {
	// Virtual instance name.
	Name string `json:"name"`
	// Virtual instance description.
	Description *string `json:"description,omitempty"`
	// Creator of requested virtual instance.
	CreatedBy *string `json:"created_by,omitempty"`
	// ISO-8601 date of when virtual instance was created.
	CreatedAt *string `json:"created_at,omitempty"`
	// ISO-8601 date of when virtual instance was created.
	ResumedAt *string `json:"resumed_at,omitempty"`
	// Virtual instance state.
	State *string `json:"state,omitempty"`
	// Virtual instance current size.
	CurrentSize *string `json:"current_size,omitempty"`
	// Virtual instance desired size.
	DesiredSize *string `json:"desired_size,omitempty"`
	MonitoringEnabled *bool `json:"monitoring_enabled,omitempty"`
	DefaultVi *bool `json:"default_vi,omitempty"`
	DefaultPodCount *int32 `json:"default_pod_count,omitempty"`
	ScaledPodCount *int32 `json:"scaled_pod_count,omitempty"`
	// Unique identifier for virtual instance.
	Id *string `json:"id,omitempty"`
	// Virtual Instance RRN.
	Rrn *string `json:"rrn,omitempty"`
	// Number of seconds without queries after which the VI is suspended
	AutoSuspendSeconds *int32 `json:"auto_suspend_seconds,omitempty"`
	Stats *VirtualInstanceStats `json:"stats,omitempty"`
}

// NewVirtualInstance instantiates a new VirtualInstance object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewVirtualInstance(name string) *VirtualInstance {
	this := VirtualInstance{}
	this.Name = name
	return &this
}

// NewVirtualInstanceWithDefaults instantiates a new VirtualInstance object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewVirtualInstanceWithDefaults() *VirtualInstance {
	this := VirtualInstance{}
	return &this
}

// GetName returns the Name field value
func (o *VirtualInstance) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetNameOk() (*string, bool) {
	if o == nil  {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *VirtualInstance) SetName(v string) {
	o.Name = v
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *VirtualInstance) GetDescription() string {
	if o == nil || o.Description == nil {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetDescriptionOk() (*string, bool) {
	if o == nil || o.Description == nil {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *VirtualInstance) HasDescription() bool {
	if o != nil && o.Description != nil {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *VirtualInstance) SetDescription(v string) {
	o.Description = &v
}

// GetCreatedBy returns the CreatedBy field value if set, zero value otherwise.
func (o *VirtualInstance) GetCreatedBy() string {
	if o == nil || o.CreatedBy == nil {
		var ret string
		return ret
	}
	return *o.CreatedBy
}

// GetCreatedByOk returns a tuple with the CreatedBy field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetCreatedByOk() (*string, bool) {
	if o == nil || o.CreatedBy == nil {
		return nil, false
	}
	return o.CreatedBy, true
}

// HasCreatedBy returns a boolean if a field has been set.
func (o *VirtualInstance) HasCreatedBy() bool {
	if o != nil && o.CreatedBy != nil {
		return true
	}

	return false
}

// SetCreatedBy gets a reference to the given string and assigns it to the CreatedBy field.
func (o *VirtualInstance) SetCreatedBy(v string) {
	o.CreatedBy = &v
}

// GetCreatedAt returns the CreatedAt field value if set, zero value otherwise.
func (o *VirtualInstance) GetCreatedAt() string {
	if o == nil || o.CreatedAt == nil {
		var ret string
		return ret
	}
	return *o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetCreatedAtOk() (*string, bool) {
	if o == nil || o.CreatedAt == nil {
		return nil, false
	}
	return o.CreatedAt, true
}

// HasCreatedAt returns a boolean if a field has been set.
func (o *VirtualInstance) HasCreatedAt() bool {
	if o != nil && o.CreatedAt != nil {
		return true
	}

	return false
}

// SetCreatedAt gets a reference to the given string and assigns it to the CreatedAt field.
func (o *VirtualInstance) SetCreatedAt(v string) {
	o.CreatedAt = &v
}

// GetResumedAt returns the ResumedAt field value if set, zero value otherwise.
func (o *VirtualInstance) GetResumedAt() string {
	if o == nil || o.ResumedAt == nil {
		var ret string
		return ret
	}
	return *o.ResumedAt
}

// GetResumedAtOk returns a tuple with the ResumedAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetResumedAtOk() (*string, bool) {
	if o == nil || o.ResumedAt == nil {
		return nil, false
	}
	return o.ResumedAt, true
}

// HasResumedAt returns a boolean if a field has been set.
func (o *VirtualInstance) HasResumedAt() bool {
	if o != nil && o.ResumedAt != nil {
		return true
	}

	return false
}

// SetResumedAt gets a reference to the given string and assigns it to the ResumedAt field.
func (o *VirtualInstance) SetResumedAt(v string) {
	o.ResumedAt = &v
}

// GetState returns the State field value if set, zero value otherwise.
func (o *VirtualInstance) GetState() string {
	if o == nil || o.State == nil {
		var ret string
		return ret
	}
	return *o.State
}

// GetStateOk returns a tuple with the State field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetStateOk() (*string, bool) {
	if o == nil || o.State == nil {
		return nil, false
	}
	return o.State, true
}

// HasState returns a boolean if a field has been set.
func (o *VirtualInstance) HasState() bool {
	if o != nil && o.State != nil {
		return true
	}

	return false
}

// SetState gets a reference to the given string and assigns it to the State field.
func (o *VirtualInstance) SetState(v string) {
	o.State = &v
}

// GetCurrentSize returns the CurrentSize field value if set, zero value otherwise.
func (o *VirtualInstance) GetCurrentSize() string {
	if o == nil || o.CurrentSize == nil {
		var ret string
		return ret
	}
	return *o.CurrentSize
}

// GetCurrentSizeOk returns a tuple with the CurrentSize field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetCurrentSizeOk() (*string, bool) {
	if o == nil || o.CurrentSize == nil {
		return nil, false
	}
	return o.CurrentSize, true
}

// HasCurrentSize returns a boolean if a field has been set.
func (o *VirtualInstance) HasCurrentSize() bool {
	if o != nil && o.CurrentSize != nil {
		return true
	}

	return false
}

// SetCurrentSize gets a reference to the given string and assigns it to the CurrentSize field.
func (o *VirtualInstance) SetCurrentSize(v string) {
	o.CurrentSize = &v
}

// GetDesiredSize returns the DesiredSize field value if set, zero value otherwise.
func (o *VirtualInstance) GetDesiredSize() string {
	if o == nil || o.DesiredSize == nil {
		var ret string
		return ret
	}
	return *o.DesiredSize
}

// GetDesiredSizeOk returns a tuple with the DesiredSize field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetDesiredSizeOk() (*string, bool) {
	if o == nil || o.DesiredSize == nil {
		return nil, false
	}
	return o.DesiredSize, true
}

// HasDesiredSize returns a boolean if a field has been set.
func (o *VirtualInstance) HasDesiredSize() bool {
	if o != nil && o.DesiredSize != nil {
		return true
	}

	return false
}

// SetDesiredSize gets a reference to the given string and assigns it to the DesiredSize field.
func (o *VirtualInstance) SetDesiredSize(v string) {
	o.DesiredSize = &v
}

// GetMonitoringEnabled returns the MonitoringEnabled field value if set, zero value otherwise.
func (o *VirtualInstance) GetMonitoringEnabled() bool {
	if o == nil || o.MonitoringEnabled == nil {
		var ret bool
		return ret
	}
	return *o.MonitoringEnabled
}

// GetMonitoringEnabledOk returns a tuple with the MonitoringEnabled field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetMonitoringEnabledOk() (*bool, bool) {
	if o == nil || o.MonitoringEnabled == nil {
		return nil, false
	}
	return o.MonitoringEnabled, true
}

// HasMonitoringEnabled returns a boolean if a field has been set.
func (o *VirtualInstance) HasMonitoringEnabled() bool {
	if o != nil && o.MonitoringEnabled != nil {
		return true
	}

	return false
}

// SetMonitoringEnabled gets a reference to the given bool and assigns it to the MonitoringEnabled field.
func (o *VirtualInstance) SetMonitoringEnabled(v bool) {
	o.MonitoringEnabled = &v
}

// GetDefaultVi returns the DefaultVi field value if set, zero value otherwise.
func (o *VirtualInstance) GetDefaultVi() bool {
	if o == nil || o.DefaultVi == nil {
		var ret bool
		return ret
	}
	return *o.DefaultVi
}

// GetDefaultViOk returns a tuple with the DefaultVi field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetDefaultViOk() (*bool, bool) {
	if o == nil || o.DefaultVi == nil {
		return nil, false
	}
	return o.DefaultVi, true
}

// HasDefaultVi returns a boolean if a field has been set.
func (o *VirtualInstance) HasDefaultVi() bool {
	if o != nil && o.DefaultVi != nil {
		return true
	}

	return false
}

// SetDefaultVi gets a reference to the given bool and assigns it to the DefaultVi field.
func (o *VirtualInstance) SetDefaultVi(v bool) {
	o.DefaultVi = &v
}

// GetDefaultPodCount returns the DefaultPodCount field value if set, zero value otherwise.
func (o *VirtualInstance) GetDefaultPodCount() int32 {
	if o == nil || o.DefaultPodCount == nil {
		var ret int32
		return ret
	}
	return *o.DefaultPodCount
}

// GetDefaultPodCountOk returns a tuple with the DefaultPodCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetDefaultPodCountOk() (*int32, bool) {
	if o == nil || o.DefaultPodCount == nil {
		return nil, false
	}
	return o.DefaultPodCount, true
}

// HasDefaultPodCount returns a boolean if a field has been set.
func (o *VirtualInstance) HasDefaultPodCount() bool {
	if o != nil && o.DefaultPodCount != nil {
		return true
	}

	return false
}

// SetDefaultPodCount gets a reference to the given int32 and assigns it to the DefaultPodCount field.
func (o *VirtualInstance) SetDefaultPodCount(v int32) {
	o.DefaultPodCount = &v
}

// GetScaledPodCount returns the ScaledPodCount field value if set, zero value otherwise.
func (o *VirtualInstance) GetScaledPodCount() int32 {
	if o == nil || o.ScaledPodCount == nil {
		var ret int32
		return ret
	}
	return *o.ScaledPodCount
}

// GetScaledPodCountOk returns a tuple with the ScaledPodCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetScaledPodCountOk() (*int32, bool) {
	if o == nil || o.ScaledPodCount == nil {
		return nil, false
	}
	return o.ScaledPodCount, true
}

// HasScaledPodCount returns a boolean if a field has been set.
func (o *VirtualInstance) HasScaledPodCount() bool {
	if o != nil && o.ScaledPodCount != nil {
		return true
	}

	return false
}

// SetScaledPodCount gets a reference to the given int32 and assigns it to the ScaledPodCount field.
func (o *VirtualInstance) SetScaledPodCount(v int32) {
	o.ScaledPodCount = &v
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *VirtualInstance) GetId() string {
	if o == nil || o.Id == nil {
		var ret string
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetIdOk() (*string, bool) {
	if o == nil || o.Id == nil {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *VirtualInstance) HasId() bool {
	if o != nil && o.Id != nil {
		return true
	}

	return false
}

// SetId gets a reference to the given string and assigns it to the Id field.
func (o *VirtualInstance) SetId(v string) {
	o.Id = &v
}

// GetRrn returns the Rrn field value if set, zero value otherwise.
func (o *VirtualInstance) GetRrn() string {
	if o == nil || o.Rrn == nil {
		var ret string
		return ret
	}
	return *o.Rrn
}

// GetRrnOk returns a tuple with the Rrn field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetRrnOk() (*string, bool) {
	if o == nil || o.Rrn == nil {
		return nil, false
	}
	return o.Rrn, true
}

// HasRrn returns a boolean if a field has been set.
func (o *VirtualInstance) HasRrn() bool {
	if o != nil && o.Rrn != nil {
		return true
	}

	return false
}

// SetRrn gets a reference to the given string and assigns it to the Rrn field.
func (o *VirtualInstance) SetRrn(v string) {
	o.Rrn = &v
}

// GetAutoSuspendSeconds returns the AutoSuspendSeconds field value if set, zero value otherwise.
func (o *VirtualInstance) GetAutoSuspendSeconds() int32 {
	if o == nil || o.AutoSuspendSeconds == nil {
		var ret int32
		return ret
	}
	return *o.AutoSuspendSeconds
}

// GetAutoSuspendSecondsOk returns a tuple with the AutoSuspendSeconds field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetAutoSuspendSecondsOk() (*int32, bool) {
	if o == nil || o.AutoSuspendSeconds == nil {
		return nil, false
	}
	return o.AutoSuspendSeconds, true
}

// HasAutoSuspendSeconds returns a boolean if a field has been set.
func (o *VirtualInstance) HasAutoSuspendSeconds() bool {
	if o != nil && o.AutoSuspendSeconds != nil {
		return true
	}

	return false
}

// SetAutoSuspendSeconds gets a reference to the given int32 and assigns it to the AutoSuspendSeconds field.
func (o *VirtualInstance) SetAutoSuspendSeconds(v int32) {
	o.AutoSuspendSeconds = &v
}

// GetStats returns the Stats field value if set, zero value otherwise.
func (o *VirtualInstance) GetStats() VirtualInstanceStats {
	if o == nil || o.Stats == nil {
		var ret VirtualInstanceStats
		return ret
	}
	return *o.Stats
}

// GetStatsOk returns a tuple with the Stats field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *VirtualInstance) GetStatsOk() (*VirtualInstanceStats, bool) {
	if o == nil || o.Stats == nil {
		return nil, false
	}
	return o.Stats, true
}

// HasStats returns a boolean if a field has been set.
func (o *VirtualInstance) HasStats() bool {
	if o != nil && o.Stats != nil {
		return true
	}

	return false
}

// SetStats gets a reference to the given VirtualInstanceStats and assigns it to the Stats field.
func (o *VirtualInstance) SetStats(v VirtualInstanceStats) {
	o.Stats = &v
}

func (o VirtualInstance) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if true {
		toSerialize["name"] = o.Name
	}
	if o.Description != nil {
		toSerialize["description"] = o.Description
	}
	if o.CreatedBy != nil {
		toSerialize["created_by"] = o.CreatedBy
	}
	if o.CreatedAt != nil {
		toSerialize["created_at"] = o.CreatedAt
	}
	if o.ResumedAt != nil {
		toSerialize["resumed_at"] = o.ResumedAt
	}
	if o.State != nil {
		toSerialize["state"] = o.State
	}
	if o.CurrentSize != nil {
		toSerialize["current_size"] = o.CurrentSize
	}
	if o.DesiredSize != nil {
		toSerialize["desired_size"] = o.DesiredSize
	}
	if o.MonitoringEnabled != nil {
		toSerialize["monitoring_enabled"] = o.MonitoringEnabled
	}
	if o.DefaultVi != nil {
		toSerialize["default_vi"] = o.DefaultVi
	}
	if o.DefaultPodCount != nil {
		toSerialize["default_pod_count"] = o.DefaultPodCount
	}
	if o.ScaledPodCount != nil {
		toSerialize["scaled_pod_count"] = o.ScaledPodCount
	}
	if o.Id != nil {
		toSerialize["id"] = o.Id
	}
	if o.Rrn != nil {
		toSerialize["rrn"] = o.Rrn
	}
	if o.AutoSuspendSeconds != nil {
		toSerialize["auto_suspend_seconds"] = o.AutoSuspendSeconds
	}
	if o.Stats != nil {
		toSerialize["stats"] = o.Stats
	}
	return json.Marshal(toSerialize)
}

type NullableVirtualInstance struct {
	value *VirtualInstance
	isSet bool
}

func (v NullableVirtualInstance) Get() *VirtualInstance {
	return v.value
}

func (v *NullableVirtualInstance) Set(val *VirtualInstance) {
	v.value = val
	v.isSet = true
}

func (v NullableVirtualInstance) IsSet() bool {
	return v.isSet
}

func (v *NullableVirtualInstance) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableVirtualInstance(val *VirtualInstance) *NullableVirtualInstance {
	return &NullableVirtualInstance{value: val, isSet: true}
}

func (v NullableVirtualInstance) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableVirtualInstance) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

