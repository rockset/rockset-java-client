# FormatParams

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Avro** | Pointer to **map[string]interface{}** |  | [optional] 
**Bson** | Pointer to **bool** |  | [optional] 
**Csv** | Pointer to [**CsvParams**](CsvParams.md) |  | [optional] 
**Json** | Pointer to **bool** | Source data is in json format. | [optional] 
**MssqlDms** | Pointer to **bool** |  | [optional] 
**MysqlDms** | Pointer to **bool** |  | [optional] 
**OracleDms** | Pointer to **bool** |  | [optional] 
**PostgresDms** | Pointer to **bool** |  | [optional] 
**Xml** | Pointer to [**XmlParams**](XmlParams.md) |  | [optional] 

## Methods

### NewFormatParams

`func NewFormatParams() *FormatParams`

NewFormatParams instantiates a new FormatParams object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFormatParamsWithDefaults

`func NewFormatParamsWithDefaults() *FormatParams`

NewFormatParamsWithDefaults instantiates a new FormatParams object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAvro

`func (o *FormatParams) GetAvro() map[string]interface{}`

GetAvro returns the Avro field if non-nil, zero value otherwise.

### GetAvroOk

`func (o *FormatParams) GetAvroOk() (*map[string]interface{}, bool)`

GetAvroOk returns a tuple with the Avro field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAvro

`func (o *FormatParams) SetAvro(v map[string]interface{})`

SetAvro sets Avro field to given value.

### HasAvro

`func (o *FormatParams) HasAvro() bool`

HasAvro returns a boolean if a field has been set.

### GetBson

`func (o *FormatParams) GetBson() bool`

GetBson returns the Bson field if non-nil, zero value otherwise.

### GetBsonOk

`func (o *FormatParams) GetBsonOk() (*bool, bool)`

GetBsonOk returns a tuple with the Bson field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBson

`func (o *FormatParams) SetBson(v bool)`

SetBson sets Bson field to given value.

### HasBson

`func (o *FormatParams) HasBson() bool`

HasBson returns a boolean if a field has been set.

### GetCsv

`func (o *FormatParams) GetCsv() CsvParams`

GetCsv returns the Csv field if non-nil, zero value otherwise.

### GetCsvOk

`func (o *FormatParams) GetCsvOk() (*CsvParams, bool)`

GetCsvOk returns a tuple with the Csv field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCsv

`func (o *FormatParams) SetCsv(v CsvParams)`

SetCsv sets Csv field to given value.

### HasCsv

`func (o *FormatParams) HasCsv() bool`

HasCsv returns a boolean if a field has been set.

### GetJson

`func (o *FormatParams) GetJson() bool`

GetJson returns the Json field if non-nil, zero value otherwise.

### GetJsonOk

`func (o *FormatParams) GetJsonOk() (*bool, bool)`

GetJsonOk returns a tuple with the Json field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetJson

`func (o *FormatParams) SetJson(v bool)`

SetJson sets Json field to given value.

### HasJson

`func (o *FormatParams) HasJson() bool`

HasJson returns a boolean if a field has been set.

### GetMssqlDms

`func (o *FormatParams) GetMssqlDms() bool`

GetMssqlDms returns the MssqlDms field if non-nil, zero value otherwise.

### GetMssqlDmsOk

`func (o *FormatParams) GetMssqlDmsOk() (*bool, bool)`

GetMssqlDmsOk returns a tuple with the MssqlDms field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMssqlDms

`func (o *FormatParams) SetMssqlDms(v bool)`

SetMssqlDms sets MssqlDms field to given value.

### HasMssqlDms

`func (o *FormatParams) HasMssqlDms() bool`

HasMssqlDms returns a boolean if a field has been set.

### GetMysqlDms

`func (o *FormatParams) GetMysqlDms() bool`

GetMysqlDms returns the MysqlDms field if non-nil, zero value otherwise.

### GetMysqlDmsOk

`func (o *FormatParams) GetMysqlDmsOk() (*bool, bool)`

GetMysqlDmsOk returns a tuple with the MysqlDms field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMysqlDms

`func (o *FormatParams) SetMysqlDms(v bool)`

SetMysqlDms sets MysqlDms field to given value.

### HasMysqlDms

`func (o *FormatParams) HasMysqlDms() bool`

HasMysqlDms returns a boolean if a field has been set.

### GetOracleDms

`func (o *FormatParams) GetOracleDms() bool`

GetOracleDms returns the OracleDms field if non-nil, zero value otherwise.

### GetOracleDmsOk

`func (o *FormatParams) GetOracleDmsOk() (*bool, bool)`

GetOracleDmsOk returns a tuple with the OracleDms field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOracleDms

`func (o *FormatParams) SetOracleDms(v bool)`

SetOracleDms sets OracleDms field to given value.

### HasOracleDms

`func (o *FormatParams) HasOracleDms() bool`

HasOracleDms returns a boolean if a field has been set.

### GetPostgresDms

`func (o *FormatParams) GetPostgresDms() bool`

GetPostgresDms returns the PostgresDms field if non-nil, zero value otherwise.

### GetPostgresDmsOk

`func (o *FormatParams) GetPostgresDmsOk() (*bool, bool)`

GetPostgresDmsOk returns a tuple with the PostgresDms field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPostgresDms

`func (o *FormatParams) SetPostgresDms(v bool)`

SetPostgresDms sets PostgresDms field to given value.

### HasPostgresDms

`func (o *FormatParams) HasPostgresDms() bool`

HasPostgresDms returns a boolean if a field has been set.

### GetXml

`func (o *FormatParams) GetXml() XmlParams`

GetXml returns the Xml field if non-nil, zero value otherwise.

### GetXmlOk

`func (o *FormatParams) GetXmlOk() (*XmlParams, bool)`

GetXmlOk returns a tuple with the Xml field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetXml

`func (o *FormatParams) SetXml(v XmlParams)`

SetXml sets Xml field to given value.

### HasXml

`func (o *FormatParams) HasXml() bool`

HasXml returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


