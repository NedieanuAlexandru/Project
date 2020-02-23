package com.sda.taskmanagement.persistance.dao;

import com.sda.taskmanagement.persistance.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TaskDao {

    SessionFactory sessionFactory;

    public TaskDao() {
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
        configuration.addAnnotatedClass(Task.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public void createTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(task);
        transaction.commit();
    }

    public List<Task> afisareTask() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Task", Task.class);
        List<Task> tasks = query.getResultList();
        transaction.commit();
        return tasks;
    }

    public void updateTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(task);
        transaction.commit();
    }

    public void deleteTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(task);
        transaction.commit();
    }

    public Task findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Task task = session.find(Task.class, id);
        transaction.commit();
        return task;
    }
}
