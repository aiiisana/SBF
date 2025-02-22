package com.example.demo.events;

import com.example.demo.events.sync.CustomSpringEventPublisher;
import com.example.demo.events.sync.GenericEventPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EventDemoRunner implements CommandLineRunner {
    private final CustomSpringEventPublisher eventPublisher;
    private final GenericEventPublisher genericEventPublisher;

    public EventDemoRunner(CustomSpringEventPublisher eventPublisher, GenericEventPublisher genericEventPublisher) {
        this.eventPublisher = eventPublisher;
        this.genericEventPublisher = genericEventPublisher;
    }

    @Override
    public void run(String... args) {
        eventPublisher.publishCustomEvent("Custom Spring Events!");
        genericEventPublisher.publishGenericEvent("It is generic event!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
