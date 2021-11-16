package com.rockset.client;

import com.rockset.client.api.*;
import com.rockset.client.model.*;

public class RocksetClient {
  private ApiClient apiClient;

  public final AliasesApi aliases;
  public final ApiKeysApi apiKeys;
  public final CollectionsApi collections;
  public final CustomRolesBetaApi customRolesBeta;
  public final DocumentsApi documents;
  public final IntegrationsApi integrations;
  public final OrganizationsApi organizations;
  public final QueriesApi queries;
  public final QueryLambdasApi queryLambdas;
  public final UsersApi users;
  public final ViewsApi views;
  public final VirtualInstancesApi virtualInstances;
  public final WorkspacesApi workspaces;

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
            .setVersion("0.9.0") // TODO: figure out how we can set this dynamically.
            .setUserAgent(userAgent);

    this.aliases = new AliasesApi(this.apiClient);
    this.apiKeys = new ApiKeysApi(this.apiClient);
    this.collections = new CollectionsApi(this.apiClient);
    this.customRolesBeta = new CustomRolesBetaApi(this.apiClient);
    this.documents = new DocumentsApi(this.apiClient);
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
}
