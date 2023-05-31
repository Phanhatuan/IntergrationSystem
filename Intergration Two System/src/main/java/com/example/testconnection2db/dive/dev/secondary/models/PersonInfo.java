package com.example.testconnection2db.dive.dev.secondary.models;

import javax.persistence.*;

@Entity
@Table(name = "person_info")
public class PersonInfo {

    @Id
    private Long id;

    private String name;

    private Integer age;

    private String address;

    @OneToOne(mappedBy = "personInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonContact personContact;

    public PersonInfo() {
    }
// getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonContact getPersonContact() {
        return personContact;
    }

    public void setPersonContact(PersonContact personContact) {
        this.personContact = personContact;
    }
}