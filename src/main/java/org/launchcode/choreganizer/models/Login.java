package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Login {

    @Id
    @GeneratedValue
    private int Id;

    @NotNull
    @Size(min= 4, max= 15, message = "Username not found")
    private String user;

    @NotNull
    @Size(min=8, max= 20, message = "Password and Username do not match")
    private String password;

    @OneToMany
    @JoinColumn(name = "login_Id")
    private List<Chore> chores = new ArrayList<>();

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Login() {}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chore> getChores() { return chores; }

}