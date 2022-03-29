package ru.job4j.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OptionalFlatMap {
    public static Optional<Integer> flatMap(List<String> strings) {
        return strings.stream()
                .filter(s -> s.endsWith(".java"))
                .flatMap(s -> Optional.of(s).stream())
                .map(s -> Optional.of(s.length())).findAny().orElse(Optional.empty());
    }
}