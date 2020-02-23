package com.sda.taskmanagement.persistance.dao;

import com.sda.taskmanagement.persistance.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.Query;
import java.util.List;
import java.util.Properties;

public class StatusDao<T extends Status > implements Dao<T> {

    SessionFactory sessionFactory;

    public StatusDao() {
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
        configuration.addAnnotatedClass(Status.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public Status findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Status status = session.find(Status.class, id);
        transaction.commit();
        return status;
    }

    @Override
    public List<T> read() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Status", Status.class);
        List<T> statuses = query.getResultList();
        transaction.commit();
        return statuses;
    }

    @Override
    public void update(T objectToBeUpdated) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(objectToBeUpdated);
        transaction.commit();
    }

    @Override
    public void remove(T ojectToBeRemoved) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(ojectToBeRemoved);
        transaction.commit();
    }

    @Override
    public void create(T objectToBeCreated) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(objectToBeCreated);
        transaction.commit();
    }
}
