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
    public Flux<Message> getInfinite() {

        return demoService.generateInfinteFlux()
                .map(m -> {
                    m.setMessage("Hello les super z");
                    return m;
                })
                .delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "/merge", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Message> getMerge() {
        return demoService.getMessage()
                .zipWith(demoService.getId())
                .map(t ->
                        Message.builder()
                                .message(t.getT1())
                                .index(t.getT2())
                                .build()
                );
    }

}
