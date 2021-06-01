package com.hcl.order.repo;

import com.hcl.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(Long orderId);
    List<OrderEntity> findAllByRestaurantId(Long restaurantId);
}
