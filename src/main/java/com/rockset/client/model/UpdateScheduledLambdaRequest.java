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
 * UpdateScheduledLambdaRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-02-14T12:03:45.664Z")
public class UpdateScheduledLambdaRequest {
  @SerializedName("apikey")
  private String apikey = null;

  @SerializedName("resume_permanent_error")
  private Boolean resumePermanentError = null;

  @SerializedName("total_times_to_execute")
  private Long totalTimesToExecute = null;

  @SerializedName("webhook_auth_header")
  private String webhookAuthHeader = null;

  @SerializedName("webhook_payload")
  private String webhookPayload = null;

  @SerializedName("webhook_url")
  private String webhookUrl = null;

  public UpdateScheduledLambdaRequest apikey(String apikey) {
    this.apikey = apikey;
    return this;
  }

   /**
   * The apikey to use when triggering execution of the associated query lambda.
   * @return apikey
  **/

@JsonProperty("apikey")
@ApiModelProperty(example = "qoiwkjndksd", value = "The apikey to use when triggering execution of the associated query lambda.")
  public String getApikey() {
    return apikey;
  }

  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  public UpdateScheduledLambdaRequest resumePermanentError(Boolean resumePermanentError) {
    this.resumePermanentError = resumePermanentError;
    return this;
  }

   /**
   * Boolean flag to allow a scheduled query lambda to resume execution after being suspended due to execution failure. This flag will be unset after scheduled lambda execution.
   * @return resumePermanentError
  **/

@JsonProperty("resume_permanent_error")
@ApiModelProperty(value = "Boolean flag to allow a scheduled query lambda to resume execution after being suspended due to execution failure. This flag will be unset after scheduled lambda execution.")
  public Boolean isResumePermanentError() {
    return resumePermanentError;
  }

  public void setResumePermanentError(Boolean resumePermanentError) {
    this.resumePermanentError = resumePermanentError;
  }

  public UpdateScheduledLambdaRequest totalTimesToExecute(Long totalTimesToExecute) {
    this.totalTimesToExecute = totalTimesToExecute;
    return this;
  }

   /**
   * The number of times to execute this scheduled query lambda.
   * @return totalTimesToExecute
  **/

@JsonProperty("total_times_to_execute")
@ApiModelProperty(example = "1", value = "The number of times to execute this scheduled query lambda.")
  public Long getTotalTimesToExecute() {
    return totalTimesToExecute;
  }

  public void setTotalTimesToExecute(Long totalTimesToExecute) {
    this.totalTimesToExecute = totalTimesToExecute;
  }

  public UpdateScheduledLambdaRequest webhookAuthHeader(String webhookAuthHeader) {
    this.webhookAuthHeader = webhookAuthHeader;
    return this;
  }

   /**
   * The value to use as the authorization header when hitting the webhook.
   * @return webhookAuthHeader
  **/

@JsonProperty("webhook_auth_header")
@ApiModelProperty(example = "bearer qiowjkjkdskdskldio", value = "The value to use as the authorization header when hitting the webhook.")
  public String getWebhookAuthHeader() {
    return webhookAuthHeader;
  }

  public void setWebhookAuthHeader(String webhookAuthHeader) {
    this.webhookAuthHeader = webhookAuthHeader;
  }

  public UpdateScheduledLambdaRequest webhookPayload(String webhookPayload) {
    this.webhookPayload = webhookPayload;
    return this;
  }

   /**
   * The payload that should be sent to the webhook. JSON format.
   * @return webhookPayload
  **/

@JsonProperty("webhook_payload")
@ApiModelProperty(value = "The payload that should be sent to the webhook. JSON format.")
  public String getWebhookPayload() {
    return webhookPayload;
  }

  public void setWebhookPayload(String webhookPayload) {
    this.webhookPayload = webhookPayload;
  }

  public UpdateScheduledLambdaRequest webhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
    return this;
  }

   /**
   * The URL of the webhook that should be triggered after this scheduled query lambda completes.
   * @return webhookUrl
  **/

@JsonProperty("webhook_url")
@ApiModelProperty(example = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX", value = "The URL of the webhook that should be triggered after this scheduled query lambda completes.")
  public String getWebhookUrl() {
    return webhookUrl;
  }

  public void setWebhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateScheduledLambdaRequest updateScheduledLambdaRequest = (UpdateScheduledLambdaRequest) o;
    return Objects.equals(this.apikey, updateScheduledLambdaRequest.apikey) &&
        Objects.equals(this.resumePermanentError, updateScheduledLambdaRequest.resumePermanentError) &&
        Objects.equals(this.totalTimesToExecute, updateScheduledLambdaRequest.totalTimesToExecute) &&
        Objects.equals(this.webhookAuthHeader, updateScheduledLambdaRequest.webhookAuthHeader) &&
        Objects.equals(this.webhookPayload, updateScheduledLambdaRequest.webhookPayload) &&
        Objects.equals(this.webhookUrl, updateScheduledLambdaRequest.webhookUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apikey, resumePermanentError, totalTimesToExecute, webhookAuthHeader, webhookPayload, webhookUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateScheduledLambdaRequest {\n");
    
    sb.append("    apikey: ").append(toIndentedString(apikey)).append("\n");
    sb.append("    resumePermanentError: ").append(toIndentedString(resumePermanentError)).append("\n");
    sb.append("    totalTimesToExecute: ").append(toIndentedString(totalTimesToExecute)).append("\n");
    sb.append("    webhookAuthHeader: ").append(toIndentedString(webhookAuthHeader)).append("\n");
    sb.append("    webhookPayload: ").append(toIndentedString(webhookPayload)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
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

