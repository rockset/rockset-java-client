package com.rockset.client;

import com.rockset.client.api.*;
import com.rockset.client.model.*;

public class RocksetClient {
  private ApiClient apiClient;

  public AliasesApi aliases;
  public ApiKeysApi apiKeys;
  public CollectionsApi collections;
  public CustomRolesBetaApi customRolesBeta;
  public DocumentsApi documents;
  public IntegrationsApi integrations;
  public OrganizationsApi organizations;
  public QueriesApi queries;
  public QueryLambdasApi queryLambdas;
  public UsersApi users;
  public ViewsApi views;
  public VirtualInstancesApi virtualInstances;
  public WorkspacesApi workspaces;

  public RocksetClient(String apiKey, String apiServer) {
    this(apiKey, apiServer, "");
  }

  public RocksetClient(String apiKey, String apiServer, String application) {
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

    apiClient =
        new ApiClient()
            .setApiKey(apiKey)
            .setApiServer(apiServer)
            .setVersion("0.9.4") // TODO: figure out how we can set this dynamically.
            .setUserAgent(userAgent);

    this.aliases = new AliasesApi(this.apiClient);
    this.apiKeys = new ApiKeysApi(this.apiClient);
    this.collections = new CollectionsApi(this.apiClient);
    this.customRolesBeta = new CustomRolesBetaApi(this.apiClient);
    this.documents = new CustomDocumentsApi(this.apiClient);
    this.integrations = new IntegrationsApi(this.apiClient);
    this.organizations = new OrganizationsApi(this.apiClient);
    this.queries = new QueriesApi(this.apiClient);
    this.queryLambdas = new QueryLambdasApi(this.apiClient);
    this.users = new UsersApi(this.apiClient);
    this.views = new ViewsApi(this.apiClient);
    this.virtualInstances = new VirtualInstancesApi(this.apiClient);
    this.workspaces = new WorkspacesApi(this.apiClient);
  }

  public int getConnectTimeout() {
    return apiClient.getConnectTimeout();
  }

  public RocksetClient setConnectTimeout(int connectTimeout) {
    apiClient.setConnectTimeout(connectTimeout);
    return this;
  }

  public int getReadTimeout() {
    return apiClient.getReadTimeout();
  }

  public RocksetClient setReadTimeout(int readTimeout) {
    apiClient.setReadTimeout(readTimeout);
    return this;
  }

  public int getWriteTimeout() {
    return apiClient.getWriteTimeout();
  }

  public RocksetClient setWriteTimeout(int writeTimeout) {
    apiClient.setWriteTimeout(writeTimeout);
    return this;
  }

  public void setAliasesApi(AliasesApi aliasesApi) {
    this.aliases = aliasesApi;
  }

  public void setApiKeys(ApiKeysApi apiKeysApi) {
    this.apiKeys = apiKeysApi;
  }

  public void setCollections(CollectionsApi collectionsApi) {
    this.collections = collectionsApi;
  }

  public void setCustomRolesBeta(CustomRolesBetaApi customRolesBetaApi) {
    this.customRolesBeta = customRolesBetaApi;
  }

  public void setDocuments(DocumentsApi documentsApi) {
    this.documents = documentsApi;
  }

  public void setIntegrations(IntegrationsApi integrationsApi) {
    this.integrations = integrationsApi;
  }

  public void setOrganizations(OrganizationsApi organizationsApi) {
    this.organizations = organizationsApi;
  }

  public void setQueries(QueriesApi queriesApi) {
    this.queries = queriesApi;
  }

  public void setQueryLambdas(QueryLambdasApi queryLambdasApi) {
    this.queryLambdas = queryLambdasApi;
  }

  public void setUsers(UsersApi usersApi) {
    this.users = usersApi;
  }

  public void setViews(ViewsApi viewsApi) {
    this.views = viewsApi;
  }

  public void setVirtualInstances(VirtualInstancesApi virtualInstancesApi) {
    this.virtualInstances = virtualInstancesApi;
  }

  public void setWorkspaces(WorkspacesApi workspacesApi) {
    this.workspaces = workspacesApi;
  }
}
