package com.gradebook.project.rest;

import com.gradebook.project.model.User;
import com.gradebook.project.security.UserService;
import com.gradebook.project.service.AdminService;
import com.gradebook.project.service.StudentService;
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

    @GetMapping
    public List<User> getStudents() {
        return adminService.getStudents();
    }

}
