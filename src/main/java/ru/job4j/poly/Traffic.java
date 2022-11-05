package ru.job4j.poly;

public class Traffic {

    public static void main(String[] args) {
        Vehicle airplane1 = new Airplane("\"Boeing-1\"");
        airplane1.move();
        Vehicle airplane2 = new Airplane("\"Boeing-2\"");
        airplane2.move();
        Vehicle airplane3 = new Airplane("\"Boeing-3\"");
        airplane3.move();
        Vehicle railway1 = new Railway("\"Supsun-1\"");
        railway1.move();
        Vehicle railway2 = new Railway("\"Supsun-2\"");
        railway2.move();
        Vehicle railway3 = new Railway("\"Supsun-3\"");
        railway3.move();
        Vehicle bus1 = new Bus("Автобус-1");
        bus1.move();
        Vehicle bus2 = new Bus("Автобус-2");
        bus2.move();
        Vehicle bus3 = new Bus("Автобус-3");
        bus3.move();
        Vehicle[] vehicles = new Vehicle[]{airplane1, airplane2, airplane3,
            railway1, railway2, railway3, bus1, bus2, bus3};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
