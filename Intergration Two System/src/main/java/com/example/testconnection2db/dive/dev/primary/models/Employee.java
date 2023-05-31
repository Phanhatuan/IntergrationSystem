package com.example.testconnection2db.dive.dev.primary.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "Employee_id")
    private long employeeId;

    @OneToOne
    @JoinColumn(name = "Employee_Number",nullable = false)
    private Users users;

    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "SSN", precision = 10, scale = 0,nullable = false)
    private BigDecimal SSN;

    @Column(name = "Pay_Rate")
    private String PayRate;

    @ManyToOne
    @JoinColumn(name = "PayRates_id")
    private PayRates payRatesId;

    @Column(name = "Vacation_Days")
    private int vacationDays;

    @Column(name = "Paid_To_Date", precision = 2, scale = 0,nullable = false)
    private BigDecimal paidToDate;

    @Column(name = "Paid_Last_Date", precision = 2, scale = 0,nullable = false)
    private BigDecimal paidLastDate;

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public PayRates getPayRatesId() {
        return payRatesId;
    }

    public void setPayRatesId(PayRates payRatesId) {
        this.payRatesId = payRatesId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getSSN() {
        return SSN;
    }

    public void setSSN(BigDecimal SSN) {
        this.SSN = SSN;
    }

    public String getPayRate() {
        return PayRate;
    }

    public void setPayRate(String payRate) {
        PayRate = payRate;
    }


    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public BigDecimal getPaidToDate() {
        return paidToDate;
    }

    public void setPaidToDate(BigDecimal paidToDate) {
        this.paidToDate = paidToDate;
    }

    public BigDecimal getPaidLastDate() {
        return paidLastDate;
    }

    public void setPaidLastDate(BigDecimal paidLastDate) {
        this.paidLastDate = paidLastDate;
    }
}
