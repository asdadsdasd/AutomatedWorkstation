package ru.kozarez.automated_workstation.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;

import javax.persistence.*;

@Entity
@Table(name = "loan_application")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL)
    private LoanContractEntity loanContract;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(name = "desired_loan")
    private int desiredLoan;

    @Column(name = "loan_status")
    @Enumerated(EnumType.STRING)
    private LoanApplicationStatus loanApplicationStatus = LoanApplicationStatus.NOT_CONSIDERED;
}
