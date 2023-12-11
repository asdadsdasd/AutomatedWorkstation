package ru.kozarez.automated_workstation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class LoanApplicationForm {
    /*@NotEmpty
    @Size(min = 2, max = 30)*/
    private String secondName;

    /*@NotEmpty
    @Size(min = 2, max = 30)*/
    private String firstName;

    /*@Size(min = 2, max = 30)*/
    private String patronymic;

    /*@NotEmpty
    @Size(min = 4, max = 4)*/
    private String passportSerial;

    /*@NotEmpty
    @Size(min = 6, max = 6)*/
    private String passportNumber;

    /*@NotEmpty*/
    private MartialStatus martialStatus;

   /* @NotEmpty
    @Size(min = 4, max = 200)*/
    private String registrationAddress;

    /*@NotEmpty
    @Size(min = 9, max = 15)*/
    private String phoneNumber;

   /* @NotEmpty
    @Min(value = 0)
    @Max(value = 900)*/
    private int workPeriod;

    /*@NotEmpty
    @Size(min = 2, max = 80)*/
    private String post;

    /*@NotEmpty
    @Size(min = 2, max = 80)*/
    private String organisationName;

    /*@NotEmpty
    @Min(value = 10000)
    @Max(value = 50000000)*/
    private int desiredLoan;

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
