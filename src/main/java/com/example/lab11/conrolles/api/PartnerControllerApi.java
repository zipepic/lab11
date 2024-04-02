package com.example.lab11.conrolles.api;

import com.example.lab11.model.Partner;
import com.example.lab11.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerControllerApi {

    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }

    @GetMapping("/{id}")
    public Partner getPartnerById(@PathVariable int id) {
        return partnerService.getPartnerById(id);
    }

    @PostMapping
    public void addPartner(@RequestBody Partner partner) {
        partnerService.addPartner(partner);
    }

    @PutMapping("/{id}")
    public void updatePartner(@PathVariable int id, @RequestBody Partner partner) {
        partnerService.updatePartner(id, partner);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable int id) {
        partnerService.deletePartner(id);
    }
}

