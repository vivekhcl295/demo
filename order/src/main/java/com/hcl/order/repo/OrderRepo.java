package com.hcl.order.repo;

import com.hcl.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findByOrderId(Long orderId);
    List<Order> findAllByRestaurantId(Long restaurantId);
}
