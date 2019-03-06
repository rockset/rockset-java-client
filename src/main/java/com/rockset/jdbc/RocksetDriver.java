package com.rockset.jdbc;

import static com.google.common.base.Strings.nullToEmpty;
import static java.lang.Integer.parseInt;

import com.google.common.base.Throwables;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RocksetDriver implements Driver, Closeable {

  static final String DRIVER_NAME = "Rockset JDBC Driver";
  static final String DRIVER_VERSION;
  static final int DRIVER_VERSION_MAJOR;
  static final int DRIVER_VERSION_MINOR;

  private static final String ROCKSET_DRIVER_URL_START = "jdbc:rockset:";

  // This is debug logging to trace the calls made to the rockset jdbc driver.
  private static boolean debugLogs = false;
  private static BufferedWriter debugWriter;
  private static String logfile = "/tmp/rockset-jdbc.log";

  static {
    String version = nullToEmpty(RocksetDriver.class.getPackage().getImplementationVersion());
    Matcher matcher = Pattern.compile("^(\\d+)\\.(\\d+)($|[.-])").matcher(version);
    if (!matcher.find()) {
      DRIVER_VERSION = "unknown";
      DRIVER_VERSION_MAJOR = 0;
      DRIVER_VERSION_MINOR = 0;
    } else {
      DRIVER_VERSION = version;
      DRIVER_VERSION_MAJOR = parseInt(matcher.group(1));
      DRIVER_VERSION_MINOR = parseInt(matcher.group(2));
    }

    try {
      DriverManager.registerDriver(new RocksetDriver());
    } catch (SQLException e) {
      throw Throwables.propagate(e);
    }
  }

  @Override
  public void close() {
    // dunno what to do here
  }

  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    log("Entry: Connect " + url);
    if (!acceptsURL(url)) {
      log("Exit: Connect " + url);
      return null;
    }
    try {
      URI uri = new URI(url);
      log("Exit: Connect " + url);
      return new RocksetConnection(uri, info);
    } catch (URISyntaxException e) {
      throw new SQLException("Bad url format " + url + " exception " + e.getMessage());
    }
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    log("Entry: acceptsURL " + url);
    return url.startsWith(ROCKSET_DRIVER_URL_START);
  }

  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
      throws SQLException {
    log("Entry: getPropertyInfo " + url);
    Properties properties = new RocksetDriverUri(url, info).getProperties();

    return ConnectionProperties.allProperties().stream()
        .map(property -> property.getDriverPropertyInfo(properties))
        .toArray(DriverPropertyInfo[]::new);
  }

  @Override
  public int getMajorVersion() {
    log("Entry: getMajorVersion ");
    return DRIVER_VERSION_MAJOR;
  }

  @Override
  public int getMinorVersion() {
    log("Entry: getMinorVersion ");
    return DRIVER_VERSION_MINOR;
  }

  @Override
  public boolean jdbcCompliant() {
    log("Entry: jdbcCompliant ");
    return true;
  }

  @Override
  public java.util.logging.Logger getParentLogger()
      throws SQLFeatureNotSupportedException {
    throw new SQLFeatureNotSupportedException();
  }

  // helper method to write log to a specific file
  static void log(String msg) {
    if (debugLogs) {
      doLog(msg);
    }
  }

  static synchronized void doLog(String msg) {
    try {
      if (debugWriter == null) {
        debugWriter = new BufferedWriter(new FileWriter(logfile));
      }
      debugWriter.write(msg + "\n");
      debugWriter.flush();
    } catch (Exception e) {
      System.out.println("Unable to log to file "  + logfile);
    }
  }
}
