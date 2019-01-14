package com.gradebook.project.service;

import com.gradebook.project.dao.TeacherDAO;
import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherDAO teacherDAO;


    @Override
    @Transactional
    public List<Student> getStudents(String groupId) {
        return teacherDAO.getStudents(groupId);
    }

    @Override
    @Transactional
    public List<Mark> getStudentsMarksByUsername(String username) {
        return teacherDAO.getStudentsMarksByUsername(username);
    }

    @Override
    @Transactional
    public void saveMark(Mark mark) {
        teacherDAO.saveMark(mark);
    }

    @Override
    @Transactional
    public Student getStudentById(Integer studentId) {
        return teacherDAO.getStudentById(studentId);
    }

    @Override
    @Transactional
    public Teacher getTeacherById(Integer teacherId) {
        return teacherDAO.getTeacherById(teacherId);
    }

    @Override
    @Transactional

    public void saveTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }

    @Override
    @Transactional
    public List<LearningGroup> getGroupsByUsername(String username) {
        return teacherDAO.getGroupsByUsername(username);
    }
}
