package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String choreName;

    @NotNull
    @Future
    private Calendar dueDate;

    @ManyToOne
    private Login cleaner;

    public Chore() {}

    public Chore (String choreName, Calendar dueDate){
        this.choreName = choreName;
        this.dueDate = dueDate;
    }

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName(Chore choreName) { this.choreName = this.choreName; }

    public @NotNull Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotNull Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Login getCleaner() {
        return cleaner;
    }

    public void setCleaner(Login cleaner) {
        this.cleaner = cleaner;
    }
}
