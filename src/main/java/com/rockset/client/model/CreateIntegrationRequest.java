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
import com.rockset.client.model.AzureBlobStorageIntegration;
import com.rockset.client.model.AzureEventHubsIntegration;
import com.rockset.client.model.AzureServiceBusIntegration;
import com.rockset.client.model.DynamodbIntegration;
import com.rockset.client.model.GcsIntegration;
import com.rockset.client.model.KafkaIntegration;
import com.rockset.client.model.KinesisIntegration;
import com.rockset.client.model.MongoDbIntegration;
import com.rockset.client.model.S3Integration;
import com.rockset.client.model.SnowflakeIntegration;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CreateIntegrationRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-25T12:03:52.511Z")
public class CreateIntegrationRequest {
  @SerializedName("azure_blob_storage")
  private AzureBlobStorageIntegration azureBlobStorage = null;

  @SerializedName("azure_event_hubs")
  private AzureEventHubsIntegration azureEventHubs = null;

  @SerializedName("azure_service_bus")
  private AzureServiceBusIntegration azureServiceBus = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("dynamodb")
  private DynamodbIntegration dynamodb = null;

  @SerializedName("gcs")
  private GcsIntegration gcs = null;

  @SerializedName("kafka")
  private KafkaIntegration kafka = null;

  @SerializedName("kinesis")
  private KinesisIntegration kinesis = null;

  @SerializedName("mongodb")
  private MongoDbIntegration mongodb = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("s3")
  private S3Integration s3 = null;

  @SerializedName("snowflake")
  private SnowflakeIntegration snowflake = null;

  public CreateIntegrationRequest azureBlobStorage(AzureBlobStorageIntegration azureBlobStorage) {
    this.azureBlobStorage = azureBlobStorage;
    return this;
  }

   /**
   * Azure Blob Storage details.
   * @return azureBlobStorage
  **/

@JsonProperty("azure_blob_storage")
@ApiModelProperty(value = "Azure Blob Storage details.")
  public AzureBlobStorageIntegration getAzureBlobStorage() {
    return azureBlobStorage;
  }

  public void setAzureBlobStorage(AzureBlobStorageIntegration azureBlobStorage) {
    this.azureBlobStorage = azureBlobStorage;
  }

  public CreateIntegrationRequest azureEventHubs(AzureEventHubsIntegration azureEventHubs) {
    this.azureEventHubs = azureEventHubs;
    return this;
  }

   /**
   * Azure Event Hubs details.
   * @return azureEventHubs
  **/

@JsonProperty("azure_event_hubs")
@ApiModelProperty(value = "Azure Event Hubs details.")
  public AzureEventHubsIntegration getAzureEventHubs() {
    return azureEventHubs;
  }

  public void setAzureEventHubs(AzureEventHubsIntegration azureEventHubs) {
    this.azureEventHubs = azureEventHubs;
  }

  public CreateIntegrationRequest azureServiceBus(AzureServiceBusIntegration azureServiceBus) {
    this.azureServiceBus = azureServiceBus;
    return this;
  }

   /**
   * Azure Service Bus details.
   * @return azureServiceBus
  **/

@JsonProperty("azure_service_bus")
@ApiModelProperty(value = "Azure Service Bus details.")
  public AzureServiceBusIntegration getAzureServiceBus() {
    return azureServiceBus;
  }

  public void setAzureServiceBus(AzureServiceBusIntegration azureServiceBus) {
    this.azureServiceBus = azureServiceBus;
  }

  public CreateIntegrationRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Longer explanation for the integration.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "AWS account with event data for the data science team.", value = "Longer explanation for the integration.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateIntegrationRequest dynamodb(DynamodbIntegration dynamodb) {
    this.dynamodb = dynamodb;
    return this;
  }

   /**
   * Amazon DynamoDB details, must have one of aws_access_key or aws_role.
   * @return dynamodb
  **/

@JsonProperty("dynamodb")
@ApiModelProperty(value = "Amazon DynamoDB details, must have one of aws_access_key or aws_role.")
  public DynamodbIntegration getDynamodb() {
    return dynamodb;
  }

  public void setDynamodb(DynamodbIntegration dynamodb) {
    this.dynamodb = dynamodb;
  }

  public CreateIntegrationRequest gcs(GcsIntegration gcs) {
    this.gcs = gcs;
    return this;
  }

   /**
   * GCS details.
   * @return gcs
  **/

@JsonProperty("gcs")
@ApiModelProperty(value = "GCS details.")
  public GcsIntegration getGcs() {
    return gcs;
  }

  public void setGcs(GcsIntegration gcs) {
    this.gcs = gcs;
  }

  public CreateIntegrationRequest kafka(KafkaIntegration kafka) {
    this.kafka = kafka;
    return this;
  }

   /**
   * Get kafka
   * @return kafka
  **/

