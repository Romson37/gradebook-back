package com.gradebook.project.rest;


import com.gradebook.project.customAnnotations.CurrentUser;
import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Teacher;
import com.gradebook.project.security.UserPrincipal;
import com.gradebook.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/studentPanel")
public class StudentRestController {

    @Autowired
    private StudentService studentService;



    @GetMapping("/myMarks")
    public List<Mark> getStudentMarks
            (@CurrentUser UserPrincipal user) {
        String username;
        username = user.getUsername();
        return studentService.getMarks(username);
    }

    @GetMapping ("{id}/myMarks")
    public List<Mark> getStudentsMarksByUsername
            (@PathVariable Integer id,
             @CurrentUser UserPrincipal user){
        String studentsUsername = user.getUsername();
        return studentService.getMarksByTeacherId(studentsUsername,id);
    }


    @GetMapping("/myTeachers/{groupId}")
    public List<Teacher> getStudentsTeachers
            (@PathVariable String groupId) {
        return studentService.getTeachersByGroup(groupId);
    }
    @GetMapping("/{username}/myGroup")
    public List<LearningGroup> getStudentsGroup
            (@PathVariable String username) {
        return studentService.getStudentsGroup(username);
    }

    //lista przedmiotow i ocen z przedmiotow
}
