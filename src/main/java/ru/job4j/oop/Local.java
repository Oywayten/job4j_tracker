package ru.job4j.oop;

/**
 * Created by Oywayten on 16.12.2022.
 */
public class Local {
    private String name = "Petr";

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();
        Local local1 = new Local() {
            public void getFullName() {
                System.out.println("Hello from Anonimus");
            }

            public void getName() {
                System.out.println("Hello from anonim class");
            }
        };
        local1.getFullName();
    }

    public void getFullName() {
        String surname = "Arsentev";

        class FullName {
            public static String testString = "test";

            public void printFullName() {
                testString += "one more";
                System.out.println(name + " " + surname);
            }
        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }
}
