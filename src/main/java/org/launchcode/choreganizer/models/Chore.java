package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=100, message="Chore name must be between 3-100 characters")
    private String choreName;

    @NotNull
    @Size(min=1, message="Date cannot be empty")
    private String date;

    @ManyToOne
    private Cleaner cleaner;

    public Chore (String choreName, String date){
        this.choreName = choreName;
        this.date = date;
    }

    public Chore() {}

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName(String choreName) { this.choreName = this.choreName; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

    public Cleaner getCleaner() { return cleaner; }

    public void setCleaner(Cleaner cleaner) { this.cleaner = cleaner; }

}
