package com.hcl.restaurant.controller;

import com.hcl.restaurant.dto.Order;
import com.hcl.restaurant.mongo.document.Restaurant;
import com.hcl.restaurant.service.PdfService;
import com.hcl.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;
    private PdfService pdfService;

    @Autowired
    public RestaurantController(
            RestaurantService restaurantService,
            PdfService pdfService
    ) {
        this.restaurantService = restaurantService;
        this.pdfService = pdfService;
    }

    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{restaurantId}/orders")
    public List<Order> ordersByRestaurantId(@PathVariable("restaurantId") Long restaurantId) {
        return restaurantService.findAllOrdersByRestaurantId(restaurantId);
    }

    @GetMapping(value = "/{restaurantId}/orders/{orderId}"/*, produces = MediaType.APPLICATION_PDF_VALUE*/)
    public Order invoiceByOrderId(@PathVariable("orderId") Long orderId) {
        return pdfService.invoiceByOrderId(orderId);
    }

    @GetMapping("/dummy")
    public Restaurant dummyCreate() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Fauzi Dhaba");
        restaurant.setAddress("NSP");
        return restaurantService.save(restaurant);
    }
}
