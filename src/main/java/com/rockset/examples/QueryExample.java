package com.rockset.examples;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

public class QueryExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    QueryRequest request = new QueryRequest()
                                .sql(new QueryRequestSql()
                                        .query("SELECT * FROM \"_events\" LIMIT 10"));

    try {
      QueryResponse response = rs.query(request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  } 
}
