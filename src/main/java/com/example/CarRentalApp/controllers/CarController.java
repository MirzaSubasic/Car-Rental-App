package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("car/")
@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("{carId}")
    public ModelAndView showCar(@PathVariable Long carId) {
        ModelAndView mav = new ModelAndView("cars/carDetails");
        mav.addObject(carService.findById(carId));
        return mav;
    }

    @GetMapping("new")
    public String newCar(Model model){
        model.addAttribute("car", new Car());

        return "cars/carForm";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") Car command, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            return "cars/carForm";
        }

        Car savedCommand = carService.save(command);

        return "redirect:/car/" + savedCommand.getId() + "/carDetails";
    }

    @RequestMapping("history")
    public String carHistory(){
        return "notImplemented";
    }
}
