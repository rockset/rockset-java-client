package com.rockset.examples;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;

public class CreateIntegrationExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    CreateIntegrationRequest request = new CreateIntegrationRequest()
                                            .name("my-first-integration")
                                            .s3(new S3Integration()
                                                .awsRole(new AwsRole()
                                                    .awsRoleArn("...")));

    try {
      CreateIntegrationResponse response = rs.createIntegration(request);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
