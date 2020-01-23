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
import com.rockset.client.model.CollectionStats;
import com.rockset.client.model.FieldMappingV2;
import com.rockset.client.model.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Collection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-21T23:08:54.250Z")
public class Collection {
  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("created_by")
  private String createdBy = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("workspace")
  private String workspace = null;

  /**
   * current status of collection, one of: CREATED, READY, DELETED
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    CREATED("CREATED"),
    
    READY("READY"),
    
    PAUSED("PAUSED"),
    
    DELETED("DELETED"),
    
    PAUSING("PAUSING"),
    
    RESUMING("RESUMING"),
    
    BULK_INGEST_MODE("BULKINGESTMODE"),
    
    EXITING_BULK_INGEST_MODE("EXITINGBULKINGESTMODE"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("sources")
  private List<Source> sources = null;

  @SerializedName("stats")
  private CollectionStats stats = null;

  @SerializedName("retention_secs")
  private Long retentionSecs = null;

  @SerializedName("field_mappings")
  private List<FieldMappingV2> fieldMappings = null;

  public Collection createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO-8601 date
   * @return createdAt
  **/

@JsonProperty("created_at")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Collection createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * email of user who created the collection
   * @return createdBy
  **/

@JsonProperty("created_by")
@ApiModelProperty(example = "hello@rockset.com", value = "email of user who created the collection")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Collection name(String name) {
    this.name = name;
    return this;
  }

   /**
   * unique identifer for collection, can contain alphanumeric or dash characters
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "global-transactions", value = "unique identifer for collection, can contain alphanumeric or dash characters")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection description(String description) {
    this.description = description;
    return this;
  }

   /**
   * text describing the collection
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "transactions from stores worldwide", value = "text describing the collection")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Collection workspace(String workspace) {
    this.workspace = workspace;
    return this;
  }

   /**
   * name of the workspace that the collection is in
   * @return workspace
  **/

@JsonProperty("workspace")
@ApiModelProperty(example = "commons", value = "name of the workspace that the collection is in")
  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }

  public Collection status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * current status of collection, one of: CREATED, READY, DELETED
   * @return status
  **/

@JsonProperty("status")
@ApiModelProperty(example = "READY", value = "current status of collection, one of: CREATED, READY, DELETED")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Collection sources(List<Source> sources) {
    this.sources = sources;
    return this;
  }

  public Collection addSourcesItem(Source sourcesItem) {
    if (this.sources == null) {
      this.sources = new ArrayList<Source>();
    }
    this.sources.add(sourcesItem);
    return this;
  }

   /**
   * list of sources from which collection ingests
   * @return sources
  **/

@JsonProperty("sources")
@ApiModelProperty(value = "list of sources from which collection ingests")
  public List<Source> getSources() {
    return sources;
  }

  public void setSources(List<Source> sources) {
    this.sources = sources;
  }

  public Collection stats(CollectionStats stats) {
    this.stats = stats;
    return this;
  }

   /**
   * metrics about the collection
   * @return stats
  **/

@JsonProperty("stats")
@ApiModelProperty(value = "metrics about the collection")
  public CollectionStats getStats() {
    return stats;
  }

  public void setStats(CollectionStats stats) {
    this.stats = stats;
  }

  public Collection retentionSecs(Long retentionSecs) {
    this.retentionSecs = retentionSecs;
    return this;
  }

   /**
   * number of seconds after which data is purged based on event time
   * @return retentionSecs
  **/

@JsonProperty("retention_secs")
@ApiModelProperty(example = "2592000", value = "number of seconds after which data is purged based on event time")
  public Long getRetentionSecs() {
    return retentionSecs;
  }

  public void setRetentionSecs(Long retentionSecs) {
    this.retentionSecs = retentionSecs;
  }

  public Collection fieldMappings(List<FieldMappingV2> fieldMappings) {
    this.fieldMappings = fieldMappings;
    return this;
  }

  public Collection addFieldMappingsItem(FieldMappingV2 fieldMappingsItem) {
    if (this.fieldMappings == null) {
      this.fieldMappings = new ArrayList<FieldMappingV2>();
    }
    this.fieldMappings.add(fieldMappingsItem);
    return this;
  }

   /**
   * list of mappings applied on all documents in a collection
   * @return fieldMappings
  **/

@JsonProperty("field_mappings")
@ApiModelProperty(value = "list of mappings applied on all documents in a collection")
  public List<FieldMappingV2> getFieldMappings() {
    return fieldMappings;
  }

  public void setFieldMappings(List<FieldMappingV2> fieldMappings) {
    this.fieldMappings = fieldMappings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Collection collection = (Collection) o;
    return Objects.equals(this.createdAt, collection.createdAt) &&
        Objects.equals(this.createdBy, collection.createdBy) &&
        Objects.equals(this.name, collection.name) &&
        Objects.equals(this.description, collection.description) &&
        Objects.equals(this.workspace, collection.workspace) &&
        Objects.equals(this.status, collection.status) &&
        Objects.equals(this.sources, collection.sources) &&
        Objects.equals(this.stats, collection.stats) &&
        Objects.equals(this.retentionSecs, collection.retentionSecs) &&
        Objects.equals(this.fieldMappings, collection.fieldMappings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, createdBy, name, description, workspace, status, sources, stats, retentionSecs, fieldMappings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Collection {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    workspace: ").append(toIndentedString(workspace)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    sources: ").append(toIndentedString(sources)).append("\n");
    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
    sb.append("    retentionSecs: ").append(toIndentedString(retentionSecs)).append("\n");
    sb.append("    fieldMappings: ").append(toIndentedString(fieldMappings)).append("\n");
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

