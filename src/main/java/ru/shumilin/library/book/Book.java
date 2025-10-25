package ru.shumilin.library.book;

import ru.shumilin.library.genre.Genre;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int year;
    private final Genre genre;
    private boolean available = true;

    public Book(String isbn, String title, String author, int year, Genre genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void claim(){
        available = false;
    }

    public void release(){
        available = true;
    }
}
