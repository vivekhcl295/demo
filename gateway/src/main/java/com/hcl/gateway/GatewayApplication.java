package com.hcl.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class GatewayApplication {

	@Autowired
	TokenRelayGatewayFilterFactory filterFactory;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("orders", r -> r.path("/api/orders")
						.filters(f -> f.filters(filterFactory.apply())
								.removeRequestHeader("Cookie")) // Prevents cookie being sent downstream
						.uri("http://localhost:9091/api/orders")) // Taking advantage of docker naming
				.route("restaurants", r -> r.path("/api/restaurants")
						.filters(f -> f.filters(filterFactory.apply())
								.removeRequestHeader("Cookie")) // Prevents cookie being sent downstream
						.uri("http://localhost:9090/api/restaurants")) // Taking advantage of docker naming
				.build();
	}

}
