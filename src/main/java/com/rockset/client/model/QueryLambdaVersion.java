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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** QueryLambdaVersion */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-11-12T22:54:16.921Z")
public class QueryLambdaVersion {
  @SerializedName("workspace")
  private String workspace = null;

  @SerializedName("created_by")
  private String createdBy = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("sql")
  private QueryLambdaSql sql = null;

  @SerializedName("collections")
  private List<String> collections = null;

  /** status of this Query Lambda */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    ACTIVE("ACTIVE"),

    INVALID_SQL("INVALIDSQL");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("state")
  private StateEnum state = null;

  @SerializedName("stats")
  private QueryLambdaStats stats = null;

  public QueryLambdaVersion workspace(String workspace) {
    this.workspace = workspace;
    return this;
  }

  /**
   * workspace of this Query Lambda
   *
   * @return workspace
   */
  @JsonProperty("workspace")
  @ApiModelProperty(example = "commons", value = "workspace of this Query Lambda")
  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }

  public QueryLambdaVersion createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * user that created this Query Lambda
   *
   * @return createdBy
   */
  @JsonProperty("created_by")
  @ApiModelProperty(example = "..@rockset.com", value = "user that created this Query Lambda")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public QueryLambdaVersion createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * ISO-8601 date of when Query Lambda was created
   *
   * @return createdAt
   */
  @JsonProperty("created_at")
  @ApiModelProperty(
      example = "2001-08-28T00:23:41Z",
      value = "ISO-8601 date of when Query Lambda was created")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public QueryLambdaVersion name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Query Lambda name
   *
   * @return name
   */
  @JsonProperty("name")
  @ApiModelProperty(example = "myQuery", value = "Query Lambda name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public QueryLambdaVersion version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Query Lambda version
   *
   * @return version
   */
  @JsonProperty("version")
  @ApiModelProperty(example = "acb99feg92bcaf", value = "Query Lambda version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public QueryLambdaVersion description(String description) {
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

  public QueryLambdaVersion sql(QueryLambdaSql sql) {
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

  public QueryLambdaVersion collections(List<String> collections) {
    this.collections = collections;
    return this;
  }

  public QueryLambdaVersion addCollectionsItem(String collectionsItem) {
    if (this.collections == null) {
      this.collections = new ArrayList<String>();
    }
    this.collections.add(collectionsItem);
    return this;
  }

  /**
   * collections queried by underlying SQL query
   *
   * @return collections
   */
  @JsonProperty("collections")
  @ApiModelProperty(value = "collections queried by underlying SQL query")
  public List<String> getCollections() {
    return collections;
  }

  public void setCollections(List<String> collections) {
    this.collections = collections;
  }

  public QueryLambdaVersion state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * status of this Query Lambda
   *
   * @return state
   */
  @JsonProperty("state")
  @ApiModelProperty(example = "ACTIVE", value = "status of this Query Lambda")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public QueryLambdaVersion stats(QueryLambdaStats stats) {
    this.stats = stats;
    return this;
  }

  /**
   * stats related to this Query Lambda
   *
   * @return stats
   */
  @JsonProperty("stats")
  @ApiModelProperty(value = "stats related to this Query Lambda")
  public QueryLambdaStats getStats() {
    return stats;
  }

  public void setStats(QueryLambdaStats stats) {
    this.stats = stats;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryLambdaVersion queryLambdaVersion = (QueryLambdaVersion) o;
    return Objects.equals(this.workspace, queryLambdaVersion.workspace)
        && Objects.equals(this.createdBy, queryLambdaVersion.createdBy)
        && Objects.equals(this.createdAt, queryLambdaVersion.createdAt)
        && Objects.equals(this.name, queryLambdaVersion.name)
        && Objects.equals(this.version, queryLambdaVersion.version)
        && Objects.equals(this.description, queryLambdaVersion.description)
        && Objects.equals(this.sql, queryLambdaVersion.sql)
        && Objects.equals(this.collections, queryLambdaVersion.collections)
        && Objects.equals(this.state, queryLambdaVersion.state)
        && Objects.equals(this.stats, queryLambdaVersion.stats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        workspace,
        createdBy,
        createdAt,
        name,
        version,
        description,
        sql,
        collections,
        state,
        stats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryLambdaVersion {\n");

    sb.append("    workspace: ").append(toIndentedString(workspace)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    sql: ").append(toIndentedString(sql)).append("\n");
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
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
