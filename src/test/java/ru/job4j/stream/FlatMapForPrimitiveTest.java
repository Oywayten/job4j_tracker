package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlatMapForPrimitiveTest {
    @Test
    public void test() {
        assertThat(
                15).isEqualTo(
                FlatMapForPrimitive.sum(new int[][]{
                        {1, 2, 3},
                        {4, 5}
                })
        );
    }
}