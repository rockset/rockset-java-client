package com.rockset.jdbc;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rockset.jdbc.ConnectionProperties.SSL;
import static com.rockset.jdbc.ConnectionProperties.USER;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.net.HostAndPort;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Parses and extracts parameters from a Rockset JDBC URL.
 */
final class RocksetDriverUri {
  private static final String JDBC_URL_START = "jdbc:";

  private static final Splitter QUERY_SPLITTER = Splitter.on('&').omitEmptyStrings();
  private static final Splitter ARG_SPLITTER = Splitter.on('=').limit(2);

  private final HostAndPort address;
  private final URI uri;

  private final Properties properties;

  private String catalog;
  private String schema;

  private final boolean useSecureConnection;

  public RocksetDriverUri(String url, Properties driverProperties) throws SQLException {
    this(parseDriverUrl(url), driverProperties);
  }

  private RocksetDriverUri(URI uri, Properties driverProperties) throws SQLException {
    this.uri = requireNonNull(uri, "uri is null");
    address = HostAndPort.fromParts(uri.getHost(), uri.getPort());
    properties = mergeConnectionProperties(uri, driverProperties);

    validateConnectionProperties(properties);

    useSecureConnection = SSL.getRequiredValue(properties);

    initCatalogAndSchema();
  }

  public URI getJdbcUri() {
    return uri;
  }

  public String getSchema() {
    return schema;
  }

  public String getCatalog() {
    return catalog;
  }

  public URI getHttpUri() {
    return buildHttpUri();
  }

  public String getUser() throws SQLException {
    return USER.getRequiredValue(properties);
  }

  public Properties getProperties() {
    return properties;
  }

  private static Map<String, String> parseParameters(String query) throws SQLException {
    Map<String, String> result = new HashMap<>();

    if (query != null) {
      Iterable<String> queryArgs = QUERY_SPLITTER.split(query);
      for (String queryArg : queryArgs) {
        List<String> parts = ARG_SPLITTER.splitToList(queryArg);
        if (result.put(parts.get(0), parts.get(1)) != null) {
          throw new SQLException(format(
                      "Connection property '%s' is in URL multiple times",
                      parts.get(0)));
        }
      }
    }
    return result;
  }

  private static URI parseDriverUrl(String url) throws SQLException {
    URI uri;
    try {
      uri = new URI(url.substring(JDBC_URL_START.length()));
    } catch (URISyntaxException e) {
      throw new SQLException("Invalid JDBC URL: " + url, e);
    }
    if (isNullOrEmpty(uri.getHost())) {
      throw new SQLException("No host specified: " + url);
    }
    if (uri.getPort() == -1) {
      throw new SQLException("No port number specified: " + url);
    }
    if ((uri.getPort() < 1) || (uri.getPort() > 65535)) {
      throw new SQLException("Invalid port number: " + url);
    }
    return uri;
  }

  private URI buildHttpUri() {
    String scheme = useSecureConnection ? "https" : "http";
    try {
      return new URI(scheme, null, address.getHost(),
                     address.getPort(), null, null, null);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  private void initCatalogAndSchema() throws SQLException {
    String path = uri.getPath();
    if (isNullOrEmpty(uri.getPath()) || path.equals("/")) {
      return;
    }

    // remove first slash
    if (!path.startsWith("/")) {
      throw new SQLException("Path does not start with a slash: " + uri);
    }
    path = path.substring(1);

    List<String> parts = Splitter.on("/").splitToList(path);
    // remove last item due to a trailing slash
    if (parts.get(parts.size() - 1).isEmpty()) {
      parts = parts.subList(0, parts.size() - 1);
    }

    if (parts.size() > 2) {
      throw new SQLException("Invalid path segments in URL: " + uri);
    }

    if (parts.get(0).isEmpty()) {
      throw new SQLException("Catalog name is empty: " + uri);
    }
    catalog = parts.get(0);

    if (parts.size() > 1) {
      if (parts.get(1).isEmpty()) {
        throw new SQLException("Schema name is empty: " + uri);
      }
      schema = parts.get(1);
    }
  }

  private static Properties mergeConnectionProperties(URI uri, Properties driverProperties)
      throws SQLException {
    Map<String, String> defaults = ConnectionProperties.getDefaults();
    Map<String, String> urlProperties = parseParameters(uri.getQuery());
    Map<String, String> suppliedProperties = Maps.fromProperties(driverProperties);

    for (String key : urlProperties.keySet()) {
      if (suppliedProperties.containsKey(key)) {
        throw new SQLException(format(
                    "Connection property '%s' is both in the URL and an argument", key));
      }
    }

    Properties result = new Properties();
    setProperties(result, defaults);
    setProperties(result, urlProperties);
    setProperties(result, suppliedProperties);
    return result;
  }

  private static void setProperties(Properties properties, Map<String, String> values) {
    for (Entry<String, String> entry : values.entrySet()) {
      properties.setProperty(entry.getKey(), entry.getValue());
    }
  }

  private static void validateConnectionProperties(Properties connectionProperties)
      throws SQLException {
    for (String propertyName : connectionProperties.stringPropertyNames()) {
      if (ConnectionProperties.forKey(propertyName) == null) {
        throw new SQLException(format("Unrecognized connection property '%s'", propertyName));
      }
    }

    for (ConnectionProperty<?> property : ConnectionProperties.allProperties()) {
      property.validate(connectionProperties);
    }
  }
}
