package com.hcl.order.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/cache")
public class CacheController {

    @DeleteMapping(path = "/order", produces = MediaType.TEXT_PLAIN_VALUE)
    @CacheEvict("order")
    public String clearOrderCache() {
        return "Cleared";
    }

}
