package ru.kozarez.automated_workstation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;

@Entity
@Table(name = "loan_application")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LoanApplicationStatus loanApplicationStatus = LoanApplicationStatus.MOT_CONSIDERED;
}
