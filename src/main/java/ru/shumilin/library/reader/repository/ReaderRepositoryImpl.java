package ru.shumilin.library.reader.repository;

import ru.shumilin.library.reader.Reader;

import java.util.HashMap;
import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
    private final static ReaderRepository INSTANCE = new ReaderRepositoryImpl();
    private final HashMap<Integer, Reader> readers;

    private ReaderRepositoryImpl() {readers = new HashMap<>();}
    public static ReaderRepository getInstance() {return INSTANCE;}

    @Override
    public Reader findById(Integer id) {
        return readers.get(id);
    }

    @Override
    public List<Reader> findAll() {
        return readers.values().stream().toList();
    }

    @Override
    public Reader save(Reader object) {
        return readers.put(object.getId(), object);
    }

    @Override
    public void delete(Reader object) {
        readers.remove(object.getId());
    }
}
