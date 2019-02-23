package com.svelay.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @GetMapping
    public Mono<String> aSimpleController() {
        return Mono.just("hello les Z");
    }

}
