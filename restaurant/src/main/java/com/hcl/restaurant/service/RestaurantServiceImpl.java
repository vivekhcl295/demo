package com.hcl.restaurant.service;

import com.hcl.restaurant.dto.Order;
import com.hcl.restaurant.mongo.document.Restaurant;
import com.hcl.restaurant.mongo.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepo restaurantRepo;
    private RestTemplate restTemplate;

    @Value("${order.service.baseUri}")
    private String orderBaseUri;

    @Autowired
    public RestaurantServiceImpl(
            RestaurantRepo restaurantRepo,
            RestTemplateBuilder restTemplateBuilder
    ) {
        this.restaurantRepo = restaurantRepo;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public List<Order> findAllOrdersByRestaurantId(Long restaurantId) {
        String url = UriComponentsBuilder.fromUriString(orderBaseUri).queryParam("byRestaurantId", restaurantId).build().toUriString();
        return (List<Order>) restTemplate.getForObject(url, List.class);
    }

    @Override
    public Order findOrderByOrderId(Long orderId) {
        String url = UriComponentsBuilder.fromUriString(orderBaseUri).build().toUriString() + "/" + orderId;
        return restTemplate.getForObject(url, Order.class);
    }
}
