package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, str) -> map.put(i, str);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = (i, str) -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            System.out.println("key: " + i + " value: " + map.get(i));
        }

        Supplier<List<String>> sup = () -> {
            ArrayList<String> list = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
            return list;
        };
        List<String> strings = new ArrayList<>(map.values());

        Consumer<String> con = s -> System.out.println(s);
        Function<String, String> func = v -> String.valueOf(v.toUpperCase());
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
