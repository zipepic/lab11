package com.example.lab11.conrolles;

import com.example.lab11.model.Client;
import com.example.lab11.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

//    @GetMapping
//    public String getAllClients(Model model) {
//        List<Client> clients = clientService.getAllClients();
//        model.addAttribute("clients", clients);
//        return "client/list";
//    }
@GetMapping
public String getAllClients(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size,
                            @RequestParam(defaultValue = "ID") String sort,
                            @RequestParam(defaultValue = "") String keyword,
                            Model model) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
    Page<Client> clientsPage;

    if (!keyword.isEmpty()) {
        clientsPage = clientService.searchClients(keyword, pageable);
    } else {
        clientsPage = clientService.getAllClients(pageable);
    }

    model.addAttribute("clients", clientsPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", clientsPage.getTotalPages());
    model.addAttribute("totalItems", clientsPage.getTotalElements());
    model.addAttribute("sortField", sort);
    model.addAttribute("sortDirection", clientsPage.getSort().getOrderFor(sort).getDirection());

    return "client/list";
}

    @GetMapping("/{id}")
    public String getClientById(@PathVariable int id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client/view";
    }

    @GetMapping("/add")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/add";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        clientService.addClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable int id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable int id, @ModelAttribute Client client) {
        clientService.updateClient(id, client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}


