package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialization;

    public Surgeon(String name, String surname, String education, String birthday, String category, String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "About doctor: " + System.lineSeparator()
                + "Doctor: " + getName() + " " + getSurname() + System.lineSeparator()
                + "Category: " + category + System.lineSeparator()
                + "Specialization: " + specialization + System.lineSeparator();
    }

    public String reportToString(Report report, Diagnosis diagnosis) {
        return report.reportToString(diagnosis) + System.lineSeparator() + "Doctor " + getName() + " " + getSurname()
                + System.lineSeparator() + specialization;
    }

    public void surgeonReportPrint(Report report, Diagnosis diagnosis) {
        System.out.println(reportToString(report, diagnosis));
    }

    public static void main(String[] args) {
        Surgeon andrew = new Surgeon("Andrew", "Andreev", "High", "01.01.2021",
                "High", "Hernia's surgeon");
        Diagnosis heal = andrew.heal("Ivan", 25, "Hernia");
        System.out.println(andrew.toString());
        andrew.surgeonReportPrint(new Report("Just now - all right!"), heal);
    }
}
