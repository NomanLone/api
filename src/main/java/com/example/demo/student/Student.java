package com.example.demo.student;

import java.time.LocalDate;

public class Student {
  private long id;
  private String name;
  private String email;
  private int age;
  private LocalDate dateOfBirth;

  public Student(long id, String name, String email, int age, LocalDate dateOfBirth) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
    this.dateOfBirth = dateOfBirth;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
