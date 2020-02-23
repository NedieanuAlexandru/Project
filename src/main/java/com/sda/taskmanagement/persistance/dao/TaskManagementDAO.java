package com.sda.taskmanagement.persistance.dao;

import com.sda.taskmanagement.persistance.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class TaskManagementDAO {

    SessionFactory sessionFactory;

    public TaskManagementDAO() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/taskmanagementsystem");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "alexandru99199");
        properties.put(Environment. DIALECT , "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment. SHOW_SQL , "true");
        properties.put(Environment. HBM2DDL_AUTO , "update");
        configuration.setProperties(properties);
        //Register classes
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Status.class);
        configuration.addAnnotatedClass(Task.class);
        configuration.addAnnotatedClass(Subtask.class);
        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
    }
}
