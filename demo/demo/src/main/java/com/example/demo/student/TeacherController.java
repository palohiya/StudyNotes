package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "{teacherId}")
    private Teacher getTeacher(@PathVariable("teacherId") Integer teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @GetMapping("/findall")
    private List<Teacher> getTeachers() {
        return teacherService.getAllTeacher();
    }

    @PostMapping("/add/teacher")
    private void registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @PutMapping(path = "/update/teacher/{teacherId}")
    private void updateTeacher(
            @PathVariable("teacherId") Integer teacherId,
            @RequestBody Teacher teacher
    ) {
        teacherService.updateTeacher(teacherId, teacher);
    }



}
