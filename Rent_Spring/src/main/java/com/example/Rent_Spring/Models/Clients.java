package com.example.Rent_Spring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String firstname;
    private String lastname;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Clients(){}
    public Clients(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
