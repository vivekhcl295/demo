package com.hcl.driver.repo;

import com.hcl.driver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Long> {
    Driver findDriverByEmail(String email);
    Driver findDriverByDriverId(Long driverId);
    @Transactional
    Driver save(Driver driver);
}
