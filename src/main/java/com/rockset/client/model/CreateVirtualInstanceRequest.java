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
 * CreateVirtualInstanceRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-07T20:46:16.821-07:00")
public class CreateVirtualInstanceRequest {
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
   * Requested virtual instance type.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
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

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  public CreateVirtualInstanceRequest autoSuspendSeconds(Integer autoSuspendSeconds) {
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

  public CreateVirtualInstanceRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of requested virtual instance.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "VI serving prod traffic", value = "Description of requested virtual instance.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateVirtualInstanceRequest enableRemountOnResume(Boolean enableRemountOnResume) {
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

  public CreateVirtualInstanceRequest mountRefreshIntervalSeconds(Integer mountRefreshIntervalSeconds) {
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

  public CreateVirtualInstanceRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Unique identifier for virtual instance, can contain alphanumeric or dash characters.
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "prod_vi", required = true, value = "Unique identifier for virtual instance, can contain alphanumeric or dash characters.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateVirtualInstanceRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Requested virtual instance type.
   * @return type
  **/

@JsonProperty("type")
@ApiModelProperty(example = "LARGE", value = "Requested virtual instance type.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateVirtualInstanceRequest createVirtualInstanceRequest = (CreateVirtualInstanceRequest) o;
    return Objects.equals(this.autoSuspendSeconds, createVirtualInstanceRequest.autoSuspendSeconds) &&
        Objects.equals(this.description, createVirtualInstanceRequest.description) &&
        Objects.equals(this.enableRemountOnResume, createVirtualInstanceRequest.enableRemountOnResume) &&
        Objects.equals(this.mountRefreshIntervalSeconds, createVirtualInstanceRequest.mountRefreshIntervalSeconds) &&
        Objects.equals(this.name, createVirtualInstanceRequest.name) &&
        Objects.equals(this.type, createVirtualInstanceRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoSuspendSeconds, description, enableRemountOnResume, mountRefreshIntervalSeconds, name, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateVirtualInstanceRequest {\n");
    
    sb.append("    autoSuspendSeconds: ").append(toIndentedString(autoSuspendSeconds)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enableRemountOnResume: ").append(toIndentedString(enableRemountOnResume)).append("\n");
    sb.append("    mountRefreshIntervalSeconds: ").append(toIndentedString(mountRefreshIntervalSeconds)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

