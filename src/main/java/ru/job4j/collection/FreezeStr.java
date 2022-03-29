package ru.job4j.collection;

import java.util.function.Function;
import java.util.stream.Collectors;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        return right.chars().mapToObj(value -> (char) value)
                .collect(
                        Collectors.groupingBy(Function.identity(),
                                Collectors.counting())).equals(left.chars().mapToObj(value -> (char) value)
                        .collect(
                                Collectors.groupingBy(Function.identity(),
                                        Collectors.counting())));
    }
}