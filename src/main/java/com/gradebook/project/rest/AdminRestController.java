package com.gradebook.project.rest;

import com.gradebook.project.model.*;
import com.gradebook.project.repository.AuthorityRepository;
import com.gradebook.project.repository.UserRepository;
import com.gradebook.project.security.UserService;
import com.gradebook.project.service.AdminService;
import com.gradebook.project.service.StudentService;
import com.gradebook.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    private AuthorityRepository authorityRepository;
    @GetMapping
    public List<User> getUsers() {
        return adminService.getUsers();
    }

    @GetMapping("/teachersList")
    public List<Teacher> teachers(){
        return adminService.getTeachers();
    }

    @GetMapping("/{username}")
    public Student getStudent(@PathVariable String username) {
        return studentService.getStudentByUsername(username);
    }

    @PostMapping(value = "/{username}/{groupId}/addStudent",headers = "Accept=application/json")
    public Student addStudent(
            @RequestBody Student student,
            @PathVariable String username,@PathVariable String groupId){
        User user = userRepository.findByUsername(username);

        user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_STUDENT"));
        student.setUser(user);
        student.setGroup(adminService.getGroupById(groupId));
        studentService.saveStudent(student);
        return student;
    }
    @PostMapping("/{username}/addTeacher")
    public Teacher addTeacher(
            @RequestBody Teacher teacher,
            @PathVariable String username){
        User user = userRepository.findByUsername(username);

        user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_TEACHER"));
        teacher.setUser(user);
        teacherService.saveTeacher(teacher);
        return teacher;
    }

    @GetMapping("/groups")
    public List<LearningGroup> groups (){
        return adminService.getGroups();
    }

    @PutMapping("/{id}/{groupId}/addTeacherToGroup")
    public LearningGroup addTeacherToGroup(@PathVariable Integer id, @PathVariable String groupId) {

        Teacher currentTeacher =
                teacherService.getTeacherById(id);

        LearningGroup group = adminService.getGroupById(groupId);

        group.setGroupId(groupId);

        group.getTeachers().add(currentTeacher);

        adminService.saveGroup(group);

        return group;
    }
}
