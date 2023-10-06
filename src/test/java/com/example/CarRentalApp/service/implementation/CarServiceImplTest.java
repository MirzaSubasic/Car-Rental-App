package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CarServiceImplTest {

    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    void findAll() {
        // Create a set of dummy cars
        Set<Car> cars = new HashSet<>();
        cars.add(new Car());
        cars.add(new Car());

        // Mock the behavior of carRepository.findAll()
        when(carRepository.findAll()).thenReturn(cars);

        Set<Car> result = carService.findAll();

        // Verify that the result matches the mocked data
        assertEquals(cars.size(), result.size());
    }

    @Test
    void findById() {
        Long carId = 1L;
        Car car = new Car();
        car.setId(carId);

        // Mock the behavior of carRepository.findById()
        when(carRepository.findById(carId)).thenReturn(Optional.of(car));

        Car result = carService.findById(carId);

        // Verify that the result matches the mocked data
        assertEquals(carId, result.getId());
    }

    @Test
    void delete() {
        Car carToDelete = new Car();

        // Perform the delete operation
        carService.delete(carToDelete);

        // Verify that the carRepository.delete() method was called once with the correct argument
        verify(carRepository, times(1)).delete(carToDelete);
    }

    @Test
    void deleteById() {
        Long carId = 1L;

        // Perform the delete operation
        carService.deleteById(carId);

        // Verify that the carRepository.deleteById() method was called once with the correct argument
        verify(carRepository, times(1)).deleteById(carId);
    }
}
