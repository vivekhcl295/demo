package com.hcl.customer.controller;

import com.hcl.customer.entity.Customer;
import com.hcl.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.Objects;

import static com.hcl.customer.constant.ApiEndpoints.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> findAllCustomers(
            @RequestParam(value = "byEmail", required = false) @Email String email
    ) {
        if (StringUtils.hasLength(email)) {
            return ResponseEntity.ok(customerService.findCustomerByEmail(email));
        }
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        return ResponseEntity.created(URI.create("/customers/" + customer.getEmail()))
                .body(customerService.save(customer));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findCustomerByCustomerId(@PathVariable("customerId") @Min(1) Long customerId) {
        return ResponseEntity.ok(customerService.findCustomerByCustomerId(customerId));
    }

}
