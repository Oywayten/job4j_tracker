package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return "{" + ln + ("\"name\" : \"" + name + "\",").indent(4)
                + "\t\"body\" : \"" + body + "\"" + ln
                + "}";
    }
}
