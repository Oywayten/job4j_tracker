package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            int matches;
            do {
            System.out.println(player + " введите число от 1 до 3:");
            if (count < 3) {
                System.out.println("Но не больше " + count);
            }
            matches = Integer.parseInt(input.nextLine());
            }
            while (matches < 1 || matches > 3 || matches > count);
            turn = !turn;
            count -= matches;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}