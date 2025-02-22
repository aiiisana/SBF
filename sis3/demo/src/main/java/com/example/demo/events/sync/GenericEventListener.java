package com.example.demo.events.sync;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GenericEventListener {
    @EventListener
    public void handleGenericEvent(GenericSpringEvent<String> event) {
        System.out.println("Generic event: " + event.getData());
    }
}
