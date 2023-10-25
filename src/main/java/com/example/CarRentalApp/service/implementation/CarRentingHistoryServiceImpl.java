package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.CarRentingHistory;
import com.example.CarRentalApp.repository.CarRentingHistoryRepository;
import com.example.CarRentalApp.service.CarRentingHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class CarRentingHistoryServiceImpl implements CarRentingHistoryService {

    private final CarRentingHistoryRepository carRentingHistoryRepository;

    @Override
    public Set<CarRentingHistory> findAll() {
        Set<CarRentingHistory> history = new HashSet<>();
        carRentingHistoryRepository.findAll().forEach(history :: add);
        return history;
    }

    @Override
    public CarRentingHistory findById(Long aLong) {
        return carRentingHistoryRepository.findById(aLong).orElse(null);
    }

    @Override
    public CarRentingHistory save(CarRentingHistory object) {
        return carRentingHistoryRepository.save(object);
    }
}
