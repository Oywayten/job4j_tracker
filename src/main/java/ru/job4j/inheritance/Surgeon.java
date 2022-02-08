package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialization;

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, String birthday, String category, String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    Diagnosis heal = heal(new Pacient("Vasya", 25), "Hernia");

    public Report surgeonReport(Diagnosis heal, String report) {
        return new Report(heal, "All right!");
    }

    public String reportToString(Report report) {
        return report.toString() + "\n" + specialization + ": " + getSurname() + " " + getName();
    }

    public void surgeonReportPrint(Report report) {
        System.out.println(reportToString(report));
    }
}
