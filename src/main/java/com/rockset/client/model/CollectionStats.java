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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CollectionStats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:21:47.964-07:00")
public class CollectionStats {
  @SerializedName("bulk_bytes_inserted")
  private Long bulkBytesInserted = null;

  @SerializedName("bulk_bytes_overwritten")
  private Long bulkBytesOverwritten = null;

  @SerializedName("bytes_inserted")
  private Long bytesInserted = null;

  @SerializedName("bytes_overwritten")
  private Long bytesOverwritten = null;

  @SerializedName("column_index_size")
  private Long columnIndexSize = null;

  @SerializedName("doc_count")
  private Long docCount = null;

  @SerializedName("fill_progress")
  private Double fillProgress = null;

  @SerializedName("inverted_index_size")
  private Long invertedIndexSize = null;

  @SerializedName("last_queried_ms")
  private Long lastQueriedMs = null;

  @SerializedName("last_updated_ms")
  private Long lastUpdatedMs = null;

  @SerializedName("purged_doc_count")
  private Long purgedDocCount = null;

  @SerializedName("purged_doc_size")
  private Long purgedDocSize = null;

  @SerializedName("range_index_size")
  private Long rangeIndexSize = null;

  @SerializedName("row_index_size")
  private Long rowIndexSize = null;

  @SerializedName("total_index_size")
  private Long totalIndexSize = null;

  @SerializedName("total_size")
  private Long totalSize = null;

  public CollectionStats bulkBytesInserted(Long bulkBytesInserted) {
    this.bulkBytesInserted = bulkBytesInserted;
    return this;
  }

   /**
   * Total number of bytes inserted into the collection during bulk.
   * @return bulkBytesInserted
  **/

@JsonProperty("bulk_bytes_inserted")
@ApiModelProperty(value = "Total number of bytes inserted into the collection during bulk.")
  public Long getBulkBytesInserted() {
    return bulkBytesInserted;
  }

  public void setBulkBytesInserted(Long bulkBytesInserted) {
    this.bulkBytesInserted = bulkBytesInserted;
  }

  public CollectionStats bulkBytesOverwritten(Long bulkBytesOverwritten) {
    this.bulkBytesOverwritten = bulkBytesOverwritten;
    return this;
  }

   /**
   * Total number of bytes overwritten in writing into the collection during bulk.
   * @return bulkBytesOverwritten
  **/

@JsonProperty("bulk_bytes_overwritten")
@ApiModelProperty(value = "Total number of bytes overwritten in writing into the collection during bulk.")
  public Long getBulkBytesOverwritten() {
    return bulkBytesOverwritten;
  }

  public void setBulkBytesOverwritten(Long bulkBytesOverwritten) {
    this.bulkBytesOverwritten = bulkBytesOverwritten;
  }

  public CollectionStats bytesInserted(Long bytesInserted) {
    this.bytesInserted = bytesInserted;
    return this;
  }

   /**
   * Total number of bytes inserted into the collection.
   * @return bytesInserted
  **/

@JsonProperty("bytes_inserted")
@ApiModelProperty(example = "123456", value = "Total number of bytes inserted into the collection.")
  public Long getBytesInserted() {
    return bytesInserted;
  }

  public void setBytesInserted(Long bytesInserted) {
    this.bytesInserted = bytesInserted;
  }

  public CollectionStats bytesOverwritten(Long bytesOverwritten) {
    this.bytesOverwritten = bytesOverwritten;
    return this;
  }

   /**
   * Total number of bytes overwritten in writing into the collection.
   * @return bytesOverwritten
  **/

@JsonProperty("bytes_overwritten")
@ApiModelProperty(example = "123456", value = "Total number of bytes overwritten in writing into the collection.")
  public Long getBytesOverwritten() {
    return bytesOverwritten;
  }

  public void setBytesOverwritten(Long bytesOverwritten) {
    this.bytesOverwritten = bytesOverwritten;
  }

  public CollectionStats columnIndexSize(Long columnIndexSize) {
    this.columnIndexSize = columnIndexSize;
    return this;
  }

   /**
   * Total collection column index size in bytes.
   * @return columnIndexSize
  **/

@JsonProperty("column_index_size")
@ApiModelProperty(example = "123456", value = "Total collection column index size in bytes.")
  public Long getColumnIndexSize() {
    return columnIndexSize;
  }

  public void setColumnIndexSize(Long columnIndexSize) {
    this.columnIndexSize = columnIndexSize;
  }

  public CollectionStats docCount(Long docCount) {
    this.docCount = docCount;
    return this;
  }

