package com.rockset.client;

import com.rockset.client.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestIntegration {
  private RocksetClient client;
  private String integrationName;
  private String awsAccessKey;
  private String awsSecretkey;

  @BeforeSuite
  public void setUp() throws Exception {
    String apiKey = System.getenv("ROCKSET_APIKEY");
    String apiServer = System.getenv("ROCKSET_APISERVER");
    if (apiKey == null || apiServer == null) {
      throw new Exception(
          "To run unit tests, please set ROCKSET_APIKEY and ROCKSET_APISERVER "
              + "environment variables.");
    }

    this.client = new RocksetClient(apiKey, apiServer);
    this.integrationName =
        "java-client-test-integration-" + RandomStringUtils.randomAlphanumeric(5);
    this.awsAccessKey = RandomStringUtils.randomAlphanumeric(4);
    this.awsSecretkey = RandomStringUtils.randomAlphanumeric(4);
  }

  @Test
  public void testIntegrationCreate() throws Exception {
    // create integration
    CreateIntegrationRequest request =
        new CreateIntegrationRequest()
            .name(integrationName)
            .kinesis(
                new KinesisIntegration()
                    .awsAccessKey(
                        new AwsAccessKey()
                            .awsAccessKeyId(awsAccessKey)
                            .awsSecretAccessKey(awsSecretkey)));
    CreateIntegrationResponse response = client.integrations.create(request);
    Assert.assertEquals(response.getData().getName(), integrationName);
    Assert.assertEquals(
        response.getData().getKinesis().getAwsAccessKey().getAwsAccessKeyId().substring(0, 4),
        awsAccessKey);
    Assert.assertEquals(
        response.getData().getKinesis().getAwsAccessKey().getAwsSecretAccessKey().substring(0, 4),
        awsSecretkey);
  }

  @Test(dependsOnMethods = {"testIntegrationCreate"})
  public void testGetIntegration() throws Exception {
    // describe integration
    GetIntegrationResponse getIntegrationResponse = client.integrations.get(integrationName);
    Assert.assertEquals(getIntegrationResponse.getData().getName(), integrationName);
    Assert.assertEquals(
        getIntegrationResponse
            .getData()
            .getKinesis()
            .getAwsAccessKey()
            .getAwsAccessKeyId()
            .substring(0, 4),
        awsAccessKey);
    Assert.assertEquals(
        getIntegrationResponse
            .getData()
            .getKinesis()
            .getAwsAccessKey()
            .getAwsSecretAccessKey()
            .substring(0, 4),
        awsSecretkey);
  }

  @Test(dependsOnMethods = {"testGetIntegration"})
  public void testDeleteIntegration() throws Exception {
    // delete integration
    DeleteIntegrationResponse deleteIntegrationResponse =
        client.integrations.delete(integrationName);
    Assert.assertEquals(deleteIntegrationResponse.getData().getName(), integrationName);
  }
}
