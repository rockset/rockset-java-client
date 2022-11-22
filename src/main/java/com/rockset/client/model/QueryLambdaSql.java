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
 * QueryLambdaSql
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-11-22T11:16:43.952-05:00")
public class QueryLambdaSql {
  @SerializedName("query")
  private String query = null;

  @SerializedName("default_parameters")
  private List<QueryParameter> defaultParameters = null;

  public QueryLambdaSql query(String query) {
    this.query = query;
    return this;
  }

   /**
   * SQL text.
   * @return query
  **/

@JsonProperty("query")
@ApiModelProperty(example = "SELECT 'Foo'", required = true, value = "SQL text.")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public QueryLambdaSql defaultParameters(List<QueryParameter> defaultParameters) {
    this.defaultParameters = defaultParameters;
    return this;
  }

  public QueryLambdaSql addDefaultParametersItem(QueryParameter defaultParametersItem) {
    if (this.defaultParameters == null) {
      this.defaultParameters = new ArrayList<QueryParameter>();
    }
    this.defaultParameters.add(defaultParametersItem);
    return this;
  }

   /**
   * Default parameters for this Query Lambda.
   * @return defaultParameters
  **/

@JsonProperty("default_parameters")
@ApiModelProperty(value = "Default parameters for this Query Lambda.")
  public List<QueryParameter> getDefaultParameters() {
    return defaultParameters;
  }

  public void setDefaultParameters(List<QueryParameter> defaultParameters) {
    this.defaultParameters = defaultParameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryLambdaSql queryLambdaSql = (QueryLambdaSql) o;
    return Objects.equals(this.query, queryLambdaSql.query) &&
        Objects.equals(this.defaultParameters, queryLambdaSql.defaultParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, defaultParameters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryLambdaSql {\n");
    
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    defaultParameters: ").append(toIndentedString(defaultParameters)).append("\n");
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

