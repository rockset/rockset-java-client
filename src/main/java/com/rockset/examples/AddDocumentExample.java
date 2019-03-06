package com.rockset.examples;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.AddDocumentsRequest;
import com.rockset.client.model.AddDocumentsResponse;
import com.rockset.client.model.CreateCollectionRequest;
import com.rockset.client.model.CreateCollectionResponse;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class AddDocumentExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");
    CreateCollectionRequest request = new CreateCollectionRequest()
        .name("my-first-add-document-collection");

    LinkedList<Object> list = new LinkedList<>();
    Map<String, Object> json = new LinkedHashMap<>();
    json.put("name", "foo");
    json.put("address", "bar");
    list.add(json);
    
    AddDocumentsRequest documentsRequest =
        new AddDocumentsRequest().data(list);
    
    try {
      CreateCollectionResponse response = rs.createCollection("commons", request);
      AddDocumentsResponse documentsResponse =
          rs.addDocuments("commons", response.getData().getName(), documentsRequest);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
