package com.example.CarRentalApp.repository;

import com.example.CarRentalApp.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAllByLastNameLike(String lastName);
}
