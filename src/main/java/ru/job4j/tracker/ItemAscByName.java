package ru.job4j.tracker;

import ru.job4j.bank.User;

import java.util.Comparator;
import java.util.Objects;

public class ItemAscByName implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
