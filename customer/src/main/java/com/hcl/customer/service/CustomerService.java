package com.hcl.customer.service;

import com.hcl.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findCustomerByCustomerId(Long customerId);
    Customer findCustomerByEmail(String email);
    List<Customer> findAll();
}