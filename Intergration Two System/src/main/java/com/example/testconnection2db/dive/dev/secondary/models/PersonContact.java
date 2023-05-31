package com.example.testconnection2db.dive.dev.secondary.models;

import javax.persistence.*;

@Entity
@Table(name = "person_contact")
public class PersonContact {

    @Id
    private Long id;

    private String phone;

    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PersonInfo personInfo;

    // getters and setters

    public PersonContact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
