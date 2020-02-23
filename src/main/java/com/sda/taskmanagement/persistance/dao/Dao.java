package com.sda.taskmanagement.persistance.dao;

import com.sda.taskmanagement.persistance.model.Model;

import java.util.List;

public interface Dao<T extends Model> {
    List<T> read();

    void update(T objectToBeUpdated);

    void remove(T ojectToBeRemoved);

    void create(T objectToBeCreated);
}
