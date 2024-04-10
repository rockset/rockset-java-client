package com.rockset.client;

import com.rockset.client.model.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestWorkspace {
  private RocksetClient client;
  private String collectionName;
  private String workspaceName;

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
    this.workspaceName = "java-client-test-workspace-" + RandomStringUtils.randomAlphanumeric(5);
  }

  @Test
  public void testWorkspaceCreate() throws Exception {
    // create workspace
    CreateWorkspaceRequest wsRequest = new CreateWorkspaceRequest().name(workspaceName);
    CreateWorkspaceResponse wsResponse = client.workspaces.create(wsRequest);

    // create collection
    CreateCollectionRequest request = new CreateCollectionRequest().name(collectionName);
    CreateCollectionResponse response = client.collections.create(workspaceName, request);

    Assert.assertEquals(response.getData().getName(), collectionName);
    Assert.assertEquals(response.getData().getStatus(), Collection.StatusEnum.CREATED);
  }

  @Test(dependsOnMethods = {"testWorkspaceCreate"})
  public void testGetWorkspace() throws Exception {
    // describe workspace
    GetWorkspaceResponse getWorkspaceResponse = client.workspaces.get(workspaceName);
    Assert.assertEquals(getWorkspaceResponse.getData().getName(), workspaceName);
  }

  @Test(dependsOnMethods = {"testGetWorkspace"})
  public void testDeleteWorkspace() throws Exception {
    // delete collection
    DeleteCollectionResponse deleteCollectionResponse =
        client.collections.delete(workspaceName, collectionName);
    Assert.assertEquals(deleteCollectionResponse.getData().getName(), collectionName);
    // Assert.assertEquals(deleteCollectionResponse.getData().getStatus(),
    // Collection.StatusEnum.DELETED);

    // wait for collection to go away
    Awaitility.await("Waiting for collection to be cleaned up ")
        .atMost(3, TimeUnit.MINUTES)
            .pollInterval(1, TimeUnit.SECONDS)
        .until(
            (Callable<Boolean>)
                () -> {
                  try {
                    GetCollectionResponse getCollectionResponse =
                        client.collections.get(workspaceName, collectionName);
                  } catch (Exception e) {
                    return true; // collection deleted
                  }
                  return false;
                });

    // delete workspace
    DeleteWorkspaceResponse deleteWorkspaceResponse = client.workspaces.delete(workspaceName);
    Assert.assertEquals(deleteWorkspaceResponse.getData().getName(), workspaceName);
  }
}
