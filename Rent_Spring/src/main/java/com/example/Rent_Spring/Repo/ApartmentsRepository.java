package com.example.Rent_Spring.Repo;

import com.example.Rent_Spring.Models.Apartments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentsRepository extends CrudRepository<Apartments, Long> {
}
