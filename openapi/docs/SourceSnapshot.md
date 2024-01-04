# SourceSnapshot

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**SourceCollectionPath** | Pointer to **string** | A representation of the workspace and collection where the source snapshot originated. | [optional] 
**SourceSnapshotRrn** | Pointer to **string** | RRN of the snapshot that the new collection will be created from. | [optional] 

## Methods

### NewSourceSnapshot

`func NewSourceSnapshot() *SourceSnapshot`

NewSourceSnapshot instantiates a new SourceSnapshot object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSourceSnapshotWithDefaults

`func NewSourceSnapshotWithDefaults() *SourceSnapshot`

NewSourceSnapshotWithDefaults instantiates a new SourceSnapshot object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSourceCollectionPath

`func (o *SourceSnapshot) GetSourceCollectionPath() string`

GetSourceCollectionPath returns the SourceCollectionPath field if non-nil, zero value otherwise.

### GetSourceCollectionPathOk

`func (o *SourceSnapshot) GetSourceCollectionPathOk() (*string, bool)`

GetSourceCollectionPathOk returns a tuple with the SourceCollectionPath field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSourceCollectionPath

`func (o *SourceSnapshot) SetSourceCollectionPath(v string)`

SetSourceCollectionPath sets SourceCollectionPath field to given value.

### HasSourceCollectionPath

`func (o *SourceSnapshot) HasSourceCollectionPath() bool`

HasSourceCollectionPath returns a boolean if a field has been set.

### GetSourceSnapshotRrn

`func (o *SourceSnapshot) GetSourceSnapshotRrn() string`

GetSourceSnapshotRrn returns the SourceSnapshotRrn field if non-nil, zero value otherwise.

### GetSourceSnapshotRrnOk

`func (o *SourceSnapshot) GetSourceSnapshotRrnOk() (*string, bool)`

GetSourceSnapshotRrnOk returns a tuple with the SourceSnapshotRrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSourceSnapshotRrn

`func (o *SourceSnapshot) SetSourceSnapshotRrn(v string)`

SetSourceSnapshotRrn sets SourceSnapshotRrn field to given value.

### HasSourceSnapshotRrn

`func (o *SourceSnapshot) HasSourceSnapshotRrn() bool`

HasSourceSnapshotRrn returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


