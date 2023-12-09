package ru.kozarez.automated_workstation.dao;

import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;

import java.util.List;

@Repository
public class LoanContractDAOImplementation extends GenericDAOImplementation<LoanContractEntity, Long> {
    @Override
    public LoanContractEntity getById(Long id) {
        return getSession().get(LoanContractEntity.class, id);
    }

    @Override
    public List<LoanContractEntity> getAll() {
        return getSession().createQuery("from LoanContractEntity").list();
    }
}
