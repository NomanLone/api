package com.example.demo.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			students.add(new Student(i, "Nomi", "Noman1997@hotmail.se", 24, LocalDate.of(1997, 10, 28)));
		}
		return students;
}
}
