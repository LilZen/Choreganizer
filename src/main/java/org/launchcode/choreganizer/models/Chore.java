package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String choreName;

    @NotNull
    private Calendar date;

    @ManyToOne
    private Cleaner cleaner;

    public Chore() {}

    public Chore (String choreName){
        this.choreName = choreName;
    }

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName(Chore choreName) { this.choreName = this.choreName; }

    public Calendar getDate() { return date; }

    public void setDate(Calendar date) { this.date = date; }

    public Cleaner getCleaner() { return cleaner; }

    public void setCleaner(Cleaner cleaner) { this.cleaner = cleaner; }

}
