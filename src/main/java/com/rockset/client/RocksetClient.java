package com.rockset.client;

import com.rockset.client.api.*;
import com.rockset.client.model.*;
import java.util.List;

public class RocksetClient {
    private ApiClient apiClient;
    private ApiKeysApi apiKeys;
    private CollectionsApi collection;
    private DocumentsApi document;
    private IntegrationsApi integration;
    private QueriesApi query;
    private UsersApi user;
    private QueryLambdasApi queryLambda;
    private WorkspacesApi workspace;

    private void setUp(String apiKey, String apiServer, String application) {
      assert !apiKey.isEmpty();

      if (apiServer.isEmpty()) {
        apiServer = "https://api.rs2.usw2.rockset.com";
      }

      if (!apiServer.startsWith("https://") && !apiServer.startsWith("http://")) {
        apiServer = "https://" + apiServer;
      }

      String userAgent = "java";
      if (!application.isEmpty()) {
        userAgent += ":";
        userAgent += application;
      }

      apiClient = new ApiClient()
          .setApiKey(apiKey)
          .setApiServer(apiServer)
          .setVersion("0.9.0")// TODO: figure out how we can set this dynamically.
          .setUserAgent(userAgent);

      apiKeys = new ApiKeysApi(this.apiClient);
      collection = new CollectionsApi(this.apiClient);
      document = new DocumentsApi(this.apiClient);
      integration = new IntegrationsApi(this.apiClient);
      query = new QueriesApi(this.apiClient);
      user = new UsersApi(this.apiClient);
      workspace = new WorkspacesApi(this.apiClient);
      queryLambda = new QueryLambdasApi(this.apiClient);
    }

    public RocksetClient(String apiKey, String apiServer) {
      setUp(apiKey, apiServer, "");
    }

    public RocksetClient(String apiKey, String apiServer, String application) {
      setUp(apiKey, apiServer, application);
    }

  /**
   * Create a Rockset API key to create and query collections
   * @param request CreateApiKeyRequest object which contains the name of the API key
   * @return CreateApiKeyResponse object containing the ApiKey created
   * @throws Exception
   */
    public CreateApiKeyResponse createApiKey(CreateApiKeyRequest request) throws Exception {
      return apiKeys.create(request);
    }

  /**
   * List all API keys for a user
   * @return List of all API key objects
   * @throws Exception
   */
    public List<ApiKey> listApiKeys() throws Exception {
      return apiKeys.list().getData();
    }

  /**
   * Delete an API key
   * @param name specify the name of the API key to be deleted
   * @return DeleteApiKeyResponse object
   * @throws Exception
   */
    public DeleteApiKeyResponse deleteApiKey(String name) throws Exception {
      return apiKeys.delete(name);
    }

  /**
   * Create a collection in Rockset
   * @param request CreateCollectionRequest object which contains the name and sources for a collection
   * @return CreateCollectionResponse object which contains information about the collection created
   * @throws Exception
   */
    public CreateCollectionResponse createCollection(String workspace, CreateCollectionRequest request) throws Exception {
      return collection.create(workspace, request);
    }

  /**
   * List all collections in the specified workspace
   * @param workspace The Rockset workspace name
   * @return List of Collection object, one for each collection
   * @throws Exception
   */
    public List<Collection> listCollections(String workspace) throws Exception {
      return collection.workspace(workspace).getData();
    }

  /**
   * Get collection details
   * @param name Name of the collection
   * @return GetCollectionResponse object with details about the desctribed collection
   * @throws Exception
   */
    public GetCollectionResponse getCollection(String workspace, String name) throws Exception {
      return collection.get(workspace, name);
    }

  /**
   * Delete a collection
   * @param name Name of the collection to be deleted
   * @return DeleteCollectionResponse object with details about the deleted collection
   * @throws Exception
   */
    public DeleteCollectionResponse deleteCollection(String workspace, String name) throws Exception {
      return collection.delete(workspace, name);
    }

