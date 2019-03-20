package com.rockset.jdbc;

import static java.util.Objects.requireNonNull;

import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

public class RocksetResultSetMetaData implements ResultSetMetaData {
  private final List<Column> columnInfo;

  RocksetResultSetMetaData() {
    this.columnInfo = new LinkedList<Column>();
  }

  RocksetResultSetMetaData(List<Column> columnInfo) {
    this.columnInfo = ImmutableList.copyOf(requireNonNull(columnInfo, "columnInfo is null"));
  }

  @Override
  public int getColumnCount() {
    return columnInfo.size();
  }

  @Override
  public boolean isAutoIncrement(int column) throws SQLException {
    return false;
  }

  @Override
  public boolean isCaseSensitive(int column) throws SQLException {
    return false;
  }

  @Override
  public boolean isSearchable(int column) throws SQLException {
    return true;
  }

  @Override
  public boolean isCurrency(int column) throws SQLException {
    return false;
  }

  @Override
  public int isNullable(int column) throws SQLException {
    return ResultSetMetaData.columnNullable;
  }

  @Override
  public boolean isSigned(int column) throws SQLException {
    return true;
  }

  @Override
  public int getColumnDisplaySize(int column) throws SQLException {
    return 10;
  }

  @Override
  public String getColumnLabel(int column) throws SQLException {
    return column(column).getName();
  }

  @Override
  public String getColumnName(int column) throws SQLException {
    return column(column).getName();
  }

  @Override
  public int getPrecision(int column) throws SQLException {
    return 2;
  }

  @Override
  public int getScale(int column) throws SQLException {
    return 2;
  }

  @Override
  public String getTableName(int column) throws SQLException {
    return "";
  }

  @Override
  public String getSchemaName(int column) throws SQLException {
    return RocksetConnection.DEFAULT_SCHEMA;
  }

  @Override
  public String getCatalogName(int column) throws SQLException {
    return RocksetConnection.DEFAULT_CATALOG;
  }

  @Override
  public int getColumnType(int column) throws SQLException {
    Column.ColumnTypes type = column(column).getType();
    return RocksetUtils.jsonToSqlType(type);
  }

  @Override
  public String getColumnTypeName(int column) throws SQLException {
    Column.ColumnTypes type = column(column).getType();
    return RocksetUtils.jsonToSqlTypeName(type);
  }

  @Override
  public boolean isReadOnly(int column) throws SQLException {
    return true;
  }

  @Override
  public boolean isWritable(int column) throws SQLException {
    return false;
  }

  @Override
  public boolean isDefinitelyWritable(int column) throws SQLException {
    return false;
  }

  @Override
  public String getColumnClassName(int column) throws SQLException {
    switch (getColumnType(column)) {
      case Types.NUMERIC:
      case Types.DECIMAL:
        return BigDecimal.class.getName();
      case Types.BOOLEAN:
      case Types.BIT:
        return Boolean.class.getName();
      case Types.TINYINT:
        return Byte.class.getName();
      case Types.SMALLINT:
        return Short.class.getName();
      case Types.INTEGER:
        return Integer.class.getName();
      case Types.BIGINT:
        return Long.class.getName();
      case Types.REAL:
        return Float.class.getName();
      case Types.FLOAT:
      case Types.DOUBLE:
        return Double.class.getName();
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
        return "byte[]";
      case Types.DATE:
        return Date.class.getName();
      case Types.TIME:
        return Time.class.getName();
      case Types.TIMESTAMP:
        return Timestamp.class.getName();
      case Types.BLOB:
        return Blob.class.getName();
      case Types.CLOB:
        return Clob.class.getName();
      case Types.ARRAY:
        return Array.class.getName();
      default:
        break;
    }
    return String.class.getName();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    if (isWrapperFor(iface)) {
      return (T) this;
    }
    throw new SQLException("No wrapper for " + iface);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return iface.isInstance(this);
  }

  private Column column(int column) throws SQLException {
    if ((column <= 0) || (column > columnInfo.size())) {
      throw new SQLException("Invalid column index: " + column);
    }
    return columnInfo.get(column - 1);
  }

  public String toString() {
    StringBuffer buf = new StringBuffer();
    int num = 0;
    for (Column c: columnInfo) {
      buf.append(c.toString());
      num++;
      if (num < getColumnCount()) {
        buf.append(",");
      }
    }
    return buf.toString();
  }
}
