package com.example.demo.Repositories;

import com.example.demo.Models.Attraction;
import com.example.demo.Models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {
  
  @Override
  List<Attraction> findAll();
  
  @Override
  Optional<Attraction> findById(Long id);
  
  Optional<Attraction> findByPerson(Person person);
}
