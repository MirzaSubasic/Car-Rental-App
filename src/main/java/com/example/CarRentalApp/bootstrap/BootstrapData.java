package com.example.CarRentalApp.bootstrap;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.CarRentalApp.model.enums.CarColor.*;
import static com.example.CarRentalApp.model.enums.FuelType.*;


@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final CarRepository carRepository;
    private final BootstrapImageLoader bootstrapImageLoader;

    @Override
    public void run(String... args) throws Exception {

        byte[] image1 = bootstrapImageLoader.loadImageAsByteArray("golf8r.jpg");
        Car vwr = new Car(image1, "Volkswagen golf 8 r",2021 ,
                (byte) 5, (short) 315, GASOLINE, RED, "");
        carRepository.save(vwr);

        byte[] image2 = bootstrapImageLoader.loadImageAsByteArray("citroenc3.jpg");
        Car citroenc3 = new Car(image2, "Citroen c3",2020 ,
                (byte) 5, (short) 110, GASOLINE, WHITE, "");
        carRepository.save(citroenc3);

        byte[] image3 = bootstrapImageLoader.loadImageAsByteArray("kiasportage.jpg");
        Car kiaSportage = new Car(image3, "Kia Sportage",2022,
                (byte) 5, (short) 180, GASOLINE, GRAY, "");
        carRepository.save(kiaSportage);

        System.out.println("Cars loaded in bootstrap: " + carRepository.count());
    }

}
