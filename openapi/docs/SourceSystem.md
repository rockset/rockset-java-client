# SourceSystem

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | Pointer to **string** | The type of this system source. | [optional] 
**Workspace** | Pointer to **string** | The workspace for which collections will have logs created. If unspecified, logs will be created for collections in all workspaces. Currently only supported for the INGEST_LOGS system source. | [optional] 

## Methods

### NewSourceSystem

`func NewSourceSystem() *SourceSystem`

NewSourceSystem instantiates a new SourceSystem object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceSystemWithDefaults

`func NewSourceSystemWithDefaults() *SourceSystem`

NewSourceSystemWithDefaults instantiates a new SourceSystem object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *SourceSystem) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *SourceSystem) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *SourceSystem) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *SourceSystem) HasType() bool`

HasType returns a boolean if a field has been set.

### GetWorkspace

`func (o *SourceSystem) GetWorkspace() string`

GetWorkspace returns the Workspace field if non-nil, zero value otherwise.

### GetWorkspaceOk

`func (o *SourceSystem) GetWorkspaceOk() (*string, bool)`

GetWorkspaceOk returns a tuple with the Workspace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkspace

`func (o *SourceSystem) SetWorkspace(v string)`

SetWorkspace sets Workspace field to given value.

### HasWorkspace

`func (o *SourceSystem) HasWorkspace() bool`

HasWorkspace returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


