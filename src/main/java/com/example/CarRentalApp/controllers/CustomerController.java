package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Customer;
import com.example.CarRentalApp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("customers/")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public String allCustomers(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "customers/customers";
    }

    @GetMapping("{customerId}")
    public ModelAndView showCustomer(@PathVariable Long customerId) {
        ModelAndView mav = new ModelAndView("customers/detail");
        Customer customer = customerService.findById(customerId);
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
        customerService.save(customer);
        return "redirect:/customers/" + customer.getId();
    }

    @GetMapping("{customerId}/update")
    public String updateCustomer(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "customers/updateCustomer";
    }

    @PostMapping("{customerId}/update")
    public String saveUpdatedCustomer(@PathVariable Long customerId, @Valid @ModelAttribute Customer customer,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateCustomer";
        } else {
            customer.setId(customerId);
            Customer savedCustomer = customerService.save(customer);
            return "redirect:/customers/" + savedCustomer.getId();
        }
    }

}
