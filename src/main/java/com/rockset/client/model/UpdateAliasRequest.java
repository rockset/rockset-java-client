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
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UpdateAliasRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-31T12:04:03.466Z")
public class UpdateAliasRequest {
  @SerializedName("collections")
  private List<String> collections = new ArrayList<String>();

  @SerializedName("description")
  private String description = null;

  public UpdateAliasRequest collections(List<String> collections) {
    this.collections = collections;
    return this;
  }

  public UpdateAliasRequest addCollectionsItem(String collectionsItem) {
    this.collections.add(collectionsItem);
    return this;
  }

   /**
   * List of fully qualified collection names referenced by alias.
   * @return collections
  **/

@JsonProperty("collections")
@ApiModelProperty(example = "\"[\\\"commons.foo\\\", \\\"prod.demo\\\"]\"", required = true, value = "List of fully qualified collection names referenced by alias.")
  public List<String> getCollections() {
    return collections;
  }

  public void setCollections(List<String> collections) {
    this.collections = collections;
  }

  public UpdateAliasRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Optional description.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "version alias", value = "Optional description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAliasRequest updateAliasRequest = (UpdateAliasRequest) o;
    return Objects.equals(this.collections, updateAliasRequest.collections) &&
        Objects.equals(this.description, updateAliasRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collections, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAliasRequest {\n");
    
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

