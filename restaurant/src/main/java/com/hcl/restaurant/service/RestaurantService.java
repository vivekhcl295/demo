package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import com.hcl.restaurant.mongo.document.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();
    Restaurant findByRestaurantId(Long restaurantId);
    Restaurant save(Restaurant restaurant);
    List<Order> findAllOrdersByRestaurantId(Long restaurantId);
}
