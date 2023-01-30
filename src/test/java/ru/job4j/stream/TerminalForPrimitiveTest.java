package ru.job4j.stream;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TerminalForPrimitiveTest {

    @Test
    public void test() {
        int[] data = {1, 2, 3};
        TerminalForPrimitive terminal = new TerminalForPrimitive(data);
        assertThat(3).isEqualTo(terminal.count());
        assertThat(3).isEqualTo(terminal.max());
        assertThat(1).isEqualTo(terminal.min());
        assertThat(6).isEqualTo(terminal.sum());
        assertThat(2).isCloseTo((int) terminal.avg(), Percentage.withPercentage(0.01));
    }
}