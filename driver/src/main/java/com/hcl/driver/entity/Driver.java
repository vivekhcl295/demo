package com.hcl.driver.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "driver")
public class Driver extends Audit {
    private Long driverId;
    @NotNull(message = "Driver Email Id Cannot be null")
    @Email
    private String email;
    @Size(min = 10, max = 10, message = "Phone should be 10 Digit long")
    @Digits(integer = 10, fraction = 0, message = "Only digits allowed in phone")
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
