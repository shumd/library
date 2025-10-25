package ru.shumilin.library.book.repository;

import ru.shumilin.library.book.Book;
import ru.shumilin.library.genre.Genre;

import java.util.HashMap;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final static BookRepository INSTANCE = new BookRepositoryImpl();
    private static HashMap<String, Book> books;

    private BookRepositoryImpl() {
        books = new HashMap<>();
    }

    public static BookRepository getInstance() {return INSTANCE;}

    @Override
    public List<Book> findByAuthor(String author) {
        return books.values().stream().filter(b -> b.getAuthor().equals(author)).toList();
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        return books.values().stream().filter(b -> b.getGenre().equals(genre)).toList();
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return books.values().stream().toList();
    }

    @Override
    public Book save(Book object) {
        return books.put(object.getIsbn(), object);
    }

    @Override
    public void delete(Book object) {
        books.remove(object.getIsbn());
    }
}
