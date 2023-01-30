package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {

    @Test
    public void whenSortRight() {
        List<Item> items = Arrays.asList(new Item("First"), new Item("Third"), new Item("Second"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("First"), new Item("Second"), new Item("Third"));
        assertThat(items).isEqualTo(expected);
    }
}