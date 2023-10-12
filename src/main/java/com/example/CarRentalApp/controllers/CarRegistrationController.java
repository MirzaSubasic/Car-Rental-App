package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.model.CarRegistration;
import com.example.CarRentalApp.service.CarRegistrationService;
import com.example.CarRentalApp.service.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("registration/")
@AllArgsConstructor
@Controller
public class CarRegistrationController {

    private final CarRegistrationService carRegistrationService;
    private final CarService carService;

    @GetMapping("")
    public String listCarRegistrations(Model model) {
        model.addAttribute("carRegistrations", carRegistrationService.findAll());
        return "registration/carRegistrationDetails";
    }

    @InitBinder("car")
    public void initCarRegistrationBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("{carId}/update")
    public String updateRegistration(Model model, @PathVariable Long carId) {
        model.addAttribute("car", carService.findById(carId));
        return "registration/updateRegistration";
    }

    @PostMapping("{carId}/update")
    public String saveUpdatedCar(@Valid CarRegistration carRegistration, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/updateRegistration";
        }
        else {
            carRegistrationService.save(carRegistration);
            return "redirect:/registration/carRegistrationDetails";
        }
    }

}
