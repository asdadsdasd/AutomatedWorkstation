package ru.kozarez.automated_workstation.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kozarez.automated_workstation.dao.ClientDAOImplementation;
import ru.kozarez.automated_workstation.dao.EmploymentDAOImplementation;
import ru.kozarez.automated_workstation.dao.LoanApplicationDAOImplementation;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;


import javax.transaction.Transactional;

@Transactional
@Service
public class LoanService {
    private LoanApplicationDAOImplementation loanApplicationDAO;

    @Autowired
    public void setLoanApplicationDAO(LoanApplicationDAOImplementation loanApplicationDAO){
        this.loanApplicationDAO = loanApplicationDAO;
    }

    private ClientDAOImplementation clientDAO;

    @Autowired
    public void setLoanApplicationDAO(ClientDAOImplementation clientDAO){
        this.clientDAO = clientDAO;
        System.out.println("123123123123");
    }

    private EmploymentDAOImplementation employmentDAO;

    @Autowired
    public void setLoanApplicationDAO(EmploymentDAOImplementation employmentDAO){
        this.employmentDAO = employmentDAO;
    }


    @org.springframework.transaction.annotation.Transactional
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
    }
}
