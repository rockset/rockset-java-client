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
import com.rockset.client.model.FieldMappingQuery;
import com.rockset.client.model.FormatParams;
import com.rockset.client.model.SourceAzureBlobStorage;
import com.rockset.client.model.SourceAzureEventHubs;
import com.rockset.client.model.SourceAzureServiceBus;
import com.rockset.client.model.SourceDynamoDb;
import com.rockset.client.model.SourceFileUpload;
import com.rockset.client.model.SourceGcs;
import com.rockset.client.model.SourceKafka;
import com.rockset.client.model.SourceKinesis;
import com.rockset.client.model.SourceMongoDb;
import com.rockset.client.model.SourceS3;
import com.rockset.client.model.SourceSnapshot;
import com.rockset.client.model.SourceSnowflake;
import com.rockset.client.model.SourceSystem;
import com.rockset.client.model.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details about the data source for the given collection. Only one of the following fields are allowed to be defined. Only collections can act as data sources for views. 
 */

@ApiModel(description = "Details about the data source for the given collection. Only one of the following fields are allowed to be defined. Only collections can act as data sources for views. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-14T01:21:30.506Z")
public class Source {
  @SerializedName("azure_blob_storage")
  private SourceAzureBlobStorage azureBlobStorage = null;

  @SerializedName("azure_event_hubs")
  private SourceAzureEventHubs azureEventHubs = null;

  @SerializedName("azure_service_bus")
  private SourceAzureServiceBus azureServiceBus = null;

  @SerializedName("dynamodb")
  private SourceDynamoDb dynamodb = null;

  @SerializedName("file_upload")
  private SourceFileUpload fileUpload = null;

  @SerializedName("format_params")
  private FormatParams formatParams = null;

  @SerializedName("gcs")
  private SourceGcs gcs = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("ingest_transformation")
  private FieldMappingQuery ingestTransformation = null;

  @SerializedName("integration_name")
  private String integrationName = null;

  @SerializedName("kafka")
  private SourceKafka kafka = null;

  @SerializedName("kinesis")
  private SourceKinesis kinesis = null;

  @SerializedName("mongodb")
  private SourceMongoDb mongodb = null;

  @SerializedName("resume_at")
  private String resumeAt = null;

  @SerializedName("s3")
  private SourceS3 s3 = null;

  @SerializedName("snapshot")
  private SourceSnapshot snapshot = null;

  @SerializedName("snowflake")
  private SourceSnowflake snowflake = null;

  @SerializedName("status")
  private Status status = null;

  @SerializedName("suspended_at")
  private String suspendedAt = null;

  @SerializedName("system")
  private SourceSystem system = null;

  public Source azureBlobStorage(SourceAzureBlobStorage azureBlobStorage) {
    this.azureBlobStorage = azureBlobStorage;
    return this;
  }

   /**
   * Configuration for ingestion from Azure Blob Storage.
   * @return azureBlobStorage
  **/

@JsonProperty("azure_blob_storage")
@ApiModelProperty(value = "Configuration for ingestion from Azure Blob Storage.")
  public SourceAzureBlobStorage getAzureBlobStorage() {
    return azureBlobStorage;
  }

  public void setAzureBlobStorage(SourceAzureBlobStorage azureBlobStorage) {
    this.azureBlobStorage = azureBlobStorage;
  }

  public Source azureEventHubs(SourceAzureEventHubs azureEventHubs) {
    this.azureEventHubs = azureEventHubs;
    return this;
  }

   /**
   * Configuration for ingestion from Azure Event Hubs.
   * @return azureEventHubs
  **/

@JsonProperty("azure_event_hubs")
@ApiModelProperty(value = "Configuration for ingestion from Azure Event Hubs.")
  public SourceAzureEventHubs getAzureEventHubs() {
    return azureEventHubs;
  }

  public void setAzureEventHubs(SourceAzureEventHubs azureEventHubs) {
    this.azureEventHubs = azureEventHubs;
  }

  public Source azureServiceBus(SourceAzureServiceBus azureServiceBus) {
    this.azureServiceBus = azureServiceBus;
    return this;
  }

   /**
   * Get azureServiceBus
   * @return azureServiceBus
  **/

@JsonProperty("azure_service_bus")
@ApiModelProperty(value = "")
  public SourceAzureServiceBus getAzureServiceBus() {
    return azureServiceBus;
  }

  public void setAzureServiceBus(SourceAzureServiceBus azureServiceBus) {
    this.azureServiceBus = azureServiceBus;
  }

  public Source dynamodb(SourceDynamoDb dynamodb) {
    this.dynamodb = dynamodb;
    return this;
  }

   /**
   * Configuration for ingestion from  a dynamodb table.
   * @return dynamodb
  **/

@JsonProperty("dynamodb")
@ApiModelProperty(value = "Configuration for ingestion from  a dynamodb table.")
  public SourceDynamoDb getDynamodb() {
    return dynamodb;
  }

