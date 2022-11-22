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
 * CsvParams
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-11-22T11:16:43.952-05:00")
public class CsvParams {
  @SerializedName("firstLineAsColumnNames")
  private Boolean firstLineAsColumnNames = null;

  @SerializedName("separator")
  private String separator = null;

  @SerializedName("encoding")
  private String encoding = null;

  @SerializedName("columnNames")
  private List<String> columnNames = null;

  /**
   * Gets or Sets columnTypes
   */
  @JsonAdapter(ColumnTypesEnum.Adapter.class)
  public enum ColumnTypesEnum {
    UNKNOWN("UNKNOWN"),
    
    BOOLEAN("BOOLEAN"),
    
    BOOL("BOOL"),
    
    INTEGER("INTEGER"),
    
    INT("INT"),
    
    FLOAT("FLOAT"),
    
    TIME("TIME"),
    
    DATE("DATE"),
    
    DATETIME("DATETIME"),
    
    TIMESTAMP("TIMESTAMP"),
    
    STRING("STRING");

    private String value;

    ColumnTypesEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ColumnTypesEnum fromValue(String text) {
      for (ColumnTypesEnum b : ColumnTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ColumnTypesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ColumnTypesEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ColumnTypesEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ColumnTypesEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("columnTypes")
  private List<ColumnTypesEnum> columnTypes = null;

  @SerializedName("quoteChar")
  private String quoteChar = null;

  @SerializedName("escapeChar")
  private String escapeChar = null;

  public CsvParams firstLineAsColumnNames(Boolean firstLineAsColumnNames) {
    this.firstLineAsColumnNames = firstLineAsColumnNames;
    return this;
  }

   /**
   * If the first line in every object specifies the column names.
   * @return firstLineAsColumnNames
  **/

@JsonProperty("firstLineAsColumnNames")
@ApiModelProperty(example = "true", value = "If the first line in every object specifies the column names.")
  public Boolean isFirstLineAsColumnNames() {
    return firstLineAsColumnNames;
  }

  public void setFirstLineAsColumnNames(Boolean firstLineAsColumnNames) {
    this.firstLineAsColumnNames = firstLineAsColumnNames;
  }

  public CsvParams separator(String separator) {
    this.separator = separator;
    return this;
  }

   /**
   * A single character that is the column separator.
   * @return separator
  **/

@JsonProperty("separator")
@ApiModelProperty(example = ",", value = "A single character that is the column separator.")
  public String getSeparator() {
    return separator;
  }

  public void setSeparator(String separator) {
    this.separator = separator;
  }

  public CsvParams encoding(String encoding) {
    this.encoding = encoding;
    return this;
  }

   /**
   * One of: UTF-8, ISO_8859_1, UTF-16.
   * @return encoding
  **/

@JsonProperty("encoding")
@ApiModelProperty(example = "UTF-8", value = "One of: UTF-8, ISO_8859_1, UTF-16.")
  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  public CsvParams columnNames(List<String> columnNames) {
    this.columnNames = columnNames;
    return this;
  }

  public CsvParams addColumnNamesItem(String columnNamesItem) {
    if (this.columnNames == null) {
      this.columnNames = new ArrayList<String>();
    }
    this.columnNames.add(columnNamesItem);
    return this;
  }

   /**
   * Names of columns.
   * @return columnNames
  **/

@JsonProperty("columnNames")
@ApiModelProperty(example = "\"[\\\"c1\\\", \\\"c2\\\", \\\"c3\\\"]\"", value = "Names of columns.")
  public List<String> getColumnNames() {
    return columnNames;
  }

  public void setColumnNames(List<String> columnNames) {
    this.columnNames = columnNames;
  }

  public CsvParams columnTypes(List<ColumnTypesEnum> columnTypes) {
    this.columnTypes = columnTypes;
    return this;
  }

  public CsvParams addColumnTypesItem(ColumnTypesEnum columnTypesItem) {
    if (this.columnTypes == null) {
      this.columnTypes = new ArrayList<ColumnTypesEnum>();
    }
    this.columnTypes.add(columnTypesItem);
    return this;
  }

   /**
   * Names of columns.
   * @return columnTypes
  **/

@JsonProperty("columnTypes")
@ApiModelProperty(example = "\"[\\\"BOOLEAN\\\", \\\"INTEGER\\\", \\\"FLOAT\\\", \\\"STRING\\\"]\"", value = "Names of columns.")
  public List<ColumnTypesEnum> getColumnTypes() {
    return columnTypes;
  }

  public void setColumnTypes(List<ColumnTypesEnum> columnTypes) {
    this.columnTypes = columnTypes;
  }

  public CsvParams quoteChar(String quoteChar) {
    this.quoteChar = quoteChar;
    return this;
  }

   /**
   * character within which a cell value is enclosed,null character if no such character, default is &#39;\&quot;&#39;
   * @return quoteChar
  **/

@JsonProperty("quoteChar")
@ApiModelProperty(example = "\"", value = "character within which a cell value is enclosed,null character if no such character, default is '\"'")
  public String getQuoteChar() {
    return quoteChar;
  }

  public void setQuoteChar(String quoteChar) {
    this.quoteChar = quoteChar;
  }

  public CsvParams escapeChar(String escapeChar) {
    this.escapeChar = escapeChar;
    return this;
  }

   /**
   * escape character removes any special meaning from the following character,default is &#39;\\&#39;
   * @return escapeChar
  **/

@JsonProperty("escapeChar")
@ApiModelProperty(example = "\\", value = "escape character removes any special meaning from the following character,default is '\\'")
  public String getEscapeChar() {
    return escapeChar;
  }

  public void setEscapeChar(String escapeChar) {
    this.escapeChar = escapeChar;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CsvParams csvParams = (CsvParams) o;
    return Objects.equals(this.firstLineAsColumnNames, csvParams.firstLineAsColumnNames) &&
        Objects.equals(this.separator, csvParams.separator) &&
        Objects.equals(this.encoding, csvParams.encoding) &&
        Objects.equals(this.columnNames, csvParams.columnNames) &&
        Objects.equals(this.columnTypes, csvParams.columnTypes) &&
        Objects.equals(this.quoteChar, csvParams.quoteChar) &&
        Objects.equals(this.escapeChar, csvParams.escapeChar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstLineAsColumnNames, separator, encoding, columnNames, columnTypes, quoteChar, escapeChar);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CsvParams {\n");
    
    sb.append("    firstLineAsColumnNames: ").append(toIndentedString(firstLineAsColumnNames)).append("\n");
    sb.append("    separator: ").append(toIndentedString(separator)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
    sb.append("    columnNames: ").append(toIndentedString(columnNames)).append("\n");
    sb.append("    columnTypes: ").append(toIndentedString(columnTypes)).append("\n");
    sb.append("    quoteChar: ").append(toIndentedString(quoteChar)).append("\n");
    sb.append("    escapeChar: ").append(toIndentedString(escapeChar)).append("\n");
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

