package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/")
    public String allCustomers(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/Customers";
    }
}
