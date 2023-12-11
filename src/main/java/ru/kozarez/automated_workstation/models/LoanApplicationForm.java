package ru.kozarez.automated_workstation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;
import java.util.Arrays;

@Data
@AllArgsConstructor
public class LoanApplicationForm {
    private String secondName;
    private String firstName;
    private String patronymic;
    private String passportSerial;
    private String passportNumber;
    private MartialStatus martialStatus;
    private String registrationAddress;
    private String phoneNumber;
    private int workPeriod;
    private String post;
    private String organisationName;
    private long desiredLoan;

    public ClientEntity parseClientEntity(){
        ClientEntity client = new ClientEntity();

        client.setSecondName(this.secondName);
        client.setFirstName(this.firstName);
        if (this.patronymic != null)
            client.setPatronymic(this.patronymic);
        client.setPassportSerial(this.passportSerial);
        client.setPassportNumber(this.passportNumber);
        client.setPhoneNumber(this.phoneNumber);
        client.setRegistrationAddress(this.registrationAddress);
        client.setMartialStatus(this.martialStatus);

        return client;
    }

    public EmploymentEntity parseEmployment(ClientEntity clientEntity){
        EmploymentEntity employment = new EmploymentEntity();
        employment.setOrganisationName(this.getOrganisationName());
        employment.setPost(this.getPost());
        employment.setWorkPeriod(this.workPeriod);
        employment.setClient(clientEntity);
        clientEntity.setEmployments(Arrays.asList(employment));

        return employment;
    }

    public LoanApplicationEntity parseLoanApplication(ClientEntity clientEntity){
        LoanApplicationEntity loanApplication = new LoanApplicationEntity();
        loanApplication.setDesiredLoan(this.desiredLoan);
        loanApplication.setClient(clientEntity);

        return loanApplication;
    }
}
