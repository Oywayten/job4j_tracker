package ru.job4j.inheritance;

public class Doctor extends Profession {
    public String category;

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, String birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public Diagnosis heal(Pacient newPacient, String keys) {
        return new Diagnosis(newPacient.getName(), newPacient.getAge(), keys);
    }

}
