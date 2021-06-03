package com.hcl.order.service;

import com.hcl.order.entity.Order;
import com.hcl.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(
            OrderRepo orderRepo
    ) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    @Cacheable(value = "Order", key = "#orderId")
    public Order findByOrderId(Long orderId) {
        return orderRepo.findByOrderId(orderId);
    }

    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> findAllByRestaurantId(Long restaurantId) {
        return orderRepo.findAllByRestaurantId(restaurantId);
    }
}
