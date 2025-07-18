package ru.shumilin.library.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.library.book.Book;
import ru.shumilin.library.book.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book entity) {
        bookRepository.save(entity);
    }

    public Book findById(long id) {
        return bookRepository.findById(id);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByAuthor(String author) {
        return findAll().stream().filter(b -> b.getAuthor().equals(author)).toList();
    }

    public List<Book> findByGenre(String genre) {
        return findAll().stream().filter(b -> b.getGenre().equals(genre)).toList();
    }
}
