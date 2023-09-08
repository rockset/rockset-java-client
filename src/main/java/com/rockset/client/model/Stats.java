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
 * Stats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:46:16.821-07:00")
public class Stats {
  @SerializedName("elapsed_time_ms")
  private Long elapsedTimeMs = null;

  @SerializedName("result_set_bytes_size")
  private Long resultSetBytesSize = null;

  @SerializedName("result_set_document_count")
  private Long resultSetDocumentCount = null;

  @SerializedName("throttled_time_ms")
  private Long throttledTimeMs = null;

  public Stats elapsedTimeMs(Long elapsedTimeMs) {
    this.elapsedTimeMs = elapsedTimeMs;
    return this;
  }

   /**
   * Total execution time (including time queued) of the query, in milliseconds.
   * @return elapsedTimeMs
  **/

@JsonProperty("elapsed_time_ms")
@ApiModelProperty(example = "128", value = "Total execution time (including time queued) of the query, in milliseconds.")
  public Long getElapsedTimeMs() {
    return elapsedTimeMs;
  }

  public void setElapsedTimeMs(Long elapsedTimeMs) {
    this.elapsedTimeMs = elapsedTimeMs;
  }

  public Stats resultSetBytesSize(Long resultSetBytesSize) {
    this.resultSetBytesSize = resultSetBytesSize;
    return this;
  }

   /**
   * Number of bytes in the query result set. Only populated if &#x60;status&#x60; is &#x60;COMPLETE&#x60;. Not populated for INSERT INTO queries.
   * @return resultSetBytesSize
  **/

@JsonProperty("result_set_bytes_size")
@ApiModelProperty(example = "1235", value = "Number of bytes in the query result set. Only populated if `status` is `COMPLETE`. Not populated for INSERT INTO queries.")
  public Long getResultSetBytesSize() {
    return resultSetBytesSize;
  }

  public void setResultSetBytesSize(Long resultSetBytesSize) {
    this.resultSetBytesSize = resultSetBytesSize;
  }

  public Stats resultSetDocumentCount(Long resultSetDocumentCount) {
    this.resultSetDocumentCount = resultSetDocumentCount;
    return this;
  }

   /**
   * Number of documents returned by the query. Only populated if &#x60;status&#x60; is &#x60;COMPLETE&#x60;.
   * @return resultSetDocumentCount
  **/

@JsonProperty("result_set_document_count")
@ApiModelProperty(example = "1235", value = "Number of documents returned by the query. Only populated if `status` is `COMPLETE`.")
  public Long getResultSetDocumentCount() {
    return resultSetDocumentCount;
  }

  public void setResultSetDocumentCount(Long resultSetDocumentCount) {
    this.resultSetDocumentCount = resultSetDocumentCount;
  }

  public Stats throttledTimeMs(Long throttledTimeMs) {
    this.throttledTimeMs = throttledTimeMs;
    return this;
  }

   /**
   * Time query spent queued, in milliseconds.
   * @return throttledTimeMs
  **/

@JsonProperty("throttled_time_ms")
@ApiModelProperty(example = "16", value = "Time query spent queued, in milliseconds.")
  public Long getThrottledTimeMs() {
    return throttledTimeMs;
  }

  public void setThrottledTimeMs(Long throttledTimeMs) {
    this.throttledTimeMs = throttledTimeMs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stats stats = (Stats) o;
    return Objects.equals(this.elapsedTimeMs, stats.elapsedTimeMs) &&
        Objects.equals(this.resultSetBytesSize, stats.resultSetBytesSize) &&
        Objects.equals(this.resultSetDocumentCount, stats.resultSetDocumentCount) &&
        Objects.equals(this.throttledTimeMs, stats.throttledTimeMs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elapsedTimeMs, resultSetBytesSize, resultSetDocumentCount, throttledTimeMs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stats {\n");
    
    sb.append("    elapsedTimeMs: ").append(toIndentedString(elapsedTimeMs)).append("\n");
    sb.append("    resultSetBytesSize: ").append(toIndentedString(resultSetBytesSize)).append("\n");
    sb.append("    resultSetDocumentCount: ").append(toIndentedString(resultSetDocumentCount)).append("\n");
    sb.append("    throttledTimeMs: ").append(toIndentedString(throttledTimeMs)).append("\n");
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
