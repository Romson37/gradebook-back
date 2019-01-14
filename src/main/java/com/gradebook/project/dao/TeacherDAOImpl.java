package com.gradebook.project.dao;


import com.gradebook.project.model.Mark;
import com.gradebook.project.model.Student;
import com.gradebook.project.model.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{

    @Autowired
    private EntityManager entityManagerFactory;

    @Override
    public List<Student> getStudents() {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Student> query =
                currentSession.createQuery("from Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Mark> getStudentsMarksByUsername(String username) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);
        Query<Mark> query =
                currentSession.createQuery("select m from Mark m join m.student s join s.user u where u.username=:var",Mark.class);
        query.setParameter("var",username);
        return query.getResultList();
    }

    @Override
    public void saveMark(Mark mark) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        currentSession.save(mark);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Student> query =
                currentSession.createQuery("select s from Student s where s.studentId = :val",Student.class);
        query.setParameter("val",studentId);
        return query.getSingleResult();
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        Session currentSession =
                entityManagerFactory.unwrap(Session.class);
        Query<Teacher> query =
                currentSession.createQuery("select t from Teacher t where t.teachersId = :val",Teacher.class);
        query.setParameter("val",teacherId);
        return query.getSingleResult();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        currentSession.saveOrUpdate(teacher);
    }
}
