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

    private final Class<T> entityClass;

    public GenericDAOImplementation() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        this.entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public T findById(IDType id) {
        return getSession().get(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return getSession().createQuery("from " + entityClass.getSimpleName(), entityClass).list();
    }

    @Override
    public void create(T entity) {
        getSession().persist(entity);
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
