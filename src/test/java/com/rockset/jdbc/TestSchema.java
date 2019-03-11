package com.rockset.jdbc;

import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.rockset.client.RocksetClient;
import com.rockset.client.model.CreateCollectionRequest;
import com.rockset.client.model.CreateCollectionResponse;
import com.rockset.client.model.DeleteCollectionResponse;
import com.rockset.client.model.QueryRequest;
import com.rockset.client.model.QueryRequestSql;
import com.rockset.client.model.QueryResponse;
import com.rockset.client.model.Resource;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//
// An example that shows simple JDBC queries on tables in a schema
// A Rockset workspace maps to a JDBC schema.
//
public class TestSchema {

  // JDBC driver name and database URL
  private static final String JDBC_DRIVER = FirstExample.JDBC_DRIVER;
  private static final String DB_URL = FirstExample.DB_URL;

  // store credentials for accessing rockset service
  private Properties property;

  // A rockset client to directly interact with Rockset service
  private RocksetClient testClient;

  // A private object to upload files to rockset
  OkHttpClient client = new OkHttpClient();

  final ObjectMapper mapper = new ObjectMapper();

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

    // create the Rockset test client
    testClient = new RocksetClient(property.getProperty("apikey"),
                                   property.getProperty("endpoint"));
    // Register JDBC driver
    Class.forName(JDBC_DRIVER);
  }

  //
  // Check catalog names.
  // This call should return one record with with one column
  // TABLE_CATALOG
  //
  @Test
  public void testGetTables() throws Exception {
    System.out.println("testGetTables");

    // create 3 collections
    int numCollections = 3;
    List<String> colls = generateCollectionNames(numCollections);
    createCollections(colls);

    // now check these 3 collections are returned via the JDBC call
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getTables(RocksetConnection.DEFAULT_CATALOG,
                                    RocksetConnection.DEFAULT_SCHEMA,
                                    "*", null);
      int colCatIndex = rs.findColumn("TABLE_CAT");
      int colSchemaIndex = rs.findColumn("TABLE_SCHEM");
      int colNameIndex = rs.findColumn("TABLE_NAME");
      int colTypeIndex = rs.findColumn("TABLE_TYPE");
      int colRemarksIndex = rs.findColumn("REMARKS");

      int found = 0;
      while (rs.next()) {
        String value = rs.getString(colSchemaIndex);
        Assert.assertTrue(value.equals(RocksetConnection.DEFAULT_SCHEMA));
        value = rs.getString(colCatIndex);
        Assert.assertTrue(value.equals(RocksetConnection.DEFAULT_CATALOG));
        value = rs.getString(colTypeIndex);
        Assert.assertTrue(value.equals("TABLE"));
        final String v1 = rs.getString(colNameIndex);
        if (colls.stream().anyMatch(str -> str.equals(v1))) {
          found++;
        }
      }
      Assert.assertEquals(numCollections, found);
    } finally {
      cleanup(colls, stmt, conn);
    }
  }

  @Test
  public void testDateTimeTimestamp() throws Exception {
    System.out.println("testDateTimeTimestamp");
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    // create 1 collection
    int numCollections = 1;
    List<String> colls = generateCollectionNames(numCollections);
    final String collectionName = colls.get(0);

    try {
      // create collection
      createCollections(colls);

      // wait for all leaves to be ready to serve
      waitCollections(colls);

      String csvParams =
              "{ \"csv\": { \"columnNames\": [\"c1\", \"c2\", \"c3\"], "
                      + "\"columnTypes\": [\"DATE\", \"TIME\", \"TIMESTAMP\"] } }";

      uploadFile(collectionName, "src/test/resources/basic.csv", csvParams);
      waitNumberDocs(collectionName, 1);

      conn = DriverManager.getConnection(DB_URL, property);

      // Execute a query
      System.out.println("Creating statement 1...");
      stmt = conn.createStatement();
      String sql = "select c1, c2, c3 from " + collectionName;
      rs = stmt.executeQuery(sql);

      // Extract data from result set
      while (rs.next()) {
        //Retrieve by column name
        Date c1 = rs.getDate("c1");
        Time c2 = rs.getTime("c2");
        String c3 = rs.getString("c3");

        //Display values
        System.out.println("c1: " + c1.toString()
                + " c2: " + c2.toString()
                + " c3: " + c3);
      }
    } finally {
      cleanup(colls, stmt, conn);
    }
  }

  @Test
  public void testGetColumns() throws Exception {
    System.out.println("testGetTableColumns");
    Connection conn = null;
    Statement stmt = null;

    // create 1 collection
    int numCollections = 1;
    List<String> colls = generateCollectionNames(numCollections);
    final String collectionName = colls.get(0);

    try {
      // create collection
      createCollections(colls);

      // wait for all leaves to be ready to serve
      waitCollections(colls);

      // upload one file to collection and wait for it to be visible
      uploadFile(collectionName, "src/test/resources/basic.json", null);
      waitNumberDocs(collectionName, 1);

      // there should be 6 columns in this test file
      // a, name, nested, _id, _meta, _event_time
      final int numColumns = 6;

      conn = DriverManager.getConnection(DB_URL, property);

      DatabaseMetaData meta = conn.getMetaData();
      ResultSet rs = meta.getColumns(RocksetConnection.DEFAULT_CATALOG,
                                     RocksetConnection.DEFAULT_SCHEMA,
                                     collectionName, null);
      int colCatIndex = rs.findColumn("TABLE_CAT");
      int colSchemaIndex = rs.findColumn("TABLE_SCHEM");
      int colNameIndex = rs.findColumn("TABLE_NAME");
      int c1 = rs.findColumn("COLUMN_NAME");
      c1 = rs.findColumn("DATA_TYPE");
      c1 = rs.findColumn("TYPE_NAME");
      c1 = rs.findColumn("COLUMN_SIZE");
      c1 = rs.findColumn("BUFFER_LENGTH");
      c1 = rs.findColumn("DECIMAL_DIGITS");
      c1 = rs.findColumn("NUM_PREC_RADIX");
      c1 = rs.findColumn("NULLABLE");
      c1 = rs.findColumn("REMARKS");
      c1 = rs.findColumn("COLUMN_DEF");
      c1 = rs.findColumn("SQL_DATA_TYPE");
      c1 = rs.findColumn("SQL_DATETIME_SUB");
      c1 = rs.findColumn("CHAR_OCTET_LENGTH");
      c1 = rs.findColumn("ORDINAL_POSITION");
      c1 = rs.findColumn("IS_NULLABLE");
      c1 = rs.findColumn("SCOPE_CATALOG");
      c1 = rs.findColumn("SCOPE_SCHEMA");
      c1 = rs.findColumn("SCOPE_TABLE");
      c1 = rs.findColumn("SOURCE_DATA_TYPE");
      c1 = rs.findColumn("IS_AUTOINCREMENT");
      c1 = rs.findColumn("IS_GENERATEDCOLUMN");

      int found = 0;
      while (rs.next()) {
        String value = rs.getString(colSchemaIndex);
        Assert.assertTrue(value.equals(RocksetConnection.DEFAULT_SCHEMA));
        value = rs.getString(colCatIndex);
        Assert.assertTrue(value.equals(RocksetConnection.DEFAULT_CATALOG));
        value = rs.getString(colNameIndex);
        Assert.assertTrue(value.equals(collectionName));
        found++;
      }
      Assert.assertEquals(found, numColumns);
    } finally {
      cleanup(colls, stmt, conn);
    }
  }

  //
  // Invoked by all unit tests at the end to cleanup its mess
  //
  private void cleanup(List<String> colls, Statement stmt, Connection conn) {
    try {
      if (colls != null) {
        deleteCollections(colls);
      }
    } catch (Exception e) {
      // nothing we can do
    }
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

  //
  //  Generate a list of collection names
  //
  private List<String> generateCollectionNames(int num) {
    List<String> names = new ArrayList<String>(num);
    String prefix  = "jdbctestcollection"
                + RandomStringUtils.randomAlphanumeric(5);
    for (int i = 0; i < num; i++) {
      names.add(prefix + i);
    }
    return names;
  }

  //
  // Wait for all collections to be ready
  //
  private void waitCollections(List<String> names)  throws Exception {
    for (String name: names) {
      String sql = "describe \"" + name + "\";";
      while (true) {
        try {
          QueryRequestSql qs = new QueryRequestSql().query(sql);
          testClient.query(new QueryRequest().sql(qs));
          break;
        } catch (Exception e) {
          System.out.println(String.format("Waiting for collection %s to be describable",
                      name));
          Thread.sleep(1000);
        }
      }
    }
  }

  //
  // Create the list of collections. Fail if any of the collection
  // already exists
  //
  private void createCollections(List<String> names)  throws Exception {
    for (String name: names) {
      CreateCollectionRequest request =
                        new CreateCollectionRequest().name(name);
      CreateCollectionResponse response = testClient.createCollection("commons", request);

      Assert.assertEquals(response.getData().getName(), name);
      Assert.assertEquals(response.getData().getStatus(), Resource.StatusEnum.CREATED);
    }
  }

  //
  // Delete all specified collections
  //
  private void deleteCollections(List<String> names)  throws Exception {
    for (String name: names) {
      DeleteCollectionResponse deleteCollectionResponse
                    = testClient.deleteCollection("commons", name);
      Assert.assertEquals(deleteCollectionResponse.getData().getName(), name);
      Assert.assertEquals(deleteCollectionResponse.getData().getStatus(),
                          Resource.StatusEnum.DELETED);
    }
  }

  //
  // Upload the specified file to the specified collection
  //
  void uploadFile(String collectionName, String path, String params) throws IOException {
    final File file = new File(path);
    final MediaType mt = MediaType.parse("text/json; charset=utf-8");

    // create multipart request
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("file", file.getName(),
          RequestBody.create(mt, file))
        .addFormDataPart("size", String.valueOf(file.length()));

    if (params != null) {
      multipartBuilder.addFormDataPart("params", params);
    }

    RequestBody body = multipartBuilder.build();

    // send the file upload request
    String url = String.format(
            "https://%s/v1/orgs/self/ws/commons/collections/%s/uploads",
            property.getProperty("endpoint"), collectionName);
    System.out.println("Uploading test file to  " + url);

    Request request = new Request.Builder()
        .url(url)
        .addHeader("Authorization", String.format("ApiKey %s", property.getProperty("apikey")))
        .post(body)
        .build();

    Response response = null;
    try {
      response = client.newCall(request).execute();
      assertEquals(response.code(), 200);
      JsonNode jsonObject = mapper.readTree(response.body().string());
      JsonNode jsonData = jsonObject.get("data");
      assertEquals(jsonData.get("file_name").asText(), file.getName());
    } finally {
      if (response != null) {
        response.close();
      }
    }
  }

  //
  // Wait for the specified docs to appear in the collection
  //
  private void waitNumberDocs(String collectionName, int expectedDocs)  throws Exception {
    String sql = "select count(*) from \"" + collectionName + "\";";
    int found = 0;
    while (found < expectedDocs) {
      try {
        QueryRequestSql qs = new QueryRequestSql().query(sql);
        QueryResponse resp = testClient.query(new QueryRequest().sql(qs));

        RocksetResultSet res = new RocksetResultSet(resp, 10);
        if (res.next()) {
          found = res.getInt("?COUNT");
        }
      } catch (Exception e) {
        System.out.println("Exception in query " + sql
                + "exception " + e.getMessage());
      }
      System.out.println(String.format("Collection %s found %d docs, waiting for %d",
                    collectionName, found, expectedDocs));
      Thread.sleep(1000);
    }
  }
}