  /**
   * Add documents to an existing collection in Rockset
   * @param collectionName Name of the collection
   * @param request AddDocumentsRequest object which contains list of documents to be inserted
   * @return AddDocumentsResponse object containing status of documents added
   * @throws Exception
   */
    public AddDocumentsResponse addDocuments(String workspace, String collectionName,
                                             AddDocumentsRequest request) throws Exception {
      return document.add(workspace, collectionName, request);
    }

  /**
   * Delete documents from an existing collection in Rockset
   * @param collectionName Name of the collection
   * @param request DeleteDocumentsRequest object containing id of the documents to be deleted
   * @return DeleteDocumentsResponse object with details of the documents deleted
   * @throws Exception
   */
    public DeleteDocumentsResponse deleteDocuments(String workspace, String collectionName,
                                                   DeleteDocumentsRequest request) throws Exception {
      return document.delete(workspace, collectionName, request);
    }

  /**
   * List integration
   * @return List of integration object containing details of each integration
   * @throws Exception
   */
    public List<Integration> listIntegrations() throws Exception {
      return integration.list().getData();
    }

  /**
   * Create an integration e.g. AWS
   * @param request CreateIntegrationRequest object containing details of the integration to be created
   * @return CreateIntegrationResponse response object containing details of the integration created
   * @throws Exception
   */
    public CreateIntegrationResponse createIntegration(CreateIntegrationRequest request) throws Exception {
      return integration.create(request);
    }

  /**
   * Get integration details
   * @param name Name of the integration
   * @return GetIntegrationResponse object with details of the described integration
   * @throws Exception
   */
    public GetIntegrationResponse getIntegration(String name) throws Exception {
      return integration.get(name);
    }

  /**
   * Delete an integration. Integration shouldn't be associated with a collection, else it will fail
   * @param name Name of the integration to be deleted
   * @return DeleteIntegrationResponse object containing details of the integration deleted
   * @throws Exception
   */
    public DeleteIntegrationResponse deleteIntegration(String name) throws Exception{
      return integration.delete(name);
    }

  /**
   * Query a collection in Rockset
   * @param request QueryRequest object containing the SQL query
   * @return QueryResponse object containing the results of the SQL query
   * @throws Exception
   */
    public QueryResponse query(QueryRequest request) throws Exception {
      return query.query(request);
    }

  /**
   * Create a workspace in Rockset
   * @param request CreateWorkspaceRequest object which contains the name and description for a workspace
   * @return CreateWorkspaceResponse object which contains information about the workspace created
   * @throws Exception
   */
    public CreateWorkspaceResponse createWorkspace(CreateWorkspaceRequest request) throws Exception {
      return workspace.create(request);
    }

  /**
   * List all workspaces in an organization
   * @return List of Workspace object, one for each workspace
   * @throws Exception
   */
    public  List<Workspace> listWorkspaces() throws Exception {
      return workspace.list().getData();
    }

  /**
   * Get workspace details
   * @param workspaceName Name of the workspace
   * @return GetWorkspaceResponse object with details about the desctribed workspace
   * @throws Exception
   */
    public GetWorkspaceResponse getWorkspace(String workspaceName) throws Exception {
      return workspace.get(workspaceName);
    }

  /**
   * Delete a workspace
   * @param workspaceName Name of the workspace to be deleted
   * @return DeleteWorkspaceResponse object with details about the deleted workspace
   * @throws Exception
   */
    public DeleteWorkspaceResponse deleteWorkspace(String workspaceName) throws Exception {
      return workspace.delete(workspaceName);
    }

  /**
   * Create a Query Lambda in Rockset
   * @param workspaceName Name of the workspace
   * @param request CreateQueryLambdaRequest object which contains information about the Query Lambda
   * @return QueryLambdaVersionResponse object which contains information about the Query Lambda created
   * @throws Exception
   */
  public QueryLambdaVersionResponse createQueryLambda(
          String workspaceName, CreateQueryLambdaRequest request) throws Exception {
      return queryLambda.create(workspaceName, request);
  }

