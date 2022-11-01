package ru.job4j.pojo;

public class College extends Student {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Petrov Ivan Sidorovich");
        student.setGroupNumber(3);
        student.setDateIn("01.09.2022");
        System.out.print("Student :" + student.getFullName() + System.lineSeparator()
                + "The group is number: " + student.getGroupNumber() + System.lineSeparator()
                + "The date of admission to college: " + student.getDateIn());
    }
}
