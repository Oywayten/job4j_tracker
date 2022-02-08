package ru.job4j.inheritance;

public class Diagnosis extends Pacient {
    private String diagnosis;

    public Diagnosis() {
    }

    public Diagnosis(String name, int age, String diagnosis) {
        super(name, age);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Имя пациента: " + getName() + "\nВозраст пациента: " + getAge() + "\nДиагноз: " + diagnosis;
    }

}
