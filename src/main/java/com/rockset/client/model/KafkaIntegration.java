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
import com.rockset.client.model.AwsRole;
import com.rockset.client.model.KafkaV3SecurityConfig;
import com.rockset.client.model.SchemaRegistryConfig;
import com.rockset.client.model.StatusKafka;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * KafkaIntegration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class KafkaIntegration {
  @SerializedName("aws_role")
  private AwsRole awsRole = null;

  @SerializedName("bootstrap_servers")
  private String bootstrapServers = null;

  @SerializedName("connection_string")
  private String connectionString = null;

  /**
   * The format of the Kafka topics being tailed.
   */
  @JsonAdapter(KafkaDataFormatEnum.Adapter.class)
  public enum KafkaDataFormatEnum {
    JSON("JSON"),
    
    AVRO("AVRO");

    private String value;

    KafkaDataFormatEnum(String value) {
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
    public static KafkaDataFormatEnum fromValue(String text) {
      for (KafkaDataFormatEnum b : KafkaDataFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<KafkaDataFormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final KafkaDataFormatEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public KafkaDataFormatEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return KafkaDataFormatEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("kafka_data_format")
  private KafkaDataFormatEnum kafkaDataFormat = null;

  @SerializedName("kafka_topic_names")
  private List<String> kafkaTopicNames = null;

  @SerializedName("schema_registry_config")
  private SchemaRegistryConfig schemaRegistryConfig = null;

  @SerializedName("security_config")
  private KafkaV3SecurityConfig securityConfig = null;

  @SerializedName("source_status_by_topic")
  private Map<String, StatusKafka> sourceStatusByTopic = null;

  @SerializedName("use_v3")
  private Boolean useV3 = null;

  public KafkaIntegration awsRole(AwsRole awsRole) {
    this.awsRole = awsRole;
    return this;
  }

   /**
   * Details of an AWS cross-account role integration.
   * @return awsRole
  **/

@JsonProperty("aws_role")
@ApiModelProperty(value = "Details of an AWS cross-account role integration.")
  public AwsRole getAwsRole() {
    return awsRole;
  }

  public void setAwsRole(AwsRole awsRole) {
    this.awsRole = awsRole;
  }

  public KafkaIntegration bootstrapServers(String bootstrapServers) {
    this.bootstrapServers = bootstrapServers;
    return this;
  }

   /**
   * The Kafka bootstrap server url(s). Required only for V3 integration.
   * @return bootstrapServers
  **/

@JsonProperty("bootstrap_servers")
@ApiModelProperty(example = "localhost:9092", value = "The Kafka bootstrap server url(s). Required only for V3 integration.")
  public String getBootstrapServers() {
    return bootstrapServers;
  }

  public void setBootstrapServers(String bootstrapServers) {
    this.bootstrapServers = bootstrapServers;
  }

  public KafkaIntegration connectionString(String connectionString) {
    this.connectionString = connectionString;
    return this;
  }

   /**
   * Kafka connection string.
   * @return connectionString
  **/

@JsonProperty("connection_string")
@ApiModelProperty(value = "Kafka connection string.")
  public String getConnectionString() {
    return connectionString;
  }

  public void setConnectionString(String connectionString) {
    this.connectionString = connectionString;
  }

  public KafkaIntegration kafkaDataFormat(KafkaDataFormatEnum kafkaDataFormat) {
    this.kafkaDataFormat = kafkaDataFormat;
    return this;
  }

   /**
   * The format of the Kafka topics being tailed.
   * @return kafkaDataFormat
  **/

@JsonProperty("kafka_data_format")
@ApiModelProperty(example = "JSON", value = "The format of the Kafka topics being tailed.")
  public KafkaDataFormatEnum getKafkaDataFormat() {
    return kafkaDataFormat;
  }

  public void setKafkaDataFormat(KafkaDataFormatEnum kafkaDataFormat) {
    this.kafkaDataFormat = kafkaDataFormat;
  }

  public KafkaIntegration kafkaTopicNames(List<String> kafkaTopicNames) {
    this.kafkaTopicNames = kafkaTopicNames;
    return this;
  }

  public KafkaIntegration addKafkaTopicNamesItem(String kafkaTopicNamesItem) {
    if (this.kafkaTopicNames == null) {
      this.kafkaTopicNames = new ArrayList<String>();
    }
    this.kafkaTopicNames.add(kafkaTopicNamesItem);
    return this;
  }

   /**
   * Kafka topics to tail.
   * @return kafkaTopicNames
  **/

@JsonProperty("kafka_topic_names")
@ApiModelProperty(value = "Kafka topics to tail.")
  public List<String> getKafkaTopicNames() {
    return kafkaTopicNames;
  }

  public void setKafkaTopicNames(List<String> kafkaTopicNames) {
    this.kafkaTopicNames = kafkaTopicNames;
  }

  public KafkaIntegration schemaRegistryConfig(SchemaRegistryConfig schemaRegistryConfig) {
    this.schemaRegistryConfig = schemaRegistryConfig;
    return this;
  }

   /**
   * Kafka configurations for schema registry.
   * @return schemaRegistryConfig
  **/

@JsonProperty("schema_registry_config")
@ApiModelProperty(value = "Kafka configurations for schema registry.")
  public SchemaRegistryConfig getSchemaRegistryConfig() {
    return schemaRegistryConfig;
  }

  public void setSchemaRegistryConfig(SchemaRegistryConfig schemaRegistryConfig) {
    this.schemaRegistryConfig = schemaRegistryConfig;
  }

  public KafkaIntegration securityConfig(KafkaV3SecurityConfig securityConfig) {
    this.securityConfig = securityConfig;
    return this;
  }

   /**
   * Kafka security configurations.
   * @return securityConfig
  **/

@JsonProperty("security_config")
@ApiModelProperty(value = "Kafka security configurations.")
  public KafkaV3SecurityConfig getSecurityConfig() {
    return securityConfig;
  }

  public void setSecurityConfig(KafkaV3SecurityConfig securityConfig) {
    this.securityConfig = securityConfig;
  }

   /**
   * The status of the Kafka source by topic.
   * @return sourceStatusByTopic
  **/

@JsonProperty("source_status_by_topic")
@ApiModelProperty(example = "\"{\\\"topic-a\\\": \\\"DORMANT\\\"}\"", value = "The status of the Kafka source by topic.")
  public Map<String, StatusKafka> getSourceStatusByTopic() {
    return sourceStatusByTopic;
  }

  public KafkaIntegration useV3(Boolean useV3) {
    this.useV3 = useV3;
    return this;
  }

   /**
   * Get useV3
   * @return useV3
  **/

@JsonProperty("use_v3")
@ApiModelProperty(value = "")
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
    KafkaIntegration kafkaIntegration = (KafkaIntegration) o;
    return Objects.equals(this.awsRole, kafkaIntegration.awsRole) &&
        Objects.equals(this.bootstrapServers, kafkaIntegration.bootstrapServers) &&
        Objects.equals(this.connectionString, kafkaIntegration.connectionString) &&
        Objects.equals(this.kafkaDataFormat, kafkaIntegration.kafkaDataFormat) &&
        Objects.equals(this.kafkaTopicNames, kafkaIntegration.kafkaTopicNames) &&
        Objects.equals(this.schemaRegistryConfig, kafkaIntegration.schemaRegistryConfig) &&
        Objects.equals(this.securityConfig, kafkaIntegration.securityConfig) &&
        Objects.equals(this.sourceStatusByTopic, kafkaIntegration.sourceStatusByTopic) &&
        Objects.equals(this.useV3, kafkaIntegration.useV3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsRole, bootstrapServers, connectionString, kafkaDataFormat, kafkaTopicNames, schemaRegistryConfig, securityConfig, sourceStatusByTopic, useV3);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KafkaIntegration {\n");
    
    sb.append("    awsRole: ").append(toIndentedString(awsRole)).append("\n");
    sb.append("    bootstrapServers: ").append(toIndentedString(bootstrapServers)).append("\n");
    sb.append("    connectionString: ").append(toIndentedString(connectionString)).append("\n");
    sb.append("    kafkaDataFormat: ").append(toIndentedString(kafkaDataFormat)).append("\n");
    sb.append("    kafkaTopicNames: ").append(toIndentedString(kafkaTopicNames)).append("\n");
    sb.append("    schemaRegistryConfig: ").append(toIndentedString(schemaRegistryConfig)).append("\n");
    sb.append("    securityConfig: ").append(toIndentedString(securityConfig)).append("\n");
    sb.append("    sourceStatusByTopic: ").append(toIndentedString(sourceStatusByTopic)).append("\n");
    sb.append("    useV3: ").append(toIndentedString(useV3)).append("\n");
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

