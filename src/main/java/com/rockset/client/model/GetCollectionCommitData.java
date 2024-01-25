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
 * GetCollectionCommitData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-25T12:03:52.511Z")
public class GetCollectionCommitData {
  @SerializedName("fence")
  private String fence = null;

  @SerializedName("passed")
  private Boolean passed = null;

  public GetCollectionCommitData fence(String fence) {
    this.fence = fence;
    return this;
  }

   /**
   * The max offset passed in the request which is the latest offset that was compared to the commit.
   * @return fence
  **/

@JsonProperty("fence")
@ApiModelProperty(example = "f1:0:14:9:7093", value = "The max offset passed in the request which is the latest offset that was compared to the commit.")
  public String getFence() {
    return fence;
  }

  public void setFence(String fence) {
    this.fence = fence;
  }

  public GetCollectionCommitData passed(Boolean passed) {
    this.passed = passed;
    return this;
  }

   /**
   * True if all the data in the offsets are available to be queried. False if one or more of the offsets is still behind the request offsets.
   * @return passed
  **/

@JsonProperty("passed")
@ApiModelProperty(example = "true", value = "True if all the data in the offsets are available to be queried. False if one or more of the offsets is still behind the request offsets.")
  public Boolean isPassed() {
    return passed;
  }

  public void setPassed(Boolean passed) {
    this.passed = passed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCollectionCommitData getCollectionCommitData = (GetCollectionCommitData) o;
    return Objects.equals(this.fence, getCollectionCommitData.fence) &&
        Objects.equals(this.passed, getCollectionCommitData.passed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fence, passed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCollectionCommitData {\n");
    
    sb.append("    fence: ").append(toIndentedString(fence)).append("\n");
    sb.append("    passed: ").append(toIndentedString(passed)).append("\n");
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

