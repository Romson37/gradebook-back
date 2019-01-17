package com.gradebook.project.service;

import com.gradebook.project.dao.AdminDAO;
import com.gradebook.project.model.Authority;
import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Teacher;
import com.gradebook.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDAO adminDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return adminDAO.getUsersList();
    }

    @Override
    public LearningGroup getGroupById(String groupId) {
    return adminDAO.getGroupById(groupId);
    }

    @Override
    public Authority findAuthorityByName(String role_teacher) {
        return adminDAO.findAuthorityByName(role_teacher);
    }

    @Override
    public List<LearningGroup> getGroups() {
        return adminDAO.getGroups();
    }

    @Override
    public List<Teacher> getTeachers() {
        return adminDAO.getTeachers();
    }

    @Override
    @Transactional
    public void saveGroup(LearningGroup group) {
        adminDAO.saveGroup(group);
    }
}
