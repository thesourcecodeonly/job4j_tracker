package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix", 4),
                new Job("Fixbug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscByName().thenComparing(new JobDescByNameLn()));
        System.out.println(jobs);
    }
}