@JsonProperty("kafka")
@ApiModelProperty(value = "")
  public KafkaIntegration getKafka() {
    return kafka;
  }

  public void setKafka(KafkaIntegration kafka) {
    this.kafka = kafka;
  }

  public CreateIntegrationRequest kinesis(KinesisIntegration kinesis) {
    this.kinesis = kinesis;
    return this;
  }

   /**
   * Amazon Kinesis details, must have one of aws_access_key or aws_role.
   * @return kinesis
  **/

@JsonProperty("kinesis")
@ApiModelProperty(value = "Amazon Kinesis details, must have one of aws_access_key or aws_role.")
  public KinesisIntegration getKinesis() {
    return kinesis;
  }

  public void setKinesis(KinesisIntegration kinesis) {
    this.kinesis = kinesis;
  }

  public CreateIntegrationRequest mongodb(MongoDbIntegration mongodb) {
    this.mongodb = mongodb;
    return this;
  }

   /**
   * MongoDb details.
   * @return mongodb
  **/

@JsonProperty("mongodb")
@ApiModelProperty(value = "MongoDb details.")
  public MongoDbIntegration getMongodb() {
    return mongodb;
  }

  public void setMongodb(MongoDbIntegration mongodb) {
    this.mongodb = mongodb;
  }

  public CreateIntegrationRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Descriptive label.
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "event-logs", required = true, value = "Descriptive label.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateIntegrationRequest s3(S3Integration s3) {
    this.s3 = s3;
    return this;
  }

   /**
   * Amazon S3 details, must have one of aws_access_key or aws_role.
   * @return s3
  **/

@JsonProperty("s3")
@ApiModelProperty(value = "Amazon S3 details, must have one of aws_access_key or aws_role.")
  public S3Integration getS3() {
    return s3;
  }

  public void setS3(S3Integration s3) {
    this.s3 = s3;
  }

  public CreateIntegrationRequest snowflake(SnowflakeIntegration snowflake) {
    this.snowflake = snowflake;
    return this;
  }

   /**
   * Snowflake details.
   * @return snowflake
  **/

@JsonProperty("snowflake")
@ApiModelProperty(value = "Snowflake details.")
  public SnowflakeIntegration getSnowflake() {
    return snowflake;
  }

  public void setSnowflake(SnowflakeIntegration snowflake) {
    this.snowflake = snowflake;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateIntegrationRequest createIntegrationRequest = (CreateIntegrationRequest) o;
    return Objects.equals(this.azureBlobStorage, createIntegrationRequest.azureBlobStorage) &&
        Objects.equals(this.azureEventHubs, createIntegrationRequest.azureEventHubs) &&
        Objects.equals(this.azureServiceBus, createIntegrationRequest.azureServiceBus) &&
        Objects.equals(this.description, createIntegrationRequest.description) &&
        Objects.equals(this.dynamodb, createIntegrationRequest.dynamodb) &&
        Objects.equals(this.gcs, createIntegrationRequest.gcs) &&
        Objects.equals(this.kafka, createIntegrationRequest.kafka) &&
        Objects.equals(this.kinesis, createIntegrationRequest.kinesis) &&
        Objects.equals(this.mongodb, createIntegrationRequest.mongodb) &&
        Objects.equals(this.name, createIntegrationRequest.name) &&
        Objects.equals(this.s3, createIntegrationRequest.s3) &&
        Objects.equals(this.snowflake, createIntegrationRequest.snowflake);
  }

  @Override
  public int hashCode() {
    return Objects.hash(azureBlobStorage, azureEventHubs, azureServiceBus, description, dynamodb, gcs, kafka, kinesis, mongodb, name, s3, snowflake);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateIntegrationRequest {\n");
    
    sb.append("    azureBlobStorage: ").append(toIndentedString(azureBlobStorage)).append("\n");
    sb.append("    azureEventHubs: ").append(toIndentedString(azureEventHubs)).append("\n");
    sb.append("    azureServiceBus: ").append(toIndentedString(azureServiceBus)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dynamodb: ").append(toIndentedString(dynamodb)).append("\n");
    sb.append("    gcs: ").append(toIndentedString(gcs)).append("\n");
    sb.append("    kafka: ").append(toIndentedString(kafka)).append("\n");
    sb.append("    kinesis: ").append(toIndentedString(kinesis)).append("\n");
    sb.append("    mongodb: ").append(toIndentedString(mongodb)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    s3: ").append(toIndentedString(s3)).append("\n");
    sb.append("    snowflake: ").append(toIndentedString(snowflake)).append("\n");
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

