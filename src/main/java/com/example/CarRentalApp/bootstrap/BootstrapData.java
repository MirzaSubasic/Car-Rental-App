package com.example.CarRentalApp.bootstrap;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.CarRentalApp.model.enums.CarColor.*;
import static com.example.CarRentalApp.model.enums.FuelType.*;


@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final CarService carService;

    String imgSrcFolder = "src/main/resources/static/Images/";
    @Override
    public void run(String... args) throws Exception {

        Car vwr = new Car();
        vwr.setImage(imgSrcFolder + "golf8r.jpg");
        vwr.setModel("Volkswagen golf 8 r");
        vwr.setYear(2021);
        vwr.setNumberOfSeats((byte) 5);
        vwr.setEnginePower((short) 315);
        vwr.setFuelType(GASOLINE);
        vwr.setCarColor(RED);
        vwr.setDescription("");
        vwr.setPrice(150);
        carService.save(vwr);

        Car citroenc3 = new Car();
        citroenc3.setImage(imgSrcFolder + "citroenc3.jpg");
        citroenc3.setModel("Citroen c3");
        citroenc3.setYear(2020);
        citroenc3.setNumberOfSeats((byte) 5);
        citroenc3.setEnginePower((short) 110);
        citroenc3.setFuelType(GASOLINE);
        citroenc3.setCarColor(WHITE);
        citroenc3.setDescription("");
        citroenc3.setPrice(80);
        carService.save(citroenc3);

        Car kiaSportage = new Car();
        kiaSportage.setImage(imgSrcFolder + "kiasportage.jpg");
        kiaSportage.setModel("Kia Sportage");
        kiaSportage.setYear(2022);
        kiaSportage.setNumberOfSeats((byte) 5);
        kiaSportage.setEnginePower((short) 180);
        kiaSportage.setFuelType(GASOLINE);
        kiaSportage.setCarColor(GRAY);
        kiaSportage.setDescription("");
        kiaSportage.setPrice(110);
        carService.save(kiaSportage);


    }

}
