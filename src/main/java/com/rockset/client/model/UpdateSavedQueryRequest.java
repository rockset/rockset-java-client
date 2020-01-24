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
import com.rockset.client.model.SavedQueryParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UpdateSavedQueryRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-24T17:41:10.748Z")
public class UpdateSavedQueryRequest {
  @SerializedName("version_tag")
  private String versionTag = null;

  @SerializedName("query_sql")
  private String querySql = null;

  @SerializedName("parameters")
  private List<SavedQueryParameter> parameters = null;

  public UpdateSavedQueryRequest versionTag(String versionTag) {
    this.versionTag = versionTag;
    return this;
  }

   /**
   * optional version tag
   * @return versionTag
  **/

@JsonProperty("version_tag")
@ApiModelProperty(example = "production version foo", value = "optional version tag")
  public String getVersionTag() {
    return versionTag;
  }

  public void setVersionTag(String versionTag) {
    this.versionTag = versionTag;
  }

  public UpdateSavedQueryRequest querySql(String querySql) {
    this.querySql = querySql;
    return this;
  }

   /**
   * SQL text of this query
   * @return querySql
  **/

@JsonProperty("query_sql")
@ApiModelProperty(example = "SELECT 'Foo'", required = true, value = "SQL text of this query")
  public String getQuerySql() {
    return querySql;
  }

  public void setQuerySql(String querySql) {
    this.querySql = querySql;
  }

  public UpdateSavedQueryRequest parameters(List<SavedQueryParameter> parameters) {
    this.parameters = parameters;
    return this;
  }

  public UpdateSavedQueryRequest addParametersItem(SavedQueryParameter parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<SavedQueryParameter>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

   /**
   * parameters associated with this query
   * @return parameters
  **/

@JsonProperty("parameters")
@ApiModelProperty(value = "parameters associated with this query")
  public List<SavedQueryParameter> getParameters() {
    return parameters;
  }

  public void setParameters(List<SavedQueryParameter> parameters) {
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
    UpdateSavedQueryRequest updateSavedQueryRequest = (UpdateSavedQueryRequest) o;
    return Objects.equals(this.versionTag, updateSavedQueryRequest.versionTag) &&
        Objects.equals(this.querySql, updateSavedQueryRequest.querySql) &&
        Objects.equals(this.parameters, updateSavedQueryRequest.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(versionTag, querySql, parameters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSavedQueryRequest {\n");
    
    sb.append("    versionTag: ").append(toIndentedString(versionTag)).append("\n");
    sb.append("    querySql: ").append(toIndentedString(querySql)).append("\n");
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
