package com.rockset.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PaginationExample {

  private static final String JDBC_DRIVER = "com.rockset.jdbc.RocksetDriver";
  private static final String DB_URL = "jdbc:rockset://";
  private static final String COLLECTION_NAME = "rockset-collection";
  private static final int PAGINATION_SIZE = 10;

  public static void main(String... args) throws Exception {
    Properties properties = new Properties();
    properties.setProperty("apiKey", "xyz");
    properties.setProperty("apiServer", "api.rs2.usw2.rockset.com");

    Class.forName(JDBC_DRIVER);
    viewAllNames(properties);
  }

  public static void viewAllNames(Properties properties) throws SQLException {
    Connection conn = DriverManager.getConnection(DB_URL, properties);

    String query = String.format("SELECT name FROM \"%s\" LIMIT 100", COLLECTION_NAME);
    try (Statement stmt = conn.createStatement()) {
      stmt.setFetchSize(PAGINATION_SIZE);
      stmt.setFetchDirection(ResultSet.FETCH_FORWARD);
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        System.out.println("Name = " + rs.getString("name"));
      }
    } catch (SQLException e) {
      System.out.println("exception " + e.getLocalizedMessage());
    }
  }
}
