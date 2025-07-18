package ru.shumilin.library.book.model;

import lombok.Getter;

@Getter
public class BookModel {
    Long id;
    String title;
    String author;
    int year;
    String publisher;
    String genre;
    String description;
}
