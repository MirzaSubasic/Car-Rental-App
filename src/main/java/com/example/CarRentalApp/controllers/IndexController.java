package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
public class IndexController {

    private final CarRepository carRepository;

    public IndexController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model){

        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);

        return "index";
    }
}
