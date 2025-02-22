package com.example.task2.springevents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class UserRemovedListener {

    @EventListener
    ReturnedEvent handleUserRemovedEvent(UserRemovedEvent event) {
        System.out.printf("User removed from task2 (@EventListerner): %s%n", event.getName());
        // Spring will send ReturnedEvent as a new event
        return new ReturnedEvent();
    }

    // Listener to receive the event returned by Spring
    @EventListener
    void handleReturnedEvent(ReturnedEvent event) {
        System.out.println("ReturnedEvent from task2 received.");
    }

    @EventListener(condition = "#event.name == 'reflectoring'")
    void handleConditionalListener(UserRemovedEvent event) {
        System.out.printf("User removed from task2 (Conditional): %s%n", event.getName());
    }
}