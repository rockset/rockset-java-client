package rockset_test

import (
	"fmt"
	"github.com/rockset/rockset-go-client"
	"log"
)

func Example_errorHandling() {
	client, err := rockset.NewClient(rockset.FromEnv())
	if err != nil {
		log.Fatal(err)
	}

	_, _, err = client.DeleteWorkspace("non-existing-workspace")
	if err != nil {
		if e, ok := rockset.AsRocksetError(err); ok {
			fmt.Printf("%s: %s", e.Type_, e.Message)
		}
	}
	// Output:
	// NotFound: Could not find workspace with name 'non-existing-workspace'
}
