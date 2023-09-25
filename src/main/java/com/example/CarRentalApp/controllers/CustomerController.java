package com.example.CarRentalApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @RequestMapping("/")
    public String allCustomers(){
        return "notImplemented";
    }
}
