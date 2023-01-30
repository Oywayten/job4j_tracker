package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe")).isEqualTo(true);
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle")).isEqualTo(false);
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello")).isEqualTo(false);
    }
}