package ru.job4j.oop;

public class Transport {

    private String brand;
    private String model;
    private static String carManual = "Инструкция к автомобилю";

    public Transport(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Start engine");
    }

    public class Trancemission {
        public void accelerate() {
            System.out.println("Ускорение");
        }
    }

    public static TripComputer getTripComputer() {
        Transport transport = new Transport("Brand", "Model");
        return transport.new TripComputer();
    }

    public class Brakes {
        public void brake() {
            System.out.println("Торможение");
        }
    }

    public class TripComputer {
        public String tripData = "Бортовой компьютер";
        private String model = "Модель TripComputer";

        public void getInfo() {
            System.out.println("Марка: " + this.model);
            System.out.println("Модель Transport: " + Transport.this.model);
        }
    }

    public static class Manual {
        public static String getManual() {
            return carManual;
        }
    }

}

class Main {
    public static void main(String[] args) {
        Transport.Manual manual = new Transport.Manual();
    }
}
