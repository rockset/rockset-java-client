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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UpdateCollectionRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:21:47.964-07:00")
public class UpdateCollectionRequest {
  @SerializedName("description")
  private String description = null;

  @SerializedName("field_mapping_query")
  private FieldMappingQuery fieldMappingQuery = null;

  public UpdateCollectionRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Updated text describing the collection.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "transactions from stores worldwide", value = "Updated text describing the collection.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateCollectionRequest fieldMappingQuery(FieldMappingQuery fieldMappingQuery) {
    this.fieldMappingQuery = fieldMappingQuery;
    return this;
  }

   /**
   * Updated ingest transformation query. Note that updating the transformation will lead to a brief interruption in ingestion.
   * @return fieldMappingQuery
  **/

@JsonProperty("field_mapping_query")
@ApiModelProperty(value = "Updated ingest transformation query. Note that updating the transformation will lead to a brief interruption in ingestion.")
  public FieldMappingQuery getFieldMappingQuery() {
    return fieldMappingQuery;
  }

  public void setFieldMappingQuery(FieldMappingQuery fieldMappingQuery) {
    this.fieldMappingQuery = fieldMappingQuery;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCollectionRequest updateCollectionRequest = (UpdateCollectionRequest) o;
    return Objects.equals(this.description, updateCollectionRequest.description) &&
        Objects.equals(this.fieldMappingQuery, updateCollectionRequest.fieldMappingQuery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, fieldMappingQuery);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateCollectionRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    fieldMappingQuery: ").append(toIndentedString(fieldMappingQuery)).append("\n");
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

