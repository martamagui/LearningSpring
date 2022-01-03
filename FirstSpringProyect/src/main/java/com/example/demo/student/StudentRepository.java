package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//<Clase con la que queremos que trabaje, El tipo del que es su id>
public interface StudentRepository extends JpaRepository<Student,Long> {
//    SELECT  * FROM student WHERE email =?
    @Query("SELECT s FROM Student s WHERE s.email =?1")
    Optional<Student> findStudentByEmail(String email);

}
