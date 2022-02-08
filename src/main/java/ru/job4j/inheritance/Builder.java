package ru.job4j.inheritance;

import ru.job4j.oop.Calculator;
import ru.job4j.oop.Jukebox;

public class Builder extends Engineer {
    private String specialization;

    public Builder() {
    }

    public Builder(String name, String surname, String education, String birthday, String category, String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Builder information{"
                + "\nname= '" + getName() + "', \nsurname= '" + getSurname() + "', \neducation= '" + getEducation()
                + "', \nbirthday= '" + getBirthday()
                + "', \ncategory='" + getCategory() + '\''
                + ", \nspecialization='" + specialization
                + '\''
                + '}';
    }

    public Jukebox makeJukebox() {
        return new Jukebox();
    }

    public static void main(String[] args) {
        Builder ivan = new Builder("Ivan", "Ivanov", "High", "11.11.2011", "High", "Jukebox builder");
        Jukebox bigBen = ivan.makeJukebox();
        bigBen.music(2);
        System.out.println(ivan.toString());
    }
}
