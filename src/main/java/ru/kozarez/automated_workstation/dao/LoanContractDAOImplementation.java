package ru.kozarez.automated_workstation.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;
import ru.kozarez.automated_workstation.entities.enums.LoanContractStatus;

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

    public List<LoanContractEntity> getByLoanContractStatus(LoanContractStatus loanContractStatus){
        Query query = getSession().createQuery("from LoanContractEntity where loanContractStatus = :loanContractStatus");
        query.setParameter("loanContractStatus", loanContractStatus);
        return query.list();
    }
}
