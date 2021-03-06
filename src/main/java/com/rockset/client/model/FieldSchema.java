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
import com.rockset.client.model.FieldOptions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * FieldSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-02-26T17:46:04.637Z")
public class FieldSchema {
  @SerializedName("field_name")
  private String fieldName = null;

  @SerializedName("field_options")
  private FieldOptions fieldOptions = null;

  public FieldSchema fieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }

   /**
   * The name of a field, parsed as a SQL qualified name
   * @return fieldName
  **/

@JsonProperty("field_name")
@ApiModelProperty(example = "address.city.zipcode", value = "The name of a field, parsed as a SQL qualified name")
  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public FieldSchema fieldOptions(FieldOptions fieldOptions) {
    this.fieldOptions = fieldOptions;
    return this;
  }

   /**
   * The indexing options for a field
   * @return fieldOptions
  **/

@JsonProperty("field_options")
@ApiModelProperty(value = "The indexing options for a field")
  public FieldOptions getFieldOptions() {
    return fieldOptions;
  }

  public void setFieldOptions(FieldOptions fieldOptions) {
    this.fieldOptions = fieldOptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldSchema fieldSchema = (FieldSchema) o;
    return Objects.equals(this.fieldName, fieldSchema.fieldName) &&
        Objects.equals(this.fieldOptions, fieldSchema.fieldOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, fieldOptions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldSchema {\n");
    
    sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
    sb.append("    fieldOptions: ").append(toIndentedString(fieldOptions)).append("\n");
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

