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

/** PaginationInfo */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2021-11-12T22:54:16.921Z")
public class PaginationInfo {
  @SerializedName("current_page_doc_count")
  private Long currentPageDocCount = null;

  @SerializedName("next_cursor_offset")
  private Long nextCursorOffset = null;

  @SerializedName("start_cursor")
  private String startCursor = null;

  @SerializedName("next_cursor")
  private String nextCursor = null;

  public PaginationInfo currentPageDocCount(Long currentPageDocCount) {
    this.currentPageDocCount = currentPageDocCount;
    return this;
  }

  /**
   * Number of documents returned in this result set
   *
   * @return currentPageDocCount
   */
  @JsonProperty("current_page_doc_count")
  @ApiModelProperty(example = "1000", value = "Number of documents returned in this result set")
  public Long getCurrentPageDocCount() {
    return currentPageDocCount;
  }

  public void setCurrentPageDocCount(Long currentPageDocCount) {
    this.currentPageDocCount = currentPageDocCount;
  }

  public PaginationInfo nextCursorOffset(Long nextCursorOffset) {
    this.nextCursorOffset = nextCursorOffset;
    return this;
  }

  /**
   * The doc offset that next_cursor starts at.
   *
   * @return nextCursorOffset
   */
  @JsonProperty("next_cursor_offset")
  @ApiModelProperty(example = "2000", value = "The doc offset that next_cursor starts at.")
  public Long getNextCursorOffset() {
    return nextCursorOffset;
  }

  public void setNextCursorOffset(Long nextCursorOffset) {
    this.nextCursorOffset = nextCursorOffset;
  }

  public PaginationInfo startCursor(String startCursor) {
    this.startCursor = startCursor;
    return this;
  }

  /**
   * Cursor used to retrieve the first set of documents.
   *
   * @return startCursor
   */
  @JsonProperty("start_cursor")
  @ApiModelProperty(
      example = "startcursor",
      value = "Cursor used to retrieve the first set of documents.")
  public String getStartCursor() {
    return startCursor;
  }

  public void setStartCursor(String startCursor) {
    this.startCursor = startCursor;
  }

  public PaginationInfo nextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
    return this;
  }

  /**
   * Cursor to use to get the list of documents
   *
   * @return nextCursor
   */
  @JsonProperty("next_cursor")
  @ApiModelProperty(
      example = "testnextcursor",
      value = "Cursor to use to get the list of documents")
  public String getNextCursor() {
    return nextCursor;
  }

  public void setNextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationInfo paginationInfo = (PaginationInfo) o;
    return Objects.equals(this.currentPageDocCount, paginationInfo.currentPageDocCount)
        && Objects.equals(this.nextCursorOffset, paginationInfo.nextCursorOffset)
        && Objects.equals(this.startCursor, paginationInfo.startCursor)
        && Objects.equals(this.nextCursor, paginationInfo.nextCursor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPageDocCount, nextCursorOffset, startCursor, nextCursor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationInfo {\n");

    sb.append("    currentPageDocCount: ")
        .append(toIndentedString(currentPageDocCount))
        .append("\n");
    sb.append("    nextCursorOffset: ").append(toIndentedString(nextCursorOffset)).append("\n");
    sb.append("    startCursor: ").append(toIndentedString(startCursor)).append("\n");
    sb.append("    nextCursor: ").append(toIndentedString(nextCursor)).append("\n");
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
