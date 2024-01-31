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
 * SourceDynamoDbSettings
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-31T12:04:03.466Z")
public class SourceDynamoDbSettings {
  @SerializedName("dynamodb_stream_poll_frequency")
  private String dynamodbStreamPollFrequency = null;

  public SourceDynamoDbSettings dynamodbStreamPollFrequency(String dynamodbStreamPollFrequency) {
    this.dynamodbStreamPollFrequency = dynamodbStreamPollFrequency;
    return this;
  }

   /**
   * Each DynamoDB stream can have one to many shards, and Rockset polls each DynamoDB shard at a fixed rate. Decreasing the duration between polls helps reduce ingest latency, while increasing the duration can prevent  Rockset from keeping up with the updates. If the latency exceeds 24 hours (DynamoDB stream retention duration), Rockset will not be able to process all of the streaming updates. Each request also has a fixed price associated with it. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn&#39;t account for DST, leap seconds and leap years. Minimum value: PT0.25S. Maximum value: PT5M.
   * @return dynamodbStreamPollFrequency
  **/

@JsonProperty("dynamodb_stream_poll_frequency")
@ApiModelProperty(example = "PT1S", value = "Each DynamoDB stream can have one to many shards, and Rockset polls each DynamoDB shard at a fixed rate. Decreasing the duration between polls helps reduce ingest latency, while increasing the duration can prevent  Rockset from keeping up with the updates. If the latency exceeds 24 hours (DynamoDB stream retention duration), Rockset will not be able to process all of the streaming updates. Each request also has a fixed price associated with it. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn't account for DST, leap seconds and leap years. Minimum value: PT0.25S. Maximum value: PT5M.")
  public String getDynamodbStreamPollFrequency() {
    return dynamodbStreamPollFrequency;
  }

  public void setDynamodbStreamPollFrequency(String dynamodbStreamPollFrequency) {
    this.dynamodbStreamPollFrequency = dynamodbStreamPollFrequency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceDynamoDbSettings sourceDynamoDbSettings = (SourceDynamoDbSettings) o;
    return Objects.equals(this.dynamodbStreamPollFrequency, sourceDynamoDbSettings.dynamodbStreamPollFrequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dynamodbStreamPollFrequency);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceDynamoDbSettings {\n");
    
    sb.append("    dynamodbStreamPollFrequency: ").append(toIndentedString(dynamodbStreamPollFrequency)).append("\n");
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

