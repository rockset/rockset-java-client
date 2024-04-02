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

/** Workspaces are organizational containers for collections. */
@ApiModel(description = "Workspaces are organizational containers for collections.")
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class Workspace {
  @SerializedName("collection_count")
  private Long collectionCount = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("created_by")
  private String createdBy = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("name")
  private String name = null;

  public Workspace collectionCount(Long collectionCount) {
    this.collectionCount = collectionCount;
    return this;
  }

  /**
   * Number of collections that are immediate children of workspace.
   *
   * @return collectionCount
   */
  @JsonProperty("collection_count")
  @ApiModelProperty(
      example = "3",
      value = "Number of collections that are immediate children of workspace.")
  public Long getCollectionCount() {
    return collectionCount;
  }

  public void setCollectionCount(Long collectionCount) {
    this.collectionCount = collectionCount;
  }

  public Workspace createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * ISO-8601 date of when workspace was created.
   *
   * @return createdAt
   */
  @JsonProperty("created_at")
  @ApiModelProperty(
      example = "2001-08-28T00:23:41Z",
      value = "ISO-8601 date of when workspace was created.")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Workspace createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Email of user who created the workspace.
   *
   * @return createdBy
   */
  @JsonProperty("created_by")
  @ApiModelProperty(
      example = "hello@rockset.com",
      value = "Email of user who created the workspace.")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Workspace description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Longer explanation for the workspace.
   *
   * @return description
   */
  @JsonProperty("description")
  @ApiModelProperty(
      example = "Datasets of system logs for the ops team.",
      value = "Longer explanation for the workspace.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Workspace name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Descriptive label and unique identifier.
   *
   * @return name
   */
  @JsonProperty("name")
  @ApiModelProperty(example = "event_logs", value = "Descriptive label and unique identifier.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Workspace workspace = (Workspace) o;
    return Objects.equals(this.collectionCount, workspace.collectionCount)
        && Objects.equals(this.createdAt, workspace.createdAt)
        && Objects.equals(this.createdBy, workspace.createdBy)
        && Objects.equals(this.description, workspace.description)
        && Objects.equals(this.name, workspace.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionCount, createdAt, createdBy, description, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Workspace {\n");

    sb.append("    collectionCount: ").append(toIndentedString(collectionCount)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
