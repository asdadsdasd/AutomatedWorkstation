package ru.kozarez.automated_workstation.entities;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozarez.automated_workstation.entities.enums.LoanContractStatus;

import java.util.Date;

@Entity
@Table(name = "loan_contract")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanContractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contract_status")
    @Enumerated(EnumType.STRING)
    private LoanContractStatus loanContractStatus;

    @Column(name = "signing_date")
    private Date signingDate;

    @OneToOne
    @JoinColumn(name = "loan_application_id", unique = true)
    private LoanApplicationEntity loanApplication;
}
