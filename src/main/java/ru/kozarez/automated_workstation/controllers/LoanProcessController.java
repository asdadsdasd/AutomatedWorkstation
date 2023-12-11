package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;
import ru.kozarez.automated_workstation.services.EmploymentService;
import ru.kozarez.automated_workstation.services.LoanApplicationService;
import ru.kozarez.automated_workstation.services.LoanContractService;

@Controller
@RequiredArgsConstructor
public class LoanProcessController {
    private final LoanApplicationService loanApplicationService;

    private final LoanContractService loanContractService;

    private LoanApplicationEntity loanApplicationEntity = null;

    private LoanContractEntity loanContractEntity = null;

    private LoanApplicationForm loanApplicationForm = null;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/loan-application-create-form/create")
    public String loanApplication(Model model){
        model.addAttribute("statuses", MartialStatus.values());
        return "loan_application_create_form";
    }

    @PostMapping("/loan-application-create-form/create")
    public String createLoanApplicationForm(@ModelAttribute("loanApplicationForm") LoanApplicationForm loanApplicationForm) {
        this.loanApplicationForm = loanApplicationForm;
        loanApplicationEntity = loanApplicationService.createWithForm(loanApplicationForm);
        return "redirect:/loan-application-create-form/decision";
    }

    @GetMapping("/loan-application-create-form/decision")
    public String loanDecision(Model model){
        if(loanApplicationEntity == null){
            return "redirect:/";
        }
        loanContractEntity = loanApplicationService.makeDecision(loanApplicationEntity);
        if (loanContractEntity == null){
            model.addAttribute("status", "Кредит не одобрен");
        }else {
            model.addAttribute("status", "Кредит одобрен");
        }
        return "loan_decision";
    }

    @GetMapping("/loan-application-create-form/contract")
    public String getContractForm(Model model){
        if(loanContractEntity == null){
            return "redirect:/";
        }else {
            model.addAttribute("loanContract", loanContractEntity);
            model.addAttribute("employment", loanApplicationForm);
        }
        return "loan_contract_form";
    }

    @PostMapping("/loan-application-create-form/contract")
    public String signContract(@RequestParam("contractAction") String contractAction){
        boolean flag;
        System.out.println(contractAction + "1111111111111111111111111");
        if("sign".equals(contractAction)){
            flag = true;
        }else{
            flag = false;
        }
        loanContractService.signContract(loanContractEntity, flag);
        loanContractEntity = null;
        loanContractEntity = null;
        return "redirect:/";
    }
}
