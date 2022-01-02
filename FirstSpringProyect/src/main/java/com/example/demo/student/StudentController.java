package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*THIS IS API LAYER*/
/*API -> SERVICE -> DATA ACCESS*/
//http://localhost:8080/api/v1/student
@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    //Con autowired enlazamos
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


}
