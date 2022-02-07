package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(5);
        System.out.println("First load " + first.load + ";\nSecond load " + second.load + ";");
        first.exchange(second);
        System.out.println("First load " + first.load + ";\nSecond load " + second.load + ";");
    }
}
