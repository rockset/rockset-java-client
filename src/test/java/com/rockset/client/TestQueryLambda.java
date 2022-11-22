package com.rockset.client;

import com.google.gson.internal.LinkedTreeMap;
import com.rockset.client.model.CreateQueryLambdaRequest;
import com.rockset.client.model.CreateQueryLambdaTagRequest;
import com.rockset.client.model.ExecuteQueryLambdaRequest;
import com.rockset.client.model.PaginationInfo;
import com.rockset.client.model.QueryLambdaSql;
import com.rockset.client.model.QueryLambdaTagResponse;
import com.rockset.client.model.QueryLambdaVersionResponse;
import com.rockset.client.model.QueryPaginationResponse;
import com.rockset.client.model.QueryParameter;
import com.rockset.client.model.QueryResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestQueryLambda {

  private RocksetClient client;
  private static final String queryName = "myQuery";
  private static final String paginatedQueryName = "myQueryPaginated";

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

    QueryLambdaVersionResponse resp = client.queryLambdas.create("commons", req);
    Assert.assertEquals(resp.getData().getName(), this.queryName);

    String version = resp.getData().getVersion();
    // Run Query Lambda with default parameters
    QueryResponse qr = client.queryLambdas.execute_0("commons", queryName, version, null);
    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.get("echo"), "Hello, world!");

    // Create a tag for a Query Lambda version
    String queryLambdaTag = "production";
    CreateQueryLambdaTagRequest reqQLTag = new CreateQueryLambdaTagRequest();
    reqQLTag.setTagName(queryLambdaTag);
    reqQLTag.setVersion(version);
    QueryLambdaTagResponse respQLTag = client.queryLambdas.create_0("commons", queryName, reqQLTag);
    Assert.assertEquals(respQLTag.getData().getTagName(), queryLambdaTag);

    // Run Query Lambda with custom parameters
    QueryParameter exParam = new QueryParameter();
    exParam.setName("param");
    exParam.setType("string");
    exParam.setValue("All work and no play makes Jack a dull boy");
    ExecuteQueryLambdaRequest exReq = new ExecuteQueryLambdaRequest();
    exReq.addParametersItem(exParam);
    qr = client.queryLambdas.execute("commons", queryName, queryLambdaTag, exReq);
    result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.get("echo"), "All work and no play makes Jack a dull boy");

    client.queryLambdas.delete("commons", queryName);
  }

  @Test
  public void testPaginatedSavedQuery() throws Exception {
    CreateQueryLambdaRequest req = new CreateQueryLambdaRequest();
    req.setName(paginatedQueryName);
    QueryLambdaSql sql = new QueryLambdaSql();
    sql.setQuery("SELECT '1' UNION SELECT '2'");
    req.setSql(sql);

    QueryLambdaVersionResponse resp = client.queryLambdas.create("commons", req);
    Assert.assertEquals(resp.getData().getName(), paginatedQueryName);

    String version = resp.getData().getVersion();

    // Create a tag for a Query Lambda version
    String queryLambdaTag = "production";
    CreateQueryLambdaTagRequest reqQLTag = new CreateQueryLambdaTagRequest();
    reqQLTag.setTagName(queryLambdaTag);
    reqQLTag.setVersion(version);
    QueryLambdaTagResponse respQLTag = client.queryLambdas.create_0("commons", paginatedQueryName, reqQLTag);
    Assert.assertEquals(respQLTag.getData().getTagName(), queryLambdaTag);

    // Execute the QL and get only the first page.
    ExecuteQueryLambdaRequest exReq = new ExecuteQueryLambdaRequest();
    exReq.setPaginate(true);
    exReq.setDefaultRowLimit(1);
    exReq.setInitialPaginateResponseDocCount(1);
    QueryResponse qr = client.queryLambdas.execute("commons", paginatedQueryName, queryLambdaTag, exReq);
    Assert.assertEquals(qr.getResults().size(), 1);

    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    Assert.assertEquals(result.values().stream().collect(Collectors.toList()).get(0), "1");

    // Get Pagination cursor.
    PaginationInfo pInfo = qr.getPagination();
    String next = pInfo.getNextCursor();

    String queryId = qr.getQueryId();
    QueryPaginationResponse paginationResponse = client.queries.get_0(queryId, next, 1);

    // Check that the second row just has a 2.
    Assert.assertEquals(paginationResponse.getResults().size(), 1);
    Assert.assertEquals(paginationResponse.getPagination().getCurrentPageDocCount().longValue(), 1L);
    result = (LinkedTreeMap) paginationResponse.getResults().get(0);
    Assert.assertEquals(result.values().stream().collect(Collectors.toList()).get(0), "2");

    // No more pages.
    Assert.assertNull(paginationResponse.getPagination().getNextCursor());

    client.queryLambdas.delete("commons", paginatedQueryName);
  }
}
