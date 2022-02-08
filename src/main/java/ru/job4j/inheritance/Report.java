package ru.job4j.inheritance;

public class Report extends Diagnosis {
    private String report;

    public Report() {
    }

    public Report(Diagnosis diagnosis, String report) {
        super(diagnosis.getName(), diagnosis.getAge(), diagnosis.getDiagnosis());
        this.report = report;
    }

    public Report(String name, int age, String diagnosis, String report) {
        super(name, age, diagnosis);
        this.report = report;
    }

    @Override
    public String toString() {
        return super.toString() + "\nОтчёт о лечении: " + report;
    }
}
