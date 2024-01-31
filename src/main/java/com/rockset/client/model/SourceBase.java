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
import com.rockset.client.model.SourceAzBlobStorageBase;
import com.rockset.client.model.SourceDynamoDbBase;
import com.rockset.client.model.SourceGcsBase;
import com.rockset.client.model.SourceS3Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SourceBase
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-31T12:04:03.466Z")
public class SourceBase {
  @SerializedName("azure_blob_storage")
  private SourceAzBlobStorageBase azureBlobStorage = null;

  @SerializedName("dynamodb")
  private SourceDynamoDbBase dynamodb = null;

  @SerializedName("gcs")
  private SourceGcsBase gcs = null;

  @SerializedName("s3")
  private SourceS3Base s3 = null;

  public SourceBase azureBlobStorage(SourceAzBlobStorageBase azureBlobStorage) {
    this.azureBlobStorage = azureBlobStorage;
    return this;
  }

   /**
   * Configuration for ingestion from Azure Blob Storage.
   * @return azureBlobStorage
  **/

@JsonProperty("azure_blob_storage")
@ApiModelProperty(value = "Configuration for ingestion from Azure Blob Storage.")
  public SourceAzBlobStorageBase getAzureBlobStorage() {
    return azureBlobStorage;
  }

  public void setAzureBlobStorage(SourceAzBlobStorageBase azureBlobStorage) {
    this.azureBlobStorage = azureBlobStorage;
  }

  public SourceBase dynamodb(SourceDynamoDbBase dynamodb) {
    this.dynamodb = dynamodb;
    return this;
  }

   /**
   * Configuration for ingestion from a DynamoDb table.
   * @return dynamodb
  **/

@JsonProperty("dynamodb")
@ApiModelProperty(value = "Configuration for ingestion from a DynamoDb table.")
  public SourceDynamoDbBase getDynamodb() {
    return dynamodb;
  }

  public void setDynamodb(SourceDynamoDbBase dynamodb) {
    this.dynamodb = dynamodb;
  }

  public SourceBase gcs(SourceGcsBase gcs) {
    this.gcs = gcs;
    return this;
  }

   /**
   * Configuration for ingestion from GCS.
   * @return gcs
  **/

@JsonProperty("gcs")
@ApiModelProperty(value = "Configuration for ingestion from GCS.")
  public SourceGcsBase getGcs() {
    return gcs;
  }

  public void setGcs(SourceGcsBase gcs) {
    this.gcs = gcs;
  }

  public SourceBase s3(SourceS3Base s3) {
    this.s3 = s3;
    return this;
  }

   /**
   * Configuration for ingestion from S3.
   * @return s3
  **/

@JsonProperty("s3")
@ApiModelProperty(value = "Configuration for ingestion from S3.")
  public SourceS3Base getS3() {
    return s3;
  }

  public void setS3(SourceS3Base s3) {
    this.s3 = s3;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceBase sourceBase = (SourceBase) o;
    return Objects.equals(this.azureBlobStorage, sourceBase.azureBlobStorage) &&
        Objects.equals(this.dynamodb, sourceBase.dynamodb) &&
        Objects.equals(this.gcs, sourceBase.gcs) &&
        Objects.equals(this.s3, sourceBase.s3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(azureBlobStorage, dynamodb, gcs, s3);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceBase {\n");
    
    sb.append("    azureBlobStorage: ").append(toIndentedString(azureBlobStorage)).append("\n");
    sb.append("    dynamodb: ").append(toIndentedString(dynamodb)).append("\n");
    sb.append("    gcs: ").append(toIndentedString(gcs)).append("\n");
    sb.append("    s3: ").append(toIndentedString(s3)).append("\n");
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

