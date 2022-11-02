package com.lauraverhoeven.mijnboekenapp;

public class Book {
    private final String title;
    private final String author;
    private final String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author
                + ", year=" + year + "]";
    }
}
