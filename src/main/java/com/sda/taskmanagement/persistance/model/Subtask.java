package com.sda.taskmanagement.persistance.model;

import javax.persistence.*;

@Entity
@Table(name = "subtask")
public class Subtask extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subtaskid")
    private int id;

    private String description;

    @Column(name = "id_task")
    private int idTask;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_status")
    private int idStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
}
