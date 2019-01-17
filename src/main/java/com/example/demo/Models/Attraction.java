package com.example.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Attraction {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private int votes;
  private String name;
  private double latitude;
  private String city;
  private Date date;
  @ManyToOne
  private Person person;
  
  public Attraction() {
    date = new Date();
  }
  
  public Attraction(String name, Double latitude, String city) {
    this.name = name;
    this.latitude = latitude;
    this.city = city;
  }
  
}
