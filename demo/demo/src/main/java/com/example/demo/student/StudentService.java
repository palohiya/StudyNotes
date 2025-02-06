package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("EMAIL TAKEN!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
        boolean studentExisted = studentRepository.existsById(studentID);

        if(!studentExisted) {
            throw new IllegalStateException("Student ID: " + studentID + " does not exist!");
        }

        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String studentName, String studentEmail) {

        boolean studentExisted = studentRepository.existsById(studentID);

        if(!studentExisted) {
            throw new IllegalStateException("Student ID: " + studentID + " does not exist!");
        }

        Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new IllegalStateException("Student ID: " + studentID + " does not exist!")
        );

        if(studentEmail != null
                && studentEmail.length() > 0
                && !Objects.equals(student.getEmail(), studentEmail)) {

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentEmail);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("EMAIL TAKEN!");
            }

            student.setEmail(studentEmail);

        }

        if(studentName != null
                && studentName.length() > 0
                && !Objects.equals(student.getName(), studentName)) {

            student.setName(studentName);

        }

    }
}
