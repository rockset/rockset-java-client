import com.rockset.ApiException;
import com.rockset.RocksetClient;
import com.rockset.model.*;

public class GetCollectionExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

    try {
      GetCollectionResponse response = rs.getCollection("_info.events");
      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
