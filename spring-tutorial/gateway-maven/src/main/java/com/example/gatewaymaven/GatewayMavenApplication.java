package com.example.gatewaymaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMavenApplication.class, args);
	}

	@Bean
	RouteLocator gateway(RouteLocatorBuilder rlb) {
		return rlb
				.routes()
				.route(r -> r.path("/hello")
				 	.filters( gatewayFilterSpec ->
						 	gatewayFilterSpec.setPath("/guides")
					)
					.uri("https://spring.io/")
				)
				.route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))

				.route("twitter", r -> r
								.path("/twitter/**")
								.filters(fs -> fs.rewritePath(
										"/twitter/(?<handle>.*)",
										"/${handle}"
								))
								.uri("http://twitter.com/@")
				)
				.build();


	}

}
