package ru.shumilin.library.book.repository;

import org.springframework.stereotype.Repository;
import ru.shumilin.library.book.Book;

import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository implements ru.shumilin.library.repository.Repository<Long, Book> {
    private final static HashMap<Long, Book> BOOKS_MAP = new HashMap<>();

    @Override
    public Book findById(Long id) {
        return BOOKS_MAP.get(id);
    }

    @Override
    public List<Book> findAll() {
        return BOOKS_MAP.values().stream().toList();
    }

    @Override
    public void save(Book book) {
        BOOKS_MAP.put(book.getId(), book);
    }

    @Override
    public void delete(Book book) {
        BOOKS_MAP.remove(book.getId());
    }

    @Override
    public void deleteById(Long id) {
        BOOKS_MAP.remove(id);
    }

    @Override
    public void update(Book book) {
        BOOKS_MAP.put(book.getId(), book);
    }
}
