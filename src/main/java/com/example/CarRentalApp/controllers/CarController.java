package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.model.CarRegistration;
import com.example.CarRentalApp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

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
    public String newCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "cars/carForm";
    }

    @PostMapping("new")
    public String saveCar(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/carForm";
        }

        // Create a new CarRegistration and associate it with the Car
        CarRegistration carRegistration = new CarRegistration();
        carRegistration.setCar(car);
        car.setCarRegistration(carRegistration);

        // Save the Car (including CarRegistration due to CascadeType.ALL)
        carService.save(car);

        return "redirect:/car/" + car.getId();
    }


    @RequestMapping("history")
    public String carHistory(){
        return "notImplemented";
    }
}
