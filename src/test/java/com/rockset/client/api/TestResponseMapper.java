package com.rockset.client.api;

import com.rockset.client.ApiClient;
import com.rockset.client.ApiException;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
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
        Mockito.when(body.string()).thenReturn("{ \"message\" : \"invalid\", \"unknown_field\" : \"foo\" }");
        Mockito.when(response.body()).thenReturn(body);

        ApiException e = Assert.expectThrows(ApiException.class, () -> apiClient.handleResponse(response, null));
        Assert.assertEquals(e.getErrorModel().getMessage(), "invalid");
    }
}
