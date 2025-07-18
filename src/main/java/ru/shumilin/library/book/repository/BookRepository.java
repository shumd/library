package ru.shumilin.library.book.repository;

import org.springframework.stereotype.Repository;
import ru.shumilin.library.book.entity.BookEntity;

import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository implements ru.shumilin.library.repository.Repository<Long, BookEntity> {
    private final static HashMap<Long, BookEntity> BOOKS_MAP = new HashMap<>();

    @Override
    public BookEntity findById(Long id) {
        return BOOKS_MAP.get(id);
    }

    @Override
    public List<BookEntity> findAll() {
        return BOOKS_MAP.values().stream().toList();
    }

    @Override
    public void save(BookEntity bookEntity) {
        BOOKS_MAP.put(bookEntity.getId(), bookEntity);
    }

    @Override
    public void delete(BookEntity bookEntity) {
        BOOKS_MAP.remove(bookEntity.getId());
    }

    @Override
    public void deleteById(Long id) {
        BOOKS_MAP.remove(id);
    }

    @Override
    public void update(BookEntity bookEntity) {
        BOOKS_MAP.put(bookEntity.getId(), bookEntity);
    }
}
