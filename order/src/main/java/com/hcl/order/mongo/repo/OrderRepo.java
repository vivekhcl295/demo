package com.hcl.order.mongo.repo;

import com.hcl.order.mongo.document.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends MongoRepository<Order, ObjectId> {
    Order findByOrderId(Long orderId);
    List<Order> findAllByRestaurantId(Long restaurantId);
}
