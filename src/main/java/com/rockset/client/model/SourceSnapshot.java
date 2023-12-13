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
 * SourceSnapshot
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-13T21:29:19.801Z")
public class SourceSnapshot {
  @SerializedName("source_collection_path")
  private String sourceCollectionPath = null;

  @SerializedName("source_snapshot_rrn")
  private String sourceSnapshotRrn = null;

  public SourceSnapshot sourceCollectionPath(String sourceCollectionPath) {
    this.sourceCollectionPath = sourceCollectionPath;
    return this;
  }

   /**
   * A representation of the workspace and collection where the source snapshot originated.
   * @return sourceCollectionPath
  **/

@JsonProperty("source_collection_path")
@ApiModelProperty(example = "myWorkspace.myCollection", value = "A representation of the workspace and collection where the source snapshot originated.")
  public String getSourceCollectionPath() {
    return sourceCollectionPath;
  }

  public void setSourceCollectionPath(String sourceCollectionPath) {
    this.sourceCollectionPath = sourceCollectionPath;
  }

  public SourceSnapshot sourceSnapshotRrn(String sourceSnapshotRrn) {
    this.sourceSnapshotRrn = sourceSnapshotRrn;
    return this;
  }

   /**
   * RRN of the snapshot that the new collection will be created from.
   * @return sourceSnapshotRrn
  **/

@JsonProperty("source_snapshot_rrn")
@ApiModelProperty(example = "rrn:snap:use1a1:123e4567-e89b-12d3-a456-556642440000", value = "RRN of the snapshot that the new collection will be created from.")
  public String getSourceSnapshotRrn() {
    return sourceSnapshotRrn;
  }

  public void setSourceSnapshotRrn(String sourceSnapshotRrn) {
    this.sourceSnapshotRrn = sourceSnapshotRrn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceSnapshot sourceSnapshot = (SourceSnapshot) o;
    return Objects.equals(this.sourceCollectionPath, sourceSnapshot.sourceCollectionPath) &&
        Objects.equals(this.sourceSnapshotRrn, sourceSnapshot.sourceSnapshotRrn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceCollectionPath, sourceSnapshotRrn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceSnapshot {\n");
    
    sb.append("    sourceCollectionPath: ").append(toIndentedString(sourceCollectionPath)).append("\n");
    sb.append("    sourceSnapshotRrn: ").append(toIndentedString(sourceSnapshotRrn)).append("\n");
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

