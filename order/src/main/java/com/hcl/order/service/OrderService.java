package com.hcl.order.service;

import com.hcl.order.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    List<OrderEntity> findAll();
    OrderEntity findByOrderId(Long orderId);
    OrderEntity save(OrderEntity orderEntity);

    List<OrderEntity> findAllByRestaurantId(Long restaurantId);
}
