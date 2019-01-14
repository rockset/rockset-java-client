package com.rockset.jdbc;

import static java.lang.String.format;

import java.sql.SQLNonTransientException;

/**
 * Thrown when a required JDBC method is not yet implemented.
 */
class NotImplementedException extends SQLNonTransientException {
  NotImplementedException(String reason) {
    super(reason);
  }

  NotImplementedException(String clazz, String method) {
    this(format("Method %s.%s is not yet implemented", clazz, method));
  }
}
