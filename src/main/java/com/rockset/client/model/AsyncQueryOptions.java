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
 * AsyncQueryOptions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class AsyncQueryOptions {
  @SerializedName("client_timeout_ms")
  private Long clientTimeoutMs = null;

  @SerializedName("max_initial_results")
  private Long maxInitialResults = null;

  @SerializedName("timeout_ms")
  private Long timeoutMs = null;

  public AsyncQueryOptions clientTimeoutMs(Long clientTimeoutMs) {
    this.clientTimeoutMs = clientTimeoutMs;
    return this;
  }

   /**
   * If the query completes before the client timeout, the results are returned. Otherwise if the client timeout is exceeded, the query id will be returned, and the query will continue to run in the background for up to 30 minutes. (The 30 minute timeout can be configured lower with timeout_ms.) &#x60;async_options.client_timeout_ms&#x60; only applies when &#x60;async&#x60; is true. The default value of &#x60;client_timeout_ms&#x60; is 0, so async query requests will immediately return with a query id by default. 
   * @return clientTimeoutMs
  **/

@JsonProperty("client_timeout_ms")
@ApiModelProperty(value = "If the query completes before the client timeout, the results are returned. Otherwise if the client timeout is exceeded, the query id will be returned, and the query will continue to run in the background for up to 30 minutes. (The 30 minute timeout can be configured lower with timeout_ms.) `async_options.client_timeout_ms` only applies when `async` is true. The default value of `client_timeout_ms` is 0, so async query requests will immediately return with a query id by default. ")
  public Long getClientTimeoutMs() {
    return clientTimeoutMs;
  }

  public void setClientTimeoutMs(Long clientTimeoutMs) {
    this.clientTimeoutMs = clientTimeoutMs;
  }

  public AsyncQueryOptions maxInitialResults(Long maxInitialResults) {
    this.maxInitialResults = maxInitialResults;
    return this;
  }

   /**
   * [DEPRECATED] Use the query request &#x60;max_initial_results&#x60; instead. The maximum number of results you will receive as a client. If the query exceeds this limit, the remaining results can be requested using a returned pagination cursor. In addition, there is a maximum response size of 100MiB so fewer than &#x60;max_results&#x60; may be returned.
   * @return maxInitialResults
  **/

@JsonProperty("max_initial_results")
@ApiModelProperty(value = "[DEPRECATED] Use the query request `max_initial_results` instead. The maximum number of results you will receive as a client. If the query exceeds this limit, the remaining results can be requested using a returned pagination cursor. In addition, there is a maximum response size of 100MiB so fewer than `max_results` may be returned.")
  public Long getMaxInitialResults() {
    return maxInitialResults;
  }

  public void setMaxInitialResults(Long maxInitialResults) {
    this.maxInitialResults = maxInitialResults;
  }

  public AsyncQueryOptions timeoutMs(Long timeoutMs) {
    this.timeoutMs = timeoutMs;
    return this;
  }

   /**
   * [DEPRECATED] Use the query request &#x60;timeout_ms&#x60; instead. The maximum amount of time that the system will attempt to complete query execution before aborting the query and returning an error. This must be set to a value that is greater than or equal to the client timeout, and the maximum value of this timeout is 30 minutes.
   * @return timeoutMs
  **/

@JsonProperty("timeout_ms")
@ApiModelProperty(value = "[DEPRECATED] Use the query request `timeout_ms` instead. The maximum amount of time that the system will attempt to complete query execution before aborting the query and returning an error. This must be set to a value that is greater than or equal to the client timeout, and the maximum value of this timeout is 30 minutes.")
  public Long getTimeoutMs() {
    return timeoutMs;
  }

  public void setTimeoutMs(Long timeoutMs) {
    this.timeoutMs = timeoutMs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsyncQueryOptions asyncQueryOptions = (AsyncQueryOptions) o;
    return Objects.equals(this.clientTimeoutMs, asyncQueryOptions.clientTimeoutMs) &&
        Objects.equals(this.maxInitialResults, asyncQueryOptions.maxInitialResults) &&
        Objects.equals(this.timeoutMs, asyncQueryOptions.timeoutMs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientTimeoutMs, maxInitialResults, timeoutMs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsyncQueryOptions {\n");
    
    sb.append("    clientTimeoutMs: ").append(toIndentedString(clientTimeoutMs)).append("\n");
    sb.append("    maxInitialResults: ").append(toIndentedString(maxInitialResults)).append("\n");
    sb.append("    timeoutMs: ").append(toIndentedString(timeoutMs)).append("\n");
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

