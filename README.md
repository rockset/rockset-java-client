# rockset-java-client

Official Java client library and JDBC driver for Rockset.

## Requirements

Building the API client library requires:
1. Java 1.8
2. Maven

## Installation

Set ROCKSET_APIKEY to run tests along with installation:
```
mvn package
```

To skip the tests:
```
mvn package -DskipTests
```

This will create a jar file rockset-java-${version}.jar

### Usage

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.rockset</groupId>
  <artifactId>rockset-java</artifactId>
  <version>...</version>
</dependency>
```

You can see a few [sample examples](https://github.com/rockset/rockset-java-client/blob/master/src/main/java/com/rockset/examples) of how to create a collection, how to put documents in a collection and how to use SQL to query your collections. There are also a set of [javadocs](https://rockset.com/docs/client/java/) that you can look to build your application.

## Testing
Set ROCKSET_APIKEY with the API key in the environment variables. To run test:
```
mvn test
```

## Scala Considerations

If using [Scala](https://www.scala-lang.org/), we recommend converting scala map and object types to java maps and collections (e.g. `java.util.LinkedHashMap`) rather than using the native Scala types with this java client.

## Support

Feel free to log issues against this client through GitHub.

## JDBC

The Rockset JDBC driver is packaged as part of this java client. Here is [one example](https://github.com/rockset/rockset-java-client/blob/master/src/test/java/com/rockset/jdbc/FirstExample.java) that shows how to use it.

A JDBC schema corresponds to a Rockset workspace. 
To scope your queries to a particular workspace without needing to fully qualify the workspace name, set the schema on the connection object.
```java
Connection connection = DriverManager.getConnection(...);
connection.setSchema("my_workspace");
```
To see the behavior of this configuration, look at the [Schema Tests](https://github.com/rockset/rockset-java-client/blob/master/src/test/java/com/rockset/jdbc/TestSchema.java).

## License

The Rockset Java Client is licensed under the [Apache 2.0 License](https://github.com/rockset/rockset-java-client/blob/master/LICENSE)
