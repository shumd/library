package ru.shumilin.library.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.library.book.entity.BookEntity;
import ru.shumilin.library.book.model.BookModel;
import ru.shumilin.library.book.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public void save(BookModel model) {
        BookEntity book = BookEntity.builder()
                .author(model.getAuthor())
                .title(model.getTitle())
                .id(model.getId())
                .description(model.getDescription())
                .genre(model.getGenre())
                .publisher(model.getPublisher())
                .year(model.getYear())
                .build();

        System.out.println(book);
        bookRepository.save(book);
    }

    public BookEntity findById(long id) {
        return bookRepository.findById(id);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<BookEntity> findByAuthor(String author) {
        return findAll().stream().filter(b -> b.getAuthor().equals(author)).toList();
    }

    public List<BookEntity> findByGenre(String genre) {
        return findAll().stream().filter(b -> b.getGenre().equals(genre)).toList();
    }
}
