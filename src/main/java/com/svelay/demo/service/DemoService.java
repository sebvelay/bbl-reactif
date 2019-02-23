package com.svelay.demo.service;

import com.svelay.demo.pojo.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DemoService {

    private static Integer i = 0;

    public Flux<Message> generateInfinteFlux() {

        return Flux.<Message>generate(sink ->
                sink.next(Message.builder()
                        .message("Hello les Z")
                        .index(i++)
                        .build()));
    }

    public Mono<String> getMessage() {
        return Mono.just("Quel est la réponse à la terre, l'univers et le reste ?");
    }

    public Mono<Integer> getId() {
        return Mono.just(42);
    }


}
