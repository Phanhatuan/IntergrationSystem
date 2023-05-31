package com.example.testconnection2db.dive.dev.primary.models;

import javax.persistence.*;

@Entity
public class UsersRole {
    @Id
    @GeneratedValue
    @Column(name = "User_Role_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "User_id",nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "Role_id",nullable = false)
    private Role role;

    public UsersRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
