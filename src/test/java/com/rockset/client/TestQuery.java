package com.rockset.client;

import com.rockset.client.RocksetClient;
import com.rockset.client.model.QueryRequest;
import com.rockset.client.model.QueryRequestSql;
import com.rockset.client.model.QueryResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestQuery {
  private RocksetClient client;
  private String collectionName;

  @BeforeSuite
  public void setUp() throws Exception {
    String apiKey = System.getenv("ROCKSET_APIKEY");
    String apiServer = System.getenv("ROCKSET_APISERVER");
    if (apiKey == null || apiServer == null) {
        throw new Exception("If you want to run unit tests "
                            + "Please set ROCKSET_APIKEY and ROCKSET_APISERVER");
    }
    this.client = new RocksetClient(apiKey, apiServer);
  }
  
  @Test
  public void testQuery() throws Exception {
    QueryRequest request = new QueryRequest()
        .sql(new QueryRequestSql()
            .query("select * from \"_events\" limit 1"));

    QueryResponse response = client.query(request);
    Assert.assertTrue(response.getResults().size() == 1
                      || response.getResults().size() == 0);
  }
}
