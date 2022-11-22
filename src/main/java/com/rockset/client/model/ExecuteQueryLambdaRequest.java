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
import com.rockset.client.model.AsyncQueryOptions;
import com.rockset.client.model.QueryParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExecuteQueryLambdaRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-11-22T11:16:43.952-05:00")
public class ExecuteQueryLambdaRequest {
  @SerializedName("parameters")
  private List<QueryParameter> parameters = null;

  @SerializedName("default_row_limit")
  private Integer defaultRowLimit = null;

  @SerializedName("generate_warnings")
  private Boolean generateWarnings = null;

  @SerializedName("paginate")
  private Boolean paginate = null;

  @SerializedName("initial_paginate_response_doc_count")
  private Integer initialPaginateResponseDocCount = null;

  @SerializedName("async_options")
  private AsyncQueryOptions asyncOptions = null;

  @SerializedName("virtual_instance_id")
  private String virtualInstanceId = null;

  public ExecuteQueryLambdaRequest parameters(List<QueryParameter> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ExecuteQueryLambdaRequest addParametersItem(QueryParameter parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<QueryParameter>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

   /**
   * List of named parameters.
   * @return parameters
  **/

@JsonProperty("parameters")
@ApiModelProperty(value = "List of named parameters.")
  public List<QueryParameter> getParameters() {
    return parameters;
  }

  public void setParameters(List<QueryParameter> parameters) {
    this.parameters = parameters;
  }

  public ExecuteQueryLambdaRequest defaultRowLimit(Integer defaultRowLimit) {
    this.defaultRowLimit = defaultRowLimit;
    return this;
  }

   /**
   * Row limit to use if no limit specified in the SQL query text.
   * @return defaultRowLimit
  **/

@JsonProperty("default_row_limit")
@ApiModelProperty(value = "Row limit to use if no limit specified in the SQL query text.")
  public Integer getDefaultRowLimit() {
    return defaultRowLimit;
  }

  public void setDefaultRowLimit(Integer defaultRowLimit) {
    this.defaultRowLimit = defaultRowLimit;
  }

  public ExecuteQueryLambdaRequest generateWarnings(Boolean generateWarnings) {
    this.generateWarnings = generateWarnings;
    return this;
  }

   /**
   * Whether to generate warnings.
   * @return generateWarnings
  **/

@JsonProperty("generate_warnings")
@ApiModelProperty(value = "Whether to generate warnings.")
  public Boolean isGenerateWarnings() {
    return generateWarnings;
  }

  public void setGenerateWarnings(Boolean generateWarnings) {
    this.generateWarnings = generateWarnings;
  }

  public ExecuteQueryLambdaRequest paginate(Boolean paginate) {
    this.paginate = paginate;
    return this;
  }

   /**
   * Flag to paginate and store the results of this query for later / sequential retrieval.
   * @return paginate
  **/

@JsonProperty("paginate")
@ApiModelProperty(value = "Flag to paginate and store the results of this query for later / sequential retrieval.")
  public Boolean isPaginate() {
    return paginate;
  }

  public void setPaginate(Boolean paginate) {
    this.paginate = paginate;
  }

  public ExecuteQueryLambdaRequest initialPaginateResponseDocCount(Integer initialPaginateResponseDocCount) {
    this.initialPaginateResponseDocCount = initialPaginateResponseDocCount;
    return this;
  }

   /**
   * Number of documents to return in addition to paginating for this query call. Only relevant if &#x60;paginate&#x60; flag is also set.
   * @return initialPaginateResponseDocCount
  **/

@JsonProperty("initial_paginate_response_doc_count")
@ApiModelProperty(value = "Number of documents to return in addition to paginating for this query call. Only relevant if `paginate` flag is also set.")
  public Integer getInitialPaginateResponseDocCount() {
    return initialPaginateResponseDocCount;
  }

  public void setInitialPaginateResponseDocCount(Integer initialPaginateResponseDocCount) {
    this.initialPaginateResponseDocCount = initialPaginateResponseDocCount;
  }

  public ExecuteQueryLambdaRequest asyncOptions(AsyncQueryOptions asyncOptions) {
    this.asyncOptions = asyncOptions;
    return this;
  }

   /**
   * Options for configuring Asynchronous Query Mode (beta).
   * @return asyncOptions
  **/

@JsonProperty("async_options")
@ApiModelProperty(value = "Options for configuring Asynchronous Query Mode (beta).")
  public AsyncQueryOptions getAsyncOptions() {
    return asyncOptions;
  }

  public void setAsyncOptions(AsyncQueryOptions asyncOptions) {
    this.asyncOptions = asyncOptions;
  }

  public ExecuteQueryLambdaRequest virtualInstanceId(String virtualInstanceId) {
    this.virtualInstanceId = virtualInstanceId;
    return this;
  }

   /**
   * Virtual instance on which to run the query.
   * @return virtualInstanceId
  **/

@JsonProperty("virtual_instance_id")
@ApiModelProperty(value = "Virtual instance on which to run the query.")
  public String getVirtualInstanceId() {
    return virtualInstanceId;
  }

  public void setVirtualInstanceId(String virtualInstanceId) {
    this.virtualInstanceId = virtualInstanceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecuteQueryLambdaRequest executeQueryLambdaRequest = (ExecuteQueryLambdaRequest) o;
    return Objects.equals(this.parameters, executeQueryLambdaRequest.parameters) &&
        Objects.equals(this.defaultRowLimit, executeQueryLambdaRequest.defaultRowLimit) &&
        Objects.equals(this.generateWarnings, executeQueryLambdaRequest.generateWarnings) &&
        Objects.equals(this.paginate, executeQueryLambdaRequest.paginate) &&
        Objects.equals(this.initialPaginateResponseDocCount, executeQueryLambdaRequest.initialPaginateResponseDocCount) &&
        Objects.equals(this.asyncOptions, executeQueryLambdaRequest.asyncOptions) &&
        Objects.equals(this.virtualInstanceId, executeQueryLambdaRequest.virtualInstanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parameters, defaultRowLimit, generateWarnings, paginate, initialPaginateResponseDocCount, asyncOptions, virtualInstanceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecuteQueryLambdaRequest {\n");
    
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    defaultRowLimit: ").append(toIndentedString(defaultRowLimit)).append("\n");
    sb.append("    generateWarnings: ").append(toIndentedString(generateWarnings)).append("\n");
    sb.append("    paginate: ").append(toIndentedString(paginate)).append("\n");
    sb.append("    initialPaginateResponseDocCount: ").append(toIndentedString(initialPaginateResponseDocCount)).append("\n");
    sb.append("    asyncOptions: ").append(toIndentedString(asyncOptions)).append("\n");
    sb.append("    virtualInstanceId: ").append(toIndentedString(virtualInstanceId)).append("\n");
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

