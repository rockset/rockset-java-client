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

/** UpdateQueryLambdaRequest */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-11-12T22:54:16.921Z")
public class UpdateQueryLambdaRequest {
  @SerializedName("description")
  private String description = null;

  @SerializedName("sql")
  private QueryLambdaSql sql = null;

  public UpdateQueryLambdaRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * optional description
   *
   * @return description
   */
  @JsonProperty("description")
  @ApiModelProperty(example = "production version foo", value = "optional description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateQueryLambdaRequest sql(QueryLambdaSql sql) {
    this.sql = sql;
    return this;
  }

  /**
   * Query Lambda SQL query
   *
   * @return sql
   */
  @JsonProperty("sql")
  @ApiModelProperty(value = "Query Lambda SQL query")
  public QueryLambdaSql getSql() {
    return sql;
  }

  public void setSql(QueryLambdaSql sql) {
    this.sql = sql;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateQueryLambdaRequest updateQueryLambdaRequest = (UpdateQueryLambdaRequest) o;
    return Objects.equals(this.description, updateQueryLambdaRequest.description)
        && Objects.equals(this.sql, updateQueryLambdaRequest.sql);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, sql);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateQueryLambdaRequest {\n");

    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    sql: ").append(toIndentedString(sql)).append("\n");
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
