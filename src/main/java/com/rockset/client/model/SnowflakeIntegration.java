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

/** SnowflakeIntegration */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class SnowflakeIntegration {
  @SerializedName("aws_access_key")
  private AwsAccessKey awsAccessKey = null;

  @SerializedName("aws_role")
  private AwsRole awsRole = null;

  @SerializedName("default_warehouse")
  private String defaultWarehouse = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("s3_export_path")
  private String s3ExportPath = null;

  @SerializedName("snowflake_url")
  private String snowflakeUrl = null;

  @SerializedName("user_role")
  private String userRole = null;

  @SerializedName("username")
  private String username = null;

  public SnowflakeIntegration awsAccessKey(AwsAccessKey awsAccessKey) {
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

  public SnowflakeIntegration awsRole(AwsRole awsRole) {
    this.awsRole = awsRole;
    return this;
  }

  /**
   * Details of an AWS cross-account role integration.
   *
   * @return awsRole
   */
  @JsonProperty("aws_role")
  @ApiModelProperty(value = "Details of an AWS cross-account role integration.")
  public AwsRole getAwsRole() {
    return awsRole;
  }

  public void setAwsRole(AwsRole awsRole) {
    this.awsRole = awsRole;
  }

  public SnowflakeIntegration defaultWarehouse(String defaultWarehouse) {
    this.defaultWarehouse = defaultWarehouse;
    return this;
  }

  /**
   * default snowflake data warehouse name for query execution. Warehouse name can be overridden in
   * the collection.
   *
   * @return defaultWarehouse
   */
  @JsonProperty("default_warehouse")
  @ApiModelProperty(
      required = true,
      value =
          "default snowflake data warehouse name for query execution. Warehouse name can be overridden in the collection.")
  public String getDefaultWarehouse() {
    return defaultWarehouse;
  }

  public void setDefaultWarehouse(String defaultWarehouse) {
    this.defaultWarehouse = defaultWarehouse;
  }

  public SnowflakeIntegration password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Snowflake database password.
   *
   * @return password
   */
  @JsonProperty("password")
  @ApiModelProperty(required = true, value = "Snowflake database password.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public SnowflakeIntegration s3ExportPath(String s3ExportPath) {
    this.s3ExportPath = s3ExportPath;
    return this;
  }

  /**
   * S3 path used for running &#39;COPY INTO&#39; command on snowflake table.
   *
   * @return s3ExportPath
   */
  @JsonProperty("s3_export_path")
  @ApiModelProperty(
      example = "s3://bucket/prefix",
      required = true,
      value = "S3 path used for running 'COPY INTO' command on snowflake table.")
  public String getS3ExportPath() {
    return s3ExportPath;
  }

  public void setS3ExportPath(String s3ExportPath) {
    this.s3ExportPath = s3ExportPath;
  }

  public SnowflakeIntegration snowflakeUrl(String snowflakeUrl) {
    this.snowflakeUrl = snowflakeUrl;
    return this;
  }

  /**
   * Snowflake browser url.
   *
   * @return snowflakeUrl
   */
  @JsonProperty("snowflake_url")
  @ApiModelProperty(
      example = "acme-marketing-test-account.snowflakecomputing.com",
      required = true,
      value = "Snowflake browser url.")
  public String getSnowflakeUrl() {
    return snowflakeUrl;
  }

  public void setSnowflakeUrl(String snowflakeUrl) {
    this.snowflakeUrl = snowflakeUrl;
  }

  public SnowflakeIntegration userRole(String userRole) {
    this.userRole = userRole;
    return this;
  }

  /**
   * Snowflake user role. If unspecified, will use the default user role.
   *
   * @return userRole
   */
  @JsonProperty("user_role")
  @ApiModelProperty(value = "Snowflake user role. If unspecified, will use the default user role.")
  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public SnowflakeIntegration username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Snowflake database username.
   *
   * @return username
   */
  @JsonProperty("username")
  @ApiModelProperty(required = true, value = "Snowflake database username.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnowflakeIntegration snowflakeIntegration = (SnowflakeIntegration) o;
    return Objects.equals(this.awsAccessKey, snowflakeIntegration.awsAccessKey)
        && Objects.equals(this.awsRole, snowflakeIntegration.awsRole)
        && Objects.equals(this.defaultWarehouse, snowflakeIntegration.defaultWarehouse)
        && Objects.equals(this.password, snowflakeIntegration.password)
        && Objects.equals(this.s3ExportPath, snowflakeIntegration.s3ExportPath)
        && Objects.equals(this.snowflakeUrl, snowflakeIntegration.snowflakeUrl)
        && Objects.equals(this.userRole, snowflakeIntegration.userRole)
        && Objects.equals(this.username, snowflakeIntegration.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        awsAccessKey,
        awsRole,
        defaultWarehouse,
        password,
        s3ExportPath,
        snowflakeUrl,
        userRole,
        username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnowflakeIntegration {\n");

    sb.append("    awsAccessKey: ").append(toIndentedString(awsAccessKey)).append("\n");
    sb.append("    awsRole: ").append(toIndentedString(awsRole)).append("\n");
    sb.append("    defaultWarehouse: ").append(toIndentedString(defaultWarehouse)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    s3ExportPath: ").append(toIndentedString(s3ExportPath)).append("\n");
    sb.append("    snowflakeUrl: ").append(toIndentedString(snowflakeUrl)).append("\n");
    sb.append("    userRole: ").append(toIndentedString(userRole)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
