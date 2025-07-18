package ru.shumilin.library.repository;

import java.util.List;

public interface Repository<I,T> {
    T findById(I id);
    List<T> findAll();
    void save(T t);
    void delete(T t);
    void deleteById(I id);
    void update(T t);
}
