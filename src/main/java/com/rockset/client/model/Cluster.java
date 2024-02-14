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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cluster
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-02-14T12:03:45.664Z")
public class Cluster {
  @SerializedName("apiserver_url")
  private String apiserverUrl = null;

  @SerializedName("aws_region")
  private String awsRegion = null;

  /**
   * Cluster type.
   */
  @JsonAdapter(ClusterTypeEnum.Adapter.class)
  public enum ClusterTypeEnum {
    PUBLIC("PUBLIC");

    private String value;

    ClusterTypeEnum(String value) {
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
    public static ClusterTypeEnum fromValue(String text) {
      for (ClusterTypeEnum b : ClusterTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ClusterTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ClusterTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ClusterTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ClusterTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("cluster_type")
  private ClusterTypeEnum clusterType = null;

  @SerializedName("domain")
  private String domain = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("top_level_domain")
  private String topLevelDomain = null;

  public Cluster apiserverUrl(String apiserverUrl) {
    this.apiserverUrl = apiserverUrl;
    return this;
  }

   /**
   * Api server url for cluster.
   * @return apiserverUrl
  **/

@JsonProperty("apiserver_url")
@ApiModelProperty(example = "api.rockset.us-west-2.rockset.com", value = "Api server url for cluster.")
  public String getApiserverUrl() {
    return apiserverUrl;
  }

  public void setApiserverUrl(String apiserverUrl) {
    this.apiserverUrl = apiserverUrl;
  }

  public Cluster awsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return this;
  }

   /**
   * Aws region.
   * @return awsRegion
  **/

@JsonProperty("aws_region")
@ApiModelProperty(example = "us-west-2", value = "Aws region.")
  public String getAwsRegion() {
    return awsRegion;
  }

  public void setAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
  }

  public Cluster clusterType(ClusterTypeEnum clusterType) {
    this.clusterType = clusterType;
    return this;
  }

   /**
   * Cluster type.
   * @return clusterType
  **/

@JsonProperty("cluster_type")
@ApiModelProperty(example = "PRIVATE", value = "Cluster type.")
  public ClusterTypeEnum getClusterType() {
    return clusterType;
  }

  public void setClusterType(ClusterTypeEnum clusterType) {
    this.clusterType = clusterType;
  }

  public Cluster domain(String domain) {
    this.domain = domain;
    return this;
  }

   /**
   * Domain of org using cluster.
   * @return domain
  **/

@JsonProperty("domain")
@ApiModelProperty(example = "rockset", value = "Domain of org using cluster.")
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public Cluster id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the cluster.
   * @return id
  **/

@JsonProperty("id")
@ApiModelProperty(example = "asdf98-as9df8adf-adsf9asfd", value = "Unique identifier for the cluster.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Cluster topLevelDomain(String topLevelDomain) {
    this.topLevelDomain = topLevelDomain;
    return this;
  }

   /**
   * Top level domain of org using cluster.
   * @return topLevelDomain
  **/

@JsonProperty("top_level_domain")
@ApiModelProperty(example = ".com", value = "Top level domain of org using cluster.")
  public String getTopLevelDomain() {
    return topLevelDomain;
  }

  public void setTopLevelDomain(String topLevelDomain) {
    this.topLevelDomain = topLevelDomain;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cluster cluster = (Cluster) o;
    return Objects.equals(this.apiserverUrl, cluster.apiserverUrl) &&
        Objects.equals(this.awsRegion, cluster.awsRegion) &&
        Objects.equals(this.clusterType, cluster.clusterType) &&
        Objects.equals(this.domain, cluster.domain) &&
        Objects.equals(this.id, cluster.id) &&
        Objects.equals(this.topLevelDomain, cluster.topLevelDomain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiserverUrl, awsRegion, clusterType, domain, id, topLevelDomain);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cluster {\n");
    
    sb.append("    apiserverUrl: ").append(toIndentedString(apiserverUrl)).append("\n");
    sb.append("    awsRegion: ").append(toIndentedString(awsRegion)).append("\n");
    sb.append("    clusterType: ").append(toIndentedString(clusterType)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    topLevelDomain: ").append(toIndentedString(topLevelDomain)).append("\n");
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

