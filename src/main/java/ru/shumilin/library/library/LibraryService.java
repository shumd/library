package ru.shumilin.library.library;

import ru.shumilin.library.book.Book;
import ru.shumilin.library.book.exception.BookUnavailableException;
import ru.shumilin.library.book.repository.BookRepository;
import ru.shumilin.library.book.repository.BookRepositoryImpl;
import ru.shumilin.library.genre.Genre;
import ru.shumilin.library.loan.Loan;
import ru.shumilin.library.loan.repository.LoanRepository;
import ru.shumilin.library.loan.repository.LoanRepositoryImpl;
import ru.shumilin.library.reader.Reader;
import ru.shumilin.library.reader.repository.ReaderRepository;
import ru.shumilin.library.reader.repository.ReaderRepositoryImpl;
import ru.shumilin.library.statistic.Statistic;

import java.time.LocalDate;
import java.util.List;

public class LibraryService {
    private final static LibraryService INSTANCE = new LibraryService();
    private final static ReaderRepository readerRepository = ReaderRepositoryImpl.getInstance();
    private final static BookRepository bookRepository = BookRepositoryImpl.getInstance();
    private final static LoanRepository loanRepository = LoanRepositoryImpl.getInstance();

    private LibraryService() {}
    public static LibraryService getInstance() {
        return INSTANCE;
    }

    public Book addBook(Book book) {
        if(bookRepository.findById(book.getIsbn()) != null) throw new IllegalArgumentException("Book already exists");
        return bookRepository.save(book);
    }

    public Reader registerReader(Reader reader) {
        return readerRepository.save(reader);
    }

    // Этот метод должен быть @Transactional
    public void lendBook(String isbn, int readerId) {
        Book book = bookRepository.findById(isbn);
        if(book.isAvailable()){
            Reader reader = readerRepository.findById(readerId);

            book.claim();
            reader.borrowBook(book.getIsbn());

            loanRepository.save(new Loan(isbn,
                    readerId,
                    LocalDate.now(),
                    LocalDate.now().plusMonths(1)));

            bookRepository.save(book);
            readerRepository.save(reader);
        }else throw new BookUnavailableException("Book "+ book.getTitle() +
                " is not available");
    }

    // Этот метод должен быть @Transactional
    public void returnBook(String isbn, int readerId) {
        Book book = bookRepository.findById(isbn);
        if(!book.isAvailable()){
            Reader reader = readerRepository.findById(readerId);
            book.release();
            reader.returnBook(isbn);

            loanRepository.delete(loanRepository.findById(isbn + readerId));
            bookRepository.save(book);
            readerRepository.save(reader);
        }else throw new IllegalArgumentException("Book already returned");
    }

    public List<Loan> getOverdueLoans(LocalDate today){
        return loanRepository.findAll().stream()
                .filter(loan -> today.isAfter(loan.getReturnDate().plusMonths(1)))
                .toList();
    }

    public Statistic getStatistic(Genre genre){
        return new Statistic(
                bookRepository.findByGenre(genre).size(),
                readerRepository.findAll().size(),
                loanRepository.findAll().size()
        );
    }
}