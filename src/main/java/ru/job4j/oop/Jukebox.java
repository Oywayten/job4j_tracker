package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже пешеходы по лужам, а вода по асфальту рекой...");
        } else if (position == 2) {
            System.out.println("Спят усталые ребя, книжки спят... Одеяла и подушки ждут ребят...");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox bigBen = new Jukebox();
        bigBen.music(1);
        bigBen.music(2);
        bigBen.music(3);
        bigBen.music(4);
    }
}
