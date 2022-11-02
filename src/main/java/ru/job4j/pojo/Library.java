package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {

        Book book1 = new Book("Clean code", 464);
        Book book2 = new Book("11/22/63", 925);
        Book book3 = new Book("The Fird level", 542);
        Book book4 = new Book("Discrete Mathematics for computing", 452);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("=========================");
        books[0] = book4;
        books[3] = book1;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("=========================");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}
