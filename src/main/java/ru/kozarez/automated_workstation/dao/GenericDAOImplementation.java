package ru.kozarez.automated_workstation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public abstract class GenericDAOImplementation<T, IDType> implements GenericCRUD<T, IDType>{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        try {
            return sessionFactory.getCurrentSession();
        }catch (Exception e){
            String err = e.getMessage();
            System.out.println("message: " + err);
        }
        return null;
    }
    @Override
    abstract public T getById(IDType id);

    @Override
    abstract public List<T> getAll();
    @Override
    public void create(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }
}
