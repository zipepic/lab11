package com.example.lab11.conrolles;

import com.example.lab11.service.ClientService;
import com.example.lab11.service.PriceSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/price")
public class PriceController {
    private final PriceSevice priceSevice;
    private final ClientService clientService;
    @Autowired
    public PriceController(PriceSevice priceSevice, ClientService clientService) {
        this.priceSevice = priceSevice;
        this.clientService = clientService;
    }
    @GetMapping("/calculate")
    public String calculatePrice(@RequestParam(defaultValue = "1") int itemPrice,
                                 @RequestParam(defaultValue = "1") int months,
                                 Model model) {

        int[] result = priceSevice.calculateSaleAndRedemptionPrice(itemPrice, months);

        model.addAttribute("salePrice", result[0]);
        model.addAttribute("redemptionPrice", result[1]);

        return "price";
    }

    @PostMapping("/bal")
    public String addBalClient(@PathVariable int id, @PathVariable int price) {
        clientService.addBal(id,price);
        return "redirect:/clients";
    }

}
