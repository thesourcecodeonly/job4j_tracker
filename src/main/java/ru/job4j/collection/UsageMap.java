package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("javajunior@yandex.ru", "Ilya Petrovich Sergeev");
        map.put("javamiddle@yandex.ru", "Ivan Petrovich Sigeev");
        map.put("javasenior@yandex.ru", "Petr Sergeevich Arsentev");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
