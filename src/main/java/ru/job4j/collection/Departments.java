package ru.job4j.collection;

import java.util.*;

/**
 * Класс добавляет пропущенные подразделения, а также производит сортировку подразделений
 */
public class Departments {

    /**
     * Метод формирует список строк, при этом учитывает все возможно отсутствующие коды подразделений;
     * @param deps список департаментов
     * @return возвращает список департаментов, в том числе и пропущенные департаменты
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += el;
                tmp.add(start);
                start += "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод сортирует по возрастанию список строк, который он принимает на вход
     * @param orgs список для сортировки
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод сортирует в соответствии с компаратором DepDescComp список строк, который он принимает на вход
     * @param orgs список для сортировки
     */
    public static void sortDesc(List<String> orgs) {
        DepDescComp comp = new DepDescComp();
        orgs.sort(comp);
    }
}