package ru.shumilin.library.loan;

import java.time.LocalDate;

public class Loan {

    private final String id;
    private final String isbn;
    private final int readerId;
    private final LocalDate loanDate;
    private final LocalDate returnDate;

    public Loan(String isbn, int readerId, LocalDate loanDate, LocalDate returnDate) {
        this.isbn = isbn;
        this.readerId = readerId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        id = isbn + readerId;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getReaderId() {
        return readerId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
