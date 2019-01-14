package com.rockset.jdbc;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.util.Locale.ENGLISH;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.google.common.collect.ImmutableMap;

import com.rockset.client.model.QueryFieldType;
import com.rockset.client.model.QueryResponse;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.ISODateTimeFormat;

public class RocksetResultSet implements ResultSet {

  private static final Logger logger = Logger.getLogger(RocksetResultSet.class.getName());

  private static final DateTimeFormatter DATE_FORMATTER = ISODateTimeFormat.date();
  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern(
          "HH:mm:ss.SSS");
  private static final DateTimeFormatter TIME_WITH_TIME_ZONE_FORMATTER =
      new DateTimeFormatterBuilder()
      .append(DateTimeFormat.forPattern("HH:mm:ss.SSS ZZZ").getPrinter(),
          new DateTimeParser[] {
              DateTimeFormat.forPattern("HH:mm:ss.SSS Z").getParser(),
              DateTimeFormat.forPattern("HH:mm:ss.SSS ZZZ").getParser(),
          })
      .toFormatter()
      .withOffsetParsed();

  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
  private static final DateTimeFormatter TIMESTAMP_WITH_TIME_ZONE_FORMATTER =
      new DateTimeFormatterBuilder()
      .append(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ").getPrinter(),
          new DateTimeParser[] {
              DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS Z").getParser(),
              DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ").getParser(),
          })
      .toFormatter()
      .withOffsetParsed();

  private static final int YEAR_FIELD = 0;
  private static final int MONTH_FIELD = 1;
  private static final int DAY_FIELD = 3;
  private static final int HOUR_FIELD = 4;
  private static final int MINUTE_FIELD = 5;
  private static final int SECOND_FIELD = 6;
  private static final int MILLIS_FIELD = 7;

  private final List<Object> resultSet;
  private final DateTimeZone sessionTimeZone;

  private final Map<String, Integer> fieldMap;
  private final List<Column> columns;
  private final ResultSetMetaData resultSetMetaData;
  private final AtomicInteger rowIndex = new AtomicInteger(-1);
  private final long totalRows;
  private final int columnCount;
  private final AtomicBoolean wasNull = new AtomicBoolean();
  private final AtomicBoolean closed = new AtomicBoolean(false);
  private final long maxRows;

  RocksetResultSet(QueryResponse response, long maxRows) throws SQLException {
    this.maxRows = maxRows;

    this.sessionTimeZone = DateTimeZone.forID(TimeZone.getDefault().getID());

    this.columns = getColumns(response);
    this.columnCount = this.columns.size();
    this.fieldMap = getFieldMap(columns);
    this.resultSet = response.getResults();
    this.resultSetMetaData = new RocksetResultSetMetaData(this.columns);

    this.totalRows = resultSet.size();
  }

  RocksetResultSet(List<Column> columns, List<Object> resultSet) {
    this.resultSet = resultSet;
    this.maxRows = resultSet.size();
    this.totalRows = resultSet.size();
    this.columnCount = columns.size();
    this.columns = columns;
    this.fieldMap = getFieldMap(columns);
    this.sessionTimeZone = DateTimeZone.forID(TimeZone.getDefault().getID());
    this.resultSetMetaData = new RocksetResultSetMetaData(this.columns);
  }


  RocksetResultSet() {
    this.resultSet = new LinkedList<Object>();
    this.maxRows = 0;
    this.totalRows = 0;
    this.columnCount = 0;
    this.columns = new ArrayList<>();
    this.fieldMap = getFieldMap(columns);
    this.sessionTimeZone = DateTimeZone.forID(TimeZone.getDefault().getID());
    this.resultSetMetaData = new RocksetResultSetMetaData();
  }

  @Override
  public boolean next() throws SQLException {
    checkOpen();
    rowIndex.getAndIncrement();
    if (rowIndex.get() >= this.totalRows) {
      return false;
    }
    return true;
  }

  @Override
  public void close() throws SQLException {
    closed.set(true);
  }

  @Override
  public boolean wasNull() throws SQLException {
    return wasNull.get();
  }

  @Override
  public String getString(int columnIndex) throws SQLException {
    JsonNode value = column(columnIndex);
    return (value != null) ? value.asText() : null;
  }

