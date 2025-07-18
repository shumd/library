package ru.shumilin.library.book.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BookEntity {
    private Long id;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private String description;
}
