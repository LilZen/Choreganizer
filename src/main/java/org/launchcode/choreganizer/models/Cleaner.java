package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cleaner {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String cleaner;

    @ManyToMany
    private List<Chore> chores = new ArrayList<>();

    @ManyToMany
    private List<Login> users =new ArrayList<>();

    public Cleaner() {}

    public Cleaner(String cleaner) {
        this.cleaner = cleaner;
    }

    public int getId() { return id; }

    public String getCleaner() { return cleaner; }

    public void setCleaner() { this.cleaner = cleaner; }

    public List<Chore> getChores() {
        return chores;
    }

    public List<Login> getUsers() {
        return users;
    }

    public void setUsers(List<Login> users) {
        this.users = users;
    }
}

