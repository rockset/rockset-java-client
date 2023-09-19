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
 * PatchOperation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-09-19T15:55:29.974-07:00")
public class PatchOperation {
  @SerializedName("from")
  private String from = null;

  /**
   * [JSON Patch operation](https://datatracker.ietf.org/doc/html/rfc6902#page-4) to be performed in this patch. Case insensitive.
   */
  @JsonAdapter(OpEnum.Adapter.class)
  public enum OpEnum {
    ADD("ADD"),
    
    REPLACE("REPLACE"),
    
    REMOVE("REMOVE"),
    
    COPY("COPY"),
    
    MOVE("MOVE"),
    
    TEST("TEST"),
    
    INCREMENT("INCREMENT");

    private String value;

    OpEnum(String value) {
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
    public static OpEnum fromValue(String text) {
      for (OpEnum b : OpEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OpEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OpEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OpEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OpEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("op")
  private OpEnum op = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("value")
  private Object value = null;

  public PatchOperation from(String from) {
    this.from = from;
    return this;
  }

   /**
   * [JSON Pointer](https://datatracker.ietf.org/doc/html/rfc6901) referencing a location in the target document. Required for &#x60;COPY&#x60; and &#x60;MOVE&#x60; operations.
   * @return from
  **/

@JsonProperty("from")
@ApiModelProperty(value = "[JSON Pointer](https://datatracker.ietf.org/doc/html/rfc6901) referencing a location in the target document. Required for `COPY` and `MOVE` operations.")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public PatchOperation op(OpEnum op) {
    this.op = op;
    return this;
  }

   /**
   * [JSON Patch operation](https://datatracker.ietf.org/doc/html/rfc6902#page-4) to be performed in this patch. Case insensitive.
   * @return op
  **/

@JsonProperty("op")
@ApiModelProperty(example = "ADD", required = true, value = "[JSON Patch operation](https://datatracker.ietf.org/doc/html/rfc6902#page-4) to be performed in this patch. Case insensitive.")
  public OpEnum getOp() {
    return op;
  }

  public void setOp(OpEnum op) {
    this.op = op;
  }

  public PatchOperation path(String path) {
    this.path = path;
    return this;
  }

   /**
   * [JSON Pointer](https://datatracker.ietf.org/doc/html/rfc6901) referencing a location in the target document where the operation is performed
   * @return path
  **/

@JsonProperty("path")
@ApiModelProperty(example = "/foo/bar", required = true, value = "[JSON Pointer](https://datatracker.ietf.org/doc/html/rfc6901) referencing a location in the target document where the operation is performed")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public PatchOperation value(Object value) {
    this.value = value;
    return this;
  }

   /**
   * Value used in the patch operation. Required for &#x60;ADD&#x60;, &#x60;REPLACE&#x60;, &#x60;TEST&#x60;, and &#x60;INCREMENT&#x60; operations.
   * @return value
  **/

@JsonProperty("value")
@ApiModelProperty(example = "\"baz\"", value = "Value used in the patch operation. Required for `ADD`, `REPLACE`, `TEST`, and `INCREMENT` operations.")
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchOperation patchOperation = (PatchOperation) o;
    return Objects.equals(this.from, patchOperation.from) &&
        Objects.equals(this.op, patchOperation.op) &&
        Objects.equals(this.path, patchOperation.path) &&
        Objects.equals(this.value, patchOperation.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, op, path, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchOperation {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

