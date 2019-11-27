package org.launchcode.choreganizer.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCleaner {

    @NotNull
    @Size(min= 5, max= 15)
    private String username;

    @NotNull
    @Size(min=8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public CreateCleaner(String username, String password, String verifyPassword) {
        this.username = username;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public CreateCleaner(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CreateCleaner() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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