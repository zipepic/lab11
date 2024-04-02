package com.example.lab11.conrolles.api;


import com.example.lab11.model.PawnshopOperation;
import com.example.lab11.service.PawnshopOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pawnshop-operations")
public class PawnshopOperationControllerApi {

    @Autowired
    private PawnshopOperationService pawnshopOperationService;

    @GetMapping
    public List<PawnshopOperation> getAllPawnshopOperations() {
        return pawnshopOperationService.getAllPawnshopOperations();
    }

    @GetMapping("/{id}")
    public PawnshopOperation getPawnshopOperationById(@PathVariable int id) {
        return pawnshopOperationService.getPawnshopOperationById(id);
    }

    @PostMapping
    public void addPawnshopOperation(@RequestBody PawnshopOperation pawnshopOperation) {
        pawnshopOperationService.addPawnshopOperation(pawnshopOperation);
    }

    @PutMapping("/{id}")
    public void updatePawnshopOperation(@PathVariable int id, @RequestBody PawnshopOperation pawnshopOperation) {
        pawnshopOperationService.updatePawnshopOperation(id, pawnshopOperation);
    }

    @DeleteMapping("/{id}")
    public void deletePawnshopOperation(@PathVariable int id) {
        pawnshopOperationService.deletePawnshopOperation(id);
    }
}

