package com.example.restservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "lastName")
  private String lastName;

  public Students() {
  }
  
  public Students(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public Students(long id, String name, String lastName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getlastName() {
    return this.lastName;
  }
}
