package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrdersByRestaurantId(Long restaurantId);
    Order findOrderByOrderId(Long orderId);
}
