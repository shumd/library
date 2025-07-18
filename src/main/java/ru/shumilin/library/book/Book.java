package ru.shumilin.library.book;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private String description;
}
