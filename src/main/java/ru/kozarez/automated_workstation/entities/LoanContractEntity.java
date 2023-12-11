package ru.kozarez.automated_workstation.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozarez.automated_workstation.entities.enums.LoanContractStatus;

import java.util.Date;

@Entity
@Table(name = "loan_contracts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanContractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "contract_status")
    @Enumerated(EnumType.STRING)
    private LoanContractStatus loanContractStatus = LoanContractStatus.NOT_SIGNED;

    @Column(name = "signing_date")
    private Date signingDate;

    @Column(name = "approved_loan")
    private long approvedLoan;

    @Column(name = "approved_time_to_pay")
    private int approvedTimeToPay;

    @OneToOne
    @JoinColumn(name = "loan_application_id")
    private LoanApplicationEntity loanApplication;
}
