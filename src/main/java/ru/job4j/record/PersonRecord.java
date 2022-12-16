package ru.job4j.record;

/**
 * Created by Oywayten on 16.12.2022.
 */
public record PersonRecord(String name, int age) {
   private static final int MAX_AGE = 100;

    public static int getMaxAge() {
        return MAX_AGE;
    }
}

class RecordMain {
    public static void main(String[] args) {
        PersonRecord person = new PersonRecord("Ivan", 29);
        System.out.println(PersonRecord.getMaxAge());
        System.out.println(person);
    }
}