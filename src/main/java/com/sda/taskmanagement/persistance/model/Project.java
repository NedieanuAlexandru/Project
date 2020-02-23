package com.sda.taskmanagement.persistance.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectid")
    private int id;

    @Column(name = "project_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_project")
    List<Task> projectList = new ArrayList<Task>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Task> projectList) {
        this.projectList = projectList;
    }
}
