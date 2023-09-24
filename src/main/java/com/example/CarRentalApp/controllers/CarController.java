package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
