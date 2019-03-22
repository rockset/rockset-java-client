package com.rockset.jdbc;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;

import com.rockset.client.model.Resource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RocksetDatabaseMetaData implements DatabaseMetaData {

  private static final String SEARCH_STRING_ESCAPE = "\\";

  private final RocksetConnection connection;

  RocksetDatabaseMetaData(RocksetConnection connection) {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData");
    this.connection = requireNonNull(connection, "connection is null");
  }

  @Override
  public boolean allProceduresAreCallable() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData allProceduresAreCallable");
    return false;
  }

  @Override
  public boolean allTablesAreSelectable() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData allTablesAreSelectable");
    return true;
  }

  @Override
  public String getURL() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData getURL");
    return connection.getUri().toString();
  }

  @Override
  public String getUserName() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData getUserName");
    return connection.getUser();
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData isReadOnly");
    return connection.isReadOnly();
  }

  @Override
  public boolean nullsAreSortedHigh() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData nullsAreSortedHigh");
    return false;
  }

  @Override
  public boolean nullsAreSortedLow() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData nullsAreSortedLow");
    return false;
  }

  @Override
  public boolean nullsAreSortedAtStart() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData nullsAreSortedAtStart false");
    return false;
  }

  @Override
  public boolean nullsAreSortedAtEnd() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData nullsAreSortedAtEnd false");
    return true;
  }

  @Override
  public String getDatabaseProductName() throws SQLException {
    return "Rockset";
  }

  @Override
  public String getDatabaseProductVersion() throws SQLException {
    return "v1";
  }

  @Override
  public String getDriverName() throws SQLException {
    return RocksetDriver.DRIVER_NAME;
  }

  @Override
  public String getDriverVersion() throws SQLException {
    return RocksetDriver.DRIVER_VERSION;
  }

  @Override
  public int getDriverMajorVersion() {
    return RocksetDriver.DRIVER_VERSION_MAJOR;
  }

  @Override
  public int getDriverMinorVersion() {
    return RocksetDriver.DRIVER_VERSION_MINOR;
  }

  @Override
  public boolean usesLocalFiles() throws SQLException {
    return false;
  }

  @Override
  public boolean usesLocalFilePerTable() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsMixedCaseIdentifiers() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData supportsMixedCaseIdentifiers false");
    return false;
  }

  @Override
  public boolean storesUpperCaseIdentifiers() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData storesUpperCaseIdentifiers false");
    return false;
  }

  @Override
  public boolean storesLowerCaseIdentifiers() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData storesLowerCaseIdentifiers true");
    return true;
  }

  @Override
  public boolean storesMixedCaseIdentifiers() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData storesMixedCaseIdentifiers false");
    return false;
  }

  @Override
  public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
    // TODO: support quoted identifiers properly
    RocksetDriver.log("Entry: RocksetDatabaseMetaData supportsMixedCaseQuotedIdentifiers false");
    return false;
  }

  @Override
  public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData storesUpperCaseQuotedIdentifiers false");
    return false;
  }

  @Override
  public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
    // TODO: support quoted identifiers properly
    RocksetDriver.log("Entry: RocksetDatabaseMetaData storesLowerCaseQuotedIdentifiers true");
    return true;
  }

  @Override
  public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
    // TODO: support quoted identifiers properly
    RocksetDriver.log("Entry: RocksetDatabaseMetaData storesMixedCaseQuotedIdentifiers false");
    return false;
  }

  @Override
  public String getIdentifierQuoteString() throws SQLException {
    return "\"";
  }

  @Override
  public String getSQLKeywords() throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData getSQLKeywords ");
    return "LIMIT";
  }

  @Override
  public String getNumericFunctions() throws SQLException {
    return "";
  }

  @Override
  public String getStringFunctions() throws SQLException {
    return "";
  }

  @Override
  public String getSystemFunctions() throws SQLException {
    return "";
  }

  @Override
  public String getTimeDateFunctions() throws SQLException {
    return "";
  }

  @Override
  public String getSearchStringEscape() throws SQLException {
    return SEARCH_STRING_ESCAPE;
  }

  @Override
  public String getExtraNameCharacters() throws SQLException {
    return "";
  }

  @Override
  public boolean supportsAlterTableWithAddColumn() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsAlterTableWithDropColumn() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsColumnAliasing() throws SQLException {
    return true;
  }

  @Override
  public boolean nullPlusNonNullIsNull() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsConvert() throws SQLException {
    // TODO: support convert
    return false;
  }

  @Override
  public boolean supportsConvert(int fromType, int toType) throws SQLException {
    // TODO: support convert
    return false;
  }

  @Override
  public boolean supportsTableCorrelationNames() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsDifferentTableCorrelationNames() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsExpressionsInOrderBy() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsOrderByUnrelated() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGroupBy() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGroupByUnrelated() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGroupByBeyondSelect() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsLikeEscapeClause() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMultipleResultSets() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsMultipleTransactions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsNonNullableColumns() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMinimumSQLGrammar() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCoreSQLGrammar() throws SQLException {
    // TODO: support this
    return false;
  }

  @Override
  public boolean supportsExtendedSQLGrammar() throws SQLException {
    // TODO: support this
    return false;
  }

  @Override
  public boolean supportsANSI92EntryLevelSQL() throws SQLException {
    // TODO: verify this
    return true;
  }

  @Override
  public boolean supportsANSI92IntermediateSQL() throws SQLException {
    // TODO: support this
    return false;
  }

  @Override
  public boolean supportsANSI92FullSQL() throws SQLException {
    // TODO: support this
    return false;
  }

  @Override
  public boolean supportsIntegrityEnhancementFacility() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOuterJoins() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsFullOuterJoins() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsLimitedOuterJoins() throws SQLException {
    return true;
  }

  @Override
  public String getSchemaTerm() throws SQLException {
    return "workspace";
  }

  @Override
  public String getProcedureTerm() throws SQLException {
    return "procedure";
  }

  @Override
  public String getCatalogTerm() throws SQLException {
    return "catalog";
  }

  @Override
  public boolean isCatalogAtStart() throws SQLException {
    return true;
  }

  @Override
  public String getCatalogSeparator() throws SQLException {
    return ".";
  }

  @Override
  public boolean supportsSchemasInDataManipulation() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSchemasInProcedureCalls() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSchemasInTableDefinitions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSchemasInIndexDefinitions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCatalogsInDataManipulation() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCatalogsInProcedureCalls() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCatalogsInTableDefinitions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsPositionedDelete() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsPositionedUpdate() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSelectForUpdate() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsStoredProcedures() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSubqueriesInComparisons() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSubqueriesInExists() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSubqueriesInIns() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSubqueriesInQuantifieds() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCorrelatedSubqueries() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsUnion() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsUnionAll() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
    return false;
  }

  @Override
  public int getMaxBinaryLiteralLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxCharLiteralLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnNameLength() throws SQLException {
    // TODO: define max identifier length
    return 0;
  }

  @Override
  public int getMaxColumnsInGroupBy() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnsInIndex() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnsInOrderBy() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnsInSelect() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnsInTable() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxConnections() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxCursorNameLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxIndexLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxSchemaNameLength() throws SQLException {
    // TODO: define max identifier length
    return 0;
  }

  @Override
  public int getMaxProcedureNameLength() throws SQLException {
    // TODO: define max identifier length
    return 0;
  }

  @Override
  public int getMaxCatalogNameLength() throws SQLException {
    // TODO: define max identifier length
    return 0;
  }

  @Override
  public int getMaxRowSize() throws SQLException {
    return 0;
  }

  @Override
  public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
    return true;
  }

  @Override
  public int getMaxStatementLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxStatements() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxTableNameLength() throws SQLException {
    // TODO: define max identifier length
    return 0;
  }

  @Override
  public int getMaxTablesInSelect() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxUserNameLength() throws SQLException {
    // TODO: define max identifier length
    return 0;
  }

  @Override
  public int getDefaultTransactionIsolation() throws SQLException {
    return Connection.TRANSACTION_READ_UNCOMMITTED;
  }

  @Override
  public boolean supportsTransactions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
    return true;
  }

  @Override
  public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
    return false;
  }

  @Override
  public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
    return false;
  }

  @Override
  public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
    return false;
  }

  //
  // Returns a relation with 9 columns and 0 rows
  // SELECT PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME,
  // null, null, null, REMARKS, PROCEDURE_TYPE, SPECIFIC_NAME
  //
  @Override
  public ResultSet getProcedures(String catalog, String schemaPattern,
          String procedureNamePattern) throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData getProcedures");
    Column col1 = new Column("PROCEDURE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("PROCEDURE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("PROCEDURE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("null", Column.ColumnTypes.NULL);
    Column col5 = new Column("null", Column.ColumnTypes.NULL);
    Column col6 = new Column("null", Column.ColumnTypes.NULL);
    Column col7 = new Column("REMARKS", Column.ColumnTypes.STRING);
    Column col8 = new Column("PROCEDURE_TYPE", Column.ColumnTypes.STRING);
    Column col9 = new Column("SPECIFIC_NAME", Column.ColumnTypes.STRING);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    columns.add(col5);
    columns.add(col6);
    columns.add(col7);
    columns.add(col8);
    columns.add(col9);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getProcedures");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  //
  // Returns a relation with 20 columns and 0 rows.
  // SELECT PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME, 
  // COLUMN_NAME, COLUMN_TYPE, DATA_TYPE, TYPE_NAME,
  // PRECISION, LENGTH, SCALE, RADIX,\n"
  // NULLABLE, REMARKS, COLUMN_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB,
  // CHAR_OCTET_LENGTH, ORDINAL_POSITION, IS_NULLABLE, SPECIFIC_NAME
  //
  @Override
  public ResultSet getProcedureColumns(String catalog, String schemaPattern,
          String procedureNamePattern, String columnNamePattern) throws SQLException {
    RocksetDriver.log("Entry: RocksetDatabaseMetaData getProcedureColumns");
    Column col1 = new Column("PROCEDURE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("PROCEDURE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("PROCEDURE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("COLUMN_NAME", Column.ColumnTypes.STRING);
    Column col5 = new Column("COLUMN_TYPE", Column.ColumnTypes.NUMBER);
    Column col6 = new Column("DATA_TYPE", Column.ColumnTypes.NUMBER);
    Column col7 = new Column("TYPE_NAME", Column.ColumnTypes.STRING);
    Column col8 = new Column("PRECISION", Column.ColumnTypes.NUMBER);
    Column col9 = new Column("LENGTH", Column.ColumnTypes.NUMBER);
    Column col10 = new Column("SCALE", Column.ColumnTypes.NUMBER);
    Column col11 = new Column("RADIX", Column.ColumnTypes.NUMBER);
    Column col12 = new Column("NULLABLE", Column.ColumnTypes.NUMBER);
    Column col13 = new Column("REMARKS", Column.ColumnTypes.STRING);
    Column col14 = new Column("COLUMN_DEF", Column.ColumnTypes.STRING);
    Column col15 = new Column("SQL_DATA_TYPE", Column.ColumnTypes.NUMBER);
    Column col16 = new Column("SQL_DATETIME_SUB", Column.ColumnTypes.NUMBER);
    Column col17 = new Column("CHAR_OCTET_LENGTH", Column.ColumnTypes.NUMBER);
    Column col18 = new Column("ORDINAL_POSITION", Column.ColumnTypes.NUMBER);
    Column col19 = new Column("IS_NULLABLE", Column.ColumnTypes.STRING);
    Column col20 = new Column("SPECIFIC_NAME", Column.ColumnTypes.STRING);

    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    columns.add(col5);
    columns.add(col6);
    columns.add(col7);
    columns.add(col8);
    columns.add(col9);
    columns.add(col10);
    columns.add(col11);
    columns.add(col12);
    columns.add(col13);
    columns.add(col14);
    columns.add(col15);
    columns.add(col16);
    columns.add(col17);
    columns.add(col18);
    columns.add(col19);
    columns.add(col20);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getProcedureColumns");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  //
  // Returns a list of rows with the following columns:
  // SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, TABLE_TYPE, REMARKS,
  // TYPE_CAT, TYPE_SCHEM, TYPE_NAME, 
  // SELF_REFERENCING_COL_NAME, REF_GENERATION
  //
  @Override
  public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern,
          String[] types) throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getTables");
    try {
      Column col1 = new Column("TABLE_CAT", Column.ColumnTypes.STRING);
      Column col2 = new Column("TABLE_SCHEM", Column.ColumnTypes.STRING);
      Column col3 = new Column("TABLE_NAME", Column.ColumnTypes.STRING);
      Column col4 = new Column("TABLE_TYPE", Column.ColumnTypes.STRING);
      Column col5 = new Column("REMARKS", Column.ColumnTypes.STRING);
      Column col6 = new Column("TYPE_CAT", Column.ColumnTypes.STRING);
      Column col7 = new Column("TYPE_SCHEM", Column.ColumnTypes.STRING);
      Column col8 = new Column("TYPE_NAME", Column.ColumnTypes.STRING);
      Column col9 = new Column("SELF_REFERENCING_COL_NAME", Column.ColumnTypes.STRING);
      Column col10 = new Column("REF_GENERATION", Column.ColumnTypes.STRING);
      ArrayList<Column> columns = new ArrayList<Column>();
      columns.add(col1);
      columns.add(col2);
      columns.add(col3);
      columns.add(col4);
      columns.add(col5);
      columns.add(col6);
      columns.add(col7);
      columns.add(col8);
      columns.add(col9);
      columns.add(col10);

      // Fetch all collections and sort them.
      List<Resource> collections =  connection.listCollections();
      Collections.sort(collections, new Comparator<Resource>() {
          public int compare(Resource r1, Resource r2) {
            return r1.getName().compareTo(r2.getName());
          }
        });

      // each row refers to a collection
      ObjectMapper mapper = new ObjectMapper();
      List<Object> data = new ArrayList<Object>();
      for (Resource collection:  collections) {
        String str = "{\"TABLE_CAT\": \"" + RocksetConnection.DEFAULT_CATALOG + "\""
                    + ", \"TABLE_SCHEM\": \"" + RocksetConnection.DEFAULT_SCHEMA + "\""
                    + ", \"TABLE_NAME\": \"" + collection.getName()  + "\""
                    + ", \"TABLE_TYPE\": \"" + "TABLE" + "\""
                    + ", \"TYPE_CAT\": \"\""
                    + ", \"TYPE_SCHEM\": \"\""
                    + ", \"TYPE_NAME\": \"\""
                    + ", \"SELF_REFERENCING_COL_NAME\": \"\""
                    + ", \"REF_GENERATION\": \"\"";
        if (collection.getDescription() != null) {
          str += ", \"REMARKS\": \"" + collection.getDescription() + "\"";
        } else {
          str += ", \"REMARKS\": \"\"";
        }
        str += " }";
        JsonNode docRootNode = mapper.readTree(str);
        data.add(docRootNode);
      }
      RocksetDriver.log("Exit : RocksetDatabaseMetaData getTables");
      return new RocksetResultSet(columns, data);
    } catch (Exception e) {
      throw new SQLException("Error processing getTables "
                      + " exception " + e.getMessage());
    }
  }

  //
  // Returns a relation with two columns and one row
  // "SELECT TABLE_SCHEM, TABLE_CATALOG"
  //
  @Override
  public ResultSet getSchemas() throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getSchemas");
    Column col1 = new Column("TABLE_SCHEM", Column.ColumnTypes.STRING);
    Column col2 = new Column("TABLE_CATALOG", Column.ColumnTypes.STRING);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);

    try {
      ObjectMapper mapper = new ObjectMapper();
      String str = "{\"TABLE_SCHEM\": \"" + RocksetConnection.DEFAULT_SCHEMA
                    + "\", \"TABLE_CATALOG\": \""
                    + RocksetConnection.DEFAULT_CATALOG
                    + "\" }";
      JsonNode docRootNode = mapper.readTree(str);
      List<Object> data = new ArrayList<Object>();
      data.add(docRootNode);
      RocksetDriver.log("Exit : RocksetDatabaseMetaData getSchemas");
      return new RocksetResultSet(columns, data);
    } catch (Exception e) {
      throw new SQLException("Error processing getSchemas "
                      + " exception " + e.getMessage());
    }
  }

  //
  // Returns a relation with one column and one row
  // "SELECT TABLE_CAT"
  //
  @Override
  public ResultSet getCatalogs() throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getCatalogs");
    Column col1 = new Column("TABLE_CAT", Column.ColumnTypes.STRING);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);

    try {
      ObjectMapper mapper = new ObjectMapper();
      String str = "{\"TABLE_CAT\": \"" + RocksetConnection.DEFAULT_CATALOG
                    + "\" }";
      JsonNode docRootNode = mapper.readTree(str);
      List<Object> data = new ArrayList<Object>();
      data.add(docRootNode);
      RocksetDriver.log("Exit : RocksetDatabaseMetaData getCatalogs");
      return new RocksetResultSet(columns, data);
    } catch (Exception e) {
      throw new SQLException("Error processing getCatalogs "
                      + " exception " + e.getMessage());
    }
  }

  //
  // Returns a relation with one columns and one row
  // "SELECT TABLE_TYPE"
  //
  @Override
  public ResultSet getTableTypes() throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getTableTypes");
    Column col1 = new Column("TABLE_TYPE", Column.ColumnTypes.STRING);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);

    try {
      ObjectMapper mapper = new ObjectMapper();
      String str = "{\"TABLE_TYPE\": \"TABLE\" }";
      JsonNode docRootNode = mapper.readTree(str);
      List<Object> data = new ArrayList<Object>();
      data.add(docRootNode);
      RocksetDriver.log("Exit : RocksetDatabaseMetaData getTableTypes");
      return new RocksetResultSet(columns, data);
    } catch (Exception e) {
      throw new SQLException("Error processing getTableTypes "
                      + " exception " + e.getMessage());
    }
  }

  //
  // Return the column information.
  // SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, DATA_TYPE,
  // TYPE_NAME, COLUMN_SIZE, BUFFER_LENGTH, DECIMAL_DIGITS, NUM_PREC_RADIX,
  // NULLABLE, REMARKS, COLUMN_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB,
  // CHAR_OCTET_LENGTH, ORDINAL_POSITION, IS_NULLABLE,
  // SCOPE_CATALOG, SCOPE_SCHEMA, SCOPE_TABLE,
  // SOURCE_DATA_TYPE, IS_AUTOINCREMENT, IS_GENERATEDCOLUMN
  //
  @Override
  public ResultSet getColumns(String catalog, String schemaPattern,
          String tableNamePattern, String columnNamePattern) throws SQLException {
    // TODO: XXX filter matching table names. For now, support exact match.
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getColumns");

    try {
      List<Resource> collections =  connection.listCollections();
      for (Resource collection: collections) {
        if (collection.getName().equals(tableNamePattern)) {
          RocksetTable table = new RocksetTable(tableNamePattern,
                connection.describeTable(tableNamePattern));
          ResultSet resultSet = table.getColumns();
          RocksetDriver.log("Exit : RocksetDatabaseMetaData getColumns");
          return resultSet;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new SQLException("Error processing getColumns "
                             + " exception " + e.getMessage());
    }
    throw new SQLException("No matching table name found.");
  }

  @Override
  public ResultSet getColumnPrivileges(String catalog, String schema,
          String table, String columnNamePattern) throws SQLException {
    throw new SQLFeatureNotSupportedException("privileges not supported");
  }

  @Override
  public ResultSet getTablePrivileges(String catalog, String schemaPattern,
          String tableNamePattern) throws SQLException {
    throw new SQLFeatureNotSupportedException("privileges not supported");
  }

  @Override
  public ResultSet getBestRowIdentifier(String catalog, String schema,
          String table, int scope, boolean nullable) throws SQLException {
    throw new SQLFeatureNotSupportedException("row identifiers not supported");
  }

  @Override
  public ResultSet getVersionColumns(String catalog, String schema, String table)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("version columns not supported");
  }

  @Override
  public ResultSet getPrimaryKeys(String catalog, String schema, String table)
      throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getPrimaryKeys");
    try {
      Column col1 = new Column("TABLE_CAT", Column.ColumnTypes.STRING);
      Column col2 = new Column("TABLE_SCHEM", Column.ColumnTypes.STRING);
      Column col3 = new Column("TABLE_NAME", Column.ColumnTypes.STRING);
      Column col4 = new Column("COLUMN_NAME", Column.ColumnTypes.STRING);
      Column col5 = new Column("KEY_SEQ", Column.ColumnTypes.NUMBER);
      Column col6 = new Column("PK_NAME", Column.ColumnTypes.STRING);
      ArrayList<Column> columns = new ArrayList<Column>();
      columns.add(col1);
      columns.add(col2);
      columns.add(col3);
      columns.add(col4);
      columns.add(col5);
      columns.add(col6);

      ObjectMapper mapper = new ObjectMapper();
      List<Object> data = new ArrayList<Object>();
      String str = "{\"TABLE_CAT\": \"" + RocksetConnection.DEFAULT_CATALOG + "\""
                    + ", \"TABLE_SCHEM\": \"" + RocksetConnection.DEFAULT_SCHEMA + "\""
                    + ", \"TABLE_NAME\": \"" + table  + "\""
                    + ", \"COLUMN_NAME\": \"" + "_id" + "\""
                    + ", \"KEY_SEQ\": " + 1
                    + ", \"PK_NAME\": \"" + "_id" + "\"";

      str += " }";
      JsonNode docRootNode = mapper.readTree(str);
      data.add(docRootNode);
      RocksetDriver.log("Exit : RocksetDatabaseMetaData getPrimaryKeys");
      return new RocksetResultSet(columns, data);
    } catch (Exception e) {
      throw new SQLException("Error processing getPrimaryKeys "
                      + " exception " + e.getMessage());
    }
  }

  @Override
  public ResultSet getImportedKeys(String catalog, String schema, String table)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("imported keys not supported");
  }

  @Override
  public ResultSet getExportedKeys(String catalog, String schema, String table)
      throws SQLException {
    throw new SQLFeatureNotSupportedException("exported keys not supported");
  }

  @Override
  public ResultSet getCrossReference(String parentCatalog, String parentSchema,
          String parentTable, String foreignCatalog, String foreignSchema,
          String foreignTable) throws SQLException {
    throw new SQLFeatureNotSupportedException("cross reference not supported");
  }

  //
  // Returns a list of all supported data types.
  // SELECT TYPE_NAME, DATA_TYPE, PRECISION, LITERAL_PREFIX, LITERAL_SUFFIX,
  // CREATE_PARAMS, NULLABLE, CASE_SENSITIVE, SEARCHABLE, UNSIGNED_ATTRIBUTE,
  // FIXED_PREC_SCALE, AUTO_INCREMENT, LOCAL_TYPE_NAME, MINIMUM_SCALE, MAXIMUM_SCALE,
  // SQL_DATA_TYPE, SQL_DATETIME_SUB, NUM_PREC_RADIX
  //
  @Override
  public ResultSet getTypeInfo() throws SQLException {
    // TODO: XXX
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getTypeInfo");
    return null;
  }

  @Override
  public ResultSet getIndexInfo(String catalog, String schema,
          String table, boolean unique, boolean approximate) throws SQLException {
    throw new SQLFeatureNotSupportedException("indexes not supported");
  }

  @Override
  public boolean supportsResultSetType(int type) throws SQLException {
    return type == ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
    return (type == ResultSet.TYPE_FORWARD_ONLY)
        && (concurrency == ResultSet.CONCUR_READ_ONLY);
  }

  @Override
  public boolean ownUpdatesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean ownDeletesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean ownInsertsAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean othersUpdatesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean othersDeletesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean othersInsertsAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean updatesAreDetected(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean deletesAreDetected(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean insertsAreDetected(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean supportsBatchUpdates() throws SQLException {
    // TODO: support batch updates
    return false;
  }

  //
  // Returns a relation with 0 rows and 7 columns.
  // SELECT TYPE_CAT, TYPE_SCHEM, TYPE_NAME,
  // CLASS_NAME, DATA_TYPE, REMARKS, BASE_TYPE
  //
  @Override
  public ResultSet getUDTs(String catalog, String schemaPattern,
          String typeNamePattern, int[] types) throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getUDTs");
    Column col1 = new Column("TYPE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("TYPE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("TYPE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("CLASS_NAME", Column.ColumnTypes.NULL);
    Column col5 = new Column("DATA_TYPE", Column.ColumnTypes.NUMBER);
    Column col6 = new Column("REMARKS", Column.ColumnTypes.NULL);
    Column col7 = new Column("BASE_TYPE", Column.ColumnTypes.NUMBER);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    columns.add(col5);
    columns.add(col6);
    columns.add(col7);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getUDTs");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  @Override
  public Connection getConnection() throws SQLException {
    return connection;
  }

  @Override
  public boolean supportsSavepoints() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsNamedParameters() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMultipleOpenResults() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsGetGeneratedKeys() throws SQLException {
    return false;
  }

  //
  // Returns a relation with 0 rows.
  // SELECT TYPE_CAT, TYPE_SCHEM, TYPE_NAME,
  // SUPERTYPE_CAT, SUPERTYPE_SCHEM, SUPERTYPE_NAME
  //
  @Override
  public ResultSet getSuperTypes(String catalog, String schemaPattern,
          String typeNamePattern) throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getSuperTypes");
    Column col1 = new Column("TYPE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("TYPE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("TYPE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("SUPERTYPE_CAT", Column.ColumnTypes.STRING);
    Column col5 = new Column("SUPERTYPE_SCHEM", Column.ColumnTypes.STRING);
    Column col6 = new Column("SUPERTYPE_NAME", Column.ColumnTypes.STRING);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    columns.add(col5);
    columns.add(col6);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getSuperTypes");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  //
  // Returns a relation with 0 rows.
  // SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, SUPERTABLE_NAME
  //
  @Override
  public ResultSet getSuperTables(String catalog, String schemaPattern,
          String tableNamePattern) throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getSuperTables");
    Column col1 = new Column("TABLE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("TABLE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("TABLE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("SUPERTABLE_NAME", Column.ColumnTypes.STRING);
    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getSuperTables");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  //
  // Returns a relation with 0 rows and 21 columns.
  // SELECT TYPE_CAT, TYPE_SCHEM, TYPE_NAME, ATTR_NAME, DATA_TYPE
  // ATTR_TYPE_NAME, ATTR_SIZE, DECIMAL_DIGITS, NUM_PREC_RADIX, NULLABLE,
  // REMARKS, ATTR_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB, CHAR_OCTET_LENGTH,
  // ORDINAL_POSITION, IS_NULLABLE, SCOPE_CATALOG, SCOPE_SCHEMA, SCOPE_TABLE,
  // SOURCE_DATA_TYPE
  //
  @Override
  public ResultSet getAttributes(String catalog, String schemaPattern,
          String typeNamePattern, String attributeNamePattern) throws SQLException {
    RocksetDriver.log("Entry : RocksetDatabaseMetaData getAttributes");
    Column col1 = new Column("TYPE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("TYPE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("TYPE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("ATTR_NAME", Column.ColumnTypes.STRING);
    Column col5 = new Column("DATA_TYPE", Column.ColumnTypes.NUMBER);
    Column col6 = new Column("ATTR_TYPE_NAME", Column.ColumnTypes.STRING);
    Column col7 = new Column("ATTR_SIZE", Column.ColumnTypes.NUMBER);
    Column col8 = new Column("DECIMAL_DIGITS", Column.ColumnTypes.NUMBER);
    Column col9 = new Column("NUM_PREC_RADIX", Column.ColumnTypes.NUMBER);
    Column col10 = new Column("NULLABLE", Column.ColumnTypes.NUMBER);
    Column col11 = new Column("REMARKS", Column.ColumnTypes.STRING);
    Column col12 = new Column("ATTR_DEF", Column.ColumnTypes.NUMBER);
    Column col13 = new Column("SQL_DATA_TYPE", Column.ColumnTypes.NUMBER);
    Column col14 = new Column("SQL_DATETIME_SUB", Column.ColumnTypes.NUMBER);
    Column col15 = new Column("CHAR_OCTET_LENGTH", Column.ColumnTypes.NUMBER);
    Column col16 = new Column("ORDINAL_POSITION", Column.ColumnTypes.NUMBER);
    Column col17 = new Column("IS_NULLABLE", Column.ColumnTypes.STRING);
    Column col18 = new Column("SCOPE_CATALOG", Column.ColumnTypes.STRING);
    Column col19 = new Column("SCOPE_SCHEMA", Column.ColumnTypes.STRING);
    Column col20 = new Column("SCOPE_TABLE", Column.ColumnTypes.STRING);
    Column col21 = new Column("SOURCE_DATA_TYPE", Column.ColumnTypes.NUMBER);

    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    columns.add(col5);
    columns.add(col6);
    columns.add(col7);
    columns.add(col8);
    columns.add(col9);
    columns.add(col10);
    columns.add(col11);
    columns.add(col12);
    columns.add(col13);
    columns.add(col14);
    columns.add(col15);
    columns.add(col16);
    columns.add(col17);
    columns.add(col18);
    columns.add(col19);
    columns.add(col20);
    columns.add(col21);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getAttributes");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  @Override
  public boolean supportsResultSetHoldability(int holdability) throws SQLException {
    return holdability == ResultSet.HOLD_CURSORS_OVER_COMMIT;
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    return ResultSet.HOLD_CURSORS_OVER_COMMIT;
  }

  @Override
  public int getDatabaseMajorVersion() throws SQLException {
    return getDatabaseVersionPart(0);
  }

  @Override
  public int getDatabaseMinorVersion() throws SQLException {
    return getDatabaseVersionPart(1);
  }

  private int getDatabaseVersionPart(int part) throws SQLException {
    String version = getDatabaseProductVersion();
    List<String> parts = Splitter.on('.').limit(3).splitToList(version);
    try {
      return parseInt(parts.get(part));
    } catch (IndexOutOfBoundsException | NumberFormatException e) {
      return 0;
    }
  }

  @Override
  public int getJDBCMajorVersion() throws SQLException {
    return 4;
  }

  @Override
  public int getJDBCMinorVersion() throws SQLException {
    return 2;
  }

  @Override
  public int getSQLStateType() throws SQLException {
    return DatabaseMetaData.sqlStateSQL;
  }

  @Override
  public boolean locatorsUpdateCopy() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsStatementPooling() throws SQLException {
    return false;
  }

  @Override
  public RowIdLifetime getRowIdLifetime() throws SQLException {
    return RowIdLifetime.ROWID_UNSUPPORTED;
  }

  @Override
  public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
    return getSchemas();
  }

  @Override
  public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
    return false;
  }

  @Override
  public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
    return false;
  }

  @Override
  public ResultSet getClientInfoProperties() throws SQLException {
    RocksetDriver.log("Enter : RocksetDatabaseMetaData getClientInfoProperties");
    throw new NotImplementedException("DatabaseMetaData", "getClientInfoProperties");
  }

  @Override
  public ResultSet getFunctions(String catalog, String schemaPattern,
          String functionNamePattern) throws SQLException {
    throw new NotImplementedException("DatabaseMetaData", "getFunctions");
  }

  @Override
  public ResultSet getFunctionColumns(String catalog, String schemaPattern,
          String functionNamePattern, String columnNamePattern) throws SQLException {
    throw new NotImplementedException("DatabaseMetaData", "getFunctionColumns");
  }

  //
  // Returns a relation with 12 columns and 0 rows
  // SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, DATA_TYPE,
  // COLUMN_SIZE, DECIMAL_DIGITS, NUM_PREC_RADIX, COLUMN_USAGE, REMARKS,
  // CHAR_OCTET_LENGTH, IS_NULLABLE\
  //
  @Override
  public ResultSet getPseudoColumns(String catalog, String schemaPattern,
          String tableNamePattern, String columnNamePattern) throws SQLException {
    RocksetDriver.log("Enter : RocksetDatabaseMetaData getPseudoColumns");
    Column col1 = new Column("TABLE_CAT", Column.ColumnTypes.STRING);
    Column col2 = new Column("TABLE_SCHEM", Column.ColumnTypes.STRING);
    Column col3 = new Column("TABLE_NAME", Column.ColumnTypes.STRING);
    Column col4 = new Column("COLUMN_NAME", Column.ColumnTypes.STRING);
    Column col5 = new Column("DATA_TYPE", Column.ColumnTypes.NUMBER);
    Column col6 = new Column("COLUMN_SIZE", Column.ColumnTypes.NUMBER);
    Column col7 = new Column("DECIMAL_DIGITS", Column.ColumnTypes.NUMBER);
    Column col8 = new Column("NUM_PREC_RADIX", Column.ColumnTypes.NUMBER);
    Column col9 = new Column("COLUMN_USAGE", Column.ColumnTypes.STRING);
    Column col10 = new Column("REMARKS", Column.ColumnTypes.STRING);
    Column col11 = new Column("CHAR_OCTET_LENGTH", Column.ColumnTypes.NUMBER);
    Column col12 = new Column("IS_NULLABLE", Column.ColumnTypes.STRING);

    ArrayList<Column> columns = new ArrayList<Column>();
    columns.add(col1);
    columns.add(col2);
    columns.add(col3);
    columns.add(col4);
    columns.add(col5);
    columns.add(col6);
    columns.add(col7);
    columns.add(col8);
    columns.add(col9);
    columns.add(col10);
    columns.add(col11);
    columns.add(col12);
    RocksetDriver.log("Exit : RocksetDatabaseMetaData getPseudoColumns");
    return new RocksetResultSet(columns, new ArrayList<Object>());
  }

  @Override
  public boolean generatedKeyAlwaysReturned() throws SQLException {
    return false;
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

  private ResultSet select(String sql) throws SQLException {
    try (Statement statement = getConnection().createStatement()) {
      return statement.executeQuery(sql);
    }
  }

}
