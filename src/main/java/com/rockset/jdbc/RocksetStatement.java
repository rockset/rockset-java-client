package com.rockset.jdbc;

import static java.lang.Math.toIntExact;
import static java.util.Objects.requireNonNull;

import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;

import com.rockset.client.model.QueryResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class RocksetStatement implements Statement {
  private final AtomicLong maxRows = new AtomicLong();
  private final AtomicInteger queryTimeoutSeconds = new AtomicInteger();
  private final AtomicInteger fetchSize = new AtomicInteger();
  private final AtomicBoolean escapeProcessing = new AtomicBoolean(true);
  private final AtomicBoolean closeOnCompletion = new AtomicBoolean();
  private final AtomicReference<RocksetConnection> connection;
  private final AtomicReference<ResultSet> currentResult = new AtomicReference<>();
  private final AtomicLong currentUpdateCount = new AtomicLong(-1);

  RocksetStatement(RocksetConnection connection) {
    this.connection = new AtomicReference<>(requireNonNull(connection, "connection is null"));
  }

  @Override
  public ResultSet executeQuery(String sql) throws SQLException {
    if (!execute(sql)) {
      throw new SQLException("SQL statement is not a query: " + sql);
    }
    return currentResult.get();
  }

  @Override
  public void close() throws SQLException {
    if (connection.getAndSet(null) != null) {
      // TODO
    }
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    checkOpen();
    return 0;
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    checkOpen();
    if (max < 0) {
      throw new SQLException("Max field size must be positive");
    }
    // ignore: full values are always returned
  }

  @Override
  public int getMaxRows() throws SQLException {
    long result = getLargeMaxRows();
    if (result > Integer.MAX_VALUE) {
      throw new SQLException("Max rows exceeds limit of 2147483647");
    }
    return toIntExact(result);
  }

  @Override
  public long getLargeMaxRows() throws SQLException {
    checkOpen();
    return maxRows.get();
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    setLargeMaxRows(max);
  }

  @Override
  public void setLargeMaxRows(long max) throws SQLException {
    checkOpen();
    if (max < 0) {
      throw new SQLException("Max rows must be positive");
    }
    maxRows.set(max);
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    checkOpen();
    escapeProcessing.set(enable);
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    checkOpen();
    return queryTimeoutSeconds.get();
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    checkOpen();
    if (seconds < 0) {
      throw new SQLException("Query timeout seconds must be positive");
    }
    queryTimeoutSeconds.set(seconds);
  }

  @Override
  public void cancel() throws SQLException {
    checkOpen();
    throw new SQLFeatureNotSupportedException("You have to live with it!");
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
  public void setCursorName(String name) throws SQLException {
    checkOpen();
    // ignore: positioned modifications not supported
  }

  @Override
  public boolean execute(String sql) throws SQLException {
    clearCurrentResults();
    checkOpen();

    ResultSet resultSet = null;
    try {
      // Make query to rockset service. We do not use queryTimeoutSeconds
      // because rockset queries do not yet have a client-side timeout.
      QueryResponse resp = connection().startQuery(sql,
              getStatementSessionProperties());

      // store resuts in memory
      resultSet = new RocksetResultSet(resp, maxRows.get());
      currentResult.set(resultSet);

      return true;
    } catch (RuntimeException e) {
      throw new SQLException("Error executing query, error =  " + e.getMessage(), e);
    } catch (Exception e) {
      throw new SQLException(e.getMessage(), e);
    } finally {
      if (currentResult.get() == null && resultSet != null) {
        resultSet.close();
      }
    }
  }

  @Override
  public ResultSet getResultSet() throws SQLException {
    checkOpen();
    return currentResult.get();
  }

  @Override
  public int getUpdateCount() throws SQLException {
    return Ints.saturatedCast(getLargeUpdateCount());
  }

  @Override
  public long getLargeUpdateCount() throws SQLException {
    checkOpen();
    return currentUpdateCount.get();
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    checkOpen();
    currentResult.get().close();
    return false;
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    checkOpen();
    if (!validFetchDirection(direction)) {
      throw new SQLException("Invalid fetch direction");
    }
    // ignore: fetch direction is always forward
  }

  @Override
  public int getFetchDirection() throws SQLException {
    checkOpen();
    return ResultSet.FETCH_FORWARD;
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    checkOpen();
    if (rows < 0) {
      throw new SQLException("Fetch size must be positive");
    }
    fetchSize.set(rows);
  }

  @Override
  public int getFetchSize() throws SQLException {
    checkOpen();
    return fetchSize.get();
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    checkOpen();
    return ResultSet.CONCUR_READ_ONLY;
  }

  @Override
  public int getResultSetType() throws SQLException {
    checkOpen();
    return ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public void addBatch(String sql) throws SQLException {
    checkOpen();
    throw new SQLFeatureNotSupportedException("Batches not supported");
  }

  @Override
  public void clearBatch() throws SQLException {
    checkOpen();
    throw new SQLFeatureNotSupportedException("Batches not supported");
  }

  @Override
  public int[] executeBatch() throws SQLException {
    checkOpen();
    throw new SQLFeatureNotSupportedException("Batches not supported");
  }

  @Override
  public Connection getConnection() throws SQLException {
    return connection();
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    checkOpen();

    if (current == CLOSE_CURRENT_RESULT) {
      currentResult.get().close();
      return false;
    }

    if (current != KEEP_CURRENT_RESULT && current != CLOSE_ALL_RESULTS) {
      throw new SQLException("Invalid argument: " + current);
    }
    throw new SQLFeatureNotSupportedException("Multiple open results not supported");
  }

  @Override
  public ResultSet getGeneratedKeys() throws SQLException {
    throw new SQLFeatureNotSupportedException("getGeneratedKeys");
  }

  @Override
  public int executeUpdate(String sql) throws SQLException {
    return Ints.saturatedCast(executeLargeUpdate(sql));
  }

  @Override
  public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    return executeUpdate(sql);
  }

  @Override
  public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
    return executeUpdate(sql);
  }

  @Override
  public int executeUpdate(String sql, String[] columnNames) throws SQLException {
    return executeUpdate(sql);
  }

  @Override
  public long executeLargeUpdate(String sql) throws SQLException {
    if (execute(sql)) {
      throw new SQLException("SQL is not an update statement: " + sql);
    }
    return currentUpdateCount.get();
  }

  @Override
  public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    return executeLargeUpdate(sql);
  }

  @Override
  public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
    return executeLargeUpdate(sql);
  }

  @Override
  public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
    return executeLargeUpdate(sql);
  }

  @Override
  public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
    return execute(sql);
  }

  @Override
  public boolean execute(String sql, int[] columnIndexes) throws SQLException {
    return execute(sql);
  }

  @Override
  public boolean execute(String sql, String[] columnNames) throws SQLException {
    return execute(sql);
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  public boolean isClosed() throws SQLException {
    return connection.get() == null;
  }

  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    checkOpen();
    // ignore: statement pooling not supported
  }

  @Override
  public boolean isPoolable() throws SQLException {
    checkOpen();
    return false;
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    checkOpen();
    closeOnCompletion.set(true);
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    checkOpen();
    return closeOnCompletion.get();
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

  private void checkOpen() throws SQLException {
    connection();
  }

  private RocksetConnection connection() throws SQLException {
    RocksetConnection connection = this.connection.get();
    if (connection == null) {
      throw new SQLException("Statement is closed");
    }
    if (connection.isClosed()) {
      throw new SQLException("Connection is closed");
    }
    return connection;
  }

  private static boolean validFetchDirection(int direction) {
    return (direction == ResultSet.FETCH_FORWARD)
        || (direction == ResultSet.FETCH_REVERSE)
        || (direction == ResultSet.FETCH_UNKNOWN);
  }

  private Map<String, String> getStatementSessionProperties() {
    ImmutableMap.Builder<String, String> sessionProperties = ImmutableMap.builder();
    if (queryTimeoutSeconds.get() > 0) {
      sessionProperties.put("query_max_run_time",
              queryTimeoutSeconds.get() + "s");
    }
    return sessionProperties.build();
  }

  private void clearCurrentResults() {
    currentResult.set(null);
    currentUpdateCount.set(-1);
  }
}
