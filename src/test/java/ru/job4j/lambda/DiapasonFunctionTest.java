package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DiapasonFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> 5 * x * x + 5 * x + 5);
        List<Double> expected = Arrays.asList(155D, 215D, 285D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(3125D, 15625D, 78125D);
        assertThat(result, is(expected));
    }
}