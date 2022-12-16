package ru.job4j.oop;

/**
 * Created by Oywayten on 16.12.2022.
 */
public abstract class Sportsman {

    public void sayMyName() {
        System.out.println("My name is " + this.getClass().getName());
    }

    abstract void run();
}
