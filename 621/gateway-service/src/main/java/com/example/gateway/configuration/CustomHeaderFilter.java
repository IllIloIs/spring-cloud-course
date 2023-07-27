package com.example.gateway.configuration;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomHeaderFilter implements GlobalFilter, Ordered {

    private static final String CUSTOM_HEADER_PREFIX = "X-client-header";
    private static final String CUSTOM_HEADER_VALUE = "spring-cloud-course";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (hasCustomHeader(exchange)) {
            exchange.getRequest().mutate().headers(httpHeaders -> httpHeaders.remove(CUSTOM_HEADER_PREFIX));
            return chain.filter(exchange);
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
    }


    private boolean hasCustomHeader(ServerWebExchange exchange) {
        return exchange.getRequest().getHeaders().entrySet().stream()
                .filter(header -> header.getKey().equals(CUSTOM_HEADER_PREFIX))
                .anyMatch(header -> header.getValue().contains(CUSTOM_HEADER_VALUE));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
