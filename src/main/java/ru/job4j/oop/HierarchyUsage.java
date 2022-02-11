package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport tp = car;
        Object obj = car;
        Object ocar = new Car();
        Transport carFromObject = (Transport) car;
        Object bicycle = new Bicycle();
        System.out.println(new Car());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}