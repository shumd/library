package ru.shumilin.library.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.shumilin.library.book.Book;
import ru.shumilin.library.book.repository.BookRepository;
import ru.shumilin.library.book.repository.BookRepositoryImpl;
import ru.shumilin.library.genre.Genre;
import ru.shumilin.library.reader.Reader;
import ru.shumilin.library.reader.repository.ReaderRepository;
import ru.shumilin.library.reader.repository.ReaderRepositoryImpl;

public class LibraryServiceTest {
    private final LibraryService libraryService = LibraryService.getInstance();
    private final BookRepository bookRepository = BookRepositoryImpl.getInstance();
    private final ReaderRepository readerRepository = ReaderRepositoryImpl.getInstance();

    @Test
    void correct_add_addBookTest(){
        Book book = new Book("test","title","author",2020, Genre.FANTASY);
        libraryService.addBook(book);
        Assertions.assertEquals("test", bookRepository.findById("test").getIsbn());
        bookRepository.delete(book);
    }

    @Test
    void unique_isbn_addBookTest(){
        Book book = new Book("test","title","author",2020, Genre.FANTASY);
        libraryService.addBook(book);
        Book book2 = new Book("test","title","author",2020, Genre.FANTASY);
        Assertions.assertThrows(IllegalArgumentException.class, ()->libraryService.addBook(book2));
        bookRepository.delete(book);
        bookRepository.delete(book2);
    }

    @Test
    void registerReaderTest(){
        Reader reader = new Reader("test","test", 1);
        libraryService.registerReader(reader);
        Assertions.assertEquals(1, readerRepository.findById(1).getId());
        readerRepository.delete(reader);
    }

    @Test
    void returnBookTest(){
        Book book = new Book("test","title","author",2020, Genre.FANTASY);
        bookRepository.save(book);
        Reader reader = new Reader("test","test", 1);
        readerRepository.save(reader);
        libraryService.lendBook("test", 1);
        libraryService.returnBook("test", 1);
        Assertions.assertTrue(bookRepository.findById("test").isAvailable());
        readerRepository.delete(reader);
        bookRepository.delete(book);
    }
}
