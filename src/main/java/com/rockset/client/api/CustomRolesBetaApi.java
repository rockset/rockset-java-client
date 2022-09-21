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
import com.rockset.client.model.CreateRoleRequest;
import com.rockset.client.model.ListRolesResponse;
import com.rockset.client.model.RoleResponse;
import com.rockset.client.model.UpdateRoleRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomRolesBetaApi {
  private ApiClient apiClient;

  public CustomRolesBetaApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CustomRolesBetaApi(ApiClient apiClient) {
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
   * @param body JSON Object (required)
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public com.squareup.okhttp.Call createCall(
      CreateRoleRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = body;

    // create path and map variables
    String localVarPath = "/v1/orgs/self/roles";

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
      apiClient
          .getHttpClient()
          .networkInterceptors()
          .add(
              new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(
                    com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                  com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                  return originalResponse
                      .newBuilder()
                      .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                      .build();
                }
              });
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
  private com.squareup.okhttp.Call createValidateBeforeCall(
      CreateRoleRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new Exception("Missing the required parameter 'body' when calling create(Async)");
    }

    com.squareup.okhttp.Call call = createCall(body, progressListener, progressRequestListener);
    return call;
  }

  /**
   * Create a Role Create a role for your organization.
   *
   * @param body JSON Object (required)
   * @return RoleResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public RoleResponse create(CreateRoleRequest body) throws Exception {
    ApiResponse<RoleResponse> resp = createWithHttpInfo(body);
    return resp.getData();
  }

  /**
   * Create a Role Create a role for your organization.
   *
   * @param body JSON Object (required)
   * @return ApiResponse&lt;RoleResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<RoleResponse> createWithHttpInfo(CreateRoleRequest body) throws Exception {
    com.squareup.okhttp.Call call = createValidateBeforeCall(body, null, null);
    Type localVarReturnType = new TypeToken<RoleResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Create a Role (asynchronously) Create a role for your organization.
   *
   * @param body JSON Object (required)
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public com.squareup.okhttp.Call createAsync(
      CreateRoleRequest body, final ApiCallback<RoleResponse> callback) throws Exception {

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

    com.squareup.okhttp.Call call =
        createValidateBeforeCall(body, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<RoleResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  /**
   * Build call for delete
   *
   * @param roleName (required)
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public com.squareup.okhttp.Call deleteCall(
      String roleName,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath =
        "/v1/orgs/self/roles/{roleName}"
            .replaceAll("\\{" + "roleName" + "\\}", apiClient.escapeString(roleName.toString()));

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
      apiClient
          .getHttpClient()
          .networkInterceptors()
          .add(
              new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(
                    com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                  com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                  return originalResponse
                      .newBuilder()
                      .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                      .build();
                }
              });
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
  private com.squareup.okhttp.Call deleteValidateBeforeCall(
      String roleName,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    // verify the required parameter 'roleName' is set
    if (roleName == null) {
      throw new Exception("Missing the required parameter 'roleName' when calling delete(Async)");
    }

    com.squareup.okhttp.Call call = deleteCall(roleName, progressListener, progressRequestListener);
    return call;
  }

  /**
   * Delete a Role Delete a role for your organization.
   *
   * @param roleName (required)
   * @return RoleResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public RoleResponse delete(String roleName) throws Exception {
    ApiResponse<RoleResponse> resp = deleteWithHttpInfo(roleName);
    return resp.getData();
  }

  /**
   * Delete a Role Delete a role for your organization.
   *
   * @param roleName (required)
   * @return ApiResponse&lt;RoleResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<RoleResponse> deleteWithHttpInfo(String roleName) throws Exception {
    com.squareup.okhttp.Call call = deleteValidateBeforeCall(roleName, null, null);
    Type localVarReturnType = new TypeToken<RoleResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Delete a Role (asynchronously) Delete a role for your organization.
   *
   * @param roleName (required)
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public com.squareup.okhttp.Call deleteAsync(
      String roleName, final ApiCallback<RoleResponse> callback) throws Exception {

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

    com.squareup.okhttp.Call call =
        deleteValidateBeforeCall(roleName, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<RoleResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  /**
   * Build call for list
   *
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public com.squareup.okhttp.Call listCall(
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/v1/orgs/self/roles";

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
      apiClient
          .getHttpClient()
          .networkInterceptors()
          .add(
              new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(
                    com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                  com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                  return originalResponse
                      .newBuilder()
                      .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                      .build();
                }
              });
    }

    String[] localVarAuthNames = new String[] {};
    return apiClient.buildCall(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarPostBody,
        localVarHeaderParams,
        localVarFormParams,
        localVarAuthNames,
        progressRequestListener);
  }

  @SuppressWarnings("rawtypes")
  private com.squareup.okhttp.Call listValidateBeforeCall(
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    com.squareup.okhttp.Call call = listCall(progressListener, progressRequestListener);
    return call;
  }

  /**
   * List Roles List all roles for your organization.
   *
   * @return ListRolesResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ListRolesResponse list() throws Exception {
    ApiResponse<ListRolesResponse> resp = listWithHttpInfo();
    return resp.getData();
  }

  /**
   * List Roles List all roles for your organization.
   *
   * @return ApiResponse&lt;ListRolesResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<ListRolesResponse> listWithHttpInfo() throws Exception {
    com.squareup.okhttp.Call call = listValidateBeforeCall(null, null);
    Type localVarReturnType = new TypeToken<ListRolesResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * List Roles (asynchronously) List all roles for your organization.
   *
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public com.squareup.okhttp.Call listAsync(final ApiCallback<ListRolesResponse> callback)
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

    com.squareup.okhttp.Call call =
        listValidateBeforeCall(progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<ListRolesResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  /**
   * Build call for update
   *
   * @param roleName (required)
   * @param body JSON Object (required)
   * @param progressListener Progress listener
   * @param progressRequestListener Progress request listener
   * @return Call to execute
   * @throws Exception If fail to serialize the request body object
   */
  public com.squareup.okhttp.Call updateCall(
      String roleName,
      UpdateRoleRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {
    Object localVarPostBody = body;

    // create path and map variables
    String localVarPath =
        "/v1/orgs/self/roles/{roleName}"
            .replaceAll("\\{" + "roleName" + "\\}", apiClient.escapeString(roleName.toString()));

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
      apiClient
          .getHttpClient()
          .networkInterceptors()
          .add(
              new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(
                    com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                  com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                  return originalResponse
                      .newBuilder()
                      .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                      .build();
                }
              });
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
  private com.squareup.okhttp.Call updateValidateBeforeCall(
      String roleName,
      UpdateRoleRequest body,
      final ProgressResponseBody.ProgressListener progressListener,
      final ProgressRequestBody.ProgressRequestListener progressRequestListener)
      throws Exception {

    // verify the required parameter 'roleName' is set
    if (roleName == null) {
      throw new Exception("Missing the required parameter 'roleName' when calling update(Async)");
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new Exception("Missing the required parameter 'body' when calling update(Async)");
    }

    com.squareup.okhttp.Call call =
        updateCall(roleName, body, progressListener, progressRequestListener);
    return call;
  }

  /**
   * Update a Role Update a role for your organization.
   *
   * @param roleName (required)
   * @param body JSON Object (required)
   * @return RoleResponse
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public RoleResponse update(String roleName, UpdateRoleRequest body) throws Exception {
    ApiResponse<RoleResponse> resp = updateWithHttpInfo(roleName, body);
    return resp.getData();
  }

  /**
   * Update a Role Update a role for your organization.
   *
   * @param roleName (required)
   * @param body JSON Object (required)
   * @return ApiResponse&lt;RoleResponse&gt;
   * @throws Exception If fail to call the API, e.g. server error or cannot deserialize the response
   *     body
   */
  public ApiResponse<RoleResponse> updateWithHttpInfo(String roleName, UpdateRoleRequest body)
      throws Exception {
    com.squareup.okhttp.Call call = updateValidateBeforeCall(roleName, body, null, null);
    Type localVarReturnType = new TypeToken<RoleResponse>() {}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Update a Role (asynchronously) Update a role for your organization.
   *
   * @param roleName (required)
   * @param body JSON Object (required)
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws Exception If fail to process the API call, e.g. serializing the request body object
   */
  public com.squareup.okhttp.Call updateAsync(
      String roleName, UpdateRoleRequest body, final ApiCallback<RoleResponse> callback)
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

    com.squareup.okhttp.Call call =
        updateValidateBeforeCall(roleName, body, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<RoleResponse>() {}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
}