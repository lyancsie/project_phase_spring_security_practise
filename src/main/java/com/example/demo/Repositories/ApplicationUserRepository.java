package com.example.demo.Repositories;

import com.example.demo.Models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
  
  ApplicationUser findByUsername(String username);
  
}
