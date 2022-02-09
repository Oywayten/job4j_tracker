package ru.job4j.inheritance;

public class Report {
    private String report;

    public Report(String report) {
        this.report = report;
    }

    public String reportToString(Diagnosis diagnosis) {
        return  diagnosis.toString() + "\nTreatment report: " + report;
    }
}
