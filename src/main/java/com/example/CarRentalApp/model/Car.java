package com.example.CarRentalApp.model;


import com.example.CarRentalApp.model.enums.CarColor;
import com.example.CarRentalApp.model.enums.FuelType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity{

    @Column(name = "manufacturer")
    private String manufacturer;

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


    public Byte setNumberOfSeats(Byte nrOfSeats) {
        if (nrOfSeats<1) {
            this.numberOfSeats = 1;
        }
        if (nrOfSeats > 9) {
            this.numberOfSeats =9;
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
