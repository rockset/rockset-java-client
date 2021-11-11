package com.rockset.jdbc;

import static java.lang.String.format;

import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

interface ConnectionProperty<T> {
  String getKey();

  Optional<String> getDefault();

  DriverPropertyInfo getDriverPropertyInfo(Properties properties);

  boolean isRequired(Properties properties);

  boolean isAllowed(Properties properties);

  Optional<T> getValue(Properties properties) throws SQLException;

  default T getRequiredValue(Properties properties) throws SQLException {
    return getValue(properties)
        .orElseThrow(
            () -> new SQLException(format("Connection property '%s' is required", getKey())));
  }

  void validate(Properties properties) throws SQLException;
}
