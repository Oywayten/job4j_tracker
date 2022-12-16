package ru.job4j.polymorph;

/**
 * Created by Oywayten on 16.12.2022.
 */
public class MainFunc implements Func1, Func2 {
    @Override
    public double func(double x, double y) {
        return Func2.super.func(x, y);
    }
}
