package com.example.CarRentalApp.repository;

import com.example.CarRentalApp.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, Long> {
}
