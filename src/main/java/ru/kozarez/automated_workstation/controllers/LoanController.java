package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;
import ru.kozarez.automated_workstation.services.LoanApplicationService;

@Controller
@RequiredArgsConstructor
public class LoanApplicationController {
    private final LoanApplicationService loanApplicationService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/loan-application-create-form/create")
    public String loanApplication(Model model){
        model.addAttribute("statuses", MartialStatus.values());
        return "loan_application_create_form";
    }

    @PostMapping("/loan/create")
    public String createLoanApplicationForm(LoanApplicationForm loanApplicationForm) {
        //loanApplicationService.createLoanApplication(loanApplicationForm);
        return "redirect:/";
    }

    @GetMapping("/loan-applications")
    public String loanApplications(Model model){
        model.addAttribute("statuses", LoanApplicationStatus.values());
        model.addAttribute("loanApplications", loanApplicationService.getAll());
        return "loan_applications";
    }
}
