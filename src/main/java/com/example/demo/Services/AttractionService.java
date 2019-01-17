package com.example.demo.Services;

import com.example.demo.Models.Attraction;
import com.example.demo.Models.Person;
import com.example.demo.Repositories.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionService {
  
  @Autowired
  public AttractionService(AttractionRepository attractionRepository) {
    this.attractionRepository = attractionRepository;
  }
  
  private AttractionRepository attractionRepository;
  
  public List<Attraction> findAll() {
    return attractionRepository.findAll();
  }
  
  public void save(Attraction attraction) {
    attractionRepository.save(attraction);
  }
  
  public void delete(Attraction attraction) {
    attractionRepository.delete(attraction);
  }
  
  public Optional<Attraction> findById(Long id) {
    return attractionRepository.findById(id);
  }
  
  public Optional<Attraction> findByPerson(Person person) {
    return attractionRepository.findByPerson(person);
  }
  
}
