package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс реализует сравнение в соответствии с описанием:
 * Сортировка имеет сложный вид.
 * Первые элементы сравниваются по убыванию, если они равны,
 * то последующие элементы сравниваются в возрастающем порядке.
 */
public class DepDescComp implements Comparator<String> {

    /**
     * Метод сравнивает 2 строки
     * @param o1 первая строка для сравнения
     * @param o2 вторая строка для сравнения
     * @return целочисленный результат сравнения типа int
     */
    @Override
    public int compare(String o1, String o2) {
        int dif = o2.substring(0, 2).compareTo(o1.substring(0, 2));
        if (dif == 0) {
            dif = o1.compareTo(o2);
        }
        return dif;
    }
}
