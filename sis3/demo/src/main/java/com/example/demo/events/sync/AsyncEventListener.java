package com.example.demo.events.sync;


import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncEventListener {
    @Async
    @EventListener
    public void handleAsyncEvent(CustomSpringEvent event) {
        System.out.println("Async event: " + event.getMessage());
    }
}