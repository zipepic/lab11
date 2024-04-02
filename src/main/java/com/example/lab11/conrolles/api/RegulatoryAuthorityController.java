package com.example.lab11.conrolles.api;

import com.example.lab11.model.RegulatoryAuthority;
import com.example.lab11.service.RegulatoryAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regulatory-authorities")
public class RegulatoryAuthorityController {

    @Autowired
    private RegulatoryAuthorityService regulatoryAuthorityService;

    @GetMapping
    public List<RegulatoryAuthority> getAllRegulatoryAuthorities() {
        return regulatoryAuthorityService.getAllRegulatoryAuthorities();
    }

    @GetMapping("/{id}")
    public RegulatoryAuthority getRegulatoryAuthorityById(@PathVariable int id) {
        return regulatoryAuthorityService.getRegulatoryAuthorityById(id);
    }

    @PostMapping
    public void addRegulatoryAuthority(@RequestBody RegulatoryAuthority regulatoryAuthority) {
        regulatoryAuthorityService.addRegulatoryAuthority(regulatoryAuthority);
    }

    @PutMapping("/{id}")
    public void updateRegulatoryAuthority(@PathVariable int id, @RequestBody RegulatoryAuthority regulatoryAuthority) {
        regulatoryAuthorityService.updateRegulatoryAuthority(id, regulatoryAuthority);
    }

    @DeleteMapping("/{id}")
    public void deleteRegulatoryAuthority(@PathVariable int id) {
        regulatoryAuthorityService.deleteRegulatoryAuthority(id);
    }
}
