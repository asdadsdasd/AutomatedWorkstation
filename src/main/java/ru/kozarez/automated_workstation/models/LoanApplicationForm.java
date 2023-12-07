package ru.kozarez.automated_workstation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;

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
    private int desiredLoan;

}
