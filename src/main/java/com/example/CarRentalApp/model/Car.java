package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    @Column(name = "nrOfSeats")
    private Byte numberOfSeats;


    @Builder
    public Car(byte[] image, String model, Integer year, Byte numberOfSeats, Short enginePower,
               FuelType fuelType, CarColor carColor, String description, Integer price) {
        super(image, model, year, enginePower, carColor, description, fuelType, price);
        this.numberOfSeats = numberOfSeats;
    }

    public Byte setNumberOfSeats(Byte nrOfSeats) {
        if (nrOfSeats<1 || nrOfSeats > 9) {
            return this.numberOfSeats = 1;
        }
        return this.numberOfSeats = nrOfSeats;
    }

}