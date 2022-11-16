package ru.job4j.ooa;

public final class Airbus extends Aircraft {

    private int countEngine = 2;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountEngine() {
        return countEngine;
    }

    public void setCountEngine(int countEngine) {
        this.countEngine = countEngine;
    }

    public void printCountEngine() {
        System.out.println("Количество двигателей равно: " + countEngine);
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
