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
import com.rockset.client.model.CollectionMountStats;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CollectionMount
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-13T18:31:46.278Z")
public class CollectionMount {
  @SerializedName("collection_path")
  private String collectionPath = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("last_refresh_time_millis")
  private Long lastRefreshTimeMillis = null;

  @SerializedName("rrn")
  private String rrn = null;

  @SerializedName("snapshot_expiration_time_millis")
  private Long snapshotExpirationTimeMillis = null;

  /**
   * Mount type.
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    CREATING("CREATING"),
    
    ACTIVE("ACTIVE"),
    
    REFRESHING("REFRESHING"),
    
    EXPIRED("EXPIRED"),
    
    DELETING("DELETING"),
    
    SWITCHING_REFRESH_TYPE("SWITCHINGREFRESHTYPE"),
    
    SUSPENDED("SUSPENDED"),
    
    SUSPENDING("SUSPENDING");

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

    @com.fasterxml.jackson.annotation.JsonCreator
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
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
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
  private CollectionMountStats stats = null;

  @SerializedName("virtual_instance_id")
  private String virtualInstanceId = null;

  @SerializedName("virtual_instance_rrn")
  private String virtualInstanceRrn = null;

  public CollectionMount collectionPath(String collectionPath) {
    this.collectionPath = collectionPath;
    return this;
  }

   /**
   * Collection path.
   * @return collectionPath
  **/

@JsonProperty("collection_path")
@ApiModelProperty(example = "commons.foo", value = "Collection path.")
  public String getCollectionPath() {
    return collectionPath;
  }

  public void setCollectionPath(String collectionPath) {
    this.collectionPath = collectionPath;
  }

  public CollectionMount createdAt(String createdAt) {
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

  public CollectionMount id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Mount ID.
   * @return id
  **/

@JsonProperty("id")
@ApiModelProperty(example = "5ac23....", value = "Mount ID.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CollectionMount lastRefreshTimeMillis(Long lastRefreshTimeMillis) {
    this.lastRefreshTimeMillis = lastRefreshTimeMillis;
    return this;
  }

   /**
   * Unix timestamp of most recent refresh. Not applicable for live mounts.
   * @return lastRefreshTimeMillis
  **/

@JsonProperty("last_refresh_time_millis")
@ApiModelProperty(example = "123123764", value = "Unix timestamp of most recent refresh. Not applicable for live mounts.")
  public Long getLastRefreshTimeMillis() {
    return lastRefreshTimeMillis;
  }

  public void setLastRefreshTimeMillis(Long lastRefreshTimeMillis) {
    this.lastRefreshTimeMillis = lastRefreshTimeMillis;
  }

  public CollectionMount rrn(String rrn) {
    this.rrn = rrn;
    return this;
  }

   /**
   * Mount RRN.
   * @return rrn
  **/

@JsonProperty("rrn")
@ApiModelProperty(example = "rrn:mnt:use1a1:123e4567-e89b-12d3-a456-556642440000", value = "Mount RRN.")
  public String getRrn() {
    return rrn;
  }

  public void setRrn(String rrn) {
    this.rrn = rrn;
  }

  public CollectionMount snapshotExpirationTimeMillis(Long snapshotExpirationTimeMillis) {
    this.snapshotExpirationTimeMillis = snapshotExpirationTimeMillis;
    return this;
  }

   /**
   * Time in millis at which the snapshot expires.
   * @return snapshotExpirationTimeMillis
  **/

@JsonProperty("snapshot_expiration_time_millis")
@ApiModelProperty(example = "864000000", value = "Time in millis at which the snapshot expires.")
  public Long getSnapshotExpirationTimeMillis() {
    return snapshotExpirationTimeMillis;
  }

  public void setSnapshotExpirationTimeMillis(Long snapshotExpirationTimeMillis) {
    this.snapshotExpirationTimeMillis = snapshotExpirationTimeMillis;
  }

  public CollectionMount state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * Mount type.
   * @return state
  **/

@JsonProperty("state")
@ApiModelProperty(example = "ACTIVE", value = "Mount type.")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public CollectionMount stats(CollectionMountStats stats) {
    this.stats = stats;
    return this;
  }

   /**
   * Stats about this Collection Mount
   * @return stats
  **/

@JsonProperty("stats")
@ApiModelProperty(value = "Stats about this Collection Mount")
  public CollectionMountStats getStats() {
    return stats;
  }

  public void setStats(CollectionMountStats stats) {
    this.stats = stats;
  }

  public CollectionMount virtualInstanceId(String virtualInstanceId) {
    this.virtualInstanceId = virtualInstanceId;
    return this;
  }

   /**
   * Virtual instance ID.
   * @return virtualInstanceId
  **/

@JsonProperty("virtual_instance_id")
@ApiModelProperty(example = "5ac23....", value = "Virtual instance ID.")
  public String getVirtualInstanceId() {
    return virtualInstanceId;
  }

  public void setVirtualInstanceId(String virtualInstanceId) {
    this.virtualInstanceId = virtualInstanceId;
  }

  public CollectionMount virtualInstanceRrn(String virtualInstanceRrn) {
    this.virtualInstanceRrn = virtualInstanceRrn;
    return this;
  }

   /**
   * Virtual Instance RRN.
   * @return virtualInstanceRrn
  **/

@JsonProperty("virtual_instance_rrn")
@ApiModelProperty(example = "rrn:vi:use1a1:123e4567-e89b-12d3-a456-556642440000", value = "Virtual Instance RRN.")
  public String getVirtualInstanceRrn() {
    return virtualInstanceRrn;
  }

  public void setVirtualInstanceRrn(String virtualInstanceRrn) {
    this.virtualInstanceRrn = virtualInstanceRrn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollectionMount collectionMount = (CollectionMount) o;
    return Objects.equals(this.collectionPath, collectionMount.collectionPath) &&
        Objects.equals(this.createdAt, collectionMount.createdAt) &&
        Objects.equals(this.id, collectionMount.id) &&
        Objects.equals(this.lastRefreshTimeMillis, collectionMount.lastRefreshTimeMillis) &&
        Objects.equals(this.rrn, collectionMount.rrn) &&
        Objects.equals(this.snapshotExpirationTimeMillis, collectionMount.snapshotExpirationTimeMillis) &&
        Objects.equals(this.state, collectionMount.state) &&
        Objects.equals(this.stats, collectionMount.stats) &&
        Objects.equals(this.virtualInstanceId, collectionMount.virtualInstanceId) &&
        Objects.equals(this.virtualInstanceRrn, collectionMount.virtualInstanceRrn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionPath, createdAt, id, lastRefreshTimeMillis, rrn, snapshotExpirationTimeMillis, state, stats, virtualInstanceId, virtualInstanceRrn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionMount {\n");
    
    sb.append("    collectionPath: ").append(toIndentedString(collectionPath)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastRefreshTimeMillis: ").append(toIndentedString(lastRefreshTimeMillis)).append("\n");
    sb.append("    rrn: ").append(toIndentedString(rrn)).append("\n");
    sb.append("    snapshotExpirationTimeMillis: ").append(toIndentedString(snapshotExpirationTimeMillis)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
    sb.append("    virtualInstanceId: ").append(toIndentedString(virtualInstanceId)).append("\n");
    sb.append("    virtualInstanceRrn: ").append(toIndentedString(virtualInstanceRrn)).append("\n");
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

