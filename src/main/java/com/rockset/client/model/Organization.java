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
import com.rockset.client.model.Cluster;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An organization in Rockset is a container for users and collections.
 */

@ApiModel(description = "An organization in Rockset is a container for users and collections.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-13T18:31:46.278Z")
public class Organization {
  @SerializedName("clusters")
  private List<Cluster> clusters = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("display_name")
  private String displayName = null;

  @SerializedName("external_id")
  private String externalId = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("rockset_user")
  private String rocksetUser = null;

  @SerializedName("sso_connection")
  private String ssoConnection = null;

  @SerializedName("sso_only")
  private Boolean ssoOnly = null;

  public Organization clusters(List<Cluster> clusters) {
    this.clusters = clusters;
    return this;
  }

  public Organization addClustersItem(Cluster clustersItem) {
    if (this.clusters == null) {
      this.clusters = new ArrayList<Cluster>();
    }
    this.clusters.add(clustersItem);
    return this;
  }

   /**
   * List of clusters associated with this org.
   * @return clusters
  **/

@JsonProperty("clusters")
@ApiModelProperty(example = "\"[{ ... }]\"", value = "List of clusters associated with this org.")
  public List<Cluster> getClusters() {
    return clusters;
  }

  public void setClusters(List<Cluster> clusters) {
    this.clusters = clusters;
  }

  public Organization createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO-8601 date.
   * @return createdAt
  **/

@JsonProperty("created_at")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date.")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Organization displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Name of the organization.
   * @return displayName
  **/

@JsonProperty("display_name")
@ApiModelProperty(example = "Rockset, Inc", value = "Name of the organization.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Organization externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

   /**
   * Organization&#39;s unique external ID within Rockset.
   * @return externalId
  **/

@JsonProperty("external_id")
@ApiModelProperty(example = "<hash>", value = "Organization's unique external ID within Rockset.")
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public Organization id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the organization.
   * @return id
  **/

@JsonProperty("id")
@ApiModelProperty(example = "rockset", value = "Unique identifier for the organization.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Organization rocksetUser(String rocksetUser) {
    this.rocksetUser = rocksetUser;
    return this;
  }

   /**
   * Rockset&#39;s global AWS user.
   * @return rocksetUser
  **/

@JsonProperty("rockset_user")
@ApiModelProperty(example = "<id>", value = "Rockset's global AWS user.")
  public String getRocksetUser() {
    return rocksetUser;
  }

  public void setRocksetUser(String rocksetUser) {
    this.rocksetUser = rocksetUser;
  }

  public Organization ssoConnection(String ssoConnection) {
    this.ssoConnection = ssoConnection;
    return this;
  }

   /**
   * Connection name of SSO connection.
   * @return ssoConnection
  **/

@JsonProperty("sso_connection")
@ApiModelProperty(example = "rockset", value = "Connection name of SSO connection.")
  public String getSsoConnection() {
    return ssoConnection;
  }

  public void setSsoConnection(String ssoConnection) {
    this.ssoConnection = ssoConnection;
  }

  public Organization ssoOnly(Boolean ssoOnly) {
    this.ssoOnly = ssoOnly;
    return this;
  }

   /**
   * Whether or not SSO is the only permitted form of auth.
   * @return ssoOnly
  **/

@JsonProperty("sso_only")
@ApiModelProperty(example = "true", value = "Whether or not SSO is the only permitted form of auth.")
  public Boolean isSsoOnly() {
    return ssoOnly;
  }

  public void setSsoOnly(Boolean ssoOnly) {
    this.ssoOnly = ssoOnly;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization organization = (Organization) o;
    return Objects.equals(this.clusters, organization.clusters) &&
        Objects.equals(this.createdAt, organization.createdAt) &&
        Objects.equals(this.displayName, organization.displayName) &&
        Objects.equals(this.externalId, organization.externalId) &&
        Objects.equals(this.id, organization.id) &&
        Objects.equals(this.rocksetUser, organization.rocksetUser) &&
        Objects.equals(this.ssoConnection, organization.ssoConnection) &&
        Objects.equals(this.ssoOnly, organization.ssoOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusters, createdAt, displayName, externalId, id, rocksetUser, ssoConnection, ssoOnly);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    
    sb.append("    clusters: ").append(toIndentedString(clusters)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rocksetUser: ").append(toIndentedString(rocksetUser)).append("\n");
    sb.append("    ssoConnection: ").append(toIndentedString(ssoConnection)).append("\n");
    sb.append("    ssoOnly: ").append(toIndentedString(ssoOnly)).append("\n");
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

