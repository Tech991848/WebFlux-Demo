package com.dilip_tech.webfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test public void testMono(){
        Mono<?> monoString=Mono.just("Dilip Tech").then(Mono.error(new RuntimeException("Exception occured")))
                .log();

        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }

    @Test
    public void testFlux(){
        Flux<String> stringFlux=Flux.just("String","String Boot","Hibernate","Microservice");
        stringFlux.subscribe(System.out::println);
    }
}
