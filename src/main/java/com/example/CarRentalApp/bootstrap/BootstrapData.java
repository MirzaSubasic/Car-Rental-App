package com.example.CarRentalApp.bootstrap;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.model.CarRegistration;
import com.example.CarRentalApp.service.CarRegistrationService;
import com.example.CarRentalApp.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.example.CarRentalApp.model.enums.CarColor.*;
import static com.example.CarRentalApp.model.enums.FuelType.*;


@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final CarService carService;

    private final CarRegistrationService carRegistrationService;

    String imgSrcFolder = "src/main/resources/static/Images/";
    String dummyText = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
            "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. " +
            "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. " +
            "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, " +
            "venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium.";
    @Override
    public void run(String... args) throws Exception {

        Car vwr = new Car();
        vwr.setImage(imgSrcFolder + "golf8r.jpg");
        vwr.setModel("Volkswagen golf 8 r");
        vwr.setYear(2021);
        vwr.setNumberOfSeats((byte) 5);
        vwr.setEnginePower((short) 315);
        vwr.setFuelType(GASOLINE);
        vwr.setCarColor(BLUE);
        vwr.setDescription(dummyText);
        vwr.setPrice(150);


        CarRegistration registration = new CarRegistration();
        // Set expiration date to one year from now
        registration.setRegistrationExpiry(LocalDate.now().plusYears(1));
        registration.setRegistrationTable("A45-I-457");
        registration.setCar(vwr);
        vwr.setCarRegistration(registration);
        carService.save(vwr);
        carRegistrationService.save(registration);



        Car citroenc3 = new Car();
        citroenc3.setImage(imgSrcFolder + "citroenc3.jpg");
        citroenc3.setModel("Citroen c3");
        citroenc3.setYear(2020);
        citroenc3.setNumberOfSeats((byte) 5);
        citroenc3.setEnginePower((short) 110);
        citroenc3.setFuelType(GASOLINE);
        citroenc3.setCarColor(WHITE);
        citroenc3.setDescription(dummyText);
        citroenc3.setPrice(80);

        CarRegistration registration1 = new CarRegistration();
        registration1.setRegistrationExpiry(LocalDate.now().plusYears(1));
        registration1.setRegistrationTable("A79-I-247");
        registration1.setCar(citroenc3);
        citroenc3.setCarRegistration(registration1);
        carService.save(citroenc3);
        carRegistrationService.save(registration1);



        Car kiaSportage = new Car();
        kiaSportage.setImage(imgSrcFolder + "kiasportage.jpg");
        kiaSportage.setModel("Kia Sportage");
        kiaSportage.setYear(2022);
        kiaSportage.setNumberOfSeats((byte) 5);
        kiaSportage.setEnginePower((short) 180);
        kiaSportage.setFuelType(GASOLINE);
        kiaSportage.setCarColor(GREEN);
        kiaSportage.setDescription(dummyText);
        kiaSportage.setPrice(110);

        CarRegistration registration2 = new CarRegistration();
        registration2.setRegistrationExpiry(LocalDate.now().plusYears(1));
        registration2.setRegistrationTable("A00-J-300");
        registration2.setCar(kiaSportage);
        kiaSportage.setCarRegistration(registration2);
        carService.save(kiaSportage);
        carRegistrationService.save(registration2);
    }
}