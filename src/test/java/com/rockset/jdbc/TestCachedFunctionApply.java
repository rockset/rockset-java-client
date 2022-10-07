package com.rockset.jdbc;

import org.testng.annotations.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCachedFunctionApply {
    private static final Function<String, Integer> STRING_LENGTH = String::length;

    private static final Function<String, Integer> THROWING_FUNCTION = s -> {
        throw new RuntimeException();
    };

    private CachedFunctionApply<String, Integer> sut = new CachedFunctionApply<>();

    @Test
    public void shouldComputeOnNew() {
        // when
        int length = sut.getOrCompute("one", STRING_LENGTH);

        // then
        assertThat(length).isEqualTo(3);
    }

    @Test
    public void shouldReturnCached() {
        // given
        sut.getOrCompute("one", STRING_LENGTH);

        // when
        int length = sut.getOrCompute("one", THROWING_FUNCTION);

        // then
        assertThat(length).isEqualTo(3);
    }

    @Test
    public void shouldAllowNullReferences() {
        // given
        sut.getOrCompute(null, s -> 100);

        // when
        int result = sut.getOrCompute(null, THROWING_FUNCTION);

        // then
        assertThat(result).isEqualTo(100);
    }
}
