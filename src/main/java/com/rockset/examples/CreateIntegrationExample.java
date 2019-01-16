package com.rockset.examples;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

public class CreateIntegrationExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    CreateIntegrationRequest request = new CreateIntegrationRequest()
                                            .name("my-first-integration")
                                            .aws(new AwsKeyIntegration()
                                                    .awsAccessKeyId(".....")
                                                    .awsSecretAccessKey("....."));

    try {
      CreateIntegrationResponse response = rs.createIntegration(request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
