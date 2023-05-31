package com.example.testconnection2db.dive.dev.primary.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class PayRates {
    @Id
    @GeneratedValue
    @Column(name = "PayRate_id")
    private Long payRateId;

    @Column(name = "Pay_Rate_Name",nullable = false)
    private String payRateName;

    @Column(name = "Value", precision = 10, scale = 0,nullable = false)
    private BigDecimal value;

    @Column(name = "Tax_Percentage", precision = 10, scale = 0,nullable = false)
    private BigDecimal taxPercentage;

    @Column(name = "Pay_Type",nullable = false)
    private int payType;

    @Column(name = "Pay_Amount", precision = 10, scale = 0,nullable = false)
    private BigDecimal payAmount;

    @Column(name = "PT_Level_C", precision = 10, scale = 0,nullable = false)
    private BigDecimal PTLevelC;
    public PayRates() {
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getPTLevelC() {
        return PTLevelC;
    }

    public void setPTLevelC(BigDecimal PTLevelC) {
        this.PTLevelC = PTLevelC;
    }

    public Long getPayRateId() {
        return payRateId;
    }

    public void setPayRateId(Long payRateId) {
        this.payRateId = payRateId;
    }

    public String getPayRateName() {
        return payRateName;
    }

    public void setPayRateName(String payRateName) {
        this.payRateName = payRateName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
