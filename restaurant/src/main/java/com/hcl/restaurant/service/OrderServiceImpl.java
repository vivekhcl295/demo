package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private RestTemplate restTemplate;

    @Value("${order.service.baseUri}")
    private String orderBaseUri;

    public OrderServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Order> findAllOrdersByRestaurantId(Long restaurantId) {
        String url = UriComponentsBuilder.fromUriString(orderBaseUri).queryParam("byRestaurantId", restaurantId).build().toUriString();
        return (List<Order>) restTemplate.getForObject(url, List.class);
    }

    @Cacheable(value = "Order", key = "#orderId")
    public Order findOrderByOrderId(Long orderId) {
        String url = UriComponentsBuilder.fromUriString(orderBaseUri).build().toUriString() + "/" + orderId;
        return restTemplate.getForObject(url, Order.class);
    }

}
