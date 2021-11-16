package com.rockset.examples;

import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

public class GetCollectionExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    try {
      GetCollectionResponse response = rs.collections.get("commons", "commons._events");
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
