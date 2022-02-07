package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String  message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность " + active);
        System.out.println("Статус " + status);
        System.out.println("Сообщение " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error crash = new Error();
        Error alarm = new Error(true, 25, "Whatta hell?!");
        Error info = new Error(false, 1, "This is just info");
        Error blocker = new Error(true, 50, "Interdiction d'accès");
        crash.printInfo();
        alarm.printInfo();
        info.printInfo();
        blocker.printInfo();
    }
}
