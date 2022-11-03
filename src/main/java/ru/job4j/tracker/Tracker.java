package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Tracker() {
    }

    public Item[] getItems() {
        return items;
    }

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

    public Item[] findByName(String key) {
        Item[] rsl = Arrays.copyOf(items, size);
        int k = 0;
        for (int index = 0; index < size; index++) {
            Item item = rsl[index];
            if (item.getName().equals(key)) {
                rsl[k++] = item;
            }
        }
        return Arrays.copyOf(rsl, k);
    }

    public Item[] findAll() {
        Item[] rsl = Arrays.copyOf(items, size);
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        Item currentItem = items[index];
        currentItem.setName(item.getName());
        return  currentItem.getName() == item.getName();
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        int size = items.length;
        Item item = items[index];
        items[index] = null;
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[size - 1] = null;
        size--;
        return item.getId() != id;
    }
}