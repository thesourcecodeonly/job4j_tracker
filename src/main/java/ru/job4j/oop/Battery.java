package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery batteryFirst = new Battery(50);
        Battery batterySecond = new Battery(30);
        System.out.println("batteryFirst: " + batteryFirst.load + ". batterySecond: "
                + batterySecond.load);
        batterySecond.exchange(batteryFirst);
        System.out.println("batteryFirst: " + batteryFirst.load + ". batterySecond: "
                + batterySecond.load);
    }
}
