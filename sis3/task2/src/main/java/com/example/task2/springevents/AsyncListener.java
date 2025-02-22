package com.example.task2.springevents;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class AsyncListener {

    @Async
    @EventListener
    void handleAsyncEvent(String event) {
        System.out.printf("Async event recevied for task2: %s%n", event);
    }

}