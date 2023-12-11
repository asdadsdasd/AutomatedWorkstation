package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;
import ru.kozarez.automated_workstation.services.EmploymentService;
import ru.kozarez.automated_workstation.services.LoanApplicationService;
import ru.kozarez.automated_workstation.services.LoanContractService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoanApplicationController {
    private final LoanApplicationService loanApplicationService;

    private final EmploymentService employmentService;

    @GetMapping("/loan-applications")
    public String loanApplications(Model model){
        model.addAttribute("statuses", LoanApplicationStatus.values());
        model.addAttribute("loanApplications", loanApplicationService.getAll());
        return "loan_applications";
    }

    @GetMapping("/loan-applications/{id}")
    public String getLoanApplication(@PathVariable long id, Model model){
        LoanApplicationEntity loanApplication = loanApplicationService.getById(id);
        List<EmploymentEntity> employments = employmentService.getByClientId(loanApplication.getClient().getId());
        model.addAttribute("loanApplication", loanApplication);
        model.addAttribute("employments", employments);
        return "loan_application";
    }

    @GetMapping("/loan-applications/filtered")
    public String getLoanApplicationsByFilter(@RequestParam(value = "loanApplicationStatus") String loanApplicationStatus, Model model){
        List<LoanApplicationEntity> loanApplications = loanApplicationService.getByLoanApplicationStatus(loanApplicationStatus);
        model.addAttribute("loanApplications", loanApplications);
        model.addAttribute("statuses", LoanApplicationStatus.values());
        return "loan_applications";
    }
}
