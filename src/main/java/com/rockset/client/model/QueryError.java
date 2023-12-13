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
 * QueryError
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-13T21:29:19.801Z")
public class QueryError {
  @SerializedName("message")
  private String message = null;

  @SerializedName("status_code")
  private Integer statusCode = null;

  @SerializedName("type")
  private String type = null;

  public QueryError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * A message associated with the error, containing more information about it.
   * @return message
  **/

@JsonProperty("message")
@ApiModelProperty(example = "Too many rows", value = "A message associated with the error, containing more information about it.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public QueryError statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

   /**
   * The HTTP status code associated with this error, had it been sent as the response status code
   * @return statusCode
  **/

@JsonProperty("status_code")
@ApiModelProperty(example = "429", value = "The HTTP status code associated with this error, had it been sent as the response status code")
  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public QueryError type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of error.
   * @return type
  **/

@JsonProperty("type")
@ApiModelProperty(example = "ResourceExceeded", value = "The type of error.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryError queryError = (QueryError) o;
    return Objects.equals(this.message, queryError.message) &&
        Objects.equals(this.statusCode, queryError.statusCode) &&
        Objects.equals(this.type, queryError.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, statusCode, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryError {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

