package ru.job4j.polymorph;

/**
 * Created by Oywayten on 16.12.2022.
 */
public interface Vehicle {
    int WHEELS = 4;

    void accelerate();

    void breake();

    void steer();

    void changeGear();

    static void getDragCoefficient() {
        System.out.println("Формула расчета коэффициента аэродинамического сопротивления автомобиля");
    }

    default void chargeBattery() {
        System.out.println("Аккумулятор под капотом. Зарядить.");
    }
}
