package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class FactTest {

    @Test
    public void whenIntLessZero() {
        Fact fact = new Fact();
        assertThatIllegalArgumentException().isThrownBy(() -> fact.calc(-1));
    }
}