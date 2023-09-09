package com.example.Rent_Spring.Repo;

import com.example.Rent_Spring.Models.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Clients, Long> {
}
