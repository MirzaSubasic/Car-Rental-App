package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    @Min(1)
    @Max(9)
    @Column(name = "nrOfSeats")
    private Byte numberOfSeats;

    @Column(name = "fuelType")
    private FuelType fuelType;

    @Column(name = "carColor")
    private CarColor carColor;

    @OneToOne(cascade = CascadeType.ALL)
    private CarRegistration carRegistration;
}