package com.example.Rent_Spring.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ApartmentRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartments apartment;

    private LocalDate rentalDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Apartments getApartment() {
        return apartment;
    }

    public void setApartment(Apartments apartment) {
        this.apartment = apartment;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public ApartmentRental(Clients client, Apartments apartment, LocalDate rentalDate) {
        this.client = client;
        this.apartment = apartment;
        this.rentalDate = rentalDate;
    }

    public ApartmentRental() {
    }
}
