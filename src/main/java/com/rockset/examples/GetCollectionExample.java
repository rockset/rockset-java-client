package com.rockset.examples;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

public class GetCollectionExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    try {
      GetCollectionResponse response = rs.getCollection("_info.events");
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
