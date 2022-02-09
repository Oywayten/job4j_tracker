package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String specialization;

    public Dentist(String name, String surname, String education, String birthday, String category, String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    public int toothBeforDel(int tooth) {
        return (tooth > 15 && tooth <= 32) ? tooth : 32;
    }

    public int toothForDel(int del) {
        return (del > 0 && del <= 3) ? del : 1;
    }

    public int toothAfterDel(int tooth, int del) {
        return (tooth > 15 && tooth <= 32) && (del > 0 && del <= 3) ? tooth - del : 32 - 1;
    }

    public String toothDelReportToString(int tooth, int del) {
        return "Treatment report: " + System.lineSeparator()
                + "Tooth befor delete: " + toothBeforDel(tooth) + System.lineSeparator()
                + "Tooth for delete: " + toothForDel(del) + System.lineSeparator()
                + "Tooth after delete: " + toothAfterDel(tooth, del) + System.lineSeparator()
                + "Doctor " + getName() + " " + getSurname()
                + System.lineSeparator() + specialization;
    }

    public static void main(String[] args) {
        Dentist sasha = new Dentist("Alexander", "Alexandrov", "High", "01.01.2021",
                "High", "Tooth deleter");
        Diagnosis heal = sasha.heal("Ivan", 25, "Tooth pain");
        System.out.println(heal.toString());
        System.out.println(sasha.toothDelReportToString(32, 1));
    }
}
