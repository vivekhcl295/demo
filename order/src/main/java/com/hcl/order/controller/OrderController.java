package com.hcl.order.controller;

import com.hcl.order.constant.API_CONSTANTS;
import com.hcl.order.entity.Order;
import com.hcl.order.entity.OrderItem;
import com.hcl.order.entity.Payment;
import com.hcl.order.entity.PaymentMethod;
import com.hcl.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.BindException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(API_CONSTANTS.BASE_URI)
@Validated
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> orders(
            @RequestParam(value = "byRestaurantId", required = false) @Min(1) Long restaurantId
    ) throws BindException {
        if (restaurantId != null) {
            if (restaurantId <= 0) {
                throw new BindException("Restaurant id is not valid");
            }
            return orderService.findAllByRestaurantId(restaurantId);
        }

        return orderService.findAll();
    }

    @GetMapping(path = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order orderById(@PathVariable("orderId") @Min(1) Long orderId ) {
        return orderService.findByOrderId(orderId);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping(path = "/dummy", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order dummyOrder() {
        Payment payment = new Payment();
        payment.setPaymentId(101L);
        payment.setPaymentMethod(PaymentMethod.CC);
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
