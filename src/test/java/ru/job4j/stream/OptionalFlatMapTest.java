package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalFlatMapTest {

    @Test
    public void whenExist() {
        assertThat(
                Optional.of("Hello.java".length())).isEqualTo(
                OptionalFlatMap.flatMap(
                        List.of("Hello.java", "Hello.js", "Hello.py")
                )
        );
    }

    @Test
    public void whenNotExist() {
        assertThat(
                Optional.empty()).isEqualTo(
                OptionalFlatMap.flatMap(
                        List.of("Hello.cpp", "Hello.js", "Hello.py")
                )
        );
    }
}