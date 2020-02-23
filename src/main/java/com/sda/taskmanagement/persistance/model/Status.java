package com.sda.taskmanagement.persistance.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class Status extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statusid")
    private int id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_status")
    private List<Subtask> statusList = new ArrayList<Subtask>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Subtask> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Subtask> statusList) {
        this.statusList = statusList;
    }
}
