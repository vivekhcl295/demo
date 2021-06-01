package com.hcl.restaurant.controller;

import com.hcl.restaurant.dto.Order;
import com.hcl.restaurant.dto.StatusDto;
import com.hcl.restaurant.entity.Address;
import com.hcl.restaurant.entity.Restaurant;
import com.hcl.restaurant.entity.RestaurantType;
import com.hcl.restaurant.entity.Status;
import com.hcl.restaurant.service.PdfService;
import com.hcl.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.hcl.restaurant.constant.ApiEndpoints.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
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

    @GetMapping("/{restaurantId}")
    public Restaurant findByOrderId(@PathVariable("restaurantId") Long resturantId) {
        return restaurantService.findByRestaurantId(resturantId);
    }

    @GetMapping("/{restaurantId}/orders")
    public List<Order> ordersByRestaurantId(@PathVariable("restaurantId") Long restaurantId) {
        return restaurantService.findAllOrdersByRestaurantId(restaurantId);
    }

    @GetMapping(value = "/{restaurantId}/orders/{orderId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> invoiceByOrderId(@PathVariable("orderId") Long orderId,
                                  HttpServletRequest request,
                                  HttpServletResponse response
    ) {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice_" + orderId + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfService.invoiceByOrderId(request, response, orderId));
    }

    @PostMapping
    public Restaurant restaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @PatchMapping("/{restaurantId}")
    public int restaurant(@PathVariable Long restaurantId, @RequestBody StatusDto statusDto) {
        return restaurantService.updateRestaurant(restaurantId, statusDto.getStatus());
    }

    @GetMapping("/dummy")
    public Restaurant dummyCreate() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(101L);
        restaurant.setName("Fauzi Dhaba");
        restaurant.setRestaurantType(RestaurantType.VEG);
        restaurant.setStatus(Status.OFFLINE);
        Address address = new Address();
        address.setAddress("nsp");
        restaurant.setAddress(address);
        return restaurantService.save(restaurant);
    }
}
