package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

/*THIS IS SERVICE LAYER*/
/*API -> SERVICE -> DATA ACCESS*/
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id: " + studentId + ". Doesn't exist");
        }
        studentRepository.deleteById(studentId);

    }

    //Transactional permite no usar queries, porque esta anotación hace que la entidad entre en un estado de gestión/manipulación
    //Hace solo el update
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id: " + studentId + ". Doesn't exist"));
        if (name != null && name.length() > 0 && !student.getName().equals(name)) {
            student.setName(name);

        }
        if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }
}
