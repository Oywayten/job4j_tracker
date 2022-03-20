package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        Supplier<List<Folder>> sup = ArrayList::new;
        List<Folder> rsl = sup.get();
        Consumer<Folder> cons = folder -> {
            if (pred.test(folder)) {
                rsl.add(folder);
            }
        };
        list.forEach(cons);
        return rsl;
    }
}