package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = Math.min(left.length(), right.length());
        int dif = 0;
        for (int i = 0; i < length; i++) {
            dif = Character.compare(left.charAt(i), right.charAt(i));
            if (dif != 0) {
                break;
            }
        }
        if (dif == 0) {
            dif = Integer.compare(left.length(), right.length());
        }
        return dif;
    }
}