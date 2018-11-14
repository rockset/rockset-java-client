# rockset-java-client

Official Java client library for Rockset.

## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven

## Installation

mvn package

This will create a jar file rockset-java-${version}.jar

### Usage

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.rockset</groupId>
  <artifactId>rockset-java</artifactId>
  <version>0.4.8</version>
</dependency>
```

You can see a few [sample examples](https://github.com/rockset/rockset-java-client/tree/dhruba_feedback/examples) of how to create a collection, how to put documents in a collection and how to use SQL to query your collections. There are also a set of [javadocs](http://docs.rockset.com/java-client/com/rockset/client/RocksetClient.html) that you can look to build your application.

## Testing
Set ROCKSET_APIKEY and ROCKSET_APISERVER endpoint in the environment variables. To run test:
```
mvn test
```

## Support

Feel free to log issues against this client through GitHub.

## License

The Rockset Java Client is licensed under the [MIT License](https://github.com/rockset/rockset-java-client/blob/master/LICENSE)
