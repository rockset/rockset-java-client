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

/** SourceFileUpload */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class SourceFileUpload {
  @SerializedName("file_name")
  private String fileName = null;

  @SerializedName("file_size")
  private Long fileSize = null;

  @SerializedName("file_upload_time")
  private String fileUploadTime = null;

  public SourceFileUpload fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * Name of the file.
   *
   * @return fileName
   */
  @JsonProperty("file_name")
  @ApiModelProperty(example = "file1.json", required = true, value = "Name of the file.")
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public SourceFileUpload fileSize(Long fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * Size of the file in bytes.
   *
   * @return fileSize
   */
  @JsonProperty("file_size")
  @ApiModelProperty(example = "12345", required = true, value = "Size of the file in bytes.")
  public Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(Long fileSize) {
    this.fileSize = fileSize;
  }

  public SourceFileUpload fileUploadTime(String fileUploadTime) {
    this.fileUploadTime = fileUploadTime;
    return this;
  }

  /**
   * Time of file upload.
   *
   * @return fileUploadTime
   */
  @JsonProperty("file_upload_time")
  @ApiModelProperty(
      example = "2019-01-15T21:48:23Z",
      required = true,
      value = "Time of file upload.")
  public String getFileUploadTime() {
    return fileUploadTime;
  }

  public void setFileUploadTime(String fileUploadTime) {
    this.fileUploadTime = fileUploadTime;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceFileUpload sourceFileUpload = (SourceFileUpload) o;
    return Objects.equals(this.fileName, sourceFileUpload.fileName)
        && Objects.equals(this.fileSize, sourceFileUpload.fileSize)
        && Objects.equals(this.fileUploadTime, sourceFileUpload.fileUploadTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, fileSize, fileUploadTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceFileUpload {\n");

    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("    fileUploadTime: ").append(toIndentedString(fileUploadTime)).append("\n");
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
