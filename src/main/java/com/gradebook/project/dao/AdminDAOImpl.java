package com.gradebook.project.dao;

import com.gradebook.project.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO{

    @Autowired
    private EntityManager entityManagerFactory;

    @Override
    public List<User> getUsersList() {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<User> query =
                currentSession.createQuery("FROM User", User.class);

        return query.getResultList();    }

    @Override
    public LearningGroup getGroupById(String groupId) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<LearningGroup> query =
                currentSession.createQuery("select g FROM LearningGroup g where g.groupId=:val", LearningGroup.class);
        query.setParameter("val",groupId);

        return query.getSingleResult();
    }

    @Override
    public Authority findAuthorityByName(String role_teacher) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<Authority> query =
                currentSession.createQuery("select a FROM Authority a where a.authority=:val", Authority.class);
        query.setParameter("val",role_teacher);

        return query.getSingleResult();
    }

    @Override
    public List<LearningGroup> getGroups() {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<LearningGroup> query =
                currentSession.createQuery("FROM LearningGroup", LearningGroup.class);

        return query.getResultList();    }

    @Override
    public List<Teacher> getTeachers() {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        Query<Teacher> query =
                currentSession.createQuery("from Teacher", Teacher.class);

        return query.getResultList();
    }

    @Override
    public void saveGroup(LearningGroup group) {
        Session currentSession = entityManagerFactory.unwrap(Session.class);

        currentSession.saveOrUpdate(group);
    }

}
