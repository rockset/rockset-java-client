import com.rockset.ApiException;
import com.rockset.RocksetClient;
import com.rockset.model.*;

public class QueryExample {
  public static void main(String[] args) {
    RocksetClient rs = new RocksetClient("<apiKey>", "<apiServer>");

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
