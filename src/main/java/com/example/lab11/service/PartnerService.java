package com.example.lab11.service;

import com.example.lab11.model.Partner;
import com.example.lab11.repo.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public Partner getPartnerById(int id) {
        return partnerRepository.findById(id).orElse(null);
    }

    public void addPartner(Partner partner) {
        partnerRepository.save(partner);
    }

    public void updatePartner(int id, Partner partner) {
        Partner existingPartner = partnerRepository.findById(id).orElse(null);
        if (existingPartner != null) {
            partner.setID(id);
            partnerRepository.save(partner);
        }
    }

    public void deletePartner(int id) {
        partnerRepository.deleteById(id);
    }
}
