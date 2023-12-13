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
 * PatchDocumentsResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-13T18:31:46.278Z")
public class PatchDocumentsResponse {
  @SerializedName("data")
  private List<DocumentStatus> data = new ArrayList<DocumentStatus>();

  @SerializedName("last_offset")
  private String lastOffset = null;

  public PatchDocumentsResponse data(List<DocumentStatus> data) {
    this.data = data;
    return this;
  }

  public PatchDocumentsResponse addDataItem(DocumentStatus dataItem) {
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/

@JsonProperty("data")
@ApiModelProperty(required = true, value = "")
  public List<DocumentStatus> getData() {
    return data;
  }

  public void setData(List<DocumentStatus> data) {
    this.data = data;
  }

  public PatchDocumentsResponse lastOffset(String lastOffset) {
    this.lastOffset = lastOffset;
    return this;
  }

   /**
   * A string representing the collection offset after completing the patch.
   * @return lastOffset
  **/

@JsonProperty("last_offset")
@ApiModelProperty(example = "f1:0:0:0:0", value = "A string representing the collection offset after completing the patch.")
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
    PatchDocumentsResponse patchDocumentsResponse = (PatchDocumentsResponse) o;
    return Objects.equals(this.data, patchDocumentsResponse.data) &&
        Objects.equals(this.lastOffset, patchDocumentsResponse.lastOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, lastOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchDocumentsResponse {\n");
    
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

