package com.srivath.filter;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("filter method triggered..................");
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		System.out.println("========================");
		System.out.println(headers);
		System.out.println("========================");
		Set<String> keySet = headers.keySet();
		for (String key : keySet) {
			System.out.println(key + "---" + headers.get(key));
		}
		return chain.filter(exchange);
	}

}
