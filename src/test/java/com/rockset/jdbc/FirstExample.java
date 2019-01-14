package com.rockset.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//
// An example that shows simple JDBC queries
//
public class FirstExample {

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.rockset.jdbc.RocksetDriver";  
  static final String DB_URL = "jdbc:rockset://";

  // store credentials for accessing rockset service
  private Properties property;

  @BeforeSuite
  public void setUp() throws Exception {
    String apikey = System.getenv("ROCKSET_APIKEY");
    String endpoint = System.getenv("ROCKSET_APISERVER");
    if (apikey == null || endpoint == null) {
      throw new Exception("If you want to run unit tests "
                          + "Please set ROCKSET_APIKEY and ROCKSET_APISERVER");
    }
    property = new Properties();
    property.setProperty("apikey", apikey);
    property.setProperty("endpoint", endpoint);

    // Register JDBC driver
    Class.forName(JDBC_DRIVER);
  }

  //
  // Check catalog names.
  // This call should return one record with with one column
  // TABLE_CATALOG
  //
  @Test
  public void testCatalog() throws Exception {
    System.out.println("testCatalog");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getCatalogs();
      int colIndex = rs.findColumn("TABLE_CAT");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(colIndex);
        Assert.assertTrue(value.equals("rockset"));
      }
      Assert.assertEquals(1, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check schema names.
  // This call should return one record with with two columns
  // TABLE_SCHEM & TABLE_CATALOG
  @Test
  public void testSchema() throws Exception {
    System.out.println("testSchema");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getSchemas();
      int colCatIndex = rs.findColumn("TABLE_CATALOG");
      int colSchemaIndex = rs.findColumn("TABLE_SCHEM");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(colSchemaIndex);
        Assert.assertTrue(value.equals("commons"));
        value = rs.getString(colCatIndex);
        Assert.assertTrue(value.equals("rockset"));
      }
      Assert.assertEquals(1, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check supported table types.
  // This call should return one record with with one column
  // TABLE_TYPE
  @Test
  public void testTableTypes() throws Exception {
    System.out.println("testTableTypes");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getTableTypes();
      int colIndex = rs.findColumn("TABLE_TYPE");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(colIndex);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(1, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check getProcedures.
  // This call should return 0 record with with 9 columns
  // PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME, null,
  // null, null, REMARKS, PROCEDURE_TYPE, SPECIFIC_NAME
  //
  @Test
  public void testStoredProcedures() throws Exception {
    System.out.println("testStoredProcedures");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getProcedures(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*");
      int c1 = rs.findColumn("PROCEDURE_CAT");
      int c2 = rs.findColumn("PROCEDURE_SCHEM");
      int c3 = rs.findColumn("PROCEDURE_NAME");
      int c4 = rs.findColumn("REMARKS");
      int c5 = rs.findColumn("PROCEDURE_TYPE");
      int c6 = rs.findColumn("SPECIFIC_NAME");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check getProcedureColumns.
  // This call should return 0 record with 20 columns
  //
  @Test
  public void testStoredProceduresColumns() throws Exception {
    System.out.println("testStoredProceduresColumns");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getProcedureColumns(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*", "*");
      int c1 = rs.findColumn("PROCEDURE_CAT");
      int c2 = rs.findColumn("PROCEDURE_SCHEM");
      int c3 = rs.findColumn("PROCEDURE_NAME");
      int c4 = rs.findColumn("RADIX");
      int c5 = rs.findColumn("SQL_DATA_TYPE");
      int c6 = rs.findColumn("IS_NULLABLE");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check get user defined types.
  // This call should return 0 record with with 7 columns
  //
  @Test
  public void testUdts() throws Exception {
    System.out.println("testUdts");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getUDTs(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*", null);
      int c1 = rs.findColumn("TYPE_CAT");
      int c2 = rs.findColumn("TYPE_SCHEM");
      int c3 = rs.findColumn("TYPE_NAME");
      int c4 = rs.findColumn("CLASS_NAME");
      int c5 = rs.findColumn("DATA_TYPE");
      int c6 = rs.findColumn("REMARKS");
      int c7 = rs.findColumn("BASE_TYPE");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check super types.
  // This call should return 0 record with with 6 columns
  //
  @Test
  public void testSuperTypes() throws Exception {
    System.out.println("testSuperTypes");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getSuperTypes(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*");
      int c1 = rs.findColumn("TYPE_CAT");
      int c2 = rs.findColumn("TYPE_SCHEM");
      int c3 = rs.findColumn("TYPE_NAME");
      int c4 = rs.findColumn("SUPERTYPE_CAT");
      int c5 = rs.findColumn("SUPERTYPE_SCHEM");
      int c6 = rs.findColumn("SUPERTYPE_NAME");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check super tables.
  // This call should return 0 record with with 4 columns
  //
  @Test
  public void testSuperTables() throws Exception {
    System.out.println("testSuperTables");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getSuperTables(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*");
      int c1 = rs.findColumn("TABLE_CAT");
      int c2 = rs.findColumn("TABLE_SCHEM");
      int c3 = rs.findColumn("TABLE_NAME");
      int c4 = rs.findColumn("SUPERTABLE_NAME");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check get Attributes
  // This call should return 0 record with with 21 columns
  //
  @Test
  public void testAttributes() throws Exception {
    System.out.println("testAttributes");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getAttributes(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*", "*");
      int c1 = rs.findColumn("TYPE_CAT");
      int c2 = rs.findColumn("TYPE_SCHEM");
      int c3 = rs.findColumn("TYPE_NAME");
      int c4 = rs.findColumn("DATA_TYPE");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Check pseudo columns
  // This call should return 0 record with with 21 columns
  //
  @Test
  public void testPseudoColumns() throws Exception {
    System.out.println("testPseudoColumns");
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getPseudoColumns(RocksetConnection.DEFAULT_CATALOG,
                     RocksetConnection.DEFAULT_SCHEMA,
                     "*", "*");
      int c1 = rs.findColumn("TABLE_CAT");
      int c2 = rs.findColumn("TABLE_SCHEM");
      int c3 = rs.findColumn("TABLE_NAME");
      int c4 = rs.findColumn("COLUMN_NAME");
      int c5 = rs.findColumn("DATA_TYPE");
      int c6 = rs.findColumn("COLUMN_SIZE");
      int c7 = rs.findColumn("DECIMAL_DIGITS");
      int c8 = rs.findColumn("NUM_PREC_RADIX");
      int c9 = rs.findColumn("COLUMN_USAGE");
      int c10 = rs.findColumn("REMARKS");
      int c11 = rs.findColumn("CHAR_OCTET_LENGTH");
      int c12 = rs.findColumn("IS_NULLABLE");

      int found = 0;
      while (rs.next()) {
        found++;
        String value = rs.getString(c1);
        Assert.assertTrue(value.equals("TABLE"));
      }
      Assert.assertEquals(0, found);
    } finally {
      cleanup(stmt, conn);
    }
  }

  //
  // Test a very basic query
  //
  // @Test
  public void testSimpleQuery() throws Exception {
    System.out.println("testSimpleQuery");
    Connection conn = null;
    Statement stmt = null;
    String tableName = System.getenv("ROCKSET_TABLENAME");
    if (tableName == null) {
      throw new Exception("If you want to run unit tests "
              + "Please set ROCKSET_TABLENAME");
    }
    try {
      // Open a connection
      conn = DriverManager.getConnection(DB_URL, property);

      // Execute a query
      System.out.println("Creating statement 1...");
      stmt = conn.createStatement();
      String sql;
      sql = "select _id, created_at, founded_year  from "
              + tableName + " limit 1";
      ResultSet rs = stmt.executeQuery(sql);

      // Extract data from result set
      while (rs.next()) {
        //Retrieve by column name
        String createdAt = rs.getString("created_at");
        String id = rs.getString("_id");
        int year = rs.getInt("founded_year");

        //Display values
        System.out.println("ID: " + id
                + " created_at: " + createdAt
                + " year: " + year);
      }
      stmt.close();
      rs.close();

      // describe table
      System.out.println("Creating statement 2...");
      stmt = conn.createStatement();
      sql = "select * from " + tableName;
      rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      System.out.println("No. of columns : " + rsmd.getColumnCount());
      System.out.println("FIELD\t\tTYPE");
      for (int i = 0; i < rsmd.getColumnCount(); i++) {
        System.out.println(rsmd.getColumnName(i + 1) + "\t\t"
                + rsmd.getColumnTypeName(i + 1));
      }

      // Clean-up environment
      rs.close();
      Assert.assertTrue(true);
    } finally {
      cleanup(stmt, conn);
    }
    System.out.println("Goodbye!");
  }

  //
  // Invoked by all unit tests at the end to cleanup its mess
  //
  private void cleanup(Statement stmt, Connection conn) {
    try {
      if (stmt != null) {
        stmt.close();
      } 
    } catch (SQLException se2) {
      // nothing we can do
    }
    try {
      if (conn != null) {
        conn.close();
      } 
    } catch (SQLException se) {
      se.printStackTrace();
    }
  }
}
