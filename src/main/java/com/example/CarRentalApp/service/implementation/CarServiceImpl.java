package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import com.example.CarRentalApp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Set<Car> findAll() {
        Set<Car> car = new HashSet<>();
        carRepository.findAll().forEach(car::add);
        return car;
    }

    @Override
    public Car findById(Long aLong) {
        return carRepository.findById(aLong).orElse(null);
    }

    @Override
    public Car save(Car object) {
        return carRepository.save(object);
    }

    @Override
    public void delete(Car object) {
        carRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }
}
