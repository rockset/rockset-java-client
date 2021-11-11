package com.rockset.client;

import static org.testng.Assert.assertEquals;

import com.rockset.client.model.*;
import org.testng.annotations.Test;

public class TestRocksetClient {

  // From ApiClient.java
  private static final int DEFAULT_CONNECT_TIMEOUT = 140000;
  private static final int DEFAULT_READ_TIMEOUT = 140000;
  private static final int DEFAULT_WRITE_TIMEOUT = 10000;

  @Test
  public void testSetTimeouts() {
    String apiKey = "apiKey";
    String apiServer = "apiServer";

    RocksetClient client;

    client = new RocksetClient(apiKey, apiServer);
    assertEquals(client.getConnectTimeout(), DEFAULT_CONNECT_TIMEOUT);
    assertEquals(client.getReadTimeout(), DEFAULT_READ_TIMEOUT);
    assertEquals(client.getWriteTimeout(), DEFAULT_WRITE_TIMEOUT);

    client = new RocksetClient(apiKey, apiServer).setConnectTimeout(1337);
    assertEquals(client.getConnectTimeout(), 1337);
    assertEquals(client.getReadTimeout(), DEFAULT_READ_TIMEOUT);
    assertEquals(client.getWriteTimeout(), DEFAULT_WRITE_TIMEOUT);

    client = new RocksetClient(apiKey, apiServer).setReadTimeout(42);
    assertEquals(client.getConnectTimeout(), DEFAULT_CONNECT_TIMEOUT);
    assertEquals(client.getReadTimeout(), 42);
    assertEquals(client.getWriteTimeout(), DEFAULT_WRITE_TIMEOUT);

    client = new RocksetClient(apiKey, apiServer).setConnectTimeout(1337).setReadTimeout(42);
    assertEquals(client.getConnectTimeout(), 1337);
    assertEquals(client.getReadTimeout(), 42);
    assertEquals(client.getWriteTimeout(), DEFAULT_WRITE_TIMEOUT);

    client = new RocksetClient(apiKey, apiServer).setWriteTimeout(123);
    assertEquals(client.getConnectTimeout(), DEFAULT_CONNECT_TIMEOUT);
    assertEquals(client.getReadTimeout(), DEFAULT_READ_TIMEOUT);
    assertEquals(client.getWriteTimeout(), 123);

    client = new RocksetClient(apiKey, apiServer).setConnectTimeout(1337).setWriteTimeout(123);
    assertEquals(client.getConnectTimeout(), 1337);
    assertEquals(client.getReadTimeout(), DEFAULT_READ_TIMEOUT);
    assertEquals(client.getWriteTimeout(), 123);

    client = new RocksetClient(apiKey, apiServer).setReadTimeout(42).setWriteTimeout(123);
    assertEquals(client.getConnectTimeout(), DEFAULT_CONNECT_TIMEOUT);
    assertEquals(client.getReadTimeout(), 42);
    assertEquals(client.getWriteTimeout(), 123);

    client =
        new RocksetClient(apiKey, apiServer)
            .setConnectTimeout(1337)
            .setReadTimeout(42)
            .setWriteTimeout(123);
    assertEquals(client.getConnectTimeout(), 1337);
    assertEquals(client.getReadTimeout(), 42);
    assertEquals(client.getWriteTimeout(), 123);
  }
}
