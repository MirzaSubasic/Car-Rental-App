package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.Customer;
import com.example.CarRentalApp.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void findAll() {
        // Create a set of dummy customers
        Set<Customer> customers = new HashSet<>();
        customers.add(new Customer());
        customers.add(new Customer());

        // Mock the behavior of customerRepository.findAll()
        when(customerRepository.findAll()).thenReturn(customers);

        // Act
        Set<Customer> result = customerService.findAll();

        // Assert
        assertEquals(customers.size(), result.size());
    }

    @Test
    void findById() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);

        // Mock the behavior of customerRepository.findById()
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        // Act
        Customer result = customerService.findById(customerId);

        // Assert
        assertEquals(customerId, result.getId());
    }

    @Test
    void save() {
        // Arrange
        Customer customerToSave = new Customer();
        customerToSave.setId(1L);

        // Mock the behavior of customerRepository.save()
        when(customerRepository.save(customerToSave)).thenReturn(customerToSave);

        // Act
        Customer result = customerService.save(customerToSave);

        // Assert
        assertEquals(1L, result.getId());
    }

    @Test
    void findAllByLastNameLike() {
        // Arrange
        String lastName = "Doe";
        List<Customer> customers = List.of(new Customer(), new Customer());

        // Mock the behavior of customerRepository.findAllByLastNameLike()
        when(customerRepository.findAllByLastNameLike(lastName)).thenReturn(customers);

        // Act
        List<Customer> result = customerService.findAllByLastNameLike(lastName);

        // Assert
        assertEquals(customers.size(), result.size());
    }
}
