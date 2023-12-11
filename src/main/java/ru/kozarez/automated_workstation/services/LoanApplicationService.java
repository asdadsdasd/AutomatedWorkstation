package ru.kozarez.automated_workstation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kozarez.automated_workstation.dao.*;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;

import java.util.List;
import java.util.Random;

@Service
public class LoanApplicationService {

    @Autowired
    private LoanApplicationDAOImplementation loanApplicationDAO;

    @Autowired
    private ClientDAOImplementation clientDAO;

    @Autowired
    private EmploymentDAOImplementation employmentDAO;

    @Autowired
    private LoanContractDAOImplementation loanContractDAO;
    @Transactional
    public LoanApplicationEntity getById(Long id){
        return loanApplicationDAO.getById(id);
    }

    @Transactional
    public List<LoanApplicationEntity> getAll(){
        return loanApplicationDAO.getAll();
    }

    @Transactional
    public void create(LoanApplicationEntity loanApplication){
        loanApplicationDAO.create(loanApplication);
    }

    @Transactional
    public LoanApplicationEntity createWithForm(LoanApplicationForm form){
        List<ClientEntity> clientByPassport = clientDAO.getByPassport(form.getPassportSerial(), form.getPassportNumber());

        ClientEntity client;

        if (clientByPassport.isEmpty()) {
            client = new ClientEntity();
            client = form.parseClientEntity();

            clientDAO.create(client);
        } else {
            client = clientByPassport.get(0);
            client = form.parseClientEntity();
            clientDAO.update(client);
        }
        employmentDAO.create(form.parseEmployment(clientDAO.getById(client.getId())));
        LoanApplicationEntity loanApplication = form.parseLoanApplication(client);
        loanApplicationDAO.create(loanApplication);

        return loanApplication;
    }

    @Transactional
    public LoanContractEntity makeDecision(LoanApplicationEntity loanApplication){
        Random random = new Random();

        if (random.nextBoolean()) {
            loanApplication.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
            loanApplicationDAO.update(loanApplication);

            int minTerm = 30;
            int maxTerm = 365;
            int diffTerm = maxTerm - minTerm;
            int termValue = random.nextInt(diffTerm + 1);
            termValue += minTerm;

            long minAmount = 10000;
            long maxAmount = loanApplication.getDesiredLoan();
            int diffAmount = (int) (maxAmount - minAmount);
            long amountValue = random.nextInt(diffAmount + 1);
            amountValue += minAmount;

            LoanContractEntity loanContract = new LoanContractEntity();

            loanContract.setApprovedLoan(amountValue);
            loanContract.setApprovedTimeToPay(termValue);
            loanContract.setLoanApplication(loanApplication);

            loanContractDAO.create(loanContract);

            return loanContract;
        }
        loanApplication.setLoanApplicationStatus(LoanApplicationStatus.NOT_APPROVED);
        loanApplicationDAO.update(loanApplication);

        return null;
    }

    @Transactional
    public void update(LoanApplicationEntity loanApplication){
        loanApplicationDAO.update(loanApplication);
    }

    @Transactional
    public void delete(LoanApplicationEntity loanApplication){
        loanApplicationDAO.delete(loanApplication);
    }

    @Transactional
    public List<LoanApplicationEntity> getByLoanApplicationStatus(String status){
        if(status.equals("APPROVED")){
            return loanApplicationDAO.getByLoanApplicationStatus(LoanApplicationStatus.APPROVED);
        }
        return loanApplicationDAO.getByLoanApplicationStatus(LoanApplicationStatus.NOT_APPROVED);
    }
}
