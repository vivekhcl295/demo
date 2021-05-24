package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    private RestaurantService restaurantService;

    @Autowired
    public PdfService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Order invoiceByOrderId(Long orderId) {
        return restaurantService.findOrderByOrderId(orderId);
    }
}
