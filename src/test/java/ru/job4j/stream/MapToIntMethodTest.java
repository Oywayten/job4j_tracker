package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MapToIntMethodTest {

    @Test
    public void test() {
        assertThat(294).isEqualTo(MapToIntMethod.sum(List.of('a', 'b', 'c')));
    }
}