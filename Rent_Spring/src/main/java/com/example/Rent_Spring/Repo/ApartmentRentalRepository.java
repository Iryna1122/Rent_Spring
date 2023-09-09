package com.example.Rent_Spring.Repo;

import com.example.Rent_Spring.Models.ApartmentRental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRentalRepository extends CrudRepository<ApartmentRental,Long> {
}
