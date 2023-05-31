package com.example.testconnection2db.dive.dev.secondary.models;

import javax.persistence.*;

@Entity
public class EmployeeDetail {
    @Id
    private Long id;

    private String address;

    @MapsId
    @OneToOne
    private Employee employee;

    // getters and setters

    public EmployeeDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
