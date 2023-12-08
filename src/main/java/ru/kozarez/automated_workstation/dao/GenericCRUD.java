package ru.kozarez.automated_workstation.dao;

import java.util.List;

public interface GenericCRUD <T, ID>{
    T findById(ID id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
