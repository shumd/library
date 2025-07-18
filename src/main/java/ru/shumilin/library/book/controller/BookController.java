package ru.shumilin.library.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.library.book.Book;
import ru.shumilin.library.book.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public List<Book> getBooks() {
        return service.findAll();
    }

    @PostMapping
    public void saveBook(Book entity) {
        service.save(entity);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        service.deleteById(id);
    }

    @GetMapping("/search")
    public List<Book> findByAuthor(@RequestParam String author) {
        return service.findByAuthor(author);
    }

    @GetMapping("/search")
    public List<Book> findByGenre(@RequestParam String genre) {
        return service.findByGenre(genre);
    }
}
