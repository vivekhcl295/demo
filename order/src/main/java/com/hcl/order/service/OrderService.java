package com.hcl.order.service;

import com.hcl.order.mongo.document.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    public List<Order> findAll();
    public Order findByOrderId(Long orderId);
    Order save(Order order);

    List<Order> findAllByRestaurantId(Long restaurantId);
}
