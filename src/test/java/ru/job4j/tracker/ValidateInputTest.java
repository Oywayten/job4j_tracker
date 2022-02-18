package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(4));
    }

    @Test
    public void whenNegativeInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-15"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-15));
    }
}