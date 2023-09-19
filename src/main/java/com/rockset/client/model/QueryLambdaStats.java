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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * QueryLambdaStats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class QueryLambdaStats {
  @SerializedName("last_executed")
  private String lastExecuted = null;

  @SerializedName("last_executed_by")
  private String lastExecutedBy = null;

  @SerializedName("last_execution_error")
  private String lastExecutionError = null;

  @SerializedName("last_execution_error_message")
  private String lastExecutionErrorMessage = null;

  public QueryLambdaStats lastExecuted(String lastExecuted) {
    this.lastExecuted = lastExecuted;
    return this;
  }

   /**
   * ISO-8601 date.
   * @return lastExecuted
  **/

@JsonProperty("last_executed")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date.")
  public String getLastExecuted() {
    return lastExecuted;
  }

  public void setLastExecuted(String lastExecuted) {
    this.lastExecuted = lastExecuted;
  }

  public QueryLambdaStats lastExecutedBy(String lastExecutedBy) {
    this.lastExecutedBy = lastExecutedBy;
    return this;
  }

   /**
   * User who last executed Query Lambda.
   * @return lastExecutedBy
  **/

@JsonProperty("last_executed_by")
@ApiModelProperty(example = "...@rockset.com", value = "User who last executed Query Lambda.")
  public String getLastExecutedBy() {
    return lastExecutedBy;
  }

  public void setLastExecutedBy(String lastExecutedBy) {
    this.lastExecutedBy = lastExecutedBy;
  }

  public QueryLambdaStats lastExecutionError(String lastExecutionError) {
    this.lastExecutionError = lastExecutionError;
    return this;
  }

   /**
   * ISO-8601 date of last execution failure.
   * @return lastExecutionError
  **/

@JsonProperty("last_execution_error")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date of last execution failure.")
  public String getLastExecutionError() {
    return lastExecutionError;
  }

  public void setLastExecutionError(String lastExecutionError) {
    this.lastExecutionError = lastExecutionError;
  }

  public QueryLambdaStats lastExecutionErrorMessage(String lastExecutionErrorMessage) {
    this.lastExecutionErrorMessage = lastExecutionErrorMessage;
    return this;
  }

   /**
   * Error message associated with last failed execution.
   * @return lastExecutionErrorMessage
  **/

@JsonProperty("last_execution_error_message")
@ApiModelProperty(example = "[error message]", value = "Error message associated with last failed execution.")
  public String getLastExecutionErrorMessage() {
    return lastExecutionErrorMessage;
  }

  public void setLastExecutionErrorMessage(String lastExecutionErrorMessage) {
    this.lastExecutionErrorMessage = lastExecutionErrorMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryLambdaStats queryLambdaStats = (QueryLambdaStats) o;
    return Objects.equals(this.lastExecuted, queryLambdaStats.lastExecuted) &&
        Objects.equals(this.lastExecutedBy, queryLambdaStats.lastExecutedBy) &&
        Objects.equals(this.lastExecutionError, queryLambdaStats.lastExecutionError) &&
        Objects.equals(this.lastExecutionErrorMessage, queryLambdaStats.lastExecutionErrorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastExecuted, lastExecutedBy, lastExecutionError, lastExecutionErrorMessage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryLambdaStats {\n");
    
    sb.append("    lastExecuted: ").append(toIndentedString(lastExecuted)).append("\n");
    sb.append("    lastExecutedBy: ").append(toIndentedString(lastExecutedBy)).append("\n");
    sb.append("    lastExecutionError: ").append(toIndentedString(lastExecutionError)).append("\n");
    sb.append("    lastExecutionErrorMessage: ").append(toIndentedString(lastExecutionErrorMessage)).append("\n");
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

