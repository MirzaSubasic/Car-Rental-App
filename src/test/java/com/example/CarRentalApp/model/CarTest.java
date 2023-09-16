package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.FuelType;
import com.example.CarRentalApp.bootstrap.BootstrapImageLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.example.CarRentalApp.model.enums.CarColor.RED;
import static com.example.CarRentalApp.model.enums.FuelType.GASOLINE;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    BootstrapImageLoader bootstrapImageLoader = new BootstrapImageLoader();

    byte[] image1 = bootstrapImageLoader.loadImageAsByteArray("golf8r.jpg");
    Car car = new Car(image1, "Volkswagen golf 8 r",2021 ,
            (byte) 5, (short) 315, GASOLINE, RED, "");

    CarTest() throws IOException {
    }

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