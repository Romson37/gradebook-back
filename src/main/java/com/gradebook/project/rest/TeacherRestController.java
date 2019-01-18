package com.gradebook.project.rest;

import com.gradebook.project.customAnnotations.CurrentUser;
import com.gradebook.project.model.*;
import com.gradebook.project.security.UserPrincipal;
import com.gradebook.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/teacherPanel")
public class TeacherRestController {

    @Autowired
    TeacherService teacherService;

    @GetMapping ("/{groupId}/studentsList")
    public List<Student> getStudentsByGroup(@PathVariable String groupId) {

        return teacherService.getStudents(groupId);
    }


    @GetMapping
    public List<LearningGroup> groupsList(
            @CurrentUser UserPrincipal user){

        String teachersUsername = user.getUsername();
        return teacherService.getGroupsByUsername(teachersUsername);
    }


    @GetMapping ("{id}/studentsMarks")
    public List<Mark> getStudentsMarksByUsername
            (@PathVariable Integer id,
            @CurrentUser UserPrincipal user){
        String teachersUsername = user.getUsername();
        return teacherService.getStudentsMarksByUsername(teachersUsername,id);
    }

    @PostMapping (value = "/{id}/addMark", headers = "Accept=application/json")
    public Mark addMark (@RequestBody Mark mark,
                         @PathVariable Integer id,
                         @CurrentUser UserPrincipal user){
        String teacherUsername = user.getUsername();
        Teacher teacher = teacherService.getTeacherByUsername(teacherUsername);

        Student student = teacherService.getStudentById(id);

        mark.setStudent(student);
        mark.setTeacher(teacher);
        teacherService.saveMark(mark);
        return mark;
    }

    @GetMapping("/marks")
    public List<Mark> marks(){
        return teacherService.getMarks();
    }
}
