package com.rockset.client;

import com.rockset.client.ApiException;
import com.rockset.client.RocksetClient;
import com.rockset.client.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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
      throw new Exception("If you want to run unit tests "
                          + "Please set ROCKSET_APIKEY and ROCKSET_APISERVER");
    }

    this.client = new RocksetClient(apiKey, apiServer);
    this.integrationName = "java-client-test-integration-"
        + RandomStringUtils.randomAlphanumeric(5);
    this.awsAccessKey = RandomStringUtils.randomAlphanumeric(4);
    this.awsSecretkey = RandomStringUtils.randomAlphanumeric(4);
  }
  
  @Test
  public void testIntegrationCreate() throws Exception {
    // create integration
    CreateIntegrationRequest request =
        new CreateIntegrationRequest()
            .name(integrationName)
            .aws(new AwsKeyIntegration()
                  .awsAccessKeyId(awsAccessKey)
                  .awsSecretAccessKey(awsSecretkey));
    CreateIntegrationResponse response =
        client.createIntegration(request);
    Assert.assertEquals(response.getData().getName(), integrationName);
    Assert.assertEquals(response.getData().getAws().getAwsAccessKeyId(), awsAccessKey);
    Assert.assertEquals(response.getData().getAws().getAwsSecretAccessKey(), awsSecretkey);
  }

  @Test(dependsOnMethods = {"testIntegrationCreate"})
  public void testGetIntegration() throws Exception {
    // describe integration
    GetIntegrationResponse getIntegrationResponse
        = client.getIntegration(integrationName);
    Assert.assertEquals(getIntegrationResponse.getData().getName(), integrationName);
    Assert.assertEquals(
        getIntegrationResponse.getData().getAws()
            .getAwsAccessKeyId().substring(0, 4), awsAccessKey);
    Assert.assertEquals(
        getIntegrationResponse.getData().getAws()
            .getAwsSecretAccessKey().substring(0, 4), awsSecretkey);
  }

  @Test(dependsOnMethods = {"testGetIntegration"})
  public void testDeleteIntegration() throws Exception {
    // delete integration
    DeleteIntegrationResponse deleteIntegrationResponse
        = client.deleteIntegration(integrationName);
    Assert.assertEquals(deleteIntegrationResponse.getData().getName(), integrationName);
  }
}
