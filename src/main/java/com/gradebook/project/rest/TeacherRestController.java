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


    @GetMapping//("/{username}")
    public List<LearningGroup> groupsList(
            @CurrentUser UserPrincipal user){

        String jp = user.getUsername();
        return teacherService.getGroupsByUsername(jp);
    }
//    @GetMapping("/{username}")
//    public List<LearningGroup> groupsList(
//            @PathVariable String username){
//
//
//        return teacherService.getGroupsByUsername(username);
//    }
    @GetMapping ("{username}/studentsMarks/")
    public List<Mark> getStudentsMarksByUsername
            (@PathVariable String username){
        return teacherService.getStudentsMarksByUsername(username);
    }

    @PostMapping (value = "/addMark/{studentId}/{teacherId}", headers = "Accept=application/json")
    public Mark addMark (@RequestBody Mark mark,
                         @PathVariable Integer studentId,
                         @PathVariable @AuthenticationPrincipal Integer teacherId){

        //should be current teacher logged in

        Teacher teacher = teacherService.getTeacherById(teacherId);
        Student student = teacherService.getStudentById(studentId);

        mark.setStudent(student);
        mark.setTeacher(teacher);
        teacherService.saveMark(mark);
        return mark;
    }
}
