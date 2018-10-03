import io.rockset.ApiException;
import io.rockset.Client;
import io.rockset.model.*;

public class GetCollectionExample {
  public static void main(String[] args) {
    Client rs = new Client("<apiKey>", "<apiServer>");

    try {
      GetCollectionResponse response = rs.getCollection("_info.events");
      System.out.Println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
