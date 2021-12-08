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

/** StatusKafka */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-12-09T15:56:21.038-08:00")
public class StatusKafka {
  /** State of the Kafka source */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    NO_DOCS_YET("NODOCSYET"),

    ACTIVE("ACTIVE"),

    DORMANT("DORMANT");

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

  @SerializedName("last_consumed_time")
  private String lastConsumedTime = null;

  @SerializedName("num_documents_processed")
  private Long numDocumentsProcessed = null;

  @SerializedName("kafka_partitions")
  private List<StatusKafkaPartition> kafkaPartitions = null;

  public StatusKafka state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of the Kafka source
   *
   * @return state
   */
  @JsonProperty("state")
  @ApiModelProperty(example = "ACTIVE", value = "State of the Kafka source")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public StatusKafka lastConsumedTime(String lastConsumedTime) {
    this.lastConsumedTime = lastConsumedTime;
    return this;
  }

  /**
   * Time at which the last document was consumed from Kafka
   *
   * @return lastConsumedTime
   */
  @JsonProperty("last_consumed_time")
  @ApiModelProperty(
      example = "2001-08-28T00:23:41Z",
      value = "Time at which the last document was consumed from Kafka")
  public String getLastConsumedTime() {
    return lastConsumedTime;
  }

  public void setLastConsumedTime(String lastConsumedTime) {
    this.lastConsumedTime = lastConsumedTime;
  }

  public StatusKafka numDocumentsProcessed(Long numDocumentsProcessed) {
    this.numDocumentsProcessed = numDocumentsProcessed;
    return this;
  }

  /**
   * Number of documents consumed by this Kafka topic
   *
   * @return numDocumentsProcessed
   */
  @JsonProperty("num_documents_processed")
  @ApiModelProperty(example = "1337", value = "Number of documents consumed by this Kafka topic")
  public Long getNumDocumentsProcessed() {
    return numDocumentsProcessed;
  }

  public void setNumDocumentsProcessed(Long numDocumentsProcessed) {
    this.numDocumentsProcessed = numDocumentsProcessed;
  }

  public StatusKafka kafkaPartitions(List<StatusKafkaPartition> kafkaPartitions) {
    this.kafkaPartitions = kafkaPartitions;
    return this;
  }

  public StatusKafka addKafkaPartitionsItem(StatusKafkaPartition kafkaPartitionsItem) {
    if (this.kafkaPartitions == null) {
      this.kafkaPartitions = new ArrayList<StatusKafkaPartition>();
    }
    this.kafkaPartitions.add(kafkaPartitionsItem);
    return this;
  }

  /**
   * Status info per partition
   *
   * @return kafkaPartitions
   */
  @JsonProperty("kafka_partitions")
  @ApiModelProperty(value = "Status info per partition")
  public List<StatusKafkaPartition> getKafkaPartitions() {
    return kafkaPartitions;
  }

  public void setKafkaPartitions(List<StatusKafkaPartition> kafkaPartitions) {
    this.kafkaPartitions = kafkaPartitions;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusKafka statusKafka = (StatusKafka) o;
    return Objects.equals(this.state, statusKafka.state)
        && Objects.equals(this.lastConsumedTime, statusKafka.lastConsumedTime)
        && Objects.equals(this.numDocumentsProcessed, statusKafka.numDocumentsProcessed)
        && Objects.equals(this.kafkaPartitions, statusKafka.kafkaPartitions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, lastConsumedTime, numDocumentsProcessed, kafkaPartitions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusKafka {\n");

    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    lastConsumedTime: ").append(toIndentedString(lastConsumedTime)).append("\n");
    sb.append("    numDocumentsProcessed: ")
        .append(toIndentedString(numDocumentsProcessed))
        .append("\n");
    sb.append("    kafkaPartitions: ").append(toIndentedString(kafkaPartitions)).append("\n");
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
