package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobDescByPriorityTest {

    @Test
    public void sortedJobsByPriorityReverse() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("QA", 4),
                new Job("Backend", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("QA", 4),
                new Job("Backend", 2),
                new Job("Fix bug", 1),
                new Job("X task", 0)
        );
        assertThat(jobs).hasSameElementsAs(expected);
    }
}