package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import com.hcl.restaurant.mongo.document.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAll();
    Restaurant save(Restaurant restaurant);
    List<Order> findAllOrdersByRestaurantId(Long restaurantId);
    Order findOrderByOrderId(Long orderId);
}
