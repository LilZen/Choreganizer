package org.launchcode.choreganizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cleaner {

    @Id
    @GeneratedValue
    private int cleanerId;

    @NotNull
    private String cleanerName;

    public Cleaner() {}

    public Cleaner(String cleanerName) { this.cleanerName = cleanerName; }

    public int getCleanerId() { return cleanerId; }

    public String getCleanerName() { return cleanerName; }

    public void setCleanerName() { this.cleanerName = cleanerName; }
}
