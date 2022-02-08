package ru.job4j.inheritance;

import ru.job4j.oop.Calculator;

public class Engineer extends Profession {
    private String category;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, String birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Calculator calc() {
        return new Calculator();
    }
}
