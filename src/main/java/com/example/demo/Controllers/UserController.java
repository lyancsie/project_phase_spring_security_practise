package com.example.demo.Controllers;

import com.example.demo.Models.ApplicationUser;
import com.example.demo.Services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  private ApplicationUserService applicationUserService;
  
  @Autowired
  public UserController(BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserService applicationUserService) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.applicationUserService = applicationUserService;
  }
  
  @PostMapping("/sign-up")
  public ResponseEntity register(@RequestBody ApplicationUser applicationUserDTO) {
    ApplicationUser applicationUser;
    applicationUser = ApplicationUser
        .builder()
        .setSomeUsername(applicationUserDTO.getUsername())
        .setSomePassword(bCryptPasswordEncoder.encode(applicationUserDTO.getPassword()))
        .build();
    applicationUserService.save(applicationUser);
    return ResponseEntity.ok("Registration done");
  }
  
  @PostMapping("/logout")
  public ResponseEntity signOut(@RequestBody ApplicationUser applicationUserDTO) {
    return null;
    //ToDo
  }
}
