package com.example.lab11.conrolles;

import com.example.lab11.model.PawnshopOperation;
import com.example.lab11.service.PawnshopOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pawnshop-operations")
public class PawnshopOperationController {

    @Autowired
    private PawnshopOperationService pawnshopOperationService;

    @GetMapping
    public String getAllPawnshopOperations(Model model) {
        List<PawnshopOperation> pawnshopOperations = pawnshopOperationService.getAllPawnshopOperations();
        model.addAttribute("pawnshopOperations", pawnshopOperations);
        return "pawnshopOperation/list";
    }

    @GetMapping("/{id}")
    public String getPawnshopOperationById(@PathVariable int id, Model model) {
        PawnshopOperation pawnshopOperation = pawnshopOperationService.getPawnshopOperationById(id);
        model.addAttribute("pawnshopOperation", pawnshopOperation);
        return "pawnshopOperation/view";
    }

    @GetMapping("/add")
    public String showAddPawnshopOperationForm(Model model) {
        model.addAttribute("pawnshopOperation", new PawnshopOperation());
        return "pawnshopOperation/add";
    }

    @PostMapping("/add")
    public String addPawnshopOperation(@ModelAttribute PawnshopOperation pawnshopOperation) {
        pawnshopOperationService.addPawnshopOperation(pawnshopOperation);
        return "redirect:/pawnshop-operations";
    }

    @GetMapping("/edit/{id}")
    public String showEditPawnshopOperationForm(@PathVariable int id, Model model) {
        PawnshopOperation pawnshopOperation = pawnshopOperationService.getPawnshopOperationById(id);
        model.addAttribute("pawnshopOperation", pawnshopOperation);
        return "pawnshopOperation/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePawnshopOperation(@PathVariable int id, @ModelAttribute PawnshopOperation pawnshopOperation) {
        pawnshopOperationService.updatePawnshopOperation(id, pawnshopOperation);
        return "redirect:/pawnshop-operations";
    }

    @GetMapping("/delete/{id}")
    public String deletePawnshopOperation(@PathVariable int id) {
        pawnshopOperationService.deletePawnshopOperation(id);
        return "redirect:/pawnshop-operations";
    }
}

