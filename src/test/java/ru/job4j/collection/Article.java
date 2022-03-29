package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> originSet = new HashSet<>(Arrays.asList(origin.toLowerCase().replaceAll("[-+.^:,!]", "").split(" ")));
        Set<String> lineSet = new HashSet<>(Arrays.asList(line.toLowerCase().replaceAll("[-+.^:,!]", "").split(" ")));
        return originSet.containsAll(lineSet);
    }
}