/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rockset.jdbc;

import static com.google.common.base.Strings.repeat;
import static com.google.common.primitives.Ints.asList;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import com.rockset.client.RocksetClient;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestJdbcPreparedStatement {
  // JDBC driver name and database URL
  private static final String JDBC_DRIVER = FirstExample.JDBC_DRIVER;
  private static final String DB_URL = FirstExample.DB_URL;

  // store credentials for accessing rockset service
  private Properties property;

  // A rockset client to directly interact with Rockset service
  private RocksetClient testClient;

  @BeforeSuite
  public void setUp() throws Exception {
    String apiKey = System.getenv("ROCKSET_APIKEY");
    String apiServer = System.getenv("ROCKSET_APISERVER");
    if (apiKey == null || apiServer == null) {
      throw new Exception(
          "To run unit tests, please set ROCKSET_APIKEY and ROCKSET_APISERVER "
              + "environment variables.");
    }
    this.property = new Properties();
    this.property.setProperty("apiKey", apiKey);

    if (apiServer.toLowerCase().contains("https://")) apiServer = apiServer.replace("https://", "");
    this.property.setProperty("apiServer", apiServer);

    // create the Rockset test client
    testClient =
        new RocksetClient(property.getProperty("apiKey"), property.getProperty("apiServer"));
    // Register JDBC driver
    Class.forName(JDBC_DRIVER);
  }

  @Test
  public void testDumbQuery() throws Exception {
    String sql = "SELECT 1";

    try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, 123);
      statement.setString(2, "hello");

      // find Metadata even before executing query
      ResultSetMetaData meta = statement.getMetaData();

      try (ResultSet rs = statement.executeQuery()) {
        assertTrue(rs.next());
        assertEquals(rs.getInt(1), 1);
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testExecuteTimeQuery() throws Exception {
    // from console:
    // 1 select cast('12:34' as time)    -> __rockset_type= 'TIME' / value = '12:34:00'
    // 2 select cast('12:34:56' as time) -> __rockset_type= 'TIME' / value = '12:34:56'
    // 3 select cast('12:34:56.1' as time) -> __rockset_type= 'TIME' / value = '12:34:56.1'
    // 4 select cast('12:34:56.123' as time) -> __rockset_type= 'TIME' / value = '12:34:56.123'
    // 5 select cast('12:34:56.123456' as time) -> __rockset_type= 'TIME' / value = '12:34:56.123456'
    // 6 select cast('12:34:56.1234567890' as time) -> __rockset_type= 'TIME' / value = '12:34:56.123456'

    String sql = "SELECT CAST(:1 AS TIME), CAST(:2 AS TIME), CAST(:3 AS TIME), CAST(:4 AS TIME), CAST(:5 AS TIME), CAST(:6 AS TIME)";

    try (Connection connection = createConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, "12:34");
      statement.setString(2, "12:34:56");
      statement.setString(3,  "12:34:56.1");
      statement.setString(4, "12:34:56.123");
      statement.setString(5, "12:34:56.123456");
      statement.setString(6, "12:34:56.1234567890");

      try (ResultSet rs = statement.executeQuery()) {
        assertTrue(rs.next());
        assertEquals(rs.getTime(1), Time.valueOf("12:34:00"));
        assertEquals(rs.getTime(2), Time.valueOf("12:34:56"));
        assertEquals(rs.getTime(3), Time.valueOf("12:34:56"));
        assertEquals(rs.getTime(4), Time.valueOf("12:34:56"));
        assertEquals(rs.getTime(5), Time.valueOf("12:34:56"));
        assertEquals(rs.getTime(6), Time.valueOf("12:34:56"));
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testExecuteQuery() throws Exception {
    String sql = "SELECT :1, :2";

    try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, 123);
      statement.setString(2, "hello");

      try (ResultSet rs = statement.executeQuery()) {
        assertTrue(rs.next());
        assertEquals(rs.getInt(1), 123);
        assertEquals(rs.getString(2), "hello");
        assertFalse(rs.next());
      }

      assertTrue(statement.execute());
      try (ResultSet rs = statement.getResultSet()) {
        assertTrue(rs.next());
        assertEquals(rs.getInt(1), 123);
        assertEquals(rs.getString(2), "hello");
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testDeallocate() throws Exception {
    try (Connection connection = createConnection()) {
      for (int i = 0; i < 200; i++) {
        try {
          connection.prepareStatement("SELECT '" + repeat("a", 300) + "'").close();
        } catch (Exception e) {
          throw new RuntimeException("Failed at " + i, e);
        }
      }
    }
  }

  @Test
  public void testPrepareMultiple() throws Exception {
    try (Connection connection = createConnection();
        PreparedStatement statement1 = connection.prepareStatement("SELECT 123");
        PreparedStatement statement2 = connection.prepareStatement("SELECT 456")) {
      try (ResultSet rs = statement1.executeQuery()) {
        assertTrue(rs.next());
        assertEquals(rs.getLong(1), 123);
        assertFalse(rs.next());
      }

      try (ResultSet rs = statement2.executeQuery()) {
        assertTrue(rs.next());
        assertEquals(rs.getLong(1), 456);
        assertFalse(rs.next());
      }
    }
  }

  // @Test
  public void testSetNull() throws Exception {
    assertSetNull(Types.BOOLEAN);
    assertSetNull(Types.BIT, Types.BOOLEAN);
    assertSetNull(Types.TINYINT);
    assertSetNull(Types.SMALLINT);
    assertSetNull(Types.INTEGER);
    assertSetNull(Types.BIGINT);
    assertSetNull(Types.REAL);
    assertSetNull(Types.FLOAT, Types.REAL);
    assertSetNull(Types.DECIMAL);
    assertSetNull(Types.NUMERIC, Types.DECIMAL);
    assertSetNull(Types.CHAR);
    assertSetNull(Types.NCHAR, Types.CHAR);
    assertSetNull(Types.VARCHAR, Types.VARCHAR);
    assertSetNull(Types.NVARCHAR, Types.VARCHAR);
    assertSetNull(Types.LONGVARCHAR, Types.VARCHAR);
    assertSetNull(Types.VARCHAR, Types.VARCHAR);
    assertSetNull(Types.CLOB, Types.VARCHAR);
    assertSetNull(Types.NCLOB, Types.VARCHAR);
    assertSetNull(Types.VARBINARY, Types.VARBINARY);
    assertSetNull(Types.VARBINARY);
    assertSetNull(Types.BLOB, Types.VARBINARY);
    assertSetNull(Types.DATE);
    assertSetNull(Types.TIME);
    assertSetNull(Types.TIMESTAMP);
    assertSetNull(Types.NULL);
  }

  private void assertSetNull(int sqlType) throws SQLException {
    assertSetNull(sqlType, sqlType);
  }

  private void assertSetNull(int sqlType, int expectedSqlType) throws SQLException {
    try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT :1")) {
      statement.setNull(1, sqlType);

      try (ResultSet rs = statement.executeQuery()) {
        assertTrue(rs.next());
        assertNull(rs.getObject(1));
        assertTrue(rs.wasNull());
        assertFalse(rs.next());

        assertEquals(rs.getMetaData().getColumnType(1), expectedSqlType);
      }
    }
  }

  // @Test
  public void testConvertBoolean() throws SQLException {
    assertParameter(true, Types.BOOLEAN, (ps, i) -> ps.setBoolean(i, true));
    assertParameter(false, Types.BOOLEAN, (ps, i) -> ps.setBoolean(i, false));
    assertParameter(true, Types.BOOLEAN, (ps, i) -> ps.setObject(i, true));
    assertParameter(false, Types.BOOLEAN, (ps, i) -> ps.setObject(i, false));

    for (int type : asList(Types.BOOLEAN, Types.BIT)) {
      assertParameter(true, Types.BOOLEAN, (ps, i) -> ps.setObject(i, true, type));
      assertParameter(false, Types.BOOLEAN, (ps, i) -> ps.setObject(i, false, type));
      assertParameter(true, Types.BOOLEAN, (ps, i) -> ps.setObject(i, 13, type));
      assertParameter(false, Types.BOOLEAN, (ps, i) -> ps.setObject(i, 0, type));
      assertParameter(true, Types.BOOLEAN, (ps, i) -> ps.setObject(i, "1", type));
      assertParameter(true, Types.BOOLEAN, (ps, i) -> ps.setObject(i, "true", type));
      assertParameter(false, Types.BOOLEAN, (ps, i) -> ps.setObject(i, "0", type));
      assertParameter(false, Types.BOOLEAN, (ps, i) -> ps.setObject(i, "false", type));
    }
  }

  // @Test
  public void testConvertTinyint() throws SQLException {
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setByte(i, (byte) 123));
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, (byte) 123));
    assertParameter(
        (byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, (byte) 123, Types.TINYINT));
    assertParameter(
        (byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, (short) 123, Types.TINYINT));
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, 123, Types.TINYINT));
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, 123L, Types.TINYINT));
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, 123.9f, Types.TINYINT));
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, 123.9d, Types.TINYINT));
    assertParameter(
        (byte) 123,
        Types.TINYINT,
        (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), Types.TINYINT));
    assertParameter(
        (byte) 123,
        Types.TINYINT,
        (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), Types.TINYINT));
    assertParameter(
        (byte) 123,
        Types.TINYINT,
        (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), Types.TINYINT));
    assertParameter((byte) 123, Types.TINYINT, (ps, i) -> ps.setObject(i, "123", Types.TINYINT));
    assertParameter((byte) 1, Types.TINYINT, (ps, i) -> ps.setObject(i, true, Types.TINYINT));
    assertParameter((byte) 0, Types.TINYINT, (ps, i) -> ps.setObject(i, false, Types.TINYINT));
  }

  // @Test
  public void testConvertSmallint() throws SQLException {
    assertParameter((short) 123, Types.SMALLINT, (ps, i) -> ps.setShort(i, (short) 123));
    assertParameter((short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, (short) 123));
    assertParameter(
        (short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, (byte) 123, Types.SMALLINT));
    assertParameter(
        (short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, (short) 123, Types.SMALLINT));
    assertParameter((short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, 123, Types.SMALLINT));
    assertParameter((short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, 123L, Types.SMALLINT));
    assertParameter(
        (short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, 123.9f, Types.SMALLINT));
    assertParameter(
        (short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, 123.9d, Types.SMALLINT));
    assertParameter(
        (short) 123,
        Types.SMALLINT,
        (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), Types.SMALLINT));
    assertParameter(
        (short) 123,
        Types.SMALLINT,
        (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), Types.SMALLINT));
    assertParameter(
        (short) 123,
        Types.SMALLINT,
        (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), Types.SMALLINT));
    assertParameter((short) 123, Types.SMALLINT, (ps, i) -> ps.setObject(i, "123", Types.SMALLINT));
    assertParameter((short) 1, Types.SMALLINT, (ps, i) -> ps.setObject(i, true, Types.SMALLINT));
    assertParameter((short) 0, Types.SMALLINT, (ps, i) -> ps.setObject(i, false, Types.SMALLINT));
  }

  // @Test
  public void testConvertInteger() throws SQLException {
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setInt(i, 123));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, 123));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, (byte) 123, Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, (byte) 123, Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, (short) 123, Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, 123, Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, 123L, Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, 123.9f, Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, 123.9d, Types.INTEGER));
    assertParameter(
        123, Types.INTEGER, (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), Types.INTEGER));
    assertParameter(
        123, Types.INTEGER, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), Types.INTEGER));
    assertParameter(
        123, Types.INTEGER, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), Types.INTEGER));
    assertParameter(123, Types.INTEGER, (ps, i) -> ps.setObject(i, "123", Types.INTEGER));
    assertParameter(1, Types.INTEGER, (ps, i) -> ps.setObject(i, true, Types.INTEGER));
    assertParameter(0, Types.INTEGER, (ps, i) -> ps.setObject(i, false, Types.INTEGER));
  }

  // @Test
  public void testConvertBigint() throws SQLException {
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setLong(i, 123L));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, 123L));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, (byte) 123, Types.BIGINT));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, (short) 123, Types.BIGINT));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, 123, Types.BIGINT));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, 123L, Types.BIGINT));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, 123.9f, Types.BIGINT));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, 123.9d, Types.BIGINT));
    assertParameter(
        123L, Types.BIGINT, (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), Types.BIGINT));
    assertParameter(
        123L, Types.BIGINT, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), Types.BIGINT));
    assertParameter(
        123L, Types.BIGINT, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), Types.BIGINT));
    assertParameter(123L, Types.BIGINT, (ps, i) -> ps.setObject(i, "123", Types.BIGINT));
    assertParameter(1L, Types.BIGINT, (ps, i) -> ps.setObject(i, true, Types.BIGINT));
    assertParameter(0L, Types.BIGINT, (ps, i) -> ps.setObject(i, false, Types.BIGINT));
  }

  // @Test
  public void testConvertReal() throws SQLException {
    assertParameter(4.2f, Types.REAL, (ps, i) -> ps.setFloat(i, 4.2f));
    assertParameter(4.2f, Types.REAL, (ps, i) -> ps.setObject(i, 4.2f));

    for (int type : asList(Types.REAL, Types.FLOAT)) {
      assertParameter(123.0f, Types.REAL, (ps, i) -> ps.setObject(i, (byte) 123, type));
      assertParameter(123.0f, Types.REAL, (ps, i) -> ps.setObject(i, (short) 123, type));
      assertParameter(123.0f, Types.REAL, (ps, i) -> ps.setObject(i, 123, type));
      assertParameter(123.0f, Types.REAL, (ps, i) -> ps.setObject(i, 123L, type));
      assertParameter(123.9f, Types.REAL, (ps, i) -> ps.setObject(i, 123.9f, type));
      assertParameter(123.9f, Types.REAL, (ps, i) -> ps.setObject(i, 123.9d, type));
      assertParameter(
          123.0f, Types.REAL, (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), type));
      assertParameter(
          123.0f, Types.REAL, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), type));
      assertParameter(
          123.9f, Types.REAL, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), type));
      assertParameter(4.2f, Types.REAL, (ps, i) -> ps.setObject(i, "4.2", type));
      assertParameter(1.0f, Types.REAL, (ps, i) -> ps.setObject(i, true, type));
      assertParameter(0.0f, Types.REAL, (ps, i) -> ps.setObject(i, false, type));
    }
  }

  // @Test
  public void testConvertDouble() throws SQLException {
    assertParameter(4.2d, Types.DOUBLE, (ps, i) -> ps.setDouble(i, 4.2d));
    assertParameter(4.2d, Types.DOUBLE, (ps, i) -> ps.setObject(i, 4.2d));
    assertParameter(123.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, (byte) 123, Types.DOUBLE));
    assertParameter(123.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, (short) 123, Types.DOUBLE));
    assertParameter(123.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, 123, Types.DOUBLE));
    assertParameter(123.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, 123L, Types.DOUBLE));
    assertParameter(
        (double) 123.9f, Types.DOUBLE, (ps, i) -> ps.setObject(i, 123.9f, Types.DOUBLE));
    assertParameter(123.9d, Types.DOUBLE, (ps, i) -> ps.setObject(i, 123.9d, Types.DOUBLE));
    assertParameter(
        123.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), Types.DOUBLE));
    assertParameter(
        123.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), Types.DOUBLE));
    assertParameter(
        123.9d, Types.DOUBLE, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), Types.DOUBLE));
    assertParameter(4.2d, Types.DOUBLE, (ps, i) -> ps.setObject(i, "4.2", Types.DOUBLE));
    assertParameter(1.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, true, Types.DOUBLE));
    assertParameter(0.0d, Types.DOUBLE, (ps, i) -> ps.setObject(i, false, Types.DOUBLE));
  }

  // @Test
  public void testConvertDecimal() throws SQLException {
    assertParameter(
        BigDecimal.valueOf(123),
        Types.DECIMAL,
        (ps, i) -> ps.setBigDecimal(i, BigDecimal.valueOf(123)));
    assertParameter(
        BigDecimal.valueOf(123),
        Types.DECIMAL,
        (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123)));

    for (int type : asList(Types.DECIMAL, Types.NUMERIC)) {
      assertParameter(
          BigDecimal.valueOf(123), Types.DECIMAL, (ps, i) -> ps.setObject(i, (byte) 123, type));
      assertParameter(
          BigDecimal.valueOf(123), Types.DECIMAL, (ps, i) -> ps.setObject(i, (short) 123, type));
      assertParameter(
          BigDecimal.valueOf(123), Types.DECIMAL, (ps, i) -> ps.setObject(i, 123, type));
      assertParameter(
          BigDecimal.valueOf(123), Types.DECIMAL, (ps, i) -> ps.setObject(i, 123L, type));
      assertParameter(
          BigDecimal.valueOf(123.9f), Types.DECIMAL, (ps, i) -> ps.setObject(i, 123.9f, type));
      assertParameter(
          BigDecimal.valueOf(123.9d), Types.DECIMAL, (ps, i) -> ps.setObject(i, 123.9d, type));
      assertParameter(
          BigDecimal.valueOf(123),
          Types.DECIMAL,
          (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), type));
      assertParameter(
          BigDecimal.valueOf(123),
          Types.DECIMAL,
          (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), type));
      assertParameter(
          BigDecimal.valueOf(123.9d),
          Types.DECIMAL,
          (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9d), type));
      assertParameter(
          BigDecimal.valueOf(123), Types.DECIMAL, (ps, i) -> ps.setObject(i, "123", type));
      assertParameter(BigDecimal.valueOf(1), Types.DECIMAL, (ps, i) -> ps.setObject(i, true, type));
      assertParameter(
          BigDecimal.valueOf(0), Types.DECIMAL, (ps, i) -> ps.setObject(i, false, type));
    }
  }

  // @Test
  public void testConvertVarchar() throws SQLException {
    assertParameter("hello", Types.VARCHAR, (ps, i) -> ps.setString(i, "hello"));
    assertParameter("hello", Types.VARCHAR, (ps, i) -> ps.setObject(i, "hello"));

    String unicodeAndNull = "abc'xyz\0\u2603\uD835\uDCABtest";
    assertParameter(unicodeAndNull, Types.VARCHAR, (ps, i) -> ps.setString(i, unicodeAndNull));

    for (int type :
        asList(
            Types.CHAR,
            Types.NCHAR,
            Types.VARCHAR,
            Types.NVARCHAR,
            Types.LONGVARCHAR,
            Types.LONGNVARCHAR)) {
      assertParameter("123", Types.VARCHAR, (ps, i) -> ps.setObject(i, (byte) 123, type));
      assertParameter("123", Types.VARCHAR, (ps, i) -> ps.setObject(i, (byte) 123, type));
      assertParameter("123", Types.VARCHAR, (ps, i) -> ps.setObject(i, (short) 123, type));
      assertParameter("123", Types.VARCHAR, (ps, i) -> ps.setObject(i, 123, type));
      assertParameter("123", Types.VARCHAR, (ps, i) -> ps.setObject(i, 123L, type));
      assertParameter("123.9", Types.VARCHAR, (ps, i) -> ps.setObject(i, 123.9f, type));
      assertParameter("123.9", Types.VARCHAR, (ps, i) -> ps.setObject(i, 123.9d, type));
      assertParameter(
          "123", Types.VARCHAR, (ps, i) -> ps.setObject(i, BigInteger.valueOf(123), type));
      assertParameter(
          "123", Types.VARCHAR, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123), type));
      assertParameter(
          "123.9", Types.VARCHAR, (ps, i) -> ps.setObject(i, BigDecimal.valueOf(123.9), type));
      assertParameter("hello", Types.VARCHAR, (ps, i) -> ps.setObject(i, "hello", type));
      assertParameter("true", Types.VARCHAR, (ps, i) -> ps.setObject(i, true, type));
      assertParameter("false", Types.VARCHAR, (ps, i) -> ps.setObject(i, false, type));
    }
  }

  // @Test
  public void testConvertVarbinary() throws SQLException {
    String value = "abc\0xyz";
    byte[] bytes = value.getBytes(UTF_8);

    assertParameter(bytes, Types.VARBINARY, (ps, i) -> ps.setBytes(i, bytes));
    assertParameter(bytes, Types.VARBINARY, (ps, i) -> ps.setObject(i, bytes));

    for (int type : asList(Types.BINARY, Types.VARBINARY, Types.LONGVARBINARY)) {
      assertParameter(bytes, Types.VARBINARY, (ps, i) -> ps.setObject(i, bytes, type));
      assertParameter(bytes, Types.VARBINARY, (ps, i) -> ps.setObject(i, value, type));
    }
  }

  // @Test
  public void testConvertDate() throws SQLException {
    LocalDate date = LocalDate.of(2001, 5, 6);
    Date sqlDate = Date.valueOf(date);
    java.util.Date javaDate = new java.util.Date(sqlDate.getTime());
    LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(12, 34, 56));
    Timestamp sqlTimestamp = Timestamp.valueOf(dateTime);

    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setDate(i, sqlDate));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, sqlDate));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, sqlDate, Types.DATE));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, sqlTimestamp, Types.DATE));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, javaDate, Types.DATE));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, date, Types.DATE));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, dateTime, Types.DATE));
    assertParameter(sqlDate, Types.DATE, (ps, i) -> ps.setObject(i, "2001-05-06", Types.DATE));
  }

  // @Test
  public void testConvertTime() throws SQLException {
    LocalTime time = LocalTime.of(12, 34, 56);
    Time sqlTime = Time.valueOf(time);
    java.util.Date javaDate = new java.util.Date(sqlTime.getTime());
    LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(2001, 5, 6), time);
    Timestamp sqlTimestamp = Timestamp.valueOf(dateTime);

    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setTime(i, sqlTime));
    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setObject(i, sqlTime));
    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setObject(i, sqlTime, Types.TIME));
    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setObject(i, sqlTimestamp, Types.TIME));
    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setObject(i, javaDate, Types.TIME));
    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setObject(i, dateTime, Types.TIME));
    assertParameter(sqlTime, Types.TIME, (ps, i) -> ps.setObject(i, "12:34:56", Types.TIME));
  }

  // @Test
  public void testConvertTimestamp() throws SQLException {
    LocalDateTime dateTime = LocalDateTime.of(2001, 5, 6, 12, 34, 56);
    Date sqlDate = Date.valueOf(dateTime.toLocalDate());
    Time sqlTime = Time.valueOf(dateTime.toLocalTime());
    Timestamp sqlTimestamp = Timestamp.valueOf(dateTime);
    java.util.Date javaDate =
        java.util.Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

    assertParameter(sqlTimestamp, Types.TIMESTAMP, (ps, i) -> ps.setTimestamp(i, sqlTimestamp));
    assertParameter(sqlTimestamp, Types.TIMESTAMP, (ps, i) -> ps.setObject(i, sqlTimestamp));
    assertParameter(
        new Timestamp(sqlDate.getTime()),
        Types.TIMESTAMP,
        (ps, i) -> ps.setObject(i, sqlDate, Types.TIMESTAMP));
    assertParameter(
        new Timestamp(sqlTime.getTime()),
        Types.TIMESTAMP,
        (ps, i) -> ps.setObject(i, sqlTime, Types.TIMESTAMP));
    assertParameter(
        sqlTimestamp, Types.TIMESTAMP, (ps, i) -> ps.setObject(i, sqlTimestamp, Types.TIMESTAMP));
    assertParameter(
        sqlTimestamp, Types.TIMESTAMP, (ps, i) -> ps.setObject(i, javaDate, Types.TIMESTAMP));
    assertParameter(
        sqlTimestamp, Types.TIMESTAMP, (ps, i) -> ps.setObject(i, dateTime, Types.TIMESTAMP));
    assertParameter(
        sqlTimestamp,
        Types.TIMESTAMP,
        (ps, i) -> ps.setObject(i, "2001-05-06 12:34:56", Types.TIMESTAMP));
  }

  // @Test
  public void testInvalidConversions() {
    assertInvalidConversion(
        (ps, i) -> ps.setObject(i, String.class), "Unsupported object type: java.lang.Class");
    assertInvalidConversion(
        (ps, i) -> ps.setObject(i, String.class, Types.BIGINT),
        "Cannot convert instance of java.lang.Class to SQL type " + Types.BIGINT);
    assertInvalidConversion(
        (ps, i) -> ps.setObject(i, "abc", Types.SMALLINT),
        "Cannot convert instance of java.lang.String to SQL type " + Types.SMALLINT);
  }

  private void assertInvalidConversion(Binder binder, String message) {
    assertThatThrownBy(() -> assertParameter(null, Types.NULL, binder))
        .isInstanceOf(SQLException.class)
        .hasMessageContaining(message);
  }

  private void assertParameter(Object expectedValue, int expectedSqlType, Binder binder)
      throws SQLException {
    try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT :1")) {
      binder.bind(statement, 1);

      try (ResultSet rs = statement.executeQuery()) {
        assertTrue(rs.next());
        assertEquals(expectedValue, rs.getObject(1));
        assertFalse(rs.next());

        assertEquals(rs.getMetaData().getColumnType(1), expectedSqlType);
      }
    }
  }

  private interface Binder {
    void bind(PreparedStatement ps, int i) throws SQLException;
  }

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection(DB_URL, this.property);
  }
}
