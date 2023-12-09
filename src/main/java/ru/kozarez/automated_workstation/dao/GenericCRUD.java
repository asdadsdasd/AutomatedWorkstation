package ru.kozarez.automated_workstation.dao;

import java.util.List;

public interface GenericCRUD <T, ID>{
    T getById(ID id);

    List<T> getAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
