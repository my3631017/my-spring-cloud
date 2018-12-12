package com.service.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-06 16:59
 */
@RestController
public class WebFluxController {
    @GetMapping("/hello")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello World");
    }
}
