package com.example.demo.Controllers;

import com.example.demo.Models.ApplicationUser;
import com.example.demo.Services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
  
 /* @GetMapping("/login")
  public ResponseEntity login() {
    return ResponseEntity.ok("Login");
  }*/
  
  @PostMapping("/logout")
  public ResponseEntity signOut(@RequestBody ApplicationUser applicationUserDTO) {
    return null;
    //ToDo
  }
  
  @GetMapping("/userdetails")
  public String showUserDetails(Model model) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = ((UserDetails) principal).getUsername();
    ApplicationUser user = applicationUserService.findByUsername(username);
    model.addAttribute("user", user);
    return "userdetails";
  }
}

  

  
 /* @GetMapping
  public User getUserAccount(ApplicationUser applicationUser, BindingResult result, Model model)
  
 @ResponseBody
  public String currentUserName(Authentication auth) {
    ((ApplicationUser) auth).getUsername();
    return "user";
    
  }*/
  
  
