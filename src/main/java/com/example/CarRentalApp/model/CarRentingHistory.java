package com.example.CarRentalApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carRentingHistory")
public class CarRentingHistory extends BaseEntity{

    @Column(name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startingDate;

    @Column(name = "endingDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endingDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne
    private Car car;
}
