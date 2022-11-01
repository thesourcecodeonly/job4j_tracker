package ru.job4j.pojo;

public class Book {

    private String bookName;
    private int bookCountPages;

    public Book(String bookName, int bookCountPages) {
        this.bookName = bookName;
        this.bookCountPages = bookCountPages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCountPages() {
        return bookCountPages;
    }

    public void setBookCountPages(int bookCountPages) {
        this.bookCountPages = bookCountPages;
    }
}
