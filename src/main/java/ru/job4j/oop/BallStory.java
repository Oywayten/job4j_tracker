package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball coloboc = new Ball();
        Hare belyak = new Hare();
        Wolf blackWolf = new Wolf();
        Fox redFox = new Fox();
        belyak.tryEat(coloboc);
        blackWolf.tryEat(coloboc);
        redFox.tryEat(coloboc);
    }
}
