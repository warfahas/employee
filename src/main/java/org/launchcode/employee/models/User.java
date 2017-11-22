package org.launchcode.employee.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mkabd on 7/8/2017.
 */
public class User {
    @NotNull
    @Size(min =5, max = 15)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 15)
    private String password;

    @NotNull
    @Size(min = 6, max = 15)
    private String verify;




    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;


    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}