  @Override
  public boolean getBoolean(int columnIndex) throws SQLException {
    JsonNode value = column(columnIndex);
    return value != null && value.booleanValue();
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    return toNumber(column(columnIndex)).byteValue();
  }

  @Override
  public short getShort(int columnIndex) throws SQLException {
    return toNumber(column(columnIndex)).shortValue();
  }

  @Override
  public int getInt(int columnIndex) throws SQLException {
    return toNumber(column(columnIndex)).intValue();
  }

  @Override
  public long getLong(int columnIndex) throws SQLException {
    return toNumber(column(columnIndex)).longValue();
  }

  @Override
  public float getFloat(int columnIndex) throws SQLException {
    return toNumber(column(columnIndex)).floatValue();
  }

  @Override
  public double getDouble(int columnIndex) throws SQLException {
    return toNumber(column(columnIndex)).doubleValue();
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    BigDecimal bigDecimal = getBigDecimal(columnIndex);
    if (bigDecimal != null) {
      bigDecimal = bigDecimal.setScale(scale, ROUND_HALF_UP);
    }
    return bigDecimal;
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    try {
      return column(columnIndex).binaryValue();
    } catch (Exception e) {
      throw new SQLException("Error processing getBytes for column index "
                             + columnIndex
                             + " exception " + e.getMessage());
    }
  }

  @Override
  public Date getDate(int columnIndex) throws SQLException {
    return getDate(columnIndex, sessionTimeZone);
  }

  private Date getDate(int columnIndex, DateTimeZone localTimeZone)
      throws SQLException {
    JsonNode value = column(columnIndex);
    if (value == null) {
      return null;
    }

    String date = value.get("value").asText();

    // SQL doesn't have DATETIME, strip the TIME part and return just
    // the date
    if (date.indexOf('T') != -1) {
      date = date.substring(0, date.indexOf('T'));
    }
    try {
      return Date.valueOf(date);
    } catch (IllegalArgumentException e) {
      throw new SQLException("Invalid date from server: " + date, e);
    }
  }

  @Override
  public Time getTime(int columnIndex) throws SQLException {
    return getTime(columnIndex, sessionTimeZone);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    return getTimestamp(columnIndex, sessionTimeZone);
  }

