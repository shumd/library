package ru.shumilin.library.book.repository;

import ru.shumilin.library.book.Book;
import ru.shumilin.library.genre.Genre;
import ru.shumilin.library.repository.Repository;


import java.util.List;

public interface BookRepository extends Repository<String, Book> {
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(Genre genre);
}
