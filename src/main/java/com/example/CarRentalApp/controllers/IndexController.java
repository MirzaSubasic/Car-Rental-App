package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@AllArgsConstructor
public class IndexController {

    private final CarService carService;

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model){

        Iterable<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);

        return "index";
    }
}
