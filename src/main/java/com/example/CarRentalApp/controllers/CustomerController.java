package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Customer;
import com.example.CarRentalApp.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("customers/")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("")
    public String allCustomers(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/customers";
    }

    @GetMapping("{customerId}")
    public ModelAndView showCustomer(@PathVariable Long customerId) {
        ModelAndView mav = new ModelAndView("customers/detail");
        Customer customer = customerRepository.findById(customerId).orElse(null);
        mav.addObject("customer", customer);
        return mav;
    }

    @GetMapping("newCustomer")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/newCustomer";
    }

    @PostMapping("newCustomer")
    public String save(@Valid Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers/" + customer.getId();
    }

}
