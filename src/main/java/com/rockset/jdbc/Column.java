package com.rockset.jdbc;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Column {

  private final String name;

  public enum ColumnTypes {
    ARRAY("ARRAY"),
    BINARY("BINARY"),
    BOOLEAN("BOOLEAN"),
    MISSING("MISSING"),
    NULL("NULL"),
    NUMBER("NUMBER"),
    OBJECT("OBJECT"),
    POJO("POJO"),
    STRING("STRING"),
    DATE("DATE"),
    TIME("TIME"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP");

    public static ColumnTypes fromValue(String text) {
      for (final ColumnTypes ct : ColumnTypes.values()) {
        if (String.valueOf(ct.value).equals(text)) {
          return ct;
        }
      }

      return null;
    }

    private String value;

    ColumnTypes(String value) {
      this.value = value;
    }

    public String toString() {
      return String.valueOf(this.value);
    }
  }

  private ColumnTypes type;

  @JsonCreator
  public Column(@JsonProperty("name") String name, @JsonProperty("type") ColumnTypes type) {
    this.name = requireNonNull(name, "name is null");
    this.type = requireNonNull(type, "type is null");
  }

  @JsonProperty
  public String getName() {
    return name;
  }

  @JsonProperty
  public ColumnTypes getType() {
    return type;
  }

  public String toString() {
    return String.format(
        "(name=%s, jsontype=%s sqltype=%s)",
        getName(), getType().toString(), RocksetUtils.jsonToSqlType(getType()));
  }
}
