package wait_test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/rockset/rockset-go-client/openapi"
	"github.com/rockset/rockset-go-client/option"
	"github.com/rockset/rockset-go-client/wait"
)

func TestWait_untilVirtualInstanceActive(t *testing.T) {
	ctx := context.TODO()

	rs := fakeRocksetClient()
	rs.GetVirtualInstanceReturnsOnCall(0, openapi.VirtualInstance{State: openapi.PtrString(option.VirtualInstanceInitializing)}, nil)
	rs.GetVirtualInstanceReturnsOnCall(1, openapi.VirtualInstance{State: openapi.PtrString(option.VirtualInstanceActive)}, nil)

	err := wait.New(&rs).UntilVirtualInstanceActive(ctx, "id")
	assert.NoError(t, err)
	assert.Equal(t, 2, rs.GetVirtualInstanceCallCount())
}

func TestWait_untilVirtualInstanceSuspended(t *testing.T) {
	ctx := context.TODO()

	rs := fakeRocksetClient()
	rs.GetVirtualInstanceReturnsOnCall(0, openapi.VirtualInstance{State: openapi.PtrString(option.VirtualInstanceActive)}, nil)
	rs.GetVirtualInstanceReturnsOnCall(1, openapi.VirtualInstance{State: openapi.PtrString(option.VirtualInstanceSuspending)}, nil)
	rs.GetVirtualInstanceReturnsOnCall(2, openapi.VirtualInstance{State: openapi.PtrString(option.VirtualInstanceSuspended)}, nil)

	err := wait.New(&rs).UntilVirtualInstanceSuspended(ctx, "id")
	assert.NoError(t, err)
	assert.Equal(t, 3, rs.GetVirtualInstanceCallCount())
}

func TestWait_untilVirtualInstanceGone(t *testing.T) {
	ctx := context.TODO()

	rs := fakeRocksetClient()
	rs.GetVirtualInstanceReturnsOnCall(0, openapi.VirtualInstance{State: openapi.PtrString(option.VirtualInstanceActive)}, nil)
	rs.GetVirtualInstanceReturnsOnCall(1, openapi.VirtualInstance{}, NotFoundErr)

	err := wait.New(&rs).UntilVirtualInstanceGone(ctx, "id")
	assert.NoError(t, err)
	assert.Equal(t, 2, rs.GetVirtualInstanceCallCount())
}

func TestWait_untilMountActive(t *testing.T) {
	ctx := context.TODO()

	rs := fakeRocksetClient()
	rs.GetCollectionMountReturnsOnCall(0, openapi.CollectionMount{State: openapi.PtrString(option.MountCreating)}, nil)
	rs.GetCollectionMountReturnsOnCall(1, openapi.CollectionMount{State: openapi.PtrString(option.MountActive)}, nil)

	err := wait.New(&rs).UntilMountActive(ctx, "id", "workspace", "collection")
	assert.NoError(t, err)
	assert.Equal(t, 2, rs.GetCollectionMountCallCount())
}

func TestWait_untilMountGone(t *testing.T) {
	ctx := context.TODO()

	rs := fakeRocksetClient()
	rs.GetCollectionMountReturnsOnCall(0, openapi.CollectionMount{State: openapi.PtrString(option.MountActive)}, nil)
	rs.GetCollectionMountReturnsOnCall(1, openapi.CollectionMount{State: openapi.PtrString(option.MountDeleting)}, nil)
	rs.GetCollectionMountReturnsOnCall(2, openapi.CollectionMount{}, NotFoundErr)

	err := wait.New(&rs).UntilMountGone(ctx, "id", "workspace", "collection")
	assert.NoError(t, err)
	assert.Equal(t, 3, rs.GetCollectionMountCallCount())
}
