package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам.
 */
public class Analyze {

    /**
     * Метод averageScore вычисляет общий средний балл
     * @param stream поток учеников
     * @return возвращает средний бал
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToDouble(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     * @param stream поток учеников
     * @return возвращает список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        averageScore(Stream.of(pupil)))
                )
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream поток учеников
     * @return возвращает список из объекта Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore))
                )
                .entrySet()
                .stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue())
                )
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream поток учеников
     * @return возвращает лучшего ученика - объект Tuple (имя ученика, его наивысший бал).
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(
                pupil.getName(),
                        pupil.getSubjects().stream()
                                .mapToDouble(Subject::getScore)
                                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream поток учеников
     * @return возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore))
                )
                .entrySet()
                .stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue())
                )
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}