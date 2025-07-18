package ru.shumilin.library.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.library.book.entity.BookEntity;
import ru.shumilin.library.book.model.BookModel;
import ru.shumilin.library.book.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public List<BookEntity> getBooks() {
        return service.findAll();
    }

    @PostMapping
    public void saveBook(@RequestBody BookModel model) {
        service.save(model);
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        service.deleteById(id);
    }

    @GetMapping("/search")
    public List<BookEntity> findByAuthorOrGenre(@RequestParam(required = false) String author,
                                                @RequestParam(required = false) String genre) {
        if(author != null){
            return service.findByAuthor(author);
        }else if(genre != null){
            return service.findByGenre(genre);
        }else {
            throw new IllegalArgumentException("You must specify at least one author or great genre");
        }
    }
}
