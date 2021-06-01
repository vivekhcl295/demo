package com.hcl.order.service;

import com.hcl.order.entity.OrderEntity;
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
    public List<OrderEntity> findAll() {
        return orderRepo.findAll();
    }

    @Override
    @Cacheable(value = "Order", key = "#orderId")
    public OrderEntity findByOrderId(Long orderId) {
        return orderRepo.findByOrderId(orderId);
    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        return orderRepo.save(orderEntity);
    }

    @Override
    public List<OrderEntity> findAllByRestaurantId(Long restaurantId) {
        return orderRepo.findAllByRestaurantId(restaurantId);
    }
}
