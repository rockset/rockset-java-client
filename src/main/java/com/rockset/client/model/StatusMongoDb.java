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
import java.util.Objects;

/** StatusMongoDb */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class StatusMongoDb {
  @SerializedName("scan_end_time")
  private String scanEndTime = null;

  @SerializedName("scan_records_processed")
  private Long scanRecordsProcessed = null;

  @SerializedName("scan_start_time")
  private String scanStartTime = null;

  @SerializedName("scan_total_records")
  private Long scanTotalRecords = null;

  /** State of current ingest for this table. */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    INITIALIZING("INITIALIZING"),

    SCANNING_TABLE("SCANNINGTABLE"),

    PROCESSING_STREAM("PROCESSINGSTREAM");

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

  @SerializedName("stream_last_delete_processed_at")
  private String streamLastDeleteProcessedAt = null;

  @SerializedName("stream_last_insert_processed_at")
  private String streamLastInsertProcessedAt = null;

  @SerializedName("stream_last_update_processed_at")
  private String streamLastUpdateProcessedAt = null;

  @SerializedName("stream_records_deleted")
  private Long streamRecordsDeleted = null;

  @SerializedName("stream_records_inserted")
  private Long streamRecordsInserted = null;

  @SerializedName("stream_records_updated")
  private Long streamRecordsUpdated = null;

  public StatusMongoDb scanEndTime(String scanEndTime) {
    this.scanEndTime = scanEndTime;
    return this;
  }

  /**
   * MongoDB scan end time.
   *
   * @return scanEndTime
   */
  @JsonProperty("scan_end_time")
  @ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "MongoDB scan end time.")
  public String getScanEndTime() {
    return scanEndTime;
  }

  public void setScanEndTime(String scanEndTime) {
    this.scanEndTime = scanEndTime;
  }

  public StatusMongoDb scanRecordsProcessed(Long scanRecordsProcessed) {
    this.scanRecordsProcessed = scanRecordsProcessed;
    return this;
  }

  /**
   * Number of records inserted using scan.
   *
   * @return scanRecordsProcessed
   */
  @JsonProperty("scan_records_processed")
  @ApiModelProperty(example = "1000", value = "Number of records inserted using scan.")
  public Long getScanRecordsProcessed() {
    return scanRecordsProcessed;
  }

  public void setScanRecordsProcessed(Long scanRecordsProcessed) {
    this.scanRecordsProcessed = scanRecordsProcessed;
  }

  public StatusMongoDb scanStartTime(String scanStartTime) {
    this.scanStartTime = scanStartTime;
    return this;
  }

  /**
   * MongoDB scan start time.
   *
   * @return scanStartTime
   */
  @JsonProperty("scan_start_time")
  @ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "MongoDB scan start time.")
  public String getScanStartTime() {
    return scanStartTime;
  }

  public void setScanStartTime(String scanStartTime) {
    this.scanStartTime = scanStartTime;
  }

  public StatusMongoDb scanTotalRecords(Long scanTotalRecords) {
    this.scanTotalRecords = scanTotalRecords;
    return this;
  }

  /**
   * Number of records in MongoDB table at time of scan.
   *
   * @return scanTotalRecords
   */
  @JsonProperty("scan_total_records")
  @ApiModelProperty(example = "2000", value = "Number of records in MongoDB table at time of scan.")
  public Long getScanTotalRecords() {
    return scanTotalRecords;
  }

  public void setScanTotalRecords(Long scanTotalRecords) {
    this.scanTotalRecords = scanTotalRecords;
  }

  public StatusMongoDb state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of current ingest for this table.
   *
   * @return state
   */
  @JsonProperty("state")
  @ApiModelProperty(example = "SCANNING_TABLE", value = "State of current ingest for this table.")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public StatusMongoDb streamLastDeleteProcessedAt(String streamLastDeleteProcessedAt) {
    this.streamLastDeleteProcessedAt = streamLastDeleteProcessedAt;
    return this;
  }

  /**
   * ISO-8601 date when delete from source was last processed.
   *
   * @return streamLastDeleteProcessedAt
   */
  @JsonProperty("stream_last_delete_processed_at")
  @ApiModelProperty(
      example = "2019-01-15T21:48:23Z",
      value = "ISO-8601 date when delete from source was last processed.")
  public String getStreamLastDeleteProcessedAt() {
    return streamLastDeleteProcessedAt;
  }

  public void setStreamLastDeleteProcessedAt(String streamLastDeleteProcessedAt) {
    this.streamLastDeleteProcessedAt = streamLastDeleteProcessedAt;
  }

  public StatusMongoDb streamLastInsertProcessedAt(String streamLastInsertProcessedAt) {
    this.streamLastInsertProcessedAt = streamLastInsertProcessedAt;
    return this;
  }

  /**
   * ISO-8601 date when new insert from source was last processed.
   *
   * @return streamLastInsertProcessedAt
   */
  @JsonProperty("stream_last_insert_processed_at")
  @ApiModelProperty(
      example = "2019-01-15T21:48:23Z",
      value = "ISO-8601 date when new insert from source was last processed.")
  public String getStreamLastInsertProcessedAt() {
    return streamLastInsertProcessedAt;
  }

  public void setStreamLastInsertProcessedAt(String streamLastInsertProcessedAt) {
    this.streamLastInsertProcessedAt = streamLastInsertProcessedAt;
  }

  public StatusMongoDb streamLastUpdateProcessedAt(String streamLastUpdateProcessedAt) {
    this.streamLastUpdateProcessedAt = streamLastUpdateProcessedAt;
    return this;
  }

  /**
   * ISO-8601 date when update from source was last processed.
   *
   * @return streamLastUpdateProcessedAt
   */
  @JsonProperty("stream_last_update_processed_at")
  @ApiModelProperty(
      example = "2019-01-15T21:48:23Z",
      value = "ISO-8601 date when update from source was last processed.")
  public String getStreamLastUpdateProcessedAt() {
    return streamLastUpdateProcessedAt;
  }

  public void setStreamLastUpdateProcessedAt(String streamLastUpdateProcessedAt) {
    this.streamLastUpdateProcessedAt = streamLastUpdateProcessedAt;
  }

  public StatusMongoDb streamRecordsDeleted(Long streamRecordsDeleted) {
    this.streamRecordsDeleted = streamRecordsDeleted;
    return this;
  }

  /**
   * Number of new records deleted using stream.
   *
   * @return streamRecordsDeleted
   */
  @JsonProperty("stream_records_deleted")
  @ApiModelProperty(example = "100", value = "Number of new records deleted using stream.")
  public Long getStreamRecordsDeleted() {
    return streamRecordsDeleted;
  }

  public void setStreamRecordsDeleted(Long streamRecordsDeleted) {
    this.streamRecordsDeleted = streamRecordsDeleted;
  }

  public StatusMongoDb streamRecordsInserted(Long streamRecordsInserted) {
    this.streamRecordsInserted = streamRecordsInserted;
    return this;
  }

  /**
   * Number of new records inserted using stream.
   *
   * @return streamRecordsInserted
   */
  @JsonProperty("stream_records_inserted")
  @ApiModelProperty(example = "10000", value = "Number of new records inserted using stream.")
  public Long getStreamRecordsInserted() {
    return streamRecordsInserted;
  }

  public void setStreamRecordsInserted(Long streamRecordsInserted) {
    this.streamRecordsInserted = streamRecordsInserted;
  }

  public StatusMongoDb streamRecordsUpdated(Long streamRecordsUpdated) {
    this.streamRecordsUpdated = streamRecordsUpdated;
    return this;
  }

  /**
   * Number of new records updated using stream.
   *
   * @return streamRecordsUpdated
   */
  @JsonProperty("stream_records_updated")
  @ApiModelProperty(example = "1000", value = "Number of new records updated using stream.")
  public Long getStreamRecordsUpdated() {
    return streamRecordsUpdated;
  }

  public void setStreamRecordsUpdated(Long streamRecordsUpdated) {
    this.streamRecordsUpdated = streamRecordsUpdated;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusMongoDb statusMongoDb = (StatusMongoDb) o;
    return Objects.equals(this.scanEndTime, statusMongoDb.scanEndTime)
        && Objects.equals(this.scanRecordsProcessed, statusMongoDb.scanRecordsProcessed)
        && Objects.equals(this.scanStartTime, statusMongoDb.scanStartTime)
        && Objects.equals(this.scanTotalRecords, statusMongoDb.scanTotalRecords)
        && Objects.equals(this.state, statusMongoDb.state)
        && Objects.equals(
            this.streamLastDeleteProcessedAt, statusMongoDb.streamLastDeleteProcessedAt)
        && Objects.equals(
            this.streamLastInsertProcessedAt, statusMongoDb.streamLastInsertProcessedAt)
        && Objects.equals(
            this.streamLastUpdateProcessedAt, statusMongoDb.streamLastUpdateProcessedAt)
        && Objects.equals(this.streamRecordsDeleted, statusMongoDb.streamRecordsDeleted)
        && Objects.equals(this.streamRecordsInserted, statusMongoDb.streamRecordsInserted)
        && Objects.equals(this.streamRecordsUpdated, statusMongoDb.streamRecordsUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        scanEndTime,
        scanRecordsProcessed,
        scanStartTime,
        scanTotalRecords,
        state,
        streamLastDeleteProcessedAt,
        streamLastInsertProcessedAt,
        streamLastUpdateProcessedAt,
        streamRecordsDeleted,
        streamRecordsInserted,
        streamRecordsUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusMongoDb {\n");

    sb.append("    scanEndTime: ").append(toIndentedString(scanEndTime)).append("\n");
    sb.append("    scanRecordsProcessed: ")
        .append(toIndentedString(scanRecordsProcessed))
        .append("\n");
    sb.append("    scanStartTime: ").append(toIndentedString(scanStartTime)).append("\n");
    sb.append("    scanTotalRecords: ").append(toIndentedString(scanTotalRecords)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    streamLastDeleteProcessedAt: ")
        .append(toIndentedString(streamLastDeleteProcessedAt))
        .append("\n");
    sb.append("    streamLastInsertProcessedAt: ")
        .append(toIndentedString(streamLastInsertProcessedAt))
        .append("\n");
    sb.append("    streamLastUpdateProcessedAt: ")
        .append(toIndentedString(streamLastUpdateProcessedAt))
        .append("\n");
    sb.append("    streamRecordsDeleted: ")
        .append(toIndentedString(streamRecordsDeleted))
        .append("\n");
    sb.append("    streamRecordsInserted: ")
        .append(toIndentedString(streamRecordsInserted))
        .append("\n");
    sb.append("    streamRecordsUpdated: ")
        .append(toIndentedString(streamRecordsUpdated))
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
