package ru.job4j.collection;

public class Parentheses {
    public static boolean valid(char[] data) {
        int sum = 0;
        for (char datum : data) {
            if (sum < 0) {
                break;
            }
            if ('(' == datum) {
                sum++;
            } else {
                sum--;
            }
        }
        return sum == 0;
    }
}