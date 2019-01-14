package com.gradebook.project.dao;

import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Student> getStudents();

    List<Mark> getStudentsMarksByUsername(String username);

    void saveMark(Mark mark);

    Student getStudentById(Integer studentId);

    Teacher getTeacherById(Integer teacherId);

    void saveTeacher(Teacher teacher);
}
