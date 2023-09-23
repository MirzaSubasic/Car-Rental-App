package com.example.CarRentalApp.controllers;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private CarRepository carRepository;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(carRepository);
    }

    @Test
    void testIndex() {
        // Mock data for cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());

        // Mock the behavior of carRepository.findAll()
        when(carRepository.findAll()).thenReturn(cars);

        // Mock the Model to capture attributes
        when(model.addAttribute(anyString(), any())).thenReturn(model);

        String viewName = indexController.index(model);

        // Verify that the view name is "index"
        assertEquals("index", viewName);

        // Verify that the findAll() method was called once
        verify(carRepository, times(1)).findAll();

        // Verify that the "cars" attribute was added to the Model with the correct value
        verify(model, times(1)).addAttribute("cars", cars);
    }
}
