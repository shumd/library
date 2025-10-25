package ru.shumilin.library.reader;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private final int id;
    private final String name;
    private final String phone;
    private final List<String> borrowedBooks;

    public Reader(String phone, String name, int id) {
        this.phone = phone;
        this.name = name;
        this.id = id;
        borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }
}
