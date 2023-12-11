package ru.kozarez.automated_workstation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kozarez.automated_workstation.dao.ClientDAOImplementation;
import ru.kozarez.automated_workstation.dao.EmploymentDAOImplementation;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;

import java.util.List;

@Service
public class EmploymentService {
    @Autowired
    private EmploymentDAOImplementation employmentDAO;

    @Transactional
    public EmploymentEntity getById(Long id){
        return employmentDAO.getById(id);
    }

    @Transactional
    public List<EmploymentEntity> getAll(){
        return employmentDAO.getAll();
    }

    @Transactional
    public void create(EmploymentEntity employmentEntity){
        employmentDAO.create(employmentEntity);
    }

    @Transactional
    public void update(EmploymentEntity employmentEntity){
        employmentDAO.update(employmentEntity);
    }

    @Transactional
    public void delete(EmploymentEntity employmentEntity){
        employmentDAO.delete(employmentEntity);
    }

    @Transactional
    public List<EmploymentEntity> getByClientId(Long id){
        return employmentDAO.getByClientId(id);
    }
}