  @Override
  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    throw new NotImplementedException("ResultSet", "getAsciiStream");
  }

  @Override
  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getUnicodeStream");
  }

  @Override
  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    throw new NotImplementedException("ResultSet", "getBinaryStream");
  }

  @Override
  public String getString(String columnLabel) throws SQLException {
    JsonNode value = column(columnLabel);
    return (value != null) ? value.asText() : null;
  }

  @Override
  public boolean getBoolean(String columnLabel) throws SQLException {
    JsonNode value = column(columnLabel);
    return (value != null) && value.booleanValue();
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    return toNumber(column(columnLabel)).byteValue();
  }

  @Override
  public short getShort(String columnLabel) throws SQLException {
    return toNumber(column(columnLabel)).shortValue();
  }

  @Override
  public int getInt(String columnLabel) throws SQLException {
    return toNumber(column(columnLabel)).intValue();
  }

  @Override
  public long getLong(String columnLabel) throws SQLException {
    return toNumber(column(columnLabel)).longValue();
  }

  @Override
  public float getFloat(String columnLabel) throws SQLException {
    return toNumber(column(columnLabel)).floatValue();
  }

  @Override
  public double getDouble(String columnLabel) throws SQLException {
    return toNumber(column(columnLabel)).doubleValue();
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    return getBigDecimal(columnIndex(columnLabel), scale);
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    try {
      return column(columnLabel).binaryValue();
    } catch (Exception e) {
      throw new SQLException("Error processing getBytes for column label "
                             + columnLabel
                             + " exception " + e.getMessage());
    }
  }

  @Override
  public Date getDate(String columnLabel) throws SQLException {
    return getDate(columnIndex(columnLabel));
  }

  @Override
  public Time getTime(String columnLabel) throws SQLException {
    return getTime(columnIndex(columnLabel));
  }

  @Override
  public Timestamp getTimestamp(String columnLabel) throws SQLException {
    return getTimestamp(columnIndex(columnLabel));
  }

  @Override
  public InputStream getAsciiStream(String columnLabel) throws SQLException {
    throw new NotImplementedException("ResultSet", "getAsciiStream");
  }

  @Override
  public InputStream getUnicodeStream(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getUnicodeStream");
  }

  @Override
  public InputStream getBinaryStream(String columnLabel) throws SQLException {
    throw new NotImplementedException("ResultSet", "getBinaryStream");
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    checkOpen();
    return null;
  }

  @Override
  public void clearWarnings() throws SQLException {
    checkOpen();
  }

  @Override
  public String getCursorName() throws SQLException {
    throw new SQLFeatureNotSupportedException("getCursorName");
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    return resultSetMetaData;
  }

  @Override
  public Object getObject(int columnIndex) throws SQLException {
    int sqlType = resultSetMetaData.getColumnType(columnIndex);
    switch (sqlType) {
      case java.sql.Types.DATE:
        return getDate(columnIndex);
      case java.sql.Types.TIME:
        return getTime(columnIndex);
      case java.sql.Types.TIMESTAMP:
        return getTimestamp(columnIndex);
      case java.sql.Types.ARRAY:
        return getArray(columnIndex);
      case java.sql.Types.DECIMAL:
        return getBigDecimal(columnIndex);
      case java.sql.Types.JAVA_OBJECT:
      default:
        // XXX TODO
    }
    return column(columnIndex);
  }

  @Override
  public Object getObject(String columnLabel) throws SQLException {
    return getObject(columnIndex(columnLabel));
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    checkOpen();
    return columnIndex(columnLabel);
  }

  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException {
    throw new NotImplementedException("ResultSet", "getCharacterStream");
  }

  @Override
  public Reader getCharacterStream(String columnLabel) throws SQLException {
    throw new NotImplementedException("ResultSet", "getCharacterStream");
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    Object value = column(columnIndex);
    if (value == null) {
      return null;
    }

    return new BigDecimal(String.valueOf(value));
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    return getBigDecimal(columnIndex(columnLabel));
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    throw new SQLFeatureNotSupportedException("isBeforeFirst");
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    throw new SQLFeatureNotSupportedException("isAfterLast");
  }

  @Override
  public boolean isFirst() throws SQLException {
    throw new SQLFeatureNotSupportedException("isFirst");
  }

  @Override
  public boolean isLast() throws SQLException {
    throw new SQLFeatureNotSupportedException("isLast");
  }

  @Override
  public void beforeFirst() throws SQLException {
    throw new SQLFeatureNotSupportedException("beforeFirst");
  }

  @Override
  public void afterLast() throws SQLException {
    throw new SQLFeatureNotSupportedException("afterLast");
  }

  @Override
  public boolean first() throws SQLException {
    throw new SQLFeatureNotSupportedException("first");
  }

  @Override
  public boolean last() throws SQLException {
    throw new SQLFeatureNotSupportedException("last");
  }

  @Override
  public int getRow() throws SQLException {
    throw new SQLFeatureNotSupportedException("getRow");
  }

  @Override
  public boolean absolute(int row) throws SQLException {
    throw new SQLFeatureNotSupportedException("absolute");
  }

  @Override
  public boolean relative(int rows) throws SQLException {
    throw new SQLFeatureNotSupportedException("relative");
  }

  @Override
  public boolean previous() throws SQLException {
    throw new SQLFeatureNotSupportedException("previous");
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    checkOpen();
    if (direction != FETCH_FORWARD) {
      throw new SQLException("Fetch direction must be FETCH_FORWARD");
    }
  }

  @Override
  public int getFetchDirection() throws SQLException {
    checkOpen();
    return FETCH_FORWARD;
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    checkOpen();
    if (rows < 0) {
      throw new SQLException("Rows is negative");
    }
    // fetch size is ignored
  }

  @Override
  public int getFetchSize() throws SQLException {
    checkOpen();
    // fetch size is ignored
    return 0;
  }

  @Override
  public int getType() throws SQLException {
    checkOpen();
    return TYPE_FORWARD_ONLY;
  }

  @Override
  public int getConcurrency() throws SQLException {
    checkOpen();
    return CONCUR_READ_ONLY;
  }

  @Override
  public boolean rowUpdated() throws SQLException {
    throw new SQLFeatureNotSupportedException("rowUpdated");
  }

  @Override
  public boolean rowInserted() throws SQLException {
    throw new SQLFeatureNotSupportedException("rowInserted");
  }

  @Override
  public boolean rowDeleted() throws SQLException {
    throw new SQLFeatureNotSupportedException("rowDeleted");
  }

  @Override
  public void updateNull(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNull");
  }

  @Override
  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBoolean");
  }

  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateByte");
  }

  @Override
  public void updateShort(int columnIndex, short x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateShort");
  }

  @Override
  public void updateInt(int columnIndex, int x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateInt");
  }

  @Override
  public void updateLong(int columnIndex, long x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateLong");
  }

  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateFloat");
  }

  @Override
  public void updateDouble(int columnIndex, double x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateDouble");
  }

  @Override
  public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBigDecimal");
  }

  @Override
  public void updateString(int columnIndex, String x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateString");
  }

  @Override
  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBytes");
  }

  @Override
  public void updateDate(int columnIndex, Date x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateDate");
  }

  @Override
  public void updateTime(int columnIndex, Time x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateTime");
  }

  @Override
  public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateTimestamp");
  }

  @Override
  public void updateAsciiStream(int columnIndex, InputStream x, int length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateAsciiStream");
  }

  @Override
  public void updateBinaryStream(int columnIndex, InputStream x, int length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBinaryStream");
  }

  @Override
  public void updateCharacterStream(int columnIndex, Reader x, int length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateCharacterStream");
  }

  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateObject");
  }

  @Override
  public void updateObject(int columnIndex, Object x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateObject");
  }

  @Override
  public void updateNull(String columnLabel)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNull");
  }

  @Override
  public void updateBoolean(String columnLabel, boolean x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBoolean");
  }

  @Override
  public void updateByte(String columnLabel, byte x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateByte");
  }

  @Override
  public void updateShort(String columnLabel, short x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateShort");
  }

  @Override
  public void updateInt(String columnLabel, int x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateInt");
  }

  @Override
  public void updateLong(String columnLabel, long x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateLong");
  }

  @Override
  public void updateFloat(String columnLabel, float x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateFloat");
  }

  @Override
  public void updateDouble(String columnLabel, double x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateDouble");
  }

  @Override
  public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBigDecimal");
  }

  @Override
  public void updateString(String columnLabel, String x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateString");
  }

  @Override
  public void updateBytes(String columnLabel, byte[] x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBytes");
  }

  @Override
  public void updateDate(String columnLabel, Date x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateDate");
  }

  @Override
  public void updateTime(String columnLabel, Time x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateTime");
  }

  @Override
  public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateTimestamp");
  }

  @Override
  public void updateAsciiStream(String columnLabel, InputStream x, int length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateAsciiStream");
  }

  @Override
  public void updateBinaryStream(String columnLabel, InputStream x, int length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBinaryStream");
  }

  @Override
  public void updateCharacterStream(String columnLabel, Reader reader, int length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateCharacterStream");
  }

  @Override
  public void updateObject(String columnLabel, Object x, int scaleOrLength)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateObject");
  }

  @Override
  public void updateObject(String columnLabel, Object x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateObject");
  }

  @Override
  public void insertRow()
      throws SQLException {
    throw new SQLFeatureNotSupportedException("insertRow");
  }

  @Override
  public void updateRow() throws SQLException {
    throw new SQLFeatureNotSupportedException("updateRow");
  }

  @Override
  public void deleteRow() throws SQLException {
    throw new SQLFeatureNotSupportedException("deleteRow");
  }

  @Override
  public void refreshRow() throws SQLException {
    throw new SQLFeatureNotSupportedException("refreshRow");
  }

  @Override
  public void cancelRowUpdates() throws SQLException {
    throw new SQLFeatureNotSupportedException("cancelRowUpdates");
  }

  @Override
  public void moveToInsertRow() throws SQLException {
    throw new SQLFeatureNotSupportedException("moveToInsertRow");
  }

  @Override
  public void moveToCurrentRow() throws SQLException {
    throw new SQLFeatureNotSupportedException("moveToCurrentRow");
  }

  @Override
  public Statement getStatement() throws SQLException {
    throw new NotImplementedException("ResultSet", "getStatement");
  }

  @Override
  public Object getObject(int columnIndex, Map<String, Class<?>> map)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("getObject");
  }

  @Override
  public Ref getRef(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getRef");
  }

  @Override
  public Blob getBlob(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getBlob");
  }

  @Override
  public Clob getClob(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getClob");
  }

  @Override
  public Array getArray(int columnIndex) throws SQLException {
    JsonNode value = column(columnIndex);
    if (value == null) {
      return null;
    }

    ArrayList<JsonNode> arr = new ArrayList<JsonNode>();
    for (Iterator<JsonNode> iter = value.iterator(); iter.hasNext(); ) {
      arr.add(iter.next());
    }
    return new RocksetArray(arr);
  }

  @Override
  public Object getObject(String columnLabel, Map<String, Class<?>> map)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("getObject");
  }

  @Override
  public Ref getRef(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getRef");
  }

  @Override
  public Blob getBlob(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getBlob");
  }

  @Override
  public Clob getClob(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getClob");
  }

  @Override
  public Array getArray(String columnLabel) throws SQLException {
    return getArray(columnIndex(columnLabel));
  }

  @Override
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    return getDate(columnIndex, DateTimeZone.forTimeZone(cal.getTimeZone()));
  }

  @Override
  public Date getDate(String columnLabel, Calendar cal) throws SQLException {
    return getDate(columnIndex(columnLabel), cal);
  }

  @Override
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    return getTime(columnIndex, DateTimeZone.forTimeZone(cal.getTimeZone()));
  }

  @Override
  public Time getTime(String columnLabel, Calendar cal) throws SQLException {
    return getTime(columnIndex(columnLabel), cal);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    return getTimestamp(columnIndex, DateTimeZone.forTimeZone(cal.getTimeZone()));
  }

  @Override
  public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
    return getTimestamp(columnIndex(columnLabel), cal);
  }

  @Override
  public URL getURL(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getURL");
  }

  @Override
  public URL getURL(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getURL");
  }

  @Override
  public void updateRef(int columnIndex, Ref x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateRef");
  }

  @Override
  public void updateRef(String columnLabel, Ref x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateRef");
  }

  @Override
  public void updateBlob(int columnIndex, Blob x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBlob");
  }

  @Override
  public void updateBlob(String columnLabel, Blob x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBlob");
  }

  @Override
  public void updateClob(int columnIndex, Clob x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateClob");
  }

  @Override
  public void updateClob(String columnLabel, Clob x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateClob");
  }

  @Override
  public void updateArray(int columnIndex, Array x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateArray");
  }

  @Override
  public void updateArray(String columnLabel, Array x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateArray");
  }

  @Override
  public RowId getRowId(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getRowId");
  }

  @Override
  public RowId getRowId(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getRowId");
  }

  @Override
  public void updateRowId(int columnIndex, RowId x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateRowId");
  }

  @Override
  public void updateRowId(String columnLabel, RowId x) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateRowId");
  }

  @Override
  public int getHoldability() throws SQLException {
    checkOpen();
    return ResultSet.HOLD_CURSORS_OVER_COMMIT;
  }

  @Override
  public boolean isClosed() throws SQLException {
    return closed.get();
  }

  @Override
  public void updateNString(int columnIndex, String nstring) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNString");
  }

  @Override
  public void updateNString(String columnLabel, String nstring) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNString");
  }

  @Override
  public void updateNClob(int columnIndex, NClob nclob) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNClob");
  }

  @Override
  public void updateNClob(String columnLabel, NClob nclob) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNClob");
  }

  @Override
  public NClob getNClob(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getNClob");
  }

  @Override
  public NClob getNClob(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getNClob");
  }

  @Override
  public SQLXML getSQLXML(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getSQLXML");
  }

  @Override
  public SQLXML getSQLXML(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getSQLXML");
  }

  @Override
  public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateSQLXML");
  }

  @Override
  public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
    throw new SQLFeatureNotSupportedException("updateSQLXML");
  }

  @Override
  public String getNString(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getNString");
  }

  @Override
  public String getNString(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getNString");
  }

  @Override
  public Reader getNCharacterStream(int columnIndex) throws SQLException {
    throw new SQLFeatureNotSupportedException("getNCharacterStream");
  }

  @Override
  public Reader getNCharacterStream(String columnLabel) throws SQLException {
    throw new SQLFeatureNotSupportedException("getNCharacterStream");
  }

  @Override
  public void updateNCharacterStream(int columnIndex, Reader x, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNCharacterStream");
  }

  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNCharacterStream");
  }

  @Override
  public void updateAsciiStream(int columnIndex, InputStream x, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateAsciiStream");
  }

  @Override
  public void updateBinaryStream(int columnIndex, InputStream x, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBinaryStream");
  }

  @Override
  public void updateCharacterStream(int columnIndex, Reader x, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateCharacterStream");
  }

  @Override
  public void updateAsciiStream(String columnLabel, InputStream x, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateAsciiStream");
  }

  @Override
  public void updateBinaryStream(String columnLabel, InputStream x, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBinaryStream");
  }

  @Override
  public void updateCharacterStream(String columnLabel, Reader reader, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateCharacterStream");
  }

  @Override
  public void updateBlob(int columnIndex, InputStream inputStream, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBlob");
  }

  @Override
  public void updateBlob(String columnLabel, InputStream inputStream, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBlob");
  }

  @Override
  public void updateClob(int columnIndex, Reader reader, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateClob");
  }

  @Override
  public void updateClob(String columnLabel, Reader reader, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateClob");
  }

  @Override
  public void updateNClob(int columnIndex, Reader reader, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNClob");
  }

  @Override
  public void updateNClob(String columnLabel, Reader reader, long length)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNClob");
  }

  @Override
  public void updateNCharacterStream(int columnIndex, Reader x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNCharacterStream");
  }

  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNCharacterStream");
  }

  @Override
  public void updateAsciiStream(int columnIndex, InputStream x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateAsciiStream");
  }

  @Override
  public void updateBinaryStream(int columnIndex, InputStream x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBinaryStream");
  }

  @Override
  public void updateCharacterStream(int columnIndex, Reader x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateCharacterStream");
  }

  @Override
  public void updateAsciiStream(String columnLabel, InputStream x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateAsciiStream");
  }

  @Override
  public void updateBinaryStream(String columnLabel, InputStream x)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBinaryStream");
  }

  @Override
  public void updateCharacterStream(String columnLabel, Reader reader)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateCharacterStream");
  }

  @Override
  public void updateBlob(int columnIndex, InputStream inputStream)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBlob");
  }

  @Override
  public void updateBlob(String columnLabel, InputStream inputStream)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateBlob");
  }

  @Override
  public void updateClob(int columnIndex, Reader reader)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateClob");
  }

  @Override
  public void updateClob(String columnLabel, Reader reader)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateClob");
  }

  @Override
  public void updateNClob(int columnIndex, Reader reader)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNClob");
  }

  @Override
  public void updateNClob(String columnLabel, Reader reader)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("updateNClob");
  }

  @Override
  public <T> T getObject(int columnIndex, Class<T> type)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("getObject");
  }

  @Override
  public <T> T getObject(String columnLabel, Class<T> type)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("getObject");
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T unwrap(Class<T> iface)
      throws SQLException {
    if (isWrapperFor(iface)) {
      return (T) this;
    }
    throw new SQLException("No wrapper for " + iface);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface)
      throws SQLException {
    return iface.isInstance(this);
  }

  private void checkOpen() throws SQLException {
    if (isClosed()) {
      throw new SQLException("ResultSet is closed");
    }
  }

  private void checkValidRow() throws SQLException {
    int cur = rowIndex.get();
    if (cur >= this.totalRows) {
      throw new SQLException("Not on a valid row "
          + " current row " + cur + " total " + this.totalRows);
    }
  }

  private JsonNode column(int index) throws SQLException {
    checkOpen();
    checkValidRow();
    if ((index <= 0) || (index > this.columnCount)) {
      throw new SQLException("Invalid column index: " + index);
    }
    String columnName = columnInfo(index).getName();

    // extract the row
    try {
      ObjectMapper mapper = new ObjectMapper();
      Object onedoc = resultSet.get(rowIndex.get());
      JsonNode docRootNode = mapper.readTree(mapper.writeValueAsString(onedoc));
      return docRootNode.get(columnName);
    } catch (Exception e) {
      throw new SQLException("Error processing column index " + index
          + " exception " + e.getMessage());
    }
  }

  private Column columnInfo(int index) throws SQLException {
    checkOpen();
    checkValidRow();
    if ((index <= 0) || (index > this.columnCount)) {
      throw new SQLException("Invalid column index: " + index);
    }
    return this.columns.get(index - 1);
  }

  private JsonNode column(String label) throws SQLException {
    return column(columnIndex(label));
  }

  private int columnIndex(String label) throws SQLException {
    if (label == null) {
      throw new SQLException("Column label is null");
    }
    Integer index = fieldMap.get(label.toLowerCase(ENGLISH));
    if (index == null) {
      throw new SQLException("Invalid column label: " + label);
    }
    return index;
  }

  private Time getTime(int columnIndex, DateTimeZone localTimeZone) throws SQLException {
    Object value = column(columnIndex);
    if (value == null) {
      return null;
    }

    Column columnInfo = columnInfo(columnIndex);
    if (columnInfo.getType() == Column.ColumnTypes.TIME) {
      String time = ((JsonNode) value).get("value").asText();
      try {
        return Time.valueOf(time);
      } catch (IllegalArgumentException e) {
        throw new SQLException("Invalid time from server: " + time, e);
      }
    }
    throw new IllegalArgumentException("Expected column to be a time type but is "
            + columnInfo.getType());
  }

  private Timestamp getTimestamp(int columnIndex, DateTimeZone localTimeZone)
      throws SQLException {
    Object value = column(columnIndex);
    if (value == null) {
      return null;
    }

    Column columnInfo = columnInfo(columnIndex);
    if (columnInfo.getType() == Column.ColumnTypes.TIMESTAMP) {
      try {
        return new Timestamp(TIMESTAMP_FORMATTER.withZone(localTimeZone).parseMillis(
                    value.toString()));
      } catch (IllegalArgumentException e) {
        throw new SQLException("Invalid timestamp from server: " + value, e);
      }
    }
    throw new IllegalArgumentException("Expected column to be a timestamp type but is "
            + columnInfo.getType());
  }

  private static Number toNumber(Object value) throws SQLException {
    if (value == null) {
      return 0;
    }
    if (value instanceof NumericNode) {
      return (Number) (((NumericNode)value).longValue());
    }
    if (value instanceof BooleanNode) {
      BooleanNode n = (BooleanNode)(value);
      return (Number) (n.asBoolean() ? 1 : 0);
    }

    throw new SQLException("Value is not a number: " + value.getClass().getCanonicalName());
  }

  private static List<Column> getColumns(QueryResponse response) throws SQLException {
    List<Column> out = new ArrayList<Column>();
    ObjectMapper mapper = new ObjectMapper();

    try {
      if (response.getFields() != null && response.getFields().size() > 0) {
        logger.info("Extracting column information from explicit fields");
        for (QueryFieldType field: response.getFields()) {
          Column.ColumnTypes valueType = Column.ColumnTypes.fromValue(field.getType());
          Column c = new Column(field.getName(), valueType);
          out.add(c);
        }
      } else if (response.getResults().size() > 0) {
        // If the server has not filled up the field types, then extract it from
        // the first record in the result set.
        logger.info("Extracting column information from first record in resultset");
        Object onedoc = response.getResults().get(0);
        JsonNode docRootNode = mapper.readTree(mapper.writeValueAsString(onedoc));

        Iterator<Map.Entry<String,JsonNode>> fields = docRootNode.fields();
        while (fields.hasNext()) {
          Map.Entry<String, JsonNode> field = fields.next();
          JsonNode value = field.getValue();
          Column.ColumnTypes type = Column.ColumnTypes.fromValue(value.getNodeType().toString());
          if (type.equals(Column.ColumnTypes.OBJECT)) {
            if (value.get("__rockset_type") != null) {
              type = Column.ColumnTypes.fromValue(value.get("__rockset_type").asText());
            }
          }

          Column c = new Column(field.getKey(), type);
          out.add(c);
        }
      }
      return out;
    } catch (Exception e) {
      throw new SQLException("Error processing first row to extract column info "
          + " exception " + e.getMessage());
    }
  }

  private static Map<String, Integer> getFieldMap(List<Column> columns) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < columns.size(); i++) {
      String name = columns.get(i).getName().toLowerCase(ENGLISH);
      if (!map.containsKey(name)) {
        map.put(name, i + 1);
        // logger.info("Column " + name + " index " + i);
      }
    }
    return ImmutableMap.copyOf(map);
  }
}
