package ru.kozarez.automated_workstation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LoanApplicationDAOImplementation extends GenericDAOImplementation<LoanApplicationEntity, Long>{
    @Override
    public LoanApplicationEntity getById(Long id) {
        return getSession().get(LoanApplicationEntity.class, id);
    }

    @Override
    public List<LoanApplicationEntity> getAll() {
        return getSession().createQuery("from LoanApplicationEntity").list();
    }
}
