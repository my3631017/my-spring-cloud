package com.service.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-04 14:54
 */
@Configuration
@Slf4j
public class config {
    @Autowired
    private MyFilter myFilter;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder serviceProvider = builder.
                routes().route("readRequestBody",
                r -> r.readBody(Object.class, requestBody -> true).and().path("/**").filters(f -> {
                    f.filter(myFilter)
                    .stripPrefix(1);
                    return f;
                }).uri("http://127.0.0.1:8088"));
        return serviceProvider.build();
    }
}
