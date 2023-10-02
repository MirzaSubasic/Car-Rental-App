package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
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

    @InitBinder("carRegistration")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("new")
    public String newCar(Model model){
        model.addAttribute("car", new Car());

        return "cars/carForm";
    }

    @PostMapping("new")
    public String save(@Valid Car car){
        carService.save(car);
        return "redirect:/car/" + car.getId();
    }


    @RequestMapping("history")
    public String carHistory(){
        return "notImplemented";
    }
}
