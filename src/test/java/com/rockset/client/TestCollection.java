package com.rockset.client;

import static org.awaitility.Awaitility.await;

import com.rockset.client.model.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCollection {
  private RocksetClient client;
  private String collectionName;

  @BeforeSuite
  public void setUp() throws Exception {
    String apiKey = System.getenv("ROCKSET_APIKEY");
    String apiServer = System.getenv("ROCKSET_APISERVER");
    if (apiKey == null || apiServer == null) {
      throw new Exception(
          "To run unit tests, please set ROCKSET_APIKEY and ROCKSET_APISERVER "
              + "environment variables.");
    }
    this.client = new RocksetClient(apiKey, apiServer);
    this.collectionName = "java-client-test-collection-" + RandomStringUtils.randomAlphanumeric(5);
  }

  @Test
  public void testCollectionCreate() throws Exception {
    // create collection
    CreateCollectionRequest request = new CreateCollectionRequest().name(collectionName);
    CreateCollectionResponse response = client.collections.create("commons", request);

    Assert.assertEquals(response.getData().getName(), collectionName);
    Assert.assertEquals(response.getData().getStatus(), Collection.StatusEnum.CREATED);
  }

  @Test(dependsOnMethods = {"testCollectionCreate"})
  public void testGetCollection() throws Exception {
    // describe collection
    GetCollectionResponse getCollectionResponse = client.collections.get("commons", collectionName);
    Assert.assertEquals(getCollectionResponse.getData().getName(), collectionName);
  }

  @Test(dependsOnMethods = {"testGetCollection"})
  public void testDeleteCollection() throws Exception {

    // wait for collection to be created successfully before deleting
    await("testDeleteCollection querying")
        .atMost(120, TimeUnit.SECONDS)
        .until(
            (Callable<Boolean>)
                () -> {
                  try {
                    QueryRequest request =
                        new QueryRequest()
                            .sql(
                                new QueryRequestSql()
                                    .query(String.format("select * from \"%s\"", collectionName)));

                    QueryResponse response = client.queries.query(request);
                    Assert.assertTrue(response.getResults().size() == 0);
                    return true;
                  } catch (Exception e) {
                    return false;
                  }
                });

    // delete collection
    DeleteCollectionResponse deleteCollectionResponse =
        client.collections.delete("commons", collectionName);
    Assert.assertEquals(deleteCollectionResponse.getData().getName(), collectionName);
    // Assert.assertEquals(deleteCollectionResponse.getData().getStatus(),
    // Collection.StatusEnum.DELETED);
  }
}
