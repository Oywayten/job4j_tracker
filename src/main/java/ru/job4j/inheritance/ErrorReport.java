package ru.job4j.inheritance;

import ru.job4j.oop.Error;

public class ErrorReport extends ru.job4j.oop.Error {
    private String report;

    public ErrorReport() {
    }

    public ErrorReport(boolean active, int status, String message, String report) {
        super(active, status, message);
        this.report = report;
    }

    public ErrorReport(Error error, String report) {
        super(error.isActive(), error.getStatus(), error.getMessage());
        this.report = report;
    }

    @Override
    public String toString() {
        return "Отчет об ошибке: \n"
                + "Ошибка: " + getMessage()
                + "\nСтатус: " + getStatus()
                + "\nАктивность: " + isActive()
                + "\n\nОтчет: "
                + report;
    }

    public void reportToPrint() {
        System.out.println(toString());
    }
}
