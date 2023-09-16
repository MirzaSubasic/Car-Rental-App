package com.example.CarRentalApp.model;

import com.example.CarRentalApp.model.enums.CarColor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
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

    @Max(30)
    @Column(name = "model")
    private String model;

    @Column (name = "yearOfMaking")
    private Integer year;

    @Column(name = "enginePower")
    private Short enginePower;

    @Column(name = "color")
    private CarColor carColor;

    @Max(350)
    @Column(name = "description")
    private String description;

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
