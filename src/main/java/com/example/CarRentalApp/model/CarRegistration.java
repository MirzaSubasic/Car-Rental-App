package com.example.CarRentalApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carRegistration")
@Entity
public class CarRegistration extends BaseEntity{

    @Column(name = "expiration")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationExpiry;

    @Column(name = "registrationTable")
    @Size(min= 5,max=15)
    private String registrationTable;

    @OneToOne
    private Car car;

}
