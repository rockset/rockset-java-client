/*
 * REST API
 *
 * Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!
 *
 * API version: v1
 * Generated by: Swagger Codegen (https://github.com/swagger-api/swagger-codegen.git)
 */

package rockset

import (
	"bufio"
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
	"strings"
)

type CollectionsApiService Service

/*
CollectionsApiService Create Collection
Create new collection in a workspace.
 * @param workspace name of the workspace
 * @param body JSON object

@return CreateCollectionResponse
*/
func (a *CollectionsApiService) Create(workspace string, body CreateCollectionRequest) (CreateCollectionResponse, *http.Response, error) {
	var (
		localVarHttpMethod  = strings.ToUpper("Post")
		localVarPostBody    interface{}
		localVarFileName    string
		localVarFileBytes   []byte
		localVarReturnValue CreateCollectionResponse
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	// body params
	localVarPostBody = &body
	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	localVarBody, err := ioutil.ReadAll(localVarHttpResponse.Body)
	localVarHttpResponse.Body.Close()
	if err != nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode < 300 {
		// If we succeed, return the data, otherwise pass on to decode error.
		err = a.Client.decode(&localVarReturnValue, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
		if err == nil {
			return localVarReturnValue, localVarHttpResponse, err
		}
	}

	if localVarHttpResponse.StatusCode >= 300 {
		newErr := GenericSwaggerError{
			body:  localVarBody,
			error: localVarHttpResponse.Status,
		}

		if localVarHttpResponse.StatusCode == 200 {
			var v CreateCollectionResponse
			err = a.Client.decode(&v, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHttpResponse, newErr
			}
			newErr.model = v
			return localVarReturnValue, localVarHttpResponse, newErr
		}

		return localVarReturnValue, localVarHttpResponse, newErr
	}

	return localVarReturnValue, localVarHttpResponse, nil
}

func (a *CollectionsApiService) CreateStream(workspace string, body CreateCollectionRequest) (string, *http.Response, error) {
	var (
		localVarHttpMethod = strings.ToUpper("Post")
		localVarPostBody   interface{}
		localVarFileName   string
		localVarFileBytes  []byte
		localVarBody       []byte
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	// body params
	localVarPostBody = &body
	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return "", nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return "", localVarHttpResponse, err
	}

	reader := bufio.NewReader(localVarHttpResponse.Body)
	localVarBody, err = reader.ReadBytes('\n')

	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(localVarBody)), "", "    ")
	if err != nil {
		return "", localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode >= 300 {
		return out.String(), localVarHttpResponse, nil
	}

	return out.String(), localVarHttpResponse, nil
}

/*
CollectionsApiService Delete Collection
Delete a collection and all its documents from Rockset.
 * @param workspace name of the workspace
 * @param collection name of the collection

@return DeleteCollectionResponse
*/
func (a *CollectionsApiService) Delete(workspace string, collection string) (DeleteCollectionResponse, *http.Response, error) {
	var (
		localVarHttpMethod  = strings.ToUpper("Delete")
		localVarPostBody    interface{}
		localVarFileName    string
		localVarFileBytes   []byte
		localVarReturnValue DeleteCollectionResponse
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections/{collection}"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)
	localVarPath = strings.Replace(localVarPath, "{"+"collection"+"}", fmt.Sprintf("%v", collection), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	localVarBody, err := ioutil.ReadAll(localVarHttpResponse.Body)
	localVarHttpResponse.Body.Close()
	if err != nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode < 300 {
		// If we succeed, return the data, otherwise pass on to decode error.
		err = a.Client.decode(&localVarReturnValue, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
		if err == nil {
			return localVarReturnValue, localVarHttpResponse, err
		}
	}

	if localVarHttpResponse.StatusCode >= 300 {
		newErr := GenericSwaggerError{
			body:  localVarBody,
			error: localVarHttpResponse.Status,
		}

		if localVarHttpResponse.StatusCode == 200 {
			var v DeleteCollectionResponse
			err = a.Client.decode(&v, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHttpResponse, newErr
			}
			newErr.model = v
			return localVarReturnValue, localVarHttpResponse, newErr
		}

		return localVarReturnValue, localVarHttpResponse, newErr
	}

	return localVarReturnValue, localVarHttpResponse, nil
}

func (a *CollectionsApiService) DeleteStream(workspace string, collection string) (string, *http.Response, error) {
	var (
		localVarHttpMethod = strings.ToUpper("Delete")
		localVarPostBody   interface{}
		localVarFileName   string
		localVarFileBytes  []byte
		localVarBody       []byte
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections/{collection}"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)
	localVarPath = strings.Replace(localVarPath, "{"+"collection"+"}", fmt.Sprintf("%v", collection), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return "", nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return "", localVarHttpResponse, err
	}

	reader := bufio.NewReader(localVarHttpResponse.Body)
	localVarBody, err = reader.ReadBytes('\n')

	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(localVarBody)), "", "    ")
	if err != nil {
		return "", localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode >= 300 {
		return out.String(), localVarHttpResponse, nil
	}

	return out.String(), localVarHttpResponse, nil
}

/*
CollectionsApiService Get Collection
Get details about a collection.
 * @param workspace name of the workspace
 * @param collection name of the collection

@return GetCollectionResponse
*/
func (a *CollectionsApiService) Get(workspace string, collection string) (GetCollectionResponse, *http.Response, error) {
	var (
		localVarHttpMethod  = strings.ToUpper("Get")
		localVarPostBody    interface{}
		localVarFileName    string
		localVarFileBytes   []byte
		localVarReturnValue GetCollectionResponse
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections/{collection}"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)
	localVarPath = strings.Replace(localVarPath, "{"+"collection"+"}", fmt.Sprintf("%v", collection), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	localVarBody, err := ioutil.ReadAll(localVarHttpResponse.Body)
	localVarHttpResponse.Body.Close()
	if err != nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode < 300 {
		// If we succeed, return the data, otherwise pass on to decode error.
		err = a.Client.decode(&localVarReturnValue, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
		if err == nil {
			return localVarReturnValue, localVarHttpResponse, err
		}
	}

	if localVarHttpResponse.StatusCode >= 300 {
		newErr := GenericSwaggerError{
			body:  localVarBody,
			error: localVarHttpResponse.Status,
		}

		if localVarHttpResponse.StatusCode == 200 {
			var v GetCollectionResponse
			err = a.Client.decode(&v, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHttpResponse, newErr
			}
			newErr.model = v
			return localVarReturnValue, localVarHttpResponse, newErr
		}

		return localVarReturnValue, localVarHttpResponse, newErr
	}

	return localVarReturnValue, localVarHttpResponse, nil
}

func (a *CollectionsApiService) GetStream(workspace string, collection string) (string, *http.Response, error) {
	var (
		localVarHttpMethod = strings.ToUpper("Get")
		localVarPostBody   interface{}
		localVarFileName   string
		localVarFileBytes  []byte
		localVarBody       []byte
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections/{collection}"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)
	localVarPath = strings.Replace(localVarPath, "{"+"collection"+"}", fmt.Sprintf("%v", collection), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return "", nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return "", localVarHttpResponse, err
	}

	reader := bufio.NewReader(localVarHttpResponse.Body)
	localVarBody, err = reader.ReadBytes('\n')

	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(localVarBody)), "", "    ")
	if err != nil {
		return "", localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode >= 300 {
		return out.String(), localVarHttpResponse, nil
	}

	return out.String(), localVarHttpResponse, nil
}

/*
CollectionsApiService List Collections
Retrieve all collections in an organization.

@return ListCollectionsResponse
*/
func (a *CollectionsApiService) List() (ListCollectionsResponse, *http.Response, error) {
	var (
		localVarHttpMethod  = strings.ToUpper("Get")
		localVarPostBody    interface{}
		localVarFileName    string
		localVarFileBytes   []byte
		localVarReturnValue ListCollectionsResponse
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/collections"

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	localVarBody, err := ioutil.ReadAll(localVarHttpResponse.Body)
	localVarHttpResponse.Body.Close()
	if err != nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode < 300 {
		// If we succeed, return the data, otherwise pass on to decode error.
		err = a.Client.decode(&localVarReturnValue, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
		if err == nil {
			return localVarReturnValue, localVarHttpResponse, err
		}
	}

	if localVarHttpResponse.StatusCode >= 300 {
		newErr := GenericSwaggerError{
			body:  localVarBody,
			error: localVarHttpResponse.Status,
		}

		if localVarHttpResponse.StatusCode == 200 {
			var v ListCollectionsResponse
			err = a.Client.decode(&v, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHttpResponse, newErr
			}
			newErr.model = v
			return localVarReturnValue, localVarHttpResponse, newErr
		}

		return localVarReturnValue, localVarHttpResponse, newErr
	}

	return localVarReturnValue, localVarHttpResponse, nil
}

func (a *CollectionsApiService) ListStream() (string, *http.Response, error) {
	var (
		localVarHttpMethod = strings.ToUpper("Get")
		localVarPostBody   interface{}
		localVarFileName   string
		localVarFileBytes  []byte
		localVarBody       []byte
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/collections"

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return "", nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return "", localVarHttpResponse, err
	}

	reader := bufio.NewReader(localVarHttpResponse.Body)
	localVarBody, err = reader.ReadBytes('\n')

	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(localVarBody)), "", "    ")
	if err != nil {
		return "", localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode >= 300 {
		return out.String(), localVarHttpResponse, nil
	}

	return out.String(), localVarHttpResponse, nil
}

/*
CollectionsApiService List Collections for Workspace
Retrieve all collections in a workspace.
 * @param workspace name of the workspace

@return ListCollectionsResponse
*/
func (a *CollectionsApiService) Workspace(workspace string) (ListCollectionsResponse, *http.Response, error) {
	var (
		localVarHttpMethod  = strings.ToUpper("Get")
		localVarPostBody    interface{}
		localVarFileName    string
		localVarFileBytes   []byte
		localVarReturnValue ListCollectionsResponse
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	localVarBody, err := ioutil.ReadAll(localVarHttpResponse.Body)
	localVarHttpResponse.Body.Close()
	if err != nil {
		return localVarReturnValue, localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode < 300 {
		// If we succeed, return the data, otherwise pass on to decode error.
		err = a.Client.decode(&localVarReturnValue, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
		if err == nil {
			return localVarReturnValue, localVarHttpResponse, err
		}
	}

	if localVarHttpResponse.StatusCode >= 300 {
		newErr := GenericSwaggerError{
			body:  localVarBody,
			error: localVarHttpResponse.Status,
		}

		if localVarHttpResponse.StatusCode == 200 {
			var v ListCollectionsResponse
			err = a.Client.decode(&v, localVarBody, localVarHttpResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHttpResponse, newErr
			}
			newErr.model = v
			return localVarReturnValue, localVarHttpResponse, newErr
		}

		return localVarReturnValue, localVarHttpResponse, newErr
	}

	return localVarReturnValue, localVarHttpResponse, nil
}

func (a *CollectionsApiService) WorkspaceStream(workspace string) (string, *http.Response, error) {
	var (
		localVarHttpMethod = strings.ToUpper("Get")
		localVarPostBody   interface{}
		localVarFileName   string
		localVarFileBytes  []byte
		localVarBody       []byte
	)

	// create path and map variables
	localVarPath := a.Client.cfg.BasePath + "/v1/orgs/self/ws/{workspace}/collections"
	localVarPath = strings.Replace(localVarPath, "{"+"workspace"+"}", fmt.Sprintf("%v", workspace), -1)

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	// to determine the Content-Type header
	localVarHttpContentTypes := []string{"application/json"}

	// set Content-Type header
	localVarHttpContentType := selectHeaderContentType(localVarHttpContentTypes)
	if localVarHttpContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHttpContentType
	}

	// to determine the Api Key header
	localVarHttpHeaderAuthorization := ""
	localVarHttpHeaderApiKey := a.Client.selectHeaderAuthorization(localVarHttpHeaderAuthorization)
	if localVarHttpHeaderApiKey == "" {
		log.Fatal("missing required argument ApiKey")
	}
	localVarHeaderParams["authorization"] = "ApiKey " + localVarHttpHeaderApiKey

	r, err := a.Client.prepareRequest(localVarPath, localVarHttpMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, localVarFileName, localVarFileBytes)
	if err != nil {
		return "", nil, err
	}

	localVarHttpResponse, err := a.Client.callAPI(r)
	if err != nil || localVarHttpResponse == nil {
		return "", localVarHttpResponse, err
	}

	reader := bufio.NewReader(localVarHttpResponse.Body)
	localVarBody, err = reader.ReadBytes('\n')

	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(localVarBody)), "", "    ")
	if err != nil {
		return "", localVarHttpResponse, err
	}

	if localVarHttpResponse.StatusCode >= 300 {
		return out.String(), localVarHttpResponse, nil
	}

	return out.String(), localVarHttpResponse, nil
}