   /**
   * Number of documents in the collection.
   * @return docCount
  **/

@JsonProperty("doc_count")
@ApiModelProperty(example = "2145", value = "Number of documents in the collection.")
  public Long getDocCount() {
    return docCount;
  }

  public void setDocCount(Long docCount) {
    this.docCount = docCount;
  }

  public CollectionStats fillProgress(Double fillProgress) {
    this.fillProgress = fillProgress;
    return this;
  }

   /**
   * Number between 0 and 1 that indicates progress of collection creation.
   * @return fillProgress
  **/

@JsonProperty("fill_progress")
@ApiModelProperty(example = "0.6", value = "Number between 0 and 1 that indicates progress of collection creation.")
  public Double getFillProgress() {
    return fillProgress;
  }

  public void setFillProgress(Double fillProgress) {
    this.fillProgress = fillProgress;
  }

  public CollectionStats invertedIndexSize(Long invertedIndexSize) {
    this.invertedIndexSize = invertedIndexSize;
    return this;
  }

   /**
   * Total collection inverted index size in bytes.
   * @return invertedIndexSize
  **/

@JsonProperty("inverted_index_size")
@ApiModelProperty(example = "123456", value = "Total collection inverted index size in bytes.")
  public Long getInvertedIndexSize() {
    return invertedIndexSize;
  }

  public void setInvertedIndexSize(Long invertedIndexSize) {
    this.invertedIndexSize = invertedIndexSize;
  }

  public CollectionStats lastQueriedMs(Long lastQueriedMs) {
    this.lastQueriedMs = lastQueriedMs;
    return this;
  }

   /**
   * Milliseconds since Unix epoch Jan 1, 1970.
   * @return lastQueriedMs
  **/

@JsonProperty("last_queried_ms")
@ApiModelProperty(example = "1535101119334", value = "Milliseconds since Unix epoch Jan 1, 1970.")
  public Long getLastQueriedMs() {
    return lastQueriedMs;
  }

  public void setLastQueriedMs(Long lastQueriedMs) {
    this.lastQueriedMs = lastQueriedMs;
  }

  public CollectionStats lastUpdatedMs(Long lastUpdatedMs) {
    this.lastUpdatedMs = lastUpdatedMs;
    return this;
  }

   /**
   * Milliseconds since Unix epoch Jan 1, 1970.
   * @return lastUpdatedMs
  **/

@JsonProperty("last_updated_ms")
@ApiModelProperty(example = "1535101094433", value = "Milliseconds since Unix epoch Jan 1, 1970.")
  public Long getLastUpdatedMs() {
    return lastUpdatedMs;
  }

  public void setLastUpdatedMs(Long lastUpdatedMs) {
    this.lastUpdatedMs = lastUpdatedMs;
  }

  public CollectionStats purgedDocCount(Long purgedDocCount) {
    this.purgedDocCount = purgedDocCount;
    return this;
  }

   /**
   * Number of documents purged from the collection.
   * @return purgedDocCount
  **/

@JsonProperty("purged_doc_count")
@ApiModelProperty(example = "2145", value = "Number of documents purged from the collection.")
  public Long getPurgedDocCount() {
    return purgedDocCount;
  }

  public void setPurgedDocCount(Long purgedDocCount) {
    this.purgedDocCount = purgedDocCount;
  }

  public CollectionStats purgedDocSize(Long purgedDocSize) {
    this.purgedDocSize = purgedDocSize;
    return this;
  }

   /**
   * Total size of bytes purged in bytes.
   * @return purgedDocSize
  **/

@JsonProperty("purged_doc_size")
@ApiModelProperty(example = "123456", value = "Total size of bytes purged in bytes.")
  public Long getPurgedDocSize() {
    return purgedDocSize;
  }

  public void setPurgedDocSize(Long purgedDocSize) {
    this.purgedDocSize = purgedDocSize;
  }

  public CollectionStats rangeIndexSize(Long rangeIndexSize) {
    this.rangeIndexSize = rangeIndexSize;
    return this;
  }

   /**
   * Total collection range index size in bytes.
   * @return rangeIndexSize
  **/

@JsonProperty("range_index_size")
@ApiModelProperty(example = "123456", value = "Total collection range index size in bytes.")
  public Long getRangeIndexSize() {
    return rangeIndexSize;
  }

  public void setRangeIndexSize(Long rangeIndexSize) {
    this.rangeIndexSize = rangeIndexSize;
  }

  public CollectionStats rowIndexSize(Long rowIndexSize) {
    this.rowIndexSize = rowIndexSize;
    return this;
  }

