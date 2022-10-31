package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int c) {
        return sum(c) + minus(c) + multiply(c) + divide(c);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(15));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(20));
        System.out.println(calculator.divide(25));
        System.out.println(calculator.sumAllOperation(30));
    }
}
