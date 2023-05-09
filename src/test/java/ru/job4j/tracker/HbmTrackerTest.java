package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.util.HbmUtil;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HbmTrackerTest {

    @BeforeEach
    public void clearTracker() {
        HbmUtil.clearDataBase();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item newItem = new Item();
            newItem.setName("test1");
            tracker.add(newItem);
            Integer newItemId = newItem.getId();
            Item actualItem = tracker.findById(newItemId);
            String expectedItemName = newItem.getName();
            String actualItemName = actualItem.getName();
            assertThat(actualItemName).isEqualTo(expectedItemName);
        }
    }

    @Test
    public void whenFindAllThenFindAllIsItem1Item2Item3() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item1 = new Item("Item 1");
            Item item2 = new Item("Item 2");
            Item item3 = new Item("Item 3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> expectedItems = List.of(item1, item2, item3);
            List<Item> actualItems = tracker.findAll();
            assertThat(actualItems).usingRecursiveFieldByFieldElementComparatorIgnoringFields("created").isEqualTo(expectedItems);
        }
    }

    @Test
    public void whenFindByNameFirstThenListLengthIs3() {
        try (HbmTracker tracker = new HbmTracker()) {
            String firstName = "First";
            String secondName = "Second";
            tracker.add(new Item(firstName));
            tracker.add(new Item(secondName));
            tracker.add(new Item(firstName));
            tracker.add(new Item(secondName));
            tracker.add(new Item(firstName));
            List<Item> actualItems = tracker.findByName(firstName);
            int expectedItemsSize = 3;
            assertThat(actualItems.size()).isEqualTo(expectedItemsSize);
        }
    }

    @Test
    public void whenAddFewItemsWithNamesFirstAndSecondThenFindByNameSecondItemsIsListWithSecondSecond() {
        try (HbmTracker tracker = new HbmTracker()) {
            String firstName = "First";
            String secondName = "Second";
            tracker.add(new Item(firstName));
            tracker.add(new Item(secondName));
            tracker.add(new Item(firstName));
            tracker.add(new Item(secondName));
            tracker.add(new Item(firstName));
            List<Item> items = tracker.findByName(secondName);
            List<String> itemsNames = new ArrayList<>();
            for (Item item : items) {
                itemsNames.add(item.getName());
            }
            assertThat(itemsNames).containsExactly(secondName, secondName);
        }
    }

    @Test
    public void whenReplaceBaseItemThenNewItemInTracker() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item baseItem = new Item();
            baseItem.setName("base item");
            tracker.add(baseItem);
            Item newItem = new Item();
            newItem.setName("new item");
            int baseItemId = baseItem.getId();
            tracker.replace(baseItemId, newItem);
            Item actualItemById = tracker.findById(baseItemId);
            assertThat(actualItemById.getName()).isEqualTo(newItem.getName());
        }
    }

    @Test
    public void whenDeleteThenFindByIdIsNull() {
        try (HbmTracker tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("item");
            tracker.add(item);
            Integer id = item.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
        }
    }
}