package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void whenSortRight() {
        List<Item> items = Arrays.asList(new Item("First"), new Item("Third"), new Item("Second"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("First"), new Item("Second"), new Item("Third"));
        Assert.assertEquals(items, expected);
    }
}