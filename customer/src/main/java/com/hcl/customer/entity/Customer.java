package com.hcl.customer.entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customer")
@Validated
public class Customer extends Audit {

    private Long customerId;
    @NotNull(message = "Customer Email Id Cannot be null")
    @Email
    private String email;
    @Size(min = 10, max = 10, message = "Phone should be 10 Digit long")
    @Digits(integer = 10, fraction = 0, message = "Only digits allowed in phone")
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
