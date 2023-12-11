package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanContractStatus;
import ru.kozarez.automated_workstation.services.EmploymentService;
import ru.kozarez.automated_workstation.services.LoanContractService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoanContractController {
    private final LoanContractService loanContractService;

    private final EmploymentService employmentService;

    @GetMapping("/loan-contracts")
    public String loanContracts(Model model){
        model.addAttribute("statuses", LoanContractStatus.values());
        model.addAttribute("loanContracts", loanContractService.getAll());
        return "loan_contracts";
    }

    @GetMapping("/loan-contracts/{id}")
    public String getLoanContract(@PathVariable long id, Model model){
        LoanContractEntity loanContract = loanContractService.getById(id);
        List<EmploymentEntity> employments = employmentService.getByClientId(loanContract.getLoanApplication().getClient().getId());
        model.addAttribute("loanContract", loanContract);
        model.addAttribute("employments", employments);
        return "loan_contract";
    }

    @GetMapping("/loan-contracts/filtered")
    public String getLoanContractsByFilter(@RequestParam(value = "loanContractStatus") String loanContractStatus, Model model){
        List<LoanContractEntity> loanContracts = loanContractService.getByLoanContractStatus(loanContractStatus);
        model.addAttribute("loanContracts", loanContracts);
        model.addAttribute("statuses", LoanContractStatus.values());
        return "loan_contracts";
    }
}
