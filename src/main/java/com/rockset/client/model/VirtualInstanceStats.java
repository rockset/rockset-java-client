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
 * VirtualInstanceStats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-31T12:04:03.466Z")
public class VirtualInstanceStats {
  @SerializedName("last_queried_ms")
  private Long lastQueriedMs = null;

  public VirtualInstanceStats lastQueriedMs(Long lastQueriedMs) {
    this.lastQueriedMs = lastQueriedMs;
    return this;
  }

   /**
   * Milliseconds since Unix epoch Jan 1, 1970.
   * @return lastQueriedMs
  **/

@JsonProperty("last_queried_ms")
@ApiModelProperty(example = "1535101119334", value = "Milliseconds since Unix epoch Jan 1, 1970.")
  public Long getLastQueriedMs() {
    return lastQueriedMs;
  }

  public void setLastQueriedMs(Long lastQueriedMs) {
    this.lastQueriedMs = lastQueriedMs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualInstanceStats virtualInstanceStats = (VirtualInstanceStats) o;
    return Objects.equals(this.lastQueriedMs, virtualInstanceStats.lastQueriedMs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastQueriedMs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualInstanceStats {\n");
    
    sb.append("    lastQueriedMs: ").append(toIndentedString(lastQueriedMs)).append("\n");
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

