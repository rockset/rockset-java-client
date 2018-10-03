import io.rockset.ApiException;
import io.rockset.Client;
import io.rockset.model.*;

public class CreateCollectionExample {
  public static void main(String[] args) {
    Client rs = new Client("<apiKey>", "<apiServer>");

    CreateCollectionRequest request = new CreateCollectionRequest()
                                            .name("my-first-collection");

    try {
      CreateCollectionResponse response = rs.createCollection(request);
      System.out.Println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
