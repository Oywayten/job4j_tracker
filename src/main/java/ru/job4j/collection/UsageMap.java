package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@ivan.ru", "Ivanov");
        for (String key : map.keySet()) {
            String val = map.get(key);
            System.out.println(key + " : " + val);
        }

    }
}
