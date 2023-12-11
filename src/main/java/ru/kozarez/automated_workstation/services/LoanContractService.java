package ru.kozarez.automated_workstation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kozarez.automated_workstation.dao.LoanContractDAOImplementation;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanContractStatus;

import java.util.Date;
import java.util.List;

@Service
public class LoanContractService {
    @Autowired
    private LoanContractDAOImplementation loanContractDAO;

    @Transactional
    public LoanContractEntity getById(Long id) {
        return loanContractDAO.getById(id);
    }

    @Transactional
    public List<LoanContractEntity> getAll() {
        return loanContractDAO.getAll();
    }

    @Transactional
    public void create(LoanContractEntity loanContract) {
        loanContractDAO.create(loanContract);
    }

    @Transactional
    public void update(LoanContractEntity loanContract) {
        loanContractDAO.update(loanContract);
    }

    @Transactional
    public void delete(LoanContractEntity loanContract) {
        loanContractDAO.delete(loanContract);
    }

    @Transactional
    public void signContract(LoanContractEntity loanContract, boolean flag){
        if (flag) {
            loanContract.setLoanContractStatus(LoanContractStatus.SIGNED);
        }else {
            loanContract.setLoanContractStatus(LoanContractStatus.NOT_SIGNED);
        }
        loanContract.setSigningDate(new Date(System.currentTimeMillis()));
        loanContractDAO.update(loanContract);
    }

    @Transactional
    public List<LoanContractEntity> getByLoanContractStatus(String status){
        if(status.equals("SIGNED")){
            return loanContractDAO.getByLoanContractStatus(LoanContractStatus.SIGNED);
        }
        return loanContractDAO.getByLoanContractStatus(LoanContractStatus.NOT_SIGNED);
    }
}