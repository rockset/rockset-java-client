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
import com.rockset.client.model.SourceS3Settings;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SourceS3
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-31T12:04:03.466Z")
public class SourceS3 {
  @SerializedName("bucket")
  private String bucket = null;

  @SerializedName("object_bytes_downloaded")
  private Long objectBytesDownloaded = null;

  @SerializedName("object_bytes_total")
  private Long objectBytesTotal = null;

  @SerializedName("object_count_downloaded")
  private Long objectCountDownloaded = null;

  @SerializedName("object_count_total")
  private Long objectCountTotal = null;

  @SerializedName("pattern")
  private String pattern = null;

  @SerializedName("prefix")
  private String prefix = null;

  @SerializedName("prefixes")
  private List<String> prefixes = null;

  @SerializedName("region")
  private String region = null;

  @SerializedName("settings")
  private SourceS3Settings settings = null;

  public SourceS3 bucket(String bucket) {
    this.bucket = bucket;
    return this;
  }

   /**
   * Address of S3 bucket containing data.
   * @return bucket
  **/

@JsonProperty("bucket")
@ApiModelProperty(example = "s3://customer-account-info", required = true, value = "Address of S3 bucket containing data.")
  public String getBucket() {
    return bucket;
  }

  public void setBucket(String bucket) {
    this.bucket = bucket;
  }

   /**
   * Get objectBytesDownloaded
   * @return objectBytesDownloaded
  **/

@JsonProperty("object_bytes_downloaded")
@ApiModelProperty(value = "")
  public Long getObjectBytesDownloaded() {
    return objectBytesDownloaded;
  }

   /**
   * Get objectBytesTotal
   * @return objectBytesTotal
  **/

@JsonProperty("object_bytes_total")
@ApiModelProperty(value = "")
  public Long getObjectBytesTotal() {
    return objectBytesTotal;
  }

   /**
   * Get objectCountDownloaded
   * @return objectCountDownloaded
  **/

@JsonProperty("object_count_downloaded")
@ApiModelProperty(value = "")
  public Long getObjectCountDownloaded() {
    return objectCountDownloaded;
  }

   /**
   * Get objectCountTotal
   * @return objectCountTotal
  **/

@JsonProperty("object_count_total")
@ApiModelProperty(value = "")
  public Long getObjectCountTotal() {
    return objectCountTotal;
  }

  public SourceS3 pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

   /**
   * Glob-style pattern that selects keys to ingest. Only either prefix or pattern can be specified.
   * @return pattern
  **/

@JsonProperty("pattern")
@ApiModelProperty(example = "prefix/to/_**_/keys/_*.format", value = "Glob-style pattern that selects keys to ingest. Only either prefix or pattern can be specified.")
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public SourceS3 prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

   /**
   * Prefix that selects keys to ingest.
   * @return prefix
  **/

@JsonProperty("prefix")
@ApiModelProperty(example = "prefix/to/keys", value = "Prefix that selects keys to ingest.")
  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

   /**
   * Deprecated in favor of &#x60;prefix&#x60;. List of prefixes to paths from which data should be ingested.
   * @return prefixes
  **/

@JsonProperty("prefixes")
@ApiModelProperty(example = "\"[\\\"/transactions\\\", \\\"/stores\\\"]\"", value = "Deprecated in favor of `prefix`. List of prefixes to paths from which data should be ingested.")
  public List<String> getPrefixes() {
    return prefixes;
  }

  public SourceS3 region(String region) {
    this.region = region;
    return this;
  }

   /**
   * AWS region containing source bucket.
   * @return region
  **/

@JsonProperty("region")
@ApiModelProperty(example = "us-west-2", value = "AWS region containing source bucket.")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public SourceS3 settings(SourceS3Settings settings) {
    this.settings = settings;
    return this;
  }

   /**
   * custom settings for Amazon S3 source
   * @return settings
  **/

@JsonProperty("settings")
@ApiModelProperty(value = "custom settings for Amazon S3 source")
  public SourceS3Settings getSettings() {
    return settings;
  }

  public void setSettings(SourceS3Settings settings) {
    this.settings = settings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceS3 sourceS3 = (SourceS3) o;
    return Objects.equals(this.bucket, sourceS3.bucket) &&
        Objects.equals(this.objectBytesDownloaded, sourceS3.objectBytesDownloaded) &&
        Objects.equals(this.objectBytesTotal, sourceS3.objectBytesTotal) &&
        Objects.equals(this.objectCountDownloaded, sourceS3.objectCountDownloaded) &&
        Objects.equals(this.objectCountTotal, sourceS3.objectCountTotal) &&
        Objects.equals(this.pattern, sourceS3.pattern) &&
        Objects.equals(this.prefix, sourceS3.prefix) &&
        Objects.equals(this.prefixes, sourceS3.prefixes) &&
        Objects.equals(this.region, sourceS3.region) &&
        Objects.equals(this.settings, sourceS3.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket, objectBytesDownloaded, objectBytesTotal, objectCountDownloaded, objectCountTotal, pattern, prefix, prefixes, region, settings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceS3 {\n");
    
    sb.append("    bucket: ").append(toIndentedString(bucket)).append("\n");
    sb.append("    objectBytesDownloaded: ").append(toIndentedString(objectBytesDownloaded)).append("\n");
    sb.append("    objectBytesTotal: ").append(toIndentedString(objectBytesTotal)).append("\n");
    sb.append("    objectCountDownloaded: ").append(toIndentedString(objectCountDownloaded)).append("\n");
    sb.append("    objectCountTotal: ").append(toIndentedString(objectCountTotal)).append("\n");
    sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    prefixes: ").append(toIndentedString(prefixes)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
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

