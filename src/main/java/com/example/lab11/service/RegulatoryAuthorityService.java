package com.example.lab11.service;


import com.example.lab11.model.RegulatoryAuthority;
import com.example.lab11.repo.RegulatoryAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegulatoryAuthorityService {

    @Autowired
    private RegulatoryAuthorityRepository regulatoryAuthorityRepository;

    public List<RegulatoryAuthority> getAllRegulatoryAuthorities() {
        return regulatoryAuthorityRepository.findAll();
    }

    public RegulatoryAuthority getRegulatoryAuthorityById(int id) {
        return regulatoryAuthorityRepository.findById(id).orElse(null);
    }
    public void addRegulatoryAuthority(RegulatoryAuthority regulatoryAuthority) {
        regulatoryAuthorityRepository.save(regulatoryAuthority);
    }

    public void updateRegulatoryAuthority(int id, RegulatoryAuthority regulatoryAuthority) {
        RegulatoryAuthority existingRegulatoryAuthority = regulatoryAuthorityRepository.findById(id).orElse(null);
        if (existingRegulatoryAuthority != null) {
            regulatoryAuthority.setID(id);
            regulatoryAuthorityRepository.save(regulatoryAuthority);
        }
    }

    public void deleteRegulatoryAuthority(int id) {
        regulatoryAuthorityRepository.deleteById(id);
    }
}
