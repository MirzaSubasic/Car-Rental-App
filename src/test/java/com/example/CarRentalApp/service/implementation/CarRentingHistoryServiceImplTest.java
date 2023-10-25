package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.CarRentingHistory;
import com.example.CarRentalApp.repository.CarRentingHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarRentingHistoryServiceImplTest {

    private CarRentingHistoryServiceImpl carRentingHistoryService;

    @Mock
    private CarRentingHistoryRepository carRentingHistoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        carRentingHistoryService = new CarRentingHistoryServiceImpl(carRentingHistoryRepository);
    }

    @Test
    public void testFindAll() {
        // Mock the behavior of the repository
        when(carRentingHistoryRepository.findAll()).thenReturn(Collections.emptyList());

        Set<CarRentingHistory> result = carRentingHistoryService.findAll();

        assertEquals(0, result.size());
    }

    @Test
    public void testFindById() {
        Long historyId = 1L;
        CarRentingHistory history = new CarRentingHistory();
        history.setId(historyId);

        // Mock the behavior of the repository
        when(carRentingHistoryRepository.findById(historyId)).thenReturn(Optional.of(history));

        CarRentingHistory result = carRentingHistoryService.findById(historyId);

        assertEquals(historyId, result.getId());
    }

    @Test
    public void testSave() {
        CarRentingHistory history = new CarRentingHistory();

        // Mock the behavior of the repository
        when(carRentingHistoryRepository.save(Mockito.any())).thenReturn(history);

        CarRentingHistory result = carRentingHistoryService.save(history);

        assertEquals(history, result);
        verify(carRentingHistoryRepository).save(history);
    }
}
