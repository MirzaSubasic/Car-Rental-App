package com.example.CarRentalApp.repository;

import com.example.CarRentalApp.model.CarRegistration;
import org.springframework.data.repository.CrudRepository;

public interface CarRegistrationRepository extends CrudRepository<CarRegistration, Long> {
}
