package com.example.gateway.configuration;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRouteLocator {

    @Bean
    public GlobalFilter customRequestFilter() {
        return new CustomHeaderFilter();
    }


//    private final CustomHeaderFilter filter;
//
//    public CustomRouteLocator(CustomHeaderFilter filter) {
//        this.filter = filter;
//    }
//
//    @Bean
//    public RouteLocator customRouteLocatorImpl(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("book-client-route", r -> r
//                        .path("/api/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://book-client"))
//                .build();
//    }
}
