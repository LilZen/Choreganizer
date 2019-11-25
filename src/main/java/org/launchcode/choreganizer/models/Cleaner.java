package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cleaner {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String cleaner;

    @OneToMany
    @JoinColumn(name = "cleaner_id")
    private List<Chore> chores = new ArrayList<>();

    public Cleaner() {}

    public Cleaner(String cleaner) {
        this.cleaner = cleaner;
    }

    public int getCleanerId() { return id; }

    public String getCleaner() { return cleaner; }

    public void setCleanerName() { this.cleaner = cleaner; }

    public List<Chore> getChores() {
        return chores;
    }
}
