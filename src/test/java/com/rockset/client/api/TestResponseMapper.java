package com.rockset.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rockset.client.ApiClient;
import com.rockset.client.ApiException;
import com.rockset.client.model.ErrorModel;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestResponseMapper {
  @Test
  public void testUnknownProps() throws Exception {
    ApiClient apiClient = new ApiClient();
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.isSuccessful()).thenReturn(false);

    ResponseBody body = Mockito.mock(ResponseBody.class);
    Mockito.when(body.string())
        .thenReturn("{ \"message\" : \"invalid\", \"unknown_field\" : \"foo\" }");
    Mockito.when(response.body()).thenReturn(body);

    ApiException e =
        Assert.expectThrows(ApiException.class, () -> apiClient.handleResponse(response, null));
    Assert.assertEquals(e.getErrorModel().getMessage(), "invalid");
  }

  @Test
  public void testQueryError() throws Exception {
    // Set up error response
    ErrorModel error =
        new ErrorModel()
            .message("Field `abc` not found.")
            .type(ErrorModel.TypeEnum.QUERY_ERROR)
            .line(1)
            .column(15);
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    String errorStr = mapper.writeValueAsString(error);

    ResponseBody body = Mockito.mock(ResponseBody.class);
    Mockito.when(body.string()).thenReturn(errorStr);

    Response response = Mockito.mock(Response.class);
    Mockito.when(response.isSuccessful()).thenReturn(false);
    Mockito.when(response.body()).thenReturn(body);

    // Check deserialization
    ApiClient apiClient = new ApiClient();
    ApiException e =
        Assert.expectThrows(ApiException.class, () -> apiClient.handleResponse(response, null));
    Assert.assertEquals(e.getErrorModel(), error);
  }
}
