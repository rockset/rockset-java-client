import io.rockset.ApiException;
import io.rockset.Client;
import io.rockset.model.*;

public class QueryExample {
  public static void main(String[] args) {
    Client rs = new Client("<apiKey>", "<apiServer>");

    QueryRequest request = new QueryRequest()
                                .sql(new QueryRequestSql()
                                        .query("select * from \"_info.events\""));

    try {
      QueryResponse response = rs.query(request);
      System.out.Println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
}
