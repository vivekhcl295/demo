package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import com.hcl.restaurant.mongo.document.Restaurant;
import com.hcl.restaurant.mongo.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepo restaurantRepo;
    private OrderService orderService;

    @Autowired
    public RestaurantServiceImpl(
            RestaurantRepo restaurantRepo,
            OrderService orderService
    ) {
        this.restaurantRepo = restaurantRepo;
        this.orderService = orderService;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant findByRestaurantId(Long restaurantId) {
        return restaurantRepo.findByRestaurantId(restaurantId);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public List<Order> findAllOrdersByRestaurantId(Long restaurantId) {
        return orderService.findAllOrdersByRestaurantId(restaurantId);
    }
}
