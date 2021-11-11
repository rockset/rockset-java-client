package com.rockset.jdbc;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.primitives.Ints;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

class RocksetArray implements Array {
  private final String elementTypeName;
  private final int elementType;
  private final JsonNode[] array;

  RocksetArray(List<?> array) {
    requireNonNull(array, "array is null");
    JsonNode[] tmp = new JsonNode[array.size()];
    this.array = array.toArray(tmp);

    // inspect the first entry to determine object types
    if (this.array.length > 0) {
      Column.ColumnTypes n = Column.ColumnTypes.valueOf(this.array[0].getNodeType().toString());
      this.elementTypeName = RocksetUtils.jsonToSqlTypeName(n);
      this.elementType = RocksetUtils.jsonToSqlType(n);
    } else {
      this.elementTypeName = "array";
      this.elementType = Types.ARRAY;
    }
  }

  @Override
  public String getBaseTypeName() {
    return elementTypeName;
  }

  @Override
  public int getBaseType() {
    return elementType;
  }

  @Override
  public Object getArray() {
    final JsonNode[] tmp = new JsonNode[array.length];
    for (int i = 0; i < array.length; i++) {
      tmp[i] = array[i].deepCopy();
    }
    return tmp;
  }

  @Override
  public Object getArray(Map<String, Class<?>> map) throws SQLException {
    throw new SQLFeatureNotSupportedException("getArray not supported");
  }

  @Override
  public Object getArray(long index, int count) throws SQLException {
    int arrayOffset = Ints.saturatedCast(index - 1);
    if (index < 1 || count < 0 || (arrayOffset + count) > array.length) {
      throw new SQLException("Index out of bounds");
    }
    final JsonNode[] tmp = new JsonNode[count];
    index--; // array indices start from 0 where sql indices starts from 1
    for (int i = (int) index; i < (int) (index + count); i++) {
      tmp[i] = array[i].deepCopy();
    }
    return tmp;
  }

  @Override
  public Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
    throw new SQLFeatureNotSupportedException("getArray not supported");
  }

  @Override
  public ResultSet getResultSet() throws SQLException {
    throw new SQLFeatureNotSupportedException("getResultSet not supported");
  }

  @Override
  public ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException {
    throw new SQLFeatureNotSupportedException("getResultSet not supported");
  }

  @Override
  public ResultSet getResultSet(long index, int count) throws SQLException {
    throw new SQLFeatureNotSupportedException("getResultSet not supported");
  }

  @Override
  public ResultSet getResultSet(long index, int count, Map<String, Class<?>> map)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("getResultSet not supported");
  }

  @Override
  public void free() {
    // no-op
  }

  // returns the number of elements in this array
  int size() {
    return this.array.length;
  }
}
