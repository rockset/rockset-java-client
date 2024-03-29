package com.rockset.examples;

import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;
import java.util.ArrayList;
import java.util.List;

public class CreateS3CollectionExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    SourceS3 sourceS3 = new SourceS3();
    sourceS3.setBucket("<bucket>");

    List<Source> sources = new ArrayList<Source>();
    sources.add(new Source().s3(sourceS3).integrationName("<integration>"));

    CreateCollectionRequest request =
        new CreateCollectionRequest().name("my-first-s3-collection").sources(sources);

    try {
      CreateCollectionResponse response = rs.collections.create("commons", request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
