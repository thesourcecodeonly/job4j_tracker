package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String rsl = strings
                .stream()
                .skip(3)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(rsl);
    }
}
