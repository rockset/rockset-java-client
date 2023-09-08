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
import com.rockset.client.model.StatusAzureServiceBus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SourceAzureServiceBus
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:46:16.821-07:00")
public class SourceAzureServiceBus {
  @SerializedName("status")
  private StatusAzureServiceBus status = null;

  @SerializedName("subscription")
  private String subscription = null;

  @SerializedName("topic")
  private String topic = null;

   /**
   * Azure Service bus source status.
   * @return status
  **/

@JsonProperty("status")
@ApiModelProperty(value = "Azure Service bus source status.")
  public StatusAzureServiceBus getStatus() {
    return status;
  }

  public SourceAzureServiceBus subscription(String subscription) {
    this.subscription = subscription;
    return this;
  }

   /**
   * The subscription to read from the topic.
   * @return subscription
  **/

@JsonProperty("subscription")
@ApiModelProperty(example = "rockset-subscription", value = "The subscription to read from the topic.")
  public String getSubscription() {
    return subscription;
  }

  public void setSubscription(String subscription) {
    this.subscription = subscription;
  }

  public SourceAzureServiceBus topic(String topic) {
    this.topic = topic;
    return this;
  }

   /**
   * Name of the topic which rockset should ingest from.
   * @return topic
  **/

@JsonProperty("topic")
@ApiModelProperty(example = "rockset-topic", value = "Name of the topic which rockset should ingest from.")
  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceAzureServiceBus sourceAzureServiceBus = (SourceAzureServiceBus) o;
    return Objects.equals(this.status, sourceAzureServiceBus.status) &&
        Objects.equals(this.subscription, sourceAzureServiceBus.subscription) &&
        Objects.equals(this.topic, sourceAzureServiceBus.topic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, subscription, topic);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceAzureServiceBus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
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

