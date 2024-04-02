package com.rockset.client.util;

import com.rockset.client.ApiException;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RetryHelper {
    public static <T> T retryOnApiException(Callable<T> request) {
        return Awaitility
                .await()
                .atMost(5, TimeUnit.MINUTES)
                .pollInterval(1, TimeUnit.SECONDS)
                .until(() -> {
                    try {
                        return request.call();
                    } catch (ApiException e) {
                        System.out.println("Encountered error, retrying request: " + e.getMessage());
                        return null;
                    }
                }, Matchers.notNullValue());
    }
}
