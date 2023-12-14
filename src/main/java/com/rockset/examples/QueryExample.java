package com.rockset.examples;

import com.google.gson.internal.LinkedTreeMap;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

import java.util.Map;

public class QueryExample {
  public static void main(String[] args) throws Exception {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    // query to default VI
    QueryRequest request =
        new QueryRequest().sql(new QueryRequestSql().query("SELECT * FROM \"_events\" LIMIT 10"));

    try {
      QueryResponse response = rs.queries.query(request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // query to a specific VI
    try {
      QueryResponse response = rs.virtualInstances.query("vi-id", request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // send query lamdba to a specific VI
    QueryParameter exParam = new QueryParameter();
    exParam.setName("param");
    exParam.setType("string");
    exParam.setValue("All work and no play makes Jack a dull boy");
    ExecuteQueryLambdaRequest exReq = new ExecuteQueryLambdaRequest();
    exReq.addParametersItem(exParam);
    exReq.setVirtualInstanceId("vi-id");
    QueryResponse qr = rs.queryLambdas.execute("commons", "ql-name", "production", exReq);
    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    System.out.println(result.toString());
  }
}
