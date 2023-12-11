package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.entities.LoanApplicationEntity;
import ru.kozarez.automated_workstation.entities.LoanContractEntity;
import ru.kozarez.automated_workstation.entities.enums.LoanApplicationStatus;
import ru.kozarez.automated_workstation.entities.enums.LoanContractStatus;
import ru.kozarez.automated_workstation.entities.enums.MartialStatus;
import ru.kozarez.automated_workstation.models.LoanApplicationForm;
import ru.kozarez.automated_workstation.services.ClientService;
import ru.kozarez.automated_workstation.services.EmploymentService;
import ru.kozarez.automated_workstation.services.LoanApplicationService;
import ru.kozarez.automated_workstation.services.LoanContractService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoanController {
    private final LoanApplicationService loanApplicationService;

    private final LoanContractService loanContractService;

    private final EmploymentService employmentService;

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
        //loanApplicationService.createLoanApplication(loanApplicationForm);
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

    @GetMapping("/loan-applications/filtered")
    public String getLoanApplicationsByFilter(@RequestParam(value = "loanApplicationStatus") String loanApplicationStatus, Model model){
        List<LoanApplicationEntity> loanApplications = loanApplicationService.getByLoanApplicationStatus(loanApplicationStatus);
        model.addAttribute("loanApplications", loanApplications);
        model.addAttribute("statuses", LoanApplicationStatus.values());
        return "loan_applications";
    }

    @GetMapping("/loan-contracts/filtered")
    public String getLoanContractsByFilter(@RequestParam(value = "loanContractStatus") String loanContractStatus, Model model){
        List<LoanContractEntity> loanContracts = loanContractService.getByLoanContractStatus(loanContractStatus);
        model.addAttribute("loanContracts", loanContracts);
        model.addAttribute("statuses", LoanContractStatus.values());
        return "loan_contracts";
    }
}
