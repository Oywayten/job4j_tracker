package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParenthesesTest {

    @Test
    public void whenValidInner() {
        assertThat(
                Parentheses.valid(new char[]{'(', '(', ')', ')'})
        ).isTrue();
    }

    @Test
    public void whenValidSeq() {
        assertThat(
                Parentheses.valid(new char[]{'(', ')', '(', ')'})
        ).isTrue();
    }

    @Test
    public void whenInValidInner() {
        assertThat(
                Parentheses.valid(new char[]{')', ')', '(', '('})
        ).isFalse();
    }

    @Test
    public void whenInValidSeq() {
        assertThat(
                Parentheses.valid(new char[]{'(', ')', '(', '('})
        ).isFalse();
    }

    @Test
    public void whenValidSeqMore() {
        assertThat(
                Parentheses.valid(new char[]{'(', '(', ')', '(', ')', '(', '(', ')', '(', ')', ')', ')'})
        ).isTrue();
    }
}
