package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if ((index == -1) || (item == null)) {
            return false;
        }
        items[index].setName(item.getName());
        return item.getName().equals(items[index].getName());
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items[index] = null;
        System.arraycopy(items, id, items, id - 1, items.length - id - 1);
        size--;
        return true;
    }

        public Item[] findAll() {
            Item[] all = new Item[items.length];
            size = 0;
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    all[size] = items[i];
                    size++;
                }
            }
            all = Arrays.copyOf(all, size);
            return all;
        }

        public Item[] findByName(String key) {
            Item[] all = new Item[items.length];
            size = 0;
            for (int i = 0; i < items.length; i++) {
                if ((items[i] != null) && (key.equals(items[i].getName()))) {
                    all[size] = items[i];
                    size++;
                }
            }
            all = Arrays.copyOf(all, size);
            return all;
        }
}