package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {

    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public static LocalDateTime now() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}