package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        return new LinkedHashMap<>(list.stream()
                .sorted(Comparator.comparing(Student::getSurname))
                .distinct()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                e -> e,
                                (ex, re) -> ex
                        )
                ));
    }
}