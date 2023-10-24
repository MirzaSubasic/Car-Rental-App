package com.example.CarRentalApp.repository;

import com.example.CarRentalApp.model.CarRentingHistory;
import org.springframework.data.repository.CrudRepository;

public interface CarRentingHistoryRepository extends CrudRepository<CarRentingHistory, Long> {
}
