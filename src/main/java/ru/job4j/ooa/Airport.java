package ru.job4j.ooa;

public class Airport {

    public static void main(String[] args) {
        Airbus airbus = new Airbus("A380");
        int count = "A380".equals(airbus.getName()) ? 4 : 2;
        System.out.println("Количество двигателей равно: " + count);
    }
}