  public void setDynamodb(SourceDynamoDb dynamodb) {
    this.dynamodb = dynamodb;
  }

   /**
   * File upload details.
   * @return fileUpload
  **/

@JsonProperty("file_upload")
@ApiModelProperty(value = "File upload details.")
  public SourceFileUpload getFileUpload() {
    return fileUpload;
  }

  public Source formatParams(FormatParams formatParams) {
    this.formatParams = formatParams;
    return this;
  }

   /**
   * Format parameters for data from this source.
   * @return formatParams
  **/

@JsonProperty("format_params")
@ApiModelProperty(value = "Format parameters for data from this source.")
  public FormatParams getFormatParams() {
    return formatParams;
  }

  public void setFormatParams(FormatParams formatParams) {
    this.formatParams = formatParams;
  }

  public Source gcs(SourceGcs gcs) {
    this.gcs = gcs;
    return this;
  }

   /**
   * Configuration for ingestion from GCS.
   * @return gcs
  **/

@JsonProperty("gcs")
@ApiModelProperty(value = "Configuration for ingestion from GCS.")
  public SourceGcs getGcs() {
    return gcs;
  }

  public void setGcs(SourceGcs gcs) {
    this.gcs = gcs;
  }

   /**
   * Unique source identifier.
   * @return id
  **/

@JsonProperty("id")
@ApiModelProperty(example = "a1df483c-734e-485b-8005-f46386ef42f6", value = "Unique source identifier.")
  public String getId() {
    return id;
  }

  public Source ingestTransformation(FieldMappingQuery ingestTransformation) {
    this.ingestTransformation = ingestTransformation;
    return this;
  }

   /**
   * Ingest transformation for a source.
   * @return ingestTransformation
  **/

@JsonProperty("ingest_transformation")
@ApiModelProperty(value = "Ingest transformation for a source.")
  public FieldMappingQuery getIngestTransformation() {
    return ingestTransformation;
  }

  public void setIngestTransformation(FieldMappingQuery ingestTransformation) {
    this.ingestTransformation = ingestTransformation;
  }

  public Source integrationName(String integrationName) {
    this.integrationName = integrationName;
    return this;
  }

   /**
   * Name of integration to use.
   * @return integrationName
  **/

@JsonProperty("integration_name")
@ApiModelProperty(example = "aws-integration", value = "Name of integration to use.")
  public String getIntegrationName() {
    return integrationName;
  }

  public void setIntegrationName(String integrationName) {
    this.integrationName = integrationName;
  }

  public Source kafka(SourceKafka kafka) {
    this.kafka = kafka;
    return this;
  }

   /**
   * Kafka collection identifier.
   * @return kafka
  **/

@JsonProperty("kafka")
@ApiModelProperty(value = "Kafka collection identifier.")
  public SourceKafka getKafka() {
    return kafka;
  }

  public void setKafka(SourceKafka kafka) {
    this.kafka = kafka;
  }

  public Source kinesis(SourceKinesis kinesis) {
    this.kinesis = kinesis;
    return this;
  }

   /**
   * Configuration for ingestion from kinesis stream.
   * @return kinesis
  **/

@JsonProperty("kinesis")
@ApiModelProperty(value = "Configuration for ingestion from kinesis stream.")
  public SourceKinesis getKinesis() {
    return kinesis;
  }

  public void setKinesis(SourceKinesis kinesis) {
    this.kinesis = kinesis;
  }

  public Source mongodb(SourceMongoDb mongodb) {
    this.mongodb = mongodb;
    return this;
  }

   /**
   * MongoDB collection details.
   * @return mongodb
  **/

@JsonProperty("mongodb")
@ApiModelProperty(value = "MongoDB collection details.")
  public SourceMongoDb getMongodb() {
    return mongodb;
  }

  public void setMongodb(SourceMongoDb mongodb) {
    this.mongodb = mongodb;
  }

   /**
   * ISO-8601 date when source would be auto resumed, if suspended
   * @return resumeAt
  **/

@JsonProperty("resume_at")
@ApiModelProperty(example = "2019-01-15T21:48:23Z", value = "ISO-8601 date when source would be auto resumed, if suspended")
  public String getResumeAt() {
    return resumeAt;
  }

  public Source s3(SourceS3 s3) {
    this.s3 = s3;
    return this;
  }

   /**
   * Configuration for ingestion from S3.
   * @return s3
  **/

@JsonProperty("s3")
@ApiModelProperty(value = "Configuration for ingestion from S3.")
  public SourceS3 getS3() {
    return s3;
  }

  public void setS3(SourceS3 s3) {
    this.s3 = s3;
  }

  public Source snapshot(SourceSnapshot snapshot) {
    this.snapshot = snapshot;
    return this;
  }

