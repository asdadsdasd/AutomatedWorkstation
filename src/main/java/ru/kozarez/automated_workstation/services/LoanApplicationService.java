package ru.kozarez.automated_workstation.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kozarez.automated_workstation.dao.*;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
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

            loanContract.setApprovedLoanAmount(amountValue);
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

    /*@Transactional
    public void createLoanApplication(LoanApplicationForm form) {
        EmploymentEntity employment = new EmploymentEntity();
        ClientEntity client = new ClientEntity();
        LoanApplicationEntity loanApplication = new LoanApplicationEntity();

        employment.setClient(client);
        employment.setPost(form.getPost());
        employment.setWorkPeriod(form.getWorkPeriod());
        employment.setOrganisationName(form.getOrganisationName());

        client.setSecondName(form.getSecondName());
        client.setFirstName(form.getFirstName());
        client.setPatronymic(form.getPatronymic());
        client.setPassportSerial(form.getPassportSerial());
        client.setPassportNumber(form.getPassportNumber());
        client.setMartialStatus(form.getMartialStatus());
        client.setPhoneNumber(form.getPhoneNumber());
        client.setRegistrationAddress(form.getRegistrationAddress());

        loanApplication.setDesiredLoan(form.getDesiredLoan());
        loanApplication.setClient(client);
        loanApplication.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);

        clientDAO.create(client);
        loanApplicationDAO.create(loanApplication);
        employmentDAO.create(employment);
    }*/
}
