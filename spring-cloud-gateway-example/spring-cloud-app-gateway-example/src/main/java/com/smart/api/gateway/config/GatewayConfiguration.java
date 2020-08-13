package com.smart.api.gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfiguration {
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("default-router",
//                        predicates -> predicates
//                        .path("/api/**")
//                        .filters(filter -> filter.stripPrefix(1))
//                        .uri("http://127.0.0.1:8080/hello"))
//                .build();
//    }
}
