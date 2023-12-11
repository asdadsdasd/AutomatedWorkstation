package ru.kozarez.automated_workstation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kozarez.automated_workstation.dao.ClientDAOImplementation;
import ru.kozarez.automated_workstation.dao.EmploymentDAOImplementation;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientDAOImplementation clientDAO;

    @Autowired
    private EmploymentDAOImplementation employmentDAO;

    @Transactional
    public ClientEntity getById(Long id){
        return clientDAO.getById(id);
    }

    @Transactional
    public List<ClientEntity> getAll(){
        return clientDAO.getAll();
    }

    @Transactional
    public void create(ClientEntity clientEntity){
        clientDAO.create(clientEntity);
    }
    @Transactional
    public void update(ClientEntity clientEntity){
        clientDAO.update(clientEntity);
    }

    @Transactional
    public void delete(ClientEntity clientEntity){
        clientDAO.delete(clientEntity);
    }
}
