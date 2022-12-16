package ru.job4j.oop;

/**
 * Created by Oywayten on 16.12.2022.
 */
public class OuterClass {
    int a = 0;

    class NestedClass {
        int b = 0;
        int c = a;
    }

    static class StaticNestedClass {
    }
}
