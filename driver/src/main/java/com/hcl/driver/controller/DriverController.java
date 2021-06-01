package com.hcl.driver.controller;

import com.hcl.driver.entity.Driver;
import com.hcl.driver.service.DriverService;
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

import static com.hcl.driver.ApiEndpoint.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
       this.driverService = driverService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(value = "byEmail", required = false) @Email String email
    ) {
        if (StringUtils.hasLength(email)) {
            ResponseEntity.ok(driverService.findDriverByEmail(email));
        }

        return ResponseEntity.ok(driverService.findAll());
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody @Valid Driver driver) {
        return ResponseEntity.created(URI.create(BASE_URI + "/" + driver.getEmail()))
                .body(driverService.save(driver));
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<Driver> findDriverByDriverId(@PathVariable(value = "driverId",required = false) @Min(1) Long driverId) {
        return ResponseEntity.ok(driverService.findDriverByDriverId(driverId));
    }
}
