package ru.shumilin.library.repository;

import java.util.List;

public interface Repository <I,R>{
    R findById(I id);
    List<R> findAll();
    R save(R object);
    void delete(R object);
}
