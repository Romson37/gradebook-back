package com.gradebook.project.rest;


import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Teacher;
import com.gradebook.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/studentPanel")
public class StudentRestController {

    @Autowired
    private StudentService studentService;



    @GetMapping("/myMarks/{username}")
    public List<Mark> getStudentMarks
            (@PathVariable String username) {
        return studentService.getMarks(username);
    }

    @GetMapping("/myTeachers/{groupId}")
    public List<Teacher> getStudentsTeachers
            (@PathVariable String groupId) {
        return studentService.getTeachersByGroup(groupId);
    }
    @GetMapping("/myGroup/{username}")
    public List<LearningGroup> getStudentsGroup
            (@PathVariable String username) {
        return studentService.getStudentsGroup(username);
    }

    //lista przedmiotow i ocen z przedmiotow
}
