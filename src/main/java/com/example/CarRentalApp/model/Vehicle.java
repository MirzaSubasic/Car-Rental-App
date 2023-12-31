package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Vehicle extends BaseEntity{
    @Lob
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "model")
    private String model;

    @Min(1960)
    @Max(2035)
    @NotNull
    @Column (name = "yearOfMaking")
    private Integer year;

    @Positive
    @Column(name = "enginePower")
    private Short enginePower;

    @Column(name = "color")
    private CarColor carColor;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "fuel")
    private FuelType fuelType;

    @Positive
    @Max(3000)
    @Column(name = "pricePerDay")
    private Integer price;

}