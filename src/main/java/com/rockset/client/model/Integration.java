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
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Integrations that can be associated with data sources to create collections. Only one type of
 * integration may be specified.
 */
@ApiModel(
    description =
        "Integrations that can be associated with data sources to create collections. Only one type of integration may be specified.")
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-11-12T22:54:16.921Z")
public class Integration {
  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("collections")
  private List<Collection> collections = null;

  @SerializedName("created_by")
  private String createdBy = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("s3")
  private S3Integration s3 = null;

  @SerializedName("kinesis")
  private KinesisIntegration kinesis = null;

  @SerializedName("dynamodb")
  private DynamodbIntegration dynamodb = null;

  @SerializedName("gcs")
  private GcsIntegration gcs = null;

  @SerializedName("segment")
  private SegmentIntegration segment = null;

  @SerializedName("kafka")
  private KafkaIntegration kafka = null;

  @SerializedName("mongodb")
  private MongoDbIntegration mongodb = null;

  public Integration name(String name) {
    this.name = name;
    return this;
  }

  /**
   * descriptive label and unique identifier
   *
   * @return name
   */
  @JsonProperty("name")
  @ApiModelProperty(
      example = "event-logs",
      required = true,
      value = "descriptive label and unique identifier")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integration description(String description) {
    this.description = description;
    return this;
  }

  /**
   * longer explanation for the integration
   *
   * @return description
   */
  @JsonProperty("description")
  @ApiModelProperty(
      example = "AWS account with event data for the data science team.",
      value = "longer explanation for the integration")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integration collections(List<Collection> collections) {
    this.collections = collections;
    return this;
  }

  public Integration addCollectionsItem(Collection collectionsItem) {
    if (this.collections == null) {
      this.collections = new ArrayList<Collection>();
    }
    this.collections.add(collectionsItem);
    return this;
  }

  /**
   * list of collections that use the integration
   *
   * @return collections
   */
  @JsonProperty("collections")
  @ApiModelProperty(value = "list of collections that use the integration")
  public List<Collection> getCollections() {
    return collections;
  }

  public void setCollections(List<Collection> collections) {
    this.collections = collections;
  }

  public Integration createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * email of user who created the integration
   *
   * @return createdBy
   */
  @JsonProperty("created_by")
  @ApiModelProperty(
      example = "hello@rockset.com",
      required = true,
      value = "email of user who created the integration")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Integration createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * ISO-8601 date
   *
   * @return createdAt
   */
  @JsonProperty("created_at")
  @ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Integration s3(S3Integration s3) {
    this.s3 = s3;
    return this;
  }

  /**
   * Amazon S3 details, must have one of aws_access_key or aws_role
   *
   * @return s3
   */
  @JsonProperty("s3")
  @ApiModelProperty(value = "Amazon S3 details, must have one of aws_access_key or aws_role")
  public S3Integration getS3() {
    return s3;
  }

  public void setS3(S3Integration s3) {
    this.s3 = s3;
  }

  public Integration kinesis(KinesisIntegration kinesis) {
    this.kinesis = kinesis;
    return this;
  }

  /**
   * Amazon Kinesis details, must have one of aws_access_key or aws_role
   *
   * @return kinesis
   */
  @JsonProperty("kinesis")
  @ApiModelProperty(value = "Amazon Kinesis details, must have one of aws_access_key or aws_role")
  public KinesisIntegration getKinesis() {
    return kinesis;
  }

  public void setKinesis(KinesisIntegration kinesis) {
    this.kinesis = kinesis;
  }

  public Integration dynamodb(DynamodbIntegration dynamodb) {
    this.dynamodb = dynamodb;
    return this;
  }

  /**
   * Amazon DynamoDB details, must have one of aws_access_key or aws_role
   *
   * @return dynamodb
   */
  @JsonProperty("dynamodb")
  @ApiModelProperty(value = "Amazon DynamoDB details, must have one of aws_access_key or aws_role")
  public DynamodbIntegration getDynamodb() {
    return dynamodb;
  }

  public void setDynamodb(DynamodbIntegration dynamodb) {
    this.dynamodb = dynamodb;
  }

  public Integration gcs(GcsIntegration gcs) {
    this.gcs = gcs;
    return this;
  }

  /**
   * GCS details
   *
   * @return gcs
   */
  @JsonProperty("gcs")
  @ApiModelProperty(value = "GCS details")
  public GcsIntegration getGcs() {
    return gcs;
  }

  public void setGcs(GcsIntegration gcs) {
    this.gcs = gcs;
  }

  public Integration segment(SegmentIntegration segment) {
    this.segment = segment;
    return this;
  }

  /**
   * Segment details
   *
   * @return segment
   */
  @JsonProperty("segment")
  @ApiModelProperty(value = "Segment details")
  public SegmentIntegration getSegment() {
    return segment;
  }

  public void setSegment(SegmentIntegration segment) {
    this.segment = segment;
  }

  public Integration kafka(KafkaIntegration kafka) {
    this.kafka = kafka;
    return this;
  }

  /**
   * Kafka details
   *
   * @return kafka
   */
  @JsonProperty("kafka")
  @ApiModelProperty(value = "Kafka details")
  public KafkaIntegration getKafka() {
    return kafka;
  }

  public void setKafka(KafkaIntegration kafka) {
    this.kafka = kafka;
  }

  public Integration mongodb(MongoDbIntegration mongodb) {
    this.mongodb = mongodb;
    return this;
  }

  /**
   * MongoDb details
   *
   * @return mongodb
   */
  @JsonProperty("mongodb")
  @ApiModelProperty(value = "MongoDb details")
  public MongoDbIntegration getMongodb() {
    return mongodb;
  }

  public void setMongodb(MongoDbIntegration mongodb) {
    this.mongodb = mongodb;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Integration integration = (Integration) o;
    return Objects.equals(this.name, integration.name)
        && Objects.equals(this.description, integration.description)
        && Objects.equals(this.collections, integration.collections)
        && Objects.equals(this.createdBy, integration.createdBy)
        && Objects.equals(this.createdAt, integration.createdAt)
        && Objects.equals(this.s3, integration.s3)
        && Objects.equals(this.kinesis, integration.kinesis)
        && Objects.equals(this.dynamodb, integration.dynamodb)
        && Objects.equals(this.gcs, integration.gcs)
        && Objects.equals(this.segment, integration.segment)
        && Objects.equals(this.kafka, integration.kafka)
        && Objects.equals(this.mongodb, integration.mongodb);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name,
        description,
        collections,
        createdBy,
        createdAt,
        s3,
        kinesis,
        dynamodb,
        gcs,
        segment,
        kafka,
        mongodb);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Integration {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    s3: ").append(toIndentedString(s3)).append("\n");
    sb.append("    kinesis: ").append(toIndentedString(kinesis)).append("\n");
    sb.append("    dynamodb: ").append(toIndentedString(dynamodb)).append("\n");
    sb.append("    gcs: ").append(toIndentedString(gcs)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    kafka: ").append(toIndentedString(kafka)).append("\n");
    sb.append("    mongodb: ").append(toIndentedString(mongodb)).append("\n");
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
