package com.rockset.examples;

import com.google.gson.internal.LinkedTreeMap;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QueryLambdaExample {
  public static void main(String[] args) throws Exception {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

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


    CreateQueryLambdaResponse resp = rs.createQueryLambda("commons", req);
    System.out.println(resp.toString());

    // Run Query Lambda with default parameters
    QueryResponse qr = rs.runQueryLambda("commons", queryName, 1, null);
    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    System.out.println(result.toString());

    // Run Query Lambda with custom parameters
    QueryParameter exParam = new QueryParameter();
    exParam.setName("param");
    exParam.setType("string");
    exParam.setValue("All work and no play makes Jack a dull boy");
    ExecuteQueryLambdaRequest exReq = new ExecuteQueryLambdaRequest();
    exReq.addParametersItem(exParam);
    qr = rs.runQueryLambda("commons", queryName, 1, exReq);
    result = (LinkedTreeMap) qr.getResults().get(0);
    System.out.println(result.toString());

    rs.deleteQueryLambda("commons", queryName);
  }
}