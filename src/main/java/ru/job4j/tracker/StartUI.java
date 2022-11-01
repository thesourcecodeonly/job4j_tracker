package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        LocalDateTime item2 = item.getCreated();
        String currentDateTimeFormat = item2.now().format(formatter);
        System.out.println(currentDateTimeFormat);
    }
}
