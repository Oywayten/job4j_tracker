package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item newItem = new Item("Item");
        LocalDateTime localDateTime = newItem.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateAndTimeFormatted = localDateTime.format(formatter);
        System.out.println(currentDateAndTimeFormatted);
    }
}
