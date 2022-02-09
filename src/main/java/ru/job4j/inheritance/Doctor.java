package ru.job4j.inheritance;

public class Doctor extends Profession {
    public String category;

    public Doctor(String name, String surname, String education, String birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public Diagnosis heal(String name, int age, String keys) {
        return new Diagnosis(name, age, keys);
    }

    public void diagnosisToPrint(Diagnosis heal) {
        System.out.println(heal.toString());
    }

}
