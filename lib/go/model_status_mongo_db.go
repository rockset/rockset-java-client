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

type StatusMongoDb struct {
	// MongoDB scan start time
	ScanStartTime string `json:"scan_start_time,omitempty"`
	// MongoDB scan end time
	ScanEndTime string `json:"scan_end_time,omitempty"`
	// Number of records inserted using scan
	ScanRecordsProcessed int64 `json:"scan_records_processed,omitempty"`
	// Number of records in MongoDB table at time of scan
	ScanTotalRecords int64 `json:"scan_total_records,omitempty"`
	// state of current ingest for this table
	State string `json:"state,omitempty"`
	// ISO-8601 date when new insert from source was last processed
	StreamLastInsertProcessedAt string `json:"stream_last_insert_processed_at,omitempty"`
	// ISO-8601 date when update from source was last processed
	StreamLastUpdateProcessedAt string `json:"stream_last_update_processed_at,omitempty"`
	// ISO-8601 date when delete from source was last processed
	StreamLastDeleteProcessedAt string `json:"stream_last_delete_processed_at,omitempty"`
	// Number of new records inserted using stream
	StreamRecordsInserted int64 `json:"stream_records_inserted,omitempty"`
	// Number of new records updated using stream
	StreamRecordsUpdated int64 `json:"stream_records_updated,omitempty"`
	// Number of new records deleted using stream
	StreamRecordsDeleted int64 `json:"stream_records_deleted,omitempty"`
}

func (m StatusMongoDb) PrintResponse() {
	r, err := json.Marshal(m)
	var out bytes.Buffer
	err = json.Indent(&out, []byte(string(r)), "", "    ")
	if err != nil {
		fmt.Println("error parsing string")
		return
	}

	fmt.Println(out.String())
}
