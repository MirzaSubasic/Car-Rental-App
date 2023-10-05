package com.example.CarRentalApp.repository;

import com.example.CarRentalApp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
