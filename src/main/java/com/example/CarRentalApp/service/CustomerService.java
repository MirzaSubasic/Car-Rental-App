package com.example.CarRentalApp.service;

import com.example.CarRentalApp.model.Customer;

import java.util.List;

public interface CustomerService extends CrudService <Customer, Long>{

    List<Customer> findAllByLastNameLike(String lastName);
}
