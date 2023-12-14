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
import com.rockset.client.model.Privilege;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UpdateRoleRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-14T01:21:30.506Z")
public class UpdateRoleRequest {
  @SerializedName("description")
  private String description = null;

  @SerializedName("privileges")
  private List<Privilege> privileges = null;

  public UpdateRoleRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description for the role.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "Role with read and write privileges to all collections.", value = "Description for the role.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateRoleRequest privileges(List<Privilege> privileges) {
    this.privileges = privileges;
    return this;
  }

  public UpdateRoleRequest addPrivilegesItem(Privilege privilegesItem) {
    if (this.privileges == null) {
      this.privileges = new ArrayList<Privilege>();
    }
    this.privileges.add(privilegesItem);
    return this;
  }

   /**
   * List of privileges that will be associated with the role.
   * @return privileges
  **/

@JsonProperty("privileges")
@ApiModelProperty(value = "List of privileges that will be associated with the role.")
  public List<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(List<Privilege> privileges) {
    this.privileges = privileges;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateRoleRequest updateRoleRequest = (UpdateRoleRequest) o;
    return Objects.equals(this.description, updateRoleRequest.description) &&
        Objects.equals(this.privileges, updateRoleRequest.privileges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, privileges);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateRoleRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    privileges: ").append(toIndentedString(privileges)).append("\n");
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

