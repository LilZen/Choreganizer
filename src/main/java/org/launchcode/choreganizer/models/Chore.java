package org.launchcode.choreganizer.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Chore {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @ManyToOne
    private Cleaner cleaner;

    @ManyToOne
    private Login login;

    public Chore (String name, Date date){
        this.name = name;
        this.date = date;
    }

    public Chore() {}

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date; }

    public Cleaner getCleaner() { return cleaner; }

    public void setCleaner(Cleaner cleaner) { this.cleaner = cleaner; }

    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }

}
