package org.launchcode.choreganizer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Login {

    @Id
    @GeneratedValue
    private int Id;

    @NotNull
    @Size(min= 5, max= 15)
    private String cleaner;

    @NotNull
    @Size(min=8, max= 25, message = "Password must be between 8 and 25 characters")
    private String password;

    @NotNull(message = "Passwords do not match")
    @Transient
    private String verifyPassword;

    public Login(String cleaner, String password) {
        this.cleaner = cleaner;
        this.password = password;
    }

    public Login() {}

    public String getCleaner() {
        return cleaner;
    }

    public void setCleaner(String cleaner) {
        this.cleaner = cleaner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null
                && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}