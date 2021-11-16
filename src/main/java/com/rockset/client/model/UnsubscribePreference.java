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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** Notification preferences for the user. */
@ApiModel(description = "Notification preferences for the user.")
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-11-12T22:54:16.921Z")
public class UnsubscribePreference {
  @SerializedName("notificationType")
  private String notificationType = null;

  public UnsubscribePreference notificationType(String notificationType) {
    this.notificationType = notificationType;
    return this;
  }

  /**
   * The type of notification to be unsubscribed from.
   *
   * @return notificationType
   */
  @JsonProperty("notificationType")
  @ApiModelProperty(
      example = "create_apikey",
      required = true,
      value = "The type of notification to be unsubscribed from.")
  public String getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(String notificationType) {
    this.notificationType = notificationType;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnsubscribePreference unsubscribePreference = (UnsubscribePreference) o;
    return Objects.equals(this.notificationType, unsubscribePreference.notificationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notificationType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnsubscribePreference {\n");

    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
