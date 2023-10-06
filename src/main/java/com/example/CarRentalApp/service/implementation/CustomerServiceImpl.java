package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.Customer;
import com.example.CarRentalApp.repository.CustomerRepository;
import com.example.CarRentalApp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Set<Customer> findAll() {
        Set<Customer> customer = new HashSet<>();
        customerRepository.findAll().forEach(customer::add);
        return customer;    }

    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).orElse(null);    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public List<Customer> findAllByLastNameLike(String lastName) {
        return customerRepository.findAllByLastNameLike(lastName);
    }
}
