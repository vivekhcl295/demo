package com.hcl.order.service;

import com.hcl.order.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findByOrderId(Long orderId);
    Order save(Order order);

    List<Order> findAllByRestaurantId(Long restaurantId);
}
