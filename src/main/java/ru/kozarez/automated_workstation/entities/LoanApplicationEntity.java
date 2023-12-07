package ru.kozarez.automated_workstation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kozarez.automated_workstation.entities.enums.LoanStatus;

@Data
@AllArgsConstructor
public class LoanApplicationEntity {
    private ClientEntity clientEntity;
    private int desiredLoan;
    private LoanStatus loanStatus = LoanStatus.MOT_CONSIDERED;

    public LoanApplicationEntity(ClientEntity clientEntity, int desiredLoan){
        this.clientEntity = clientEntity;
        this.desiredLoan = desiredLoan;
    }
}
