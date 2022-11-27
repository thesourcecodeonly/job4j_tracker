package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {

    @Test
    public void sortedItemByName() {
        List<Item> items = Arrays.asList(
                new Item("Wayne"),
                new Item("Andrey"),
                new Item("John"),
                new Item("Boris")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Andrey"),
                new Item("Boris"),
                new Item("John"),
                new Item("Wayne")
        );
        assertThat(items).hasSameElementsAs(expected);
    }
}