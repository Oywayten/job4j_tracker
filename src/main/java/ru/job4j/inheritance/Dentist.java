package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String specialization;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, String birthday, String category, String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    Diagnosis heal = heal(new Pacient("Vika", 18), "Toothpain");

    public Report dentistReport(Diagnosis heal, String report) {
        return new Report(heal, "No more pain");
    }

    public String reportToString(Report report) {
        return report.toString() + "\n" + specialization + ": " + getSurname() + " " + getName();
    }

    public void dentistReportPrint(Report report) {
        System.out.println(reportToString(report));
    }
}
