package com.rockset.examples;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

public class CreateCollectionExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    CreateCollectionRequest request = new CreateCollectionRequest()
                                            .name("my-first-collection");
    
    try {
      CreateCollectionResponse response = rs.createCollection(request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
