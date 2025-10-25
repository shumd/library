package ru.shumilin.library.loan.repository;

import ru.shumilin.library.loan.Loan;

import java.util.HashMap;
import java.util.List;

public class LoanRepositoryImpl implements LoanRepository {
    private static final LoanRepository INSTANCE = new LoanRepositoryImpl();
    private final HashMap<String, Loan> loans;

    private LoanRepositoryImpl() {loans = new HashMap<>();}
    public static LoanRepository getInstance() {return INSTANCE;}

    @Override
    public Loan findById(String id) {
        return loans.get(id);
    }

    @Override
    public List<Loan> findAll() {
        return loans.values().stream().toList();
    }

    @Override
    public Loan save(Loan object) {
        return loans.put(object.getId(), object);
    }

    @Override
    public void delete(Loan object) {
        loans.remove(object.getId());
    }
}
