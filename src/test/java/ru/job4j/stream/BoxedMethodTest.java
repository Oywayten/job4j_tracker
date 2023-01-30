package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoxedMethodTest {

    @Test
    public void test() {
        assertThat(
                List.of(1, 2, 3)).isEqualTo(
                BoxedMethod.boxed(new int[]{1, 2, 3})
        );
    }
}