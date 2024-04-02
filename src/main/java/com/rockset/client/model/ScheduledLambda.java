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
import java.util.Objects;

/** ScheduledLambda */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class ScheduledLambda {
  @SerializedName("cron_string")
  private String cronString = null;

  @SerializedName("execution_count")
  private Long executionCount = null;

  @SerializedName("last_completion_date")
  private String lastCompletionDate = null;

  @SerializedName("last_query_id")
  private String lastQueryId = null;

  @SerializedName("next_execution_date")
  private String nextExecutionDate = null;

  @SerializedName("ql_name")
  private String qlName = null;

  @SerializedName("query_execution_status")
  private ExecutionStatus queryExecutionStatus = null;

  @SerializedName("resume_permanent_error")
  private Boolean resumePermanentError = null;

  @SerializedName("rrn")
  private String rrn = null;

  @SerializedName("tag")
  private String tag = null;

  @SerializedName("total_times_to_execute")
  private Long totalTimesToExecute = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("webhook_payload")
  private String webhookPayload = null;

  @SerializedName("webhook_url")
  private String webhookUrl = null;

  @SerializedName("workspace")
  private String workspace = null;

  public ScheduledLambda cronString(String cronString) {
    this.cronString = cronString;
    return this;
  }

  /**
   * The UNIX-formatted cron string for this scheduled query lambda.
   *
   * @return cronString
   */
  @JsonProperty("cron_string")
  @ApiModelProperty(
      example = "* * * * *",
      value = "The UNIX-formatted cron string for this scheduled query lambda.")
  public String getCronString() {
    return cronString;
  }

  public void setCronString(String cronString) {
    this.cronString = cronString;
  }

  public ScheduledLambda executionCount(Long executionCount) {
    this.executionCount = executionCount;
    return this;
  }

  /**
   * The number of times this scheduled QL has been executed.
   *
   * @return executionCount
   */
  @JsonProperty("execution_count")
  @ApiModelProperty(
      example = "5",
      value = "The number of times this scheduled QL has been executed.")
  public Long getExecutionCount() {
    return executionCount;
  }

  public void setExecutionCount(Long executionCount) {
    this.executionCount = executionCount;
  }

  public ScheduledLambda lastCompletionDate(String lastCompletionDate) {
    this.lastCompletionDate = lastCompletionDate;
    return this;
  }

  /**
   * The last time this scheduled query lambda completed successfully.
   *
   * @return lastCompletionDate
   */
  @JsonProperty("last_completion_date")
  @ApiModelProperty(
      example = "2001-08-28T00:23:41Z",
      value = "The last time this scheduled query lambda completed successfully.")
  public String getLastCompletionDate() {
    return lastCompletionDate;
  }

  public void setLastCompletionDate(String lastCompletionDate) {
    this.lastCompletionDate = lastCompletionDate;
  }

  public ScheduledLambda lastQueryId(String lastQueryId) {
    this.lastQueryId = lastQueryId;
    return this;
  }

  /**
   * The ID of the query that was triggered by this scheduled lambda&#39;s last run.
   *
   * @return lastQueryId
   */
  @JsonProperty("last_query_id")
  @ApiModelProperty(
      example = "salkdjfsd-1jakdsjfksaj",
      value = "The ID of the query that was triggered by this scheduled lambda's last run.")
  public String getLastQueryId() {
    return lastQueryId;
  }

  public void setLastQueryId(String lastQueryId) {
    this.lastQueryId = lastQueryId;
  }

  public ScheduledLambda nextExecutionDate(String nextExecutionDate) {
    this.nextExecutionDate = nextExecutionDate;
    return this;
  }

  /**
   * The next time this scheduled query lambda will be executed.
   *
   * @return nextExecutionDate
   */
  @JsonProperty("next_execution_date")
  @ApiModelProperty(
      example = "2001-08-28T00:23:41Z",
      value = "The next time this scheduled query lambda will be executed.")
  public String getNextExecutionDate() {
    return nextExecutionDate;
  }

  public void setNextExecutionDate(String nextExecutionDate) {
    this.nextExecutionDate = nextExecutionDate;
  }

  public ScheduledLambda qlName(String qlName) {
    this.qlName = qlName;
    return this;
  }

  /**
   * The name of the associated query lambda.
   *
   * @return qlName
   */
  @JsonProperty("ql_name")
  @ApiModelProperty(example = "example_ql", value = "The name of the associated query lambda.")
  public String getQlName() {
    return qlName;
  }

  public void setQlName(String qlName) {
    this.qlName = qlName;
  }

  public ScheduledLambda queryExecutionStatus(ExecutionStatus queryExecutionStatus) {
    this.queryExecutionStatus = queryExecutionStatus;
    return this;
  }

  /**
   * Query execution status of the scheduled lambda. This field will only be populated when the
   * query execution encounters a warning or error state.
   *
   * @return queryExecutionStatus
   */
  @JsonProperty("query_execution_status")
  @ApiModelProperty(
      value =
          "Query execution status of the scheduled lambda. This field will only be populated when the query execution encounters a warning or error state.")
  public ExecutionStatus getQueryExecutionStatus() {
    return queryExecutionStatus;
  }

  public void setQueryExecutionStatus(ExecutionStatus queryExecutionStatus) {
    this.queryExecutionStatus = queryExecutionStatus;
  }

  public ScheduledLambda resumePermanentError(Boolean resumePermanentError) {
    this.resumePermanentError = resumePermanentError;
    return this;
  }

  /**
   * Boolean flag to allow a scheduled query lambda to resume execution after being suspended due to
   * execution failure. This flag will be unset after scheduled lambda execution.
   *
   * @return resumePermanentError
   */
  @JsonProperty("resume_permanent_error")
  @ApiModelProperty(
      value =
          "Boolean flag to allow a scheduled query lambda to resume execution after being suspended due to execution failure. This flag will be unset after scheduled lambda execution.")
  public Boolean isResumePermanentError() {
    return resumePermanentError;
  }

  public void setResumePermanentError(Boolean resumePermanentError) {
    this.resumePermanentError = resumePermanentError;
  }

  public ScheduledLambda rrn(String rrn) {
    this.rrn = rrn;
    return this;
  }

  /**
   * Scheduled Lambda mapping RRN.
   *
   * @return rrn
   */
  @JsonProperty("rrn")
  @ApiModelProperty(
      example = "rrn:sl:use1a1:123e4567-e89b-12d3-a456-556642440000",
      value = "Scheduled Lambda mapping RRN.")
  public String getRrn() {
    return rrn;
  }

  public void setRrn(String rrn) {
    this.rrn = rrn;
  }

  public ScheduledLambda tag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * The query lambda tag.
   *
   * @return tag
   */
  @JsonProperty("tag")
  @ApiModelProperty(example = "production", value = "The query lambda tag.")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public ScheduledLambda totalTimesToExecute(Long totalTimesToExecute) {
    this.totalTimesToExecute = totalTimesToExecute;
    return this;
  }

  /**
   * The number of times to execute this scheduled query lambda. Once this scheduled query lambda
   * has been executed this many times, it will no longer be executed.
   *
   * @return totalTimesToExecute
   */
  @JsonProperty("total_times_to_execute")
  @ApiModelProperty(
      example = "5",
      value =
          "The number of times to execute this scheduled query lambda. Once this scheduled query lambda has been executed this many times, it will no longer be executed.")
  public Long getTotalTimesToExecute() {
    return totalTimesToExecute;
  }

  public void setTotalTimesToExecute(Long totalTimesToExecute) {
    this.totalTimesToExecute = totalTimesToExecute;
  }

  public ScheduledLambda version(String version) {
    this.version = version;
    return this;
  }

  /**
   * The version of the associated query lambda.
   *
   * @return version
   */
  @JsonProperty("version")
  @ApiModelProperty(example = "abcde1234", value = "The version of the associated query lambda.")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ScheduledLambda webhookPayload(String webhookPayload) {
    this.webhookPayload = webhookPayload;
    return this;
  }

  /**
   * The payload that should be sent to the webhook.
   *
   * @return webhookPayload
   */
  @JsonProperty("webhook_payload")
  @ApiModelProperty(
      example =
          "{\"text\": \"A scheduled query lambda completed execution. Query ID: {{QUERY_ID}}, Initial results: {{QUERY_RESULTS}}\"",
      value = "The payload that should be sent to the webhook.")
  public String getWebhookPayload() {
    return webhookPayload;
  }

  public void setWebhookPayload(String webhookPayload) {
    this.webhookPayload = webhookPayload;
  }

  public ScheduledLambda webhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
    return this;
  }

  /**
   * The URL of the webhook that should be triggered after this scheduled query lambda completes.
   *
   * @return webhookUrl
   */
  @JsonProperty("webhook_url")
  @ApiModelProperty(
      example = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
      value =
          "The URL of the webhook that should be triggered after this scheduled query lambda completes.")
  public String getWebhookUrl() {
    return webhookUrl;
  }

  public void setWebhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
  }

  public ScheduledLambda workspace(String workspace) {
    this.workspace = workspace;
    return this;
  }

  /**
   * Workspace of the associated query lambda.
   *
   * @return workspace
   */
  @JsonProperty("workspace")
  @ApiModelProperty(example = "commons", value = "Workspace of the associated query lambda.")
  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduledLambda scheduledLambda = (ScheduledLambda) o;
    return Objects.equals(this.cronString, scheduledLambda.cronString)
        && Objects.equals(this.executionCount, scheduledLambda.executionCount)
        && Objects.equals(this.lastCompletionDate, scheduledLambda.lastCompletionDate)
        && Objects.equals(this.lastQueryId, scheduledLambda.lastQueryId)
        && Objects.equals(this.nextExecutionDate, scheduledLambda.nextExecutionDate)
        && Objects.equals(this.qlName, scheduledLambda.qlName)
        && Objects.equals(this.queryExecutionStatus, scheduledLambda.queryExecutionStatus)
        && Objects.equals(this.resumePermanentError, scheduledLambda.resumePermanentError)
        && Objects.equals(this.rrn, scheduledLambda.rrn)
        && Objects.equals(this.tag, scheduledLambda.tag)
        && Objects.equals(this.totalTimesToExecute, scheduledLambda.totalTimesToExecute)
        && Objects.equals(this.version, scheduledLambda.version)
        && Objects.equals(this.webhookPayload, scheduledLambda.webhookPayload)
        && Objects.equals(this.webhookUrl, scheduledLambda.webhookUrl)
        && Objects.equals(this.workspace, scheduledLambda.workspace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cronString,
        executionCount,
        lastCompletionDate,
        lastQueryId,
        nextExecutionDate,
        qlName,
        queryExecutionStatus,
        resumePermanentError,
        rrn,
        tag,
        totalTimesToExecute,
        version,
        webhookPayload,
        webhookUrl,
        workspace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduledLambda {\n");

    sb.append("    cronString: ").append(toIndentedString(cronString)).append("\n");
    sb.append("    executionCount: ").append(toIndentedString(executionCount)).append("\n");
    sb.append("    lastCompletionDate: ").append(toIndentedString(lastCompletionDate)).append("\n");
    sb.append("    lastQueryId: ").append(toIndentedString(lastQueryId)).append("\n");
    sb.append("    nextExecutionDate: ").append(toIndentedString(nextExecutionDate)).append("\n");
    sb.append("    qlName: ").append(toIndentedString(qlName)).append("\n");
    sb.append("    queryExecutionStatus: ")
        .append(toIndentedString(queryExecutionStatus))
        .append("\n");
    sb.append("    resumePermanentError: ")
        .append(toIndentedString(resumePermanentError))
        .append("\n");
    sb.append("    rrn: ").append(toIndentedString(rrn)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    totalTimesToExecute: ")
        .append(toIndentedString(totalTimesToExecute))
        .append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    webhookPayload: ").append(toIndentedString(webhookPayload)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
    sb.append("    workspace: ").append(toIndentedString(workspace)).append("\n");
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
