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
 * AwsRole
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-15T19:57:30.680Z")
public class AwsRole {
  @SerializedName("aws_external_id")
  private String awsExternalId = null;

  @SerializedName("aws_role_arn")
  private String awsRoleArn = null;

  public AwsRole awsExternalId(String awsExternalId) {
    this.awsExternalId = awsExternalId;
    return this;
  }

   /**
   * External id used for integration.
   * @return awsExternalId
  **/

@JsonProperty("aws_external_id")
@ApiModelProperty(example = "external id of aws", value = "External id used for integration.")
  public String getAwsExternalId() {
    return awsExternalId;
  }

  public void setAwsExternalId(String awsExternalId) {
    this.awsExternalId = awsExternalId;
  }

  public AwsRole awsRoleArn(String awsRoleArn) {
    this.awsRoleArn = awsRoleArn;
    return this;
  }

   /**
   * ARN of rockset-role created in your account.
   * @return awsRoleArn
  **/

@JsonProperty("aws_role_arn")
@ApiModelProperty(example = "arn:aws:iam::2378964092:role/rockset-role", required = true, value = "ARN of rockset-role created in your account.")
  public String getAwsRoleArn() {
    return awsRoleArn;
  }

  public void setAwsRoleArn(String awsRoleArn) {
    this.awsRoleArn = awsRoleArn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsRole awsRole = (AwsRole) o;
    return Objects.equals(this.awsExternalId, awsRole.awsExternalId) &&
        Objects.equals(this.awsRoleArn, awsRole.awsRoleArn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsExternalId, awsRoleArn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsRole {\n");
    
    sb.append("    awsExternalId: ").append(toIndentedString(awsExternalId)).append("\n");
    sb.append("    awsRoleArn: ").append(toIndentedString(awsRoleArn)).append("\n");
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

