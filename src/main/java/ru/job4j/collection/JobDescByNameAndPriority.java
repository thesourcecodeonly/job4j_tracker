package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByNameAndPriority implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        int result = o2.getName().compareTo(o1.getName());
        if (result == 0) {
            return Integer.compare(o2.getPriority(), o1.getPriority());
        }
        return result;
    }
}
