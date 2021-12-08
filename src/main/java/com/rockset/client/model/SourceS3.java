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

/** SourceS3 */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-12-09T15:56:21.038-08:00")
public class SourceS3 {
  @SerializedName("access_key")
  private String accessKey = null;

  @SerializedName("secret_access")
  private String secretAccess = null;

  @SerializedName("prefix")
  private String prefix = null;

  @SerializedName("pattern")
  private String pattern = null;

  @SerializedName("region")
  private String region = null;

  @SerializedName("bucket")
  private String bucket = null;

  @SerializedName("prefixes")
  private List<String> prefixes = new ArrayList<String>();

  /** do not use */
  @JsonAdapter(FormatEnum.Adapter.class)
  public enum FormatEnum {
    JSON("JSON");

    private String value;

    FormatEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FormatEnum fromValue(String text) {
      for (FormatEnum b : FormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<FormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FormatEnum enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FormatEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return FormatEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("format")
  private FormatEnum format = null;

  @SerializedName("mappings")
  private List<FieldMask> mappings = null;

  @SerializedName("object_count_downloaded")
  private Long objectCountDownloaded = null;

  @SerializedName("object_count_total")
  private Long objectCountTotal = null;

  @SerializedName("object_bytes_total")
  private Long objectBytesTotal = null;

  /**
   * AWS credential with ListObjects and GetObject access
   *
   * @return accessKey
   */
  @JsonProperty("access_key")
  @ApiModelProperty(
      example = "AKIAIOSFODNN7EXAMPLE",
      value = "AWS credential with ListObjects and GetObject access")
  public String getAccessKey() {
    return accessKey;
  }

  /**
   * AWS credential with ListObjects and GetObject access
   *
   * @return secretAccess
   */
  @JsonProperty("secret_access")
  @ApiModelProperty(
      example = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY",
      value = "AWS credential with ListObjects and GetObject access")
  public String getSecretAccess() {
    return secretAccess;
  }

  public SourceS3 prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

  /**
   * Prefix that selects keys to ingest.
   *
   * @return prefix
   */
  @JsonProperty("prefix")
  @ApiModelProperty(example = "prefix/to/keys", value = "Prefix that selects keys to ingest.")
  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public SourceS3 pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  /**
   * Pattern that selects keys to ingest.
   *
   * @return pattern
   */
  @JsonProperty("pattern")
  @ApiModelProperty(
      example = "prefix/to/_**_/keys/_*.format",
      value = "Pattern that selects keys to ingest.")
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public SourceS3 region(String region) {
    this.region = region;
    return this;
  }

  /**
   * AWS region containing source bucket
   *
   * @return region
   */
  @JsonProperty("region")
  @ApiModelProperty(example = "us-west-2", value = "AWS region containing source bucket")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public SourceS3 bucket(String bucket) {
    this.bucket = bucket;
    return this;
  }

  /**
   * address of S3 bucket containing data
   *
   * @return bucket
   */
  @JsonProperty("bucket")
  @ApiModelProperty(
      example = "s3://customer-account-info",
      required = true,
      value = "address of S3 bucket containing data")
  public String getBucket() {
    return bucket;
  }

  public void setBucket(String bucket) {
    this.bucket = bucket;
  }

  /**
   * list of prefixes to paths from which data should be ingested
   *
   * @return prefixes
   */
  @JsonProperty("prefixes")
  @ApiModelProperty(
      example = "\"[\\\"/transactions\\\", \\\"/stores\\\"]\"",
      required = true,
      value = "list of prefixes to paths from which data should be ingested")
  public List<String> getPrefixes() {
    return prefixes;
  }

  public SourceS3 format(FormatEnum format) {
    this.format = format;
    return this;
  }

  /**
   * do not use
   *
   * @return format
   */
  @JsonProperty("format")
  @ApiModelProperty(example = "none", value = "do not use")
  public FormatEnum getFormat() {
    return format;
  }

  public void setFormat(FormatEnum format) {
    this.format = format;
  }

  public SourceS3 mappings(List<FieldMask> mappings) {
    this.mappings = mappings;
    return this;
  }

  public SourceS3 addMappingsItem(FieldMask mappingsItem) {
    if (this.mappings == null) {
      this.mappings = new ArrayList<FieldMask>();
    }
    this.mappings.add(mappingsItem);
    return this;
  }

  /**
   * custom transformation on data field
   *
   * @return mappings
   */
  @JsonProperty("mappings")
  @ApiModelProperty(value = "custom transformation on data field")
  public List<FieldMask> getMappings() {
    return mappings;
  }

  public void setMappings(List<FieldMask> mappings) {
    this.mappings = mappings;
  }

  public SourceS3 objectCountDownloaded(Long objectCountDownloaded) {
    this.objectCountDownloaded = objectCountDownloaded;
    return this;
  }

  /**
   * Get objectCountDownloaded
   *
   * @return objectCountDownloaded
   */
  @JsonProperty("object_count_downloaded")
  @ApiModelProperty(value = "")
  public Long getObjectCountDownloaded() {
    return objectCountDownloaded;
  }

  public void setObjectCountDownloaded(Long objectCountDownloaded) {
    this.objectCountDownloaded = objectCountDownloaded;
  }

  public SourceS3 objectCountTotal(Long objectCountTotal) {
    this.objectCountTotal = objectCountTotal;
    return this;
  }

  /**
   * Get objectCountTotal
   *
   * @return objectCountTotal
   */
  @JsonProperty("object_count_total")
  @ApiModelProperty(value = "")
  public Long getObjectCountTotal() {
    return objectCountTotal;
  }

  public void setObjectCountTotal(Long objectCountTotal) {
    this.objectCountTotal = objectCountTotal;
  }

  public SourceS3 objectBytesTotal(Long objectBytesTotal) {
    this.objectBytesTotal = objectBytesTotal;
    return this;
  }

  /**
   * Get objectBytesTotal
   *
   * @return objectBytesTotal
   */
  @JsonProperty("object_bytes_total")
  @ApiModelProperty(value = "")
  public Long getObjectBytesTotal() {
    return objectBytesTotal;
  }

  public void setObjectBytesTotal(Long objectBytesTotal) {
    this.objectBytesTotal = objectBytesTotal;
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
    return Objects.equals(this.accessKey, sourceS3.accessKey)
        && Objects.equals(this.secretAccess, sourceS3.secretAccess)
        && Objects.equals(this.prefix, sourceS3.prefix)
        && Objects.equals(this.pattern, sourceS3.pattern)
        && Objects.equals(this.region, sourceS3.region)
        && Objects.equals(this.bucket, sourceS3.bucket)
        && Objects.equals(this.prefixes, sourceS3.prefixes)
        && Objects.equals(this.format, sourceS3.format)
        && Objects.equals(this.mappings, sourceS3.mappings)
        && Objects.equals(this.objectCountDownloaded, sourceS3.objectCountDownloaded)
        && Objects.equals(this.objectCountTotal, sourceS3.objectCountTotal)
        && Objects.equals(this.objectBytesTotal, sourceS3.objectBytesTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accessKey,
        secretAccess,
        prefix,
        pattern,
        region,
        bucket,
        prefixes,
        format,
        mappings,
        objectCountDownloaded,
        objectCountTotal,
        objectBytesTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceS3 {\n");

    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    secretAccess: ").append(toIndentedString(secretAccess)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    bucket: ").append(toIndentedString(bucket)).append("\n");
    sb.append("    prefixes: ").append(toIndentedString(prefixes)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    mappings: ").append(toIndentedString(mappings)).append("\n");
    sb.append("    objectCountDownloaded: ")
        .append(toIndentedString(objectCountDownloaded))
        .append("\n");
    sb.append("    objectCountTotal: ").append(toIndentedString(objectCountTotal)).append("\n");
    sb.append("    objectBytesTotal: ").append(toIndentedString(objectBytesTotal)).append("\n");
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
