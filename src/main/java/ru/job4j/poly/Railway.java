package ru.job4j.poly;

public class Railway implements Vehicle {
    private String name;

    public Railway(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " едет по рельсам.");
    }
}
