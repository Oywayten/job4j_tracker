package ru.job4j.inheritance;

public class Pacient {
    private String name;
    private int age;

    public Pacient() {
    }

    public Pacient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public  int getAge() {
        return age;
    }
}
