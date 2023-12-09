package ru.kozarez.automated_workstation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;

import java.util.List;

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
}
