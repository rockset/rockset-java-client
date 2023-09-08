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
import com.rockset.client.model.QueryLambdaVersion;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * QueryLambda
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:46:16.821-07:00")
public class QueryLambda {
  @SerializedName("collections")
  private List<String> collections = null;

  @SerializedName("last_updated")
  private String lastUpdated = null;

  @SerializedName("last_updated_by")
  private String lastUpdatedBy = null;

  @SerializedName("latest_version")
  private QueryLambdaVersion latestVersion = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("version_count")
  private Integer versionCount = null;

  @SerializedName("workspace")
  private String workspace = null;

  public QueryLambda collections(List<String> collections) {
    this.collections = collections;
    return this;
  }

  public QueryLambda addCollectionsItem(String collectionsItem) {
    if (this.collections == null) {
      this.collections = new ArrayList<String>();
    }
    this.collections.add(collectionsItem);
    return this;
  }

   /**
   * Collections/aliases queried by underlying SQL query.
   * @return collections
  **/

@JsonProperty("collections")
@ApiModelProperty(value = "Collections/aliases queried by underlying SQL query.")
  public List<String> getCollections() {
    return collections;
  }

  public void setCollections(List<String> collections) {
    this.collections = collections;
  }

  public QueryLambda lastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * ISO-8601 date of when Query Lambda was last updated.
   * @return lastUpdated
  **/

@JsonProperty("last_updated")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date of when Query Lambda was last updated.")
  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public QueryLambda lastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
    return this;
  }

   /**
   * User that created this Query Lambda.
   * @return lastUpdatedBy
  **/

@JsonProperty("last_updated_by")
@ApiModelProperty(example = "..@rockset.com", value = "User that created this Query Lambda.")
  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public QueryLambda latestVersion(QueryLambdaVersion latestVersion) {
    this.latestVersion = latestVersion;
    return this;
  }

   /**
   * Query Lambda version details for most recently created version.
   * @return latestVersion
  **/

@JsonProperty("latest_version")
@ApiModelProperty(value = "Query Lambda version details for most recently created version.")
  public QueryLambdaVersion getLatestVersion() {
    return latestVersion;
  }

  public void setLatestVersion(QueryLambdaVersion latestVersion) {
    this.latestVersion = latestVersion;
  }

  public QueryLambda name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Query Lambda name.
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "myQuery", value = "Query Lambda name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public QueryLambda versionCount(Integer versionCount) {
    this.versionCount = versionCount;
    return this;
  }

   /**
   * Number of Query Lambda versions.
   * @return versionCount
  **/

@JsonProperty("version_count")
@ApiModelProperty(example = "1", value = "Number of Query Lambda versions.")
  public Integer getVersionCount() {
    return versionCount;
  }

  public void setVersionCount(Integer versionCount) {
    this.versionCount = versionCount;
  }

  public QueryLambda workspace(String workspace) {
    this.workspace = workspace;
    return this;
  }

   /**
   * Workspace of this Query Lambda.
   * @return workspace
  **/

@JsonProperty("workspace")
@ApiModelProperty(example = "commons", value = "Workspace of this Query Lambda.")
  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryLambda queryLambda = (QueryLambda) o;
    return Objects.equals(this.collections, queryLambda.collections) &&
        Objects.equals(this.lastUpdated, queryLambda.lastUpdated) &&
        Objects.equals(this.lastUpdatedBy, queryLambda.lastUpdatedBy) &&
        Objects.equals(this.latestVersion, queryLambda.latestVersion) &&
        Objects.equals(this.name, queryLambda.name) &&
        Objects.equals(this.versionCount, queryLambda.versionCount) &&
        Objects.equals(this.workspace, queryLambda.workspace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collections, lastUpdated, lastUpdatedBy, latestVersion, name, versionCount, workspace);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryLambda {\n");
    
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
    sb.append("    latestVersion: ").append(toIndentedString(latestVersion)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    versionCount: ").append(toIndentedString(versionCount)).append("\n");
    sb.append("    workspace: ").append(toIndentedString(workspace)).append("\n");
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

