package com.hcl.customer.service;

import com.hcl.customer.entity.Customer;
import com.hcl.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer findCustomerByCustomerId(Long customerId) {
        Customer customer = customerRepo.findCustomerByCustomerId(customerId);
        if (Objects.isNull(customer)) {
            throw new EntityNotFoundException("Customer with customer id: " + customerId + " does't exist");
        }
        return customer;
    }

    @Override
    public Customer findCustomerByEmail(String email) {

        Customer customer = customerRepo.findCustomerByEmail(email);
        if (Objects.isNull(customer)) {
            throw new EntityNotFoundException("Customer with email: " + email + " does't exist");
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

}