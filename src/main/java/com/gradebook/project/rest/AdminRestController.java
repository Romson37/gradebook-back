package com.gradebook.project.rest;

import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;
import com.gradebook.project.model.User;
import com.gradebook.project.repository.UserRepository;
import com.gradebook.project.security.UserService;
import com.gradebook.project.service.AdminService;
import com.gradebook.project.service.StudentService;
import com.gradebook.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/adminPanel")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return adminService.getUsers();
    }

    @PostMapping("/{username}/addStudent")
    public Student addStudent(
            @RequestBody Student student,
            @RequestBody LearningGroup group,
            @PathVariable String username){
        User user = userRepository.findByUsername(username);

        student.setUser(user);
        student.setGroup(group);
        studentService.saveStudent(student);
        return student;
    }
    @PostMapping("/{username}/addTeacher")
    public Teacher addTeacher(
            @RequestBody Teacher teacher,
            @RequestBody Set<LearningGroup> groups,
            @PathVariable String username){
        User user = userRepository.findByUsername(username);

        teacher.setLearningGroups(groups);
        teacher.setUser(user);
        teacherService.saveTeacher(teacher);
        return teacher;
    }

}
