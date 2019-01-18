package com.example.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String occupation;
  private Integer money;
  
  public Person(String name, String occupation, Integer money) {
    this.name = name;
    this.occupation = occupation;
    this.money = money;
  }
  
  @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "person")
  private List<Attraction> attractionList;
  
  public Person() {
  }
}