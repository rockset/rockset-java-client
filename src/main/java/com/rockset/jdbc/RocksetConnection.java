package com.rockset.jdbc;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Maps.fromProperties;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.util.Objects.requireNonNull;

import com.rockset.client.RocksetClient;
import com.rockset.client.model.Collection;
import com.rockset.client.model.QueryParameter;
import com.rockset.client.model.QueryRequest;
import com.rockset.client.model.QueryRequestSql;
import com.rockset.client.model.QueryResponse;
import com.rockset.client.model.Workspace;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.CharsetEncoder;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class RocksetConnection implements Connection {

  // A Catalog specifies the type of a data source.
  // A Catalog contains schemas
  public static final String DEFAULT_CATALOG = "rockset";

  // A schema refers to a Rockset's workspace.
  // A workspace internally contains a set of tables.
  public static final String DEFAULT_SCHEMA = "commons";

  private final AtomicBoolean closed = new AtomicBoolean();
  private final AtomicReference<String> catalog = new AtomicReference<>();
  private final AtomicReference<String> schema = new AtomicReference<>();
  private final AtomicReference<String> timeZoneId = new AtomicReference<>();
  private final AtomicReference<Locale> locale = new AtomicReference<>();
  private final AtomicLong nextStatementId = new AtomicLong(1);

  private final URI uri; // The JDBC URI
  private final String user;
  private final Map<String, String> clientInfo = new ConcurrentHashMap<>();
  private final Map<String, String> sessionProperties = new ConcurrentHashMap<>();

  // The rockset client
  private RocksetClient client;

  RocksetConnection(URI uri, Properties info) throws SQLException {
    requireNonNull(uri, "uri is null");
    this.uri = uri;
    this.user = uri.getUserInfo();
    this.schema.set(DEFAULT_SCHEMA);
    this.catalog.set(DEFAULT_CATALOG);

    // Create a rockset client connection.
    String apiKey = getApiKey(info);
    String apiServer = getApiServer(uri, info);
    this.client = new RocksetClient(apiKey, apiServer, "jdbc");

    timeZoneId.set(TimeZone.getDefault().getID());
    locale.set(Locale.getDefault());
  }

  @Override
  public Statement createStatement() throws SQLException {
    RocksetDriver.log("Entry: createStatement ");
    checkOpen();
    return new RocksetStatement(this);
  }

  @Override
  public PreparedStatement prepareStatement(String sql) throws SQLException {
    RocksetDriver.log("Entry: prepareStatement ");
    checkOpen();
    String name = "statement" + nextStatementId.getAndIncrement();
    return new RocksetPreparedStatement(this, name, sql);
  }

  @Override
  public CallableStatement prepareCall(String sql) throws SQLException {
    throw new NotImplementedException("Connection", "prepareCall");
  }

  @Override
  public String nativeSQL(String sql) throws SQLException {
    checkOpen();
    return sql;
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    checkOpen();
    if (!autoCommit) {
      throw new SQLFeatureNotSupportedException("Disabling auto-commit mode not supported");
    }
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    checkOpen();
    return true;
  }

  @Override
  public void commit() throws SQLException {
    checkOpen();
    if (getAutoCommit()) {
      throw new SQLException("Connection is in auto-commit mode");
    }
    throw new NotImplementedException("Connection", "commit");
  }

  @Override
  public void rollback() throws SQLException {
    checkOpen();
    if (getAutoCommit()) {
      throw new SQLException("Connection is in auto-commit mode");
    }
    throw new NotImplementedException("Connection", "rollback");
  }

  @Override
  public void close() throws SQLException {
    closed.set(true);
    client = null;
  }

  @Override
  public boolean isClosed() throws SQLException {
    return closed.get();
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return new RocksetDatabaseMetaData(this);
  }

  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    checkOpen();
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    return false;
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    checkOpen();
    this.catalog.set(catalog);
  }

  @Override
  public String getCatalog() throws SQLException {
    checkOpen();
    return catalog.get();
  }

  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    checkOpen();
    throw new SQLFeatureNotSupportedException("Dhruba says that you are crazy cool!");
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    checkOpen();
    return TRANSACTION_NONE;
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
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    RocksetDriver.log(
        "Entry: createStatement "
            + " resultSetType "
            + resultSetType
            + " resultSetConcurrency "
            + resultSetConcurrency);
    checkResultSet(resultSetType, resultSetConcurrency);
    return createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    RocksetDriver.log(
        "Entry: prepareStatement "
            + " sql "
            + sql
            + " resultSetType "
            + resultSetType
            + " resultSetConcurrency "
            + resultSetConcurrency);
    checkResultSet(resultSetType, resultSetConcurrency);
    return prepareStatement(sql);
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkResultSet(resultSetType, resultSetConcurrency);
    throw new SQLFeatureNotSupportedException("prepareCall");
  }

  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    throw new SQLFeatureNotSupportedException("getTypeMap");
  }

  @Override
  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    throw new SQLFeatureNotSupportedException("setTypeMap");
  }

  @Override
  public void setHoldability(int holdability) throws SQLException {
    checkOpen();
    if (holdability != ResultSet.HOLD_CURSORS_OVER_COMMIT) {
      throw new SQLFeatureNotSupportedException("Changing holdability not supported");
    }
  }

  @Override
  public int getHoldability() throws SQLException {
    checkOpen();
    return ResultSet.HOLD_CURSORS_OVER_COMMIT;
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    throw new SQLFeatureNotSupportedException("setSavepoint");
  }

  @Override
  public Savepoint setSavepoint(String name) throws SQLException {
    throw new SQLFeatureNotSupportedException("setSavepoint");
  }

  @Override
  public void rollback(Savepoint savepoint) throws SQLException {
    throw new SQLFeatureNotSupportedException("rollback");
  }

  @Override
  public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    throw new SQLFeatureNotSupportedException("releaseSavepoint");
  }

  @Override
  public Statement createStatement(
      int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    RocksetDriver.log(
        "Entry: createStatement "
            + " resultSetType "
            + resultSetType
            + " resultSetConcurrency "
            + resultSetConcurrency
            + " resultSetHoldability "
            + resultSetHoldability);
    checkHoldability(resultSetHoldability);
    return createStatement(resultSetType, resultSetConcurrency);
  }

  @Override
  public PreparedStatement prepareStatement(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    RocksetDriver.log(
        "Entry: prepareStatement "
            + " sql "
            + sql
            + " resultSetType "
            + resultSetType
            + " resultSetConcurrency "
            + resultSetConcurrency
            + " resultSetHoldability "
            + resultSetHoldability);
    checkHoldability(resultSetHoldability);
    return prepareStatement(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public CallableStatement prepareCall(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    checkHoldability(resultSetHoldability);
    return prepareCall(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    RocksetDriver.log(
        "Entry: prepareStatement " + " sql " + sql + " autoGeneratedKeys " + autoGeneratedKeys);
    if (autoGeneratedKeys != Statement.RETURN_GENERATED_KEYS) {
      throw new SQLFeatureNotSupportedException("Auto generated keys must be NO_GENERATED_KEYS");
    }
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    RocksetDriver.log("Entry: prepareStatement " + " sql " + sql + " columnIndexes ");
    throw new SQLFeatureNotSupportedException("prepareStatement");
  }

  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    RocksetDriver.log("Entry: prepareStatement " + " sql " + sql + " columnNames ");
    throw new SQLFeatureNotSupportedException("prepareStatement");
  }

  @Override
  public Clob createClob() throws SQLException {
    throw new SQLFeatureNotSupportedException("createClob");
  }

  @Override
  public Blob createBlob() throws SQLException {
    throw new SQLFeatureNotSupportedException("createBlob");
  }

  @Override
  public NClob createNClob() throws SQLException {
    throw new SQLFeatureNotSupportedException("createNClob");
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    throw new SQLFeatureNotSupportedException("createSQLXML");
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    if (timeout < 0) {
      throw new SQLException("Timeout is negative");
    }
    return !isClosed();
  }

  @Override
  public void setClientInfo(String name, String value) throws SQLClientInfoException {
    requireNonNull(name, "name is null");
    if (value != null) {
      clientInfo.put(name, value);
    } else {
      clientInfo.remove(name);
    }
  }

  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    clientInfo.putAll(fromProperties(properties));
  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    return clientInfo.get(name);
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    Properties properties = new Properties();
    for (Map.Entry<String, String> entry : clientInfo.entrySet()) {
      properties.setProperty(entry.getKey(), entry.getValue());
    }
    return properties;
  }

  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    throw new SQLFeatureNotSupportedException("createArrayOf");
  }

  @Override
  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    throw new SQLFeatureNotSupportedException("createStruct");
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    checkOpen();
    RocksetDriver.log("setSchema() setting schema to " + schema);
    this.schema.set(schema);
  }

  @Override
  public String getSchema() throws SQLException {
    checkOpen();
    return schema.get();
  }

  public String getTimeZoneId() {
    return timeZoneId.get();
  }

  public void setTimeZoneId(String timeZoneId) {
    requireNonNull(timeZoneId, "timeZoneId is null");
    this.timeZoneId.set(timeZoneId);
  }

  public Locale getLocale() {
    return locale.get();
  }

  public void setLocale(Locale locale) {
    this.locale.set(locale);
  }

  /**
   * Adds a session property (experimental).
   * @param name Name
   * @param value Value
   */
  public void setSessionProperty(String name, String value) {
    requireNonNull(name, "name is null");
    requireNonNull(value, "value is null");
    checkArgument(!name.isEmpty(), "name is empty");

    CharsetEncoder charsetEncoder = US_ASCII.newEncoder();
    checkArgument(name.indexOf('=') < 0, "Session property name must not contain '=': %s", name);
    checkArgument(
        charsetEncoder.canEncode(name), "Session property name is not US_ASCII: %s", name);
    checkArgument(
        charsetEncoder.canEncode(value), "Session property value is not US_ASCII: %s", value);

    sessionProperties.put(name, value);
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    close();
  }

  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    throw new SQLFeatureNotSupportedException("setNetworkTimeout");
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    throw new SQLFeatureNotSupportedException("getNetworkTimeout");
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

  URI getUri() {
    return uri;
  }

  String getUser() {
    return user;
  }

  //
  // This is invoked by the RocksetStatement to execute a query
  //
  QueryResponse startQuery(
      String sql, int fetchSize, List<QueryParameter> params, Map<String, String> sessionPropertiesOverride)
      throws Exception {
    final QueryRequestSql q = new QueryRequestSql().query(sql);

    if (fetchSize > 0) {
      q.paginate(true).initialPaginateResponseDocCount(fetchSize);
    }

    // Append any specified queries
    if (params != null) {
      q.parameters(params);
    }

    final QueryRequest request = new QueryRequest().sql(q);
    return client.queries.query(request);
  }

  //
  // This is invoked by the RocksetStatement to paginate a query
  //
  public QueryResponse getQueryPaginationResults(
          String queryId, String cursor, int fetchSize)
          throws Exception {
    return client.queries.getQueryPaginationResults(queryId, cursor, fetchSize);
  }

  //
  // List all collections
  //
  List<Collection> listCollections(String schema) throws Exception {
    return client.collections.workspace(schema).getData();
  }

  List<Collection> listCollections() throws Exception {
    return listCollections(getSchema());
  }

  // TODO also check for quotes withing string
  String quoteIdentifier(String value) {
    String result = "\"";
    result += value;
    result += "\"";
    return result;
  }

  //
  // Get schema for a table
  //
  QueryResponse describeTable(String schema, String name) throws Exception {
    RocksetDriver.log("Entry: describeTable " + name);
    String sql =
        String.format(
            "describe %s.%s OPTION(max_field_depth=1)",
            quoteIdentifier(schema), quoteIdentifier(name));
    QueryResponse resp = startQuery(sql, 0,null, null);
    RocksetDriver.log("Exit: describeTable " + name);
    return resp;
  }

  QueryResponse describeTable(String name) throws Exception {
    return describeTable(getSchema(), name);
  }

  List<String> getWorkspaces() throws Exception {
    return client.workspaces.list(true).getData().stream()
        .map(Workspace::getName)
        .collect(Collectors.toList());
  }

  private static String getApiKey(Properties info) {
    // TODO: We should stop supporting 'apikey' property after we are certain that no customer would
    // ever use an older version.
    String apiKey = info.getProperty("apiKey");
    if (apiKey == null) {
      apiKey = info.getProperty("apikey");
    }
    // If username and password provided, override the apikey.
    if (info.getProperty("user") != null
        && info.getProperty("user").toLowerCase().equals("apikey")) {
      apiKey = info.getProperty("password");
    }
    return apiKey;
  }

  private static String getApiServer(URI uri, Properties info) {
    // TODO: We should stop supporting 'apiserver' and 'endpoint' properties after we are certain
    // that no customer would ever use an older version.
    String apiServer = "";
    try {
      URI hostURI = new URI(uri.toString().substring(RocksetDriver.JDBC_URL_START.length()));
      apiServer = hostURI.getHost();
    } catch (URISyntaxException e) {
      // ignore
    }

    if (apiServer.isEmpty() && info.getProperty("apiserver") != null) {
      apiServer = info.getProperty("apiserver");
    }
    if (apiServer.isEmpty() && info.getProperty("apiServer") != null) {
      apiServer = info.getProperty("apiServer");
    }
    if (apiServer.isEmpty() && info.getProperty("endpoint") != null) {
      apiServer = info.getProperty("endpoint");
    }
    return apiServer;
  }

  private void checkOpen() throws SQLException {
    if (isClosed()) {
      throw new SQLException("Connection is closed");
    }
  }

  private static void checkResultSet(int resultSetType, int resultSetConcurrency)
      throws SQLFeatureNotSupportedException {
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY) {
      throw new SQLFeatureNotSupportedException("Result set type must be TYPE_FORWARD_ONLY");
    }
    if (resultSetConcurrency != ResultSet.CONCUR_READ_ONLY) {
      throw new SQLFeatureNotSupportedException("Result set concurrency must be CONCUR_READ_ONLY");
    }
  }

  private static void checkHoldability(int resultSetHoldability)
      throws SQLFeatureNotSupportedException {
    if (resultSetHoldability != ResultSet.HOLD_CURSORS_OVER_COMMIT) {
      throw new SQLFeatureNotSupportedException(
          "Result set holdability must be HOLD_CURSORS_OVER_COMMIT");
    }
  }
}
