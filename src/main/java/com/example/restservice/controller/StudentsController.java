package com.example.restservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.restservice.data.StudentsRepository;
import com.example.restservice.entities.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class StudentsController {

  @Autowired
  StudentsRepository studentsRepository;

  @GetMapping("/students")
  public ResponseEntity<List<Students>> getStudents(@RequestParam(required = false) String title) {
    try {
      List<Students> tutorials = new ArrayList<Students>();
      studentsRepository.findAll().forEach(tutorials::add);
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Students> getStudentById(@PathVariable("id") long id) {
    Optional<Students> tutorialData = studentsRepository.findById(id);
    if (tutorialData.isPresent()) {
      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/students")
  public ResponseEntity<Students> addStudent(@RequestBody Students students) {
    try {
      System.out.println(students);
      Students _students = studentsRepository
          .save(new Students(students.getName(), students.getlastName()));
      return new ResponseEntity<>(_students, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/students/{id}")
  public ResponseEntity<Students> updateTutorial(@PathVariable("id") long id, @RequestBody Students students) {
    Optional<Students> studentData = studentsRepository.findById(id);
    if (studentData.isPresent()) {
      Students _students = studentData.get();
      _students.setName(students.getName());
      _students.setLastName(students.getlastName());
      return new ResponseEntity<>(studentsRepository.save(_students), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      studentsRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/students")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      studentsRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
