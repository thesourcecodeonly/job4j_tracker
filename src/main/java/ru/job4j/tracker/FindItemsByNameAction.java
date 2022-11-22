package ru.job4j.tracker;

import java.util.ArrayList;

public class FindItemsByNameAction implements UserAction {

    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String msg = input.askStr("Enter name: ");
        ArrayList<Item> items = tracker.findByName(msg);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + msg + " не найдены.");
        }
        return true;
    }
}
