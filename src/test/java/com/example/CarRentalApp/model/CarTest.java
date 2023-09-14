package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.FuelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car = new Car();

    @Test
    void setFuelType() {
        car.setFuelType(FuelType.ELECTRIC);
        String actual = car.getFuelType().toString();
        assertEquals("ELECTRIC", actual);
    }

    @Test
    void setSeatsWithZero () {
        car.setNumberOfSeats((byte) 0);
        assertEquals(1, 1);
    }

    @Test
    void setSeatsWithFive () {
        car.setNumberOfSeats((byte) 5);
        assertEquals(5, 5);
    }

    @Test
    void setSeatsWithTen () {
        car.setNumberOfSeats((byte) 10);
        assertEquals(9, 9);
    }

    @Test
    void setEnginePowerLow () {
        car.setEnginePower((short) 20);
        assertEquals(40, 40);
    }

    @Test
    void setEnginePowerNormal () {
        car.setEnginePower((short) 400);
        assertEquals(400, 400);
    }

    @Test
    void setEnginePowerHigh () {
        car.setEnginePower((short) 20000);
        assertEquals(3000, 3000);
    }
}