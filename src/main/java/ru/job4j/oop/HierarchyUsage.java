package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle plain = new Plain();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{train, plain, bus};
        for (Vehicle veh : vehicles) {
            veh.move();
        }
    }
}