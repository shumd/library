package ru.shumilin.library.statistic;

public class Statistic {
    private final int booksByGenre;
    private final int reader;
    private final int loans;

    public Statistic(int booksByGenre, int reader, int loans) {
        this.booksByGenre = booksByGenre;
        this.reader = reader;
        this.loans = loans;
    }

    public int getBooksByGenre() {
        return booksByGenre;
    }

    public int getReader() {
        return reader;
    }

    public int getLoans() {
        return loans;
    }
}
