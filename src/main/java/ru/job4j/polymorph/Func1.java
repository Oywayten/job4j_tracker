package ru.job4j.polymorph;

public interface Func1 {
    default double func(double x, double y) {
        return x * x - 2 * y + 30;
    }
}