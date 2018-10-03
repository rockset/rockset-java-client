import io.rockset.ApiException;
import io.rockset.RocksetClient;
import io.rockset.model.*;

public class CreateCollectionExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    CreateCollectionRequest request = new CreateCollectionRequest()
                                            .name("my-first-collection");

    try {
      CreateCollectionResponse response = rs.createCollection(request);
      System.out.Println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
