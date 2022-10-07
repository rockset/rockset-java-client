package com.rockset.jdbc;

import java.util.function.Function;

/**
 * Caches the result of a {@link Function#apply(Object)}.
 * <p>
 * Do not use an instance of this class in multiple threads.
 */
public class CachedFunctionApply<T, R> {
    private static final Object NOT_INVOKED = new Object();

    private T lastArgument = (T) NOT_INVOKED;
    private R lastResult;

    public R getOrCompute(T t, Function<T, R> function) {
        if (t == lastArgument) {
            return lastResult;
        }

        lastArgument = t;
        return lastResult = function.apply(t);
    }
}
