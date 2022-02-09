package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup(2517);
        student.setEnterDate("01.09.2021");
        String ln = System.lineSeparator();
        System.out.println(
                "Студент: " + student.getFio() + ln
                + "Группа номер: " + student.getGroup() + ln
                + "Дата поступления: " + student.getEnterDate()
        );
    }
}
