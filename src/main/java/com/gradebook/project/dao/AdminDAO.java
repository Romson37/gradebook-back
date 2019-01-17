package com.gradebook.project.dao;

import com.gradebook.project.model.Authority;
import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Teacher;
import com.gradebook.project.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDAO {
    List<User> getUsersList();

    LearningGroup getGroupById(String groupId);

    Authority findAuthorityByName(String role_teacher);

    List<LearningGroup> getGroups();

    List<Teacher> getTeachers();

    void saveGroup(LearningGroup group);
}
