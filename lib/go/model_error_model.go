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
	"bytes"
	"encoding/json"
	"fmt"
)

// Describes details about an error
type ErrorModel struct {
	// descriptive message about the error
	Message string `json:"message,omitempty"`
	// category of the error
	Type_ string `json:"type,omitempty"`
	// Line where the error happened (if applicable)
	Line int32 `json:"line,omitempty"`
	// Column where the error happened (if applicable)
	Column int32 `json:"column,omitempty"`
	// Internal trace ID to help with debugging
	TraceId string `json:"trace_id,omitempty"`
	// ID of the error
	ErrorId string `json:"error_id,omitempty"`
}

func (m ErrorModel) PrintResponse() {
	r, err := json.Marshal(m)
	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(r)), "", "    ")
	if err != nil {
		fmt.Println("error parsing string")
		return
	}

	fmt.Println(out.String())
}
