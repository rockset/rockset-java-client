import io.rockset.ApiException;
import io.rockset.Client;
import io.rockset.model.*;

public class CreateIntegrationExample {
  public static void main(String[] args) {
    Client rs = new Client("<apiKey>", "<apiServer>");

    CreateIntegrationRequest request = new CreateCollectionRequest()
                                            .name("my-first-integration")
                                            .aws(new AwsKeyIntegrations()
                                                    .awsAccessKeyId(".....")
                                                    .awsSecretAccessKey("....."));

    try {
      CreateIntegrationResponse response = rs.createIntegration(request);
      System.out.Println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
