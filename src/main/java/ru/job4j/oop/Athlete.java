package ru.job4j.oop;

/**
 * Created by Oywayten on 16.12.2022.
 */
public class Athlete extends Sportsman {
    @Override
    public void run() {
        System.out.println("Быстрая скорость бега");
    }

    public void sprint() {
        System.out.println("Быстрый рывок на короткую дистанцию");
    }
}
