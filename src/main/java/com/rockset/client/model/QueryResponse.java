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
import com.rockset.client.model.PaginationInfo;
import com.rockset.client.model.QueryError;
import com.rockset.client.model.QueryFieldType;
import com.rockset.client.model.QueryResponseStats;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * QueryResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-11-22T11:16:43.952-05:00")
public class QueryResponse {
  @SerializedName("query_id")
  private String queryId = null;

  @SerializedName("collections")
  private List<String> collections = null;

  @SerializedName("results")
  private List<Object> results = null;

  @SerializedName("stats")
  private QueryResponseStats stats = null;

  @SerializedName("warnings")
  private List<String> warnings = null;

  @SerializedName("query_lambda_path")
  private String queryLambdaPath = null;

  @SerializedName("query_errors")
  private List<QueryError> queryErrors = null;

  @SerializedName("column_fields")
  private List<QueryFieldType> columnFields = null;

  @SerializedName("results_total_doc_count")
  private Long resultsTotalDocCount = null;

  @SerializedName("pagination")
  private PaginationInfo pagination = null;

  @SerializedName("last_offset")
  private String lastOffset = null;

  public QueryResponse queryId(String queryId) {
    this.queryId = queryId;
    return this;
  }

   /**
   * Unique ID for this query.
   * @return queryId
  **/

@JsonProperty("query_id")
@ApiModelProperty(value = "Unique ID for this query.")
  public String getQueryId() {
    return queryId;
  }

  public void setQueryId(String queryId) {
    this.queryId = queryId;
  }

  public QueryResponse collections(List<String> collections) {
    this.collections = collections;
    return this;
  }

  public QueryResponse addCollectionsItem(String collectionsItem) {
    if (this.collections == null) {
      this.collections = new ArrayList<String>();
    }
    this.collections.add(collectionsItem);
    return this;
  }

   /**
   * List of collections referenced in the query.
   * @return collections
  **/

@JsonProperty("collections")
@ApiModelProperty(value = "List of collections referenced in the query.")
  public List<String> getCollections() {
    return collections;
  }

  public void setCollections(List<String> collections) {
    this.collections = collections;
  }

  public QueryResponse results(List<Object> results) {
    this.results = results;
    return this;
  }

  public QueryResponse addResultsItem(Object resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<Object>();
    }
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Results from the query.
   * @return results
  **/

@JsonProperty("results")
@ApiModelProperty(value = "Results from the query.")
  public List<Object> getResults() {
    return results;
  }

  public void setResults(List<Object> results) {
    this.results = results;
  }

  public QueryResponse stats(QueryResponseStats stats) {
    this.stats = stats;
    return this;
  }

   /**
   * Meta information about the query including execution latencies.
   * @return stats
  **/

@JsonProperty("stats")
@ApiModelProperty(value = "Meta information about the query including execution latencies.")
  public QueryResponseStats getStats() {
    return stats;
  }

  public void setStats(QueryResponseStats stats) {
    this.stats = stats;
  }

  public QueryResponse warnings(List<String> warnings) {
    this.warnings = warnings;
    return this;
  }

  public QueryResponse addWarningsItem(String warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<String>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

   /**
   * Warnings generated by the query. Only populated if &#x60;generate_warnings&#x60; is specified in the query request.
   * @return warnings
  **/

@JsonProperty("warnings")
@ApiModelProperty(value = "Warnings generated by the query. Only populated if `generate_warnings` is specified in the query request.")
  public List<String> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<String> warnings) {
    this.warnings = warnings;
  }

  public QueryResponse queryLambdaPath(String queryLambdaPath) {
    this.queryLambdaPath = queryLambdaPath;
    return this;
  }

   /**
   * The full path of the executed query lambda. Includes version information.
   * @return queryLambdaPath
  **/

@JsonProperty("query_lambda_path")
@ApiModelProperty(value = "The full path of the executed query lambda. Includes version information.")
  public String getQueryLambdaPath() {
    return queryLambdaPath;
  }

  public void setQueryLambdaPath(String queryLambdaPath) {
    this.queryLambdaPath = queryLambdaPath;
  }

  public QueryResponse queryErrors(List<QueryError> queryErrors) {
    this.queryErrors = queryErrors;
    return this;
  }

  public QueryResponse addQueryErrorsItem(QueryError queryErrorsItem) {
    if (this.queryErrors == null) {
      this.queryErrors = new ArrayList<QueryError>();
    }
    this.queryErrors.add(queryErrorsItem);
    return this;
  }

