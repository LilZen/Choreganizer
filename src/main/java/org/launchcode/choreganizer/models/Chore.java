package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

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
    private Cleaner cleaner;

    public Chore() {}

    public Chore (String choreName, Date dueDate){
        this.choreName = choreName;
        this.dueDate = dueDate;
    }

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName() { this.choreName = choreName; }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(Cleaner clean) {
        this.cleaner = cleaner;
    }
}
