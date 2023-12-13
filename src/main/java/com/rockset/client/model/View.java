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
 * View
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-13T21:29:19.801Z")
public class View {
  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("created_by_apikey_name")
  private String createdByApikeyName = null;

  @SerializedName("creator_email")
  private String creatorEmail = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("entities")
  private List<String> entities = null;

  @SerializedName("modified_at")
  private String modifiedAt = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("owner_email")
  private String ownerEmail = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("query_sql")
  private String querySql = null;

  /**
   * State of the view.
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    CREATED("CREATED"),
    
    SYNCING("SYNCING"),
    
    DELETED("DELETED");

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

  @SerializedName("workspace")
  private String workspace = null;

  public View createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO-8601 date.
   * @return createdAt
  **/

@JsonProperty("created_at")
@ApiModelProperty(example = "2001-08-28T00:23:41Z", value = "ISO-8601 date.")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public View createdByApikeyName(String createdByApikeyName) {
    this.createdByApikeyName = createdByApikeyName;
    return this;
  }

   /**
   * Name of the API key that was used to create this object if one was used.
   * @return createdByApikeyName
  **/

@JsonProperty("created_by_apikey_name")
@ApiModelProperty(value = "Name of the API key that was used to create this object if one was used.")
  public String getCreatedByApikeyName() {
    return createdByApikeyName;
  }

  public void setCreatedByApikeyName(String createdByApikeyName) {
    this.createdByApikeyName = createdByApikeyName;
  }

  public View creatorEmail(String creatorEmail) {
    this.creatorEmail = creatorEmail;
    return this;
  }

   /**
   * Email of the creator.
   * @return creatorEmail
  **/

@JsonProperty("creator_email")
@ApiModelProperty(example = "xyz@rockset.com", value = "Email of the creator.")
  public String getCreatorEmail() {
    return creatorEmail;
  }

  public void setCreatorEmail(String creatorEmail) {
    this.creatorEmail = creatorEmail;
  }

  public View description(String description) {
    this.description = description;
    return this;
  }

   /**
   * View description.
   * @return description
  **/

@JsonProperty("description")
@ApiModelProperty(example = "view referencing collection in workspace", value = "View description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public View entities(List<String> entities) {
    this.entities = entities;
    return this;
  }

  public View addEntitiesItem(String entitiesItem) {
    if (this.entities == null) {
      this.entities = new ArrayList<String>();
    }
    this.entities.add(entitiesItem);
    return this;
  }

   /**
   * List of entities referenced by view. An entity can be a view, alias or collection.
   * @return entities
  **/

@JsonProperty("entities")
@ApiModelProperty(example = "\"[\\\"common.foo_view\\\", \\\"prod.demo_alias\\\", \\\"dev.user_collection\\\"]\"", value = "List of entities referenced by view. An entity can be a view, alias or collection.")
  public List<String> getEntities() {
    return entities;
  }

  public void setEntities(List<String> entities) {
    this.entities = entities;
  }

  public View modifiedAt(String modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

   /**
   * ISO-8601 date.
   * @return modifiedAt
  **/

@JsonProperty("modified_at")
@ApiModelProperty(example = "2001-08-28T00:23:42Z", value = "ISO-8601 date.")
  public String getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(String modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public View name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the view.
   * @return name
  **/

@JsonProperty("name")
@ApiModelProperty(example = "demo", value = "Name of the view.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public View ownerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

   /**
   * Email of the owner, note: deprecated and will always be null.
   * @return ownerEmail
  **/

@JsonProperty("owner_email")
@ApiModelProperty(example = "abc@rockset.com", value = "Email of the owner, note: deprecated and will always be null.")
  public String getOwnerEmail() {
    return ownerEmail;
  }

  public void setOwnerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
  }

  public View path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/

@JsonProperty("path")
@ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public View querySql(String querySql) {
    this.querySql = querySql;
    return this;
  }

   /**
   * SQL query of the view.
   * @return querySql
  **/

@JsonProperty("query_sql")
@ApiModelProperty(example = "SELECT * FROM commons.foo", value = "SQL query of the view.")
  public String getQuerySql() {
    return querySql;
  }

  public void setQuerySql(String querySql) {
    this.querySql = querySql;
  }

  public View state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * State of the view.
   * @return state
  **/

@JsonProperty("state")
@ApiModelProperty(example = "CREATED", value = "State of the view.")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public View workspace(String workspace) {
    this.workspace = workspace;
    return this;
  }

   /**
   * Name of the workspace.
   * @return workspace
  **/

@JsonProperty("workspace")
@ApiModelProperty(example = "commons", value = "Name of the workspace.")
  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    View view = (View) o;
    return Objects.equals(this.createdAt, view.createdAt) &&
        Objects.equals(this.createdByApikeyName, view.createdByApikeyName) &&
        Objects.equals(this.creatorEmail, view.creatorEmail) &&
        Objects.equals(this.description, view.description) &&
        Objects.equals(this.entities, view.entities) &&
        Objects.equals(this.modifiedAt, view.modifiedAt) &&
        Objects.equals(this.name, view.name) &&
        Objects.equals(this.ownerEmail, view.ownerEmail) &&
        Objects.equals(this.path, view.path) &&
        Objects.equals(this.querySql, view.querySql) &&
        Objects.equals(this.state, view.state) &&
        Objects.equals(this.workspace, view.workspace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, createdByApikeyName, creatorEmail, description, entities, modifiedAt, name, ownerEmail, path, querySql, state, workspace);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class View {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdByApikeyName: ").append(toIndentedString(createdByApikeyName)).append("\n");
    sb.append("    creatorEmail: ").append(toIndentedString(creatorEmail)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerEmail: ").append(toIndentedString(ownerEmail)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    querySql: ").append(toIndentedString(querySql)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    workspace: ").append(toIndentedString(workspace)).append("\n");
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

