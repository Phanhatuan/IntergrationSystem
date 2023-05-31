package com.example.testconnection2db.dive.dev.primary.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "User_id")
    private Long user_id;
    @Column(name = "User_name",nullable = false) // đánh cái này để không cho null
    private String user_name;

    @Column(name = "Password",nullable = false)
    private String password;

    @Column(name = "Email",nullable = false)
    @Email
    private String email;

    @Column(name = "Active",nullable = false)
    private boolean active;

    public Users() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
