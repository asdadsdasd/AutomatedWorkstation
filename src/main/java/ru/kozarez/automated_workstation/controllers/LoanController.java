package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;
import ru.kozarez.automated_workstation.services.LoanService;

@Controller
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping("/")
    public String index(Model model){
        //model.addAttribute("loans", loanService.getLoans());
        model.addAttribute("statuses", MartialStatus.values());
        return "index";
    }

    @PostMapping("/loan/create")
    public String createLoanApplicationForm(LoanApplicationForm loanApplicationForm){
        loanService.createLoanApplication(loanApplicationForm);
        return "redirect:/";
    }
}
