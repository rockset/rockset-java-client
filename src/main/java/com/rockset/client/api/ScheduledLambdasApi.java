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

import com.google.gson.reflect.TypeToken;
import com.rockset.client.ApiCallback;
import com.rockset.client.ApiClient;
import com.rockset.client.ApiResponse;
import com.rockset.client.Configuration;
import com.rockset.client.Pair;
import com.rockset.client.ProgressRequestBody;
import com.rockset.client.ProgressResponseBody;
import com.rockset.client.model.CreateScheduledLambdaRequest;
import com.rockset.client.model.ScheduledLambdaResponse;
import com.rockset.client.model.UpdateScheduledLambdaRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduledLambdasApi {
  private ApiClient apiClient;

  public ScheduledLambdasApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ScheduledLambdasApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Build call for create
   *
   * @param workspace name of the workspace (required)
   * @param body JSON Object (required)
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public okhttp3.Call createCall(
      String workspace,
      CreateScheduledLambdaRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = body;

    // create path and map variables
    String localVarPath =
        "/v1/orgs/self/ws/{workspace}/scheduled_lambdas"
            .replaceAll("\\{" + "workspace" + "\\}", apiClient.escapeString(workspace.toString()));

    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

    Map<String, String> localVarHeaderParams = new HashMap<String, String>();

    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    final String[] localVarAccepts = {"application/json"};
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
    if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

    final String[] localVarContentTypes = {"application/json"};
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
    localVarHeaderParams.put("Content-Type", localVarContentType);

    if (progressListener != null) {
      apiClient.setHttpClient(
          apiClient
              .getHttpClient()
              .newBuilder()
              .addInterceptor(
                  new okhttp3.Interceptor() {
                    @Override
                    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain)
                        throws IOException {
                      okhttp3.Response originalResponse = chain.proceed(chain.request());
                      return originalResponse
                          .newBuilder()
                          .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                          .build();
                    }
                  })
              .build());
    }

    String[] localVarAuthNames = new String[] {};
    return apiClient.buildCall(
        localVarPath,
        "POST",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarFormParams,
        localVarAuthNames,
        progressRequestListener);
  }

  @SuppressWarnings("rawtypes")
  private okhttp3.Call createValidateBeforeCall(
      String workspace,
      CreateScheduledLambdaRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    // verify the required parameter 'workspace' is set
    if (workspace == null) {
      throw new Exception("Missing the required parameter 'workspace' when calling create(Async)");
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new Exception("Missing the required parameter 'body' when calling create(Async)");
    }

    okhttp3.Call call = createCall(workspace, body, progressListener, progressRequestListener);
    return call;
  }

  /**
   * Create a Scheduled Lambda mapping Create a scheduled lambda mapping for your organization.
   *
   * @param workspace name of the workspace (required)
   * @param body JSON Object (required)
   * @return ScheduledLambdaResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ScheduledLambdaResponse create(String workspace, CreateScheduledLambdaRequest body)
      throws Exception {
    ApiResponse<ScheduledLambdaResponse> resp = createWithHttpInfo(workspace, body);
    return resp.getData();
  }

  /**
   * Create a Scheduled Lambda mapping Create a scheduled lambda mapping for your organization.
   *
   * @param workspace name of the workspace (required)
   * @param body JSON Object (required)
   * @return ApiResponse&lt;ScheduledLambdaResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<ScheduledLambdaResponse> createWithHttpInfo(
      String workspace, CreateScheduledLambdaRequest body) throws Exception {
    okhttp3.Call call = createValidateBeforeCall(workspace, body, null, null);
    Type localVarReturnType = new TypeToken<ScheduledLambdaResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Create a Scheduled Lambda mapping (asynchronously) Create a scheduled lambda mapping for your
   * organization.
   *
   * @param workspace name of the workspace (required)
   * @param body JSON Object (required)
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public okhttp3.Call createAsync(
      String workspace,
      CreateScheduledLambdaRequest body,
      final ApiCallback<ScheduledLambdaResponse> callback)
      throws Exception {

    ProgressResponseBody.ProgressListener progressListener = null;
    ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

    if (callback != null) {
      progressListener =
          new ProgressResponseBody.ProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
              callback.onDownloadProgress(bytesRead, contentLength, done);
            }
          };

      progressRequestListener =
          new ProgressRequestBody.ProgressRequestListener() {
            @Override
            public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
              callback.onUploadProgress(bytesWritten, contentLength, done);
            }
          };
    }

    okhttp3.Call call =
        createValidateBeforeCall(workspace, body, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<ScheduledLambdaResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  /**
   * Build call for delete
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public okhttp3.Call deleteCall(
      String workspace,
      String scheduledLambdaId,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath =
        "/v1/orgs/self/ws/{workspace}/scheduled_lambdas/{scheduledLambdaId}"
            .replaceAll("\\{" + "workspace" + "\\}", apiClient.escapeString(workspace.toString()))
            .replaceAll(
                "\\{" + "scheduledLambdaId" + "\\}",
                apiClient.escapeString(scheduledLambdaId.toString()));

    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

    Map<String, String> localVarHeaderParams = new HashMap<String, String>();

    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    final String[] localVarAccepts = {"application/json"};
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
    if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

    final String[] localVarContentTypes = {"application/json"};
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
    localVarHeaderParams.put("Content-Type", localVarContentType);

    if (progressListener != null) {
      apiClient.setHttpClient(
          apiClient
              .getHttpClient()
              .newBuilder()
              .addInterceptor(
                  new okhttp3.Interceptor() {
                    @Override
                    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain)
                        throws IOException {
                      okhttp3.Response originalResponse = chain.proceed(chain.request());
                      return originalResponse
                          .newBuilder()
                          .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                          .build();
                    }
                  })
              .build());
    }

    String[] localVarAuthNames = new String[] {};
    return apiClient.buildCall(
        localVarPath,
        "DELETE",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarFormParams,
        localVarAuthNames,
        progressRequestListener);
  }

  @SuppressWarnings("rawtypes")
  private okhttp3.Call deleteValidateBeforeCall(
      String workspace,
      String scheduledLambdaId,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    // verify the required parameter 'workspace' is set
    if (workspace == null) {
      throw new Exception("Missing the required parameter 'workspace' when calling delete(Async)");
    }

    // verify the required parameter 'scheduledLambdaId' is set
    if (scheduledLambdaId == null) {
      throw new Exception(
          "Missing the required parameter 'scheduledLambdaId' when calling delete(Async)");
    }

    okhttp3.Call call =
        deleteCall(workspace, scheduledLambdaId, progressListener, progressRequestListener);
    return call;
  }

  /**
   * Delete a Scheduled Lambda mapping Delete a scheduled lambda mapping for your organization.
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @return ScheduledLambdaResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ScheduledLambdaResponse delete(String workspace, String scheduledLambdaId)
      throws Exception {
    ApiResponse<ScheduledLambdaResponse> resp = deleteWithHttpInfo(workspace, scheduledLambdaId);
    return resp.getData();
  }

  /**
   * Delete a Scheduled Lambda mapping Delete a scheduled lambda mapping for your organization.
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @return ApiResponse&lt;ScheduledLambdaResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<ScheduledLambdaResponse> deleteWithHttpInfo(
      String workspace, String scheduledLambdaId) throws Exception {
    okhttp3.Call call = deleteValidateBeforeCall(workspace, scheduledLambdaId, null, null);
    Type localVarReturnType = new TypeToken<ScheduledLambdaResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Delete a Scheduled Lambda mapping (asynchronously) Delete a scheduled lambda mapping for your
   * organization.
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public okhttp3.Call deleteAsync(
      String workspace,
      String scheduledLambdaId,
      final ApiCallback<ScheduledLambdaResponse> callback)
      throws Exception {

    ProgressResponseBody.ProgressListener progressListener = null;
    ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

    if (callback != null) {
      progressListener =
          new ProgressResponseBody.ProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
              callback.onDownloadProgress(bytesRead, contentLength, done);
            }
          };

      progressRequestListener =
          new ProgressRequestBody.ProgressRequestListener() {
            @Override
            public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
              callback.onUploadProgress(bytesWritten, contentLength, done);
            }
          };
    }

    okhttp3.Call call =
        deleteValidateBeforeCall(
            workspace, scheduledLambdaId, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<ScheduledLambdaResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  /**
   * Build call for update
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @param body JSON Object (required)
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public okhttp3.Call updateCall(
      String workspace,
      String scheduledLambdaId,
      UpdateScheduledLambdaRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = body;

    // create path and map variables
    String localVarPath =
        "/v1/orgs/self/ws/{workspace}/scheduled_lambdas/{scheduledLambdaId}"
            .replaceAll("\\{" + "workspace" + "\\}", apiClient.escapeString(workspace.toString()))
            .replaceAll(
                "\\{" + "scheduledLambdaId" + "\\}",
                apiClient.escapeString(scheduledLambdaId.toString()));

    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

    Map<String, String> localVarHeaderParams = new HashMap<String, String>();

    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    final String[] localVarAccepts = {"application/json"};
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
    if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

    final String[] localVarContentTypes = {"application/json"};
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
    localVarHeaderParams.put("Content-Type", localVarContentType);

    if (progressListener != null) {
      apiClient.setHttpClient(
          apiClient
              .getHttpClient()
              .newBuilder()
              .addInterceptor(
                  new okhttp3.Interceptor() {
                    @Override
                    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain)
                        throws IOException {
                      okhttp3.Response originalResponse = chain.proceed(chain.request());
                      return originalResponse
                          .newBuilder()
                          .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                          .build();
                    }
                  })
              .build());
    }

    String[] localVarAuthNames = new String[] {};
    return apiClient.buildCall(
        localVarPath,
        "POST",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarFormParams,
        localVarAuthNames,
        progressRequestListener);
  }

  @SuppressWarnings("rawtypes")
  private okhttp3.Call updateValidateBeforeCall(
      String workspace,
      String scheduledLambdaId,
      UpdateScheduledLambdaRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    // verify the required parameter 'workspace' is set
    if (workspace == null) {
      throw new Exception("Missing the required parameter 'workspace' when calling update(Async)");
    }

    // verify the required parameter 'scheduledLambdaId' is set
    if (scheduledLambdaId == null) {
      throw new Exception(
          "Missing the required parameter 'scheduledLambdaId' when calling update(Async)");
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new Exception("Missing the required parameter 'body' when calling update(Async)");
    }

    okhttp3.Call call =
        updateCall(workspace, scheduledLambdaId, body, progressListener, progressRequestListener);
    return call;
  }

  /**
   * Update a Scheduled Lambda mapping Update a scheduled lambda mapping for your organization.
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @param body JSON Object (required)
   * @return ScheduledLambdaResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ScheduledLambdaResponse update(
      String workspace, String scheduledLambdaId, UpdateScheduledLambdaRequest body)
      throws Exception {
    ApiResponse<ScheduledLambdaResponse> resp =
        updateWithHttpInfo(workspace, scheduledLambdaId, body);
    return resp.getData();
  }

  /**
   * Update a Scheduled Lambda mapping Update a scheduled lambda mapping for your organization.
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @param body JSON Object (required)
   * @return ApiResponse&lt;ScheduledLambdaResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<ScheduledLambdaResponse> updateWithHttpInfo(
      String workspace, String scheduledLambdaId, UpdateScheduledLambdaRequest body)
      throws Exception {
    okhttp3.Call call = updateValidateBeforeCall(workspace, scheduledLambdaId, body, null, null);
    Type localVarReturnType = new TypeToken<ScheduledLambdaResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Update a Scheduled Lambda mapping (asynchronously) Update a scheduled lambda mapping for your
   * organization.
   *
   * @param workspace name of the workspace (required)
   * @param scheduledLambdaId Scheduled Lambda RRN (required)
   * @param body JSON Object (required)
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public okhttp3.Call updateAsync(
      String workspace,
      String scheduledLambdaId,
      UpdateScheduledLambdaRequest body,
      final ApiCallback<ScheduledLambdaResponse> callback)
      throws Exception {

    ProgressResponseBody.ProgressListener progressListener = null;
    ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

    if (callback != null) {
      progressListener =
          new ProgressResponseBody.ProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
              callback.onDownloadProgress(bytesRead, contentLength, done);
            }
          };

      progressRequestListener =
          new ProgressRequestBody.ProgressRequestListener() {
            @Override
            public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
              callback.onUploadProgress(bytesWritten, contentLength, done);
            }
          };
    }

    okhttp3.Call call =
        updateValidateBeforeCall(
            workspace, scheduledLambdaId, body, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<ScheduledLambdaResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
}
