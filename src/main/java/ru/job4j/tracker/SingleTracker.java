package ru.job4j.tracker;

public class SingleTracker {

    private Tracker tracker = new Tracker();
    public static SingleTracker instance = null;
    private String[] messages = new String[1000];
    private int index = 0;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById() {
        return null;
    }

    public Item[] findByName() {
        return null;
    }

    public Item[] findAll() {
        return null;
    }

    public boolean delete() {
        return false;
    }

    public boolean replace() {
        return false;
    }
}
