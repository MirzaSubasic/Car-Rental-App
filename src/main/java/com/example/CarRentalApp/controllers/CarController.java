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
    public void initCarBinder(WebDataBinder dataBinder) {
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

        carService.save(car);
        return "redirect:/car/" + car.getId();
    }

    @GetMapping("{carId}/update")
    public String updateCar(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        return "cars/updateCar";
    }

    @PostMapping("{carId}/update")
    public String saveUpdatedCar(@PathVariable Long carId, @Valid Car car, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "cars/updateCar";
        }
        else {
            car.setId(carId);
            Car savedCar = carService.save(car);
            return "redirect:/car/" + savedCar.getId();
        }
    }

    @GetMapping("{carId}/delete")
    public String deleteCarPage(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        return "cars/deleteCar";
    }

    @PostMapping("{carId}/delete")
    public String deleteCar(@PathVariable Long carId) {
        carService.deleteById(carId);
        return "redirect:/index";
    }


    @RequestMapping("history")
    public String carHistory(){
        return "notImplemented";
    }
}
