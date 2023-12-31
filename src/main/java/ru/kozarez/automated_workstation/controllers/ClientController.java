package ru.kozarez.automated_workstation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.entities.EmploymentEntity;
import ru.kozarez.automated_workstation.models.ClientFilterForm;
import ru.kozarez.automated_workstation.services.ClientService;
import ru.kozarez.automated_workstation.services.EmploymentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    private final EmploymentService employmentService;

    @GetMapping("/clients")
    public String clients(Model model){
        model.addAttribute("clients", clientService.getAll());
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String getClient(@PathVariable long id, Model model){
        List<EmploymentEntity> employments = employmentService.getByClientId(id);
        ClientEntity client = clientService.getById(id);
        model.addAttribute("client", client);
        model.addAttribute("employments", employments);
        return "client";
    }

    @GetMapping("/clients/filtered")
    public String getClientsByFilter(ClientFilterForm clientFilterForm, Model model){
        List<ClientEntity> filteredClients = clientService.getClientsByFilter(clientFilterForm);
        model.addAttribute("clients", filteredClients);
        return "clients";
    }
}
