package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherById(Integer teacherId) {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);

        if(optionalTeacher.isPresent()) {
            return optionalTeacher.get();
        } else {
            throw new IllegalStateException("Record Not Found!");
        }

    }

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional
    public void updateTeacher(Integer teid, Teacher passedTeacher) {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(teid);

        if(optionalTeacher.isPresent()) {
            Teacher currentTeacher = optionalTeacher.get();

            if(passedTeacher.getTeacherName() != null && passedTeacher.getTeacherName().length() > 0 && !passedTeacher.getTeacherName().equals(currentTeacher.getTeacherName())) {
                currentTeacher.setTeacherName(passedTeacher.getTeacherName());
            }

            if(passedTeacher.getSubject() != null && passedTeacher.getSubject().length() > 0 && !passedTeacher.getSubject().equals(currentTeacher.getSubject())) {
                currentTeacher.setSubject(passedTeacher.getSubject());
            }

            teacherRepository.save(currentTeacher);

        } else {
            throw new IllegalStateException("Teacher with id: " + teid + ", does not exits!");
        }

    }
}
