package com.example.CarRentalApp.bootstrap;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.CarRentalApp.model.enums.CarColor.*;
import static com.example.CarRentalApp.model.enums.FuelType.*;


@Component
public class BootstrapData implements CommandLineRunner {

    private final CarRepository carRepository;

    public BootstrapData(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car vwr = new Car("Volkswagen golf 8 r", (byte) 5, (short) 315, GASOLINE, RED, "");
        carRepository.save(vwr);

        Car citroenc3 = new Car("Citroen c3", (byte) 5, (short) 110, GASOLINE, WHITE, "");
        carRepository.save(citroenc3);

        Car kiaSportage = new Car("Kia Sportage", (byte) 5, (short) 180, GASOLINE, GRAY, "");
        carRepository.save(kiaSportage);

        System.out.println("Cars loaded in bootstrap: " + carRepository.count());
    }

}
