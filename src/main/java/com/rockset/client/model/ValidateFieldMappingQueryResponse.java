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
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** ValidateFieldMappingQueryResponse */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2022-04-15T10:38:36.284-04:00")
public class ValidateFieldMappingQueryResponse {
  @SerializedName("valid")
  private Boolean valid = null;

  @SerializedName("reason")
  private String reason = null;

  @SerializedName("is_rollup")
  private Boolean isRollup = null;

  @SerializedName("has_id_mapping")
  private Boolean hasIdMapping = null;

  public ValidateFieldMappingQueryResponse valid(Boolean valid) {
    this.valid = valid;
    return this;
  }

  /**
   * Whether the field mapping query is valid
   *
   * @return valid
   */
  @JsonProperty("valid")
  @ApiModelProperty(example = "true", value = "Whether the field mapping query is valid")
  public Boolean isValid() {
    return valid;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  public ValidateFieldMappingQueryResponse reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * The reason if field mapping query is invalid
   *
   * @return reason
   */
  @JsonProperty("reason")
  @ApiModelProperty(
      example = "Invalid SQL expression. Incorrect SQL syntax near..",
      value = "The reason if field mapping query is invalid")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ValidateFieldMappingQueryResponse isRollup(Boolean isRollup) {
    this.isRollup = isRollup;
    return this;
  }

  /**
   * Get isRollup
   *
   * @return isRollup
   */
  @JsonProperty("is_rollup")
  @ApiModelProperty(value = "")
  public Boolean isIsRollup() {
    return isRollup;
  }

  public void setIsRollup(Boolean isRollup) {
    this.isRollup = isRollup;
  }

  public ValidateFieldMappingQueryResponse hasIdMapping(Boolean hasIdMapping) {
    this.hasIdMapping = hasIdMapping;
    return this;
  }

  /**
   * Get hasIdMapping
   *
   * @return hasIdMapping
   */
  @JsonProperty("has_id_mapping")
  @ApiModelProperty(value = "")
  public Boolean isHasIdMapping() {
    return hasIdMapping;
  }

  public void setHasIdMapping(Boolean hasIdMapping) {
    this.hasIdMapping = hasIdMapping;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateFieldMappingQueryResponse validateFieldMappingQueryResponse =
        (ValidateFieldMappingQueryResponse) o;
    return Objects.equals(this.valid, validateFieldMappingQueryResponse.valid)
        && Objects.equals(this.reason, validateFieldMappingQueryResponse.reason)
        && Objects.equals(this.isRollup, validateFieldMappingQueryResponse.isRollup)
        && Objects.equals(this.hasIdMapping, validateFieldMappingQueryResponse.hasIdMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valid, reason, isRollup, hasIdMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateFieldMappingQueryResponse {\n");

    sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    isRollup: ").append(toIndentedString(isRollup)).append("\n");
    sb.append("    hasIdMapping: ").append(toIndentedString(hasIdMapping)).append("\n");
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
