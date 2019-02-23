package com.svelay.demo.controller;

import com.svelay.demo.pojo.Message;
import com.svelay.demo.service.DemoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class DemoController {

    private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public Mono<String> aSimpleController() {
        return Mono.just("hello les Z");
    }

    @GetMapping(value = "/infinite", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Message> getInfinite(){

        return demoService.generateInfinteFlux()
                .delayElements(Duration.ofSeconds(1));
    }

}