   /**
   * Total collection row index size in bytes.
   * @return rowIndexSize
  **/

@JsonProperty("row_index_size")
@ApiModelProperty(example = "123456", value = "Total collection row index size in bytes.")
  public Long getRowIndexSize() {
    return rowIndexSize;
  }

  public void setRowIndexSize(Long rowIndexSize) {
    this.rowIndexSize = rowIndexSize;
  }

  public CollectionStats totalIndexSize(Long totalIndexSize) {
    this.totalIndexSize = totalIndexSize;
    return this;
  }

   /**
   * Total collection index size in bytes.
   * @return totalIndexSize
  **/

@JsonProperty("total_index_size")
@ApiModelProperty(example = "123456", value = "Total collection index size in bytes.")
  public Long getTotalIndexSize() {
    return totalIndexSize;
  }

  public void setTotalIndexSize(Long totalIndexSize) {
    this.totalIndexSize = totalIndexSize;
  }

  public CollectionStats totalSize(Long totalSize) {
    this.totalSize = totalSize;
    return this;
  }

   /**
   * Total collection size in bytes.
   * @return totalSize
  **/

@JsonProperty("total_size")
@ApiModelProperty(example = "123456", value = "Total collection size in bytes.")
  public Long getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(Long totalSize) {
    this.totalSize = totalSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollectionStats collectionStats = (CollectionStats) o;
    return Objects.equals(this.bulkBytesInserted, collectionStats.bulkBytesInserted) &&
        Objects.equals(this.bulkBytesOverwritten, collectionStats.bulkBytesOverwritten) &&
        Objects.equals(this.bytesInserted, collectionStats.bytesInserted) &&
        Objects.equals(this.bytesOverwritten, collectionStats.bytesOverwritten) &&
        Objects.equals(this.columnIndexSize, collectionStats.columnIndexSize) &&
        Objects.equals(this.docCount, collectionStats.docCount) &&
        Objects.equals(this.fillProgress, collectionStats.fillProgress) &&
        Objects.equals(this.invertedIndexSize, collectionStats.invertedIndexSize) &&
        Objects.equals(this.lastQueriedMs, collectionStats.lastQueriedMs) &&
        Objects.equals(this.lastUpdatedMs, collectionStats.lastUpdatedMs) &&
        Objects.equals(this.purgedDocCount, collectionStats.purgedDocCount) &&
        Objects.equals(this.purgedDocSize, collectionStats.purgedDocSize) &&
        Objects.equals(this.rangeIndexSize, collectionStats.rangeIndexSize) &&
        Objects.equals(this.rowIndexSize, collectionStats.rowIndexSize) &&
        Objects.equals(this.totalIndexSize, collectionStats.totalIndexSize) &&
        Objects.equals(this.totalSize, collectionStats.totalSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bulkBytesInserted, bulkBytesOverwritten, bytesInserted, bytesOverwritten, columnIndexSize, docCount, fillProgress, invertedIndexSize, lastQueriedMs, lastUpdatedMs, purgedDocCount, purgedDocSize, rangeIndexSize, rowIndexSize, totalIndexSize, totalSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionStats {\n");
    
    sb.append("    bulkBytesInserted: ").append(toIndentedString(bulkBytesInserted)).append("\n");
    sb.append("    bulkBytesOverwritten: ").append(toIndentedString(bulkBytesOverwritten)).append("\n");
    sb.append("    bytesInserted: ").append(toIndentedString(bytesInserted)).append("\n");
    sb.append("    bytesOverwritten: ").append(toIndentedString(bytesOverwritten)).append("\n");
    sb.append("    columnIndexSize: ").append(toIndentedString(columnIndexSize)).append("\n");
    sb.append("    docCount: ").append(toIndentedString(docCount)).append("\n");
    sb.append("    fillProgress: ").append(toIndentedString(fillProgress)).append("\n");
    sb.append("    invertedIndexSize: ").append(toIndentedString(invertedIndexSize)).append("\n");
    sb.append("    lastQueriedMs: ").append(toIndentedString(lastQueriedMs)).append("\n");
    sb.append("    lastUpdatedMs: ").append(toIndentedString(lastUpdatedMs)).append("\n");
    sb.append("    purgedDocCount: ").append(toIndentedString(purgedDocCount)).append("\n");
    sb.append("    purgedDocSize: ").append(toIndentedString(purgedDocSize)).append("\n");
    sb.append("    rangeIndexSize: ").append(toIndentedString(rangeIndexSize)).append("\n");
    sb.append("    rowIndexSize: ").append(toIndentedString(rowIndexSize)).append("\n");
    sb.append("    totalIndexSize: ").append(toIndentedString(totalIndexSize)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
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

