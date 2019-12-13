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
    @Size(min= 4, max= 15, message= "Must enter username")
    private String user;

    @NotNull
    @Size(min=8, max= 25, message = "Password must be between 8-25 characters")
    private String password;

//    @NotNull
//    @Transient
//    private String verifyPassword;

    @OneToMany
    @JoinColumn(name = "owner_id")
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
//        checkPassword();
    }
//
//    public String getVerifyPassword() {
//        return verifyPassword;
//    }
//
//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//        checkPassword();
//    }
//
    public List<Chore> getChores() { return chores; }

//    private void checkPassword() {
//        if (password != null && verifyPassword != null
//                && !password.equals(verifyPassword)) {
//            verifyPassword = null;
//        }
//    }
}