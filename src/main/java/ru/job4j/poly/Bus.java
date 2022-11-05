package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    private String name;

    public Bus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " едет по дороге.");
    }

    @Override
    public void drive() {
        System.out.println("Let is drive");
    }

    @Override
    public void passengers(int count) {
        System.out.println("In the bus is " + count + " passengers");
    }

    @Override
    public double refuel(double countFuel) {
        double price = 40.5;
        return countFuel * price;
    }
}
