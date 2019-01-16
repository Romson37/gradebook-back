package com.gradebook.project.service;

import com.gradebook.project.model.Authority;
import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Teacher;
import com.gradebook.project.model.User;

import java.util.List;

public interface AdminService {
    List<User> getUsers();

    LearningGroup getGroupById(String groupId);

    Authority findAuthorityByName(String role_teacher);

    List<LearningGroup> getGroups();

    List<Teacher> getTeachers();
}
