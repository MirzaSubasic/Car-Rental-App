package com.example.CarRentalApp.service;

import com.example.CarRentalApp.model.Car;

public interface CarService extends CrudService<Car, Long> {

    Car findById(Long Id);

}
