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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** CreateCollectionMountRequest */
@javax.annotation.Generated(
    value = "io.swagger.codegen.languages.JavaClientCodegen",
    date = "2024-01-15T19:57:30.680Z")
public class CreateCollectionMountRequest {
  @SerializedName("collection_paths")
  private List<String> collectionPaths = null;

  public CreateCollectionMountRequest collectionPaths(List<String> collectionPaths) {
    this.collectionPaths = collectionPaths;
    return this;
  }

  public CreateCollectionMountRequest addCollectionPathsItem(String collectionPathsItem) {
    if (this.collectionPaths == null) {
      this.collectionPaths = new ArrayList<String>();
    }
    this.collectionPaths.add(collectionPathsItem);
    return this;
  }

  /**
   * Collections to mount.
   *
   * @return collectionPaths
   */
  @JsonProperty("collection_paths")
  @ApiModelProperty(
      example = "\"[\\\"commons.foo\\\", \\\"commons.bar\\\"]\"",
      value = "Collections to mount.")
  public List<String> getCollectionPaths() {
    return collectionPaths;
  }

  public void setCollectionPaths(List<String> collectionPaths) {
    this.collectionPaths = collectionPaths;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCollectionMountRequest createCollectionMountRequest = (CreateCollectionMountRequest) o;
    return Objects.equals(this.collectionPaths, createCollectionMountRequest.collectionPaths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionPaths);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCollectionMountRequest {\n");

    sb.append("    collectionPaths: ").append(toIndentedString(collectionPaths)).append("\n");
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
