package com.gradebook.project.service;



import com.gradebook.project.model.LearningGroup;
import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    void saveStudent(Student student);

    List<Teacher> getTeachersByGroup(String groupId);


    List<Mark> getMarks(String username);

    List<LearningGroup> getStudentsGroup(String username);

    Student getStudentByUsername(String username);

    List<Mark> getMarksByTeacherId(String studentsUsername, Integer id);
}
