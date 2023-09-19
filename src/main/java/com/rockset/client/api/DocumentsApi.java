/*
 * REST API
 * Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.rockset.client.api;

import com.rockset.client.ApiCallback;
import com.rockset.client.ApiClient;
import com.rockset.client.ApiResponse;
import com.rockset.client.Configuration;
import com.rockset.client.Pair;
import com.rockset.client.ProgressRequestBody;
import com.rockset.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.rockset.client.model.AddDocumentsRequest;
import com.rockset.client.model.AddDocumentsResponse;
import com.rockset.client.model.DeleteDocumentsRequest;
import com.rockset.client.model.DeleteDocumentsResponse;
import com.rockset.client.model.ErrorModel;
import com.rockset.client.model.PatchDocumentsRequest;
import com.rockset.client.model.PatchDocumentsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentsApi {
    private ApiClient apiClient;

    public DocumentsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DocumentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for add
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws Exception If fail to serialize the request body object
     */
    public okhttp3.Call addCall(String workspace, String collection, AddDocumentsRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws Exception {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/orgs/self/ws/{workspace}/collections/{collection}/docs"
            .replaceAll("\\{" + "workspace" + "\\}", apiClient.escapeString(workspace.toString()))
            .replaceAll("\\{" + "collection" + "\\}", apiClient.escapeString(collection.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.setHttpClient(apiClient.getHttpClient().newBuilder().addInterceptor(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            }).build());
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call addValidateBeforeCall(String workspace, String collection, AddDocumentsRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws Exception {
        
        // verify the required parameter 'workspace' is set
        if (workspace == null) {
            throw new Exception("Missing the required parameter 'workspace' when calling add(Async)");
        }
        
        // verify the required parameter 'collection' is set
        if (collection == null) {
            throw new Exception("Missing the required parameter 'collection' when calling add(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new Exception("Missing the required parameter 'body' when calling add(Async)");
        }
        

        okhttp3.Call call = addCall(workspace, collection, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Add Documents
     * Add documents to a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @return AddDocumentsResponse
     * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AddDocumentsResponse add(String workspace, String collection, AddDocumentsRequest body) throws Exception {
        ApiResponse<AddDocumentsResponse> resp = addWithHttpInfo(workspace, collection, body);
        return resp.getData();
    }

    /**
     * Add Documents
     * Add documents to a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @return ApiResponse&lt;AddDocumentsResponse&gt;
     * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AddDocumentsResponse> addWithHttpInfo(String workspace, String collection, AddDocumentsRequest body) throws Exception {
        okhttp3.Call call = addValidateBeforeCall(workspace, collection, body, null, null);
        Type localVarReturnType = new TypeToken<AddDocumentsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add Documents (asynchronously)
     * Add documents to a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws Exception If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call addAsync(String workspace, String collection, AddDocumentsRequest body, final ApiCallback<AddDocumentsResponse> callback) throws Exception {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call call = addValidateBeforeCall(workspace, collection, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AddDocumentsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for delete
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws Exception If fail to serialize the request body object
     */
    public okhttp3.Call deleteCall(String workspace, String collection, DeleteDocumentsRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws Exception {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/orgs/self/ws/{workspace}/collections/{collection}/docs"
            .replaceAll("\\{" + "workspace" + "\\}", apiClient.escapeString(workspace.toString()))
            .replaceAll("\\{" + "collection" + "\\}", apiClient.escapeString(collection.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.setHttpClient(apiClient.getHttpClient().newBuilder().addInterceptor(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            }).build());
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteValidateBeforeCall(String workspace, String collection, DeleteDocumentsRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws Exception {
        
        // verify the required parameter 'workspace' is set
        if (workspace == null) {
            throw new Exception("Missing the required parameter 'workspace' when calling delete(Async)");
        }
        
        // verify the required parameter 'collection' is set
        if (collection == null) {
            throw new Exception("Missing the required parameter 'collection' when calling delete(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new Exception("Missing the required parameter 'body' when calling delete(Async)");
        }
        

        okhttp3.Call call = deleteCall(workspace, collection, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete Documents
     * Delete documents from a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @return DeleteDocumentsResponse
     * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeleteDocumentsResponse delete(String workspace, String collection, DeleteDocumentsRequest body) throws Exception {
        ApiResponse<DeleteDocumentsResponse> resp = deleteWithHttpInfo(workspace, collection, body);
        return resp.getData();
    }

    /**
     * Delete Documents
     * Delete documents from a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @return ApiResponse&lt;DeleteDocumentsResponse&gt;
     * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeleteDocumentsResponse> deleteWithHttpInfo(String workspace, String collection, DeleteDocumentsRequest body) throws Exception {
        okhttp3.Call call = deleteValidateBeforeCall(workspace, collection, body, null, null);
        Type localVarReturnType = new TypeToken<DeleteDocumentsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete Documents (asynchronously)
     * Delete documents from a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON object (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws Exception If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call deleteAsync(String workspace, String collection, DeleteDocumentsRequest body, final ApiCallback<DeleteDocumentsResponse> callback) throws Exception {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call call = deleteValidateBeforeCall(workspace, collection, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeleteDocumentsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for patch
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON Patch objects (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws Exception If fail to serialize the request body object
     */
    public okhttp3.Call patchCall(String workspace, String collection, PatchDocumentsRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws Exception {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/orgs/self/ws/{workspace}/collections/{collection}/docs"
            .replaceAll("\\{" + "workspace" + "\\}", apiClient.escapeString(workspace.toString()))
            .replaceAll("\\{" + "collection" + "\\}", apiClient.escapeString(collection.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.setHttpClient(apiClient.getHttpClient().newBuilder().addInterceptor(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            }).build());
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call patchValidateBeforeCall(String workspace, String collection, PatchDocumentsRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws Exception {
        
        // verify the required parameter 'workspace' is set
        if (workspace == null) {
            throw new Exception("Missing the required parameter 'workspace' when calling patch(Async)");
        }
        
        // verify the required parameter 'collection' is set
        if (collection == null) {
            throw new Exception("Missing the required parameter 'collection' when calling patch(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new Exception("Missing the required parameter 'body' when calling patch(Async)");
        }
        

        okhttp3.Call call = patchCall(workspace, collection, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Patch Documents
     * Update existing documents in a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON Patch objects (required)
     * @return PatchDocumentsResponse
     * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PatchDocumentsResponse patch(String workspace, String collection, PatchDocumentsRequest body) throws Exception {
        ApiResponse<PatchDocumentsResponse> resp = patchWithHttpInfo(workspace, collection, body);
        return resp.getData();
    }

    /**
     * Patch Documents
     * Update existing documents in a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON Patch objects (required)
     * @return ApiResponse&lt;PatchDocumentsResponse&gt;
     * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PatchDocumentsResponse> patchWithHttpInfo(String workspace, String collection, PatchDocumentsRequest body) throws Exception {
        okhttp3.Call call = patchValidateBeforeCall(workspace, collection, body, null, null);
        Type localVarReturnType = new TypeToken<PatchDocumentsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Patch Documents (asynchronously)
     * Update existing documents in a collection.
     * @param workspace Name of the workspace. (required)
     * @param collection Name of the collection. (required)
     * @param body JSON Patch objects (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws Exception If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call patchAsync(String workspace, String collection, PatchDocumentsRequest body, final ApiCallback<PatchDocumentsResponse> callback) throws Exception {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call call = patchValidateBeforeCall(workspace, collection, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PatchDocumentsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