   /**
   * Configuration for restoring from snapshot.
   * @return snapshot
  **/

@JsonProperty("snapshot")
@ApiModelProperty(value = "Configuration for restoring from snapshot.")
  public SourceSnapshot getSnapshot() {
    return snapshot;
  }

  public void setSnapshot(SourceSnapshot snapshot) {
    this.snapshot = snapshot;
  }

  public Source snowflake(SourceSnowflake snowflake) {
    this.snowflake = snowflake;
    return this;
  }

   /**
   * Configuration for ingestion from Snowflake.
   * @return snowflake
  **/

@JsonProperty("snowflake")
@ApiModelProperty(value = "Configuration for ingestion from Snowflake.")
  public SourceSnowflake getSnowflake() {
    return snowflake;
  }

  public void setSnowflake(SourceSnowflake snowflake) {
    this.snowflake = snowflake;
  }

   /**
   * The ingest status of this source.
   * @return status
  **/

@JsonProperty("status")
@ApiModelProperty(value = "The ingest status of this source.")
  public Status getStatus() {
    return status;
  }

   /**
   * ISO-8601 date when source was suspended, if suspended
   * @return suspendedAt
  **/

@JsonProperty("suspended_at")
@ApiModelProperty(example = "2019-01-15T21:48:23Z", value = "ISO-8601 date when source was suspended, if suspended")
  public String getSuspendedAt() {
    return suspendedAt;
  }

  public Source system(SourceSystem system) {
    this.system = system;
    return this;
  }

   /**
   * Get system
   * @return system
  **/

@JsonProperty("system")
@ApiModelProperty(value = "")
  public SourceSystem getSystem() {
    return system;
  }

  public void setSystem(SourceSystem system) {
    this.system = system;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Source source = (Source) o;
    return Objects.equals(this.azureBlobStorage, source.azureBlobStorage) &&
        Objects.equals(this.azureEventHubs, source.azureEventHubs) &&
        Objects.equals(this.azureServiceBus, source.azureServiceBus) &&
        Objects.equals(this.dynamodb, source.dynamodb) &&
        Objects.equals(this.fileUpload, source.fileUpload) &&
        Objects.equals(this.formatParams, source.formatParams) &&
        Objects.equals(this.gcs, source.gcs) &&
        Objects.equals(this.id, source.id) &&
        Objects.equals(this.ingestTransformation, source.ingestTransformation) &&
        Objects.equals(this.integrationName, source.integrationName) &&
        Objects.equals(this.kafka, source.kafka) &&
        Objects.equals(this.kinesis, source.kinesis) &&
        Objects.equals(this.mongodb, source.mongodb) &&
        Objects.equals(this.resumeAt, source.resumeAt) &&
        Objects.equals(this.s3, source.s3) &&
        Objects.equals(this.snapshot, source.snapshot) &&
        Objects.equals(this.snowflake, source.snowflake) &&
        Objects.equals(this.status, source.status) &&
        Objects.equals(this.suspendedAt, source.suspendedAt) &&
        Objects.equals(this.system, source.system);
  }

  @Override
  public int hashCode() {
    return Objects.hash(azureBlobStorage, azureEventHubs, azureServiceBus, dynamodb, fileUpload, formatParams, gcs, id, ingestTransformation, integrationName, kafka, kinesis, mongodb, resumeAt, s3, snapshot, snowflake, status, suspendedAt, system);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Source {\n");
    
    sb.append("    azureBlobStorage: ").append(toIndentedString(azureBlobStorage)).append("\n");
    sb.append("    azureEventHubs: ").append(toIndentedString(azureEventHubs)).append("\n");
    sb.append("    azureServiceBus: ").append(toIndentedString(azureServiceBus)).append("\n");
    sb.append("    dynamodb: ").append(toIndentedString(dynamodb)).append("\n");
    sb.append("    fileUpload: ").append(toIndentedString(fileUpload)).append("\n");
    sb.append("    formatParams: ").append(toIndentedString(formatParams)).append("\n");
    sb.append("    gcs: ").append(toIndentedString(gcs)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ingestTransformation: ").append(toIndentedString(ingestTransformation)).append("\n");
    sb.append("    integrationName: ").append(toIndentedString(integrationName)).append("\n");
    sb.append("    kafka: ").append(toIndentedString(kafka)).append("\n");
    sb.append("    kinesis: ").append(toIndentedString(kinesis)).append("\n");
    sb.append("    mongodb: ").append(toIndentedString(mongodb)).append("\n");
    sb.append("    resumeAt: ").append(toIndentedString(resumeAt)).append("\n");
    sb.append("    s3: ").append(toIndentedString(s3)).append("\n");
    sb.append("    snapshot: ").append(toIndentedString(snapshot)).append("\n");
    sb.append("    snowflake: ").append(toIndentedString(snowflake)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    suspendedAt: ").append(toIndentedString(suspendedAt)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
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

