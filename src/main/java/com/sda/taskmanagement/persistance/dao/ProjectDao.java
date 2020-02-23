package com.sda.taskmanagement.persistance.dao;

import com.sda.taskmanagement.persistance.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.Query;
import java.util.List;
import java.util.Properties;

public class ProjectDao<T extends Project> implements Dao<T> {

    SessionFactory sessionFactory;

    public ProjectDao() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/taskmanagementsystem");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "alexandru99199");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(properties);
        //Register class
        configuration.addAnnotatedClass(Project.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public Project findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Project project = session.find(Project.class, id);
        transaction.commit();
        return project;
    }

    @Override
    public List<T> read() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Project", Project.class);
        List<T> projects = query.getResultList();
        transaction.commit();
        return projects;
    }

    @Override
    public void update(T objectToBeUpdated) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(objectToBeUpdated);
        transaction.commit();
    }

    @Override
    public void remove(T objectToBeRemoved) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(objectToBeRemoved);
        transaction.commit();
    }

    @Override
    public void create(T objectToBeCreated) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(objectToBeCreated);
        transaction.commit();
    }
}
