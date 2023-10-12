package com.example.CarRentalApp.service.implementation;

import com.example.CarRentalApp.model.Car;
import com.example.CarRentalApp.repository.CarRepository;
import com.example.CarRentalApp.service.CarService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Set<Car> findAll() {
        Set<Car> car = new HashSet<>();
        carRepository.findAll().forEach(car::add);
        return car;
    }

    @Override
    public Car findById(Long aLong) {
        return carRepository.findById(aLong).orElse(null);
    }

    @Override
    public Car save(Car object) {
        String imagePath = object.getImage().replace("\"", "");
        File inputFile = new File(imagePath);

        if (inputFile.exists()) {
            try {
                // Read the input image as bytes
                byte[] imageBytes = Files.readAllBytes(inputFile.toPath());

                // Encode the image bytes to Base64
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                object.setImage(base64Image);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.err.println("Image file does not exist: " + imagePath);
        }
        if (object.getCarRegistration().getRegistrationTable() == null ||
                object.getCarRegistration().getRegistrationExpiry() == null){
            object.getCarRegistration().setRegistrationTable("000-0-000");
            object.getCarRegistration().setRegistrationExpiry(LocalDate.EPOCH);
        }
        return carRepository.save(object);
    }

    @Override
    public void delete(Car object) {
        carRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }
}
