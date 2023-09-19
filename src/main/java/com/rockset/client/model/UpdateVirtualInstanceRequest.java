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
import com.rockset.client.model.AutoScalingPolicy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UpdateVirtualInstanceRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class UpdateVirtualInstanceRequest {
  @SerializedName("auto_scaling_policy")
  private AutoScalingPolicy autoScalingPolicy = null;

  @SerializedName("auto_suspend_enabled")
  private Boolean autoSuspendEnabled = null;

  @SerializedName("auto_suspend_seconds")
  private Integer autoSuspendSeconds = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("enable_remount_on_resume")
  private Boolean enableRemountOnResume = null;

  @SerializedName("mount_refresh_interval_seconds")
  private Integer mountRefreshIntervalSeconds = null;

  @SerializedName("name")
  private String name = null;

  /**
   * Requested virtual instance size.
   */
  @JsonAdapter(NewSizeEnum.Adapter.class)
  public enum NewSizeEnum {
    FREE("FREE"),
    
    NANO("NANO"),
    
    SHARED("SHARED"),
    
    MILLI("MILLI"),
    
    SMALL("SMALL"),
    
    MEDIUM("MEDIUM"),
    
    LARGE("LARGE"),
    
    XLARGE("XLARGE"),
    
    XLARGE2("XLARGE2"),
    
    XLARGE4("XLARGE4"),
    
    XLARGE8("XLARGE8"),
    
    XLARGE16("XLARGE16");

    private String value;

    NewSizeEnum(String value) {
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
    public static NewSizeEnum fromValue(String text) {
      for (NewSizeEnum b : NewSizeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<NewSizeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NewSizeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public NewSizeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return NewSizeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("new_size")
  private NewSizeEnum newSize = null;

  public UpdateVirtualInstanceRequest autoScalingPolicy(AutoScalingPolicy autoScalingPolicy) {
    this.autoScalingPolicy = autoScalingPolicy;
    return this;
  }

   /**
   * Options for configuring auto scaling policy
   * @return autoScalingPolicy
  **/

@JsonProperty("auto_scaling_policy")
@ApiModelProperty(value = "Options for configuring auto scaling policy")
  public AutoScalingPolicy getAutoScalingPolicy() {
    return autoScalingPolicy;
  }

  public void setAutoScalingPolicy(AutoScalingPolicy autoScalingPolicy) {
    this.autoScalingPolicy = autoScalingPolicy;
  }

  public UpdateVirtualInstanceRequest autoSuspendEnabled(Boolean autoSuspendEnabled) {
    this.autoSuspendEnabled = autoSuspendEnabled;
    return this;
  }

   /**
   * Whether auto-suspend should be enabled for this Virtual Instance.
   * @return autoSuspendEnabled
  **/

@JsonProperty("auto_suspend_enabled")
@ApiModelProperty(example = "true", value = "Whether auto-suspend should be enabled for this Virtual Instance.")
  public Boolean isAutoSuspendEnabled() {
    return autoSuspendEnabled;
  }

  public void setAutoSuspendEnabled(Boolean autoSuspendEnabled) {
    this.autoSuspendEnabled = autoSuspendEnabled;
  }

  public UpdateVirtualInstanceRequest autoSuspendSeconds(Integer autoSuspendSeconds) {
    this.autoSuspendSeconds = autoSuspendSeconds;
    return this;
  }

   /**
   * Number of seconds without queries after which the VI is suspended
   * @return autoSuspendSeconds
  **/

@JsonProperty("auto_suspend_seconds")
@ApiModelProperty(example = "3600", value = "Number of seconds without queries after which the VI is suspended")
  public Integer getAutoSuspendSeconds() {
    return autoSuspendSeconds;
  }

  public void setAutoSuspendSeconds(Integer autoSuspendSeconds) {
    this.autoSuspendSeconds = autoSuspendSeconds;
  }

  public UpdateVirtualInstanceRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * New virtual instance description.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "VI for prod traffic", value = "New virtual instance description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateVirtualInstanceRequest enableRemountOnResume(Boolean enableRemountOnResume) {
    this.enableRemountOnResume = enableRemountOnResume;
    return this;
  }

   /**
   * When a Virtual Instance is resumed, it will remount all collections that were mounted when the Virtual Instance was suspended.
   * @return enableRemountOnResume
  **/

@JsonProperty("enable_remount_on_resume")
@ApiModelProperty(example = "true", value = "When a Virtual Instance is resumed, it will remount all collections that were mounted when the Virtual Instance was suspended.")
  public Boolean isEnableRemountOnResume() {
    return enableRemountOnResume;
  }

  public void setEnableRemountOnResume(Boolean enableRemountOnResume) {
    this.enableRemountOnResume = enableRemountOnResume;
  }

  public UpdateVirtualInstanceRequest mountRefreshIntervalSeconds(Integer mountRefreshIntervalSeconds) {
    this.mountRefreshIntervalSeconds = mountRefreshIntervalSeconds;
    return this;
  }

   /**
   * Number of seconds between data refreshes for mounts on this Virtual Instance. A value of 0 means continuous refresh and a value of null means never refresh.
   * @return mountRefreshIntervalSeconds
  **/

@JsonProperty("mount_refresh_interval_seconds")
@ApiModelProperty(example = "3600", value = "Number of seconds between data refreshes for mounts on this Virtual Instance. A value of 0 means continuous refresh and a value of null means never refresh.")
  public Integer getMountRefreshIntervalSeconds() {
    return mountRefreshIntervalSeconds;
  }

  public void setMountRefreshIntervalSeconds(Integer mountRefreshIntervalSeconds) {
    this.mountRefreshIntervalSeconds = mountRefreshIntervalSeconds;
  }

  public UpdateVirtualInstanceRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * New virtual instance name.
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "prod_vi", value = "New virtual instance name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateVirtualInstanceRequest newSize(NewSizeEnum newSize) {
    this.newSize = newSize;
    return this;
  }

   /**
   * Requested virtual instance size.
   * @return newSize
  **/

@JsonProperty("new_size")
@ApiModelProperty(example = "LARGE", value = "Requested virtual instance size.")
  public NewSizeEnum getNewSize() {
    return newSize;
  }

  public void setNewSize(NewSizeEnum newSize) {
    this.newSize = newSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateVirtualInstanceRequest updateVirtualInstanceRequest = (UpdateVirtualInstanceRequest) o;
    return Objects.equals(this.autoScalingPolicy, updateVirtualInstanceRequest.autoScalingPolicy) &&
        Objects.equals(this.autoSuspendEnabled, updateVirtualInstanceRequest.autoSuspendEnabled) &&
        Objects.equals(this.autoSuspendSeconds, updateVirtualInstanceRequest.autoSuspendSeconds) &&
        Objects.equals(this.description, updateVirtualInstanceRequest.description) &&
        Objects.equals(this.enableRemountOnResume, updateVirtualInstanceRequest.enableRemountOnResume) &&
        Objects.equals(this.mountRefreshIntervalSeconds, updateVirtualInstanceRequest.mountRefreshIntervalSeconds) &&
        Objects.equals(this.name, updateVirtualInstanceRequest.name) &&
        Objects.equals(this.newSize, updateVirtualInstanceRequest.newSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoScalingPolicy, autoSuspendEnabled, autoSuspendSeconds, description, enableRemountOnResume, mountRefreshIntervalSeconds, name, newSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateVirtualInstanceRequest {\n");
    
    sb.append("    autoScalingPolicy: ").append(toIndentedString(autoScalingPolicy)).append("\n");
    sb.append("    autoSuspendEnabled: ").append(toIndentedString(autoSuspendEnabled)).append("\n");
    sb.append("    autoSuspendSeconds: ").append(toIndentedString(autoSuspendSeconds)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enableRemountOnResume: ").append(toIndentedString(enableRemountOnResume)).append("\n");
    sb.append("    mountRefreshIntervalSeconds: ").append(toIndentedString(mountRefreshIntervalSeconds)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    newSize: ").append(toIndentedString(newSize)).append("\n");
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

