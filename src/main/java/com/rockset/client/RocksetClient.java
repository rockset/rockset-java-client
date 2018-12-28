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

    public RocksetClient(String apiKey, String apiServer) {

      assert !apiKey.isEmpty();

      if (apiServer.isEmpty()) {
        apiServer = "https://api.rs2.usw2.rockset.com";
      }

      if (!apiServer.startsWith("https://") && !apiServer.startsWith("http://")) {
        apiServer = "https://" + apiServer;
      }

      apiClient = new ApiClient()
          .setApiKey(apiKey)
          .setApiServer(apiServer)
          .setVersion("0.4.8");// TODO: figure out how we can set this dynamically.

      apiKeys = new ApiKeysApi(this.apiClient);
      collection = new CollectionsApi(this.apiClient);
      document = new DocumentsApi(this.apiClient);
      integration = new IntegrationsApi(this.apiClient);
      query = new QueriesApi(this.apiClient);
      user = new UsersApi(this.apiClient);
    }

  /**
   * Create a Rockset API key to create and query collections
   * @param request CreateApiKeyRequest object which contains the name of the API key
   * @return CreateApiKeyResponse object containing the ApiKey created
   * @throws ApiException
   */
    public CreateApiKeyResponse createApiKey(CreateApiKeyRequest request) throws ApiException {
      return apiKeys.create(request);
    }

  /**
   * List all API keys for a user
   * @return List of all API key objects
   * @throws ApiException
   */
    public List<ApiKey> listApiKeys() throws ApiException {
      return apiKeys.list().getData();
    }

  /**
   * Delete an API key
   * @param name specify the name of the API key to be deleted
   * @return DeleteApiKeyResponse object
   * @throws ApiException
   */
    public DeleteApiKeyResponse deleteApiKey(String name) throws ApiException {
      return apiKeys.delete(name);
    }

  /**
   * Create a collection in Rockset
   * @param request CreateCollectionRequest object which contains the name and sources for a collection
   * @return CreateCollectionResponse object which contains information about the collection created
   * @throws ApiException
   */
    public CreateCollectionResponse createCollection(CreateCollectionRequest request) throws ApiException {
      return collection.create(request);
    }

  /**
   * List all collections in an organization
   * @return List of Resource object, one for each collection
   * @throws ApiException
   */
    public List<Resource> listCollections() throws ApiException {
      return collection.list().getData();
    }

  /**
   * Get collection details
   * @param name Name of the collection
   * @return GetCollectionResponse object with details about the desctribed collection
   * @throws ApiException
   */
    public GetCollectionResponse getCollection(String name) throws ApiException {
      return collection.get(name);
    }

  /**
   * Delete a collection
   * @param name Name of the collection to be deleted
   * @return DeleteCollectionResponse object with details about the deleted collection
   * @throws ApiException
   */
    public DeleteCollectionResponse deleteCollection(String name) throws ApiException {
      return collection.delete(name);
    }

  /**
   * Add documents to an existing collection in Rockset
   * @param collectionName Name of the collection
   * @param request AddDocumentsRequest object which contains list of documents to be inserted
   * @return AddDocumentsResponse object containing status of documents added
   * @throws ApiException
   */
    public AddDocumentsResponse addDocuments(String collectionName, AddDocumentsRequest request) throws ApiException {
      return document.add(collectionName, request);
    }

  /**
   * Delete documents from an existing collection in Rockset
   * @param collectionName Name of the collection
   * @param request DeleteDocumentsRequest object containing id of the documents to be deleted
   * @return DeleteDocumentsResponse object with details of the documents deleted
   * @throws ApiException
   */
    public DeleteDocumentsResponse deleteDocuments(String collectionName, DeleteDocumentsRequest request) throws ApiException {
      return document.delete(collectionName, request);
    }

  /**
   * List integration
   * @return List of integration object containing details of each integration
   * @throws ApiException
   */
    public List<Integration> listIntegrations() throws ApiException {
      return integration.list().getData();
    }

  /**
   * Create an integration e.g. AWS
   * @param request CreateIntegrationRequest object containing details of the integration to be created
   * @return CreateIntegrationResponse response object containing details of the integration created
   * @throws ApiException
   */
    public CreateIntegrationResponse createIntegration(CreateIntegrationRequest request) throws ApiException {
      return integration.create(request);
    }

  /**
   * Get integration details
   * @param name Name of the integration
   * @return GetIntegrationResponse object with details of the described integration
   * @throws ApiException
   */
    public GetIntegrationResponse getIntegration(String name) throws ApiException {
      return integration.get(name);
    }

  /**
   * Delete an integration. Integration shouldn't be associated with a collection, else it will fail
   * @param name Name of the integration to be deleted
   * @return DeleteIntegrationResponse object containing details of the integration deleted
   * @throws ApiException
   */
    public DeleteIntegrationResponse deleteIntegration(String name) throws ApiException{
      return integration.delete(name);
    }

  /**
   * Query a collection in Rockset
   * @param request QueryRequest object containing the SQL query
   * @return QueryResponse object containing the results of the SQL query
   * @throws ApiException
   */
    public QueryResponse query(QueryRequest request) throws ApiException {
      return query.query(request);
    }
}
