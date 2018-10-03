package io.rockset.client;

import io.rockset.client.api.*;
import io.rockset.client.model.*;

import java.util.List;

public class RocksetClient {
    private ApiClient apiClient;
    private ApiKeysApi apiKeys;
    private CollectionsApi collection;
    private DocumentsApi document;
    private IntegrationsApi integration;
    private QueriesApi query;
    private UsersApi user;

    public Client(String apiKey, String apiServer) {

      assert !apiKey.isEmpty();

      if (apiServer.isEmpty()) {
        apiServer = "https://api.rs2.usw2.rockset.com";
      }

      if (!apiServer.startsWith("https://") && !apiServer.startsWith("http://")) {
        apiServer = "https://" + apiServer;
      }

      apiClient = new ApiClient().setApiKey(apiKey).setApiServer(apiServer);

      apiKeys = new ApiKeysApi(this.apiClient);
      collection = new CollectionsApi(this.apiClient);
      document = new DocumentsApi(this.apiClient);
      integration = new IntegrationsApi(this.apiClient);
      query = new QueriesApi(this.apiClient);
      user = new UsersApi(this.apiClient);
    }

    public CreateApiKeyResponse createApiKey(CreateApiKeyRequest request) throws ApiException {
      return apiKeys.create(request);
    }

    public List<ApiKey> listApiKeys() throws ApiException {
      return apiKeys.list().getData();
    }

    public DeleteApiKeyResponse deleteApiKey(String name) throws ApiException {
      return apiKeys.delete(name);
    }

    public CreateCollectionResponse createCollection(CreateCollectionRequest request) throws ApiException {
      return collection.create(request);
    }

    public List<Resource> listCollections() throws ApiException {
      return collection.list().getData();
    }

    public GetCollectionResponse getCollection(String name) throws ApiException {
      return collection.get(name);
    }

    public DeleteCollectionResponse deleteCollection(String name) throws ApiException {
      return collection.delete(name);
    }

    public AddDocumentsResponse addDocuments(String collectionName, AddDocumentsRequest request) throws ApiException {
      return document.add(collectionName, request);
    }

    public DeleteDocumentsResponse deleteDocuments(String collectionName, DeleteDocumentsRequest request) throws ApiException {
      return document.delete(collectionName, request);
    }

    public List<Integration> listIntegrations() throws ApiException {
      return integration.list().getData();
    }

    public CreateIntegrationResponse createIntegration(CreateIntegrationRequest request) throws ApiException {
      return integration.create(request);
    }

    public GetIntegrationResponse getIntegration(String name) throws ApiException {
      return integration.get(name);
    }

    public DeleteIntegrationResponse deleteIntegration(String name) throws ApiException{
      return integration.delete(name);
    }

    public List<User> listUsers() throws ApiException {
      return user.list().getData();
    }

    public CreateUserResponse createUser(CreateUserRequest request) throws ApiException {
      return user.create(request);
    }

    public QueryResponse query(QueryRequest request) throws ApiException {
      return query.query(request, null);
    }
}
