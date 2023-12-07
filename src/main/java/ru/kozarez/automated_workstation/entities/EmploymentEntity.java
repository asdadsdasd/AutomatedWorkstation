package ru.kozarez.automated_workstation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmploymentEntity {
    private int workPeriod;
    private String post;
    private String organisationName;
}
