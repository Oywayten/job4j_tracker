package ru.job4j.inheritance;

public class Diagnosis {
    private String pacientName;
    private int pacientAge;
    private String diagnosis;

    public Diagnosis(String name, int age, String diagnosis) {
        pacientName = name;
        pacientAge = age;
        this.diagnosis = diagnosis;
    }

    public String getPacientName() {
        return pacientName;
    }

    public int getPacientAge() {
        return pacientAge;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Summary by Pacient research " + System.lineSeparator() + "Patient's name: "
                + getPacientName() + "\nAge: "
                + getPacientAge() + "\nDiagnosis: "
                + diagnosis + System.lineSeparator();
    }

}
