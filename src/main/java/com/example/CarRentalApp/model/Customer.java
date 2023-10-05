package com.example.CarRentalApp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table(name = "customers")
@Data
@Builder
public class Customer extends BaseEntity{

    @NonNull
    @Column(name = "name")
    private String firstName;

    @NonNull
    @Column(name = "lastName")
    private String lastName;

    @NonNull
    @Column(name = "address")
    private String homeAddress;

    @NonNull
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NonNull
    @Column(name = "drivingLicence")
    private String drivingLicenceNumber;

    @NonNull
    @Column(name = "name")
    private Date dateOfBirth;
}
