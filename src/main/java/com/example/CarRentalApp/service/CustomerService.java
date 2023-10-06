package com.example.CarRentalApp.service;

import com.example.CarRentalApp.model.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService extends CrudService <Customer, Long>{

    List<Customer> findAllByLastNameLike(String lastName);
}
