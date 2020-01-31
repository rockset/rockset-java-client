package com.rockset.examples;

import com.google.gson.internal.LinkedTreeMap;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SavedQueryExample {
  public static void main(String[] args) throws Exception {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    String queryName = "myQuery";
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

    CreateSavedQueryResponse resp = rs.createSavedQuery("commons", req);
    System.out.println(resp.toString());

    // Run saved query with default parameters
    QueryResponse qr = rs.runSavedQuery("commons", queryName, 1, null);
    Map<String, String> result = (LinkedTreeMap) qr.getResults().get(0);
    System.out.println(result.toString());

    // Run saved query with overidden parameters
    ExecuteSavedQueryParameter exParam = new ExecuteSavedQueryParameter();
    exParam.setName("param");
    exParam.setValue("All work and no play makes Jack a dull boy");
    ExecuteSavedQueryRequest exReq = new ExecuteSavedQueryRequest();
    exReq.addParametersItem(exParam);
    qr = rs.runSavedQuery("commons", queryName, 1, exReq);
    result = (LinkedTreeMap) qr.getResults().get(0);
    System.out.println(result.toString());

    rs.deleteSavedQuery("commons", queryName);
  }
}