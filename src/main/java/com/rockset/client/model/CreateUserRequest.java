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
 * CreateUserRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-25T12:03:52.511Z")
public class CreateUserRequest {
  @SerializedName("email")
  private String email = null;

  @SerializedName("first_name")
  private String firstName = null;

  @SerializedName("last_name")
  private String lastName = null;

  @SerializedName("roles")
  private List<String> roles = new ArrayList<String>();

  public CreateUserRequest email(String email) {
    this.email = email;
    return this;
  }

   /**
   * User email, must be unique.
   * @return email
  **/

@JsonProperty("email")
@ApiModelProperty(example = "hello@rockset.com", required = true, value = "User email, must be unique.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateUserRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * User first name.
   * @return firstName
  **/

@JsonProperty("first_name")
@ApiModelProperty(example = "John", value = "User first name.")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CreateUserRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * User last name.
   * @return lastName
  **/

@JsonProperty("last_name")
@ApiModelProperty(example = "Doe", value = "User last name.")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CreateUserRequest roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public CreateUserRequest addRolesItem(String rolesItem) {
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * List of roles for a given user.
   * @return roles
  **/

@JsonProperty("roles")
@ApiModelProperty(example = "\"[\\\"admin\\\", \\\"member\\\", \\\"read-only\\\"]\"", required = true, value = "List of roles for a given user.")
  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserRequest createUserRequest = (CreateUserRequest) o;
    return Objects.equals(this.email, createUserRequest.email) &&
        Objects.equals(this.firstName, createUserRequest.firstName) &&
        Objects.equals(this.lastName, createUserRequest.lastName) &&
        Objects.equals(this.roles, createUserRequest.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, firstName, lastName, roles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserRequest {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

