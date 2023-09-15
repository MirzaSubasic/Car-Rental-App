package com.example.CarRentalApp.model;


import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    @Lob
    @Column(name = "image")
    private Byte[] image;

    @Column(name = "model")
    private String model;

    @Column (name = "year")
    private Integer year;

    @Column(name = "nrOfSeats")
    private Byte numberOfSeats;

    @Column(name = "enginePower")
    private Short enginePower;

    @Column(name = "fuel")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "color")
    private CarColor carColor;

    @Column(name = "description")
    private String description;

    public Integer setYear(Integer y) {
        if (y < 1950 || y > Year.now().getValue()) {
            return this.year = Year.now().getValue();
        }
        return this.year;
    }

    public Byte setNumberOfSeats(Byte nrOfSeats) {
        if (nrOfSeats<1 || nrOfSeats > 9) {
            return this.numberOfSeats = 1;
        }
        return this.numberOfSeats = nrOfSeats;
    }

    public Short setEnginePower (Short hp) {
        if (hp < 40) {
            return this.enginePower = 40;
        }
        if (hp > 3000) {
            return this.enginePower = 3000;
        }

        return this.enginePower = hp;
    }
}