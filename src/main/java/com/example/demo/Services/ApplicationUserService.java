package com.example.demo.Services;

import com.example.demo.Models.ApplicationUser;
import com.example.demo.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {
  
  ApplicationUserRepository applicationUserRepository;
  
  @Autowired
  public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
    this.applicationUserRepository = applicationUserRepository;
  }
  
  ApplicationUser findByUsername(String username) {
    return applicationUserRepository.findByUsername(username);
  }
  
  public void save(ApplicationUser newUser) {
    applicationUserRepository.save(newUser);
  }
  
}
