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

/** DynamodbIntegration */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class DynamodbIntegration {
  @SerializedName("aws_access_key")
  private AwsAccessKey awsAccessKey = null;

  @SerializedName("aws_role")
  private AwsRole awsRole = null;

  @SerializedName("s3_export_bucket_name")
  private String s3ExportBucketName = null;

  public DynamodbIntegration awsAccessKey(AwsAccessKey awsAccessKey) {
    this.awsAccessKey = awsAccessKey;
    return this;
  }

  /**
   * Credentials for an AWS access key integration.
   *
   * @return awsAccessKey
   */
  @JsonProperty("aws_access_key")
  @ApiModelProperty(value = "Credentials for an AWS access key integration.")
  public AwsAccessKey getAwsAccessKey() {
    return awsAccessKey;
  }

  public void setAwsAccessKey(AwsAccessKey awsAccessKey) {
    this.awsAccessKey = awsAccessKey;
  }

  public DynamodbIntegration awsRole(AwsRole awsRole) {
    this.awsRole = awsRole;
    return this;
  }

  /**
   * Role used for external id type authentication.
   *
   * @return awsRole
   */
  @JsonProperty("aws_role")
  @ApiModelProperty(value = "Role used for external id type authentication.")
  public AwsRole getAwsRole() {
    return awsRole;
  }

  public void setAwsRole(AwsRole awsRole) {
    this.awsRole = awsRole;
  }

  public DynamodbIntegration s3ExportBucketName(String s3ExportBucketName) {
    this.s3ExportBucketName = s3ExportBucketName;
    return this;
  }

  /**
   * S3 bucket used for export during collection initial dump.
   *
   * @return s3ExportBucketName
   */
  @JsonProperty("s3_export_bucket_name")
  @ApiModelProperty(value = "S3 bucket used for export during collection initial dump.")
  public String getS3ExportBucketName() {
    return s3ExportBucketName;
  }

  public void setS3ExportBucketName(String s3ExportBucketName) {
    this.s3ExportBucketName = s3ExportBucketName;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DynamodbIntegration dynamodbIntegration = (DynamodbIntegration) o;
    return Objects.equals(this.awsAccessKey, dynamodbIntegration.awsAccessKey)
        && Objects.equals(this.awsRole, dynamodbIntegration.awsRole)
        && Objects.equals(this.s3ExportBucketName, dynamodbIntegration.s3ExportBucketName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsAccessKey, awsRole, s3ExportBucketName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DynamodbIntegration {\n");

    sb.append("    awsAccessKey: ").append(toIndentedString(awsAccessKey)).append("\n");
    sb.append("    awsRole: ").append(toIndentedString(awsRole)).append("\n");
    sb.append("    s3ExportBucketName: ").append(toIndentedString(s3ExportBucketName)).append("\n");
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
