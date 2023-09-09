package com.example.Rent_Spring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Apartments {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private int numberOfRooms;

    public Apartments() {
    }

    public Apartments(String address, int numberOfRooms) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
