package com.sda.taskmanagement.persistance.model;

import java.io.Serializable;

public abstract class Model implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
