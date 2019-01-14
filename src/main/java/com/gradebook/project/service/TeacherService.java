package com.gradebook.project.service;

import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Student> getStudents();

    List<Mark> getStudentsMarksByUsername(String username);

    void saveMark(Mark mark);

    Student getStudentById(Integer studentId);

    Teacher getTeacherById(Integer teacherId);
}