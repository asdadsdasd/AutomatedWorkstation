package ru.kozarez.automated_workstation.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;

import java.util.List;

@Repository
public class ClientDAOImplementation extends GenericDAOImplementation<ClientEntity, Long>{
    @Override
    public ClientEntity getById(Long id) {
        return getSession().get(ClientEntity.class, id);
    }

    @Override
    public List<ClientEntity> getAll() {
        return getSession().createQuery("from ClientEntity").list();
    }
}
