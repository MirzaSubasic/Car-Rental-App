package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.service.CarRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("registration/")
@AllArgsConstructor
@Controller
public class CarRegistrationController {

    private final CarRegistrationService carRegistrationService;


    @GetMapping("")
    public String listCarRegistrations(Model model) {
        model.addAttribute("carRegistrations", carRegistrationService.findAll());
        return "registration/carRegistrationDetails";
    }
}
