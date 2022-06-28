package com.rockset.examples;

import com.rockset.client.RocksetClient;
import com.rockset.client.model.AddDocumentsRequest;
import com.rockset.client.model.AddDocumentsResponse;
import com.rockset.client.model.CreateCollectionRequest;
import com.rockset.client.model.CreateCollectionResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class AddDocumentExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");
    CreateCollectionRequest request =
        new CreateCollectionRequest().name("my-first-add-document-collection");

    LinkedList<Object> list = new LinkedList<>();
    Map<String, Object> json = new LinkedHashMap<>();
    json.put("name", "foo");
    json.put("address", "bar");
    json.put("dob", LocalDate.of(2000, 7, 4));
    json.put("_event_time", Instant.ofEpochSecond(1000));
    list.add(json);

    AddDocumentsRequest documentsRequest = new AddDocumentsRequest().data(list);

    try {
      CreateCollectionResponse response = rs.collections.create("commons", request);
      AddDocumentsResponse documentsResponse =
          rs.documents.add("commons", response.getData().getName(), documentsRequest);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
