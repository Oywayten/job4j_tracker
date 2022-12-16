package ru.job4j.oop;

/**
 * Created by Oywayten on 16.12.2022.
 */
public class FootbalPlayer extends Sportsman {
    @Override
    void run() {
        System.out.println("Средняя скорость бега");
    }

    public void footKick() {
        System.out.println("Удар ногой по мячу");
    }
}
