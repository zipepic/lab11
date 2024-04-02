package com.example.lab11.service;

import com.example.lab11.model.PawnshopOperation;
import com.example.lab11.repo.PawnshopOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawnshopOperationService {

    @Autowired
    private PawnshopOperationRepository pawnshopOperationRepository;

    public List<PawnshopOperation> getAllPawnshopOperations() {
        return pawnshopOperationRepository.findAll();
    }

    public PawnshopOperation getPawnshopOperationById(int id) {
        return pawnshopOperationRepository.findById(id).orElse(null);
    }

    public void addPawnshopOperation(PawnshopOperation pawnshopOperation) {
        pawnshopOperationRepository.save(pawnshopOperation);
    }

    public void updatePawnshopOperation(int id, PawnshopOperation pawnshopOperation) {
        PawnshopOperation existingPawnshopOperation = pawnshopOperationRepository.findById(id).orElse(null);
        if (existingPawnshopOperation != null) {
            pawnshopOperation.setID(id);
            pawnshopOperationRepository.save(pawnshopOperation);
        }
    }

    public void deletePawnshopOperation(int id) {
        pawnshopOperationRepository.deleteById(id);
    }
}

