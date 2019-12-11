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
    private String name;

    @NotNull
    @Size(min=1, message="Date cannot be empty")
    private String date;

    @ManyToOne
    private Cleaner cleaner;

    public Chore (String name, String date){
        this.name = name;
        this.date = date;
    }

    public Chore() {}

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

    public Cleaner getCleaner() { return cleaner; }

    public void setCleaner(Cleaner cleaner) { this.cleaner = cleaner; }

}
