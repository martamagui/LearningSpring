package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*THIS IS SERVICE LAYER*/
/*API -> SERVICE -> DATA ACCESS*/
@Service
public class StudentService {
    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Maria",
                        LocalDate.of(2000, Month.APRIL, 5),
                        "maria@gmail.com",
                        21));
    }
}
