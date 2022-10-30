package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Are there any errors? " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(false, 0, "There are no errors.");
        Error error2 = new Error(true, 2, "There are 2 errors.");
        Error error3 = new Error(true, 1, "There are 1 error.");
        error.printInfo();
        System.out.println("============");
        error1.printInfo();
        System.out.println("============");
        error2.printInfo();
        System.out.println("============");
        error3.printInfo();
    }
}
