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
    private int Id;

    @NotNull
    private String cleaner;

    @NotNull
    private Date dueDate;

    @OneToMany
    @JoinColumn(name = "cleaner_id")
    private List<Chore> chores = new ArrayList<>();

    public Cleaner() {}

    public Cleaner(String cleaner, Date dueDate) {
        this.cleaner = cleaner;
        this.dueDate = dueDate;
    }

    public int getId() { return Id; }

    public String getCleaner() { return cleaner; }

    public void setCleanerName() { this.cleaner = cleaner; }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<Chore> getChores() {
        return chores;
    }
}
