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

    @NotNull
    @Column(name = "model")
    private String model;

    @Min(1960)
    @Column (name = "yearOfMaking")
    private Integer year;

    @Positive
    @Column(name = "enginePower")
    private Short enginePower;

    @Column(name = "color")
    private CarColor carColor;

    @Column(name = "description")
    private String description;

    @Column(name = "fuel")
    private FuelType fuelType;

    @Positive
    @Max(3000)
    @Column(name = "pricePerDay")
    private Integer price;

    public Integer setYear(Integer y) {
        if (y > Year.now().getValue()) {
            return this.year = Year.now().getValue();
        }
        return this.year;
    }

}
