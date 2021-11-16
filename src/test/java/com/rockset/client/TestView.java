package com.rockset.client;

import com.rockset.client.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestView {
  private RocksetClient client;
  private String viewName;

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
    this.viewName = "java-client-test-view-" + RandomStringUtils.randomAlphanumeric(5);
  }

  @Test
  public void testCreateView() throws Exception {
    CreateViewRequest request =
        new CreateViewRequest().name(viewName).query("SELECT 1").description("my view description");
    CreateViewResponse response = client.views.create("commons", request);

    Assert.assertEquals(response.getData().getName(), viewName);
    Assert.assertEquals(response.getData().getQuerySql(), "SELECT 1");
    Assert.assertEquals(response.getData().getDescription(), "my view description");
  }

  @Test(dependsOnMethods = {"testCreateView"})
  public void testGetView() throws Exception {
    GetViewResponse response = client.views.get("commons", viewName);
    Assert.assertEquals(response.getData().getName(), viewName);
  }

  @Test(dependsOnMethods = {"testGetView"})
  public void testDeleteCollection() throws Exception {
    DeleteViewResponse response = client.views.delete("commons", viewName);
    Assert.assertEquals(response.getData().getName(), viewName);
  }
}
