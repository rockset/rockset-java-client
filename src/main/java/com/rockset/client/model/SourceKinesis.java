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
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SourceKinesis
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class SourceKinesis {
  @SerializedName("aws_region")
  private String awsRegion = null;

  @SerializedName("dms_primary_key")
  private List<String> dmsPrimaryKey = null;

  /**
   * For non-DMS streams, Rockset can tail from the earliest end or latest end of kinesis source.
   */
  @JsonAdapter(OffsetResetPolicyEnum.Adapter.class)
  public enum OffsetResetPolicyEnum {
    LATEST("LATEST"),
    
    EARLIEST("EARLIEST");

    private String value;

    OffsetResetPolicyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    public static OffsetResetPolicyEnum fromValue(String text) {
      for (OffsetResetPolicyEnum b : OffsetResetPolicyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OffsetResetPolicyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OffsetResetPolicyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OffsetResetPolicyEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OffsetResetPolicyEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("offset_reset_policy")
  private OffsetResetPolicyEnum offsetResetPolicy = null;

  @SerializedName("stream_name")
  private String streamName = null;

  public SourceKinesis awsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return this;
  }

   /**
   * AWS region name of Kinesis stream, by default us-west-2 is used.
   * @return awsRegion
  **/

@JsonProperty("aws_region")
@ApiModelProperty(example = "us-east-2", value = "AWS region name of Kinesis stream, by default us-west-2 is used.")
  public String getAwsRegion() {
    return awsRegion;
  }

  public void setAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
  }

  public SourceKinesis dmsPrimaryKey(List<String> dmsPrimaryKey) {
    this.dmsPrimaryKey = dmsPrimaryKey;
    return this;
  }

  public SourceKinesis addDmsPrimaryKeyItem(String dmsPrimaryKeyItem) {
    if (this.dmsPrimaryKey == null) {
      this.dmsPrimaryKey = new ArrayList<String>();
    }
    this.dmsPrimaryKey.add(dmsPrimaryKeyItem);
    return this;
  }

   /**
   * Set of fields that correspond to a DMS primary key.
   * @return dmsPrimaryKey
  **/

@JsonProperty("dms_primary_key")
@ApiModelProperty(value = "Set of fields that correspond to a DMS primary key.")
  public List<String> getDmsPrimaryKey() {
    return dmsPrimaryKey;
  }

  public void setDmsPrimaryKey(List<String> dmsPrimaryKey) {
    this.dmsPrimaryKey = dmsPrimaryKey;
  }

  public SourceKinesis offsetResetPolicy(OffsetResetPolicyEnum offsetResetPolicy) {
    this.offsetResetPolicy = offsetResetPolicy;
    return this;
  }

   /**
   * For non-DMS streams, Rockset can tail from the earliest end or latest end of kinesis source.
   * @return offsetResetPolicy
  **/

@JsonProperty("offset_reset_policy")
@ApiModelProperty(example = "EARLIEST", value = "For non-DMS streams, Rockset can tail from the earliest end or latest end of kinesis source.")
  public OffsetResetPolicyEnum getOffsetResetPolicy() {
    return offsetResetPolicy;
  }

  public void setOffsetResetPolicy(OffsetResetPolicyEnum offsetResetPolicy) {
    this.offsetResetPolicy = offsetResetPolicy;
  }

  public SourceKinesis streamName(String streamName) {
    this.streamName = streamName;
    return this;
  }

   /**
   * Name of kinesis stream.
   * @return streamName
  **/

@JsonProperty("stream_name")
@ApiModelProperty(example = "click_stream", required = true, value = "Name of kinesis stream.")
  public String getStreamName() {
    return streamName;
  }

  public void setStreamName(String streamName) {
    this.streamName = streamName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceKinesis sourceKinesis = (SourceKinesis) o;
    return Objects.equals(this.awsRegion, sourceKinesis.awsRegion) &&
        Objects.equals(this.dmsPrimaryKey, sourceKinesis.dmsPrimaryKey) &&
        Objects.equals(this.offsetResetPolicy, sourceKinesis.offsetResetPolicy) &&
        Objects.equals(this.streamName, sourceKinesis.streamName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsRegion, dmsPrimaryKey, offsetResetPolicy, streamName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceKinesis {\n");
    
    sb.append("    awsRegion: ").append(toIndentedString(awsRegion)).append("\n");
    sb.append("    dmsPrimaryKey: ").append(toIndentedString(dmsPrimaryKey)).append("\n");
    sb.append("    offsetResetPolicy: ").append(toIndentedString(offsetResetPolicy)).append("\n");
    sb.append("    streamName: ").append(toIndentedString(streamName)).append("\n");
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

