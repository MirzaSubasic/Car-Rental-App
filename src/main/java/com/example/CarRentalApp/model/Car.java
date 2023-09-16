package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    @Column(name = "nrOfSeats")
    private Byte numberOfSeats;

    @Column(name = "fuel")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Builder
    public Car(byte[] image1, String s, int i, byte b, short i1, FuelType fuelType, CarColor carColor, String s1) {
    }


    public Byte setNumberOfSeats(Byte nrOfSeats) {
        if (nrOfSeats<1 || nrOfSeats > 9) {
            return this.numberOfSeats = 1;
        }
        return this.numberOfSeats = nrOfSeats;
    }

}