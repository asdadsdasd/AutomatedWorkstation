package ru.kozarez.automated_workstation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientFilterForm {
    private String secondName;
    private String firstName;
    private String patronymic;
    private String passportSerial;
    private String passportNumber;
    private String phoneNumber;
}
