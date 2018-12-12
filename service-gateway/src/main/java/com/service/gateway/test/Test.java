package com.service.gateway.test;

import reactor.core.publisher.Flux;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-10 14:50
 */
public class Test {


    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(1, 3);
        integerFlux.subscribe(integer -> {});
    }
}
