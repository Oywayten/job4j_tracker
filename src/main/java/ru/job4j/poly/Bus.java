package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void drive() {
        System.out.println("The bus started moving");
    }

    @Override
    public void setPassengers(int pas) {
        System.out.println("There are " + pas + " passengers on the bus");
    }

    @Override
    public float refuel(int liters) {
        return liters * 45.50f;
    }
}
