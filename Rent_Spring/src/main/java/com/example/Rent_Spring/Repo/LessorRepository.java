package com.example.Rent_Spring.Repo;

import com.example.Rent_Spring.Models.Lessor;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface LessorRepository extends CrudRepository<Lessor, Long>  {
}
