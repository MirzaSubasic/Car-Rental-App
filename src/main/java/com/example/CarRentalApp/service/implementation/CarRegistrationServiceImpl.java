package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.model.CarRegistration;
import com.example.CarRentalApp.repository.CarRegistrationRepository;
import com.example.CarRentalApp.service.CarRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class CarRegistrationServiceImpl implements CarRegistrationService {

    private final CarRegistrationRepository carRegistrationRepository;
    @Override
    public Set<CarRegistration> findAll() {
        Set<CarRegistration> carRegistrations = new HashSet<>();
        carRegistrationRepository.findAll().forEach(carRegistrations::add);
        return carRegistrations;
    }

    @Override
    public CarRegistration findById(Long aLong) {
        return carRegistrationRepository.findById(aLong).orElse(null);
    }

    @Override
    public CarRegistration save(CarRegistration object) {
        return carRegistrationRepository.save(object);
    }
}
