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
 * SchemaRegistryConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-11-22T11:16:43.952-05:00")
public class SchemaRegistryConfig {
  @SerializedName("url")
  private String url = null;

  @SerializedName("key")
  private String key = null;

  @SerializedName("secret")
  private String secret = null;

  public SchemaRegistryConfig url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Schema registry URL.
   * @return url
  **/

@JsonProperty("url")
@ApiModelProperty(value = "Schema registry URL.")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SchemaRegistryConfig key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The secure API key for schema registry.
   * @return key
  **/

@JsonProperty("key")
@ApiModelProperty(value = "The secure API key for schema registry.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public SchemaRegistryConfig secret(String secret) {
    this.secret = secret;
    return this;
  }

   /**
   * The secure API password registry.
   * @return secret
  **/

@JsonProperty("secret")
@ApiModelProperty(value = "The secure API password registry.")
  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchemaRegistryConfig schemaRegistryConfig = (SchemaRegistryConfig) o;
    return Objects.equals(this.url, schemaRegistryConfig.url) &&
        Objects.equals(this.key, schemaRegistryConfig.key) &&
        Objects.equals(this.secret, schemaRegistryConfig.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, key, secret);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchemaRegistryConfig {\n");
    
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
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