   /**
   * Errors encountered while executing the query.
   * @return queryErrors
  **/

@JsonProperty("query_errors")
@ApiModelProperty(value = "Errors encountered while executing the query.")
  public List<QueryError> getQueryErrors() {
    return queryErrors;
  }

  public void setQueryErrors(List<QueryError> queryErrors) {
    this.queryErrors = queryErrors;
  }

  public QueryResponse columnFields(List<QueryFieldType> columnFields) {
    this.columnFields = columnFields;
    return this;
  }

  public QueryResponse addColumnFieldsItem(QueryFieldType columnFieldsItem) {
    if (this.columnFields == null) {
      this.columnFields = new ArrayList<QueryFieldType>();
    }
    this.columnFields.add(columnFieldsItem);
    return this;
  }

   /**
   * Meta information about each column in the result set. Not populated in &#x60;SELECT *&#x60; queries.
   * @return columnFields
  **/

@JsonProperty("column_fields")
@ApiModelProperty(value = "Meta information about each column in the result set. Not populated in `SELECT *` queries.")
  public List<QueryFieldType> getColumnFields() {
    return columnFields;
  }

  public void setColumnFields(List<QueryFieldType> columnFields) {
    this.columnFields = columnFields;
  }

  public QueryResponse resultsTotalDocCount(Long resultsTotalDocCount) {
    this.resultsTotalDocCount = resultsTotalDocCount;
    return this;
  }

   /**
   * Number of results generated by the query.
   * @return resultsTotalDocCount
  **/

@JsonProperty("results_total_doc_count")
@ApiModelProperty(value = "Number of results generated by the query.")
  public Long getResultsTotalDocCount() {
    return resultsTotalDocCount;
  }

  public void setResultsTotalDocCount(Long resultsTotalDocCount) {
    this.resultsTotalDocCount = resultsTotalDocCount;
  }

  public QueryResponse pagination(PaginationInfo pagination) {
    this.pagination = pagination;
    return this;
  }

   /**
   * Pagination information. Only populated if &#x60;paginate&#x60; is specified in the query request.
   * @return pagination
  **/

@JsonProperty("pagination")
@ApiModelProperty(value = "Pagination information. Only populated if `paginate` is specified in the query request.")
  public PaginationInfo getPagination() {
    return pagination;
  }

  public void setPagination(PaginationInfo pagination) {
    this.pagination = pagination;
  }

  public QueryResponse lastOffset(String lastOffset) {
    this.lastOffset = lastOffset;
    return this;
  }

   /**
   * If this was a write query, this is the log offset the query was written to.
   * @return lastOffset
  **/

@JsonProperty("last_offset")
@ApiModelProperty(value = "If this was a write query, this is the log offset the query was written to.")
  public String getLastOffset() {
    return lastOffset;
  }

  public void setLastOffset(String lastOffset) {
    this.lastOffset = lastOffset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryResponse queryResponse = (QueryResponse) o;
    return Objects.equals(this.queryId, queryResponse.queryId) &&
        Objects.equals(this.collections, queryResponse.collections) &&
        Objects.equals(this.results, queryResponse.results) &&
        Objects.equals(this.stats, queryResponse.stats) &&
        Objects.equals(this.warnings, queryResponse.warnings) &&
        Objects.equals(this.queryLambdaPath, queryResponse.queryLambdaPath) &&
        Objects.equals(this.queryErrors, queryResponse.queryErrors) &&
        Objects.equals(this.columnFields, queryResponse.columnFields) &&
        Objects.equals(this.resultsTotalDocCount, queryResponse.resultsTotalDocCount) &&
        Objects.equals(this.pagination, queryResponse.pagination) &&
        Objects.equals(this.lastOffset, queryResponse.lastOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queryId, collections, results, stats, warnings, queryLambdaPath, queryErrors, columnFields, resultsTotalDocCount, pagination, lastOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryResponse {\n");
    
    sb.append("    queryId: ").append(toIndentedString(queryId)).append("\n");
    sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
    sb.append("    queryLambdaPath: ").append(toIndentedString(queryLambdaPath)).append("\n");
    sb.append("    queryErrors: ").append(toIndentedString(queryErrors)).append("\n");
    sb.append("    columnFields: ").append(toIndentedString(columnFields)).append("\n");
    sb.append("    resultsTotalDocCount: ").append(toIndentedString(resultsTotalDocCount)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    lastOffset: ").append(toIndentedString(lastOffset)).append("\n");
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

