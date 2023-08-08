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
import com.rockset.client.model.QueryParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExecutePublicQueryLambdaRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-08T22:21:01.705Z")
public class ExecutePublicQueryLambdaRequest {
  @SerializedName("default_row_limit")
  private Integer defaultRowLimit = null;

  @SerializedName("parameters")
  private List<QueryParameter> parameters = null;

  public ExecutePublicQueryLambdaRequest defaultRowLimit(Integer defaultRowLimit) {
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

  public ExecutePublicQueryLambdaRequest parameters(List<QueryParameter> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ExecutePublicQueryLambdaRequest addParametersItem(QueryParameter parametersItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutePublicQueryLambdaRequest executePublicQueryLambdaRequest = (ExecutePublicQueryLambdaRequest) o;
    return Objects.equals(this.defaultRowLimit, executePublicQueryLambdaRequest.defaultRowLimit) &&
        Objects.equals(this.parameters, executePublicQueryLambdaRequest.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultRowLimit, parameters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutePublicQueryLambdaRequest {\n");
    
    sb.append("    defaultRowLimit: ").append(toIndentedString(defaultRowLimit)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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

