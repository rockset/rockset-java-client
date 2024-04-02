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

/** SourceKafka */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class SourceKafka {
  @SerializedName("client_id")
  private String clientId = null;

  @SerializedName("consumer_group_id")
  private String consumerGroupId = null;

  @SerializedName("kafka_topic_name")
  private String kafkaTopicName = null;

  /** The offset reset policy. */
  @JsonAdapter(OffsetResetPolicyEnum.Adapter.class)
  public enum OffsetResetPolicyEnum {
    LATEST("LATEST"),

    EARLIEST("EARLIEST");

    private String value;

    OffsetResetPolicyEnum(String value) {
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
    public static OffsetResetPolicyEnum fromValue(String text) {
      for (OffsetResetPolicyEnum b : OffsetResetPolicyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OffsetResetPolicyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OffsetResetPolicyEnum enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OffsetResetPolicyEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OffsetResetPolicyEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("offset_reset_policy")
  private OffsetResetPolicyEnum offsetResetPolicy = null;

  @SerializedName("status")
  private StatusKafka status = null;

  @SerializedName("use_v3")
  private Boolean useV3 = null;

  public SourceKafka clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * The kafka client id being used.
   *
   * @return clientId
   */
  @JsonProperty("client_id")
  @ApiModelProperty(
      example = "cwc|0013a00001hSJ7oAAG|rockset-colln-consumer",
      value = "The kafka client id being used.")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public SourceKafka consumerGroupId(String consumerGroupId) {
    this.consumerGroupId = consumerGroupId;
    return this;
  }

  /**
   * The Kafka consumer group Id being used.
   *
   * @return consumerGroupId
   */
  @JsonProperty("consumer_group_id")
  @ApiModelProperty(example = "org-collection", value = "The Kafka consumer group Id being used.")
  public String getConsumerGroupId() {
    return consumerGroupId;
  }

  public void setConsumerGroupId(String consumerGroupId) {
    this.consumerGroupId = consumerGroupId;
  }

  public SourceKafka kafkaTopicName(String kafkaTopicName) {
    this.kafkaTopicName = kafkaTopicName;
    return this;
  }

  /**
   * The Kafka topic to be tailed.
   *
   * @return kafkaTopicName
   */
  @JsonProperty("kafka_topic_name")
  @ApiModelProperty(example = "example-topic", value = "The Kafka topic to be tailed.")
  public String getKafkaTopicName() {
    return kafkaTopicName;
  }

  public void setKafkaTopicName(String kafkaTopicName) {
    this.kafkaTopicName = kafkaTopicName;
  }

  public SourceKafka offsetResetPolicy(OffsetResetPolicyEnum offsetResetPolicy) {
    this.offsetResetPolicy = offsetResetPolicy;
    return this;
  }

  /**
   * The offset reset policy.
   *
   * @return offsetResetPolicy
   */
  @JsonProperty("offset_reset_policy")
  @ApiModelProperty(example = "EARLIEST", value = "The offset reset policy.")
  public OffsetResetPolicyEnum getOffsetResetPolicy() {
    return offsetResetPolicy;
  }

  public void setOffsetResetPolicy(OffsetResetPolicyEnum offsetResetPolicy) {
    this.offsetResetPolicy = offsetResetPolicy;
  }

  /**
   * Kafka source status.
   *
   * @return status
   */
  @JsonProperty("status")
  @ApiModelProperty(value = "Kafka source status.")
  public StatusKafka getStatus() {
    return status;
  }

  public SourceKafka useV3(Boolean useV3) {
    this.useV3 = useV3;
    return this;
  }

  /**
   * Whether to use v3 integration.
   *
   * @return useV3
   */
  @JsonProperty("use_v3")
  @ApiModelProperty(value = "Whether to use v3 integration.")
  public Boolean isUseV3() {
    return useV3;
  }

  public void setUseV3(Boolean useV3) {
    this.useV3 = useV3;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceKafka sourceKafka = (SourceKafka) o;
    return Objects.equals(this.clientId, sourceKafka.clientId)
        && Objects.equals(this.consumerGroupId, sourceKafka.consumerGroupId)
        && Objects.equals(this.kafkaTopicName, sourceKafka.kafkaTopicName)
        && Objects.equals(this.offsetResetPolicy, sourceKafka.offsetResetPolicy)
        && Objects.equals(this.status, sourceKafka.status)
        && Objects.equals(this.useV3, sourceKafka.useV3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        clientId, consumerGroupId, kafkaTopicName, offsetResetPolicy, status, useV3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceKafka {\n");

    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    consumerGroupId: ").append(toIndentedString(consumerGroupId)).append("\n");
    sb.append("    kafkaTopicName: ").append(toIndentedString(kafkaTopicName)).append("\n");
    sb.append("    offsetResetPolicy: ").append(toIndentedString(offsetResetPolicy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    useV3: ").append(toIndentedString(useV3)).append("\n");
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
