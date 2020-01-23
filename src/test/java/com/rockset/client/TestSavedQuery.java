package com.rockset.client;

import com.google.gson.internal.LinkedTreeMap;
import com.rockset.client.model.CreateSavedQueryRequest;
import com.rockset.client.model.CreateSavedQueryResponse;
import com.rockset.client.model.ExecuteSavedQueryParameter;
import com.rockset.client.model.ExecuteSavedQueryRequest;
import com.rockset.client.model.QueryResponse;
import com.rockset.client.model.SavedQueryParameter;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestSavedQuery {

  private RocksetClient client;
  private static final String queryName = "myQuery";

  @BeforeSuite
  public void setUp() throws Exception {
    String apiKey = System.getenv("ROCKSET_APIKEY");
    String apiServer = System.getenv("ROCKSET_APISERVER");
    if (apiKey == null || apiServer == null) {
      throw new Exception(
              "To run unit tests, please set ROCKSET_APIKEY and ROCKSET_APISERVER " +
                      "environment variables.");
    }
    this.client = new RocksetClient(apiKey, apiServer);
  }

  @Test
  public void testSavedQueryCrud() throws Exception {
    CreateSavedQueryRequest req = new CreateSavedQueryRequest();
    req.setName(queryName);
    req.setQuerySql("SELECT :param as echo");
    SavedQueryParameter param = new SavedQueryParameter();
    param.setName("param");
    param.setType("string");
    param.setDefaultValue("Hello, world!");
    List<SavedQueryParameter> savedQueryParameters = new ArrayList<>();
    savedQueryParameters.add(param);
    req.setParameters(savedQueryParameters);

    CreateSavedQueryResponse resp = client.createSavedQuery("commons", req);
    Assert.assertEquals(resp.getData().getName(), this.queryName);

    // Run saved query with default parameters
    QueryResponse qr = client.runSavedQuery("commons", queryName, 1, null);
    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.get("echo"), "Hello, world!");

    // Run saved query with overidden parameters
    ExecuteSavedQueryParameter exParam = new ExecuteSavedQueryParameter();
    exParam.setName("param");
    exParam.setValue("All work and no play makes Jack a dull boy");
    ExecuteSavedQueryRequest exReq = new ExecuteSavedQueryRequest();
    exReq.addParametersItem(exParam);
    qr = client.runSavedQuery("commons", queryName, 1, exReq);
    result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.get("echo"), "All work and no play makes Jack a dull boy");

    client.deleteSavedQuery("commons", this.queryName);
  }
}
