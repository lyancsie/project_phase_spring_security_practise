package com.example.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ApplicationUser {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;
  
  public ApplicationUser(String username, String password) {
    this.username = username;
    this.password = password;
  }
  
  public ApplicationUser() {
  }
  
  public static UserBuilder builder() {
    return new UserBuilder();
  }
  
  public static class UserBuilder {
    
    private String someUsername;
    private String somePassword;
    
    public UserBuilder setSomeUsername(final String someUsername) {
      this.someUsername = someUsername;
      return this;
    }
    
    public UserBuilder setSomePassword(final String somePassword) {
      this.somePassword = somePassword;
      return this;
    }
    
    public ApplicationUser build() {
      return new ApplicationUser(someUsername, somePassword);
    }
    
  }
}