package com.hcl.customer.repo;

import com.hcl.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmail(String email);
    Customer findCustomerByCustomerId(Long customerId);
    @Transactional
    Customer save(Customer customer);
}
