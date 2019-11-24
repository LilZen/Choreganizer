package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String choreName;

    @ManyToOne
    private Cleaner cleaner;

    public Chore() {}

    public Chore (String choreName){
        this.choreName = choreName;
    }

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName() { this.choreName = choreName; }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(Cleaner clean) {
        this.cleaner = cleaner;
    }
}
