package ru.job4j.oop;

/**
 * Created by Oywayten on 16.12.2022.
 */
public class CarMain {
    public static void main(String[] args) {
        Transport transport = new Transport("Brand", "Model");
        Transport.Trancemission trancemission = transport.new Trancemission();
        Transport.Brakes brakes = transport.new Brakes();
        transport.startEngine();
        trancemission.accelerate();
        brakes.brake();
        Transport.TripComputer tripComputer = transport.new TripComputer();
        tripComputer.getInfo();
    }
}
