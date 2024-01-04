# \VirtualInstancesApi

All URIs are relative to *https://api.use1a1.rockset.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateVirtualInstance**](VirtualInstancesApi.md#CreateVirtualInstance) | **Post** /v1/orgs/self/virtualinstances | Create Virtual Instance
[**DeleteVirtualInstance**](VirtualInstancesApi.md#DeleteVirtualInstance) | **Delete** /v1/orgs/self/virtualinstances/{virtualInstanceId} | Delete Virtual Instance
[**GetCollectionMount**](VirtualInstancesApi.md#GetCollectionMount) | **Get** /v1/orgs/self/virtualinstances/{virtualInstanceId}/mounts/{collectionPath} | Get Collection Mount
[**GetMountOffsets**](VirtualInstancesApi.md#GetMountOffsets) | **Post** /v1/orgs/self/virtualinstances/{virtualInstanceId}/mounts/{collectionPath}/offsets/commit | Get Collection Commit
[**GetVirtualInstance**](VirtualInstancesApi.md#GetVirtualInstance) | **Get** /v1/orgs/self/virtualinstances/{virtualInstanceId} | Retrieve Virtual Instance
[**GetVirtualInstanceQueries**](VirtualInstancesApi.md#GetVirtualInstanceQueries) | **Get** /v1/orgs/self/virtualinstances/{virtualInstanceId}/queries | List Queries
[**ListCollectionMounts**](VirtualInstancesApi.md#ListCollectionMounts) | **Get** /v1/orgs/self/virtualinstances/{virtualInstanceId}/mounts | List Collection Mounts
[**ListVirtualInstances**](VirtualInstancesApi.md#ListVirtualInstances) | **Get** /v1/orgs/self/virtualinstances | List Virtual Instances
[**MountCollection**](VirtualInstancesApi.md#MountCollection) | **Post** /v1/orgs/self/virtualinstances/{virtualInstanceId}/mounts | Mount Collections
[**QueryVirtualInstance**](VirtualInstancesApi.md#QueryVirtualInstance) | **Post** /v1/orgs/self/virtualinstances/{virtualInstanceId}/queries | Execute SQL Query on a specific Virtual Instance
[**ResumeVirtualInstance**](VirtualInstancesApi.md#ResumeVirtualInstance) | **Post** /v1/orgs/self/virtualinstances/{virtualInstanceId}/resume | Resume Virtual Instance
[**SetVirtualInstance**](VirtualInstancesApi.md#SetVirtualInstance) | **Post** /v1/orgs/self/virtualinstances/{virtualInstanceId} | Update Virtual Instance
[**SuspendVirtualInstance**](VirtualInstancesApi.md#SuspendVirtualInstance) | **Post** /v1/orgs/self/virtualinstances/{virtualInstanceId}/suspend | Suspend Virtual Instance
[**UnmountCollection**](VirtualInstancesApi.md#UnmountCollection) | **Delete** /v1/orgs/self/virtualinstances/{virtualInstanceId}/mounts/{collectionPath} | Unmount Collection



## CreateVirtualInstance

> CreateVirtualInstanceResponse CreateVirtualInstance(ctx).Body(body).Execute()

Create Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    body := *openapiclient.NewCreateVirtualInstanceRequest("prod_vi") // CreateVirtualInstanceRequest | JSON object

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.CreateVirtualInstance(context.Background()).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.CreateVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `CreateVirtualInstance`: CreateVirtualInstanceResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.CreateVirtualInstance`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiCreateVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CreateVirtualInstanceRequest**](CreateVirtualInstanceRequest.md) | JSON object | 

### Return type

[**CreateVirtualInstanceResponse**](CreateVirtualInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteVirtualInstance

> DeleteVirtualInstanceResponse DeleteVirtualInstance(ctx, virtualInstanceId).Execute()

Delete Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.DeleteVirtualInstance(context.Background(), virtualInstanceId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.DeleteVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `DeleteVirtualInstance`: DeleteVirtualInstanceResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.DeleteVirtualInstance`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**DeleteVirtualInstanceResponse**](DeleteVirtualInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetCollectionMount

> CollectionMountResponse GetCollectionMount(ctx, virtualInstanceId, collectionPath).Execute()

Get Collection Mount



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN
    collectionPath := "collectionPath_example" // string | 

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.GetCollectionMount(context.Background(), virtualInstanceId, collectionPath).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.GetCollectionMount``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetCollectionMount`: CollectionMountResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.GetCollectionMount`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 
**collectionPath** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetCollectionMountRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**CollectionMountResponse**](CollectionMountResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetMountOffsets

> GetCollectionCommit GetMountOffsets(ctx, virtualInstanceId, collectionPath).Body(body).Execute()

Get Collection Commit



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN
    collectionPath := "collectionPath_example" // string | 
    body := *openapiclient.NewGetCollectionCommitRequest() // GetCollectionCommitRequest | JSON object

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.GetMountOffsets(context.Background(), virtualInstanceId, collectionPath).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.GetMountOffsets``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetMountOffsets`: GetCollectionCommit
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.GetMountOffsets`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 
**collectionPath** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetMountOffsetsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


 **body** | [**GetCollectionCommitRequest**](GetCollectionCommitRequest.md) | JSON object | 

### Return type

[**GetCollectionCommit**](GetCollectionCommit.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetVirtualInstance

> GetVirtualInstanceResponse GetVirtualInstance(ctx, virtualInstanceId).Execute()

Retrieve Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.GetVirtualInstance(context.Background(), virtualInstanceId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.GetVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetVirtualInstance`: GetVirtualInstanceResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.GetVirtualInstance`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**GetVirtualInstanceResponse**](GetVirtualInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetVirtualInstanceQueries

> ListQueriesResponse GetVirtualInstanceQueries(ctx, virtualInstanceId).Execute()

List Queries



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.GetVirtualInstanceQueries(context.Background(), virtualInstanceId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.GetVirtualInstanceQueries``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetVirtualInstanceQueries`: ListQueriesResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.GetVirtualInstanceQueries`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiGetVirtualInstanceQueriesRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**ListQueriesResponse**](ListQueriesResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListCollectionMounts

> ListCollectionMountsResponse ListCollectionMounts(ctx, virtualInstanceId).Execute()

List Collection Mounts



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.ListCollectionMounts(context.Background(), virtualInstanceId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.ListCollectionMounts``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `ListCollectionMounts`: ListCollectionMountsResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.ListCollectionMounts`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiListCollectionMountsRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**ListCollectionMountsResponse**](ListCollectionMountsResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ListVirtualInstances

> ListVirtualInstancesResponse ListVirtualInstances(ctx).Execute()

List Virtual Instances



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.ListVirtualInstances(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.ListVirtualInstances``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `ListVirtualInstances`: ListVirtualInstancesResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.ListVirtualInstances`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiListVirtualInstancesRequest struct via the builder pattern


### Return type

[**ListVirtualInstancesResponse**](ListVirtualInstancesResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## MountCollection

> CreateCollectionMountsResponse MountCollection(ctx, virtualInstanceId).Body(body).Execute()

Mount Collections



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN
    body := *openapiclient.NewCreateCollectionMountRequest() // CreateCollectionMountRequest | JSON object

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.MountCollection(context.Background(), virtualInstanceId).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.MountCollection``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `MountCollection`: CreateCollectionMountsResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.MountCollection`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiMountCollectionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | [**CreateCollectionMountRequest**](CreateCollectionMountRequest.md) | JSON object | 

### Return type

[**CreateCollectionMountsResponse**](CreateCollectionMountsResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## QueryVirtualInstance

> QueryResponse QueryVirtualInstance(ctx, virtualInstanceId).Body(body).Execute()

Execute SQL Query on a specific Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN
    body := *openapiclient.NewQueryRequest(*openapiclient.NewQueryRequestSql("SELECT * FROM foo where _id = :_id")) // QueryRequest | JSON object

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.QueryVirtualInstance(context.Background(), virtualInstanceId).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.QueryVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `QueryVirtualInstance`: QueryResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.QueryVirtualInstance`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiQueryVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | [**QueryRequest**](QueryRequest.md) | JSON object | 

### Return type

[**QueryResponse**](QueryResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ResumeVirtualInstance

> ResumeVirtualInstanceResponse ResumeVirtualInstance(ctx, virtualInstanceId).Execute()

Resume Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.ResumeVirtualInstance(context.Background(), virtualInstanceId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.ResumeVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `ResumeVirtualInstance`: ResumeVirtualInstanceResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.ResumeVirtualInstance`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiResumeVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**ResumeVirtualInstanceResponse**](ResumeVirtualInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SetVirtualInstance

> UpdateVirtualInstanceResponse SetVirtualInstance(ctx, virtualInstanceId).Body(body).Execute()

Update Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN
    body := *openapiclient.NewUpdateVirtualInstanceRequest() // UpdateVirtualInstanceRequest | JSON object

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.SetVirtualInstance(context.Background(), virtualInstanceId).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.SetVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SetVirtualInstance`: UpdateVirtualInstanceResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.SetVirtualInstance`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiSetVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------

 **body** | [**UpdateVirtualInstanceRequest**](UpdateVirtualInstanceRequest.md) | JSON object | 

### Return type

[**UpdateVirtualInstanceResponse**](UpdateVirtualInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SuspendVirtualInstance

> SuspendVirtualInstanceResponse SuspendVirtualInstance(ctx, virtualInstanceId).Execute()

Suspend Virtual Instance



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.SuspendVirtualInstance(context.Background(), virtualInstanceId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.SuspendVirtualInstance``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SuspendVirtualInstance`: SuspendVirtualInstanceResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.SuspendVirtualInstance`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 

### Other Parameters

Other parameters are passed through a pointer to a apiSuspendVirtualInstanceRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**SuspendVirtualInstanceResponse**](SuspendVirtualInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## UnmountCollection

> CollectionMountResponse UnmountCollection(ctx, virtualInstanceId, collectionPath).Execute()

Unmount Collection



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/rockset/rockset-go-client"
)

func main() {
    virtualInstanceId := "virtualInstanceId_example" // string | Virtual Instance RRN
    collectionPath := "collectionPath_example" // string | 

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.VirtualInstancesApi.UnmountCollection(context.Background(), virtualInstanceId, collectionPath).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `VirtualInstancesApi.UnmountCollection``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `UnmountCollection`: CollectionMountResponse
    fmt.Fprintf(os.Stdout, "Response from `VirtualInstancesApi.UnmountCollection`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**virtualInstanceId** | **string** | Virtual Instance RRN | 
**collectionPath** | **string** |  | 

### Other Parameters

Other parameters are passed through a pointer to a apiUnmountCollectionRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------



### Return type

[**CollectionMountResponse**](CollectionMountResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

