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

/** SourceSnowflake */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class SourceSnowflake {
  @SerializedName("database")
  private String database = null;

  @SerializedName("schema")
  private String schema = null;

  @SerializedName("status")
  private StatusSnowflake status = null;

  @SerializedName("table_name")
  private String tableName = null;

  @SerializedName("warehouse")
  private String warehouse = null;

  public SourceSnowflake database(String database) {
    this.database = database;
    return this;
  }

  /**
   * Name of the snowflake database.
   *
   * @return database
   */
  @JsonProperty("database")
  @ApiModelProperty(example = "NASDAQ", required = true, value = "Name of the snowflake database.")
  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public SourceSnowflake schema(String schema) {
    this.schema = schema;
    return this;
  }

  /**
   * Name of the snowflake database schema.
   *
   * @return schema
   */
  @JsonProperty("schema")
  @ApiModelProperty(
      example = "PUBLIC",
      required = true,
      value = "Name of the snowflake database schema.")
  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  /**
   * Snowflake source status.
   *
   * @return status
   */
  @JsonProperty("status")
  @ApiModelProperty(value = "Snowflake source status.")
  public StatusSnowflake getStatus() {
    return status;
  }

  public SourceSnowflake tableName(String tableName) {
    this.tableName = tableName;
    return this;
  }

  /**
   * Name of the snowflake table.
   *
   * @return tableName
   */
  @JsonProperty("table_name")
  @ApiModelProperty(example = "COMPANIES", required = true, value = "Name of the snowflake table.")
  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public SourceSnowflake warehouse(String warehouse) {
    this.warehouse = warehouse;
    return this;
  }

  /**
   * Name of the data warehouse to be used.
   *
   * @return warehouse
   */
  @JsonProperty("warehouse")
  @ApiModelProperty(example = "COMPUTE_XL", value = "Name of the data warehouse to be used.")
  public String getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(String warehouse) {
    this.warehouse = warehouse;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceSnowflake sourceSnowflake = (SourceSnowflake) o;
    return Objects.equals(this.database, sourceSnowflake.database)
        && Objects.equals(this.schema, sourceSnowflake.schema)
        && Objects.equals(this.status, sourceSnowflake.status)
        && Objects.equals(this.tableName, sourceSnowflake.tableName)
        && Objects.equals(this.warehouse, sourceSnowflake.warehouse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(database, schema, status, tableName, warehouse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceSnowflake {\n");

    sb.append("    database: ").append(toIndentedString(database)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tableName: ").append(toIndentedString(tableName)).append("\n");
    sb.append("    warehouse: ").append(toIndentedString(warehouse)).append("\n");
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
