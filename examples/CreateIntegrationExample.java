import com.rockset.ApiException;
import com.rockset.RocksetClient;
import com.rockset.model.*;

public class CreateIntegrationExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    CreateIntegrationRequest request = new CreateCollectionRequest()
                                            .name("my-first-integration")
                                            .aws(new AwsKeyIntegrations()
                                                    .awsAccessKeyId(".....")
                                                    .awsSecretAccessKey("....."));

    try {
      CreateIntegrationResponse response = rs.createIntegration(request);
      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
