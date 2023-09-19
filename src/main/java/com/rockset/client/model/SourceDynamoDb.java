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
import com.rockset.client.model.StatusDynamoDb;
import com.rockset.client.model.StatusDynamoDbV2;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SourceDynamoDb
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class SourceDynamoDb {
  @SerializedName("aws_region")
  private String awsRegion = null;

  @SerializedName("current_status")
  private StatusDynamoDbV2 currentStatus = null;

  @SerializedName("rcu")
  private Long rcu = null;

  @SerializedName("status")
  private StatusDynamoDb status = null;

  @SerializedName("table_name")
  private String tableName = null;

  @SerializedName("use_scan_api")
  private Boolean useScanApi = null;

  public SourceDynamoDb awsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return this;
  }

   /**
   * AWS region name of DynamoDB table, by default us-west-2 is used.
   * @return awsRegion
  **/

@JsonProperty("aws_region")
@ApiModelProperty(example = "us-east-2", value = "AWS region name of DynamoDB table, by default us-west-2 is used.")
  public String getAwsRegion() {
    return awsRegion;
  }

  public void setAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
  }

   /**
   * DynamoDB source status v2.
   * @return currentStatus
  **/

@JsonProperty("current_status")
@ApiModelProperty(value = "DynamoDB source status v2.")
  public StatusDynamoDbV2 getCurrentStatus() {
    return currentStatus;
  }

  public SourceDynamoDb rcu(Long rcu) {
    this.rcu = rcu;
    return this;
  }

   /**
   * Max RCU usage for scan.
   * @return rcu
  **/

@JsonProperty("rcu")
@ApiModelProperty(example = "1000", value = "Max RCU usage for scan.")
  public Long getRcu() {
    return rcu;
  }

  public void setRcu(Long rcu) {
    this.rcu = rcu;
  }

   /**
   * DynamoDB source status.
   * @return status
  **/

@JsonProperty("status")
@ApiModelProperty(value = "DynamoDB source status.")
  public StatusDynamoDb getStatus() {
    return status;
  }

  public SourceDynamoDb tableName(String tableName) {
    this.tableName = tableName;
    return this;
  }

   /**
   * Name of DynamoDB table containing data.
   * @return tableName
  **/

@JsonProperty("table_name")
@ApiModelProperty(example = "dynamodb_table_name", required = true, value = "Name of DynamoDB table containing data.")
  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public SourceDynamoDb useScanApi(Boolean useScanApi) {
    this.useScanApi = useScanApi;
    return this;
  }

   /**
   * Whether to use DynamoDB Scan API for the initial scan.
   * @return useScanApi
  **/

@JsonProperty("use_scan_api")
@ApiModelProperty(value = "Whether to use DynamoDB Scan API for the initial scan.")
  public Boolean isUseScanApi() {
    return useScanApi;
  }

  public void setUseScanApi(Boolean useScanApi) {
    this.useScanApi = useScanApi;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceDynamoDb sourceDynamoDb = (SourceDynamoDb) o;
    return Objects.equals(this.awsRegion, sourceDynamoDb.awsRegion) &&
        Objects.equals(this.currentStatus, sourceDynamoDb.currentStatus) &&
        Objects.equals(this.rcu, sourceDynamoDb.rcu) &&
        Objects.equals(this.status, sourceDynamoDb.status) &&
        Objects.equals(this.tableName, sourceDynamoDb.tableName) &&
        Objects.equals(this.useScanApi, sourceDynamoDb.useScanApi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsRegion, currentStatus, rcu, status, tableName, useScanApi);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceDynamoDb {\n");
    
    sb.append("    awsRegion: ").append(toIndentedString(awsRegion)).append("\n");
    sb.append("    currentStatus: ").append(toIndentedString(currentStatus)).append("\n");
    sb.append("    rcu: ").append(toIndentedString(rcu)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tableName: ").append(toIndentedString(tableName)).append("\n");
    sb.append("    useScanApi: ").append(toIndentedString(useScanApi)).append("\n");
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

