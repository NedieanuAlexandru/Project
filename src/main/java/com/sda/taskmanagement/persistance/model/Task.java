package com.sda.taskmanagement.persistance.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskid")
    private int id;

    private String description;

    @Column(name = "id_project")
    private int idProject;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_task")
    private List<Subtask> taskList = new ArrayList<Subtask>();

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

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public List<Subtask> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Subtask> taskList) {
        this.taskList = taskList;
    }
}
