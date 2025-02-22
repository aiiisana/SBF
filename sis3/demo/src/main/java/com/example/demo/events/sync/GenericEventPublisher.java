package com.example.demo.events.sync;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class GenericEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public GenericEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishGenericEvent(String data) {
        System.out.println("Publish generic event: " + data);
        applicationEventPublisher.publishEvent(new GenericSpringEvent<>(data));
    }
}
