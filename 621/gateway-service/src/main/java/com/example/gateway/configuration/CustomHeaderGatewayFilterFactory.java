//package com.example.gateway.configuration;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//
//@Component
//public class CustomHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomHeaderGatewayFilterFactory.Config> {
//
//    private static final String CUSTOM_HEADER_PREFIX = "X-client-header";
//    private static final String CUSTOM_HEADER_VALUE = "spring-cloud-course";
//
//    public CustomHeaderGatewayFilterFactory() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            if (hasCustomHeader(exchange)) {
//                exchange.getRequest().mutate().headers(httpHeaders -> httpHeaders.remove("X-client-header"));
//                return chain.filter(exchange);
//            } else {
//                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//                return exchange.getResponse().setComplete();
//            }
//        };
//    }
//
//    private boolean hasCustomHeader(ServerWebExchange exchange) {
//        return exchange.getRequest().getHeaders().entrySet().stream()
//                .filter(header -> header.getKey().equals(CUSTOM_HEADER_PREFIX))
//                .anyMatch(header -> header.getValue().contains(CUSTOM_HEADER_VALUE));
//    }
//
//
//    public static class Config {
//        // You can add any configuration properties here if needed
//    }
//
//}