package ru.kozarez.automated_workstation.services;

import org.springframework.stereotype.Service;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanStatus;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    private List<LoanApplicationEntity> loans = new ArrayList<>();
    {
        loans.add(new LoanApplicationEntity(
                new ClientEntity(
                        "Максим", "Козарез", "Вячеславович",
                        "8849", "639023", MartialStatus.MARRIED,
                        "г. Волгоград ул. Тарифная. д. 7 кв. 65", "79044148001",
                        new EmploymentEntity(
                                16, "Программист", "VSTU"
                        )
                ), 1000000, LoanStatus.APPROVED));

        loans.add(new LoanApplicationEntity(
                new ClientEntity(
                        "Виталий", "Мельник", "Сергеевич",
                        "3277", "240054", MartialStatus.DIVORCED,
                        "г. Волгоград ул. Титова. д. 14 кв. 39", "79223176549",
                        new EmploymentEntity(
                                31, "Слесарь", "orgName"
                        )
                ), 550000, LoanStatus.NOT_APPROVED));
    }

    public List<LoanApplicationEntity> getLoans(){
        return loans;
    }

    private void saveLoan(LoanApplicationEntity loanApplicationEntity){
        loans.add(loanApplicationEntity);
    }

    public void createLoan(LoanApplicationForm form){
        EmploymentEntity employment = new EmploymentEntity(
                form.getWorkPeriod(), form.getPost(), form.getOrganisationName()
        );

        ClientEntity client = new ClientEntity(
                form.getSecondName(), form.getFirstName(),
                form.getPatronymic(), form.getPassportSerial(),
                form.getPassportNumber(), form.getMartialStatus(),
                form.getRegistrationAddress(), form.getPhoneNumber(),
                employment
        );

        LoanApplicationEntity loanApplication = new LoanApplicationEntity(
                client, form.getDesiredLoan()
        );

        saveLoan(loanApplication);
    }
}
