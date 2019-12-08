package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String choreName;
//
//    @ManyToOne
//    @JoinColumn(name = "chore_id")
//    private List<Cleaner> cleaners = new ArrayList<>();

    public Chore() {}

    public Chore (String choreName){
        this.choreName = choreName;
    }

    public int getId() { return id; }

    public String getChoreName() { return choreName; }

    public void setChoreName(Chore choreName) { this.choreName = this.choreName; }
//
//    public List<Cleaner> getCleaners() { return cleaners; }
}
