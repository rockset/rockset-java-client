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
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ValidateQueryResponse */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-12-09T15:56:21.038-08:00")
public class ValidateQueryResponse {
  @SerializedName("name")
  private List<String> name = new ArrayList<String>();

  @SerializedName("collections")
  private List<String> collections = new ArrayList<String>();

  @SerializedName("parameters")
  private List<String> parameters = new ArrayList<String>();

  public ValidateQueryResponse name(List<String> name) {
    this.name = name;
    return this;
  }

  public ValidateQueryResponse addNameItem(String nameItem) {
    this.name.add(nameItem);
    return this;
  }

  /**
   * list of collection specified in query
   *
   * @return name
   */
  @JsonProperty("name")
  @ApiModelProperty(
      example = "\"[\\\"commons.foo\\\"]\"",
      required = true,
      value = "list of collection specified in query")
  public List<String> getName() {
    return name;
  }

  public void setName(List<String> name) {
    this.name = name;
  }

  public ValidateQueryResponse collections(List<String> collections) {
    this.collections = collections;
    return this;
  }

  public ValidateQueryResponse addCollectionsItem(String collectionsItem) {
    this.collections.add(collectionsItem);
    return this;
  }

  /**
   * list of collection specified in query
   *
   * @return collections
   */
  @JsonProperty("collections")
  @ApiModelProperty(
      example = "\"[\\\"commons.foo\\\"]\"",
      required = true,
      value = "list of collection specified in query")
  public List<String> getCollections() {
    return collections;
  }

  public void setCollections(List<String> collections) {
    this.collections = collections;
  }

  public ValidateQueryResponse parameters(List<String> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ValidateQueryResponse addParametersItem(String parametersItem) {
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * list of parameters specified in query
   *
   * @return parameters
   */
  @JsonProperty("parameters")
  @ApiModelProperty(
      example = "\"[\\\"foo\\\"]\"",
      required = true,
      value = "list of parameters specified in query")
  public List<String> getParameters() {
    return parameters;
  }

  public void setParameters(List<String> parameters) {
    this.parameters = parameters;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateQueryResponse validateQueryResponse = (ValidateQueryResponse) o;
    return Objects.equals(this.name, validateQueryResponse.name)
        && Objects.equals(this.collections, validateQueryResponse.collections)
        && Objects.equals(this.parameters, validateQueryResponse.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, collections, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateQueryResponse {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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
