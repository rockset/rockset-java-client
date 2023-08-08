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
 * StatusAzureEventHubsPartition
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-08T22:21:01.705Z")
public class StatusAzureEventHubsPartition {
  @SerializedName("offset_lag")
  private Long offsetLag = null;

  @SerializedName("partition_number")
  private Integer partitionNumber = null;

  @SerializedName("partition_offset")
  private Long partitionOffset = null;

  public StatusAzureEventHubsPartition offsetLag(Long offsetLag) {
    this.offsetLag = offsetLag;
    return this;
  }

   /**
   * Per partition lag for offset.
   * @return offsetLag
  **/

@JsonProperty("offset_lag")
@ApiModelProperty(example = "10", value = "Per partition lag for offset.")
  public Long getOffsetLag() {
    return offsetLag;
  }

  public void setOffsetLag(Long offsetLag) {
    this.offsetLag = offsetLag;
  }

  public StatusAzureEventHubsPartition partitionNumber(Integer partitionNumber) {
    this.partitionNumber = partitionNumber;
    return this;
  }

   /**
   * The number of this partition.
   * @return partitionNumber
  **/

@JsonProperty("partition_number")
@ApiModelProperty(example = "123", value = "The number of this partition.")
  public Integer getPartitionNumber() {
    return partitionNumber;
  }

  public void setPartitionNumber(Integer partitionNumber) {
    this.partitionNumber = partitionNumber;
  }

  public StatusAzureEventHubsPartition partitionOffset(Long partitionOffset) {
    this.partitionOffset = partitionOffset;
    return this;
  }

   /**
   * Latest offset of partition.
   * @return partitionOffset
  **/

@JsonProperty("partition_offset")
@ApiModelProperty(example = "100", value = "Latest offset of partition.")
  public Long getPartitionOffset() {
    return partitionOffset;
  }

  public void setPartitionOffset(Long partitionOffset) {
    this.partitionOffset = partitionOffset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusAzureEventHubsPartition statusAzureEventHubsPartition = (StatusAzureEventHubsPartition) o;
    return Objects.equals(this.offsetLag, statusAzureEventHubsPartition.offsetLag) &&
        Objects.equals(this.partitionNumber, statusAzureEventHubsPartition.partitionNumber) &&
        Objects.equals(this.partitionOffset, statusAzureEventHubsPartition.partitionOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offsetLag, partitionNumber, partitionOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusAzureEventHubsPartition {\n");
    
    sb.append("    offsetLag: ").append(toIndentedString(offsetLag)).append("\n");
    sb.append("    partitionNumber: ").append(toIndentedString(partitionNumber)).append("\n");
    sb.append("    partitionOffset: ").append(toIndentedString(partitionOffset)).append("\n");
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

