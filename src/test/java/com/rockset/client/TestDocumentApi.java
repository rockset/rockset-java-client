package com.rockset.client;

import com.rockset.client.model.AddDocumentsRequest;
import com.rockset.client.model.AddDocumentsResponse;
import com.rockset.client.model.Collection;
import com.rockset.client.model.CreateCollectionRequest;
import com.rockset.client.model.DocumentStatus;
import com.rockset.client.model.GetCollectionResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class TestDocumentApi {
    private RocksetClient client;
    private String collectionName;
    private String workspaceName;

    @BeforeClass
    public void setUpOnce() throws Exception {
        String apiKey = System.getenv("ROCKSET_APIKEY");
        String apiServer = System.getenv("ROCKSET_APISERVER");
        if (apiKey == null || apiServer == null) {
            throw new Exception(
                    "To run unit tests, please set ROCKSET_APIKEY and ROCKSET_APISERVER "
                            + "environment variables.");
        }
        this.client = new RocksetClient(apiKey, apiServer);
        this.workspaceName = "commons";
        this.collectionName = "java-client-test-collection-" + RandomStringUtils.randomAlphanumeric(5);
        client.collections.create(workspaceName, new CreateCollectionRequest()
                .name(collectionName));

        Awaitility.await().atMost(Duration.TWO_MINUTES)
                .pollInterval(Duration.TWO_SECONDS)
                .until(() -> {
                    try {
                        GetCollectionResponse response = client.collections.get(workspaceName, collectionName);
                        return response.getData().getStatus().equals(Collection.StatusEnum.READY);
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    @AfterClass
    public void destroy() throws Exception {
        this.client.collections.delete(workspaceName, collectionName);
    }

    @Test
    public void testAdd() throws Exception {

        LinkedList<Object> list = new LinkedList<>();
        Map<String, Object> json = new LinkedHashMap<>();
        json.put("name", "foo");
        json.put("address", "bar");
        list.add(json);

        AddDocumentsRequest request = new AddDocumentsRequest()
                .data(list);

        AddDocumentsResponse response = client.documents.add(workspaceName, collectionName, request);
        Assert.assertEquals(response.getData().size(), 1);
        Assert.assertEquals(response.getData().get(0).getStatus(), DocumentStatus.StatusEnum.ADDED);
    }

    @Test
    public void testAddAsync() throws Exception {

        LinkedList<Object> list = new LinkedList<>();
        Map<String, Object> json = new LinkedHashMap<>();
        json.put("name", "foo");
        json.put("address", "bar");
        list.add(json);

        AddDocumentsRequest request = new AddDocumentsRequest()
                .data(list);

        final AddDocumentsResponse[] response = new AddDocumentsResponse[1];
        CountDownLatch countDownLatch = new CountDownLatch(1) ;
        client.documents.addAsync(workspaceName, collectionName, request, new ApiCallback<AddDocumentsResponse>() {
            @Override
            public void onFailure(Exception e, int statusCode, Map<String, List<String>> responseHeaders) {
                countDownLatch.countDown();
            }

            @Override
            public void onSuccess(AddDocumentsResponse result, int statusCode, Map<String, List<String>> responseHeaders) {
                response[0] = result;
                countDownLatch.countDown();
            }

            @Override
            public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {}

            @Override
            public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {}
        });

        countDownLatch.await();

        Assert.assertEquals(response[0].getData().size(), 1);
        Assert.assertEquals(response[0].getData().get(0).getStatus(), DocumentStatus.StatusEnum.ADDED);
    }
}
