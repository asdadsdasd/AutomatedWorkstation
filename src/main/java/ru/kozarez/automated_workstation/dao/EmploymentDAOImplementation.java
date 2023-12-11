package ru.kozarez.automated_workstation.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;

import java.util.List;
import java.util.Queue;

@Repository
public class EmploymentDAOImplementation extends GenericDAOImplementation<EmploymentEntity, Long>{
    @Override
    public EmploymentEntity getById(Long id) {
        return getSession().get(EmploymentEntity.class, id);
    }

    @Override
    public List<EmploymentEntity> getAll() {
        return getSession().createQuery("from EmploymentEntity").list();
    }

    public List<EmploymentEntity> getByClientId(Long clientId) {
        return getSession().createQuery("from EmploymentEntity where client.id = :client_id", EmploymentEntity.class).setParameter("client_id", clientId).getResultList();
    }
}
