package com.example.CarRentalApp.service;

import com.example.CarRentalApp.model.Car;

public interface CarService extends CrudService<Car, Long> {

    void delete(Car object);

    void deleteById(Long id);
}
