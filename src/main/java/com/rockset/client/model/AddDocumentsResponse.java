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
import com.rockset.client.model.DocumentStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AddDocumentsResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-25T12:03:52.511Z")
public class AddDocumentsResponse {
  @SerializedName("data")
  private List<DocumentStatus> data = null;

  @SerializedName("last_offset")
  private String lastOffset = null;

  public AddDocumentsResponse data(List<DocumentStatus> data) {
    this.data = data;
    return this;
  }

  public AddDocumentsResponse addDataItem(DocumentStatus dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<DocumentStatus>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Information about the added documents.
   * @return data
  **/

@JsonProperty("data")
@ApiModelProperty(value = "Information about the added documents.")
  public List<DocumentStatus> getData() {
    return data;
  }

  public void setData(List<DocumentStatus> data) {
    this.data = data;
  }

  public AddDocumentsResponse lastOffset(String lastOffset) {
    this.lastOffset = lastOffset;
    return this;
  }

   /**
   * A string representing the collection offset after completing the write.
   * @return lastOffset
  **/

@JsonProperty("last_offset")
@ApiModelProperty(example = "f1:0:0:0:0", value = "A string representing the collection offset after completing the write.")
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
    AddDocumentsResponse addDocumentsResponse = (AddDocumentsResponse) o;
    return Objects.equals(this.data, addDocumentsResponse.data) &&
        Objects.equals(this.lastOffset, addDocumentsResponse.lastOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, lastOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddDocumentsResponse {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

