package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){

        Car car = CarRepository.findById(1L).orElse(null);

        model.addAttribute("car", car);

        return "index";
    }
}
