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
 * EventTimeInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-02-14T12:03:45.664Z")
public class EventTimeInfo {
  @SerializedName("field")
  private String field = null;

  @SerializedName("format")
  private String format = null;

  @SerializedName("time_zone")
  private String timeZone = null;

  public EventTimeInfo field(String field) {
    this.field = field;
    return this;
  }

   /**
   * Name of the field containing event time.
   * @return field
  **/

@JsonProperty("field")
@ApiModelProperty(example = "timestamp", required = true, value = "Name of the field containing event time.")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public EventTimeInfo format(String format) {
    this.format = format;
    return this;
  }

   /**
   * Format of time field, can be one of: milliseconds_since_epoch, seconds_since_epoch.
   * @return format
  **/

@JsonProperty("format")
@ApiModelProperty(example = "seconds_since_epoch", value = "Format of time field, can be one of: milliseconds_since_epoch, seconds_since_epoch.")
  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public EventTimeInfo timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

   /**
   * Default time zone, in standard IANA format.
   * @return timeZone
  **/

@JsonProperty("time_zone")
@ApiModelProperty(example = "UTC", value = "Default time zone, in standard IANA format.")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventTimeInfo eventTimeInfo = (EventTimeInfo) o;
    return Objects.equals(this.field, eventTimeInfo.field) &&
        Objects.equals(this.format, eventTimeInfo.format) &&
        Objects.equals(this.timeZone, eventTimeInfo.timeZone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, format, timeZone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventTimeInfo {\n");
    
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
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

