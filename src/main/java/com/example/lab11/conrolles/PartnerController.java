package com.example.lab11.conrolles;

import com.example.lab11.model.Partner;
import com.example.lab11.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public String getAllPartners(Model model) {
        List<Partner> partners = partnerService.getAllPartners();
        model.addAttribute("partners", partners);
        return "partner/list";
    }

    @GetMapping("/{id}")
    public String getPartnerById(@PathVariable int id, Model model) {
        Partner partner = partnerService.getPartnerById(id);
        model.addAttribute("partner", partner);
        return "partner/view";
    }

    @GetMapping("/add")
    public String showAddPartnerForm(Model model) {
        model.addAttribute("partner", new Partner());
        return "partner/add";
    }

    @PostMapping("/add")
    public String addPartner(@ModelAttribute Partner partner) {
        partnerService.addPartner(partner);
        return "redirect:/partners";
    }

    @GetMapping("/edit/{id}")
    public String showEditPartnerForm(@PathVariable int id, Model model) {
        Partner partner = partnerService.getPartnerById(id);
        model.addAttribute("partner", partner);
        return "partner/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePartner(@PathVariable int id, @ModelAttribute Partner partner) {
        partnerService.updatePartner(id, partner);
        return "redirect:/partners";
    }

    @GetMapping("/delete/{id}")
    public String deletePartner(@PathVariable int id) {
        partnerService.deletePartner(id);
        return "redirect:/partners";
    }
}

