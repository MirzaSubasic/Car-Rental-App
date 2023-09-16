package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Vehicle extends BaseEntity{
    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "model")
    private String model;

    @Column (name = "yearOfMaking")
    private Integer year;

    @Column(name = "enginePower")
    private Short enginePower;

    @Column(name = "color")
    private CarColor carColor;

    @Column(name = "description")
    private String description;

    @Column(name = "fuel")
    private FuelType fuelType;

    @Column(name = "pricePerDay")
    private Integer price;

    public Integer setYear(Integer y) {
        if (y < 1950 || y > Year.now().getValue()) {
            return this.year = Year.now().getValue();
        }
        return this.year;
    }

    public Short setEnginePower (Short hp) {
        if (hp > 3000) {
            return this.enginePower = 3000;
        }
        return this.enginePower = hp;
    }
}
