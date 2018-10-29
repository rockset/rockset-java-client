package com.rockset.client;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;
import org.
    apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCollection {
  private RocksetClient client;
  private String collectionName;

  @BeforeSuite
  public void setUp() {
    String apiKey = System.getenv("ROCKSET_APIKEY");
    String apiServer = System.getenv("ROCKSET_APISERVER");
    this.client = new RocksetClient(apiKey, apiServer);
    this.collectionName = "java-client-test-collection-"
        + RandomStringUtils.randomAlphanumeric(5);
  }

  @Test
  public void testCollectionCreate() throws Exception {
    // create collection
    CreateCollectionRequest request =
        new CreateCollectionRequest().name(collectionName);
    CreateCollectionResponse response =
        client.createCollection(request);

    Assert.assertEquals(response.getData().getName(), collectionName);
    Assert.assertEquals(response.getData().getStatus(), Resource.StatusEnum.CREATED);
  }

  @Test(dependsOnMethods = {"testCollectionCreate"})
  public void testGetCollection() throws Exception {
    // describe collection
    GetCollectionResponse getCollectionResponse
        = client.getCollection(collectionName);
    Assert.assertEquals(getCollectionResponse.getData().getName(), collectionName);
  }

  @Test(dependsOnMethods = {"testGetCollection"})
  public void testDeleteCollection() throws Exception {
    // delete collection
    DeleteCollectionResponse deleteCollectionResponse
        = client.deleteCollection(collectionName);
    Assert.assertEquals(deleteCollectionResponse.getData().getName(), collectionName);
    Assert.assertEquals(deleteCollectionResponse.getData().getStatus(), Resource.StatusEnum.DELETED);
  }
}
