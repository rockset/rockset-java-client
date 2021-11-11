package com.rockset.client;

import com.google.gson.internal.LinkedTreeMap;
import com.rockset.client.model.CreateQueryLambdaRequest;
import com.rockset.client.model.CreateQueryLambdaTagRequest;
import com.rockset.client.model.ExecuteQueryLambdaRequest;
import com.rockset.client.model.QueryLambdaSql;
import com.rockset.client.model.QueryLambdaTagResponse;
import com.rockset.client.model.QueryLambdaVersionResponse;
import com.rockset.client.model.QueryParameter;
import com.rockset.client.model.QueryResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSavedQuery {

  private RocksetClient client;
  private static final String queryName = "myQuery";

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
  }

  @Test
  public void testSavedQueryCrud() throws Exception {
    String queryName = "myQuery";
    CreateQueryLambdaRequest req = new CreateQueryLambdaRequest();
    req.setName(queryName);
    QueryLambdaSql sql = new QueryLambdaSql();
    sql.setQuery("SELECT :param as echo");
    QueryParameter param = new QueryParameter();
    param.setName("param");
    param.setType("string");
    param.setValue("Hello, world!");
    List<QueryParameter> defaultParameters = new ArrayList<>();
    defaultParameters.add(param);
    sql.setDefaultParameters(defaultParameters);
    req.setSql(sql);

    QueryLambdaVersionResponse resp = client.createQueryLambda("commons", req);
    Assert.assertEquals(resp.getData().getName(), this.queryName);

    String version = resp.getData().getVersion();
    // Run Query Lambda with default parameters
    QueryResponse qr = client.runQueryLambdaByVersion("commons", queryName, version, null);
    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.get("echo"), "Hello, world!");

    // Create a tag for a Query Lambda version
    String queryLambdaTag = "production";
    CreateQueryLambdaTagRequest reqQLTag = new CreateQueryLambdaTagRequest();
    reqQLTag.setTagName(queryLambdaTag);
    reqQLTag.setVersion(version);
    QueryLambdaTagResponse respQLTag = client.createQueryLambdaTag("commons", queryName, reqQLTag);
    Assert.assertEquals(respQLTag.getData().getTagName(), queryLambdaTag);

    // Run Query Lambda with custom parameters
    QueryParameter exParam = new QueryParameter();
    exParam.setName("param");
    exParam.setType("string");
    exParam.setValue("All work and no play makes Jack a dull boy");
    ExecuteQueryLambdaRequest exReq = new ExecuteQueryLambdaRequest();
    exReq.addParametersItem(exParam);
    qr = client.runQueryLambdaByTag("commons", queryName, queryLambdaTag, exReq);
    result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.get("echo"), "All work and no play makes Jack a dull boy");

    client.deleteQueryLambda("commons", queryName);
  }
}
