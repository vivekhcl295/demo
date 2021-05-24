package com.hcl.order.controller;

import com.hcl.order.API_CONSTANTS;
import com.hcl.order.mongo.document.Order;
import com.hcl.order.mongo.document.OrderItem;
import com.hcl.order.mongo.document.Payment;
import com.hcl.order.mongo.document.PaymentMethods;
import com.hcl.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(API_CONSTANTS.BASE_URI)
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> orders(
            @RequestParam(value = "byRestaurantId", required = false) Long restaurantId
    ) throws BindException {
        if (restaurantId != null) {
            if (restaurantId <= 0) {
                throw new BindException("Restaurant id is not valid");
            }
            return orderService.findAllByRestaurantId(restaurantId);
        }

        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public Order orderById(@PathVariable("orderId") Long orderId ) {
        return orderService.findByOrderId(orderId);
    }

    @GetMapping("/dummy")
    public Order dummyOrder() {
        Payment payment = new Payment();
        payment.setPaymentId(101L);
        payment.setPaymentMethod(PaymentMethods.CC);
        payment.setPaymentAmount(1000.00);

        OrderItem item = new OrderItem();
        item.setItemId(101);
        item.setItemName("Whisky");
        item.setItemPrice(1000.00);
        item.setItemQty(1);

        Order order = new Order();
        order.setOrderId(101L);
        order.setOrderItems(new HashSet<>(Arrays.asList(item)));
        order.setOrderAmount(1000.00);
        order.setPayment(payment);
        order.setRestaurantId(101L);
        return orderService.save(order);
    }
}
