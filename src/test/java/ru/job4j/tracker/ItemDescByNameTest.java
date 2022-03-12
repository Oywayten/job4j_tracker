package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenSortRevers() {
        List<Item> items = Arrays.asList(new Item("First"), new Item("Third"), new Item("Second"));
        items.sort(new ItemDescByName().reversed());
        List<Item> expected = Arrays.asList(new Item("Third"), new Item("Second"), new Item("First"));
        Assert.assertEquals(items, expected);
    }
}