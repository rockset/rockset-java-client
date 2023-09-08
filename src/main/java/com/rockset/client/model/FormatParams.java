/*
 * REST API
 * Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.rockset.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.rockset.client.model.AvroParams;
import com.rockset.client.model.CsvParams;
import com.rockset.client.model.XmlParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * FormatParams
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:21:47.964-07:00")
public class FormatParams {
  @SerializedName("avro")
  private AvroParams avro = null;

  @SerializedName("csv")
  private CsvParams csv = null;

  @SerializedName("json")
  private Boolean json = null;

  @SerializedName("mssql_dms")
  private Boolean mssqlDms = null;

  @SerializedName("mysql_dms")
  private Boolean mysqlDms = null;

  @SerializedName("oracle_dms")
  private Boolean oracleDms = null;

  @SerializedName("postgres_dms")
  private Boolean postgresDms = null;

  @SerializedName("xml")
  private XmlParams xml = null;

  public FormatParams avro(AvroParams avro) {
    this.avro = avro;
    return this;
  }

   /**
   * Get avro
   * @return avro
  **/

@JsonProperty("avro")
@ApiModelProperty(value = "")
  public AvroParams getAvro() {
    return avro;
  }

  public void setAvro(AvroParams avro) {
    this.avro = avro;
  }

  public FormatParams csv(CsvParams csv) {
    this.csv = csv;
    return this;
  }

   /**
   * Get csv
   * @return csv
  **/

@JsonProperty("csv")
@ApiModelProperty(value = "")
  public CsvParams getCsv() {
    return csv;
  }

  public void setCsv(CsvParams csv) {
    this.csv = csv;
  }

  public FormatParams json(Boolean json) {
    this.json = json;
    return this;
  }

   /**
   * Source data is in json format.
   * @return json
  **/

@JsonProperty("json")
@ApiModelProperty(example = "true", value = "Source data is in json format.")
  public Boolean isJson() {
    return json;
  }

  public void setJson(Boolean json) {
    this.json = json;
  }

  public FormatParams mssqlDms(Boolean mssqlDms) {
    this.mssqlDms = mssqlDms;
    return this;
  }

   /**
   * Get mssqlDms
   * @return mssqlDms
  **/

@JsonProperty("mssql_dms")
@ApiModelProperty(value = "")
  public Boolean isMssqlDms() {
    return mssqlDms;
  }

  public void setMssqlDms(Boolean mssqlDms) {
    this.mssqlDms = mssqlDms;
  }

  public FormatParams mysqlDms(Boolean mysqlDms) {
    this.mysqlDms = mysqlDms;
    return this;
  }

   /**
   * Get mysqlDms
   * @return mysqlDms
  **/

@JsonProperty("mysql_dms")
@ApiModelProperty(value = "")
  public Boolean isMysqlDms() {
    return mysqlDms;
  }

  public void setMysqlDms(Boolean mysqlDms) {
    this.mysqlDms = mysqlDms;
  }

  public FormatParams oracleDms(Boolean oracleDms) {
    this.oracleDms = oracleDms;
    return this;
  }

   /**
   * Get oracleDms
   * @return oracleDms
  **/

@JsonProperty("oracle_dms")
@ApiModelProperty(value = "")
  public Boolean isOracleDms() {
    return oracleDms;
  }

  public void setOracleDms(Boolean oracleDms) {
    this.oracleDms = oracleDms;
  }

  public FormatParams postgresDms(Boolean postgresDms) {
    this.postgresDms = postgresDms;
    return this;
  }

   /**
   * Get postgresDms
   * @return postgresDms
  **/

@JsonProperty("postgres_dms")
@ApiModelProperty(value = "")
  public Boolean isPostgresDms() {
    return postgresDms;
  }

  public void setPostgresDms(Boolean postgresDms) {
    this.postgresDms = postgresDms;
  }

  public FormatParams xml(XmlParams xml) {
    this.xml = xml;
    return this;
  }

   /**
   * Get xml
   * @return xml
  **/

@JsonProperty("xml")
@ApiModelProperty(value = "")
  public XmlParams getXml() {
    return xml;
  }

  public void setXml(XmlParams xml) {
    this.xml = xml;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormatParams formatParams = (FormatParams) o;
    return Objects.equals(this.avro, formatParams.avro) &&
        Objects.equals(this.csv, formatParams.csv) &&
        Objects.equals(this.json, formatParams.json) &&
        Objects.equals(this.mssqlDms, formatParams.mssqlDms) &&
        Objects.equals(this.mysqlDms, formatParams.mysqlDms) &&
        Objects.equals(this.oracleDms, formatParams.oracleDms) &&
        Objects.equals(this.postgresDms, formatParams.postgresDms) &&
        Objects.equals(this.xml, formatParams.xml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avro, csv, json, mssqlDms, mysqlDms, oracleDms, postgresDms, xml);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormatParams {\n");
    
    sb.append("    avro: ").append(toIndentedString(avro)).append("\n");
    sb.append("    csv: ").append(toIndentedString(csv)).append("\n");
    sb.append("    json: ").append(toIndentedString(json)).append("\n");
    sb.append("    mssqlDms: ").append(toIndentedString(mssqlDms)).append("\n");
    sb.append("    mysqlDms: ").append(toIndentedString(mysqlDms)).append("\n");
    sb.append("    oracleDms: ").append(toIndentedString(oracleDms)).append("\n");
    sb.append("    postgresDms: ").append(toIndentedString(postgresDms)).append("\n");
    sb.append("    xml: ").append(toIndentedString(xml)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

