package org.example.laby4AUI_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class SimpleRpgGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRpgGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${ast.celestial.url}") String celestial_bodyUrl,
            @Value("${ast.asttype.url}") String ast_typeUrl,
            @Value("${ast.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("ast_types", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/ast_types/{uuid}",
                                "/api/ast_types"
                        )
                        .uri(ast_typeUrl)
                )
                .route("celestial_bodies", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/celestial_bodies",
                                "/api/celestial_bodies/**",
                                "/api/ast_types/{uuid}/celestial_bodies"
                        )
                        .uri(celestial_bodyUrl)
                )
                .build();
    }
    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }


}
