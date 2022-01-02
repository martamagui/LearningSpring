package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;

//<Clase con la que queremos que trabaje, El tipo del que es su id>
public interface StudentRepository extends JpaRepository<Student,Long> {

}
