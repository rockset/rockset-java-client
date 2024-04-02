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

/** CreateCollectionRequest */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class CreateCollectionRequest {
  @SerializedName("clustering_key")
  private List<FieldPartition> clusteringKey = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("event_time_info")
  private EventTimeInfo eventTimeInfo = null;

  @SerializedName("field_mapping_query")
  private FieldMappingQuery fieldMappingQuery = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("retention_secs")
  private Long retentionSecs = null;

  @SerializedName("source_download_soft_limit_bytes")
  private Long sourceDownloadSoftLimitBytes = null;

  @SerializedName("sources")
  private List<Source> sources = null;

  /** RocksDB storage compression type. */
  @JsonAdapter(StorageCompressionTypeEnum.Adapter.class)
  public enum StorageCompressionTypeEnum {
    LZ4("LZ4"),

    ZSTD("ZSTD");

    private String value;

    StorageCompressionTypeEnum(String value) {
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
    public static StorageCompressionTypeEnum fromValue(String text) {
      for (StorageCompressionTypeEnum b : StorageCompressionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StorageCompressionTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StorageCompressionTypeEnum enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StorageCompressionTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StorageCompressionTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("storage_compression_type")
  private StorageCompressionTypeEnum storageCompressionType = null;

  public CreateCollectionRequest clusteringKey(List<FieldPartition> clusteringKey) {
    this.clusteringKey = clusteringKey;
    return this;
  }

  public CreateCollectionRequest addClusteringKeyItem(FieldPartition clusteringKeyItem) {
    if (this.clusteringKey == null) {
      this.clusteringKey = new ArrayList<FieldPartition>();
    }
    this.clusteringKey.add(clusteringKeyItem);
    return this;
  }

  /**
   * Deprecated. List of clustering fields. Use CLUSTER BY clause in &#x60;field_mapping_query&#x60;
   * instead.
   *
   * @return clusteringKey
   */
  @JsonProperty("clustering_key")
  @ApiModelProperty(
      value =
          "Deprecated. List of clustering fields. Use CLUSTER BY clause in `field_mapping_query` instead.")
  public List<FieldPartition> getClusteringKey() {
    return clusteringKey;
  }

  public void setClusteringKey(List<FieldPartition> clusteringKey) {
    this.clusteringKey = clusteringKey;
  }

  public CreateCollectionRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Text describing the collection.
   *
   * @return description
   */
  @JsonProperty("description")
  @ApiModelProperty(
      example = "transactions from stores worldwide",
      value = "Text describing the collection.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateCollectionRequest eventTimeInfo(EventTimeInfo eventTimeInfo) {
    this.eventTimeInfo = eventTimeInfo;
    return this;
  }

  /**
   * Deprecated. Configuration for event data. Use an _event_time mapping in
   * &#x60;field_mapping_query&#x60; instead.
   *
   * @return eventTimeInfo
   */
  @JsonProperty("event_time_info")
  @ApiModelProperty(
      value =
          "Deprecated. Configuration for event data. Use an _event_time mapping in `field_mapping_query` instead.")
  public EventTimeInfo getEventTimeInfo() {
    return eventTimeInfo;
  }

  public void setEventTimeInfo(EventTimeInfo eventTimeInfo) {
    this.eventTimeInfo = eventTimeInfo;
  }

  public CreateCollectionRequest fieldMappingQuery(FieldMappingQuery fieldMappingQuery) {
    this.fieldMappingQuery = fieldMappingQuery;
    return this;
  }

  /**
   * Ingest transformation query.
   *
   * @return fieldMappingQuery
   */
  @JsonProperty("field_mapping_query")
  @ApiModelProperty(value = "Ingest transformation query.")
  public FieldMappingQuery getFieldMappingQuery() {
    return fieldMappingQuery;
  }

  public void setFieldMappingQuery(FieldMappingQuery fieldMappingQuery) {
    this.fieldMappingQuery = fieldMappingQuery;
  }

  public CreateCollectionRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Unique identifier for collection, can contain alphanumeric or dash characters.
   *
   * @return name
   */
  @JsonProperty("name")
  @ApiModelProperty(
      example = "global-transactions",
      value = "Unique identifier for collection, can contain alphanumeric or dash characters.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateCollectionRequest retentionSecs(Long retentionSecs) {
    this.retentionSecs = retentionSecs;
    return this;
  }

  /**
   * Number of seconds after which data is purged, based on event time. Minimum allowable value is
   * 3600s/1 hour. The maximum value is strictly less than 10 years. minimum: 3600 maximum:
   * 315359999
   *
   * @return retentionSecs
   */
  @JsonProperty("retention_secs")
  @ApiModelProperty(
      example = "1000000",
      value =
          "Number of seconds after which data is purged, based on event time. Minimum allowable value is 3600s/1 hour. The maximum value is strictly less than 10 years.")
  public Long getRetentionSecs() {
    return retentionSecs;
  }

  public void setRetentionSecs(Long retentionSecs) {
    this.retentionSecs = retentionSecs;
  }

  public CreateCollectionRequest sourceDownloadSoftLimitBytes(Long sourceDownloadSoftLimitBytes) {
    this.sourceDownloadSoftLimitBytes = sourceDownloadSoftLimitBytes;
    return this;
  }

  /**
   * Soft ingest limit for this collection.
   *
   * @return sourceDownloadSoftLimitBytes
   */
  @JsonProperty("source_download_soft_limit_bytes")
  @ApiModelProperty(value = "Soft ingest limit for this collection.")
  public Long getSourceDownloadSoftLimitBytes() {
    return sourceDownloadSoftLimitBytes;
  }

  public void setSourceDownloadSoftLimitBytes(Long sourceDownloadSoftLimitBytes) {
    this.sourceDownloadSoftLimitBytes = sourceDownloadSoftLimitBytes;
  }

  public CreateCollectionRequest sources(List<Source> sources) {
    this.sources = sources;
    return this;
  }

  public CreateCollectionRequest addSourcesItem(Source sourcesItem) {
    if (this.sources == null) {
      this.sources = new ArrayList<Source>();
    }
    this.sources.add(sourcesItem);
    return this;
  }

  /**
   * List of sources from which to ingest data.
   *
   * @return sources
   */
  @JsonProperty("sources")
  @ApiModelProperty(value = "List of sources from which to ingest data.")
  public List<Source> getSources() {
    return sources;
  }

  public void setSources(List<Source> sources) {
    this.sources = sources;
  }

  public CreateCollectionRequest storageCompressionType(
      StorageCompressionTypeEnum storageCompressionType) {
    this.storageCompressionType = storageCompressionType;
    return this;
  }

  /**
   * RocksDB storage compression type.
   *
   * @return storageCompressionType
   */
  @JsonProperty("storage_compression_type")
  @ApiModelProperty(example = "LZ4", value = "RocksDB storage compression type.")
  public StorageCompressionTypeEnum getStorageCompressionType() {
    return storageCompressionType;
  }

  public void setStorageCompressionType(StorageCompressionTypeEnum storageCompressionType) {
    this.storageCompressionType = storageCompressionType;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCollectionRequest createCollectionRequest = (CreateCollectionRequest) o;
    return Objects.equals(this.clusteringKey, createCollectionRequest.clusteringKey)
        && Objects.equals(this.description, createCollectionRequest.description)
        && Objects.equals(this.eventTimeInfo, createCollectionRequest.eventTimeInfo)
        && Objects.equals(this.fieldMappingQuery, createCollectionRequest.fieldMappingQuery)
        && Objects.equals(this.name, createCollectionRequest.name)
        && Objects.equals(this.retentionSecs, createCollectionRequest.retentionSecs)
        && Objects.equals(
            this.sourceDownloadSoftLimitBytes, createCollectionRequest.sourceDownloadSoftLimitBytes)
        && Objects.equals(this.sources, createCollectionRequest.sources)
        && Objects.equals(
            this.storageCompressionType, createCollectionRequest.storageCompressionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        clusteringKey,
        description,
        eventTimeInfo,
        fieldMappingQuery,
        name,
        retentionSecs,
        sourceDownloadSoftLimitBytes,
        sources,
        storageCompressionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCollectionRequest {\n");

    sb.append("    clusteringKey: ").append(toIndentedString(clusteringKey)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    eventTimeInfo: ").append(toIndentedString(eventTimeInfo)).append("\n");
    sb.append("    fieldMappingQuery: ").append(toIndentedString(fieldMappingQuery)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    retentionSecs: ").append(toIndentedString(retentionSecs)).append("\n");
    sb.append("    sourceDownloadSoftLimitBytes: ")
        .append(toIndentedString(sourceDownloadSoftLimitBytes))
        .append("\n");
    sb.append("    sources: ").append(toIndentedString(sources)).append("\n");
    sb.append("    storageCompressionType: ")
        .append(toIndentedString(storageCompressionType))
        .append("\n");
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
