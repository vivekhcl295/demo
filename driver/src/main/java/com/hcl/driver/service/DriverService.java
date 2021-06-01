package com.hcl.driver.service;

import com.hcl.driver.entity.Driver;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriverService {
    Driver findDriverByEmail(String email);
    Driver save(Driver driver);
    List<Driver> findAll();
    Driver findDriverByDriverId(Long driverId);
}
