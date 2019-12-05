package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String choreName;

    @NotNull
    private Date dueDate;

    @ManyToOne
    private Login cleaner;

    public Chore() {}

    public Chore (String choreName, Date dueDate){
        this.choreName = choreName;
        this.dueDate = dueDate;
    }

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName(Chore choreName) { this.choreName = this.choreName; }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Login getCleaner() {
        return cleaner;
    }

    public void setCleaner(Login cleaner) {
        this.cleaner = cleaner;
    }
}
