package com.hcl.driver.service;

import com.hcl.driver.entity.Driver;
import com.hcl.driver.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepo driverRepo;

    @Autowired
    public DriverServiceImpl(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public Driver findDriverByEmail(String email) {
        Driver driver = driverRepo.findDriverByEmail(email);
        if (Objects.isNull(driver) ) {
            throw new EntityNotFoundException("Driver with email: " + email + " does't exist");
        }
        return driver;
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    public List<Driver> findAll() {
        return driverRepo.findAll();
    }

    @Override
    public Driver findDriverByDriverId(Long driverId) {
        Driver driver = driverRepo.findDriverByDriverId(driverId);
        if (Objects.isNull(driver) ) {
            throw new EntityNotFoundException("Driver with driver id: " + driverId + " does't exist");
        }
        return driver;
    }
}