  /**
   * Create a Query Lambda Tag in Rockset
   * @param workspaceName Name of the workspace
   * @param queryLambdaName Name of the Query Lambda
   * @param request CreateQueryLambdaTagRequest object which contains information about the Query Lambda Tag
   * @return QueryLambdaTagResponse object which contains information about the Query Lambda Tag created
   * @throws Exception
   */
  public QueryLambdaTagResponse createQueryLambdaTag(
          String workspaceName, String queryLambdaName, CreateQueryLambdaTagRequest request) throws Exception {
      return queryLambda.create_0(workspaceName, queryLambdaName, request);
  }

  /**
   * Create a Query Lambda in Rockset
   * @param workspaceName Name of the workspace
   * @param queryName Name of the Query Lambda to be updated
   * @param request UpdateQueryLambdaRequest object which contains information about the Query Lambda
   * @param create Create if missing
   * @return QueryLambdaVersionResponse object which contains information about the Query Lambda updated
   * @throws Exception
   */
  public QueryLambdaVersionResponse updateQueryLambda(
          String workspaceName, String queryName, UpdateQueryLambdaRequest request, Boolean create) throws Exception {
    return queryLambda.update(workspaceName, queryName, request, create);
  }

  /**
   * List all Query Lambdas
   * @return List of QueryLambdaTag objects 
   * @throws Exception
   */
  public List<QueryLambdaTag> listQueryLambdas() throws Exception {
    return queryLambda.list_0().getData();
  }

  /**
   * List all Query Lambda Versions associated with a given tag"
   * @param tag name of the tag
   * @return List of QueryLambdaVersion objects
   * @throws Exception
   */
  public List<QueryLambdaVersion> listQueryLambdaVersions(
          String tag) throws Exception {
    return queryLambda.list_1(tag).getData();
  }

  /**
   * Get Query Lambda Version details
   * @param workspaceName Name of the workspace
   * @param queryName Name of the Query Lambda
   * @param tag Tag of the Query Lambda
   * @return QueryLambdaTagResponse object with details about the Query Lambda Version
   * @throws Exception
   */
  public QueryLambdaTagResponse getQueryLambdaVersionByTag(
          String workspaceName, String queryName, String tag) throws Exception {
    return queryLambda.get(workspaceName, queryName, tag);
  }

  /**
   * Run a Query Lambda
   * @param workspaceName Name of the workspace
   * @param queryName Name of the Query Lambda
   * @param tag Tag of the Query Lambda
   * @param request ExecuteQueryLambdaRequest object with additional run options
   * @return QueryResponse object with query results
   * @throws Exception
   */
  public QueryResponse runQueryLambdaByTag(String workspaceName, String queryName,
                                     String tag, ExecuteQueryLambdaRequest request) throws Exception {
    return queryLambda.execute(workspaceName, queryName, tag, request);
  }


  /**
   * Run a Query Lambda
   * @param workspaceName Name of the workspace
   * @param queryName Name of the Query Lambda
   * @param version Version of the Query Lambda
   * @param request ExecuteQueryLambdaRequest object with additional run options
   * @return QueryResponse object with query results
   * @throws Exception
   */
  public QueryResponse runQueryLambdaByVersion(String workspaceName, String queryName,
                                     String version, ExecuteQueryLambdaRequest request) throws Exception {
    return queryLambda.execute_0(workspaceName, queryName, version, request);
  }


  /**
   * Delete a Query Lambda
   * @param workspaceName Name of the workspace
   * @param queryName Name of query to be deleted
   * @return DeleteQueryLambdaResponse object with details about the deleted Query Lambda
   * @throws Exception
   */
  public DeleteQueryLambdaResponse deleteQueryLambda(String workspaceName, String queryName)
          throws Exception {
    return queryLambda.delete(workspaceName, queryName);
  }


}
