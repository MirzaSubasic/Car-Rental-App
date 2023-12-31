package com.example.CarRentalApp.bootstrap;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.model.CarRegistration;
import com.example.CarRentalApp.model.Customer;
import com.example.CarRentalApp.service.CarRegistrationService;
import com.example.CarRentalApp.service.CarService;
import com.example.CarRentalApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static com.example.CarRentalApp.model.enums.CarColor.*;
import static com.example.CarRentalApp.model.enums.FuelType.*;


@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final CarService carService;
    private final CarRegistrationService carRegistrationService;
    private final CustomerService customerService;

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


        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setHomeAddress("123 Main Street");
        customer.setMail("john.doe@example.com");
        customer.setPhoneNumber("123-456-7890");
        customer.setDrivingLicenceNumber("ABC123456");
        // Create a Calendar instance and set the date of birth
        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, Calendar.OCTOBER, 5);
        // Convert the Calendar instance to a Date
        Date dateOfBirth = calendar.getTime();
        // Set the dateOfBirth in the customer object
        customer.setDateOfBirth(dateOfBirth);
        customerService.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Alice");
        customer1.setLastName("Smith");
        customer1.setHomeAddress("456 Elm Street");
        customer1.setMail("alice.smith@example.com");
        customer1.setPhoneNumber("987-654-3210");
        customer1.setDrivingLicenceNumber("XYZ789012");
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(1995, Calendar.SEPTEMBER, 15);
        Date dateOfBirth1 = calendar1.getTime();
        customer1.setDateOfBirth(dateOfBirth1);
        customerService.save(customer1);
    }
}