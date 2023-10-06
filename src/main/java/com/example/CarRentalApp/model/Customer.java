package com.example.CarRentalApp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Email
    @Column(name = "mail")
    private String mail;

    @NonNull
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NonNull
    @Column(name = "drivingLicence")
    private String drivingLicenceNumber;

    @NonNull
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
}
