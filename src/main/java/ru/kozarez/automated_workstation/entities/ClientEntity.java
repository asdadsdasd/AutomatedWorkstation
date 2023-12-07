package ru.kozarez.automated_workstation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;

@Data
@AllArgsConstructor
public class ClientEntity {
    private String secondName;
    private String firstName;
    private String patronymic;
    private String passportSerial;
    private String passportNumber;
    private MartialStatus martialStatus;
    private String registrationAddress;
    private String phoneNumber;
    private EmploymentEntity employmentEntity;

}
