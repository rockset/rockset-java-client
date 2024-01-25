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
 * SourceAzBlobStorageSettings
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-25T12:03:52.511Z")
public class SourceAzBlobStorageSettings {
  @SerializedName("azblob_scan_frequency")
  private String azblobScanFrequency = null;

  public SourceAzBlobStorageSettings azblobScanFrequency(String azblobScanFrequency) {
    this.azblobScanFrequency = azblobScanFrequency;
    return this;
  }

   /**
   * Rockset scans an Azure blob Storage container based on a defined time interval. The scan frequency determines the length of time between a new scan and the previous scan. If the previous scan finds new objects or updates to existing objects, Rockset immediately scans the bucket again after processing changes from the previous scan. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn&#39;t account for DST, leap seconds and leap years. Minimum value: PT1S. Maximum value: PT1H.
   * @return azblobScanFrequency
  **/

@JsonProperty("azblob_scan_frequency")
@ApiModelProperty(example = "PT5M", value = "Rockset scans an Azure blob Storage container based on a defined time interval. The scan frequency determines the length of time between a new scan and the previous scan. If the previous scan finds new objects or updates to existing objects, Rockset immediately scans the bucket again after processing changes from the previous scan. Duration value is of type ISO 8601 (e.g. PT5H, PT4M, PT3S). It doesn't account for DST, leap seconds and leap years. Minimum value: PT1S. Maximum value: PT1H.")
  public String getAzblobScanFrequency() {
    return azblobScanFrequency;
  }

  public void setAzblobScanFrequency(String azblobScanFrequency) {
    this.azblobScanFrequency = azblobScanFrequency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceAzBlobStorageSettings sourceAzBlobStorageSettings = (SourceAzBlobStorageSettings) o;
    return Objects.equals(this.azblobScanFrequency, sourceAzBlobStorageSettings.azblobScanFrequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(azblobScanFrequency);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceAzBlobStorageSettings {\n");
    
    sb.append("    azblobScanFrequency: ").append(toIndentedString(azblobScanFrequency)).append("\n");
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

