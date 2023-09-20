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
import com.rockset.client.model.VirtualInstanceStats;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VirtualInstance
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class VirtualInstance {
  @SerializedName("auto_scaling_policy")
  private AutoScalingPolicy autoScalingPolicy = null;

  @SerializedName("auto_suspend_seconds")
  private Integer autoSuspendSeconds = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("created_by")
  private String createdBy = null;

  /**
   * Virtual instance current size.
   */
  @JsonAdapter(CurrentSizeEnum.Adapter.class)
  public enum CurrentSizeEnum {
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

    CurrentSizeEnum(String value) {
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
    public static CurrentSizeEnum fromValue(String text) {
      for (CurrentSizeEnum b : CurrentSizeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<CurrentSizeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CurrentSizeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CurrentSizeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CurrentSizeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("current_size")
  private CurrentSizeEnum currentSize = null;

  @SerializedName("default_pod_count")
  private Integer defaultPodCount = null;

  @SerializedName("default_vi")
  private Boolean defaultVi = null;

  @SerializedName("description")
  private String description = null;

  /**
   * Virtual instance desired size.
   */
  @JsonAdapter(DesiredSizeEnum.Adapter.class)
  public enum DesiredSizeEnum {
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

    DesiredSizeEnum(String value) {
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
    public static DesiredSizeEnum fromValue(String text) {
      for (DesiredSizeEnum b : DesiredSizeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<DesiredSizeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DesiredSizeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DesiredSizeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return DesiredSizeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("desired_size")
  private DesiredSizeEnum desiredSize = null;

  @SerializedName("enable_remount_on_resume")
  private Boolean enableRemountOnResume = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("monitoring_enabled")
  private Boolean monitoringEnabled = null;

  @SerializedName("mount_refresh_interval_seconds")
  private Integer mountRefreshIntervalSeconds = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("resumed_at")
  private String resumedAt = null;

  @SerializedName("rrn")
  private String rrn = null;

  @SerializedName("scaled_pod_count")
  private Integer scaledPodCount = null;

  /**
   * Virtual instance state.
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    INITIALIZING("INITIALIZING"),
    
    PROVISIONING_RESOURCES("PROVISIONINGRESOURCES"),
    
    REBALANCING_COLLECTIONS("REBALANCINGCOLLECTIONS"),
    
    ACTIVE("ACTIVE"),
    
    SUSPENDING("SUSPENDING"),
    
    SUSPENDED("SUSPENDED"),
    
    RESUMING("RESUMING"),
    
    DELETED("DELETED"),
    
    ENABLING_DEDICATED_SERVICES("ENABLINGDEDICATEDSERVICES"),
    
    DISABLING_DEDICATED_SERVICES("DISABLINGDEDICATEDSERVICES");

    private String value;

    StateEnum(String value) {
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
    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("state")
  private StateEnum state = null;

  @SerializedName("stats")
  private VirtualInstanceStats stats = null;

  public VirtualInstance autoScalingPolicy(AutoScalingPolicy autoScalingPolicy) {
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

  public VirtualInstance autoSuspendSeconds(Integer autoSuspendSeconds) {
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

  public VirtualInstance createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO-8601 date of when virtual instance was created.
   * @return createdAt
  **/

@JsonProperty("created_at")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date of when virtual instance was created.")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public VirtualInstance createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Creator of requested virtual instance.
   * @return createdBy
  **/

@JsonProperty("created_by")
@ApiModelProperty(example = "hello@rockset.com", value = "Creator of requested virtual instance.")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

   /**
   * Virtual instance current size.
   * @return currentSize
  **/

@JsonProperty("current_size")
@ApiModelProperty(example = "MEDIUM", value = "Virtual instance current size.")
  public CurrentSizeEnum getCurrentSize() {
    return currentSize;
  }

  public VirtualInstance defaultPodCount(Integer defaultPodCount) {
    this.defaultPodCount = defaultPodCount;
    return this;
  }

   /**
   * Get defaultPodCount
   * @return defaultPodCount
  **/

@JsonProperty("default_pod_count")
@ApiModelProperty(value = "")
  public Integer getDefaultPodCount() {
    return defaultPodCount;
  }

  public void setDefaultPodCount(Integer defaultPodCount) {
    this.defaultPodCount = defaultPodCount;
  }

  public VirtualInstance defaultVi(Boolean defaultVi) {
    this.defaultVi = defaultVi;
    return this;
  }

   /**
   * Get defaultVi
   * @return defaultVi
  **/

@JsonProperty("default_vi")
@ApiModelProperty(value = "")
  public Boolean isDefaultVi() {
    return defaultVi;
  }

  public void setDefaultVi(Boolean defaultVi) {
    this.defaultVi = defaultVi;
  }

  public VirtualInstance description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Virtual instance description.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "VI for prod traffic", value = "Virtual instance description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

   /**
   * Virtual instance desired size.
   * @return desiredSize
  **/

@JsonProperty("desired_size")
@ApiModelProperty(example = "MEDIUM", value = "Virtual instance desired size.")
  public DesiredSizeEnum getDesiredSize() {
    return desiredSize;
  }

  public VirtualInstance enableRemountOnResume(Boolean enableRemountOnResume) {
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

  public VirtualInstance id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for virtual instance.
   * @return id
  **/

@JsonProperty("id")
@ApiModelProperty(example = "123e4567-e89b-12d3-a456-556642440000", value = "Unique identifier for virtual instance.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public VirtualInstance monitoringEnabled(Boolean monitoringEnabled) {
    this.monitoringEnabled = monitoringEnabled;
    return this;
  }

   /**
   * Get monitoringEnabled
   * @return monitoringEnabled
  **/

@JsonProperty("monitoring_enabled")
@ApiModelProperty(value = "")
  public Boolean isMonitoringEnabled() {
    return monitoringEnabled;
  }

  public void setMonitoringEnabled(Boolean monitoringEnabled) {
    this.monitoringEnabled = monitoringEnabled;
  }

  public VirtualInstance mountRefreshIntervalSeconds(Integer mountRefreshIntervalSeconds) {
    this.mountRefreshIntervalSeconds = mountRefreshIntervalSeconds;
    return this;
  }

   /**
   * Number of seconds between data refreshes for mounts on this Virtual Instance
   * @return mountRefreshIntervalSeconds
  **/

@JsonProperty("mount_refresh_interval_seconds")
@ApiModelProperty(example = "3600", value = "Number of seconds between data refreshes for mounts on this Virtual Instance")
  public Integer getMountRefreshIntervalSeconds() {
    return mountRefreshIntervalSeconds;
  }

  public void setMountRefreshIntervalSeconds(Integer mountRefreshIntervalSeconds) {
    this.mountRefreshIntervalSeconds = mountRefreshIntervalSeconds;
  }

  public VirtualInstance name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Virtual instance name.
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "prod_vi", required = true, value = "Virtual instance name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public VirtualInstance resumedAt(String resumedAt) {
    this.resumedAt = resumedAt;
    return this;
  }

   /**
   * ISO-8601 date of when virtual instance was created.
   * @return resumedAt
  **/

@JsonProperty("resumed_at")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date of when virtual instance was created.")
  public String getResumedAt() {
    return resumedAt;
  }

  public void setResumedAt(String resumedAt) {
    this.resumedAt = resumedAt;
  }

  public VirtualInstance rrn(String rrn) {
    this.rrn = rrn;
    return this;
  }

   /**
   * Virtual Instance RRN.
   * @return rrn
  **/

@JsonProperty("rrn")
@ApiModelProperty(example = "rrn:vi:use1a1:123e4567-e89b-12d3-a456-556642440000", value = "Virtual Instance RRN.")
  public String getRrn() {
    return rrn;
  }

  public void setRrn(String rrn) {
    this.rrn = rrn;
  }

  public VirtualInstance scaledPodCount(Integer scaledPodCount) {
    this.scaledPodCount = scaledPodCount;
    return this;
  }

   /**
   * Get scaledPodCount
   * @return scaledPodCount
  **/

@JsonProperty("scaled_pod_count")
@ApiModelProperty(value = "")
  public Integer getScaledPodCount() {
    return scaledPodCount;
  }

  public void setScaledPodCount(Integer scaledPodCount) {
    this.scaledPodCount = scaledPodCount;
  }

  public VirtualInstance state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * Virtual instance state.
   * @return state
  **/

@JsonProperty("state")
@ApiModelProperty(example = "ACTIVE", value = "Virtual instance state.")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public VirtualInstance stats(VirtualInstanceStats stats) {
    this.stats = stats;
    return this;
  }

   /**
   * Stats about this VirtualInstance
   * @return stats
  **/

@JsonProperty("stats")
@ApiModelProperty(value = "Stats about this VirtualInstance")
  public VirtualInstanceStats getStats() {
    return stats;
  }

  public void setStats(VirtualInstanceStats stats) {
    this.stats = stats;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualInstance virtualInstance = (VirtualInstance) o;
    return Objects.equals(this.autoScalingPolicy, virtualInstance.autoScalingPolicy) &&
        Objects.equals(this.autoSuspendSeconds, virtualInstance.autoSuspendSeconds) &&
        Objects.equals(this.createdAt, virtualInstance.createdAt) &&
        Objects.equals(this.createdBy, virtualInstance.createdBy) &&
        Objects.equals(this.currentSize, virtualInstance.currentSize) &&
        Objects.equals(this.defaultPodCount, virtualInstance.defaultPodCount) &&
        Objects.equals(this.defaultVi, virtualInstance.defaultVi) &&
        Objects.equals(this.description, virtualInstance.description) &&
        Objects.equals(this.desiredSize, virtualInstance.desiredSize) &&
        Objects.equals(this.enableRemountOnResume, virtualInstance.enableRemountOnResume) &&
        Objects.equals(this.id, virtualInstance.id) &&
        Objects.equals(this.monitoringEnabled, virtualInstance.monitoringEnabled) &&
        Objects.equals(this.mountRefreshIntervalSeconds, virtualInstance.mountRefreshIntervalSeconds) &&
        Objects.equals(this.name, virtualInstance.name) &&
        Objects.equals(this.resumedAt, virtualInstance.resumedAt) &&
        Objects.equals(this.rrn, virtualInstance.rrn) &&
        Objects.equals(this.scaledPodCount, virtualInstance.scaledPodCount) &&
        Objects.equals(this.state, virtualInstance.state) &&
        Objects.equals(this.stats, virtualInstance.stats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoScalingPolicy, autoSuspendSeconds, createdAt, createdBy, currentSize, defaultPodCount, defaultVi, description, desiredSize, enableRemountOnResume, id, monitoringEnabled, mountRefreshIntervalSeconds, name, resumedAt, rrn, scaledPodCount, state, stats);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualInstance {\n");
    
    sb.append("    autoScalingPolicy: ").append(toIndentedString(autoScalingPolicy)).append("\n");
    sb.append("    autoSuspendSeconds: ").append(toIndentedString(autoSuspendSeconds)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    currentSize: ").append(toIndentedString(currentSize)).append("\n");
    sb.append("    defaultPodCount: ").append(toIndentedString(defaultPodCount)).append("\n");
    sb.append("    defaultVi: ").append(toIndentedString(defaultVi)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    desiredSize: ").append(toIndentedString(desiredSize)).append("\n");
    sb.append("    enableRemountOnResume: ").append(toIndentedString(enableRemountOnResume)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    monitoringEnabled: ").append(toIndentedString(monitoringEnabled)).append("\n");
    sb.append("    mountRefreshIntervalSeconds: ").append(toIndentedString(mountRefreshIntervalSeconds)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resumedAt: ").append(toIndentedString(resumedAt)).append("\n");
    sb.append("    rrn: ").append(toIndentedString(rrn)).append("\n");
    sb.append("    scaledPodCount: ").append(toIndentedString(scaledPodCount)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
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

