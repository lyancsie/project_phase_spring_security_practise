package com.example.demo.Controllers;

import com.example.demo.Models.Attraction;
import com.example.demo.Services.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BudgeController {
  
  private AttractionService attractionService;
  
  @Autowired
  public BudgeController(AttractionService attractionService) {
    this.attractionService = attractionService;
  }
  
  @GetMapping("/budge")
  public Optional<Attraction> attractionJson(Long id) {
    return attractionService.findById(id);
  }
}
