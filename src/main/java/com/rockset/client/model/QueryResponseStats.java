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
 * QueryResponseStats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:21:47.964-07:00")
public class QueryResponseStats {
  @SerializedName("elapsed_time_ms")
  private Long elapsedTimeMs = null;

  @SerializedName("throttled_time_micros")
  private Long throttledTimeMicros = null;

  public QueryResponseStats elapsedTimeMs(Long elapsedTimeMs) {
    this.elapsedTimeMs = elapsedTimeMs;
    return this;
  }

   /**
   * Query time in milliseconds.
   * @return elapsedTimeMs
  **/

@JsonProperty("elapsed_time_ms")
@ApiModelProperty(example = "126", value = "Query time in milliseconds.")
  public Long getElapsedTimeMs() {
    return elapsedTimeMs;
  }

  public void setElapsedTimeMs(Long elapsedTimeMs) {
    this.elapsedTimeMs = elapsedTimeMs;
  }

  public QueryResponseStats throttledTimeMicros(Long throttledTimeMicros) {
    this.throttledTimeMicros = throttledTimeMicros;
    return this;
  }

   /**
   * Time query was throttled by admission control.
   * @return throttledTimeMicros
  **/

@JsonProperty("throttled_time_micros")
@ApiModelProperty(example = "126", value = "Time query was throttled by admission control.")
  public Long getThrottledTimeMicros() {
    return throttledTimeMicros;
  }

  public void setThrottledTimeMicros(Long throttledTimeMicros) {
    this.throttledTimeMicros = throttledTimeMicros;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryResponseStats queryResponseStats = (QueryResponseStats) o;
    return Objects.equals(this.elapsedTimeMs, queryResponseStats.elapsedTimeMs) &&
        Objects.equals(this.throttledTimeMicros, queryResponseStats.throttledTimeMicros);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elapsedTimeMs, throttledTimeMicros);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryResponseStats {\n");
    
    sb.append("    elapsedTimeMs: ").append(toIndentedString(elapsedTimeMs)).append("\n");
    sb.append("    throttledTimeMicros: ").append(toIndentedString(throttledTimeMicros)).append("\n");
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

