package ru.job4j.map;

import java.util.*;

/**
 * Класс AnalyzeByMap получает статистику по аттестатам.
 */
public class AnalyzeByMap {
    /**
     * вычисляет общий средний балл
     *
     * @param pupils школьники
     * @return средний бал
     */
    public static double averageScore(List<Pupil> pupils) {
        int elemCount = 0;
        int score = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                score += s.score();
                elemCount++;
            }
        }
        return (double) score / elemCount;
    }

    /**
     * вычисляет средний балл по каждому ученику.
     * То есть берем одного ученика и считаем все его баллы за все предметы и делим на количество предметов.
     *
     * @param pupils школьники
     * @return Возвращает список из объекта Label (имя ученика и средний балл).
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        for (Pupil p : pupils) {
            int elemCount = 0;
            int score = 0;
            for (Subject s : p.subjects()) {
                score += s.score();
                elemCount++;
            }
            double average = (double) score / elemCount;
            result.add(new Label(p.name(), average));
        }
        return result;
    }

    /**
     * вычисляет средний балл по каждому предмету.
     * Например, собираем все баллы учеников по предмету география и делим на количество учеников.
     *
     * @param pupils школьники
     * @return Возвращает список из объектов Label (название предмета и средний балл).
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        Map<String, Integer> tmp = new LinkedHashMap<>();
        int elemCount = 0;
        for (Pupil p : pupils) {
            elemCount++;
            for (Subject s : p.subjects()) {
                tmp.computeIfPresent(s.name(), (s1, integer) -> integer + s.score());
                tmp.putIfAbsent(s.name(), s.score());
            }
        }
        for (Map.Entry<String, Integer> m : tmp.entrySet()) {
            double average = (double) m.getValue() / elemCount;
            result.add(new Label(m.getKey(), average));
        }
        return result;
    }

    /**
     * возвращает лучшего ученика. Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     *
     * @param pupils ученики
     * @return Возвращает объект Label (имя ученика и суммарный балл).
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        for (Pupil p : pupils) {
            int score = 0;
            for (Subject s : p.subjects()) {
                score += s.score();
            }
            result.add(new Label(p.name(), score));
        }
        Comparator<Label> comparator = Comparator.naturalOrder();
        result.sort(comparator);
        return result.get(result.size() - 1);
    }

    /**
     * возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param pupils ученики
     * @return Возвращает объект Label (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        Map<String, Integer> tmp = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                tmp.computeIfPresent(s.name(), (s1, integer) -> integer + s.score());
                tmp.putIfAbsent(s.name(), s.score());
            }
        }
        for (Map.Entry<String, Integer> m : tmp.entrySet()) {
            result.add(new Label(m.getKey(), m.getValue()));
        }
        Comparator<Label> comparator = Comparator.naturalOrder();
        result.sort(comparator);
        return result.get(result.size() - 1);
    }
}